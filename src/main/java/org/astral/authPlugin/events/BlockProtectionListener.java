package org.astral.authPlugin.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.jspecify.annotations.NonNull;

public final class BlockProtectionListener implements Listener {

    @EventHandler
    public void onBreak(@NonNull BlockBreakEvent event) {

        Player player = event.getPlayer();

        if (player.getGameMode() == GameMode.CREATIVE) return;

        event.setCancelled(true);
    }
}