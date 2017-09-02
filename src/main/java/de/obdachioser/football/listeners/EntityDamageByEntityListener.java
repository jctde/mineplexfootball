package de.obdachioser.football.listeners;

import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * package: de.obdachioser.football.listeners
 * <p>
 * created by ObdachIoser 02:07 on 02.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    public void entityDamageByEntity(EntityDamageByEntityEvent event) {

        if(event.getEntity().getType() == EntityType.SLIME && event.getEntity() == Football.getFootballSlime().getSlime()) {
            event.setCancelled(true);
        }

        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {

            CustomPlayerCache customEntityCache = Football.getFootballSession().getCustomPlayerCaches().get(event.getEntity().getUniqueId());
            CustomPlayerCache customDamagerCache = Football.getFootballSession().getCustomPlayerCaches().get(event.getDamager().getUniqueId());

            if(customDamagerCache.isIngame() && customEntityCache.isIngame()) {

                event.getEntity().setVelocity(event.getDamager().getLocation().getDirection().setY(0.20));

                ((Player) event.getEntity()).playSound(((Player) event.getEntity()).getEyeLocation(), Sound.BLAZE_HIT, 1F, 1F);
                ((Player) event.getDamager()).playSound(((Player) event.getDamager()).getEyeLocation(), Sound.BLAZE_HIT, 1F, 1F);

                customEntityCache.setLastPush(System.currentTimeMillis()+1650);
            }
        }
    }
}
