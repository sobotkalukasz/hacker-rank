package pl.lsobotka.hacker.rank.daysofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HourGlassTest {

    @ParameterizedTest
    @MethodSource("findBiggestHourGlassData")
    public void findBiggestHourGlassTest(int[][] testArray, int expectedOutput) {
        int actualOutput = HourGlass.findBiggestHourGlass(testArray);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> findBiggestHourGlassData() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 1, 1, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0},
                                {1, 1, 1, 0, 0, 0},
                                {0, 0, 2, 4, 4, 0},
                                {0, 0, 0, 2, 0, 0},
                                {0, 0, 1, 2, 4, 0}}, 19)
        );
    }
}
