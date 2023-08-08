package ManageRankedMatch.service;

import ManageRankedMatch.entities.Figure;
import ManageRankedMatch.entities.SummonRift;
import ManageRankedMatch.entities.Team;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class SummonRiftService {
    public SummonRift createMatch(Scanner sc, ArrayList<Team> teams, TeamService teamService, ArrayList<Figure> figures, FigureService figureService){
        ArrayList<Figure> figures1 = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            System.out.println("Nhập team "+(i+1)+": ");
            if (i == 0){
                teams.add(teamService.createTeam(sc, figures, figureService));
                figures1.addAll(figures);
            }
            if (i == 1){
                teams.add(teamService.createTeam(sc, figures1, figureService));
                figures1.removeAll(figures);
            }
        }
        LocalTime time = LocalTime.now();
        return new SummonRift(teams,time);
    }
}
