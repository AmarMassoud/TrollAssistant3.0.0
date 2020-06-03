package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Frozen {
    private static final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    public static List<String> frozen = new ArrayList<>();

    public static void addPlayerToFrozenList(String p) {
        List<String> copy = new ArrayList<>(plugin.getData().getStringList("frozen"));
        copy.add(p);
        plugin.getData().set("frozen", copy);
        try {
            plugin.getDataConfig().saveConfig();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removePlayerFromFrozenList(String p) {
        List<String> copy = new ArrayList<>(plugin.getData().getStringList("frozen"));
        copy.remove(p);
        plugin.getData().set("frozen", copy);
        try {
            plugin.getDataConfig().saveConfig();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    public static boolean isFrozenPlayer(String p) {
        List<String> copy = new ArrayList<>(plugin.getData().getStringList("frozen"));
        if (copy.contains(p)) {
            return true;
        } else {
            return false;
        }
    }

}