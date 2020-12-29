package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtraLongFactorialTest {

    @ParameterizedTest
    @MethodSource("factorialData")
    public void factorialTest(int input, BigInteger expectedOutput) {
        BigInteger output = ExtraLongFactorial.extraLongFactorials(input);
        assertEquals(expectedOutput, output);
    }

    private static Stream<Arguments> factorialData(){
        return Stream.of(
                Arguments.of(25, new BigInteger("15511210043330985984000000")),
                Arguments.of(100, new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"))
        );
    }
}
