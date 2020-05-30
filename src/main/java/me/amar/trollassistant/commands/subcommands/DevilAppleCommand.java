package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;

public class DevilAppleCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "DevilApple";
    }

    @Override
    public String getDescription() {
        return "Troll players with the DevilApple troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> DevilApple";
    }

    @Override
    public void preform(Player p, CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.devilapple")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        }
        ItemStack item = new ItemStack(Material.GOLDEN_APPLE, 1);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(TrollAssistant.colorize("&cThe Apple of the Devil!"));
        ArrayList<String> lore = new ArrayList<String>();
        meta.setLore(Collections.singletonList(TrollAssistant.colorize("&bThe curiosity got the cat killed")));
        item.setItemMeta(meta);

        target.getInventory().addItem(item);
        target.sendMessage(TrollAssistant.colorize("&cYou have been given a golden apple!"));
        s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bDevil Apple &ctroll."));

    }
}
