package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lsobotka.hacker.rank.BaseTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingLeaderboardTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("simpleTestData")
    public void climbingLeaderboardTest(List<Integer> ranked, List<Integer> player, List<Integer> expected) {
        List<Integer> result = ClimbingLeaderboard.climbingLeaderboard(ranked, player);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> simpleTestData() {
        return Stream.of(
                Arguments.of(Arrays.asList(101, 100, 90, 90, 85, 80, 77, 75, 65, 60, 57, 55, 53, 50, 40, 30, 20, 17, 15, 10),
                        Arrays.asList(50, 65, 77, 90, 102),
                        Arrays.asList(13, 8, 6, 3, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("fileData")
    public void climbingLeaderboardFromFileTest(String inputName, String outputName) throws Exception {
        List<String> input = getFileInput(inputName);

        List<Integer> ranked = Stream.of(input.get(0).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> player = Stream.of(input.get(1).split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = ClimbingLeaderboard.climbingLeaderboard(ranked, player);

        List<Integer> expectedResult = getFileInput(outputName).stream().map(Integer::parseInt)
                .collect(Collectors.toList());

        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> fileData() {
        return Stream.of(
                Arguments.of("ClimbingLeaderboard_input", "ClimbingLeaderboard_output")
        );
    }
}
