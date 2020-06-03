package me.amar.trollassistant.commands;

import me.amar.trollassistant.Menus.TrollMenu;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.subcommands.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandManager implements CommandExecutor {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    private ArrayList<SubCommand> SubCommands = new ArrayList<>();

    public CommandManager() {
        SubCommands.add(new MLGCommand());
        SubCommands.add(new PotatoCommand());
        SubCommands.add(new ChatCommand());
        SubCommands.add(new DemoCommand());
        SubCommands.add(new DevilAppleCommand());
        SubCommands.add(new EnderSpookCommand());
        SubCommands.add(new FakeOPCommand());
        SubCommands.add(new FreezeCommand());
        SubCommands.add(new KickCommand());
        SubCommands.add(new PlayerChatCommand());
        SubCommands.add(new PushCommand());
        SubCommands.add(new FakeNukeCommand());

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(TrollAssistant.colorize("&2[&6Troll Assistant&2] &cPlease specify a player."));
        } else {
            Player target = null;
            try {
                target = Bukkit.getPlayer(args[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (target == null && !args[0].toLowerCase().equals("reload")) {
                sender.sendMessage(TrollAssistant.colorize("&cYour target must be online."));
            }
            if ("reload".equals(args[0].toLowerCase())) {
                System.out.println("Reloading config");
                plugin.reloadConfig();
                sender.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.reload")));


            } else if (args.length == 1) {
                if (sender instanceof Player) {
                    sender.sendMessage(TrollAssistant.colorize("&eTrolling &c" + sender.getName()));
                    new TrollMenu((Player) sender, target);
                } else {
                    sender.sendMessage(TrollAssistant.colorize("&cThis command can only be used by players"));
                }

            }



            else {
                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[1].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                        getSubCommands().get(i).perform(sender, args);
                    }
                }
            }

        }

        return true;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return SubCommands;
    }
}
//            for (int i = 0; i < getSubCommands().size(); i++) {
//                getSubCommands().get(i).getName();
//                if(getSubCommands().size() == i) {
//                    if(args.length == 2 && args[1] != "reload" && args[1] == null && args[2] != getSubCommands().get(i).getName() ) {
//                        sender.sendMessage(TrollAssistant.colorize("Please specify a valid troll."));
//                    }
//                }
//            }
//            if(args.length == 2 && args[1] != "reload" && args[1] == null && args[2] != ) {
//
//            }