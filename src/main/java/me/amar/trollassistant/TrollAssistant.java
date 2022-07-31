package me.amar.trollassistant;


import dev.demeng.pluginbase.plugin.BaseManager;
import dev.demeng.pluginbase.plugin.BasePlugin;
import lombok.Getter;
import me.amar.trollassistant.Events.*;
import me.amar.trollassistant.Files.DataYml;
import me.amar.trollassistant.Global.GlobalTrollCommandManager;
import me.amar.trollassistant.commands.TrollCommandManager;
import me.amar.trollassistant.commands.TabExecutor;
import me.amar.trollassistant.modules.ReplaceTrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TrollAssistant extends BasePlugin {
    @Getter
    private static TrollAssistant instance;

    private static List<ReplaceTrollPlayer> replaceTrollPlayers = new ArrayList<>();


    @Override
    public void enable() {
        BaseManager.setPlugin(this);
        loadConfigManager();
        getCommand("troll").setExecutor(new TrollCommandManager());
        getCommand("globaltroll").setExecutor(new GlobalTrollCommandManager());
        Bukkit.getPluginManager().registerEvents(new TrolledPlayerChatEvent(), this);
        Bukkit.getPluginManager().registerEvents(new TrolledPlayerConsumeEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CarrotChatEvent(), this);
        getCommand("troll").setTabCompleter(new TabExecutor());
        Bukkit.getPluginManager().registerEvents(new PlayerGameModeChangeListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLoginListener(), this);
        Bukkit.getPluginManager().registerEvents(new ChatPlayersEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BrrDamagEvent(), this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        getLogger().info("Troll Assistant " + getDescription().getVersion() + " enabled");
        instance = this;


    }

    @Override
    public void disable() {
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
    public void loadConfigManager() {
        DataYml.setUpDataYml();
        DataYml.reloadDataYml();
        final List<String> frozen = Arrays.asList();
        DataYml.getDataYml().addDefault("frozen", frozen);
        DataYml.getDataYml().addDefault("carrot", false);
        DataYml.getDataYml().options().copyDefaults(true);
        DataYml.saveDataYml();
    }
}
