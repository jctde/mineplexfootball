package de.obdachioser.football;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;
import org.bukkit.util.Vector;

/**
 * package: de.obdachioser.football
 * <p>
 * created by ObdachIoser 19:49 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class FootballSlime {

    @Getter
    private Slime slime;

    public FootballSlime(Location location) {
        slime = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);
    }

    public void setVelocity(Vector velocity) {
        slime.setVelocity(velocity);
    }

    public void destroy() {
        if(slime != null) slime.remove();
    }
}