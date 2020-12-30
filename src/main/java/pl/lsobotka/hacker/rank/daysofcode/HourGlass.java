package pl.lsobotka.hacker.rank.daysofcode;

/*
 * https://www.hackerrank.com/challenges/30-2d-arrays/problem
 * */

import java.util.stream.IntStream;

public class HourGlass {

    public static int findBiggestHourGlass(int[][] testArray) {

        int hourGlassLength = 3;

        int biggest = Integer.MIN_VALUE;

        int rows = testArray.length;
        int columns = testArray.length > 0 ? testArray[0].length : 0;

        for (int row = 0; row <= rows - hourGlassLength; row++) {
            for (int column = 0; column <= columns - hourGlassLength; column++) {
                int[] count = new int[7];
                count[0] = testArray[row][column];
                count[1] = testArray[row][column + 1];
                count[2] = testArray[row][column + 2];
                count[3] = testArray[row + 1][column + 1];
                count[4] = testArray[row + 2][column];
                count[5] = testArray[row + 2][column + 1];
                count[6] = testArray[row + 2][column + 2];
                int sum = IntStream.of(count).sum();
                biggest = Math.max(sum, biggest);
            }
        }

        return biggest;
    }
}
