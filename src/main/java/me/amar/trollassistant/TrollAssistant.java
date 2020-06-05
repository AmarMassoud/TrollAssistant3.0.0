package me.amar.trollassistant;

import com.demeng7215.demlib.DemLib;
import com.demeng7215.demlib.api.files.CustomConfig;
import lombok.Getter;
import me.amar.trollassistant.Global.GlobalTrollCommandManager;
import me.amar.trollassistant.commands.TrollCommandManager;
import me.amar.trollassistant.commands.TabExecutor;
import me.amar.trollassistant.listeners.*;
import me.amar.trollassistant.modules.ReplaceTrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class TrollAssistant extends JavaPlugin {
    @Getter
    private CustomConfig dataConfig;
    private static TrollAssistant instance;

    private static List<ReplaceTrollPlayer> replaceTrollPlayers = new ArrayList<>();


    @Override
    public void onEnable() {
        DemLib.setPlugin(this);
        try {
            this.dataConfig = new CustomConfig("data.yml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        getCommand("troll").setExecutor(new TrollCommandManager());
        getCommand("globaltroll").setExecutor(new GlobalTrollCommandManager());
        Bukkit.getPluginManager().registerEvents(new TrolledPlayerChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new TrolledPlayerConsumeListener(), this);
        Bukkit.getPluginManager().registerEvents(new CarrotChatListener(), this);
        getCommand("troll").setTabCompleter(new TabExecutor());
        Bukkit.getPluginManager().registerEvents(new PlayerLoginListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerGameModeChangeListener(), this);
        getConfig().options().copyDefaults(true);
        saveConfig();


        getLogger().info("Troll Assistant " + getDescription().getVersion() + " enabled");
        instance = this;

    }

    @Override
    public void onDisable() {
        getLogger().info("Troll Assistant " + getDescription().getVersion() + " disabled");


    }

    public FileConfiguration getData() {
        return dataConfig.getConfig();
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
