package me.amar.trollassistant.commands;


import me.amar.trollassistant.Menus.MainTrollMenu;
import me.amar.trollassistant.Menus.PersonalTrollsMenu;
import me.amar.trollassistant.TrollAssistant;
import me.amar.trollassistant.commands.subcommands.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TrollCommandManager implements CommandExecutor {
    private final TrollAssistant plugin = TrollAssistant.getPlugin(TrollAssistant.class);

    private ArrayList<SubCommand> SubCommands = new ArrayList<>();

    public TrollCommandManager() {
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
//        if (args.length == 0) {
//            new MainTrollMenu((Player) sender);
//            sender.sendMessage(TrollAssistant.colorize("opened main gui"));
//        } else {
//            Player target = null;
//            try {
//                target = Bukkit.getPlayer(args[0]);
//            } catch (Exception e) {
//                sender.sendMessage(TrollAssistant.colorize("&cWrong usage."));
//            }
//            if (target == null && !args[0].toLowerCase().equals("reload") && !args[0].equalsIgnoreCase("carrot")) {
//                new MainTrollMenu((Player) sender);
//                sender.sendMessage(TrollAssistant.colorize("opened main gui"));
//            }
//            if ("reload".equals(args[0].toLowerCase())) {
//                System.out.println("Reloading config");
//                plugin.reloadConfig();
//                sender.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.reload")));
//
//
//            } else if("carrot".equalsIgnoreCase(args[0])) {
//                Bukkit.dispatchCommand(sender, "troll carrot");
//            }
//
//            else if (args.length == 1) {
//                if (sender instanceof Player) {
//                    sender.sendMessage(TrollAssistant.colorize("&eTrolling &c" + sender.getName()));
//                    new PersonalTrollsMenu((Player) sender, target);
//                } else {
//                    sender.sendMessage(TrollAssistant.colorize("&cThis command can only be used by players"));
//                }
//
//            }

        if (args.length == 0) {
            new MainTrollMenu((Player) sender);
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                sender.sendMessage(TrollAssistant.colorize(plugin.getConfig().getString("messages.reload")));
            } else {
                if (sender instanceof Player) {
                    Player target = null;
                    try {
                        target = Bukkit.getPlayer(args[0]);
                    } catch (Exception e) {
                        sender.sendMessage(TrollAssistant.colorize("&cWrong usage."));
                    }
                    new PersonalTrollsMenu((Player) sender, target);
                } else {
                sender.sendMessage("Only players can use this command.");
                }
            }

        } else if(args.length == 2) {
            for (int i = 0; i < getSubCommands().size(); i++) {
                if (args[1].equalsIgnoreCase(getSubCommands().get(i).getName())) {
                    getSubCommands().get(i).perform(sender, args);
                }
            }
        } else {
            sender.sendMessage(TrollAssistant.colorize("&cIncorrect usage."));

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


// SHUT THE FUCK UP I DON'T HAVE MONEY TO BUY WINDOWS ok bye