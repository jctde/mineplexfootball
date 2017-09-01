package de.obdachioser.football.events.worldguard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * package: de.obdachioser.football.events.worldguard
 * <p>
 * created by ObdachIoser 21:07 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

@AllArgsConstructor @Getter
public class PlayerRegionEnteredEvent extends Event implements Cancellable {

    private static HandlerList handlerList = new HandlerList();
    private boolean cancelled = false;

    private Player player;

    @Override
    public boolean isCancelled() {
	   return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
	   cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
	   return handlerList;
    }

    public static HandlerList getHandlerList() {
	   return handlerList;
    }
}
