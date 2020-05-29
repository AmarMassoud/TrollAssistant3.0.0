package me.amar.trollassistant.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabExecutor implements TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("troll")) {
            if (args.length == 1) {
                List<String> playerNames = new ArrayList<>();
                Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);
                for (int i = 0; i < players.length; i++) {
                    playerNames.add(players[i].getName());
                }
                return playerNames;
            } else if (args.length == 2) {
                List<String> arguments = new ArrayList<>();
                arguments.add("push");
                arguments.add("mlg");
                arguments.add("potato");
                arguments.add("devilapple");
                arguments.add("chat");
                arguments.add("playerchat");
                arguments.add("kick");
                arguments.add("demo");
                arguments.add("enderspook");
                arguments.add("fakeop");
                arguments.add("freeze");
                Collections.sort(arguments);
                return arguments;
            }
        }
        return null;
    }
}
