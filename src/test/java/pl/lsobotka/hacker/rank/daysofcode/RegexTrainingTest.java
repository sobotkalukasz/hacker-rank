package pl.lsobotka.hacker.rank.daysofcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegexTrainingTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(Arrays.asList("riya riya@gmail.com", "julia julia@julia.me", "julia sjulia@gmail.com",
                        "julia julia@gmail.com", "samantha samantha@gmail.com", "tanya tanya@gmail.com"),
                        Arrays.asList("julia", "julia", "riya", "samantha", "tanya"))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void regexTest(List<String> namesEmails, List<String> expected) {
        List<String> actual = RegexTraining.namesGmailAccounts(namesEmails);
        assertEquals(expected, actual);
    }
}
