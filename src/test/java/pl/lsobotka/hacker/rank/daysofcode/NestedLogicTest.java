package pl.lsobotka.hacker.rank.daysofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NestedLogicTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of("9 6 2015", "6 6 2015", 45)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void nestedLogicTest(String returnDate, String deadline, int expected) {
        int actual = NestedLogic.calcFine(returnDate, deadline);
        assertEquals(expected, actual);
    }
}
