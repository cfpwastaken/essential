package de.cfp.essential.command.warp;

import de.cfp.essential.Essential;
import de.cfp.essential.Messages;
import de.cfp.essential.util.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDWarp implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(p.hasPermission(Essential.getEssential().getConfig().getString("perm_prefix") + "warp")) {
                if (args.length == 1) {

                    if (WarpManager.getWarp(args[0]) != null) {
                        p.teleport(WarpManager.getWarp(args[0]));
                        p.sendMessage(Messages.getMessage("teleported"));
                    } else {
                        p.sendMessage(Messages.getMessage("warp.doesnt_exist"));
                    }

                } else {
                    p.sendMessage(Messages.getMessage("usage_prefix") + "/warp <warp>");
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
