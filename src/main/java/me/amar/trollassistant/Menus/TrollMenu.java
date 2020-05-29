package me.amar.trollassistant.Menus;

import com.demeng7215.demlib.api.items.ItemBuilder;
import com.demeng7215.demlib.api.menus.CustomMenu;
import me.amar.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
public class TrollMenu extends CustomMenu {
    public TrollMenu(Player player, Player target) {
        super(36, "troll " + target.getName());
//        ItemStack Item_Skull = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
//        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
//        SkullMeta skull = (SkullMeta) Item_Skull.getItemMeta();
//        skull.setOwner(target.getName());
//        skull.setDisplayName(TrollAssistant.colorize("&c&lPlayerChat troll "));

        setItem(9, ItemBuilder.build(new ItemStack(Material.WATER_BUCKET), "&c&lMLG troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cMLG &etroll!", "&aforce your frenemies to MLG water clutch!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " mlg");
            player.closeInventory();
        });
        setItem(10, ItemBuilder.build(new ItemStack(Material.POTATO), "&c&lPotato troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cpotato &etroll!", "&aFill the player's inventory  with spuds!")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " potato");
            player.closeInventory();
        });
        setItem(11, ItemBuilder.build(new ItemStack(Material.GOLDEN_APPLE), "&c&lDevil Apple troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cDevil Apple &etroll!", "&aSlips a golden apple into the player's inventory", "&awhich has catastrophic effects when eaten...")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " devilapple");
            player.closeInventory();
        });

        setItem(12, ItemBuilder.build(new ItemStack(Material.BARRIER), "&c&lKick troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &ckick &etroll!", "")), event -> {
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " kick");
            player.closeInventory();
        });
        setItem(13, ItemBuilder.build((new ItemStack(Material.PLAYER_HEAD)), "&c&lPlayerChat troll " + target.getName(), Arrays.asList("&cComing soon!", "")), event -> {
            player.closeInventory();
            player.sendMessage(TrollAssistant.colorize("&cComing soon!"));
        });
        setItem(14, ItemBuilder.build(new ItemStack(Material.RED_WOOL), "&c&lChat troll " + target.getName(), Arrays.asList("&cComing soon!")), event -> {
            player.closeInventory();
            player.sendMessage(TrollAssistant.colorize("&cComing soon!"));
        });
        setItem(15, ItemBuilder.build(new ItemStack(Material.TRAPPED_CHEST), "&c&lDemo Mode troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cDemo Mode &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " demo");
        });
        setItem(16, ItemBuilder.build(new ItemStack(Material.BOW), "&c&lPush troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cPush &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " push");
        });
        setItem(17, ItemBuilder.build(new ItemStack(Material.ENDER_PEARL), "&c&lEnderSpook troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cEnderSpook &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " EnderSpook");
        });
        setItem(18, ItemBuilder.build(new ItemStack(Material.FIRE_CHARGE), "&c&lFakeOP troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cFakeOP &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " fakeop");
        });
        setItem(19, ItemBuilder.build(new ItemStack(Material.SNOWBALL), "&c&lFreeze troll " + target.getName(), Arrays.asList("&eClick to troll &d" + target.getName() + " &ewith the &cFreeze &etroll!")), event -> {
            player.closeInventory();
            Bukkit.dispatchCommand(event.getWhoClicked(), "troll " + target.getName() + " freeze");
        });
        for (int i = 0; i <= 8; i++) {
            setItem(i, ItemBuilder.build(new ItemStack(Material.RED_STAINED_GLASS_PANE), "&cTroll Assistant &e" + target.getName(), Arrays.asList("")), event -> {
                player.closeInventory();
            });

        }
        for (int i = 27; i <= 35; i++) {
            setItem(i, ItemBuilder.build(new ItemStack(Material.RED_STAINED_GLASS_PANE), "&cTroll Assistant &e" + target.getName(), Arrays.asList("")), event -> {
                player.closeInventory();
            });
        }
            open(player);


    }
}
