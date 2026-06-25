package org.astral.authPlugin.config;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public final class AuthPluginConfig {

    private final AuthPlugin plugin;

    private boolean hidePlayers;
    private boolean disableCollisions;

    public AuthPluginConfig(AuthPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();

        FileConfiguration config = plugin.getConfig();

        hidePlayers = config.getBoolean("players.hide", true);
        disableCollisions = config.getBoolean("players.disable-collisions", true);
    }

    public boolean isHidePlayers() {
        return hidePlayers;
    }

    public boolean isDisableCollisions() {
        return disableCollisions;
    }
}