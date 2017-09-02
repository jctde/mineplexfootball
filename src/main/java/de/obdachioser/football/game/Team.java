package de.obdachioser.football.game;

import org.bukkit.entity.Player;

import java.util.List;

/**
 * package: de.obdachioser.football.game
 * <p>
 * created by ObdachIoser 19:56 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public interface Team {

    List<Player> getPlayers();
    void addPlayer(Player player);
    void removePlayer(Player player);
    String getTeamDisplayName();
    void setTeamDisplayName(String displayName);
    String getTeamName();
    TeamColor getTeamColor();
    void addScore();
    Integer getScore();
}
