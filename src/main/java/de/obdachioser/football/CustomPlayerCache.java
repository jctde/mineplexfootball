package de.obdachioser.football;

import de.obdachioser.football.game.DefinedTeam;
import de.obdachioser.football.game.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * package: de.obdachioser.football
 * <p>
 * created by ObdachIoser 20:01 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */

@Getter @Setter
public class CustomPlayerCache {

    private boolean ingame = false;
    private Team currentTeam = null;
    private Long lastTeamSwitchStamp = System.currentTimeMillis();
    private Long lastmessagestamp = System.currentTimeMillis();
    private Long lastPush = System.currentTimeMillis();
}
