package fr.dam.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CommandFreeze implements CommandExecutor {

    private Main main;

    public CommandFreeze(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;

            if(label.equalsIgnoreCase("freeze")){
                if(args.length == 0){
                    p.sendMessage(ChatColor.RED + "Invalid command, type: /freeze [Player]");
                    return false;
                }
                String targetName = args[0];
                if(Bukkit.getPlayer(targetName) == null){
                    p.sendMessage(ChatColor.RED + "Invalid Player");
                    return false;
                }
                Player targetP = Bukkit.getPlayer(targetName);
                UUID targetUUID = targetP.getUniqueId();

                if(main.getFrozePlayers().contains(targetUUID)){
                    main.getFrozePlayers().add(targetUUID);
                    p.sendMessage(ChatColor.GREEN + targetP.getName() + " is no longer froze");
                    targetP.sendMessage(ChatColor.GREEN + "You are no longer froze");
                    return true;
                }
                main.getFrozePlayers().add(targetUUID);
                p.sendMessage(ChatColor.GREEN + targetP.getName() + " is now froze");
                targetP.sendMessage(ChatColor.RED + "You are now froze");
                return true;
            }
        }
        return false;
    }
}
