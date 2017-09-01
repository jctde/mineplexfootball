package de.obdachioser.football.projectlisteners;

import de.obdachioser.football.events.worldguard.PlayerRegionLeftEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * package: de.obdachioser.football.projectlisteners
 * <p>
 * created by ObdachIoser 22:06 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class PlayerRegionLeftListener implements Listener {

    @EventHandler
    public void regionLeft(PlayerRegionLeftEvent event) {
	   event.getPlayer().sendMessage("lefted");
    }
}