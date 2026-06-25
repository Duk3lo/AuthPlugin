package org.astral.authPlugin.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.jspecify.annotations.NonNull;

public final class HungerProtectionListener implements Listener {

    @EventHandler
    public void onHunger(@NonNull FoodLevelChangeEvent event) {

        if (!(event.getEntity() instanceof Player player)) return;

        if (player.getGameMode() == GameMode.CREATIVE) return;

        event.setCancelled(true);
        player.setFoodLevel(20);
    }
}