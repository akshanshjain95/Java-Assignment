package edu.knoldus.Models;

import java.time.LocalDate;

public class Match {

    private int id, season, dlApplied, winByRuns, winByWickets;
    private String city, team1, team2, tossWinner, tossDecision, winner, playerOfMatch, venue, umpire1, umpire2, result;
    private LocalDate matchDate;

    public Match(int id, int season, String city, LocalDate matchDate, String team1, String team2, String tossWinner,
                 String tossDecision, String result, int dlApplied, String winner, int winByRuns, int winByWickets, String playerOfMatch,
                 String venue, String umpire1, String umpire2) {
        this.id = id;
        this.season = season;
        this.city = city;
        this.matchDate = matchDate;
        this.team1 = team1;
        this.team2 = team2;
        this.tossWinner = tossWinner;
        this.tossDecision = tossDecision;
        this.dlApplied = dlApplied;
        this.winner = winner;
        this.winByRuns = winByRuns;
        this.winByWickets = winByWickets;
        this.playerOfMatch = playerOfMatch;
        this.venue = venue;
        this.umpire1 = umpire1;
        this.umpire2 = umpire2;
        this.result = result;
    }

    public int getDlApplied() {
        return this.dlApplied;
    }

    public int getId() {
        return this.id;
    }

    public int getSeason() {
        return this.season;
    }

    public String getCity() {
        return this.city;
    }

    public LocalDate getMatchDate() {
        return this.matchDate;
    }

    public String getTeam1() {
        return this.team1;
    }

    public String getTeam2() {
        return this.team2;
    }

    public String getTossWinner() {
        return this.tossWinner;
    }

    public String getTossDecision() {
        return this.tossDecision;
    }

    public String getResult() {
        return this.result;
    }

    public String getWinner() {
        return this.winner;
    }

    public int getWinByRuns() {
        return this.winByRuns;
    }

    public int getWinByWickets() {
        return this.winByWickets;
    }

    public String getPlayerOfMatch() {
        return this.playerOfMatch;
    }

    public String getVenue() {
        return this.venue;
    }

    public String getUmpire1() {
        return this.umpire1;
    }

    public String getUmpire2() {
        return this.umpire2;
    }

}
