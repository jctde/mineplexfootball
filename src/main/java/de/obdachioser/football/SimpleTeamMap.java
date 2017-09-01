package de.obdachioser.football;

import com.google.common.collect.Maps;
import de.obdachioser.football.game.Team;

import java.util.HashMap;

/**
 * package: de.obdachioser.football
 * <p>
 * created by ObdachIoser 20:00 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class SimpleTeamMap {

    private HashMap<String, Team> teamHashMap = Maps.newHashMap();

    public void registerNewTeam(Team team) {

        if(team == null) throw new NullPointerException("Team is null");
        if(teamHashMap.containsKey(team.getTeamName())) return;

	   teamHashMap.put(team.getTeamName(), team);
    }

    public void unregisterTeam(String teamName) {

	   if(teamName == null) throw new NullPointerException("TeamName is null");
	   if(!teamHashMap.containsKey(teamName)) return;

	   teamHashMap.remove(teamName);
    }

    public Team getTeam(String name) {
	   return teamHashMap.getOrDefault(name, null);
    }
}