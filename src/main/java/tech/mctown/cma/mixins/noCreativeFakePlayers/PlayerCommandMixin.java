package tech.mctown.cma.mixins.noCreativeFakePlayers;

import carpet.commands.PlayerCommand;
import carpet.utils.Messenger;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerCommand.class)
public abstract class PlayerCommandMixin {
    @Inject(method = "cantSpawn", at = @At("HEAD"), remap = false)
    void checkGamemode(CommandContext<ServerCommandSource> context, CallbackInfoReturnable<Boolean> ci) {
        try {
            StringArgumentType.getString(context, "gamemode");
        } catch (IllegalArgumentException var10) {
            return;
        }
        ci.setReturnValue(false);

    }
}
