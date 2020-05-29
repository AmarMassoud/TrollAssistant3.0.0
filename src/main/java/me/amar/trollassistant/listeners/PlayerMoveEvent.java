package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerMoveEvent implements Listener {
    public static TrollAssistant plugin;

    @EventHandler
    public void move(org.bukkit.event.player.PlayerMoveEvent e) {
        Player p = (Player) e.getPlayer();
        if (me.amar.trollassistant.listeners.Frozen.isFrozenPlayer(p.getUniqueId().toString())) {
            p.teleport((Location) p.getLocation().getBlock().getRelative(BlockFace.DOWN));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999, 200), true);
        } else {
            p.setFoodLevel(10);
            p.setWalkSpeed((float) 0.2);
            p.removePotionEffect(PotionEffectType.JUMP);
        }
    }
}
