package de.obdachioser.football.listeners;

import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * package: de.obdachioser.football.listeners
 * <p>
 * created by ObdachIoser 20:50 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {

	   Football.getFootballSession().getCustomPlayerCaches().put(event.getPlayer().getUniqueId(), new CustomPlayerCache());
    }
}