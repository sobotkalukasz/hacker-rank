package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lsobotka.hacker.rank.BaseTest;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonDivisibleSubsetTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("subsetData")
    public void subsetTest(int k, List<Integer> integers, int expectedOutput) {
        int actualOutput = NonDivisibleSubset.nonDivisibleSubset(k, integers);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> subsetData(){
        return Stream.of(
                Arguments.of(4, Arrays.asList(1, 7, 2, 4), 3),
                Arguments.of(7, Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436), 11)
        );
    }

    @Test
    public void subsetFileTest() throws Exception {

        String inputName = "NonDivisibleSubset_input";
        Deque<String> input = new LinkedList<>(getFileInput(inputName));

        int k = Integer.parseInt(input.removeFirst().trim());
        List<Integer> integers = Stream.of(input.removeFirst().split("\s"))
                .map(Integer::parseInt)
                .collect(toList());
        int expectedOutput = Integer.parseInt(input.removeFirst().trim());

        assertEquals(expectedOutput, NonDivisibleSubset.nonDivisibleSubset(k, integers));
    }

}
