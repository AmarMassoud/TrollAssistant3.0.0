package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
            if (!p.hasPermission("troll.potato")) {
                p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
            }

            for (int i = 0; i <= 35; i++) {
                target.getInventory().setItem(i, new ItemStack(Material.POTATO));
            }

            target.updateInventory();
            target.sendMessage(TrollAssistant.colorize("&ePotato! Potato! Potato!"));
            p.sendMessage(
                    TrollAssistant.colorize(
                            "&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bPotato &ctroll."));
        }
    }
