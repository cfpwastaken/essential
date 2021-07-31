package de.cfp.essential.util;

import de.cfp.essential.Essential;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MoneyManager {

    public static double getMoney(UUID uuid) {
        return Essential.getMoneyConfiguration().getDouble(uuid.toString());
    }

    public static void setMoney(UUID uuid, double money) {
        Essential.getMoneyConfiguration().set(uuid.toString(), money);
        try {
            Essential.getMoneyConfiguration().save(new File(Essential.getEssential().getDataFolder(), "money.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMoney(UUID uuid, double amount) {
        Essential.getMoneyConfiguration().set(uuid.toString(), getMoney(uuid) + amount);
        try {
            Essential.getMoneyConfiguration().save(new File(Essential.getEssential().getDataFolder(), "money.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeMoney(UUID uuid, double amount) {
        Essential.getMoneyConfiguration().set(uuid.toString(), getMoney(uuid) - amount);
        try {
            Essential.getMoneyConfiguration().save(new File(Essential.getEssential().getDataFolder(), "money.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCurrency() {
        return Essential.getEssential().getConfig().getString("money.currency");
    }

    public static double getStarterMoney() {
        return Essential.getEssential().getConfig().getDouble("money.starter");
    }

    public static boolean hasEnoughMoney(UUID uuid, double amount) {
        return getMoney(uuid) >= amount;
    }

    public static boolean hasMoney(UUID uuid) {
        return Essential.getMoneyConfiguration().contains(uuid.toString());
    }

}
