package com.github.shin_ideal.killsoundplugin.Sounds;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class EggSound extends KillSound {
    @Override
    public void play(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CHICKEN_EGG, 2, 1);
    }
}
