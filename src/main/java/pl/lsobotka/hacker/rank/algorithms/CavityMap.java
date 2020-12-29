package pl.lsobotka.hacker.rank.algorithms;

import java.util.stream.IntStream;

/*
 * https://www.hackerrank.com/challenges/cavity-map/problem
 * */
public class CavityMap {

    static String[] cavityMap(String[] grid) {

        String[] cavityMap = new String[grid.length];
        System.arraycopy(grid, 0, cavityMap, 0,grid.length);

        int size = grid.length;

        for(int row = 1; row < size-1; row++){
            for(int column = 1; column < size-1; column++){
                int toTest = Integer.parseInt(String.valueOf(grid[row].charAt(column)));
                long count = IntStream.of(getBoarders(grid, row, column))
                        .distinct()
                        .filter(i -> i >= toTest)
                        .count();
                if(count == 0) cavityMap[row] = markIndex(cavityMap[row], column);
            }
        }
        return cavityMap;
    }

    static int[] getBoarders(String[] grid, int row, int column){
        return new int[]{
                Integer.parseInt(String.valueOf(grid[row - 1].charAt(column))),
                Integer.parseInt(String.valueOf(grid[row].charAt(column - 1))),
                Integer.parseInt(String.valueOf(grid[row].charAt(column + 1))),
                Integer.parseInt(String.valueOf(grid[row + 1].charAt(column)))};
    }

    static String markIndex(String str, int index){
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index, 'X');
        return sb.toString();
    }
}
