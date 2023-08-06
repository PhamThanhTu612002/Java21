package ManageRankedMatch.service;

import ManageRankedMatch.entities.Figure;
import ManageRankedMatch.entities.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamService {
    public Team createTeam(Scanner sc, ArrayList<Figure> figures, FigureService figureService){
        System.out.println("Nhập tên team: ");
        String name = sc.nextLine();
        System.out.println("Nhập thông tin tướng: ");
        for(int i = 0; i < 3; i++){
            figures.add(figureService.createFigure(sc));
        }
        return new Team(name,figures);
    }
}
