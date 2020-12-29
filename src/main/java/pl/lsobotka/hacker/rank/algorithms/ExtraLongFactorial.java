package pl.lsobotka.hacker.rank.algorithms;

import java.math.BigInteger;

/*
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 * */
public class ExtraLongFactorial {

    static BigInteger extraLongFactorials(int n) {
        if(n > 1){
            return extraLongFactorials(n-1).multiply(BigInteger.valueOf(n));
        }
        return BigInteger.ONE;
    }

}
