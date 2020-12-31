package pl.lsobotka.hacker.rank.daysofcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/30-nested-logic/problem
 * */
public class NestedLogic {

    private final static int DAY_INDEX = 0;
    private final static int MONTH_INDEX = 1;
    private final static int YEAR_INDEX = 2;

    private final static int YEAR_FINE = 10_000;
    private final static int MONTH_FINE = 500;
    private final static int DAY_FINE = 15;
    private final static int NO_FINE = 0;

    public static int calcFine(String returnDate, String expectedDate) {
        List<Integer> returned = Arrays.stream(returnDate.split("\s")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> expected = Arrays.stream(expectedDate.split("\s")).map(Integer::valueOf).collect(Collectors.toList());

        if (returned.get(YEAR_INDEX) > expected.get(YEAR_INDEX)) {
            return YEAR_FINE;
        } else if (returned.get(YEAR_INDEX) < expected.get(YEAR_INDEX)) {
            return NO_FINE;
        } else {
            if (returned.get(MONTH_INDEX) > expected.get(MONTH_INDEX)) {
                return MONTH_FINE * (returned.get(MONTH_INDEX) - expected.get(MONTH_INDEX));
            } else if (returned.get(MONTH_INDEX) < expected.get(MONTH_INDEX)) {
                return NO_FINE;
            } else {
                if (returned.get(DAY_INDEX) > expected.get(DAY_INDEX)) {
                    return DAY_FINE * (returned.get(DAY_INDEX) - expected.get(DAY_INDEX));
                } else if (returned.get(DAY_INDEX) <= expected.get(DAY_INDEX)) {
                    return NO_FINE;
                }
            }
        }
        return NO_FINE;
    }
}

