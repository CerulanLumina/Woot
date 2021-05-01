package ipsis.woot.modules.squeezer.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import ipsis.woot.Woot;
import ipsis.woot.fluilds.FluidSetup;
import ipsis.woot.modules.infuser.InfuserConfiguration;
import ipsis.woot.modules.squeezer.SqueezerConfiguration;
import ipsis.woot.modules.squeezer.SqueezerSetup;
import ipsis.woot.modules.squeezer.blocks.EnchantSqueezerContainer;
import ipsis.woot.util.WootContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidStack;

@OnlyIn(Dist.CLIENT)
public class EnchantSqueezerScreen extends WootContainerScreen<EnchantSqueezerContainer> {

    private ResourceLocation GUI = new ResourceLocation(Woot.MODID, "textures/gui/" + SqueezerSetup.ENCHANT_SQUEEZER_TAG + ".png");

    private static final int GUI_XSIZE = 180;
    private static final int GUI_YSIZE = 177;

    private static final int ENERGY_LX = 10;
    private static final int ENERGY_LY = 18;
    private static final int ENERGY_RX = 25;
    private static final int ENERGY_RY = 77;
    private static final int ENERGY_WIDTH = ENERGY_RX - ENERGY_LX + 1;
    private static final int ENERGY_HEIGHT = ENERGY_RY - ENERGY_LY + 1;

    private static final int TANK_LX = 154;
    private static final int TANK_LY = 18;
    private static final int TANK_RX = 169;
    private static final int TANK_RY = 77;
    private static final int TANK_WIDTH = TANK_RX - TANK_LX + 1;
    private static final int TANK_HEIGHT = TANK_RY - TANK_LY + 1;

    public EnchantSqueezerScreen(EnchantSqueezerContainer container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
        imageWidth = GUI_XSIZE;
        imageHeight = GUI_YSIZE;
        titleLabelY = getYSize() - 94;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);

        if (isHovering(TANK_LX, TANK_LY, TANK_WIDTH, TANK_HEIGHT, mouseX, mouseY))
            renderFluidTankTooltip(matrixStack, mouseX, mouseY,
                    menu.getOutputFluid(),
                    SqueezerConfiguration.ENCH_SQUEEZER_TANK_CAPACITY.get());
        if (isHovering(ENERGY_LX, ENERGY_LY, ENERGY_WIDTH, ENERGY_HEIGHT, mouseX, mouseY))
            renderEnergyTooltip(matrixStack, mouseX, mouseY, menu.getEnergy(),
                    SqueezerConfiguration.ENCH_SQUEEZER_MAX_ENERGY.get(), 10);
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        GlStateManager._color4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bind(GUI);
        int relX = (this.width - this.getXSize()) / 2;
        int relY = (this.height - this.getYSize()) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, getXSize(), getYSize());

        // Progress
        int progress = menu.getProgress();
        this.blit(matrixStack, this.getGuiLeft() + 116, this.getGuiTop() + 39, 180, 0,(int)(18 * (progress / 100.0F)) , 17);

        renderEnergyBar(
                matrixStack,
                ENERGY_LX,
                ENERGY_RY,
                ENERGY_HEIGHT,
                ENERGY_WIDTH,
                menu.getEnergy(),
                SqueezerConfiguration.ENCH_SQUEEZER_MAX_ENERGY.get());

        renderFluidTank(
                matrixStack,
                TANK_LX,
                TANK_RY,
                TANK_HEIGHT,
                TANK_WIDTH,
                SqueezerConfiguration.ENCH_SQUEEZER_TANK_CAPACITY.get(),
                menu.getOutputFluid());
    }
}
