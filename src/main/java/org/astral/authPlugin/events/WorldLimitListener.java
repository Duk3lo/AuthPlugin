package org.astral.authPlugin.events;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jspecify.annotations.NonNull;

public final class WorldLimitListener implements Listener {

    private final AuthPlugin plugin = AuthPlugin.getInstance();

    @EventHandler
    public void onMove(@NonNull PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE) return;

        double y = player.getLocation().getY();

        double minY = plugin.getConfigManager().getMinY();
        double maxY = plugin.getConfigManager().getMaxY();

        if (y < minY || y > maxY) {

            player.getScheduler().run(plugin, _ -> teleportToSpawn(player), null);
        }
    }

    private void teleportToSpawn(@NonNull Player player) {

        var cfg = plugin.getConfigManager();

        World world = player.getServer().getWorld(cfg.getSpawnWorld());
        if (world == null) return;

        Location spawn = new Location(
                world,
                cfg.getSpawnX(),
                cfg.getSpawnY(),
                cfg.getSpawnZ(),
                cfg.getSpawnYaw(),
                cfg.getSpawnPitch()
        );

        player.teleport(spawn);
    }
}