package me.amar.trollassistant.trollassistant.commands.subcommands;

import me.amar.trollassistant.trollassistant.TrollAssistant;
import me.amar.trollassistant.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
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
        return "Troll player with the MLG troll";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> mlg";
    }

    @Override
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
            if (!p.hasPermission("troll.mlg")) {
                p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
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
            p.sendMessage(
                    TrollAssistant.colorize(
                            "&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bMLG &ctroll."));


        }
    }
}
