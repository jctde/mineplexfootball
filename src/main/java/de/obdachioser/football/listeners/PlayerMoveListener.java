package de.obdachioser.football.listeners;

import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import de.obdachioser.football.events.worldguard.PlayerRegionEnteredEvent;
import de.obdachioser.football.events.worldguard.PlayerRegionLeftEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.List;

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
				return;
			 }
		  }

		  if(!protectedRegion.contains(localPlayer.getPosition()) && protectedRegion.getId().equalsIgnoreCase(Football.getFootballSession().getRegionName())) {

			 if(playerCache.isIngame()) {

				PlayerRegionLeftEvent playerRegionLeftEvent = new PlayerRegionLeftEvent(false, event.getPlayer());
				Bukkit.getPluginManager().callEvent(playerRegionLeftEvent);

				if (playerRegionLeftEvent.isCancelled()) return;
			 }
		  }
	   }

	   if(playerCache.isIngame()) {

		  List<Entity> entityList = event.getPlayer().getNearbyEntities(0.5, 0.5, 0.5);

	       if(entityList.size() >= 1 && entityList.get(0).getType() == EntityType.SLIME && entityList.get(0) == Football.getFootballSlime().getSlime()) {

			 Football.getFootballSlime().setVelocity(event.getPlayer().getLocation().getDirection().multiply(1.55).setY(0.26));
			 Football.getFootballSlime().setLastKicker(event.getPlayer());
		  }
	   }
    }
}