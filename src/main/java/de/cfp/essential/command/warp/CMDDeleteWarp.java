package de.cfp.essential.command.warp;

import de.cfp.essential.Essential;
import de.cfp.essential.Messages;
import de.cfp.essential.util.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDDeleteWarp implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 1) {
                if(p.hasPermission(Essential.getEssential().getConfig().getString("perm_prefix") + "warp.delete")) {

                    if (WarpManager.getWarp(args[0]) != null) {
                        WarpManager.deleteWarp(args[0]);
                        p.sendMessage(Messages.getMessage("warp.deleted"));
                    } else {
                        p.sendMessage(Messages.getMessage("warp.doesnt_exist"));
                    }

                } else {
                    p.sendMessage(Messages.getMessage("no_perm"));
                    return true;
                }
            } else {
                p.sendMessage(Messages.getMessage("usage_prefix") + "/delwarp <warp>");
            }
        } else {
            sender.sendMessage(Messages.getMessage("player_only"));
        }

        return true;
    }

}
