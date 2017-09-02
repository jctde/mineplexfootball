package de.obdachioser.football.projectlisteners;

import de.obdachioser.football.events.TeamScoreEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * package: de.obdachioser.football.projectlisteners
 * <p>
 * created by ObdachIoser 14:13 on 02.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class TeamScoreListener implements Listener {

    @EventHandler
    public void teamScore(TeamScoreEvent event) {

	   Bukkit.broadcastMessage("player: " + event.getPlayer().getName());
	   Bukkit.broadcastMessage("scored for: " + event.getTeam().getTeamDisplayName());
    }
}
