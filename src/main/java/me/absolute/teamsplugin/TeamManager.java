package me.absolute.teamsplugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TeamManager {
    private static List<Team> teamsList = new ArrayList<>();

    public static List<Team> getTeamsList () {
        return teamsList;
    }
    public static Team getTeamByName(String name) {
        for(Team team : teamsList) {
            if(team.getName().equals(name)) {
                return team;
            }
        }
        return null;

    }

    public static boolean addTeam(Team team) {
        AtomicBoolean exodus = new AtomicBoolean(true); //Проверяем список всех имеющихся комманд на наличие дубликата
        teamsList.forEach(x ->  {
            if(x.getName().equalsIgnoreCase(team.getName())) {
                exodus.set(false);
            }
        });
        if(!exodus.get()) {
            return false;
        }

        teamsList.add(team);

        return true;
    }
}
