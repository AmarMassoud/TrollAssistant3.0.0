package me.amar.trollassistant.modules;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplaceTrollPlayer {

    private UUID uuid;

    private char replace;
    private char replaceWith;

    public ReplaceTrollPlayer(Player p, char replace, char replaceWith) {
        this.uuid = p.getUniqueId();
        this.replace = replace;
        this.replaceWith = replaceWith;
    }

    public Player getPlayer() {
        return Bukkit.getServer().getPlayer(uuid);
    }

    public char getReplace() {
        return replace;
    }

    public char getReplaceWith() {
        return replaceWith;
    }

    public void setPlayer(Player p) {
        this.uuid = p.getUniqueId();
    }

    public void setReplace(char replace) {
        this.replace = replace;
    }

    public void setReplaceWith(char replaceWith) {
        this.replaceWith = replaceWith;
    }
}
