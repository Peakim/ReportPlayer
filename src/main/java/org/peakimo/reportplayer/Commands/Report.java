package org.peakimo.reportplayer.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {

    @Override
    public boolean onCommand (CommandSender sender, Command command, String label, String[] args){

        Player bazikon = (Player) sender;
        String playername = bazikon.getName();

        if (args.length == 0){
            sender.sendMessage(color("&cUse: /report (message)"));


        }

        if (bazikon.hasPermission("ReportPlayer.use")) {
            if (args.length > 0) {
                StringBuilder message = new StringBuilder();
                for (String arg : args) {
                    message.append(arg).append(" ");
                }
                String finalMessage = message.toString().trim();
                bazikon.sendMessage(color("&7[&c&lReport&r&7] &fYour report request has been submit."));

                //Ersal message to Admin report
                for (Player onlineplayers : Bukkit.getOnlinePlayers()) {

                    if (onlineplayers.hasPermission("ReportPlayer.admin")) {
                        onlineplayers.sendMessage(color("&7[&c&lReport&r&7] " + playername + " &c| &f" + finalMessage));
                    }
                }
            }
        }







        return true;
    }
    private String color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);


    }
}
