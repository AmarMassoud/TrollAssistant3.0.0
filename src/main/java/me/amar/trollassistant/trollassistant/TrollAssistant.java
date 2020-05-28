package me.amar.trollassistant.trollassistant;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class TrollAssistant extends JavaPlugin {
    private static TrollAssistant instance;

    private static List<ReplaceTrollPlayer> replaceTrollPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        getLogger().info("Troll Assistant Enabled");
        getConfig().options().copyDefaults(true);
        saveConfig();
        getLogger().info("Troll Assistant enabled.");
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static List<ReplaceTrollPlayer> getReplaceTrollPlayers() {
        return replaceTrollPlayers;
    }

    /*
    Not great to have this in your main class and you should probably create a MessageUtils class
    with a bunch of messaging utilities, but at this stage this is really the only thing you need
    so yeah.
     */
    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static TrollAssistant getInstance() {
        return instance;
    }

    public String getNoPermission() {
    return getConfig().getString("messages.NoPermission");

    }
}

