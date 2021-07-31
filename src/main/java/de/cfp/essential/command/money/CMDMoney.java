package de.cfp.essential.command.money;

import de.cfp.essential.Essential;
import de.cfp.essential.Messages;
import de.cfp.essential.util.MoneyManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDMoney implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            Player p = (Player)sender;
            if(args.length == 0) {
                if (p.hasPermission(Essential.getEssential().getConfig().getString("perm_prefix") + "money")) {
                    p.sendMessage(Messages.getMessage("money.myself").replaceAll("%a", "" + MoneyManager.getMoney(p.getUniqueId())).replaceAll("%c", MoneyManager.getCurrency()));
                } else {
                    p.sendMessage(Messages.getMessage("no_perm"));
                }
            } else if(args.length == 1) {
                if (p.hasPermission(Essential.getEssential().getConfig().getString("perm_prefix") + "money.others")) {
                    p.sendMessage(Messages.getMessage("money.others").replaceAll("%p", args[0]).replaceAll("%a", "" + MoneyManager.getMoney(p.getUniqueId())).replaceAll("%c", MoneyManager.getCurrency()));
                } else {
                    p.sendMessage(Messages.getMessage("no_perm"));
                }
            } else {
                p.sendMessage(Messages.getMessage("usage_prefix") + "/money <player>");
            }
        } else {
            sender.sendMessage(Messages.getMessage("player_only"));
        }

        return false;
    }

}
