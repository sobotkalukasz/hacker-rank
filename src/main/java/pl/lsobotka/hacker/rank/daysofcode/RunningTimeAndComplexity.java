package pl.lsobotka.hacker.rank.daysofcode;

/*
 * https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem
 * */
public class RunningTimeAndComplexity {

    static final String PRIME = "Prime";
    static final String NOT_PRIME = "Not prime";

    public static String isPrime(long numberToTest) {
        if (numberToTest < 2)
            return NOT_PRIME;
        for (long i = 2; i * i <= numberToTest; i++)
            if (numberToTest % i == 0)
                return NOT_PRIME;
        return PRIME;
    }
}
