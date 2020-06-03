package me.amar.trollassistant.commands;
import org.bukkit.command.CommandSender;

public class hasPermission {
    public static boolean hasPermissions(CommandSender s, String permission) {
        if(s.hasPermission(permission) || s.hasPermission("troll.*")) {
            return true;
        } else {
            return false;
        }

    }



}
