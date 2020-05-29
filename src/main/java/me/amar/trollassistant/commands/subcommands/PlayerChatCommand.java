package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerChatCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "playerchat";
    }

    @Override
    public String getDescription() {
        return "Troll players with the playerchat troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> playerchat";
    }

    @Override
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!p.hasPermission("troll.playerchat") || !p.hasPermission("troll.*")) {
            p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        }
        String message = "";
        for (int i = 2; i < args.length; i++) {
            message = message + " " + args[i];
        }
        target.chat(TrollAssistant.colorize(message));

    }
}
