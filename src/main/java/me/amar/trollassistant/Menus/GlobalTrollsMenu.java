package me.amar.trollassistant.Menus;

import dev.demeng.pluginbase.item.ItemBuilder;
import dev.demeng.pluginbase.lib.xseries.XMaterial;
import dev.demeng.pluginbase.menu.layout.Menu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class GlobalTrollsMenu extends Menu {
    public GlobalTrollsMenu(Player p) {
        super(36, "&aGlobal Trolls");
        addButton(9, ItemBuilder.create(XMaterial.CARROT.parseItem()).name("&cTo choose the Carrot troll").lore(Arrays.asList("&cMake all players say nothing but the word &bCarrot&c!")).get(), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll carrot");
            p.closeInventory();

        });
        addButton(10, ItemBuilder.create(XMaterial.WATER_BUCKET.parseItem()).name("&cTo choose the MLG troll").lore(Arrays.asList("&cForce all players to MLG or they will &bdie!")).get(), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll mlg");
            p.closeInventory();

        });
        addButton(11, ItemBuilder.create(XMaterial.ENDER_PEARL.parseItem()).name("&cTo choose the EnderSpook troll").lore(Arrays.asList("&cScare the crap out of all players!")).get(), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll enderspook");
            p.closeInventory();

        });

        setBackground(XMaterial.RED_STAINED_GLASS_PANE.parseItem());
        open(p);

    }
}
