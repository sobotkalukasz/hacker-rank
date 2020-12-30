package pl.lsobotka.hacker.rank.daysofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitwiseANDTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(5, 2, 1),
                Arguments.of(8, 5, 4),
                Arguments.of(2, 2, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void bitwiseANDTest(int a, int b, int expected) {
        int actual = BitwiseAND.maxValue(a, b);
        assertEquals(expected, actual);
    }
}
