package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.modules.ReplaceTrollPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    @Override
    public String getName() {
        return "chat";
    }

    @Override
    public String getDescription() {
        return "Troll players with the chat troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> chat";
    }

    @Override
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.chat")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            if (args.length == 3
                    && (args[2].equalsIgnoreCase("cancel") || args[2].equalsIgnoreCase("stop"))) {

                Player finalTarget = target;
                TrollAssistant.getReplaceTrollPlayers()
                        .removeIf(rtp -> rtp.getPlayer().getUniqueId().equals(finalTarget.getUniqueId()));

                s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2]" + " &cChat curse has been removed."));
            }

            if (args.length > 4) {
                s.sendMessage(
                        TrollAssistant.colorize(
                                "&2[&6Troll Assistant&2] &cIncorrect usage. Try &f/troll <target> <troll> <replace> <replacewith>"));
            } else if (args.length == 4) {

                final ReplaceTrollPlayer rtp =
                        new ReplaceTrollPlayer(target, args[2].toCharArray()[0], args[3].toCharArray()[0]);
                TrollAssistant.getReplaceTrollPlayers().add(rtp);

                target.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] &dYou have been cursed with the chat curse."));
                s.sendMessage(
                        TrollAssistant.colorize(
                                "&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bChat &ctroll."));

            } else if (args.length == 2) {
                s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] &cIncorrect usage. Try &f/troll <target> <troll> <replace> <replacewith>"));

            }
        }
    }
}
// /troll MagnifiedNeonate chat cancel