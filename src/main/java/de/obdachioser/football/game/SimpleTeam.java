package de.obdachioser.football.game;

import com.google.common.collect.Lists;
import de.obdachioser.football.events.PlayerTeamJoinEvent;
import de.obdachioser.football.events.PlayerTeamQuitEvent;
import de.obdachioser.football.utils.ItemStackCreator;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * package: de.obdachioser.football.game
 * <p>
 * created by ObdachIoser 20:14 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class SimpleTeam extends DefinedTeam {

    private List<Player> playerList = Lists.newCopyOnWriteArrayList();

    private int scores = 0;

    @Getter
    private ItemStack[] armorContent;

    private TeamColor teamColor;

    public SimpleTeam(TeamColor teamColor) {
        super (teamColor);
        this.teamColor = teamColor;

        armorContent = new ItemStack[] {
                    ItemStackCreator.d(Material.LEATHER_BOOTS, teamColor, " "),
                    ItemStackCreator.d(Material.LEATHER_LEGGINGS, teamColor, " "),
                    ItemStackCreator.d(Material.LEATHER_CHESTPLATE, teamColor, " "), null};
    }

    @Override
    public List<Player> getPlayers() {
	   return playerList;
    }

    @Override
    public void removePlayer(Player player) {

        playerList.remove(player);
        Bukkit.getPluginManager().callEvent(new PlayerTeamQuitEvent(player, this));
    }

    @Override
    public void addPlayer(Player player) {

        playerList.add(player);
        Bukkit.getPluginManager().callEvent(new PlayerTeamJoinEvent(player, this));
    }

    @Override
    public String getTeamDisplayName() {
	   return getTeamColor().getDisplayName();
    }

    @Override
    public String getTeamName() {
	   return teamColor.getTeamName().toLowerCase();
    }

    @Override
    public TeamColor getTeamColor() {
	   return teamColor;
    }

    @Override
    public void setTeamDisplayName(String displayName) {}

    @Override
    public void addScore() {
        scores++;
    }

    @Override
    public Integer getScore() {
        return scores;
    }

    public void r() {
        scores = 0;
    }
}
