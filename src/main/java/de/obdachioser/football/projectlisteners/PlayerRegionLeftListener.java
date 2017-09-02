package de.obdachioser.football.projectlisteners;

import de.obdachioser.football.CustomPlayerCache;
import de.obdachioser.football.Football;
import de.obdachioser.football.events.worldguard.PlayerRegionLeftEvent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

/**
 * package: de.obdachioser.football.projectlisteners
 * <p>
 * created by ObdachIoser 22:06 on 01.09.2017.
 * Copyright (C) 2017 all rights reserved
 */
public class PlayerRegionLeftListener implements Listener {

    @EventHandler
    public void regionLeft(PlayerRegionLeftEvent event) {

	   CustomPlayerCache customPlayerCache = Football.getFootballSession().getCustomPlayerCaches().get(event.getPlayer().getUniqueId());
	   customPlayerCache.setIngame(false);

	   event.getPlayer().playSound(event.getPlayer().getEyeLocation(), Sound.ITEM_PICKUP, 1F, 1F);

	   event.getPlayer().sendMessage(Football.getPrefix() + "Du hast das §eSpielfeld §7verlassen.");

	   event.getPlayer().getInventory().setArmorContents(new ItemStack[] {null, null, null, null});

	   PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE,
				IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + "§f§lFOOTBALL" + "\"}"));

	   PacketPlayOutTitle packetPlayOutSubTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE,
				IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + "§7Du hast das §eSpielfeld §7verlassen!" + "\"}"));

	   ((CraftPlayer) event.getPlayer()).getHandle().playerConnection.sendPacket(packetPlayOutTitle);
	   ((CraftPlayer) event.getPlayer()).getHandle().playerConnection.sendPacket(packetPlayOutSubTitle);
    }
}