package de.obdachioser.football.game;

import lombok.Getter;

/**
 * package: de.obdachioser.football.game
 * <p>
 * created by ObdachIoser 19:57 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public enum TeamColor {

    RED("Rot", "§cRot", "§c"),
    BLUE("Blau", "§bBlau", "§a");

    @Getter
    private String teamName;

    @Getter
    private String color;

    @Getter
    private String displayName;

    TeamColor(String teamName, String displayName, String color) {
        this.teamName = teamName;
        this.displayName = displayName;
        this.color = color;
    }

}
