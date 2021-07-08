package de.cfp.essential.command;

import de.cfp.essential.Essential;
import de.cfp.essential.Messages;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDGamemode implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission(Essential.getEssential().getConfig().getString("perm_prefix") + "gm")) {

                if(args.length == 1) {
                    String gm = args[0];

                    if(gm.equalsIgnoreCase("0") || gm.equalsIgnoreCase("s") || gm.equalsIgnoreCase("survival")) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Messages.getMessage("gamemode.switched").replaceAll("%g", Messages.getMessage("gamemode.survival")));
                    } else if(gm.equalsIgnoreCase("1") || gm.equalsIgnoreCase("c") || gm.equalsIgnoreCase("creative")) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Messages.getMessage("gamemode.switched").replaceAll("%g", Messages.getMessage("gamemode.creative")));
                    } else if(gm.equalsIgnoreCase("2") || gm.equalsIgnoreCase("a") || gm.equalsIgnoreCase("adventure")) {
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(Messages.getMessage("gamemode.switched").replaceAll("%g", Messages.getMessage("gamemode.adventure")));
                    } else if(gm.equalsIgnoreCase("3") || gm.equalsIgnoreCase("sp") || gm.equalsIgnoreCase("spectator")) {
                        p.setGameMode(GameMode.SPECTATOR);
                        p.sendMessage(Messages.getMessage("gamemode.switched").replaceAll("%g", Messages.getMessage("gamemode.spectator")));
                    } else if(gm.equalsIgnoreCase("4")) {
                        p.sendMessage(Messages.getMessage("nuclear_bomb"));
                    } else {
                        p.sendMessage(Messages.getMessage("gamemode.invalid"));
                    }
                } else {
                    p.sendMessage(Messages.getMessage("usage_prefix") + "/gm <gamemode>");
                }

            } else {
                p.sendMessage(Messages.getMessage("no_perm"));
            }
        } else {
            sender.sendMessage(Messages.getMessage("player_only"));
        }

        return true;
    }

}
