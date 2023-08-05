package com.github.shin_ideal.killsoundplugin.Gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class GuiKillSoundSelector {
    private final static int GUIMAXPAGE = 1;
    private static Inventory[] arrayInventory;

    static {
        arrayInventory = new Inventory[GUIMAXPAGE];
        for(int page = 0; page < arrayInventory.length; page++) {
            arrayInventory[page] = Bukkit.createInventory(null, 54, "KillSound "+(page+1)+"/"+GUIMAXPAGE);
            Inventory inventory = arrayInventory[page];

            for (int i = 0; i < inventory.getSize(); i++) {
                if (i < 9 || 44 < i) {
                    if (i == 4) {
                        ItemStack icon = new ItemStack(Material.BARRIER);
                        ItemMeta icon_meta = icon.getItemMeta();
                        icon_meta.setDisplayName("None");
                        icon_meta.setLore(Arrays.asList("No Effect"));
                        icon.setItemMeta(icon_meta);
                        inventory.setItem(i, icon);
                    } else if (i == 45) {
                        ItemStack icon = new ItemStack(Material.GREEN_STAINED_GLASS);
                        ItemMeta icon_meta = icon.getItemMeta();
                        icon_meta.setDisplayName("Previous Page");
                        icon.setItemMeta(icon_meta);
                        inventory.setItem(i, icon);
                    } else if (i == 53) {
                        ItemStack icon = new ItemStack(Material.GREEN_STAINED_GLASS);
                        ItemMeta icon_meta = icon.getItemMeta();
                        icon_meta.setDisplayName("Next Page");
                        icon.setItemMeta(icon_meta);
                        inventory.setItem(i, icon);
                    } else {
                        ItemStack icon = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemMeta icon_meta = icon.getItemMeta();
                        icon_meta.setDisplayName(" ");
                        icon.setItemMeta(icon_meta);
                        inventory.setItem(i, icon);
                    }
                }
            }
        }

        //Wolf
        {
            ItemStack icon = new ItemStack(Material.BONE);
            ItemMeta icon_meta = icon.getItemMeta();
            icon_meta.setDisplayName("Wolf");
            icon_meta.setLore(Arrays.asList("あおーん"));
            icon.setItemMeta(icon_meta);
            arrayInventory[0].setItem(9, icon);
        }
        //Goat Horn
        {
            ItemStack icon = new ItemStack(Material.GOAT_HORN);
            ItemMeta icon_meta = icon.getItemMeta();
            icon_meta.setDisplayName("Goat Horn");
            icon_meta.setLore(Arrays.asList("ふぁふぁふぁふぁーん"));
            icon.setItemMeta(icon_meta);
            arrayInventory[0].setItem(10, icon);
        }
        //Egg
        {
            ItemStack icon = new ItemStack(Material.EGG);
            ItemMeta icon_meta = icon.getItemMeta();
            icon_meta.setDisplayName("Egg");
            icon_meta.setLore(Arrays.asList("ぽっ"));
            icon.setItemMeta(icon_meta);
            arrayInventory[0].setItem(11, icon);
        }
        //Anvil
        {
            ItemStack icon = new ItemStack(Material.ANVIL);
            ItemMeta icon_meta = icon.getItemMeta();
            icon_meta.setDisplayName("Anvil");
            icon_meta.setLore(Arrays.asList("Nexusを削った音ではない"));
            icon.setItemMeta(icon_meta);
            arrayInventory[0].setItem(12, icon);
        }
        //Burp
        {
            ItemStack icon = new ItemStack(Material.COOKED_CHICKEN);
            ItemMeta icon_meta = icon.getItemMeta();
            icon_meta.setDisplayName("Burp");
            icon_meta.setLore(Arrays.asList("げー"));
            icon.setItemMeta(icon_meta);
            arrayInventory[0].setItem(13, icon);
        }
    }

    public static void OpenGUI(Player player,int page){
        player.openInventory(arrayInventory[page]);
    }

    public static Inventory[] getArrayInventory(){
        return arrayInventory;
    }

    public static int GetGUIPage(Inventory checkInventory){
        int i=0;
        for(Inventory inventory: arrayInventory){
            if(checkInventory==inventory){
                return i;
            }
            i++;
        }
        return -1;
    }
}
