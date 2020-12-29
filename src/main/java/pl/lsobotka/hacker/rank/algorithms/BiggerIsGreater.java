package pl.lsobotka.hacker.rank.algorithms;


import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * */
public class BiggerIsGreater {

    static final String NO_ANSWER = "no answer";

    static String biggerIsGreater(String word) {

        BigInteger initialSize = new BigInteger(word.chars()
                .map(Character::getNumericValue)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));

        String nextPermutation = Stream.of(nextPermutation(word.toCharArray())).map(String::new).collect(Collectors.joining());

        BigInteger nextPermutationSize = new BigInteger(nextPermutation.chars()
                .map(Character::getNumericValue)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));

        if (initialSize.compareTo(nextPermutationSize) < 0) {
            return nextPermutation;
        }
        return NO_ANSWER;
    }

    public static char[] nextPermutation(char[] chars) {
        int mark = -1;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                mark = i - 1;
                break;
            }
        }

        if (mark == -1) {
            return reverse(chars, 0, chars.length - 1);
        }

        int idx = chars.length - 1;
        for (int i = chars.length - 1; i >= mark + 1; i--) {
            if (chars[i] > chars[mark]) {
                idx = i;
                break;
            }
        }

        swap(chars, mark, idx);
        reverse(chars, mark + 1, chars.length - 1);
        return chars;
    }

    private static char[] reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
        return chars;
    }

    private static void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

}
