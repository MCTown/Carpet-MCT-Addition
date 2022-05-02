package tech.mctown.cma.mixins.flintAndSteelActivatesObserver;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tech.mctown.cma.CMASettings;

@Mixin(FlintAndSteelItem.class)
public abstract class FlintAndSteelItemMixin {
    @Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
    void activatesObserver(ItemUsageContext context, CallbackInfoReturnable<ActionResult> ci) {
        if (CMASettings.flintAndSteelActivatesObserver) {
            PlayerEntity playerEntity = context.getPlayer();
            if (playerEntity == null) return;
            World world = context.getWorld();
            BlockPos blockPos = context.getBlockPos();
            BlockState blockState = world.getBlockState(blockPos);

            if (blockState.isOf(Blocks.OBSERVER) && !playerEntity.isSneaking()) {
                if (!world.isClient() && !world.getBlockTickScheduler().isQueued(blockPos, Blocks.OBSERVER)) {
                    world.createAndScheduleBlockTick(blockPos, blockState.getBlock(), 2);
                }
                ci.setReturnValue(ActionResult.success(world.isClient()));
            }
        }
    }
}
