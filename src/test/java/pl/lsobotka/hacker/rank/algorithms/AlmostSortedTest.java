package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lsobotka.hacker.rank.BaseTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlmostSortedTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("almostSortedData")
    public void almostSortedTest(List<Integer> testData, String expectedOutput) {
        AlmostSorted sorted = new AlmostSorted();
        String actualOutput = sorted.almostSorted(testData);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> almostSortedData() {
        return Stream.of(
                Arguments.of(Arrays.asList(4, 2), "yes\nswap 1 2"),
                Arguments.of(Arrays.asList(3, 1, 2), "no"),
                Arguments.of(Arrays.asList(1, 5, 4, 3, 2, 6), "yes\nreverse 2 5"),
                Arguments.of(Arrays.asList(1, 2, 3, 4), "yes"),
                Arguments.of(Collections.singletonList(3), "yes"),
                Arguments.of(Arrays.asList(1, 2, 8, 6, 7, 9), "no"),
                Arguments.of(Arrays.asList(1, 3, 2, 4, 6, 5), "no")
        );
    }

    @ParameterizedTest
    @MethodSource("almostSortedFiles")
    public void almostSortedFromFile(String fileName, String expectedOutput) throws Exception {

        List<String> input = getFileInput(fileName);
        List<Integer> integers = input.stream().flatMap(line -> Stream.of(line.split(" "))).map(Integer::parseInt).collect(Collectors.toList());

        AlmostSorted sorted = new AlmostSorted();
        String actualOutput = sorted.almostSorted(integers);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> almostSortedFiles() {
        return Stream.of(
                Arguments.of("AlmostSorted_input_01", "yes\nswap 19429 37227"),
                Arguments.of("AlmostSorted_input_02", "yes\nreverse 3023 57991"),
                Arguments.of("AlmostSorted_input_03", "yes\nswap 176 189")
        );
    }
}
