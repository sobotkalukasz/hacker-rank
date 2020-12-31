package pl.lsobotka.hacker.rank.daysofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RunningTimeAndComplexityTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(12, RunningTimeAndComplexity.NOT_PRIME),
                Arguments.of(5, RunningTimeAndComplexity.PRIME),
                Arguments.of(7, RunningTimeAndComplexity.PRIME)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void regexTest(int test, String expected) {
        String actual = RunningTimeAndComplexity.isPrime(test);
        assertEquals(expected, actual);
    }
}
