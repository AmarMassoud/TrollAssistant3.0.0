package me.amar.trollassistant.Global;

import me.amar.trollassistant.Global.GlobalSubCommands.GlobalMLGCommand;
import me.amar.trollassistant.Menus.GlobalTrollsMenu;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.SubCommand;
import me.amar.trollassistant.Global.GlobalSubCommands.GlobalCarrotCommand;
import me.amar.trollassistant.commands.subcommands.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class GlobalTrollCommandManager implements CommandExecutor {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);
    private ArrayList<SubCommand> GSubCommands = new ArrayList<>();

    public GlobalTrollCommandManager() {
        GSubCommands.add(new GlobalCarrotCommand());
        GSubCommands.add(new GlobalMLGCommand());
    }


    @Override
    public boolean onCommand(CommandSender s, Command command, String label, String[] args) {


        if (s instanceof Player) {
            Player p = (Player) s;
            if (args.length == 0) {
                if(p.hasPermission("globaltroll.gui")) {
                    new GlobalTrollsMenu(p);
                    p.sendMessage(TrollAssistant.colorize("&cOpening the Global troll menu."));
                } else {
                    p.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.NoPermission")));
                }
                } else {
                for (int i = 0; i < getGSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getGSubCommands().get(i).getName())) {
                        getGSubCommands().get(i).perform(s, args);
                    }
                }
            }
        } else {
            s.sendMessage("Please specify a valid troll.");

        }
            return true;

    }


    public ArrayList<SubCommand> getGSubCommands() {
        return GSubCommands;
    }
}
