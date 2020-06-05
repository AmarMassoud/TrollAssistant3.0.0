package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class CarrotChatListener implements Listener {
    @EventHandler
    public void CarrotChat(AsyncPlayerChatEvent e) {
        if(GlobalCarrot.isCarrotOn()) {
            ArrayList<String> word = new ArrayList<String>();
            String sending = "";
            for(String words : e.getMessage().split(" ")){
                word.add(words);
            }

            for(int i = 0; i < word.size(); i++){
                sending = sending + TrollAssistant.colorize("Carrot ");
            }
            e.setMessage(sending);


    }


    }


}
