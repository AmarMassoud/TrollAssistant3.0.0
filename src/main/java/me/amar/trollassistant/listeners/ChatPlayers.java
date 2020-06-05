package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ChatPlayers {
    public static ArrayList<String> players = new ArrayList<>();

    public static void addPlayer(String p) {
        players.add(p);

        Bukkit.broadcastMessage(TrollAssistant.colorize("added to list - add"));
    }
    public static void removePlayer(String p) {
        players.remove(p);

        Bukkit.broadcastMessage(TrollAssistant.colorize("removed from list - remove"));
    }
    public static boolean hasPlayer(String p) {
        if (players.contains(p)) {
            return true;
        } else {
            return false;
        }
    }
}
