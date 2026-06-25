package org.astral.authPlugin.events;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.jspecify.annotations.NonNull;

public final class HungerProtectionListener implements Listener {

    @EventHandler
    public void onHunger(@NonNull FoodLevelChangeEvent event) {

        if (!(event.getEntity() instanceof Player player)) return;

        if (player.getGameMode() == org.bukkit.GameMode.CREATIVE) return;

        if (isInAuthWorld(player)) {
            event.setCancelled(true);
            player.setFoodLevel(20);
        }
    }

    private boolean isInAuthWorld(@NonNull Player player) {
        return player.getWorld().getName().equalsIgnoreCase("auth");
    }
}