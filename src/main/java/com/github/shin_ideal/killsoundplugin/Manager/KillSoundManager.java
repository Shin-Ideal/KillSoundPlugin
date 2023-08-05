package com.github.shin_ideal.killsoundplugin.Manager;

import com.github.shin_ideal.killsoundplugin.Sounds.KillSound;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KillSoundManager {
    private static Map<UUID, KillSound> killSoundMap = new HashMap<>();

    public static void SetKillSound(Player player,KillSound killSound){
        killSoundMap.put(player.getUniqueId(),killSound);
    }

    public static KillSound GetKillSound(Player player){
        return  killSoundMap.get(player.getUniqueId());
    }

    public static Map<UUID,KillSound> GetKillSoundMap(){
        return killSoundMap;
    }
}
