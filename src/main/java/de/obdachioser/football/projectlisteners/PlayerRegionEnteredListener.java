package de.obdachioser.football.projectlisteners;

import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import de.obdachioser.football.events.worldguard.PlayerRegionEnteredEvent;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

/**
 * package: de.obdachioser.football.projectlisteners
 * <p>
 * created by ObdachIoser 22:05 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class PlayerRegionEnteredListener implements Listener {

    @EventHandler
    public void regionEntered(PlayerRegionEnteredEvent event) {

        CustomPlayerCache customPlayerCache = Football.getFootballSession().getCustomPlayerCaches().get(event.getPlayer().getUniqueId());

        if(customPlayerCache.getCurrentTeam() == null) {

            Location playerLocation = event.getPlayer().getLocation().clone();
            Location middleLocation = Football.getFootballSession().getMiddlePointLocation().clone();

            Vector vector = new Vector((middleLocation.getBlockX()+playerLocation.getBlockX()),
            (middleLocation.getY()+playerLocation.getY()), (middleLocation.getZ()+playerLocation.getZ()));

            vector.setY(0.95);
            vector.setX(vector.getBlockX()/8.55);
            vector.setZ(vector.getBlockZ()/8.55);

            event.getPlayer().setVelocity(vector);

            if(customPlayerCache.getLastmessagestamp() < System.currentTimeMillis()) {

                event.getPlayer().sendMessage(Football.getPrefix() + "§c/team join [Rot|Blau]");
                event.getPlayer().playSound(event.getPlayer().getEyeLocation(), Sound.ZOMBIE_WOODBREAK,1F, 1F);

                customPlayerCache.setLastmessagestamp(System.currentTimeMillis()+650L);
            }

            event.setCancelled(true);
        }
    }
}