package me.amar.trollassistant.Menus;

import dev.demeng.demlib.api.items.ItemCreator;
import dev.demeng.demlib.api.menus.Menu;
import dev.demeng.demlib.api.xseries.XMaterial;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.listeners.ChatPlayers;
import me.amar.trollassistant.listeners.Frozen;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.awt.*;
import java.util.Arrays;

public class MainTrollMenu extends Menu {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    public MainTrollMenu(Player p) {
        super(27, "&bChoose an option");
        setItem(12, ItemCreator.quickBuild(new ItemStack(XMaterial.PLAYER_HEAD.parseItem()), "&b&lPersonal Troll Menu", Arrays.asList("&cClick me to choose from the personal trolls")),event -> {
            if(p.hasPermission("personaltroll.gui")) {
                p.closeInventory();
                ChatPlayers.addPlayerToChatList(p.getUniqueId());
                sendTitleMethod.sendTitle(p, TrollAssistant.colorize("&bPlease specify a player"), "", 1, 600, 1);
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        ChatPlayers.removePlayerFromChatList(p.getUniqueId());
                    }
                }, 20 * 30L);
            } else {

                p.closeInventory();
                p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));

            }


        });
        setItem(14, ItemCreator.quickBuild(new ItemStack(XMaterial.CREEPER_HEAD.parseItem()), "&b&lGlobal Troll Menu", Arrays.asList("&cClick here to choose from the global trolls")), event -> {
            if(p.hasPermission("globaltroll.gui")) {

                p.closeInventory();
                new GlobalTrollsMenu(p);

            } else {

                p.closeInventory();
                p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
            }
        });

        setBackground(new ItemStack(XMaterial.RED_STAINED_GLASS_PANE.parseItem()));
        open(p);
    }

}