package me.amar.trollassistant.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class SubCommand {


    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract void perform(CommandSender s, String args[]);

}
