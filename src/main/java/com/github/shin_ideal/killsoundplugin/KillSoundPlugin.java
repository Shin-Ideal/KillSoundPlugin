package com.github.shin_ideal.killsoundplugin;

import com.github.shin_ideal.killsoundplugin.CommandExecutors.KillSoundExecutor;
import com.github.shin_ideal.killsoundplugin.Listeners.GuiClickListener;
import com.github.shin_ideal.killsoundplugin.Listeners.KillingPlayerListener;
import com.github.shin_ideal.killsoundplugin.Manager.KillSoundManager;
import com.github.shin_ideal.killsoundplugin.Sounds.KillSound;
import org.bukkit.entity.Player;
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
            Load_Config();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Load_Listeners();
        Load_Commands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Save_Config();
        getLogger().info("Disable");
    }

    private void Load_Config() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if(getConfig().getConfigurationSection("Data")==null){
            return;
        }
        for(String stringUuid:getConfig().getConfigurationSection("Data").getKeys(false)){
            KillSound killSound = (KillSound) Class.forName(getConfig().getString("Data."+stringUuid)).getDeclaredConstructor().newInstance();
            KillSoundManager.SetKillSound(UUID.fromString(stringUuid), killSound);
        }
    }

    private void Save_Config(){
        for(UUID uuid:KillSoundManager.GetKillSoundMap().keySet()){
            Player player = (Player) getServer().getOfflinePlayer(uuid);
            String killSoundName = KillSoundManager.GetKillSound(player).getClass().getName();
            getConfig().set("Data."+ uuid, killSoundName);
        }
        saveConfig();
    }

    private void Load_Listeners() {
        getServer().getPluginManager().registerEvents(new KillingPlayerListener(),this);
        getServer().getPluginManager().registerEvents(new GuiClickListener(),this);
    }

    private void Load_Commands() {
        getCommand("killsound").setExecutor(new KillSoundExecutor());
    }

    public static KillSoundPlugin getInstance(){
        return instance;
    }
}
