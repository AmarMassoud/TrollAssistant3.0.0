package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KickCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    @Override
    public String getName() {
        return "kick";
    }

    @Override
    public String getDescription() {
        return "Troll players with the kick command.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> kick";
    }

    @Override
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
            if (!p.hasPermission("troll.kick") || !p.hasPermission("troll.*")) {
                p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
            }
            target.kickPlayer("internal exception java.io.ioexception an existing connection was forcibly closed by the remote host");
            p.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2]" + target.getDisplayName() + "&chas been trolled with the &bKick &ctroll."));
        }
    }