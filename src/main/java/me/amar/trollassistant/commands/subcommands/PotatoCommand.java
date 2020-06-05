package me.amar.trollassistant.commands.subcommands;

import com.demeng7215.demlib.api.items.XMaterial;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PotatoCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    @Override
    public String getName() {
        return "potato";
    }

    @Override
    public String getDescription() {
        return "Troll players with the potato troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> potato";
    }

    @Override
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.potato") || !s.hasPermission("torll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {

            for (int i = 0; i <= 35; i++) {
                target.getInventory().setItem(i, new ItemStack(XMaterial.POTATO.parseItem()));
            }

            target.updateInventory();
            target.sendMessage(TrollAssistant.colorize("&ePotato! Potato! Potato!"));
            s.sendMessage( //
                    TrollAssistant.colorize(
                            "&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bPotato &ctroll."));
        }
    }
}