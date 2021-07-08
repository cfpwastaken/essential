package de.cfp.essential.command;

import de.cfp.essential.Essential;
import de.cfp.essential.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDSpeed implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission(Essential.getEssential().getConfig().getString("perm_prefix") + "speed")) {
                if(args.length == 1) {
                    int speed;
                    try {
                        speed = Integer.parseInt(args[0]);
                    } catch(NumberFormatException ex) {
                        p.sendMessage(Messages.getMessage("usage_prefix") + "/speed <number>");
                        return true;
                    }
                    if(speed < 1 || speed > 10) {
                        p.sendMessage(Messages.getMessage("speed.wrong_number"));
                        return true;
                    }
                    if (p.isFlying()) {
                        p.setFlySpeed((float) speed / 10);
                        p.sendMessage(Messages.getMessage("speed.fly").replaceAll("%s", speed + ""));
                    } else {
                        p.setWalkSpeed((float) speed / 10);
                        p.sendMessage(Messages.getMessage("speed.walk").replaceAll("%s", speed + ""));
                    }
                } else {
                    p.sendMessage(Messages.getMessage("usage_prefix") + "/speed <number>");
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
