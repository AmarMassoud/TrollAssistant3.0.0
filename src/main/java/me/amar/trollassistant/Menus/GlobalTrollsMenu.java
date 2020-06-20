package me.amar.trollassistant.Menus;

import com.demeng7215.demlib.api.items.ItemBuilder;
import com.demeng7215.demlib.api.items.XMaterial;
import com.demeng7215.demlib.api.menus.CustomMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class GlobalTrollsMenu extends CustomMenu {
    public GlobalTrollsMenu(Player p) {
        super(36, "&aGlobal Trolls");
        setItem(9, ItemBuilder.build(new ItemStack(XMaterial.CARROT.parseItem()), "&cTo choose the Carrot troll", Arrays.asList("&cMake all players say nothing but the word &bCarrot&c!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll carrot");
            p.closeInventory();

        });
        setItem(10, ItemBuilder.build(new ItemStack(XMaterial.WATER_BUCKET.parseItem()), "&cTo choose the MLG troll", Arrays.asList("&cForce all players to MLG or they will &bdie!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "globaltroll mlg");
            p.closeInventory();

        });
        setBackground(XMaterial.RED_STAINED_GLASS_PANE.parseItem());
        open(p);

    }
}
