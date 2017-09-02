package de.obdachioser.football.projectlisteners;

import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import de.obdachioser.football.events.TeamScoreEvent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * package: de.obdachioser.football.projectlisteners
 * <p>
 * created by ObdachIoser 14:13 on 02.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class TeamScoreListener implements Listener {

    @EventHandler
    public void teamScore(TeamScoreEvent event) {

	   CustomPlayerCache customPlayerCache = Football.getFootballSession().getCustomPlayerCaches().get(event.getPlayer().getUniqueId());

	   event.getScorredTeam().addScore();

	   PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE,
				IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + event.getScorredTeam().getTeamDisplayName()
						  + " §7(§e"+ event.getScorredTeam().getScore() +"§7) §8§l| "
						  + event.getLosedTeam().getTeamDisplayName() + "§7(§e"+event.getLosedTeam().getScore()+"§7)" + "\"}"));

	   PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,
				IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + "§f" + customPlayerCache.getCurrentTeam()
						  .getTeamColor().getColor() + event.getPlayer().getName() + " §7hat für Team "
						  + event.getScorredTeam().getTeamDisplayName() + " §7ein Tor geschossen!" + "\"}"));

	   for(Player player : Bukkit.getOnlinePlayers()) {

		  CustomPlayerCache customPlayerCache0 = Football.getFootballSession().getCustomPlayerCaches().get(player.getUniqueId());
		  if(customPlayerCache0.isIngame()) {

			 ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutTitle);
			 ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutSubTitle);

		      player.playSound(player.getEyeLocation(), Sound.WITHER_DEATH, 1F, 1F);
		  }
	   }
    }
}
