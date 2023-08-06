package ManageRankedMatch.entities;

import java.time.LocalTime;
import java.util.ArrayList;

public class SummonRift {
    private ArrayList<Team> teams;
    private LocalTime time;

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public SummonRift(ArrayList<Team> teams, LocalTime time) {
        this.teams = teams;
        this.time = time;
    }

    @Override
    public String toString() {
        return "SummonRift{" +
                "teams=" + teams +
                ", time=" + time +
                '}';
    }
}
