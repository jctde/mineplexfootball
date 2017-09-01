package de.obdachioser.football.game;

/**
 * package: de.obdachioser.football.game
 * <p>
 * created by ObdachIoser 19:59 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

public abstract class DefinedTeam implements Team {

    private TeamColor teamColor;

    public DefinedTeam(TeamColor teamColor) {
	   this.teamColor = teamColor;
    }
}