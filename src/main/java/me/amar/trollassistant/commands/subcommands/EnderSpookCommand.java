package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
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
    public void perform(CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!s.hasPermission("troll.enderspook") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 1), true);

            if(Bukkit.getVersion().contains("1.8")) {
                for (int i = 0; i < 10; i++) {
                    target.playSound(target.getLocation(), Sound.valueOf("ENDERMAN_SCREAM"), 10, 1);
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    target.playSound(target.getLocation(), Sound.valueOf("ENTITY_ENDERMAN_SCREAM"), 10, 1);
                }
            }
            s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bEnderSpook &ctroll."));
        }

    }
}
