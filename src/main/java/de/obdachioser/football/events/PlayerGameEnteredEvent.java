package de.obdachioser.football.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * package: de.obdachioser.football.events
 * <p>
 * created by ObdachIoser 20:10 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

@AllArgsConstructor @Getter
public class PlayerGameEnteredEvent extends Event {

    private static HandlerList handlerList = new HandlerList();
    private Player player;

    @Override
    public HandlerList getHandlers() {
	   return null;
    }

    public static HandlerList getHandlerList() {
	   return handlerList;
    }
}
