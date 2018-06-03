package ipsis.woot.tools;

import net.minecraft.item.ItemStack;

public interface IValidateTool {

    boolean isValidateTier(ItemStack itemStack);
    boolean isValidateImport(ItemStack itemStack);
    boolean isValidateExport(ItemStack itemStack);
}
