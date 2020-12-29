package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncryptionTest {

    @ParameterizedTest
    @MethodSource("encryptionData")
    public void encryptionTest(String input, String expectedOutput) {
        String output = Encryption.encryption(input);
        assertEquals(expectedOutput, output);
    }

    private static Stream<Arguments> encryptionData(){
        return Stream.of(
                Arguments.of("haveaniceday", "hae and via ecy"),
                Arguments.of("feedthedog", "fto ehg ee dd"),
                Arguments.of("chillout", "clu hlt io")
        );
    }
}
