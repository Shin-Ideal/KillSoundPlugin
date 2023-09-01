package com.github.shin_ideal.killsoundplugin;

import com.github.shin_ideal.killsoundplugin.CommandExecutors.KillSoundExecutor;
import com.github.shin_ideal.killsoundplugin.Listeners.GuiClickListener;
import com.github.shin_ideal.killsoundplugin.Listeners.KillingPlayerListener;
import com.github.shin_ideal.killsoundplugin.Manager.KillSoundManager;
import com.github.shin_ideal.killsoundplugin.Sounds.KillSound;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public final class KillSoundPlugin extends JavaPlugin {

    private static KillSoundPlugin instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Enable");
        instance = this;
        saveDefaultConfig();

        try {
            loadConfigData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        loadListeners();
        loadCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        saveConfigData();
        getLogger().info("Disable");
    }

    private void loadConfigData() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (getConfig().getConfigurationSection("Data") == null) {
            return;
        }
        for (String stringUuid : getConfig().getConfigurationSection("Data").getKeys(false)) {
            KillSound killSound = (KillSound) Class.forName(getConfig().getString("Data." + stringUuid)).getDeclaredConstructor().newInstance();
            KillSoundManager.setKillSound(UUID.fromString(stringUuid), killSound);
        }
    }

    private void saveConfigData() {
        for (UUID uuid : KillSoundManager.getKillSoundMap().keySet()) {
            String killSoundName = KillSoundManager.getKillSound(uuid).getClass().getName();
            getConfig().set("Data." + uuid, killSoundName);
        }
        saveConfig();
    }

    private void loadListeners() {
        getServer().getPluginManager().registerEvents(new KillingPlayerListener(), this);
        getServer().getPluginManager().registerEvents(new GuiClickListener(), this);
    }

    private void loadCommands() {
        getCommand("killsound").setExecutor(new KillSoundExecutor());
    }

    public static KillSoundPlugin getInstance() {
        return instance;
    }
}
