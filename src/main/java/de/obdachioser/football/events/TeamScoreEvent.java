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
 * created by ObdachIoser 13:45 on 02.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

@AllArgsConstructor @Getter
public class TeamScoreEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Team team;
    private Player player;

    @Override
    public HandlerList getHandlers() {
	   return null;
    }

    public static HandlerList getHandlerList() {
	   return handlerList;
    }
}
