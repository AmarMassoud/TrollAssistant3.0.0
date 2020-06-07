package me.amar.trollassistant.Menus;

import me.amar.trollassistant.api.ReflectionUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class sendTitleMethod {
    public static void sendTitles(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        Class packetPlayOutTitleClass = ReflectionUtil.getNMSClass("PacketPlayOutTitle");
        Object times = ReflectionUtil.instantiate(
                ReflectionUtil.getConstructor(packetPlayOutTitleClass, int.class, int.class, int.class), fadeIn,
                stay, fadeOut);
        Class craftPlayerClass = ReflectionUtil.getOBCClass("entity.CraftPlayer");
        Class entityPlayerClass = ReflectionUtil.getNMSClass("EntityPlayer");
        Class playerConnectionClass = ReflectionUtil.getNMSClass("PlayerConnection");
        Class packetClass = ReflectionUtil.getNMSClass("Packet");

        Object craftPlayer = craftPlayerClass.cast(player);
        Object playerConn = ReflectionUtil.getField("playerConnection", entityPlayerClass,
                ReflectionUtil.invokeMethod(ReflectionUtil.getMethod("getHandle", craftPlayerClass), craftPlayer));
        ReflectionUtil.invokeMethod(ReflectionUtil.getMethod("sendPacket", playerConnectionClass, packetClass), playerConn, times);

        Class packetPlayOutTitleEnumTitleActionClass = ReflectionUtil.getNMSClass("PacketPlayOutTitle.EnumTitleAction");
        Class IChatBaseComponentClass = ReflectionUtil.getNMSClass("IChatBaseComponent");
        Class chatMessageClass = ReflectionUtil.getNMSClass("ChatMessage");

        if (title != null) {
            Object packetSubtitle = ReflectionUtil.instantiate(ReflectionUtil.getConstructor(packetPlayOutTitleClass,
                    packetPlayOutTitleEnumTitleActionClass, IChatBaseComponentClass), Enum.valueOf(packetPlayOutTitleEnumTitleActionClass,
                    "TITLE"), ReflectionUtil.instantiate(ReflectionUtil.getConstructor(chatMessageClass, String.class), title));

            ReflectionUtil.invokeMethod(ReflectionUtil.getMethod("sendPacket", playerConnectionClass, packetClass), playerConn,
                    packetSubtitle);
        }

        if (subtitle != null) {
            Object packetSubtitle =  ReflectionUtil.instantiate(ReflectionUtil.getConstructor(packetPlayOutTitleClass,
                    packetPlayOutTitleEnumTitleActionClass, IChatBaseComponentClass), Enum.valueOf(packetPlayOutTitleEnumTitleActionClass,
                    "SUBTITLE"), ReflectionUtil.instantiate(ReflectionUtil.getConstructor(chatMessageClass, String.class), subtitle));

            ReflectionUtil.invokeMethod(ReflectionUtil.getMethod("sendPacket", playerConnectionClass, packetClass), playerConn,
                    packetSubtitle);
        }

    }
}