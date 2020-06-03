package me.amar.trollassistant.commands.subcommands;

import com.google.common.base.Joiner;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

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
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.playerchat") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        }
        String args2 = Arrays.copyOfRange(args, 1, args.length).toString();
        final String[] messages = Arrays.copyOfRange(args, 2, args.length);
        target.chat(TrollAssistant.colorize(Joiner.on(' ').skipNulls().join(messages)));

    }
}
