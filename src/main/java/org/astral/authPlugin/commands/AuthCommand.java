package org.astral.authPlugin.commands;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.command.*;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

import java.util.List;

public final class AuthCommand implements CommandExecutor, TabCompleter {

    private final AuthPlugin plugin;

    public AuthCommand(AuthPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String label,
            @NotNull String @NonNull [] args
    ) {

        if (args.length == 0) {
            sender.sendMessage("§e/auth reload");
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {

            plugin.reloadPlugin();

            sender.sendMessage("§aConfiguración recargada.");
            return true;
        }

        sender.sendMessage("§cSubcomando desconocido.");
        return true;
    }

    @Override
    public List<String> onTabComplete(
            @NotNull CommandSender sender,
            @NotNull Command command,
            @NotNull String alias,
            @NotNull String @NonNull [] args
    ) {

        if (args.length == 1) {
            return List.of("reload");
        }

        return List.of();
    }
}