package de.obdachioser.football.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Slime;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * package: de.obdachioser.football.events
 * <p>
 * created by ObdachIoser 02:29 on 02.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

@AllArgsConstructor @Getter
public class SlimeMoveEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Slime slime;
    private Location from;
    private Location to;

    @Override
    public HandlerList getHandlers() {
	   return handlerList;
    }

    public static HandlerList getHandlerList() {
	   return handlerList;
    }
}
