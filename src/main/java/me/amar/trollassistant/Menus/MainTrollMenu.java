package me.amar.trollassistant.Menus;

import com.demeng7215.demlib.api.items.ItemBuilder;
import com.demeng7215.demlib.api.items.XMaterial;
import com.demeng7215.demlib.api.menus.CustomMenu;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.listeners.ChatPlayers;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class MainTrollMenu extends CustomMenu {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    public MainTrollMenu(Player p) {
        super(27, "&bChoose an option");
        setItem(12, ItemBuilder.build(new ItemStack(XMaterial.PLAYER_HEAD.parseItem()), "&b&lPersonal Troll Menu", Arrays.asList("&cClick me to choose from the global trolls")), event -> {
            p.closeInventory();
            ChatPlayers.addPlayerToChatList(p.getUniqueId());
            sendTitleMethod.sendTitles(p, TrollAssistant.colorize("&bPlease specify a player"), "", 1, 600, 1);
        });
        setItem(14, ItemBuilder.build(new ItemStack(XMaterial.CREEPER_HEAD.parseItem()), "&b&lGlobal Troll Menu", Arrays.asList("&cClick here to choose from the global trolls")), event -> {
            p.closeInventory();
            new GlobalTrollsMenu(p);
        });

        setBackground(new ItemStack(XMaterial.RED_STAINED_GLASS_PANE.parseItem()));
        open(p);
    }
}