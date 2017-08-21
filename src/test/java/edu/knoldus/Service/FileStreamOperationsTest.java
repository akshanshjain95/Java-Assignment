package edu.knoldus.Service;

import static org.junit.Assert.*;

import edu.knoldus.Models.Match;
import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class FileStreamOperationsTest {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate matchDate = LocalDate.parse("2008-04-18", dateTimeFormatter);


    Stream<Match> matchStream = Stream.of(
            new Match(1,2008,"Bangalore",matchDate,"Kolkata Knight Riders","Royal Challengers Bangalore",
                    "Royal Challengers Bangalore","field","normal",0,"Kolkata Knight Riders",
                    140,0,"BB McCullum","M Chinnaswamy Stadium","Asad Rauf",
                    "RE Koertzen"),
            new Match(1,2008,"Bangalore",matchDate,"Kolkata Knight Riders","Royal Challengers Bangalore",
                    "Royal Challengers Bangalore","field","normal",1,"Kolkata Knight Riders",
                    140,0,"BB McCullum","M Chinnaswamy Stadium","Asad Rauf",
                    "RE Koertzen")
    );


    CSV mockCSV = Mockito.mock(CSV.class);
    FileStreamOperations fileStreamOperations = new FileStreamOperations(mockCSV);

    @Test
    public void testNoOfMatches() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.noOfMatches() == 2);
    }

    @Test
    public void testAllNormalMatches() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.allNormal());
    }

    @Test
    public void testAnyMatch() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(!fileStreamOperations.wasHeManOfMatch("SR Tendulkar"));
    }

    @Test
    public void testDLMatches() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.wereThereDuckWorthLewisMatches());
    }

    @Test
    public void testWinByRunsAverage() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.winByRunsAverage() == 140.00);
    }

    @Test
    public void testLongestName() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.longestPlayerOfMatchName().orElse("Empty").equals("BB McCullum"));
    }

    @Test
    public void testMatchesWonByTeamBattingFirst() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.matchesWonByTeamBattingFirst() == 2);
    }

    @Test
    public void testTeamsOfFirstMatch() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.firstMatchWinner().equals("Kolkata Knight Riders"));
    }

    @Test
    public void testTotalNoOfTeams() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.noOfTeams() == 2);
    }

    @Test
    public void testFirstNMatch() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.firstNMatch(1).equals("First " + 1 + " match(es) were mostly won by team batting first"));
    }

    @Test
    public void testWinnerOfNthMatch() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.winnerOfNthMatch(1).equals("Kolkata Knight Riders"));
    }

    @Test
    public void testManOfMatchOfFirstDLMatch() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.manOfMatchOfFirstDLMatch().orElse("").equals("BB McCullum"));
    }

    @Test
    public void testWonByWicketsAverage() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.wonByWicketsAverage().orElse(0.0)== 0.0);
    }

    @Test
    public void testMostMatchesWon() {
        Mockito.when(mockCSV.createStream()).thenReturn(matchStream);
        assert(fileStreamOperations.mostMatchesWon().equals("Kolkata Knight Riders"));
    }

    /*@Test
    public void testFindAny() {
        Mockito.when(mockCSV.createStream()).thenReturn(personStream);
        assert(fileStreamOperations.findAnyInStream());
    }

    @Test
    public void testFindFirst() {
        Mockito.when(mockCSV.createStream()).thenReturn(personStream);
        assert(fileStreamOperations.findFirstInStream());
    }*/

}