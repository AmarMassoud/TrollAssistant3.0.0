package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.listeners.Frozen;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
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
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.freeze") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            World world = target.getWorld();
            if (world.getDifficulty() == Difficulty.PEACEFUL) {
                s.sendMessage(TrollAssistant.colorize("&cThis troll does not work if the difficulty is peaceful."));
            } else {
                if (target.getGameMode() == GameMode.CREATIVE) {
                    s.sendMessage(TrollAssistant.colorize("&b" + target.getDisplayName() + " &cis in creative. This troll does not work on players who are in creative."));
                } else {
                    if (!Frozen.isFrozenPlayer(target.getUniqueId().toString())) {
                        Frozen.addPlayerToFrozenList(target.getUniqueId().toString());
                        s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bFreeze &ctroll."));
                        target.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.freeze")));
                        target.setWalkSpeed(0);
                        target.setFoodLevel(3);
                        target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 200), true);
                    } else {
                        Frozen.removePlayerFromFrozenList(target.getUniqueId().toString());
                        s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been &bUnfrozen&c."));
                        target.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.unfreeze")));
                        target.setFoodLevel(20);
                        target.setWalkSpeed((float) 0.2);
                        target.removePotionEffect(PotionEffectType.JUMP);
                    }


                }
            }
        }
    }
}