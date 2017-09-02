package de.obdachioser.football.commands;

import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import de.obdachioser.football.game.SimpleTeam;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * package: de.obdachioser.football.commands
 * <p>
 * created by ObdachIoser 20:30 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class TeamCommand extends Command {

    public TeamCommand() {
        super ("team");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] args) {

        if(!(commandSender instanceof Player)) return true;

        if(args.length < 1) {

            commandSender.sendMessage(Football.getPrefix() + "Bitte wähle ein Team aus!");
		  commandSender.sendMessage("§c/team <join|leave> [Rot|Blau]");
		  return true;
	   }

	   if(args.length < 2 && args[0].equalsIgnoreCase("join")) {

            commandSender.sendMessage(Football.getPrefix() + "§cBitte wähle ein Team aus!");
            return true;
	   }

	   if(args[0].equalsIgnoreCase("leave")) {

		  Player player = Bukkit.getPlayer(((Player) commandSender).getUniqueId());
		  CustomPlayerCache customPlayerCache = Football.getFootballSession().getCustomPlayerCaches().get(player.getUniqueId());

		  if(customPlayerCache.isIngame()) {

			 player.sendMessage(Football.getPrefix() + "§cDu kannst im Spiel kein Team wechseln!");
			 return true;
		  }

		  if(customPlayerCache.getCurrentTeam() == null) {

			 commandSender.sendMessage(Football.getPrefix() + "§cDu bist in keinen Team");
			 return true;
		  }

		  customPlayerCache.getCurrentTeam().removePlayer(player);
		  customPlayerCache.setCurrentTeam(null);

		  customPlayerCache.setIngame(false);
		  player.sendMessage(Football.getPrefix() + "Du hast das Spiel verlassen.");
		  return true;

	   } else if(args[0].equalsIgnoreCase("join")) {

		  Player player = Bukkit.getPlayer(((Player) commandSender).getUniqueId());
		  CustomPlayerCache customPlayerCache = Football.getFootballSession().getCustomPlayerCaches().get(player.getUniqueId());

		  if(customPlayerCache.isIngame()) {

			 player.sendMessage(Football.getPrefix() + "§cDu kannst im Spiel kein Team wechseln!");
			 return true;
		  }

		  if(customPlayerCache.getLastTeamSwitchStamp() > System.currentTimeMillis()) {

			 player.sendMessage(Football.getPrefix() + "§cDu kannst nur jede Minute das Team wechseln!");
			 return true;
		  }

		  SimpleTeam simpleTeam = (SimpleTeam) Football.getFootballSession().getSimpleTeamMap().getTeam(args[1].toLowerCase());

		  if(simpleTeam == null) {

			 commandSender.sendMessage(Football.getPrefix() + "§cDas ausgewählte Team exestiert nicht!");
			 return true;
		  }

		  if(simpleTeam.getPlayers().contains(player)) {

			 commandSender.sendMessage(Football.getPrefix() + "§7Du bist bereits Teil von Team " + simpleTeam.getTeamDisplayName() + "§7!");
			 return true;
		  }

		  simpleTeam.addPlayer(player);

		  customPlayerCache.setLastTeamSwitchStamp(System.currentTimeMillis()+(60*1000));
		  customPlayerCache.setCurrentTeam(simpleTeam);

		  player.sendMessage(Football.getPrefix() + "§7Du bist nun in Team " + simpleTeam.getTeamDisplayName() + "§7.");
		  return true;
	   }

	   commandSender.sendMessage(Football.getPrefix() + "Bitte wähle ein Team aus!");
	   commandSender.sendMessage("§c/team <join|leave> [Rot|Blau]");
	   return true;
    }
}