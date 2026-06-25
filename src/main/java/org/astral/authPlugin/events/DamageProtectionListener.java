package org.astral.authPlugin.events;

import org.astral.authPlugin.AuthPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.jspecify.annotations.NonNull;

public final class DamageProtectionListener implements Listener {

    @EventHandler
    public void onDamage(@NonNull EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player player)) return;
        if (player.getGameMode() == org.bukkit.GameMode.CREATIVE) return;
        if (isInAuthWorld(player)) {
            event.setCancelled(true);
        }
    }

    private boolean isInAuthWorld(@NonNull Player player) {
        return player.getWorld().getName().equalsIgnoreCase("auth");
    }
}