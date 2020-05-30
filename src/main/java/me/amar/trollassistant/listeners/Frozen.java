package me.amar.trollassistant.listeners;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Frozen {
    public static List<String> frozen = new ArrayList<>();

    public static void addPlayerToFrozenList(String p) {
        frozen.add(p);
    }

    public static void removePlayerFromFrozenList(String p) {
        frozen.remove(p);

    }

    public static boolean isFrozenPlayer(String p) {
        if (frozen.contains(p)) {
            return true;
        } else {
            return false;
        }
    }
    public static void resetFrozenList() {
        frozen.clear();
    }
}