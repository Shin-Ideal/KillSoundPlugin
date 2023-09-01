package com.github.shin_ideal.killsoundplugin.Listeners;

import com.github.shin_ideal.killsoundplugin.Gui.GuiKillSoundSelector;
import com.github.shin_ideal.killsoundplugin.Manager.KillSoundManager;
import com.github.shin_ideal.killsoundplugin.Sounds.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class GuiClickListener implements Listener {
    @EventHandler
    public void onGuiClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getView().getTopInventory();
        if (GuiKillSoundSelector.getGUIPage(inventory) < 0) {
            return;
        }
        event.setCancelled(true);

        if (event.getCurrentItem() == null || event.getCurrentItem().getItemMeta() == null || event.getCurrentItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        String string = event.getCurrentItem().getItemMeta().getDisplayName();
        switch (string) {
            case "None":
                KillSoundManager.setKillSound(player.getUniqueId(), null);
                player.sendMessage(ChatColor.DARK_GREEN + "Select None");
                break;
            case "Previous Page":
                int previousPage = GuiKillSoundSelector.getGUIPage(inventory) > 0 ? GuiKillSoundSelector.getGUIPage(inventory) - 1 : GuiKillSoundSelector.getArrayInventory().length - 1;
                player.openInventory(GuiKillSoundSelector.getArrayInventory()[previousPage]);
                break;
            case "Next Page":
                int nextPage = GuiKillSoundSelector.getGUIPage(inventory) < GuiKillSoundSelector.getArrayInventory().length - 1 ? GuiKillSoundSelector.getGUIPage(inventory) + 1 : 0;
                player.openInventory(GuiKillSoundSelector.getArrayInventory()[nextPage]);
                break;

            //KillSounds
            case "Wolf":
                if (playerHasPermission(player, "Wolf")) {
                    KillSoundManager.setKillSound(player.getUniqueId(), new WolfSound());
                    player.sendMessage(ChatColor.DARK_GREEN + "Select Wolf");
                }
                break;
            case "Goat Horn":
                if (playerHasPermission(player, "GoatHorn")) {
                    KillSoundManager.setKillSound(player.getUniqueId(), new GoatHornSound());
                    player.sendMessage(ChatColor.DARK_GREEN + "Select Goat Horn");
                }
                break;
            case "Egg":
                if (playerHasPermission(player, "Egg")) {
                    KillSoundManager.setKillSound(player.getUniqueId(), new EggSound());
                    player.sendMessage(ChatColor.DARK_GREEN + "Select Egg");
                }
                break;
            case "Anvil":
                if (playerHasPermission(player, "Anvil")) {
                    KillSoundManager.setKillSound(player.getUniqueId(), new AnvilSound());
                    player.sendMessage(ChatColor.DARK_GREEN + "Select Anvil");
                }
                break;
            case "Burp":
                if (playerHasPermission(player, "Burp")) {
                    KillSoundManager.setKillSound(player.getUniqueId(), new BurpSound());
                    player.sendMessage(ChatColor.DARK_GREEN + "Select Burp");
                }
                break;
            default:
                break;
        }

    }

    private boolean playerHasPermission(Player player, String permission) {
        if (player.hasPermission("KillSoundPlugin.sound.*") || player.hasPermission("KillSoundPlugin.sound." + permission)) {
            return true;
        } else {
            player.sendMessage(ChatColor.RED + "You don't have permission");
            return false;
        }
    }
}
