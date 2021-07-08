package de.cfp.essential;

import de.cfp.essential.command.CMDCreateWarp;
import de.cfp.essential.command.CMDDeleteWarp;
import de.cfp.essential.command.CMDFly;
import de.cfp.essential.command.CMDGamemode;
import de.cfp.essential.command.CMDSpeed;
import de.cfp.essential.command.CMDWarp;
import de.cfp.essential.tab.TabCompleteGamemode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Essential extends JavaPlugin {

    public static YamlConfiguration warpConfiguration;
    private static Essential instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        loadConfig();
        Messages.loadMessages();
        warpConfiguration = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "warps.yml"));
        try {
            warpConfiguration.save(new File(getDataFolder(), "warps.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        getCommand("gm").setExecutor(new CMDGamemode());
        getCommand("gm").setTabCompleter(new TabCompleteGamemode());

        getCommand("warp").setExecutor(new CMDWarp());
        getCommand("createwarp").setExecutor(new CMDCreateWarp());
        getCommand("delwarp").setExecutor(new CMDDeleteWarp());

        getCommand("fly").setExecutor(new CMDFly());

        getCommand("speed").setExecutor(new CMDSpeed());
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static YamlConfiguration getWarpConfiguration() {
        return warpConfiguration;
    }

    public static Essential getEssential() {
        return instance;
    }
}
