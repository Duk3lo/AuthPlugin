package org.astral.authPlugin;

import org.astral.authPlugin.commands.RegisterCommands;
import org.astral.authPlugin.config.AuthPluginConfig;
import org.astral.authPlugin.events.RegisterEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class AuthPlugin extends JavaPlugin {

    private static AuthPlugin INSTANCE;
    private AuthPluginConfig configManager;

    @Override
    public void onEnable() {
        INSTANCE = this;

        configManager = new AuthPluginConfig(this);
        configManager.load();

        RegisterEvents.registerAll(this);
        RegisterCommands.registerAll(this);
    }

    public void reloadPlugin() {
        reloadConfig();
        configManager.load();
    }

    public AuthPluginConfig getConfigManager() {
        return configManager;
    }

    public static AuthPlugin getInstance() {
        return INSTANCE;
    }
}