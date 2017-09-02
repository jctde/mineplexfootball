package de.obdachioser.football;

import de.obdachioser.football.events.SlimeMoveEvent;
import lombok.Getter;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntity;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Slime;
import org.bukkit.util.Vector;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
        slime.setSize(4);

        a();
    }

    public void setVelocity(Vector velocity) {
        slime.setVelocity(velocity);
    }

    private Location lastLocation = null;

    public void a() {

        Executors.newCachedThreadPool().execute(() -> {

            try {

                for(Integer i = 0; i != -1; i++) {

                    TimeUnit.MILLISECONDS.sleep(150L);

                    Bukkit.getPluginManager().callEvent(new SlimeMoveEvent(slime, lastLocation, slime.getLocation()));
                    lastLocation = slime.getLocation();

                    i = 0;
                }

            } catch (Exception exc) {
                exc.printStackTrace();
            }

        });

    }

    public void destroy() {
        if(slime != null) slime.remove();
    }
}