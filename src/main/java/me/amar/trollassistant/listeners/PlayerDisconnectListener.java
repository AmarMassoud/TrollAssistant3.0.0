package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerDisconnectListener implements Listener {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    public void disconnect(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (Frozen.isFrozenPlayer(p.getUniqueId().toString())) {
            p.removePotionEffect(PotionEffectType.JUMP);
            p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.freezeOnLogin")));
            p.setWalkSpeed(0);
            p.setFoodLevel(3);
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 200), true);
        }


    }

}
