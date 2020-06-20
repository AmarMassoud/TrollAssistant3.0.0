package me.amar.trollassistant.Events;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.modules.ReplaceTrollPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class TrolledPlayerChatEvent implements Listener {
    @EventHandler
    public void onTrolledPlayerChatListener(AsyncPlayerChatEvent e) {

        final ReplaceTrollPlayer p =
                TrollAssistant.getReplaceTrollPlayers().stream()
                        .filter(rtp -> rtp.getPlayer().getUniqueId().equals(e.getPlayer().getUniqueId()))
                        .findFirst()
                        .orElse(null);

        if (p == null) return;

        e.setMessage(e.getMessage().replace(p.getReplace(), p.getReplaceWith()));
    }
}
