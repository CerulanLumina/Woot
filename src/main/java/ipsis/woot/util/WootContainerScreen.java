package ipsis.woot.util;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.GlStateManager;
import ipsis.woot.Woot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class WootContainerScreen<T extends Container> extends ContainerScreen<T> {

    public WootContainerScreen(T container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
    }

    public void renderEnergyBar(int x1, int y1, int x2, int y2, int curr, int max) {
        int filled = curr * 100 / max;
        filled = MathHelper.clamp(filled, 0, 100);
        int h = filled * (y2 - y1) / 100;
        fill(guiLeft + x1, guiTop + y2 - h, guiLeft + x2, guiTop + y2, 0xffff0000);
    }

    public void renderFluidTank(int x1, int y1, int x2, int y2, int curr, int max, FluidStack fluidStack)  {
        int filled = curr * 100 / max;
        filled = MathHelper.clamp(filled, 0, 100);
        int h = filled * (y2 - y1) / 100;
        drawFluid(guiLeft + x1, guiTop + y2 - h , fluidStack, x2 - x1, h);
    }

    public void renderHorizontalBar(int x1, int y1, int x2, int y2, int curr, int max, int color) {
        int filled = curr * max / 100;
        filled = MathHelper.clamp(filled, 0, 100);
        int l = filled * (x2 - x1) / 100;
        fill(guiLeft + x1, guiTop + y2,
                guiLeft + x2 + l, guiTop + y2, color);
    }

    public void renderHorizontalGauge(int x1, int y1, int x2, int y2, int curr, int max, int color) {
        fill(guiLeft + x1, guiTop + y1, guiLeft + x2, guiTop + y2, color);
        int p = curr * (x2 - x1) / max;
        for (int i = 0; i < p; i++)
            vLine(guiLeft + x1 + 1 + i,
                    guiTop + y1,
                    guiTop + y2 - 1,
                    i % 2 == 0 ? color : 0xff000000);
    }

    public void renderFluidTankTooltip(int mouseX, int mouseY, FluidStack fluidStack, int capacity) {
        List<String> tooltip = new ArrayList<>();
        if (!fluidStack.isEmpty()) {
            tooltip.add(fluidStack.getDisplayName().getFormattedText());
            tooltip.add(String.format("%d/%d mb", fluidStack.getAmount(), capacity));
        } else {
            tooltip.add(String.format("0/%d mb", capacity));
        }
        renderTooltip(tooltip, mouseX, mouseY);
    }

    public void renderEnergyTooltip(int mouseX, int mouseY, int curr, int capacity, int rate) {
        List<String> tooltip = Arrays.asList(
                String.format("%d/%d RF", curr, capacity),
                String.format("%d RF/tick", rate));
        renderTooltip(tooltip, mouseX, mouseY);
    }

    public void drawFluid(int x, int y, FluidStack fluid, int width, int height) {

        if (fluid == null)
            return;

        Minecraft.getInstance().getTextureManager().bindTexture(AtlasTexture.LOCATION_BLOCKS_TEXTURE);
        int color = fluid.getFluid().getAttributes().getColor(fluid);
        setGLColorFromInt(color);
        ResourceLocation resourceLocation = fluid.getFluid().getAttributes().getStillTexture();
        TextureAtlasSprite textureAtlasSprite = Minecraft.getInstance().getAtlasSpriteGetter(AtlasTexture.LOCATION_BLOCKS_TEXTURE).apply(resourceLocation);
        drawTiledTexture(x, y, textureAtlasSprite, width, height);
    }

    private void setGLColorFromInt(int color) {
        float red = (float)(color >> 16 & 255) / 255.0F;
        float green = (float)(color >> 8 & 255) / 255.0F;
        float blue = (float)(color & 255) / 255.0F;
        float alpha = (float)(color >> 24 & 255) / 255.0F;
        GlStateManager.color4f(red, green, blue, alpha);
    }

    private void drawTiledTexture(int x, int y, TextureAtlasSprite icon, int width, int height) {
        int i;
        int j;
        int drawHeight;
        int drawWidth;

        for (i = 0; i < width; i += 16) {
            for (j = 0; j < height; j += 16) {
                drawWidth = Math.min(width - i, 16);
                drawHeight = Math.min(height - j, 16);
                drawScaledTexturedModelRectFromIcon(x + i, y + j, icon, drawWidth, drawHeight);
            }
        }
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void drawScaledTexturedModelRectFromIcon(int x, int y, TextureAtlasSprite icon, int width, int height) {

        if (icon == null) {
            return;
        }
        float minU = icon.getMinU();
        float maxU = icon.getMaxU();
        float minV = icon.getMinV();
        float maxV = icon.getMaxV();

        BufferBuilder buffer = Tessellator.getInstance().getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        buffer.pos(x, y + height, this.itemRenderer.zLevel).tex(minU, minV + (maxV - minV) * height / 16F).endVertex();
        buffer.pos(x + width, y + height, this.itemRenderer.zLevel).tex(minU + (maxU - minU) * width / 16F, minV + (maxV - minV) * height / 16F).endVertex();
        buffer.pos(x + width, y, this.itemRenderer.zLevel).tex(minU + (maxU - minU) * width / 16F, minV).endVertex();
        buffer.pos(x, y, this.itemRenderer.zLevel).tex(minU, minV).endVertex();
        Tessellator.getInstance().draw();
    }
}
