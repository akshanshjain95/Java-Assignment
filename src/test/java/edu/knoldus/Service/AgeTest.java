package edu.knoldus.Service;

import org.junit.Test;
import org.mockito.Matchers;

import java.time.LocalDateTime;

public class AgeTest {

    Age age = new Age();

    @Test
    public void testAge() {
        LocalDateTime birthday = LocalDateTime.of(1995, 10, 17,17,17,23);
        assert(age.calculateAge(birthday).equals(Matchers.anyString()));
    }

}
