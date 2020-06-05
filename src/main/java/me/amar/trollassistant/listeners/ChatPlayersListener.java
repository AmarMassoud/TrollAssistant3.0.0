package me.amar.trollassistant.listeners;

import me.amar.trollassistant.Menus.PersonalTrollsMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPlayersListener implements Listener {
    @EventHandler
    public void playersChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("event works1");
    if(ChatPlayers.hasPlayer(p.getName())) {
        p.sendMessage("event works");
        e.setCancelled(true);
        Player target = Bukkit.getPlayer(e.getMessage());
        new PersonalTrollsMenu(p, target);



        }





    }


}
