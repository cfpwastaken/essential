package de.cfp.essential.util;

import de.cfp.essential.Essential;
import org.bukkit.Location;

import java.io.File;
import java.io.IOException;

public class WarpManager {

    public static Location getWarp(String name) {
        return Essential.getWarpConfiguration().getLocation(name);
    }

    public static void createWarp(String name, Location location) {
        Essential.getWarpConfiguration().set(name, location);
        try {
            Essential.getWarpConfiguration().save(new File(Essential.getEssential().getDataFolder(), "warps.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteWarp(String name) {
        Essential.getWarpConfiguration().set(name, null);
        try {
            Essential.getWarpConfiguration().save(new File(Essential.getEssential().getDataFolder(), "warps.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
