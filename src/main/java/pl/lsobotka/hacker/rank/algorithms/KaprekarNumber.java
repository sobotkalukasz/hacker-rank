package pl.lsobotka.hacker.rank.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
public class KaprekarNumber {

    static final String INVALID_RANGE = "INVALID RANGE";

    static List<String> kaprekarNumbers(int p, int q) {
        return IntStream.rangeClosed(p, q).mapToLong(Long::valueOf)
                .filter(KaprekarNumber::test).mapToObj(String::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.isEmpty() ? Collections.singletonList(INVALID_RANGE) : list));
    }

    static boolean test(long toTest) {
        int digitLen = String.valueOf(toTest).length();
        long sqrt = toTest * toTest;
        String sqrtStr = Long.toString(sqrt);
        if (sqrtStr.length() > 1) {
            int right = Integer.parseInt(sqrtStr.substring(sqrtStr.length() - digitLen));
            int left = Integer.parseInt(sqrtStr.substring(0, sqrtStr.length() - digitLen));
            return left + right == toTest;
        }
        return sqrt == toTest;
    }

}
