package de.obdachioser.football.projectlisteners;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import de.obdachioser.football.events.SlimeMoveEvent;
import de.obdachioser.football.events.TeamScoreEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

/**
 * package: de.obdachioser.football.projectlisteners
 * <p>
 * created by ObdachIoser 12:25 on 02.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class SlimeMoveListener implements Listener {

    @EventHandler
    public void slimeMove(SlimeMoveEvent event) {

        for(ProtectedRegion protectedRegion : Football.getFootballSession().getRegionManager().getRegions().values()) {

            if(protectedRegion.getId().equals(Football.getFootballSession().getRegionName())
				    && !protectedRegion.contains((int) event.getTo().getX(), (int) event.getTo().getY(), (int) event.getTo().getZ())) {

			 Location slimeLocation = event.getSlime().getLocation().clone();
			 Location middleLocation = Football.getFootballSession().getMiddlePointLocation().clone();

			 Vector vector = new Vector((middleLocation.getBlockX()-slimeLocation.getBlockX()),
					   (middleLocation.getY()-slimeLocation.getY()), (middleLocation.getZ()-slimeLocation.getZ()));

			 vector.setY(0.35);
			 vector.setX(vector.getBlockX()/11.55);
			 vector.setZ(vector.getBlockZ()/11.55);

			 event.getSlime().setVelocity(vector);

			 for(Player player : Bukkit.getOnlinePlayers()) {

			     CustomPlayerCache customPlayerCache = Football.getFootballSession().getCustomPlayerCaches().get(player.getUniqueId());
			     if(customPlayerCache.isIngame()) player.playSound(player.getEyeLocation(), Sound.ZOMBIE_WOODBREAK, 1F, 1F);
			 }
		  }

		  if(protectedRegion.getId().equals(Football.getFootballSession().getRegionName() + "-gate-blue")
				    && protectedRegion.contains((int) event.getTo().getX(), (int) event.getTo().getY(), (int) event.getTo().getZ())
				    && Football.getFootballSlime().getLastscore() < System.currentTimeMillis()) {

			 TeamScoreEvent teamScoreEvent = new TeamScoreEvent(
					   Football.getFootballSession().getSimpleTeamMap().getTeam("rot"),
					   Football.getFootballSession().getSimpleTeamMap().getTeam("blau"),
					   Football.getFootballSlime().getLastKicker());

			 Football.getFootballSlime().setLastscore(System.currentTimeMillis()+5000);
                Bukkit.getPluginManager().callEvent(teamScoreEvent);

                Football.getFootballSlime().destroyAndSpawn();
		  }

		  if(protectedRegion.getId().equals(Football.getFootballSession().getRegionName() + "-gate-red")
				    && protectedRegion.contains((int) event.getTo().getX(), (int) event.getTo().getY(), (int) event.getTo().getZ())
				    && Football.getFootballSlime().getLastscore() < System.currentTimeMillis()) {

			 TeamScoreEvent teamScoreEvent = new TeamScoreEvent(
					   Football.getFootballSession().getSimpleTeamMap().getTeam("blau"),
					   Football.getFootballSession().getSimpleTeamMap().getTeam("rot"),
					   Football.getFootballSlime().getLastKicker());

			 Football.getFootballSlime().setLastscore(System.currentTimeMillis()+5000);
			 Bukkit.getPluginManager().callEvent(teamScoreEvent);

			 Football.getFootballSlime().destroyAndSpawn();
		  }
	   }
    }
}
