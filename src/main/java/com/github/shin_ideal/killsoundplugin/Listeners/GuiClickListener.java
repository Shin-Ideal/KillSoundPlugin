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
    public void onGuiClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = event.getView().getTopInventory();
        if(GuiKillSoundSelector.GetGUIPage(inventory)<0){
            return;
        }
        event.setCancelled(true);

        if(event.getCurrentItem()==null||event.getCurrentItem().getItemMeta()==null||event.getCurrentItem().getItemMeta().getDisplayName()==null){
            return;
        }
        String string = event.getCurrentItem().getItemMeta().getDisplayName();
        switch (string){
            case "None":
                KillSoundManager.SetKillSound(player.getUniqueId(),null);
                player.sendMessage(ChatColor.DARK_GREEN+"Select None");
                break;
            case "Previous Page":
                int previousPage = GuiKillSoundSelector.GetGUIPage(inventory)>0?GuiKillSoundSelector.GetGUIPage(inventory)-1:GuiKillSoundSelector.getArrayInventory().length-1;
                player.openInventory(GuiKillSoundSelector.getArrayInventory()[previousPage]);
                break;
            case "Next Page":
                int nextPage = GuiKillSoundSelector.GetGUIPage(inventory)<GuiKillSoundSelector.getArrayInventory().length-1?GuiKillSoundSelector.GetGUIPage(inventory)+1:0;
                player.openInventory(GuiKillSoundSelector.getArrayInventory()[nextPage]);
                break;

            //KillSounds
            case "Wolf":
                if(PlayerHasPermission(player,"Wolf")) {
                    KillSoundManager.SetKillSound(player.getUniqueId(), new WolfSound());
                    player.sendMessage(ChatColor.DARK_GREEN+"Select Wolf");
                }
                break;
            case "Goat Horn":
                if(PlayerHasPermission(player,"GoatHorn")) {
                    KillSoundManager.SetKillSound(player.getUniqueId(), new GoatHornSound());
                    player.sendMessage(ChatColor.DARK_GREEN+"Select Goat Horn");
                }
                break;
            case "Egg":
                if(PlayerHasPermission(player,"Egg")) {
                    KillSoundManager.SetKillSound(player.getUniqueId(), new EggSound());
                    player.sendMessage(ChatColor.DARK_GREEN+"Select Egg");
                }
                break;
            case "Anvil":
                if(PlayerHasPermission(player,"Anvil")) {
                    KillSoundManager.SetKillSound(player.getUniqueId(), new AnvilSound());
                    player.sendMessage(ChatColor.DARK_GREEN+"Select Anvil");
                }
                break;
            case "Burp":
                if(PlayerHasPermission(player,"Burp")) {
                    KillSoundManager.SetKillSound(player.getUniqueId(), new BurpSound());
                    player.sendMessage(ChatColor.DARK_GREEN+"Select Burp");
                }
                break;
            default:
                break;
        }

    }

    private boolean PlayerHasPermission(Player player, String permission){
        if(player.hasPermission("KillSoundPlugin.sound.*")||player.hasPermission("KillSoundPlugin.sound."+permission)){
            return true;
        }else {
            player.sendMessage(ChatColor.RED +"You don't have permission");
            return false;
        }
    }
}
