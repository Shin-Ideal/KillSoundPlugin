package com.github.shin_ideal.killsoundplugin.Sounds;

import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class AnvilSound extends KillSound{
    @Override
    public void play(Player player) {
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE,0.5F, 1);
    }
}
