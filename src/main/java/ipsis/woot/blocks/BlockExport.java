package ipsis.woot.blocks;

import ipsis.Woot;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockExport extends Block {

    private static final String BASENAME = "export";

    public BlockExport() {

        super(Material.ROCK);
        setCreativeTab(Woot.tab);
        setUnlocalizedName(Woot.MODID + "." + BASENAME);
        setRegistryName(BASENAME);
    }

    public static String getBasename() { return BASENAME; }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this),
                0,
                new ModelResourceLocation(getRegistryName(), ".inventory"));
    }


}
