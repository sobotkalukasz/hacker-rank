package pl.lsobotka.hacker.rank.algorithms;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 *
 * */
public class NonDivisibleSubset {

    public static int nonDivisibleSubset(int k, List<Integer> integers) {

        if (k == 0 || k == 1) {
            return 1;
        }

        Map<Integer, Long> counted = integers.stream().map(i -> i % k)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int count = 0;

        for (int i = 0, j = k; i <= j; i++, j--) {
            Integer a = i;
            Integer b = j;

            if ((i == 0 || (k % 2 == 0 && i == k / 2)) && counted.containsKey(a)) {
                count++;
                continue;
            }
            if (counted.containsKey(a)) {
                if (counted.containsKey(b)) {
                    long aLong = counted.get(a);
                    long bLong = counted.get(b);
                    count += Math.max(aLong, bLong);
                } else {
                    count += counted.get(a);
                }
            } else if (counted.containsKey(b)) {
                count += counted.get(b);
            }
        }

        return count;
    }
}
