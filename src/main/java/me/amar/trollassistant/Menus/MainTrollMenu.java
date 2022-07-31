package me.amar.trollassistant.Menus;


import dev.demeng.pluginbase.item.ItemBuilder;
import dev.demeng.pluginbase.lib.xseries.XMaterial;
import dev.demeng.pluginbase.menu.layout.Menu;
import dev.demeng.pluginbase.text.TextUtils;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.listeners.ChatPlayers;
import me.amar.trollassistant.listeners.Frozen;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class MainTrollMenu extends Menu {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    public MainTrollMenu(Player p) {
        super(27, "&bChoose an option");
        addButton(12, ItemBuilder.create(XMaterial.PLAYER_HEAD.parseItem()).name("&b&lPersonal Troll Menu").lore(Arrays.asList("&cClick me to choose from the personal trolls")).get(), event -> {
            if(p.hasPermission("personaltroll.gui")) {
                p.closeInventory();
                ChatPlayers.addPlayerToChatList(p.getUniqueId());
             //   sendTitleMethod.sendTitle(p, TrollAssistant.colorize("&bPlease specify a player"), "", 1, 600, 1);
                TextUtils.sendTitle(p, "&bPlease specify a player", "", 1, 600, 1);
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
        addButton(14, ItemBuilder.create(XMaterial.CREEPER_HEAD.parseItem()).name("&b&lGlobal Troll Menu").lore(Arrays.asList("&cClick here to choose from the global trolls")).get(), event -> {
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