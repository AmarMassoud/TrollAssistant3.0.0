package me.amar.trollassistant.listeners;

import me.amar.trollassistant.Menus.PersonalTrollsMenu;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPlayersListener implements Listener {
    @EventHandler
    public void playersChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
    if(ChatPlayers.ChatListhasPlayer(p.getUniqueId())) {
        e.setCancelled(true);
        try {
            Player target = Bukkit.getPlayer(e.getMessage());
            new PersonalTrollsMenu(p, target);
            ChatPlayers.removePlayerFromChatList(p.getUniqueId());
        } catch (Exception exc) {
            p.sendMessage(TrollAssistant.colorize("Please specify a valid player."));
        }




        }





    }


}
