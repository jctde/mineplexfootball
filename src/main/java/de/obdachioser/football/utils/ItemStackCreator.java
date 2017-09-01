package de.obdachioser.football.utils;

import com.google.common.collect.Lists;
import de.obdachioser.football.game.TeamColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * package: de.obdachioser.football
 * <p>
 * created by ObdachIoser 19:47 on 25.08.2017.
 * Copyright (C) 2017 all rights reserved
 */

public class ItemStackCreator {

    public static ItemStack a(Material material, String name) {

        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(name);

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack f(String owner, String name) {

        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();

        itemMeta.setOwner(owner);
        itemMeta.setDisplayName(name);

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;

    }

    public static ItemStack a(Material material, String name, String[] lore) {

        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(name);
        itemMeta.setLore(Lists.newArrayList(lore));

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack a(Material material, Short s, String name, String[] lore) {

        ItemStack itemStack = new ItemStack(material, 1, s);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(name);
        itemMeta.setLore(Lists.newArrayList(lore));

        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }

    public static ItemStack a(Material material, Integer i) {
        return new ItemStack(material, i);
    }

    public static ItemStack b(ItemStack itemStack, String name) {

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack b(ItemStack itemStack, String[] lore) {

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(Lists.newArrayList(lore));

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack c() {

        ItemStack itemStack = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("§c");

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack d(Material material, TeamColor teamColor, String name) {

        ItemStack itemStack = new ItemStack(material);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();

        Color color = null;

        if(teamColor == TeamColor.RED) color = Color.RED;
        if(teamColor == TeamColor.BLUE) color = Color.BLUE;

        leatherArmorMeta.setColor(color);
        leatherArmorMeta.setDisplayName(name);

        itemStack.setItemMeta(leatherArmorMeta);
        return itemStack;
    }

    public static ItemStack d(Material material, TeamColor teamColor) {

        Short id = 0;

        if(teamColor == TeamColor.RED) id = 14;
        else if(teamColor == TeamColor.BLUE) id = 11;

        return new ItemStack(material, 1, id);
    }
}