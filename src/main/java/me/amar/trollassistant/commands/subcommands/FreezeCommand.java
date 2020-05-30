package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.listeners.Frozen;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FreezeCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    @Override
    public String getName() {
        return "freeze";
    }

    @Override
    public String getDescription() {
        return "Troll players with the freeze troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> freeze";
    }

    @Override
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!p.hasPermission("troll.freeze") || !p.hasPermission("troll.*")) {
            p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            if (target.getGameMode() == GameMode.CREATIVE) {
                p.sendMessage(TrollAssistant.colorize(target.getDisplayName() + " is in creative. This troll does not work on players who are in creative."));
            } else {
                if (!Frozen.isFrozenPlayer(target.getUniqueId().toString())) {
                    Frozen.addPlayerToFrozenList(target.getUniqueId().toString());
                    p.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bFreeze &ctroll."));
                    target.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.freeze")));
                    p.setWalkSpeed(0);
                    p.setFoodLevel(3);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 200), true);
                } else {
                    Frozen.removePlayerFromFrozenList(target.getUniqueId().toString());
                    p.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been untrolled with the &bFreeze &ctroll."));
                    target.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.unfreeze")));
                    p.setFoodLevel(20);
                    p.setWalkSpeed((float) 0.2);
                    p.removePotionEffect(PotionEffectType.JUMP);
                }


            }
        }
    }
}