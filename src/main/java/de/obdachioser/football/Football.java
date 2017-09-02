package de.obdachioser.football;

import de.obdachioser.football.commands.TeamCommand;
import de.obdachioser.football.listeners.*;
import de.obdachioser.football.projectlisteners.PlayerRegionEnteredListener;
import de.obdachioser.football.projectlisteners.PlayerRegionLeftListener;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * package: de.obdachioser.football
 * <p>
 * created by ObdachIoser 19:47 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class Football extends JavaPlugin {

    @Getter
    private static FootballSession footballSession;

    @Getter @Setter
    private static FootballSlime footballSlime = null;

    @Getter
    private static Football instance;

    @Getter
    private static String prefix = "§f[§eFootball§f] §7";

    public Football() {
        instance = this;
    }

    @Override
    public void onEnable() {

        Executors.newCachedThreadPool().execute(() -> {

            try {

                TimeUnit.MILLISECONDS.sleep(500L);

                footballSession = new FootballSession();
                footballSession.start();

                registerCommands();
                registerListeners();

                Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> footballSlime = new FootballSlime(footballSession.getMiddlePointLocation()));

            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });
    }

    @Override
    public void onDisable() {
	   super.onDisable();
    }

    private void registerListeners() {

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerRegionEnteredListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerRegionLeftListener(), this);

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
    }

    private void registerCommands() {

        ((CraftServer) getServer()).getCommandMap().register("football", new TeamCommand());
    }
}
