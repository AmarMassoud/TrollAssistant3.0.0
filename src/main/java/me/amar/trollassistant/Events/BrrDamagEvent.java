package me.amar.trollassistant.Events;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.listeners.GoBrrListener;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

public class BrrDamagEvent implements Listener {

    @EventHandler
    public void onPlayerDamageEvent(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (GoBrrListener.isInBrrList(p.getUniqueId().toString())) {
                if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK || e.getCause() == EntityDamageEvent.DamageCause.PROJECTILE || e.getCause() == EntityDamageEvent.DamageCause.POISON) {
                    p.sendMessage(("x: " + (int) p.getLocation().getX() + "y: " + (int) p.getLocation().getY() + "Z: " + (int) p.getLocation().getZ()  + " location"));
                    int min = -50;
                    int max = 50;
                    int yVelocity = (int)Math.floor(Math.random()*(3+3+1)-3);
                    p.setVelocity(new Vector((int)Math.floor(Math.random()*(max-min+1)+min),yVelocity, (int)Math.floor(Math.random()*(max-min+1)+min) ));
                    p.setFallDistance((float) p.getVelocity().getY());
                }
            }

        }
    }
}