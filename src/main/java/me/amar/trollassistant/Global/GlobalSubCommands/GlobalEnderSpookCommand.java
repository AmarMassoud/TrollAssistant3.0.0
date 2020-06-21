package me.amar.trollassistant.Global.GlobalSubCommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class GlobalEnderSpookCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);


    @Override
    public String getName() {
        return "enderspook";
    }

    @Override
    public String getDescription() {
        return "Troll all players with the EnderSpook troll.";
    }

    @Override
    public String getSyntax() {
        return "/gtroll enderspook";
    }

    @Override
    public void perform(CommandSender s, String[] args) {
        for(Player players : Bukkit.getOnlinePlayers()) {
        if (!s.hasPermission("gtroll.enderspook") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            players.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1), true);

            if(Bukkit.getVersion().contains("1.8")) {
                for (int i = 0; i < 10; i++) {
                    players.playSound(players.getLocation(), Sound.valueOf("ENDERMAN_SCREAM"), 10, 1);
                }
            } else if(Bukkit.getVersion().contains("1.9")) {
                for (int i = 0; i < 10; i++) {
                    players.playSound(players.getLocation(), Sound.valueOf("ENTITY_ENDERMEN_SCREAM"), 10, 1);
                }
            } else if( Bukkit.getVersion().contains("1.10")) {
                for (int i = 0; i < 10; i++) {
                    players.playSound(players.getLocation(), Sound.valueOf("ENTITY_ENDERMEN_SCREAM"), 10, 1);
                }
            } else if(Bukkit.getVersion().contains("1.11")){
                for (int i = 0; i < 10; i++) {
                    players.playSound(players.getLocation(), Sound.valueOf("ENTITY_ENDERMEN_SCREAM"), 10, 1);
                }
            } else if(Bukkit.getVersion().contains("1.12")) {
                for (int i = 0; i < 10; i++) {
                    players.playSound(players.getLocation(), Sound.valueOf("ENTITY_ENDERMEN_SCREAM"), 10, 1);
                }
            } else {
                for (int i = 0; i < 10; i++) {
                    players.playSound(players.getLocation(), Sound.valueOf("ENTITY_ENDERMAN_SCREAM"), 10, 1);
                }
            }
            s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + players.getDisplayName() + " &chas been trolled with the &bEnderSpook &ctroll."));
        }

    }
    }
}
