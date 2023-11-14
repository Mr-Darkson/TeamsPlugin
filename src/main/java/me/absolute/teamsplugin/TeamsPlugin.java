package me.absolute.teamsplugin;

import me.absolute.teamsplugin.commands.TeamCMD;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeamsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("tms").setExecutor(new TeamCMD());
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
