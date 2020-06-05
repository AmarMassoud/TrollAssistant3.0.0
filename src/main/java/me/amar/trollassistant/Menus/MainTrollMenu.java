package me.amar.trollassistant.Menus;

import com.demeng7215.demlib.api.items.ItemBuilder;
import com.demeng7215.demlib.api.items.XMaterial;
import com.demeng7215.demlib.api.menus.CustomMenu;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class MainTrollMenu extends CustomMenu {
    public MainTrollMenu(Player p) {
        super(36, "&bChoose an option");
        setItem(13, ItemBuilder.build(new ItemStack(XMaterial.PLAYER_HEAD.parseItem()), "&b&lPersonal Troll Menu", Arrays.asList("\"Click me to choose from the global trolls.\"")), event -> {
            p.closeInventory();
        });
        setItem(15, ItemBuilder.build(new ItemStack(XMaterial.SKELETON_SKULL.parseItem()), "&b&lGlobal Trolls.", Arrays.asList("Click me to choose from the global trolls.")), event -> {
            p.closeInventory();
            new GlobalTrollsMenu(p);
        });

        setBackground(new ItemStack(XMaterial.RED_STAINED_GLASS_PANE.parseItem()));
        open(p);
    }
}