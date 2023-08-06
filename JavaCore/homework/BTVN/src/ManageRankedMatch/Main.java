package ManageRankedMatch;

import ManageRankedMatch.entities.Figure;
import ManageRankedMatch.entities.Team;
import ManageRankedMatch.service.FigureService;
import ManageRankedMatch.service.SummonRiftService;
import ManageRankedMatch.service.TeamService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Figure> figures = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();
        FigureService figureService = new FigureService();
        TeamService teamService = new TeamService();
        SummonRiftService summonRiftService = new SummonRiftService();
        System.out.println(summonRiftService.createMatch(sc,teams,teamService,figures,figureService));
    }
}
