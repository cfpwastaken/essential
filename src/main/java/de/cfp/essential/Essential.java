package de.cfp.essential;

import de.cfp.essential.command.money.CMDBalTop;
import de.cfp.essential.command.money.CMDEco;
import de.cfp.essential.command.money.CMDMoney;
import de.cfp.essential.command.money.CMDPay;
import de.cfp.essential.command.time.CMDDay;
import de.cfp.essential.command.time.CMDMidday;
import de.cfp.essential.command.time.CMDMidnight;
import de.cfp.essential.command.time.CMDNight;
import de.cfp.essential.command.warp.CMDCreateWarp;
import de.cfp.essential.command.warp.CMDDeleteWarp;
import de.cfp.essential.command.CMDFly;
import de.cfp.essential.command.CMDGamemode;
import de.cfp.essential.command.CMDSpeed;
import de.cfp.essential.command.warp.CMDWarp;
import de.cfp.essential.tab.TabCompleteGamemode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Essential extends JavaPlugin {

    public static YamlConfiguration warpConfiguration;
    public static YamlConfiguration moneyConfiguration;
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

        getCommand("day").setExecutor(new CMDDay());
        getCommand("night").setExecutor(new CMDNight());
        getCommand("midday").setExecutor(new CMDMidday());
        getCommand("noon").setExecutor(new CMDMidday());
        getCommand("midnight").setExecutor(new CMDMidnight());
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

    public static YamlConfiguration getMoneyConfiguration() {
        return moneyConfiguration;
    }

}
