package com.github.shin_ideal.killsoundplugin.Sounds;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class BurpSound extends KillSound{
    @Override
    public void play(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP,1,1);
    }
}
