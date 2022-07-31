package me.amar.trollassistant.Events;

import dev.demeng.pluginbase.text.TextUtils;
import me.amar.trollassistant.Menus.PersonalTrollsMenu;
import me.amar.trollassistant.Menus.sendTitleMethod;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.listeners.ChatPlayers;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPlayersEvent implements Listener {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    @EventHandler
    public void playersChatEvent(AsyncPlayerChatEvent e) {

            Player p = e.getPlayer();
            if (ChatPlayers.ChatListhasPlayer(p.getUniqueId())) {
                e.setCancelled(true);
                Bukkit.getScheduler().runTask(plugin, () -> {
                    try {
                        Player target = Bukkit.getPlayer(e.getMessage());
                        new PersonalTrollsMenu(p, target);
                        ChatPlayers.removePlayerFromChatList(p.getUniqueId());
                        TextUtils.sendTitle(p, "", "");
                    } catch (NullPointerException exc) {
                        p.sendMessage(TrollAssistant.colorize("&cPlease specify a valid player."));
                    }


                });
            }

    }
}
