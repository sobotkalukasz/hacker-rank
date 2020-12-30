package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeInWordsTest {

    @ParameterizedTest
    @MethodSource("timeInWordsData")
    public void timeInWordsTest(int h, int m, String expectedOutput) {
        String actualOutput = TimeInWords.timeInWords(h, m);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> timeInWordsData(){
        return Stream.of(
                Arguments.of(5, 47, "thirteen minutes to six"),
                Arguments.of(3, 0, "three o' clock"),
                Arguments.of(7, 15, "quarter past seven"),
                Arguments.of(5, 0, "five o' clock"),
                Arguments.of(5, 1, "one minute past five"),
                Arguments.of(5, 10, "ten minutes past five"),
                Arguments.of(5, 15, "quarter past five"),
                Arguments.of(5, 30, "half past five"),
                Arguments.of(5, 40, "twenty minutes to six"),
                Arguments.of(5, 45, "quarter to six"),
                Arguments.of(5, 47, "thirteen minutes to six"),
                Arguments.of(5, 28, "twenty eight minutes past five")
        );
    }
}
