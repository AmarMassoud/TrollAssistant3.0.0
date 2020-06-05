package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

public class FakeNukeCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "fakenuke";
    }

    @Override
    public String getDescription() {
        return "Troll the player with the fakeNuke command";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> fakenuke";
    }

    @Override
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.fakenuke") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            Entity tnt = target.getWorld().spawn(target.getTargetBlock(null, 50).getLocation().add(0, 1, 0), TNTPrimed.class);
            s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] &cYou have been FakeNuked " + target.getDisplayName()));

        }
    }
}
