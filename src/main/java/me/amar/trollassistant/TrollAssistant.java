package me.amar.trollassistant;

import me.amar.trollassistant.commands.CommandManager;
import me.amar.trollassistant.commands.TabExecutor;
import me.amar.trollassistant.listeners.PlayerMoveEvent;
import me.amar.trollassistant.listeners.TrolledPlayerChatListener;
import me.amar.trollassistant.listeners.TrolledPlayerConsumeListener;
import me.amar.trollassistant.modules.ReplaceTrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class TrollAssistant extends JavaPlugin {
    private static TrollAssistant instance;

    private static List<ReplaceTrollPlayer> replaceTrollPlayers = new ArrayList<>();

    @Override
    public void onEnable() {
        getCommand("troll").setExecutor(new CommandManager());
        Bukkit.getPluginManager().registerEvents(new TrolledPlayerChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new TrolledPlayerConsumeListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerMoveEvent(), this);
        getCommand("troll").setTabCompleter(new TabExecutor());
        getConfig().options().copyDefaults(true);
        saveConfig();
         getLogger().info("Troll Assistant " + getDescription().getVersion() + " enabled");
        instance = this;

    }

    @Override
    public void onDisable() {
        getLogger().info("Troll Assistant " + getDescription().getVersion() + " disabled");
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
    }
