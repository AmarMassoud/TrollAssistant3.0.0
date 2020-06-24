package me.amar.trollassistant.listeners;

import me.amar.trollassistant.Files.DataYml;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class GlobalCarrot {
    private static final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    public static String carrot = new String();

    public static void setGlobalCarrotTrue() {
        String copy = DataYml.getDataYml().getString("carrot");
        DataYml.getDataYml().set("carrot", true);
        DataYml.saveDataYml();
    }

    public static void setGlobalCarrotFalse() {
        boolean copy = DataYml.getDataYml().getBoolean("carrot");
        DataYml.getDataYml().set("carrot", false);
        DataYml.saveDataYml();
    }

    public static boolean isCarrotOn() {
        boolean copy = DataYml.getDataYml().getBoolean("carrot");
        if (copy == true) {
            return true;
        } else {
            return false;
        }
    }
}