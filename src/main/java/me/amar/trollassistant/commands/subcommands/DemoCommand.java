package me.amar.trollassistant.commands.subcommands;

import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DemoCommand extends SubCommand {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    @Override
    public String getName() {
        return "demo";
    }

    @Override
    public String getDescription() {
        return "Troll players with the demo troll.";
    }

    @Override
    public String getSyntax() {
        return "/troll <player> demo";
    }

    @Override
    public void preform(Player p, CommandSender s, String[] args) {
        Player target = null;
        try {
            target = Bukkit.getPlayer(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!s.hasPermission("troll.demo") || !s.hasPermission("troll.*")) {
            s.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
        } else {
            String path = Bukkit.getServer().getClass().getPackage().getName();
            String version = path.substring(path.lastIndexOf(".") + 1, path.length());
            try {
                Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
                Class<?> PacketPlayOutGameStateChange = Class.forName("net.minecraft.server." + version + ".PacketPlayOutGameStateChange");
                Class<?> Packet = Class.forName("net.minecraft.server." + version + ".Packet");
                Constructor<?> playOutConstructor = PacketPlayOutGameStateChange.getConstructor(new Class[]{int.class, float.class});
                Object demoPacket = playOutConstructor.newInstance(new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                Object craftPlayerObject = craftPlayer.cast(target);
                Method getHandleMethod = craftPlayer.getMethod("getHandle", new Class[0]);
                Object handle = getHandleMethod.invoke(craftPlayerObject, new Object[0]);
                Object pc = handle.getClass().getField("playerConnection").get(handle);
                Method sendPacketMethod = pc.getClass().getMethod("sendPacket", new Class[]{Packet});
                sendPacketMethod.invoke(pc, new Object[]{demoPacket});
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            s.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] " + target.getDisplayName() + " &chas been trolled with the &bDemo Mode &ctroll."));
        }
    }
}
