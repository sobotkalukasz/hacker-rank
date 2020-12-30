package pl.lsobotka.hacker.rank.algorithms;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/happy-ladybugs/problem
 */
public class LadyBugs {

    private final String YES = "YES";
    private final String NO = "NO";
    private final char SPACE = '_';

    public String happyLadybugs(String test) {
        if (isSingleCharPresent(test)) {
            return NO;
        } else if (isSpaceCharPresent(test)) {
            return YES;
        } else {
            return isAlreadySorted(test) ? YES : NO;
        }
    }

    public boolean isSingleCharPresent(String test) {
        Map<Character, Long> collect = test.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != SPACE)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

        return collect.values().stream().anyMatch(val -> val == 1);
    }

    public boolean isSpaceCharPresent(String test) {
        return test.chars().anyMatch(c -> (char) c == SPACE);
    }

    public boolean isAlreadySorted(String test) {
        int falseCount = 0;
        for (int index = 0; index < test.length() - 1; index++) {
            char c = test.charAt(index);
            if (c == test.charAt(index + 1)) {
                falseCount = 0;
            } else {
                if (index == test.length() - 1) {
                    falseCount = 2;
                }
                falseCount++;
            }
            if (falseCount >= 2) {
                return false;
            }
        }
        return true;
    }

}
