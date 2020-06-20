package me.amar.trollassistant.Global.GlobalSubCommands;

import me.amar.trollassistant.Global.GlobalTrollCommandManager;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GlobalMLGCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);


    @Override
    public String getName() {
        return "mlg";
    }

    @Override
    public String getDescription() {
        return "Troll all players with the MLG troll.";
    }

    @Override
    public String getSyntax() {
        return "/gtroll mlg";
    }
    public void MLG(Player p) {

    }

    @Override
    public void perform(CommandSender s, String[] args) {
        if (!s.hasPermission("troll.mlg") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            for (Player players : Bukkit.getOnlinePlayers()) {


                final Location loc =
                        new Location(
                                players.getWorld(),
                                players.getLocation().getX(),
                                players.getLocation().getY() + 100,
                                players.getLocation().getZ());

                players.teleport(loc);
                players.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));

                players.sendMessage(TrollAssistant.colorize("&cMLG water bucket or die. >:)"));


            }


        }




    }



}


