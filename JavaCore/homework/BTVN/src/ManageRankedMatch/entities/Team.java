package ManageRankedMatch.entities;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Figure> figures;

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public void setFigures(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public Team(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team(String name, ArrayList<Figure> figures) {
        this.name = name;
        this.figures = figures;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", figures=" + figures +
                '}';
    }
}
