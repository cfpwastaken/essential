package de.cfp.essential.command.time;

import de.cfp.essential.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDNight implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player)sender;
            if (p.hasPermission("essential.night")) {
                p.getWorld().setTime(13000);
                p.sendMessage(Messages.getMessage("time.set").replaceAll("%t", Messages.getMessage("time.night")));
            }
        } else {
            sender.sendMessage(Messages.getMessage("player_only"));
        }

        return true;
    }

}
