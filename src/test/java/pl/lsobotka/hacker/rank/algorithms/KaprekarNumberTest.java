package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KaprekarNumberTest {

    @ParameterizedTest
    @MethodSource("kaprekarData")
    public void kaprekarTest(int min, int max, List<String> expectedOutput) {
        List<String> actualOutput = KaprekarNumber.kaprekarNumbers(min, max);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> kaprekarData() {
        return Stream.of(
                Arguments.of(1, 100, Arrays.asList("1", "9", "45", "55", "99")),
                Arguments.of(45, 45, Collections.singletonList("45")),
                Arguments.of(100, 300, Collections.singletonList("297")),
                Arguments.of(400, 700, Collections.singletonList(KaprekarNumber.INVALID_RANGE))
        );
    }
}
