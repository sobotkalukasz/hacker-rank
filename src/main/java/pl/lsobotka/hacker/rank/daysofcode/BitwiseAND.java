package pl.lsobotka.hacker.rank.daysofcode;

/*
 * https://www.hackerrank.com/challenges/30-bitwise-and/problem
 * */
public class BitwiseAND {

    public static int maxValue(int n, int k) {
        int solution = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int temp = i & j;
                if (temp < k && temp > solution)
                    solution = temp;
                if (solution == k - 1)
                    break;
            }
        }
        return solution;
    }
}
