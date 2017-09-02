package de.obdachioser.football;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.managers.RegionManager;
import de.obdachioser.football.game.SimpleTeam;
import de.obdachioser.football.game.TeamColor;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * package: de.obdachioser.football
 * <p>
 * created by ObdachIoser 19:49 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

@Getter
public class FootballSession {

    private SimpleTeamMap simpleTeamMap = new SimpleTeamMap();
    private HashMap<UUID, CustomPlayerCache> customPlayerCaches = Maps.newHashMap();

    private String regionName = "football";
    private Location middlePointLocation = new Location(Bukkit.getWorld(Football.getInstance().getWorld()), 0.5, 100.0, 0.5);

    private RegionManager regionManager;

    public FootballSession() {}

    public void start() {

        simpleTeamMap.registerNewTeam(new SimpleTeam(TeamColor.RED));
        simpleTeamMap.registerNewTeam(new SimpleTeam(TeamColor.BLUE));

        regionManager = WorldGuardPlugin.inst().getRegionManager(Bukkit.getWorld(Football.getInstance().getWorld()));
    }

    public void stop() {

    }
}
