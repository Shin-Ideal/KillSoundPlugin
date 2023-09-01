package com.github.shin_ideal.killsoundplugin.Manager;

import com.github.shin_ideal.killsoundplugin.Sounds.KillSound;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class KillSoundManager {
    private static Map<UUID, KillSound> killSoundMap = new HashMap<>();

    public static void setKillSound(UUID uuid, KillSound killSound) {
        killSoundMap.put(uuid, killSound);
    }

    public static KillSound getKillSound(UUID uuid) {
        return killSoundMap.get(uuid);
    }

    public static Map<UUID, KillSound> getKillSoundMap() {
        return killSoundMap;
    }
}
