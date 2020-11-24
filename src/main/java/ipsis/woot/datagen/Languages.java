package ipsis.woot.datagen;

import ipsis.woot.Woot;
import ipsis.woot.modules.anvil.AnvilSetup;
import ipsis.woot.modules.debug.DebugSetup;
import ipsis.woot.modules.factory.FactorySetup;
import ipsis.woot.modules.fluidconvertor.FluidConvertorSetup;
import ipsis.woot.modules.generic.GenericSetup;
import ipsis.woot.modules.infuser.InfuserSetup;
import ipsis.woot.modules.layout.LayoutSetup;
import ipsis.woot.modules.oracle.OracleSetup;
import ipsis.woot.modules.squeezer.SqueezerSetup;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class Languages extends LanguageProvider {

    public Languages(DataGenerator gen, String locale) {
        super(gen, Woot.MODID, locale);
    }

    @Override
    protected void addTranslations() {

        add("itemGroup.woot", "Woot");

        // Anvil
        add(AnvilSetup.ANVIL_BLOCK.get(), "Stygian Anvil");
        add(AnvilSetup.HAMMER_ITEM.get(), "YA Hammer");
        add(AnvilSetup.PLATE_DIE_ITEM.get(), "Plate Die");
        add(AnvilSetup.SHARD_DIE_ITEM.get(), "Shard Die");
        add(AnvilSetup.DYE_DIE_ITEM.get(), "Dye Casing Die");

        // Debug
        add(DebugSetup.CREATIVE_POWER_BLOCK.get(), "Creative Power (Dev)");
        add(DebugSetup.CREATIVE_CONATUS_BLOCK.get(), "Creative Conatus (Dev)");
        add(DebugSetup.DEBUG_ITEM.get(), "Debug Tool (Dev)");

        // Factory
        add(FactorySetup.HEART_BLOCK.get(), "Heart");
        add(FactorySetup.CONTROLLER_BLOCK.get(), "Mob Controller");
        add(FactorySetup.FACTORY_A_BLOCK.get(), "Amaranth Block");
        add(FactorySetup.FACTORY_B_BLOCK.get(), "Amber Block");
        add(FactorySetup.FACTORY_C_BLOCK.get(), "Celadon Block");
        add(FactorySetup.FACTORY_D_BLOCK.get(), "Cerulean Block");
        add(FactorySetup.FACTORY_E_BLOCK.get(), "Byzantium Block");
        add(FactorySetup.CAP_A_BLOCK.get(), "Theoricus Cap");
        add(FactorySetup.CAP_B_BLOCK.get(), "Practicus Cap");
        add(FactorySetup.CAP_C_BLOCK.get(), "Exemptus Cap");
        add(FactorySetup.CAP_D_BLOCK.get(), "Magister Cap");
        add(FactorySetup.FACTORY_CONNECT_BLOCK.get(), "Factory Connector");
        add(FactorySetup.FACTORY_CTR_BASE_PRI_BLOCK.get(), "Primary Base");
        add(FactorySetup.FACTORY_CTR_BASE_SEC_BLOCK.get(), "Secondary Base");
        add(FactorySetup.IMPORT_BLOCK.get(), "Ingredient Importer");
        add(FactorySetup.EXPORT_BLOCK.get(), "Loot Exporter");
        add(FactorySetup.FACTORY_UPGRADE_BLOCK.get(), "Perk Slot");
        add(FactorySetup.CELL_1_BLOCK.get(), "Basic Conatus Cell");
        add(FactorySetup.CELL_2_BLOCK.get(), "Advanced Conatus Cell");
        add(FactorySetup.CELL_3_BLOCK.get(), "Premium Conatus Cell");
        add(FactorySetup.CELL_4_BLOCK.get(), "Ultimate Conatus Cell");
        add(FactorySetup.EFFICIENCY_1_ITEM.get(), "Stoke The Boiler I Perk");
        add(FactorySetup.EFFICIENCY_2_ITEM.get(), "Stoke The Boiler II Perk");
        add(FactorySetup.EFFICIENCY_3_ITEM.get(), "Stoke The Boiler III Perk");
        add(FactorySetup.LOOTING_1_ITEM.get(), "Treasure Island I Perk");
        add(FactorySetup.LOOTING_2_ITEM.get(), "Treasure Island II Perk");
        add(FactorySetup.LOOTING_3_ITEM.get(), "Treasure Island III Perk");
        add(FactorySetup.MASS_1_ITEM.get(), "Rampage I Perk");
        add(FactorySetup.MASS_2_ITEM.get(), "Rampage II Perk");
        add(FactorySetup.MASS_3_ITEM.get(), "Rampage III Perk");
        add(FactorySetup.RATE_1_ITEM.get(), "Feeding Frenzy I Perk");
        add(FactorySetup.RATE_2_ITEM.get(), "Feeding Frenzy II Perk");
        add(FactorySetup.RATE_3_ITEM.get(), "Feeding Frenzy III Perk");
        add(FactorySetup.TIER_SHARD_1_ITEM.get(), "Scale The Summit I Perk");
        add(FactorySetup.TIER_SHARD_2_ITEM.get(), "Scale The Summit II Perk");
        add(FactorySetup.TIER_SHARD_3_ITEM.get(), "Scale The Summit III Perk");
        add(FactorySetup.XP_1_ITEM.get(), "Wisdom I Perk");
        add(FactorySetup.XP_2_ITEM.get(), "Wisdom II Perk");
        add(FactorySetup.XP_3_ITEM.get(), "Wisdom III Perk");
        add(FactorySetup.HEADLESS_1_ITEM.get(), "Head Start I Perk");
        add(FactorySetup.HEADLESS_2_ITEM.get(), "Head Start II Perk");
        add(FactorySetup.HEADLESS_3_ITEM.get(), "Head Start III Perk");
        add(FactorySetup.MOB_SHARD_ITEM.get(), "Mob Shard");
        add(FactorySetup.XP_SHARD_ITEM.get(), "Experience Shard");
        add(FactorySetup.XP_SPLINTER_ITEM.get(), "Experience Splinter");
        add(FactorySetup.EXOTIC_A_BLOCK.get(), "Enochian Key - LIL");
        add(FactorySetup.EXOTIC_B_BLOCK.get(), "Enochian Key - ARN");
        add(FactorySetup.EXOTIC_C_BLOCK.get(), "Enochian Key - ZOM");
        add(FactorySetup.EXOTIC_D_BLOCK.get(), "Enochian Key - PAZ");
        add(FactorySetup.EXOTIC_E_BLOCK.get(), "Enochian Key - LAT");

        // Fluid Convertor
        add(FluidConvertorSetup.FLUID_CONVERTOR_BLOCK.get(), "Fluid Vat");

        // Generic
        add(GenericSetup.SI_INGOT_ITEM.get(), "Stygian Iron Ingot");
        add(GenericSetup.SI_DUST_ITEM.get(), "Stygian Iron Dust");
        add(GenericSetup.SI_PLATE_ITEM.get(), "Stygian Iron Plate");
        add(GenericSetup.PRISM_ITEM.get(), "Prism");
        add(GenericSetup.ENCH_PLATE_1.get(), "Neophyte Plate");
        add(GenericSetup.ENCH_PLATE_2.get(), "Adeptus Plate");
        add(GenericSetup.ENCH_PLATE_3.get(), "Magus Plate");
        add(GenericSetup.T1_SHARD_ITEM.get(), "Celadon Essence");
        add(GenericSetup.T2_SHARD_ITEM.get(), "Cerulean Essence");
        add(GenericSetup.T3_SHARD_ITEM.get(), "Byzantium Essence");
        add(GenericSetup.MACHINE_CASING_ITEM.get(), "Machine Casing");

        // Infuser
        add(InfuserSetup.INFUSER_BLOCK.get(), "Injection Press");
        add(InfuserSetup.WHITE_DYE_CASING_ITEM.get(), "White Dye Casing");
        add(InfuserSetup.WHITE_DYE_PLATE_ITEM.get(), "White Dye Plate");
        add(InfuserSetup.ORANGE_DYE_CASING_ITEM.get(), "Orange Dye Casing");
        add(InfuserSetup.ORANGE_DYE_PLATE_ITEM.get(), "Orange Dye Plate");
        add(InfuserSetup.MAGENTA_DYE_CASING_ITEM.get(), "Magenta Dye Casing");
        add(InfuserSetup.MAGENTA_DYE_PLATE_ITEM.get(), "Magenta Dye Plate");
        add(InfuserSetup.LIGHT_BLUE_DYE_CASING_ITEM.get(), "Light Blue Dye Casing");
        add(InfuserSetup.LIGHT_BLUE_DYE_PLATE_ITEM.get(), "Light Blue Dye Plate");
        add(InfuserSetup.YELLOW_DYE_CASING_ITEM.get(), "Yellow Dye Casing");
        add(InfuserSetup.YELLOW_DYE_PLATE_ITEM.get(), "Yellow Dye Plate");
        add(InfuserSetup.LIME_DYE_CASING_ITEM.get(), "Lime Dye Casing");
        add(InfuserSetup.LIME_DYE_PLATE_ITEM.get(), "Lime Dye Plate");
        add(InfuserSetup.PINK_DYE_CASING_ITEM.get(), "Pink Dye Casing");
        add(InfuserSetup.PINK_DYE_PLATE_ITEM.get(), "Pink Dye Plate");
        add(InfuserSetup.GRAY_DYE_CASING_ITEM.get(), "Gray Dye Casing");
        add(InfuserSetup.GRAY_DYE_PLATE_ITEM.get(), "Gray Dye Plate");
        add(InfuserSetup.LIGHT_GRAY_DYE_CASING_ITEM.get(), "Light Gray Dye Casing");
        add(InfuserSetup.LIGHT_GRAY_DYE_PLATE_ITEM.get(), "Light Gray Dye Plate");
        add(InfuserSetup.CYAN_DYE_CASING_ITEM.get(), "Cyan Dye Casing");
        add(InfuserSetup.CYAN_DYE_PLATE_ITEM.get(), "Cyan Dye Plate");
        add(InfuserSetup.PURPLE_DYE_CASING_ITEM.get(), "Purple Dye Casing");
        add(InfuserSetup.PURPLE_DYE_PLATE_ITEM.get(), "Purple Dye Plate");
        add(InfuserSetup.BLUE_DYE_CASING_ITEM.get(), "Blue Dye Casing");
        add(InfuserSetup.BLUE_DYE_PLATE_ITEM.get(), "Blue Dye Plate");
        add(InfuserSetup.BROWN_DYE_CASING_ITEM.get(), "Brown Dye Casing");
        add(InfuserSetup.BROWN_DYE_PLATE_ITEM.get(), "Brown Dye Plate");
        add(InfuserSetup.GREEN_DYE_CASING_ITEM.get(), "Green Dye Casing");
        add(InfuserSetup.GREEN_DYE_PLATE_ITEM.get(), "Green Dye Plate");
        add(InfuserSetup.RED_DYE_CASING_ITEM.get(), "Red Dye Casing");
        add(InfuserSetup.RED_DYE_PLATE_ITEM.get(), "Red Dye Plate");
        add(InfuserSetup.BLACK_DYE_CASING_ITEM.get(), "Black Dye Casing");
        add(InfuserSetup.BLACK_DYE_PLATE_ITEM.get(), "Black Dye Plate");

        // Layout
        add(LayoutSetup.LAYOUT_BLOCK.get(), "Layout Guide");
        add(LayoutSetup.INTERN_ITEM.get(), "Intern");

        // Oracle
        add(OracleSetup.ORACLE_BLOCK.get(), "Dee's Oracle");

        // Squeezer
        add(SqueezerSetup.SQUEEZER_BLOCK.get(), "Dye Liquifier");
        add(SqueezerSetup.ENCHANT_SQUEEZER_BLOCK.get(), "Enchant Liquifier");

        // Comands
        add("commands.woot.pupils", "Simulating %s");
        add("commands.woot.give.ok", "Gave %s controller for %s");
        add("commands.woot.give.fail", "Invalid mob %s");
        add("commands.woot.simulation.learn.ok", "Starting learning Entity: {0}");
        add("commands.woot.simulation.learn.fail", "Failed to start learning Entity: {0}");
        add("commands.woot.simulation.status.simulating", "Simulating {0}");
        add("commands.woot.simulation.status.waiting", "Waiting for cell {0}");
        add("commands.woot.simulation.dump.drop", "Drops {0}");
        add("commands.woot.simulation.roll", "{0} Looting {1} dropped {2}");
        add("commands.woot.mob.info.summary", "{0} Health {1} XP {2} Tier {3}");

        // Fluids
        add("fluid.woot.conatus_fluid", "Conatus Fluid");
        add("fluid.woot.puredye_fluid", "Pure Dye Fluid");
        add("fluid.woot.enchant_fluid", "Liquid Enchant");
        add("fluid.woot.mob_essence_fluid", "Purge Fluid");

        add("item.woot.conatus_fluid_bucket", "Conatus Bucket");
        add("item.woot.enchant_fluid_bucket", "Liquid Enchant Bucket");
        add("item.woot.puredye_fluid_bucket", "Pure Dye Bucket");
        add("item.woot.mob_essence_fluid_bucket", "Purge Fluid Bucket");

        // Tooltips
        add("info.woot.intern", "Use on the factory heart to form, build or validate a factory");
        add("info.woot.intern.0", "Sneak-right click to change modes");
        add("info.woot.intern.1", "Place controllers and cells manually");
        add("info.woot.intern.mode.form", "Form the factory");
        add("info.woot.intern.mode.build", "Build a %s factory");
        add("info.woot.intern.mode.validate", "Validate a %s factory");
        add("info.woot.intern.other.count", "%2d of %s");
        add("info.woot.intern.controller.count.0", "%2d of %s");
        add("info.woot.intern.controller.count.1", "1 to %2d of %s");
        add("info.woot.mobshard.0", "Attack mob with shard to capture");
        add("info.woot.mobshard.1", "Kill mobs to fill the shard");
        add("info.woot.mobshard.2", "Shard must be in your hotbar to fill");
        add("info.woot.mobshard.3", "Can be cleared in a crafting table");
        add("info.woot.mobshard.a.0", "[Unprogrammed]");
        add("info.woot.mobshard.a.1", "[Fully Programmed]");
        add("info.woot.mobshard.b.0", "[Kills %d/%d]");
        add("info.woot.mobshard.b.1", "[Fully Programmed]");
        add("info.woot.cell.0", "Conatus Fluid %d/%dmB");
        add("info.woot.cell.1", "Transfer rate %dmB/tick");
        add("info.woot.shard.0", "Right click to gain experience");
        add("info.woot.shard.1", "Sneak right click to consume full stack");
        add("info.woot.intern.cell", "Cell");
        add("info.woot.energy", "Energy: %d/%d RF");
        add("info.woot.input_tank", "Input Tank: %s %d/%d mB");
        add("info.woot.input_tank.empty", "Input Tank: 0/%d mB");
        add("info.woot.output_tank", "Output Tank: %s %d/%d mB");
        add("info.woot.output_tank.empty", "Output Tank: 0/%d mB");
        add("info.woot.squeezer.glow", "Use glowstone on machine to swap dump/strict mode");
        add("info.woot.squeezer.0", "Internal: R:%dmB Y:%dmB B:%dmB W:%dmB");
        add("info.woot.perk.efficiency", "Use less Conatus fluid");
        add("info.woot.perk.efficiency.0", "Use %d%% less fluid");
        add("info.woot.perk.looting", "Change the looting level");
        add("info.woot.perk.mass", "Increases the number of mobs");
        add("info.woot.perk.mass.0", "Spawn %d mobs");
        add("info.woot.perk.rate", "Speeds up the spawn time");
        add("info.woot.perk.rate.0", "Reduce spawn time by %d%%");
        add("info.woot.perk.headless", "Generate skulls");
        add("info.woot.perk.headless.0", "Chance to drop a skull %d%%");
        add("info.woot.perk.tier_shard", "Generate essence to upgrade the factory");
        add("info.woot.perk.tier_shard.0", "%d chances to drop essence");
        add("info.woot.perk.tier_shard.1", "- %s drop chance %.02f%%");
        add("info.woot.perk.tier_shard.2", "Essence weights w%d/w%d/w%d");
        add("info.woot.perk.xp", "Generate experience");
        add("info.woot.perk.xp.0", "Generate %d%% of mob experience");
        add("info.woot.controller.0", "Right-click for required tier information");
        add("info.woot.exotic.exotic_a", "Reduce fluid ingredients by %0.2f%%");
        add("info.woot.exotic.exotic_b", "Reduce item ingredients by %0.2f%%");
        add("info.woot.exotic.exotic_c", "Increase efficiency of Conatus usage to %0.2f%%");
        add("info.woot.exotic.exotic_d", "Fixed spawn time of %d ticks");
        add("info.woot.exotic.exotic_e", "Spawns %d mobs");

        // Chat
        add("chat.woot.intern.noedit", "Player is not allowed to edit");
        add("chat.woot.intern.missingblock", "No %s in inventory");
        add("chat.woot.intern.noreplace", "Cannot replace %s at (%d,%d,%d)");
        add("chat.woot.intern.validate.power", "Found power cell at (%d,%d,%d)");
        add("chat.woot.intern.validate.nopower", "No power cell at (%d,%d,%d)");
        add("chat.woot.intern.validate.importer", "Found importer at (%d,%d,%d)");
        add("chat.woot.intern.validate.noimported", "No importer at (%d,%d,%d)");
        add("chat.woot.intern.validate.exporter", "Found exporter at (%d,%d,%d)");
        add("chat.woot.intern.validate.noexported", "No exporter at (%d,%d,%d)");
        add("chat.woot.intern.validate.missing", "Expected %s at (%d,%d,%d)");
        add("chat.woot.intern.validate.incorrect", "Expected %s at (%d,%d,%d) but found %s");
        add("chat.woot.intern.validate.wrongtier", "Controller at (%d,%d,%d) not valid for %s");
        add("chat.woot.intern.validate.blacklisted", "Controller at (%d,%d,%d) is blacklisted");
        add("chat.woot.intern.validate.noprimary", "No valid primary controller at (%d,%d,%d)");
        add("chat.woot.intern.validate.start", "-- Validating %s --");
        add("chat.woot.intern.validate.invalid", "### Not a valid %s factory");
        add("chat.woot.intern.validate.valid", "### Found valid %s factory");
        add("chat.woot.mobshard.failure", "Cannot capture mob");
        add("chat.woot.mobshard.success", "Captured mob");
        add("chat.woot.anvil.cold", "Anvil must be sitting on a Magma Block");
        add("chat.woot.anvil.nobase", "Place valid base item first");
        add("chat.woot.perk.fail.0", "Only level 1 perks can be added to an empty upgrade block");
        add("chat.woot.perk.fail.1", "Cannot add a different perk to an existing one");
        add("chat.woot.perk.fail.2", "Max level perk already installed");
        add("chat.woot.perk.fail.3", "Perk level %d already installed");
        add("chat.woot.perk.fail.4", "Can only add the same perk with level %d");
        add("chat.woot.squeezer.dump", "Dumping excess");
        add("chat.woot.squeezer.strict", "Strict internal tanks");

        // Gui
        add("gui.woot.anvil.name", "Stygian Anvil");
        add("gui.woot.infuser.name", "Injection Press");
        add("gui.woot.enchsqueezer.name", "Enchant Liquifier");
        add("gui.woot.squeezer.name", "Dye Liquifier");
        add("gui.woot.fluidconvertor.name", "Fluid Vat");
        add("gui.woot.oracle.name", "Dee's Oracle");
        add("gui.woot.heart.0", "Factory");
        add("gui.woot.heart.1", "Spawn Time");
        add("gui.woot.heart.2", "Progress");
        add("gui.woot.heart.3", "Controllers");
        add("gui.woot.heart.4", "Perks");
        add("gui.woot.heart.5", "Loot Pool");
        add("gui.woot.oracle.looting.0", "No looting : %.2f%%");
        add("gui.woot.oracle.looting.1", "Looting I : %.2f%%");
        add("gui.woot.oracle.looting.2", "Looting II : %.2f%%");
        add("gui.woot.oracle.looting.3", "Looting III : %.2f%%");
        add("gui.woot.squeezer.red", "Red %d/%d mb");
        add("gui.woot.squeezer.yellow", "Yellow %d/%d mb");
        add("gui.woot.squeezer.blue", "Blue %d/%d mb");
        add("gui.woot.squeezer.white", "White %d/%d mb");
        add("gui.woot.squeezer.dump", "Dumping");
        add("gui.woot.squeezer.strict", "Strict");

        // Misc
        add("misc.woot.tier_1", "Zelator [I]");
        add("misc.woot.tier_2", "Theoricus [II]");
        add("misc.woot.tier_3", "Practicus [III]");
        add("misc.woot.tier_4", "Exemptus [IV]");
        add("misc.woot.tier_5", "Magister [V]");
        add("misc.woot.unknown_entity", "Unknown entity");
        add("misc.woot.tagged_mob", "%s [%s]");

        // Jei
        add("jei.woot.shard", "Generated from the factory with the Shard perk installed.");
        add("jei.woot.anvil.0", "Used to create controllers.");
        add("jei.woot.anvil.1", "Must be placed on a Magma block.");
        add("jei.woot.anvil.2", "Items are right-clicked onto the top of the anvil to place them.");
        add("jei.woot.anvil.3", "Use the YA Hammer to craft.");
        add("jei.woot.intern.0", "Can be used to auto-build or validate the factory.");
        add("jei.woot.intern.1", "Use on a factory heart to build or validate.");
        add("jei.woot.mob_shard.0", "Hit a mob with the shard to program.");
        add("jei.woot.mob_shard.1", "A number of mobs of that type must then be killed with the shard in your inventory to fully program it.");
        add("jei.woot.mob_shard.2", "Once fully programmed it can be turned into a controller on the anvil.");

        // Patchouli
        LanguagesGuide.addTranslations(this);

        // Top
        add("top.woot.heart.unformed", "Unformed");
        add("top.woot.heart.tier.label", "Tier");
        add("top.woot.heart.progress.label", "Progress");
        add("top.woot.heart.progress.0", "%d%%");
        add("top.woot.heart.mob.label", "Mob");
        add("top.woot.heart.perk.label", "Perk");
        add("top.woot.heart.exotic.label", "Exotic");
        add("top.woot.controller.mob.label", "Mob");
        add("top.woot.controller.tier.label", "Required Tier");
        add("top.woot.squeezer.red.label", "Red Dye");
        add("top.woot.squeezer.yellow.label", "Yellow Dye");
        add("top.woot.squeezer.blue.label", "Blue Dye");
        add("top.woot.squeezer.white.label", "White Dye");
        add("top.woot.squeezer.dye.0", "%d mb");
        add("top.woot.squeezer.tanks.label", "Tank Mode");
        add("top.woot.squeezer.tanks.0", "Dumping");
        add("top.woot.squeezer.tanks.1", "Strict");
        add("top.woot.perk.type.label", "Perk");
        add("top.woot.perk.type.empty", "Empty");
        add("top.woot.layout.tier.label", "Tier");
    }
}
