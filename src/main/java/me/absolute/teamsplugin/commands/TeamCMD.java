package me.absolute.teamsplugin.commands;

import me.absolute.teamsplugin.Team;
import me.absolute.teamsplugin.TeamManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.awt.*;

public class TeamCMD implements CommandExecutor {
    private static Team selectTeam;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("Отсутствуют аргументы команды. Use /team help");

            return false;
        }

        if (args[0].equalsIgnoreCase("help")) { //WRITE HELP LIST
            sender.sendMessage(color("&3<-----HELP MENU----->\n" +
                    "&6/tms create <name> <color>\n" +
                    "&6/tms delete <name>\n" +
                    "&6/tms addmember/am <team> <nickname>\n" +
                    "&6/tms removemember/rm <team> <nickname>"));
            return true;
        }

        if (args[0].equalsIgnoreCase("list")) { //WRITE COMMAND LIST
            StringBuilder builder = new StringBuilder();
            TeamManager.getTeamsList().forEach(x -> builder.append(color(x.getColorCode() + x.getName())).append(" "));
            if (builder.length() > 0) {
                sender.sendMessage(builder.toString());
                return true;
            } else {
                sender.sendMessage("Список команд пуст");
                return true;
            }
        }
        if(args[0].equalsIgnoreCase("colors")) { //---
        }


        if (args[0].equalsIgnoreCase("create")) { //CREATE TEAM
            ChatColor color;
            try {
                color = ChatColor.getByChar(args[2]);
            } catch (Exception e) {
                 color = ChatColor.GRAY;
            }
            if (!TeamManager.addTeam(new Team(args[1], color))) {
                sender.sendMessage("Команда с таким названием уже существует");
                return false;
            }
            else {
                sender.sendMessage(color("&aКоманда &" + color.getChar() + args[1] + " &aбыла &aуспешно &aсозданна!"));
            }
        }


        //The functions mean that the command has already been created


        if (args[0].equalsIgnoreCase("delete")) { //DELETE TEAM

        }

        if (args[0].equals("addmember") || args[0].equals("am")) { //ADD MEMBER


        }
        if (args[0].equals("removemember") || args[0].equals("rm")) { //REMOVE MEMBER

        }
        if (args[0].equalsIgnoreCase("color")) { //tms color name set
            if (args[2].equalsIgnoreCase("set")) {
                ChatColor color = ChatColor.valueOf(args[2]);
                if(color == null) {
                    sender.sendMessage("Такого цвета не существует");
                    return false;
                }
                selectTeam.setColor(color);
                return true;
            }
        }

        return false;
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void readTeam(String name) {
        selectTeam = TeamManager.getTeamByName(name);

    }
}
