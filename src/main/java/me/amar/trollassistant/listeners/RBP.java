package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;

import java.util.ArrayList;
import java.util.List;

public class RBP {
    private static final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    public static void addPlayerToRBP(String p) {
        List<String> copy = new ArrayList<>(plugin.getData().getStringList("rbp"));
        copy.add(p);
        plugin.getData().set("rbp", copy);
        try {
            plugin.getDataConfig().saveConfig();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void removePlayerFromRBP(String p) {
        List<String> copy = new ArrayList<>(plugin.getData().getStringList("rbp"));
        copy.remove(p);
        plugin.getData().set("rbp", copy);
        try {
            plugin.getDataConfig().saveConfig();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isPlayerInRBPT(String p) {
        List<String> copy = new ArrayList<>(plugin.getData().getStringList("rbp"));
        if (copy.contains(p)) {
            return true;
        } else {
            return false;
        }
    }



}
