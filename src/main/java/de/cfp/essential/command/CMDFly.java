package de.cfp.essential.command;

import de.cfp.essential.Essential;
import de.cfp.essential.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDFly implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(p.hasPermission(Essential.getEssential().getConfig().getString("perm_prefix") + "fly")) {
                if(p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.sendMessage(Messages.getMessage("fly.disabled"));
                } else {
                    p.setAllowFlight(true);
                    p.sendMessage(Messages.getMessage("fly.enabled"));
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
