package org.astral.authPlugin.commands;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.command.PluginCommand;

public final class RegisterCommands {

    public static void registerAll(AuthPlugin plugin) {

        AuthCommand commandExecutor = new AuthCommand(plugin);

        PluginCommand command = plugin.getCommand("auth");

        if (command != null) {
            command.setExecutor(commandExecutor);
            command.setTabCompleter(commandExecutor);
        }
    }
}