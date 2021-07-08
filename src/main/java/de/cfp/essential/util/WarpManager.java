package de.cfp.essential.util;

import de.cfp.essential.Essential;
import org.bukkit.Location;

import java.io.IOException;

public class WarpManager {

    public static Location getWarp(String name) {
        return Essential.getWarpConfiguration().getLocation(name);
    }

    public static void createWarp(String name, Location location) {
        Essential.getWarpConfiguration().set(name, location);
        try {
            Essential.getWarpConfiguration().save(Essential.getEssential().getConfig().getString("perm_prefix") + "warp.delete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteWarp(String name) {
        Essential.getWarpConfiguration().set(name, null);
        try {
            Essential.getWarpConfiguration().save(Essential.getEssential().getConfig().getString("perm_prefix") + "warp.delete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
