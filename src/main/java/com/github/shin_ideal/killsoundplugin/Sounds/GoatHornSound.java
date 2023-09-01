package com.github.shin_ideal.killsoundplugin.Sounds;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GoatHornSound extends KillSound {
    @Override
    public void play(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.ITEM_GOAT_HORN_SOUND_2, 1, 1);
    }
}
