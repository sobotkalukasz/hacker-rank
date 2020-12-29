package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BiggerIsGreaterTest {

    @ParameterizedTest
    @MethodSource("biggerIsGreaterData")
    public void biggerIsGreaterTest(String input, String expectedOutput) {
        String output = BiggerIsGreater.biggerIsGreater(input);
        assertEquals(expectedOutput, output);
    }

    private static Stream<Arguments> biggerIsGreaterData(){
        return Stream.of(
                Arguments.of("lmno", "lmon"),
                Arguments.of("dcba", "no answer"),
                Arguments.of("dcbb", "no answer"),
                Arguments.of("abdc", "acbd"),
                Arguments.of("abcd", "abdc"),
                Arguments.of("fedcbabcd", "fedcbabdc")
        );
    }
}
