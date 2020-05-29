package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.listeners.Frozen;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FreezeCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    @Override
    public String getName() {
        return "freeze";
    }

    @Override
    public String getDescription() {
        return "Troll players with the freeze troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> freeze";
    }

    @Override
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!p.hasPermission("troll.freeze") || !p.hasPermission("troll.*")) {
            p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        }  else {
            if (target.getGameMode().equals("Creative")) {
                p.sendMessage(TrollAssistant.colorize(target.getDisplayName() + " is in creative. This troll does not work on players who are in creative."));
            } else {
                if (!Frozen.isFrozenPlayer(target.getUniqueId().toString())) {
                    Frozen.addPlayerToFrozenList(target.getUniqueId().toString());
                    p.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bFreeze &ctroll."));
                    target.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.freeze")));
                } else {
                    Frozen.removePlayerFromFrozenList(target.getUniqueId().toString());
                    p.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been untrolled with the &bFreeze &ctroll."));
                    target.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.unfreeze")));
                }


            }
        }
    }
}
