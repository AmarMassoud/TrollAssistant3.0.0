package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerLoginListener implements Listener {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @EventHandler
    public void Login(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                if (Frozen.isFrozenPlayer(p.getUniqueId().toString())) {
                    p.removePotionEffect(PotionEffectType.JUMP);
                    p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.freezeOnLogin")));
                    p.setWalkSpeed(0);
                    p.setFoodLevel(3);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 200), true);
                }
            }
        }, 20L);



    }

}
