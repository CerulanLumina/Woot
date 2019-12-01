package ipsis.woot.server.command;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import ipsis.woot.factory.blocks.ControllerTileEntity;
import ipsis.woot.simulation.spawning.SpawnController;
import ipsis.woot.util.FakeMob;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.registries.ForgeRegistries;

public class GiveCommand {

    static final SuggestionProvider<CommandSource> ENTITY_SUGGESTIONS = (ctx, builder) ->
            ISuggestionProvider.func_212476_a(
                    ForgeRegistries.ENTITIES.getKeys().stream(),
                    builder);

    static ArgumentBuilder<CommandSource, ?> register() {
        return Commands.literal("give")
                .requires(cs -> cs.hasPermissionLevel(0))
                .then(Commands.argument("target", EntityArgument.player())
                        .then(Commands.argument("entity", ResourceLocationArgument.resourceLocation())
                                .suggests(ENTITY_SUGGESTIONS)
                                .executes(ctx -> giveItem(
                                        ctx.getSource(),
                                        EntityArgument.getPlayer(ctx, "target"),
                                        ResourceLocationArgument.getResourceLocation(ctx, "entity")))));
    }

    private static int giveItem(CommandSource source, ServerPlayerEntity target, ResourceLocation resourceLocation) {

        FakeMob fakeMob = new FakeMob(resourceLocation.toString());
        if (fakeMob.isValid() && SpawnController.get().isLivingEntity(fakeMob, source.getWorld())) {
            ItemStack itemStack = ControllerTileEntity.getItemStack(fakeMob);

            /**
             * Straight from vanilla GiveCommand
             */
            boolean added = target.inventory.addItemStackToInventory(itemStack);
            if (added && itemStack.isEmpty()) {
                itemStack.setCount(1);
                ItemEntity itemEntity = target.dropItem(itemStack, false);
                if (itemEntity != null)
                    itemEntity.makeFakeItem();

                target.world.playSound(null,
                        target.posX, target.posY, target.posZ,
                        SoundEvents.ENTITY_ITEM_PICKUP,
                        SoundCategory.PLAYERS,
                        0.2F,
                        ((target.getRNG().nextFloat() - target.getRNG().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                target.container.detectAndSendChanges();
            } else {
                ItemEntity itemEntity = target.dropItem(itemStack, false);
                if (itemEntity != null) {
                    itemEntity.setNoPickupDelay();
                    itemEntity.setOwnerId(target.getUniqueID());
                }
            }
            source.sendFeedback(new TranslationTextComponent("commands.woot.give.ok",
                    target.getDisplayName(), resourceLocation.toString()), true);
        } else {
            source.sendFeedback(new TranslationTextComponent("commands.woot.give.fail",
                    resourceLocation.toString()), true);
        }

        return 1;
    }
}
