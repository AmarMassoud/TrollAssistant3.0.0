package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnderSpookCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "enderspook";
    }

    @Override
    public String getDescription() {
        return "Troll players with the EnderSpook troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> enderspook";
    }

    @Override
    public void preform(Player p, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!p.hasPermission("troll.enderspook") || !p.hasPermission("troll.*")) {
            p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 1), true);
            for (int i = 0; i < 10; i++) {
                target.playSound(target.getLocation(), Sound.ENTITY_ENDERMAN_SCREAM, 10, 1);
            }
            p.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bEnderSpook &ctroll."));
        }

    }
}
