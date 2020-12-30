package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfaceAreaTest {

    @ParameterizedTest
    @MethodSource("surfaceAreaData")
    public void surfaceAreaTest(Integer[][] arr, int expectedOutput) {
        int actualOutput = SurfaceArea.surfaceArea(arr);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> surfaceAreaData() {
        return Stream.of(
                Arguments.of(new Integer[][]{{1}}, 6),
                Arguments.of(new Integer[][]{{3, 5}}, 30),
                Arguments.of(new Integer[][]{{3}, {6}}, 34),
                Arguments.of(new Integer[][]{{51}, {32}, {28}, {49}, {28}, {21}, {98}, {56}, {99}, {77}}, 1482),
                Arguments.of(new Integer[][]{
                        {1, 3, 4},
                        {2, 2, 3},
                        {1, 2, 4}}, 60)
        );
    }
}
