package me.amar.trollassistant.Menus;


import dev.demeng.pluginbase.item.ItemBuilder;
import dev.demeng.pluginbase.lib.xseries.XMaterial;
import dev.demeng.pluginbase.menu.layout.Menu;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
public class PersonalTrollsMenu extends Menu {
    ItemStack waterBucket = XMaterial.WATER_BUCKET.parseItem();
    public PersonalTrollsMenu(Player player, Player target) {
        super(36, "&cTroll &b" + target.getName());
        addButton(9, ItemBuilder.create(XMaterial.WATER_BUCKET.parseItem()).name("&c&lMLG troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cMLG &etroll!", "&aforce your frenemies to MLG water clutch!")).get(), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " mlg");
            player.closeInventory();
        });
        addButton(10, ItemBuilder.create(XMaterial.POTATO.parseItem()).name("&c&lPotato troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cpotato &etroll!", "&aFill the player's inventory  with spuds!")).get(), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " potato");
            player.closeInventory();
        });
        addButton(11, ItemBuilder.create(XMaterial.GOLDEN_APPLE.parseItem()).name("&c&lDevil Apple troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cDevil Apple &etroll!", "&aSlips a golden apple into the player's inventory", "&awhich has catastrophic effects when eaten...")).get(), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " devilapple");
            player.closeInventory();
        });

        addButton(12, ItemBuilder.create(XMaterial.BARRIER.parseItem()).name("&c&lKick troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &ckick &etroll!", "")).get(),event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " kick");
            player.closeInventory();
        });
        addButton(13, ItemBuilder.create(XMaterial.PLAYER_HEAD.parseItem()).name("&c&lPlayerChat troll " + target.getName()).lore(Arrays.asList("&cComing soon!", "")).get(), event -> {
            player.closeInventory();
            player.sendMessage(TrollAssistant.colorize("&cComing soon!"));
        });
        addButton(14, ItemBuilder.create(XMaterial.RED_WOOL.parseItem()).name("&c&lChat troll " + target.getName()).lore(Arrays.asList("&cComing soon!")).get(), event -> {
            player.closeInventory();
            player.sendMessage(TrollAssistant.colorize("&cComing soon!"));
        });
        addButton(15, ItemBuilder.create(XMaterial.TRAPPED_CHEST.parseItem()).name("&c&lDemo Mode troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cDemo Mode &etroll!")).get(), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " demo");
        });
        addButton(16, ItemBuilder.create(XMaterial.BOW.parseItem()).name("&c&lPush troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cPush &etroll!")).get(), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " push");
        });
        addButton(17, ItemBuilder.create(XMaterial.ENDER_PEARL.parseItem()).name("&c&lEnderSpook troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cEnderSpook &etroll!")).get(), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " EnderSpook");
        });
        addButton(18, ItemBuilder.create(XMaterial.FIRE_CHARGE.parseItem()).name("&c&lFakeOP troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cFakeOP &etroll!")).get(), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " fakeop");
        });
        addButton(19, ItemBuilder.create(XMaterial.SNOWBALL.parseItem()).name("&c&lFreeze troll " + target.getName()).lore(Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cFreeze &etroll!")).get(), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " freeze");
        });

        setBackground(new ItemStack(XMaterial.RED_STAINED_GLASS_PANE.parseItem()));
            open(player);


    }
}
