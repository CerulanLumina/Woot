package ipsis.woot.modules.factory.items;

import ipsis.woot.Woot;
import ipsis.woot.modules.factory.*;
import ipsis.woot.util.helper.StringHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PerkItem extends Item {

    public static final String EFFICIENCY_1_REGNAME = "efficiency_1";
    public static final String EFFICIENCY_2_REGNAME = "efficiency_2";
    public static final String EFFICIENCY_3_REGNAME = "efficiency_3";
    public static final String LOOTING_1_REGNAME = "looting_1";
    public static final String LOOTING_2_REGNAME = "looting_2";
    public static final String LOOTING_3_REGNAME = "looting_3";
    public static final String MASS_1_REGNAME = "mass_1";
    public static final String MASS_2_REGNAME = "mass_2";
    public static final String MASS_3_REGNAME = "mass_3";
    public static final String RATE_1_REGNAME = "rate_1";
    public static final String RATE_2_REGNAME = "rate_2";
    public static final String RATE_3_REGNAME = "rate_3";
    public static final String XP_1_REGNAME = "xp_1";
    public static final String XP_2_REGNAME = "xp_2";
    public static final String XP_3_REGNAME = "xp_3";
    public static final String TIER_SHARD_1_REGNAME = "tier_shard_1";
    public static final String TIER_SHARD_2_REGNAME = "tier_shard_2";
    public static final String TIER_SHARD_3_REGNAME = "tier_shard_3";
    public static final String HEADLESS_1_REGNAME = "headless_1";
    public static final String HEADLESS_2_REGNAME = "headless_2";
    public static final String HEADLESS_3_REGNAME = "headless_3";

    final Perk perk;

    public PerkItem(Perk perk) {
        super(new Item.Properties().group(Woot.setup.getCreativeTab()));
        this.perk = perk;
    }

    public Perk getFactoryUpgrade() { return this.perk; }

    public static ItemStack getItemStack(Perk perk) {

        if (perk == Perk.EFFICIENCY_1)
            return new ItemStack(FactorySetup.EFFICIENCY_1_ITEM.get());
        else if (perk == Perk.EFFICIENCY_2)
            return new ItemStack(FactorySetup.EFFICIENCY_2_ITEM.get());
        else if (perk == Perk.EFFICIENCY_3)
            return new ItemStack(FactorySetup.EFFICIENCY_3_ITEM.get());
        else if (perk == Perk.LOOTING_1)
            return new ItemStack(FactorySetup.LOOTING_1_ITEM.get());
        else if (perk == Perk.LOOTING_2)
            return new ItemStack(FactorySetup.LOOTING_2_ITEM.get());
        else if (perk == Perk.LOOTING_3)
            return new ItemStack(FactorySetup.LOOTING_3_ITEM.get());
        else if (perk == Perk.MASS_1)
            return new ItemStack(FactorySetup.MASS_1_ITEM.get());
        else if (perk == Perk.MASS_2)
            return new ItemStack(FactorySetup.MASS_2_ITEM.get());
        else if (perk == Perk.MASS_3)
            return new ItemStack(FactorySetup.MASS_3_ITEM.get());
        else if (perk == Perk.RATE_1)
            return new ItemStack(FactorySetup.RATE_1_ITEM.get());
        else if (perk == Perk.RATE_2)
            return new ItemStack(FactorySetup.RATE_2_ITEM.get());
        else if (perk == Perk.RATE_3)
            return new ItemStack(FactorySetup.RATE_3_ITEM.get());
        else if (perk == Perk.TIER_SHARD_1)
            return new ItemStack(FactorySetup.TIER_SHARD_1_ITEM.get());
        else if (perk == Perk.TIER_SHARD_2)
            return new ItemStack(FactorySetup.TIER_SHARD_2_ITEM.get());
        else if (perk == Perk.TIER_SHARD_3)
            return new ItemStack(FactorySetup.TIER_SHARD_3_ITEM.get());
        else if (perk == Perk.XP_1)
            return new ItemStack(FactorySetup.XP_1_ITEM.get());
        else if (perk == Perk.XP_2)
            return new ItemStack(FactorySetup.XP_2_ITEM.get());
        else if (perk == Perk.XP_3)
            return new ItemStack(FactorySetup.XP_3_ITEM.get());
        else if (perk == Perk.HEADLESS_1)
            return new ItemStack(FactorySetup.HEADLESS_1_ITEM.get());
        else if (perk == Perk.HEADLESS_2)
            return new ItemStack(FactorySetup.HEADLESS_2_ITEM.get());
        else if (perk == Perk.HEADLESS_3)
            return new ItemStack(FactorySetup.HEADLESS_3_ITEM.get());

        return ItemStack.EMPTY;
    }

    public static ItemStack getItemStack(PerkType type, int level) {

        if (level < 1 || level > 3)
            return ItemStack.EMPTY;

        Perk perk = Perk.getPerks(type, level);
        return getItemStack(perk);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);

        tooltip.add(perk.getTooltip());
        tooltip.addAll(perk.getTooltipForLevel());
        if (Perk.TIER_SHARD_PERKS.contains(perk)) {
            {
                // tier 2 factory
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.1",
                        StringHelper.translate(Tier.TIER_1.getTranslationKey()).getUnformattedComponentText(),
                        FactoryConfiguration.T1_FARM_DROP_CHANCE.get()));
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.2",
                        FactoryConfiguration.T1_FARM_DROP_SHARD_WEIGHTS.get().get(0),
                        FactoryConfiguration.T1_FARM_DROP_SHARD_WEIGHTS.get().get(1),
                        FactoryConfiguration.T1_FARM_DROP_SHARD_WEIGHTS.get().get(2)));
            }
            {
                // tier 2 factory
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.1",
                        StringHelper.translate(Tier.TIER_2.getTranslationKey()).getUnformattedComponentText(),
                        FactoryConfiguration.T2_FARM_DROP_CHANCE.get()));
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.2",
                        FactoryConfiguration.T2_FARM_DROP_SHARD_WEIGHTS.get().get(0),
                        FactoryConfiguration.T2_FARM_DROP_SHARD_WEIGHTS.get().get(1),
                        FactoryConfiguration.T2_FARM_DROP_SHARD_WEIGHTS.get().get(2)));
            }
            {
                // tier 3 factory
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.1",
                        StringHelper.translate(Tier.TIER_3.getTranslationKey()).getUnformattedComponentText(),
                        FactoryConfiguration.T3_FARM_DROP_CHANCE.get()));
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.2",
                        FactoryConfiguration.T3_FARM_DROP_SHARD_WEIGHTS.get().get(0),
                        FactoryConfiguration.T3_FARM_DROP_SHARD_WEIGHTS.get().get(1),
                        FactoryConfiguration.T3_FARM_DROP_SHARD_WEIGHTS.get().get(2)));
            }
            {
                // tier 4 factory
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.1",
                        StringHelper.translate(Tier.TIER_4.getTranslationKey()).getUnformattedComponentText(),
                        FactoryConfiguration.T4_FARM_DROP_CHANCE.get()));
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.2",
                        FactoryConfiguration.T4_FARM_DROP_SHARD_WEIGHTS.get().get(0),
                        FactoryConfiguration.T4_FARM_DROP_SHARD_WEIGHTS.get().get(1),
                        FactoryConfiguration.T4_FARM_DROP_SHARD_WEIGHTS.get().get(2)));
            }
            {
                // tier 5 factory
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.1",
                        StringHelper.translate(Tier.TIER_5.getTranslationKey()).getUnformattedComponentText(),
                        FactoryConfiguration.T5_FARM_DROP_CHANCE.get()));
                tooltip.add(StringHelper.translate("info.woot.perk.tier_shard.2",
                        FactoryConfiguration.T5_FARM_DROP_SHARD_WEIGHTS.get().get(0),
                        FactoryConfiguration.T5_FARM_DROP_SHARD_WEIGHTS.get().get(1),
                        FactoryConfiguration.T5_FARM_DROP_SHARD_WEIGHTS.get().get(2)));
            }
        }
    }
}
