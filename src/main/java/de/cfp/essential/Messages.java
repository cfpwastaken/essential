package de.cfp.essential;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Messages {

    private static FileConfiguration messages;

    public static String getMessage(String message) {
        return messages.getString(message);
    }

    public static void loadMessages() {
        File langFolder = new File(Essential.getEssential().getDataFolder() + "/lang");
        if(!langFolder.exists()) {
            langFolder.mkdir();
        }
        copyLanguage(langFolder);

        File langFile = new File(langFolder, Essential.getEssential().getConfig().getString("lang") + ".yml");

        messages = YamlConfiguration.loadConfiguration(langFile);
    }

    private static void copyLanguage(File langFolder) {
        File enFile = new File(langFolder, "en.yml");
        try {
            if(!enFile.exists()) {
                InputStream in = Essential.getEssential().getResource("en.yml");
                Files.copy(in, enFile.toPath());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        File deFile = new File(langFolder, "de.yml");
        try {
            if(!deFile.exists()) {
                InputStream in = Essential.getEssential().getResource("de.yml");
                Files.copy(in, deFile.toPath());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}
