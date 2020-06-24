package me.amar.trollassistant.listeners;

import me.amar.trollassistant.Files.DataYml;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Frozen {
    public static void addPlayerToFrozenList(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("frozen"));
        copy.add(p);
        DataYml.getDataYml().set("frozen", copy);
        DataYml.saveDataYml();
    }

    public static void removePlayerFromFrozenList(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("frozen"));
        copy.remove(p);
        DataYml.getDataYml().set("frozen", copy);
        DataYml.saveDataYml();
    }

    public static boolean isFrozenPlayer(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("frozen"));
        if (copy.contains(p)) {
            System.out.println("is");
            return true;
        } else {
            System.out.println("is not");
            return false;
        }
    }

}