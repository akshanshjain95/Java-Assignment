package edu.knoldus.Service;

import com.opencsv.CSVReader;
import edu.knoldus.Models.Match;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class CSV {

    public Stream<Match> createStream() {
        ArrayList<Match> personList = new ArrayList<>();
        String[] line = null;
        try (CSVReader reader = new CSVReader(new FileReader("/home/knoldus/Downloads/matches.csv"))) {
            while ((line = reader.readNext()) != null) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate matchDate = LocalDate.parse(line[3], dateTimeFormatter);
                Match person = new Match(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2], matchDate,
                        line[4], line[5], line[6], line[7], line[8], Integer.parseInt(line[9]), line[10],
                        Integer.parseInt(line[11]), Integer.parseInt(line[12]), line[13], line[14], line[15], line[16]);
                personList.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return personList.stream();
    }
}
