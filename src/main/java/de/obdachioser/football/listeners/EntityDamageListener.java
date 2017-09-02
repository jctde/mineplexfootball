package de.obdachioser.football.listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * package: de.obdachioser.football.listeners
 * <p>
 * created by ObdachIoser 02:13 on 02.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class EntityDamageListener implements Listener {

    @EventHandler
    public void entityDamage(EntityDamageEvent event) {

	   if(event.getEntity().getType() == EntityType.SLIME) {
		  event.setCancelled(true);
	   }
    }
}