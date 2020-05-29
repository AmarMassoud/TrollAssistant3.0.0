package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PushCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "push";
    }

    @Override
    public String getDescription() {
        return "Troll players with the Push troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> push";
    }

    @Override
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!p.hasPermission("troll.push") || !p.hasPermission("troll.*")) {
            p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            target.setVelocity(target.getVelocity().setY(0));
            target.setVelocity(target.getLocation().getDirection().multiply(-3.1D));
            target.setVelocity(target.getVelocity().setY(1.12D));
        }
    }
}
