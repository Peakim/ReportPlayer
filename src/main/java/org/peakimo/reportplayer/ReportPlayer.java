package org.peakimo.reportplayer;

import org.bukkit.plugin.java.JavaPlugin;
import org.peakimo.reportplayer.Commands.Report;

public final class ReportPlayer extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("report").setExecutor(new Report());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
