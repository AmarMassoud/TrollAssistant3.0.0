package me.amar.trollassistant.Menus;

import com.demeng7215.demlib.api.items.ItemBuilder;
import com.demeng7215.demlib.api.items.XMaterial;
import com.demeng7215.demlib.api.menus.CustomMenu;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
public class PersonalTrollsMenu extends CustomMenu {
    ItemStack waterBucket = XMaterial.WATER_BUCKET.parseItem();
    public PersonalTrollsMenu(Player player, Player target) {
        super(36, "troll " + target.getName());
        setItem(9, ItemBuilder.build(new ItemStack(XMaterial.WATER_BUCKET.parseItem()), "&c&lMLG troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cMLG &etroll!", "&aforce your frenemies to MLG water clutch!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " mlg");
            player.closeInventory();
        });
        setItem(10, ItemBuilder.build(new ItemStack(XMaterial.POTATO.parseItem()), "&c&lPotato troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cpotato &etroll!", "&aFill the player's inventory  with spuds!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " potato");
            player.closeInventory();
        });
        setItem(11, ItemBuilder.build(new ItemStack(XMaterial.GOLDEN_APPLE.parseItem()), "&c&lDevil Apple troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cDevil Apple &etroll!", "&aSlips a golden apple into the player's inventory", "&awhich has catastrophic effects when eaten...")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " devilapple");
            player.closeInventory();
        });

        setItem(12, ItemBuilder.build(new ItemStack(XMaterial.BARRIER.parseItem()), "&c&lKick troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &ckick &etroll!", "")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " kick");
            player.closeInventory();
        });
        setItem(13, ItemBuilder.build((new ItemStack(XMaterial.PLAYER_HEAD.parseItem())), "&c&lPlayerChat troll " + target.getName(), Arrays.asList("&cComing soon!", "")), event -> {
            player.closeInventory();
            player.sendMessage(TrollAssistant.colorize("&cComing soon!"));
        });
        setItem(14, ItemBuilder.build(new ItemStack(XMaterial.RED_WOOL.parseItem()), "&c&lChat troll " + target.getName(), Arrays.asList("&cComing soon!")), event -> {
            player.closeInventory();
            player.sendMessage(TrollAssistant.colorize("&cComing soon!"));
        });
        setItem(15, ItemBuilder.build(new ItemStack(XMaterial.TRAPPED_CHEST.parseItem()), "&c&lDemo Mode troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cDemo Mode &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " demo");
        });
        setItem(16, ItemBuilder.build(new ItemStack(XMaterial.BOW.parseItem()), "&c&lPush troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cPush &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " push");
        });
        setItem(17, ItemBuilder.build(new ItemStack(XMaterial.ENDER_PEARL.parseItem()), "&c&lEnderSpook troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cEnderSpook &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " EnderSpook");
        });
        setItem(18, ItemBuilder.build(new ItemStack(XMaterial.FIRE_CHARGE.parseItem()), "&c&lFakeOP troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cFakeOP &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " fakeop");
        });
        setItem(19, ItemBuilder.build(new ItemStack(XMaterial.SNOWBALL.parseItem()), "&c&lFreeze troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cFreeze &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " freeze");
        });

        setBackground(new ItemStack(XMaterial.RED_STAINED_GLASS_PANE.parseItem()));
            open(player);


    }
}
