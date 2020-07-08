package me.amar.trollassistant.Menus;

import dev.demeng.demlib.api.items.ItemCreator;
import dev.demeng.demlib.api.menus.Menu;
import dev.demeng.demlib.api.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class GlobalTrollsMenu extends Menu {
    public GlobalTrollsMenu(Player p) {
        super(36, "&aGlobal Trolls");
        setItem(9, ItemCreator.quickBuild(new ItemStack(XMaterial.CARROT.parseItem()), "&cTo choose the Carrot troll", Arrays.asList("&cMake all players say nothing but the word &bCarrot&c!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll carrot");
            p.closeInventory();

        });
        setItem(10, ItemCreator.quickBuild(new ItemStack(XMaterial.WATER_BUCKET.parseItem()), "&cTo choose the MLG troll", Arrays.asList("&cForce all players to MLG or they will &bdie!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll mlg");
            p.closeInventory();

        });
        setItem(11, ItemCreator.quickBuild(new ItemStack(XMaterial.ENDER_PEARL.parseItem()), "&cTo choose the EnderSpook troll", Arrays.asList("&cScare the crap out of all players!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll enderspook");
            p.closeInventory();

        });

        setBackground(XMaterial.RED_STAINED_GLASS_PANE.parseItem());
        open(p);

    }
}
