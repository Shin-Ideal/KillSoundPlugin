package com.github.shin_ideal.killsoundplugin.Gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class GuiKillSoundSelector {
    private final static int GUIMAXPAGE = 1;
    private static Inventory[] arrayInventory;

    static {
        arrayInventory = new Inventory[GUIMAXPAGE];
        for (int page = 0; page < arrayInventory.length; page++) {
            arrayInventory[page] = Bukkit.createInventory(null, 54, "KillSound " + (page + 1) + "/" + GUIMAXPAGE);
            Inventory inventory = arrayInventory[page];

            for (int i = 0; i < inventory.getSize(); i++) {
                if (i < 9 || 44 < i) {
                    if (i == 4) {
                        setGUIIcon(Material.BARRIER, "None", Arrays.asList("No Effect"), page, i);
                    } else if (i == 45) {
                        setGUIIcon(Material.GREEN_STAINED_GLASS, "Previous Page", Arrays.asList(""), page, i);
                    } else if (i == 53) {
                        setGUIIcon(Material.GREEN_STAINED_GLASS, "Next Page", Arrays.asList(""), page, i);
                    } else {
                        setGUIIcon(Material.GRAY_STAINED_GLASS_PANE, " ", Arrays.asList(""), page, i);
                    }
                }
            }
        }

        //Wolf
        setGUIIcon(Material.BONE, "Wolf", Arrays.asList("あおーん"), 0, 9);
        //Goat Horn
        setGUIIcon(Material.GOAT_HORN, "Goat Horn", Arrays.asList("ふぁふぁふぁふぁーん"), 0, 10);
        //Egg
        setGUIIcon(Material.EGG, "Egg", Arrays.asList("ぽっ"), 0, 11);
        //Anvil
        setGUIIcon(Material.ANVIL, "Anvil", Arrays.asList("Nexusを削った音ではない"), 0, 12);
        //Burp
        setGUIIcon(Material.COOKED_CHICKEN, "Burp", Arrays.asList("げー"), 0, 13);
    }

    private static void setGUIIcon(Material iconMaterial, String displayName, List<String> lore, int page, int index) {
        ItemStack icon = new ItemStack(iconMaterial);
        ItemMeta icon_meta = icon.getItemMeta();
        icon_meta.setDisplayName(displayName);
        icon_meta.setLore(lore);
        icon.setItemMeta(icon_meta);
        arrayInventory[page].setItem(index, icon);
    }

    public static void openGUI(Player player, int page) {
        player.openInventory(arrayInventory[page]);
    }

    public static Inventory[] getArrayInventory() {
        return arrayInventory;
    }

    public static int getGUIPage(Inventory checkInventory) {
        int i = 0;
        for (Inventory inventory : arrayInventory) {
            if (checkInventory == inventory) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
