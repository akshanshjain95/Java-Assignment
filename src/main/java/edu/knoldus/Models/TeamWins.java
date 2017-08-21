package edu.knoldus.Models;

public class TeamWins {

    String teamName;
    int noOfWins;

    public TeamWins(String teamName, int noOfWins) {
        this.teamName = teamName;
        this.noOfWins = noOfWins;
    }

    public String getTeamName() {
        return this.teamName;
    }

    public int getNoOfWins() {
        return this.noOfWins;
    }

}
