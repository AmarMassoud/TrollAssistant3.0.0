package me.amar.trollassistant.Events;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.listeners.Frozen;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class TrolledPlayerConsumeEvent implements Listener {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @EventHandler
    public void onCursedGappleConsume(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if (Frozen.isFrozenPlayer(p.getUniqueId().toString())) {
            e.setCancelled(true);
            p.sendMessage(TrollAssistant.colorize("You can not eat while being frozen!"));
        } else {

        if (e.getItem().getType() != Material.GOLDEN_APPLE) return;
        ItemStack apple = e.getItem();
        if (!apple.hasItemMeta() || !apple.getItemMeta().hasDisplayName() || !apple.getItemMeta().hasLore()) return;

        if (!apple.getItemMeta().getDisplayName().equals(TrollAssistant.colorize("&cThe Apple of the Devil!"))) return;
        if (!apple.getItemMeta().getLore().get(0).equals(TrollAssistant.colorize("&bThe curiosity got the cat killed")))
            return;
        e.setCancelled(true);

        p.setHealth(plugin.getConfig().getInt("hearts"));
        p.sendMessage(TrollAssistant.colorize("&cYou have been cursed with the golden apple curse!"));
        int amount = apple.getAmount() - 1;
        if (apple.getAmount() > 1) {
            apple.setAmount(amount);
        } else {
            p.getInventory().setItem(p.getInventory().getHeldItemSlot() ,new ItemStack(Material.AIR));
        }
    }
        p.updateInventory();

    }
}
