package me.absolute.teamsplugin;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Team {
    private String name;
    ChatColor color;

    ArrayList<Player> players = new ArrayList<>();

    public Team(String name, ChatColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public String getColorCode() {
        return String.valueOf("&" + color.getChar());
    }
    public void setColor(ChatColor color) {
        this.color = color;
    }
}
