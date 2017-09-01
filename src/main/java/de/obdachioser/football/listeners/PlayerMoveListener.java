package de.obdachioser.football.listeners;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import de.obdachioser.football.events.worldguard.PlayerRegionEnteredEvent;
import de.obdachioser.football.events.worldguard.PlayerRegionLeftEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * package: de.obdachioser.football.listeners
 * <p>
 * created by ObdachIoser 21:08 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class PlayerMoveListener implements Listener {

    @EventHandler
    public void playerMove(PlayerMoveEvent event) {

	   LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(event.getPlayer());
	   CustomPlayerCache playerCache = Football.getFootballSession().getCustomPlayerCaches().get(event.getPlayer().getUniqueId());

	   for(ProtectedRegion protectedRegion : Football.getFootballSession().getRegionManager().getRegions().values()) {

		  if(protectedRegion.contains(localPlayer.getPosition()) && protectedRegion.getId().equalsIgnoreCase(Football.getFootballSession().getRegionName())) {

			 if (!playerCache.isIngame()) {

				PlayerRegionEnteredEvent playerRegionEnteredEvent = new PlayerRegionEnteredEvent(false, event.getPlayer());
				Bukkit.getPluginManager().callEvent(playerRegionEnteredEvent);

				if (playerRegionEnteredEvent.isCancelled()) return;

				playerCache.setIngame(true);
				return;
			 }
		  }

		  if(!protectedRegion.contains(localPlayer.getPosition()) && protectedRegion.getId().equalsIgnoreCase(Football.getFootballSession().getRegionName())) {

			 if(playerCache.isIngame()) {

				PlayerRegionLeftEvent playerRegionLeftEvent = new PlayerRegionLeftEvent(false, event.getPlayer());
				Bukkit.getPluginManager().callEvent(playerRegionLeftEvent);

				if (playerRegionLeftEvent.isCancelled()) return;

				playerCache.setIngame(false);
			 }
		  }
	   }
    }
}