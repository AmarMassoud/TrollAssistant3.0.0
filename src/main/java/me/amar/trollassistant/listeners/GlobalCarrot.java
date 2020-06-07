package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class GlobalCarrot {
    private static final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    public static String carrot = new String();

    public static void setGlobalCarrotTrue() {
        String copy = plugin.getData().getString("carrot");
        plugin.getData().set("carrot", true);
        try {
            plugin.getDataConfig().saveConfig();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setGlobalCarrotFalse() {
        boolean copy = plugin.getData().getBoolean("carrot");
        plugin.getData().set("carrot", false);
        try {
            plugin.getDataConfig().saveConfig();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static boolean isCarrotOn() {
        boolean copy = plugin.getData().getBoolean("carrot");
        if (copy == true) {
            return true;
        } else {
            return false;
        }
    }
}