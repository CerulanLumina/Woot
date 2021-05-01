package ipsis.woot.modules.fluidconvertor.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import ipsis.woot.Woot;
import ipsis.woot.modules.fluidconvertor.FluidConvertorConfiguration;
import ipsis.woot.modules.fluidconvertor.blocks.FluidConvertorContainer;
import ipsis.woot.modules.infuser.InfuserConfiguration;
import ipsis.woot.util.WootContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class FluidConvertorScreen extends WootContainerScreen<FluidConvertorContainer> {

    private ResourceLocation GUI = new ResourceLocation(Woot.MODID, "textures/gui/fluidconvertor.png");

    private static final int GUI_XSIZE = 180;
    private static final int GUI_YSIZE = 177;
    private static final int ENERGY_LX = 10;
    private static final int ENERGY_LY = 18;
    private static final int ENERGY_RX = 25;
    private static final int ENERGY_RY = 77;
    private static final int ENERGY_WIDTH = ENERGY_RX - ENERGY_LX + 1;
    private static final int ENERGY_HEIGHT = ENERGY_RY - ENERGY_LY + 1;

    private static final int IN_TANK_LX = 46;
    private static final int IN_TANK_LY = 18;
    private static final int IN_TANK_RX = 61;
    private static final int IN_TANK_RY = 77;
    private static final int IN_TANK_WIDTH = IN_TANK_RX - IN_TANK_LX + 1;
    private static final int IN_TANK_HEIGHT = IN_TANK_RY - IN_TANK_LY + 1;

    private static final int OUT_TANK_LX = 154;
    private static final int OUT_TANK_LY = 18;
    private static final int OUT_TANK_RX = 169;
    private static final int OUT_TANK_RY = 77;
    private static final int OUT_TANK_WIDTH = OUT_TANK_RX - OUT_TANK_LX + 1;
    private static final int OUT_TANK_HEIGHT = OUT_TANK_RY - OUT_TANK_LY + 1;

    public FluidConvertorScreen(FluidConvertorContainer container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
        imageWidth = GUI_XSIZE;
        imageHeight = GUI_YSIZE;
        inventoryLabelY = getYSize() - 94;
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);

        if (isHovering(IN_TANK_LX, IN_TANK_LY, IN_TANK_WIDTH, IN_TANK_HEIGHT, mouseX, mouseY))
            renderFluidTankTooltip(matrixStack, mouseX, mouseY, menu.getInputFluid(),
                    FluidConvertorConfiguration.FLUID_CONV_INPUT_TANK_CAPACITY.get());
        if (isHovering(OUT_TANK_LX, OUT_TANK_LY, OUT_TANK_WIDTH, OUT_TANK_HEIGHT, mouseX, mouseY))
            renderFluidTankTooltip(matrixStack, mouseX, mouseY, menu.getOutputFluid(),
                    FluidConvertorConfiguration.FLUID_CONV_OUTPUT_TANK_CAPACITY.get());
        if (isHovering(ENERGY_LX, ENERGY_LY, ENERGY_WIDTH, ENERGY_HEIGHT, mouseX, mouseY))
            renderEnergyTooltip(matrixStack, mouseX, mouseY, menu.getEnergy(),
                    InfuserConfiguration.INFUSER_MAX_ENERGY.get(), InfuserConfiguration.INFUSER_ENERGY_PER_TICK.get());
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        GlStateManager._color4f(1.0F, 1.0F, 1.0F, 1.0F);
        getMinecraft().getTextureManager().bind(GUI);
        int relX = (this.width - this.getXSize()) / 2;
        int relY = (this.height - this.getYSize()) / 2;
        this.blit(matrixStack, relX, relY, 0, 0, this.getXSize(), this.getYSize());

        // Progress
        int progress = menu.getProgress();
        this.blit(matrixStack, this.getGuiLeft() + 73, this.getGuiTop() + 39, 180, 0,(int)(72 * (progress / 100.0F)) , 28);

        renderEnergyBar(
                matrixStack,
                ENERGY_LX,
                ENERGY_RY,
                ENERGY_HEIGHT,
                ENERGY_WIDTH,
                menu.getEnergy(), InfuserConfiguration.INFUSER_MAX_ENERGY.get());

        renderFluidTank(
                matrixStack,
                IN_TANK_LX,
                IN_TANK_RY,
                IN_TANK_HEIGHT,
                IN_TANK_WIDTH,
                FluidConvertorConfiguration.FLUID_CONV_INPUT_TANK_CAPACITY.get(),
                menu.getInputFluid());

        renderFluidTank(
                matrixStack,
                OUT_TANK_LX,
                OUT_TANK_RY,
                OUT_TANK_HEIGHT,
                OUT_TANK_WIDTH,
                FluidConvertorConfiguration.FLUID_CONV_OUTPUT_TANK_CAPACITY.get(),
                menu.getOutputFluid());
    }
}
