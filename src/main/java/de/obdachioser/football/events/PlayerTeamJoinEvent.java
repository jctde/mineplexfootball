package de.obdachioser.football.events;

import de.obdachioser.football.game.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * package: de.obdachioser.football.events
 * <p>
 * created by ObdachIoser 20:15 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

@AllArgsConstructor @Getter
public class PlayerTeamJoinEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Player player;
    private Team team;

    @Override
    public HandlerList getHandlers() {
	   return handlerList;
    }

    public static HandlerList getHandlerList() {
	   return handlerList;
    }
}