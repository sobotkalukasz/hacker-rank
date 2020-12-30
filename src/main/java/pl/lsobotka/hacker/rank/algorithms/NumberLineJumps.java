package pl.lsobotka.hacker.rank.algorithms;

/*
 * https://www.hackerrank.com/challenges/kangaroo/problem
 */
public class NumberLineJumps {

    private final static String YES = "YES";
    private final static String NO = "NO";

    static String kangaroo(int x1, int v1, int x2, int v2) {

        int biggerPos;
        int biggerJum;
        int lowerPos;
        int lowerJump;

        if (x1 == x2) {
            return v1 == v2 ? YES : NO;
        } else if (x1 > x2) {
            biggerPos = x1;
            biggerJum = v1;
            lowerPos = x2;
            lowerJump = v2;
        } else {
            biggerPos = x2;
            biggerJum = v2;
            lowerPos = x1;
            lowerJump = v1;
        }

        while (lowerPos < biggerPos) {
            biggerPos = biggerPos + biggerJum;
            lowerPos = lowerPos + lowerJump;
        }

        return biggerPos == lowerPos ? YES : NO;
    }

}
