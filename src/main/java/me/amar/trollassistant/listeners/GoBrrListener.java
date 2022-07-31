package me.amar.trollassistant.listeners;

import me.amar.trollassistant.Files.DataYml;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GoBrrListener {

    public static void addToBrrList(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("brr"));
        copy.add(p);
        DataYml.getDataYml().set("brr", copy);
        DataYml.saveDataYml();
    }
    public static void removeFromBrrList(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("brr"));
        copy.remove(p);
        DataYml.getDataYml().set("brr", copy);
        DataYml.saveDataYml();
    }

    public static boolean isInBrrList(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("brr"));
        if (copy.contains(p)) {
            return true;
        } else {
            return false;
        }
    }


}
