package de.cfp.essential.listener;

import de.cfp.essential.util.MoneyManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void on(PlayerJoinEvent e) {
        if(MoneyManager.hasMoney(e.getPlayer().getUniqueId())) {
            MoneyManager.setMoney(e.getPlayer().getUniqueId(), MoneyManager.getStarterMoney());
        }
    }

}
