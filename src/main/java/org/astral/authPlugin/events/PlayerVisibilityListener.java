package org.astral.authPlugin.events;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jspecify.annotations.NonNull;

public final class PlayerVisibilityListener implements Listener {

    private final AuthPlugin plugin = AuthPlugin.getInstance();

    @EventHandler
    public void onJoin(@NonNull PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.getScheduler().run(plugin, _ -> {

            if (plugin.getConfigManager().isDisableCollisions()) {
                player.setCollidable(false);
            }

            if (!plugin.getConfigManager().isHidePlayers()) {
                return;
            }

            for (Player other : player.getServer().getOnlinePlayers()) {

                if (player.equals(other)) {
                    continue;
                }

                player.hidePlayer(plugin, other);
                other.hidePlayer(plugin, player);
            }

        }, null);
    }
}