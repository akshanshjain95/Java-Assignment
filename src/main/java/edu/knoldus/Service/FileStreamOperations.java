package edu.knoldus.Service;

import edu.knoldus.Models.Match;

import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileStreamOperations {

    CSV csvFile;

    public FileStreamOperations(CSV csvFile) {
        this.csvFile = csvFile;
    }

    public long noOfMatches() {
        Stream<Match> matchStream = csvFile.createStream();
        return matchStream.count();
    }

    public boolean allNormal() {
        Stream<Match> matchStream = csvFile.createStream();
        Predicate<String> allMatchPredicate = result -> result.equals("normal");
        return matchStream.map(Match::getResult).allMatch(allMatchPredicate::test);
    }

    public boolean wasHeManOfMatch(String nameOfPlayer) {
        Stream<Match> matchStream = csvFile.createStream();
        Predicate<String> anyMatchPredicate = name -> name.equals(nameOfPlayer);
        return matchStream.map(Match::getPlayerOfMatch).anyMatch(anyMatchPredicate::test);
    }

    public boolean wereThereDuckWorthLewisMatches() {
        Stream<Match> matchStream = csvFile.createStream();
        Predicate<Integer> noneMatchPredicate = dlApplied -> dlApplied == 1;
        return !matchStream.map(Match::getDlApplied).noneMatch(noneMatchPredicate::test);
    }

    public Optional<String> longestPlayerOfMatchName() {
        Stream<Match> matchStream = csvFile.createStream();
        return matchStream.map(Match::getPlayerOfMatch).max(Comparator.comparingInt(String::length));
    }

    public OptionalInt closeMatchWinByRuns() {
        Stream<Match> matchStream = csvFile.createStream();
        return matchStream.map(Match::getWinByRuns).filter(runs -> runs > 0).mapToInt(Integer::intValue).min();
    }

    public double winByRunsAverage() {
        Stream<Match> matchStream = csvFile.createStream();
        IntSummaryStatistics stats = matchStream.filter(match -> match.getWinByRuns()>0).collect(Collectors.summarizingInt(Match::getWinByRuns));
        return stats.getAverage();
    }

    public int matchesWonByTeamBattingFirst() {
        Stream<Match> matchStream = csvFile.createStream();
        return matchStream.map(Match::getWinByRuns).reduce(0, (count, matchWonByRuns) -> matchWonByRuns>0 ? count+=1 : count);
    }

    public String firstMatchWinner() {
        Stream<Match> matchStream = csvFile.createStream();
        Optional<String> firstWinner =  matchStream.map(Match::getWinner).findFirst();
        return firstWinner.orElse("EmptyStream");
    }

    public long noOfTeams() {
        Stream<Match> matchStream = csvFile.createStream();
        return matchStream.flatMap(match -> Stream.of(match.getTeam1(), match.getTeam2())).distinct().count();
    }

    public String firstNMatch(long limit) {
        Stream<Match> matchStream = csvFile.createStream();
        long count = matchStream.limit(limit).filter(match -> match.getWinByRuns()>0).count();
        if(count > limit/2) {
            return "First " + limit + " match(es) were mostly won by team batting first";
        }
        else if(count < limit/2) {
            return "First " + limit + " match(es) were mostly won by team bowling first";
        }
        else {
            return "First " + limit + " match(es) were equally won by teams bowling or batting first";
        }
    }

    public String winnerOfNthMatch(long skip) {
        Stream<Match> matchStream = csvFile.createStream();
        Optional<String> winner = matchStream.skip(skip-1).map(Match::getWinner).findFirst();
        return winner.orElse("EmptyStream");
    }

    public Optional<String> manOfMatchOfFirstDLMatch() {
        Stream<Match> matchStream = csvFile.createStream();
        return matchStream.sorted(Comparator.comparingInt(Match::getDlApplied).reversed())
                .map(Match::getPlayerOfMatch).findFirst();
    }

    public OptionalDouble wonByWicketsAverage() {
        Stream<Match> matchStream = csvFile.createStream();
        return matchStream.filter(match -> match.getWinByWickets()>0).mapToInt(Match::getWinByWickets).average();
    }

    public String mostMatchesWon() {
        Stream<Match> matchStream = csvFile.createStream();
        Optional<Map.Entry<String, Long>> first = matchStream.collect(Collectors.groupingBy(Match::getWinner, Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).findFirst();
        return first.map(Map.Entry::getKey).orElse("EmptyStream");
    }

}
