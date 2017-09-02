package de.obdachioser.football.listeners;

import org.bukkit.entity.EntityType;
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

        if(event.getEntity().getType() == EntityType.SLIME) {
            event.setCancelled(true);
        }
    }
}
