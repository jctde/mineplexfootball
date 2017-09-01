package de.obdachioser.football.listeners;

import de.obdachioser.football.Football;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * package: de.obdachioser.football.listeners
 * <p>
 * created by ObdachIoser 20:50 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void playerQUit(PlayerQuitEvent event) {

        if(Football.getFootballSession().getCustomPlayerCaches().containsKey(event.getPlayer().getUniqueId()))
            Football.getFootballSession().getCustomPlayerCaches().remove(event.getPlayer().getUniqueId());
    }
}
