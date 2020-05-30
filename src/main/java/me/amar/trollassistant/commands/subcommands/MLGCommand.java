package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MLGCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "mlg";
    }

    @Override
    public String getDescription() {
        return "Troll player with the MLG troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> mlg";
    }

    @Override
    public void preform(Player p, CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
            if (!s.hasPermission("troll.mlg")  || !s.hasPermission("troll.*")) {
                s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
            }

            final Location loc =
                    new Location(
                            target.getWorld(),
                            target.getLocation().getX(),
                            target.getLocation().getY() + 100,
                            target.getLocation().getZ());

            target.teleport(loc);
            target.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));

            target.sendMessage(TrollAssistant.colorize("&cMLG water bucket or die. >:)"));
            s.sendMessage(
                    TrollAssistant.colorize(
                            "&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bMLG &ctroll."));


        }
    }
