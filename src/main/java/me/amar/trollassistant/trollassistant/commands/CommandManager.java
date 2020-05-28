package me.amar.trollassistant.trollassistant.commands;

import me.amar.trollassistant.trollassistant.TrollAssistant;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
                if (target == null && !args[0].toLowerCase().equals("reload")) {
                    sender.sendMessage(TrollAssistant.colorize("&cYour target must be online."));
                }
                if (args.length == 1) {
                    p.sendMessage(TrollAssistant.colorize("&eTrolling &c" + p.getName()));
                    new TrollMenu(p, target);



            }
        }
        return true;
    }
}
