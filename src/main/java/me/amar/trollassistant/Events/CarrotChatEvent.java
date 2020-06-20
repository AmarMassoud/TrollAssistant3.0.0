package me.amar.trollassistant.Events;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.listeners.GlobalCarrot;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class CarrotChatEvent implements Listener {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @EventHandler
    public void CarrotChat(AsyncPlayerChatEvent e) {
        if(GlobalCarrot.isCarrotOn()) {
            ArrayList<String> word = new ArrayList<String>();
            String sending = "";
            for(String words : e.getMessage().split(" ")){
                word.add(words);
            }

            for(int i = 0; i < word.size(); i++){
                sending = sending + TrollAssistant.colorize(plugin.getConfig().getString("MessageSent") + " ");
            }
            e.setMessage(sending);


    }


    }


}
