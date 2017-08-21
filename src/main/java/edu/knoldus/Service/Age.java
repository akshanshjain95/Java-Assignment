package edu.knoldus.Service;

import java.time.*;
import java.util.logging.Logger;

public class Age {

    Logger logger = Logger.getLogger(FileStreamOperations.class.getName());

    public String calculateAge(LocalDateTime birthdayDateTime) {

        LocalDate birthdayDate = birthdayDateTime.toLocalDate();
        LocalTime birthdayTime = birthdayDateTime.toLocalTime();
        LocalDate nowDate = LocalDate.now();
        LocalTime nowTime = LocalTime.now();
        Period period = Period.between(birthdayDate, nowDate);
        Duration duration = Duration.between(nowTime, birthdayTime);

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        long hours = duration.toHours();
        Duration durationAfterRemovingHours = duration.minusHours(hours);
        long minutes = durationAfterRemovingHours.toMinutes();
        Duration durationAfterRemovingMinutes = durationAfterRemovingHours.minusMinutes(minutes);
        long seconds = durationAfterRemovingMinutes.getSeconds();

        String age = "Years: " + years + " Months: " + months + " Days: " + days + " Hours: " + hours
                + " Minutes: " + minutes + " Seconds: " + seconds;

        logger.info("Age ----------------> " + age);

        return age;

    }

}
