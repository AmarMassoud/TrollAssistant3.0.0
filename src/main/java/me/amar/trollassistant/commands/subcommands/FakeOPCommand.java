package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeOPCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "fakeop";
    }

    @Override
    public String getDescription() {
        return "Troll players with the fakeOP troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> fakeop";
    }

    @Override
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.fakeop") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        }  else {
            target.sendMessage(TrollAssistant.colorize("&7[Server: Opped " + target.getName()) + "]");
            s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bFakeOP &ctroll."));
        }
    }
}