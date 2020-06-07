package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChatPlayers {
    public static List<String> players = new ArrayList<>();

    public static void addPlayerToChatList(UUID p) {
        players.add(p.toString());
    }
    public static void removePlayerFromChatList(UUID p) {
        players.remove(p.toString());
    }
    public static boolean ChatListhasPlayer(UUID p) {
        if (players.contains(p.toString())) {
            return true;
        } else {
            return false;
        }
    }
}