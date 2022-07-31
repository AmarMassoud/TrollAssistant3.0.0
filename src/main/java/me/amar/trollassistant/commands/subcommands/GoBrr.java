package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.listeners.GoBrrListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class GoBrr extends SubCommand {
    TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);


    @Override
    public String getName() {
        return "gobrr";
    }

    @Override
    public String getDescription() {
        return "Makes it so whenever anyone hits the player they go flying!";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> gobrr";
    }

    @Override
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.gobrr") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            if (!GoBrrListener.isInBrrList(target.getUniqueId().toString())) {
                s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bGoBrr &ctroll."));

                GoBrrListener.addToBrrList(target.getUniqueId().toString());
            } else {
                s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been untrolled with the &bGoBrr &ctroll."));
                target.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] No more brr :("));
                GoBrrListener.removeFromBrrList(target.getUniqueId().toString());
            }
        }













        }
    }

