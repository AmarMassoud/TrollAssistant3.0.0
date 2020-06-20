package me.amar.trollassistant.Global.GlobalSubCommands;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.listeners.GlobalCarrot;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GlobalCarrotCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "carrot";
    }

    @Override
    public String getDescription() {
        return "Troll all players with the Carrot troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll carrot";
    }

    @Override
    public void perform(CommandSender s, String[] args) {
        if (!s.hasPermission("troll.carrot") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            if (GlobalCarrot.isCarrotOn()) {
                s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + "&cYou have untrolled the entire server from the carrot troll."));
                GlobalCarrot.setGlobalCarrotFalse();
                if(plugin.getConfig().getBoolean("shouldBroadcastMessage")) {
                    Bukkit.broadcastMessage(TrollAssistant.colorize(plugin.getConfig().getString("BroadCastedMessage")));
                }

            } else {
                s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + "&cYou have trolled the entire server with the carrot troll!"));
                Bukkit.broadcastMessage(TrollAssistant.colorize("&eWhat did one snowman say to the other?"));
                Bukkit.broadcastMessage(TrollAssistant.colorize("&6Can you smell...?"));
                GlobalCarrot.setGlobalCarrotTrue();
            }
        }



    }
}
