package edu.knoldus;

import edu.knoldus.Service.FileStreamOperations;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.logging.Logger;

public class MethodCall {

    FileStreamOperations operations;
    Logger logger = Logger.getLogger(FileStreamOperations.class.getName());

    public MethodCall(FileStreamOperations operations) {
        this.operations = operations;
    }

    public String initializeMethods() {
        long count = operations.noOfMatches();
        logger.info("Number of matches -----------> " + count);

        boolean resultOfAllMatch = operations.allNormal();
        logger.info("Were all matches normal? -----------> " + resultOfAllMatch);

        boolean resultOfAnyMatch = operations.wasHeManOfMatch("SR Tendulkar");
        logger.info("Did Sachin receive man of match in IPL?  -----------> " + resultOfAnyMatch);

        boolean resultOfNoneMatch = operations.wereThereDuckWorthLewisMatches();
        logger.info("Did any match went to Duck Worth Lewis Method? -----------> " + resultOfNoneMatch);

        double averageOfWinByRuns = operations.winByRunsAverage();
        logger.info("When won by runs, average runs were -----------> " + averageOfWinByRuns);

        Optional<String> longestPlayerOfMatchName = operations.longestPlayerOfMatchName();
        logger.info("Longest name among players of match(empty if stream is empty) -----------> " + longestPlayerOfMatchName.orElse("empty"));

        OptionalInt closeMatchRuns = operations.closeMatchWinByRuns();
        logger.info("Close match where team won by runs(0 if stream is empty) -----------> " + closeMatchRuns.orElse(0));

        int matchesWonByTeamBattingFirst = operations.matchesWonByTeamBattingFirst();
        logger.info("Matches won by team that was batting first -----------> " + matchesWonByTeamBattingFirst);

        String firstMatchWinner = operations.firstMatchWinner();
        logger.info("First winner of an IPL match (EmptyStream if stream was empty) -----------> " + firstMatchWinner);

        long noOfTeams = operations.noOfTeams();
        logger.info("Total number of teams in IPL -----------> " + noOfTeams);

        int limit = 10;
        String firstNMatch = operations.firstNMatch(limit);
        logger.info("Analysis of first "+limit+" match ------------->" + firstNMatch);

        int skip = 10;
        String winnerOfNthMatch = operations.winnerOfNthMatch(skip);
        logger.info("Winner of "+skip+"th match ------------->" + winnerOfNthMatch);

        Optional<String> manOfMathcOfFirstDLMatch = operations.manOfMatchOfFirstDLMatch();
        logger.info("Man of match of first Duck Worth Lewis Method match in IPL(Empty Stream if Stream was empty) ------------->" + manOfMathcOfFirstDLMatch.orElse("Empty Stream"));

        OptionalDouble wonByWicketsAverage = operations.wonByWicketsAverage();
        logger.info("When won by wickets, average wicket difference was(0.0 if stream was empty) ------------->" + wonByWicketsAverage.orElse(0.00));

        String mostMatchesWon = operations.mostMatchesWon();
        logger.info("Most matches won by team(EmptyStream if stream was empty) ------------->" + mostMatchesWon);

        return "All methods successfully executed";
    }
}
