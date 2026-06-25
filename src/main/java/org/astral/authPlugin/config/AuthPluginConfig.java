package org.astral.authPlugin.config;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public final class AuthPluginConfig {

    private final AuthPlugin plugin;

    private boolean hidePlayers;
    private boolean disableCollisions;

    private String spawnWorld;
    private double spawnX, spawnY, spawnZ;
    private float spawnYaw, spawnPitch;

    private double minY, maxY;

    public AuthPluginConfig(AuthPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();

        FileConfiguration config = plugin.getConfig();

        hidePlayers = config.getBoolean("players.hide", true);
        disableCollisions = config.getBoolean("players.disable-collisions", true);

        spawnWorld = config.getString("spawn.world", "world");
        spawnX = config.getDouble("spawn.x");
        spawnY = config.getDouble("spawn.y");
        spawnZ = config.getDouble("spawn.z");
        spawnYaw = (float) config.getDouble("spawn.yaw");
        spawnPitch = (float) config.getDouble("spawn.pitch");

        minY = config.getDouble("limits.min-y", 0);
        maxY = config.getDouble("limits.max-y", 200);
    }

    public boolean isHidePlayers() { return hidePlayers; }
    public boolean isDisableCollisions() { return disableCollisions; }

    public String getSpawnWorld() { return spawnWorld; }

    public double getSpawnX() { return spawnX; }
    public double getSpawnY() { return spawnY; }
    public double getSpawnZ() { return spawnZ; }
    public float getSpawnYaw() { return spawnYaw; }
    public float getSpawnPitch() { return spawnPitch; }

    public double getMinY() { return minY; }
    public double getMaxY() { return maxY; }
}