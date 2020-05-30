package me.amar.trollassistant.listeners;

import me.amar.trollassistant.TrollAssistant;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.potion.PotionEffectType;

public class PlayerGameModeChangeListener implements Listener {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    public void GamemodeChange(PlayerGameModeChangeEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {
            if (Frozen.isFrozenPlayer(p.getUniqueId().toString())) {
                Frozen.removePlayerFromFrozenList(p.getUniqueId().toString());
                p.setFoodLevel(20);
                p.setWalkSpeed((float) 0.2);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.unfreeze")));
            }
        }
    }
}
