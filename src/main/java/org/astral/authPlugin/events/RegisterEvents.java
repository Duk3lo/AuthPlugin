package org.astral.authPlugin.events;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.plugin.PluginManager;
import org.jspecify.annotations.NonNull;

public final class RegisterEvents {

    public static void registerAll(@NonNull AuthPlugin plugin) {
        PluginManager manager = plugin.getServer().getPluginManager();

        manager.registerEvents(new PlayerVisibilityListener(), plugin);
    }
}