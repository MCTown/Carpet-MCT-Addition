package tech.mctown.cma.commands;

import carpet.settings.SettingsManager;
import carpet.utils.Messenger;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.BaseText;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import org.lwjgl.system.CallbackI;
import tech.mctown.cma.CMASettings;

import static net.minecraft.server.command.CommandManager.literal;

public class DumpEntitiyCommand {
    public static void registerCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("dumpentity").requires(src -> SettingsManager.canUseCommand(src, CMASettings.commandDumpEntity))
                        .executes(DumpEntitiyCommand::dumpEntity)
        );
    }

    public static int dumpEntity(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        ServerCommandSource src = ctx.getSource();
        ServerWorld world = src.getWorld();
        for (Entity e : world.iterateEntities()) {
            Messenger.m(src, Text.of(e.toString()));
        }
        return 0;
    }
}
