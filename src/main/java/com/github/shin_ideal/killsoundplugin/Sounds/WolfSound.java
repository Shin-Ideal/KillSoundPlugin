package com.github.shin_ideal.killsoundplugin.Sounds;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class WolfSound extends KillSound {
    @Override
    public void play(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_WOLF_HOWL, 1, 1);
    }
}
