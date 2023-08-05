package com.github.shin_ideal.killsoundplugin.CommandExecutors;

import com.github.shin_ideal.killsoundplugin.Gui.GuiKillSoundSelector;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillSoundExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player Only!");
            return false;
        }
        Player player = (Player) commandSender;
        GuiKillSoundSelector.OpenGUI(player,0);
        return true;
    }
}
