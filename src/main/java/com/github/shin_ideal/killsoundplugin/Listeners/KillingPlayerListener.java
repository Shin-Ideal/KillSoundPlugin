package com.github.shin_ideal.killsoundplugin.Listeners;

import com.github.shin_ideal.killsoundplugin.Manager.KillSoundManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillingPlayerListener implements Listener {
    @EventHandler
    public void onKill(PlayerDeathEvent event){
        Player player = event.getEntity();
        if(player.getKiller()==null){
            return;
        }
        Player killer = player.getKiller();
        if(KillSoundManager.GetKillSound(killer.getUniqueId())==null) {
            return;
        }
        KillSoundManager.GetKillSound(killer.getUniqueId()).play(player);
    }
}
