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
        SetGUIIcon(Material.BONE,"Wolf",Arrays.asList("あおーん"),0,9);
        //Goat Horn
        SetGUIIcon(Material.GOAT_HORN,"Goat Horn",Arrays.asList("ふぁふぁふぁふぁーん"),0,10);
        //Egg
        SetGUIIcon(Material.EGG,"Egg",Arrays.asList("ぽっ"),0,11);
        //Anvil
        SetGUIIcon(Material.ANVIL,"Anvil",Arrays.asList("Nexusを削った音ではない"),0,12);
        //Burp
        SetGUIIcon(Material.COOKED_CHICKEN,"Burp",Arrays.asList("げー"),0,13);
    }

    private static void SetGUIIcon(Material iconMaterial, String displayName, List<String> lore,int page,int index){
        ItemStack icon = new ItemStack(iconMaterial);
        ItemMeta icon_meta = icon.getItemMeta();
        icon_meta.setDisplayName(displayName);
        icon_meta.setLore(lore);
        icon.setItemMeta(icon_meta);
        arrayInventory[page].setItem(index, icon);
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
