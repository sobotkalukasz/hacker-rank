package pl.lsobotka.hacker.rank.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueenAttack {

    private static int rowIndex;
    private static int columnIndex;
    private static int boardSize;
    private static Map<Integer, List<Integer>> obstacles;
    private static AtomicInteger tempRow;
    private static AtomicInteger tempColumn;

    private static final List<Test<Boolean>> tests;
        static{
            tests = new ArrayList<>();
            tests.add(() -> tempRow.decrementAndGet() >= 0);
            tests.add(() -> tempRow.decrementAndGet() >= 0 && tempColumn.incrementAndGet() < boardSize);
            tests.add(() -> tempColumn.incrementAndGet() < boardSize);
            tests.add(() -> tempRow.incrementAndGet() < boardSize && tempColumn.incrementAndGet() < boardSize);
            tests.add(() -> tempRow.incrementAndGet() < boardSize);
            tests.add(() -> tempRow.incrementAndGet() < boardSize && tempColumn.decrementAndGet() >= 0);
            tests.add(() -> tempColumn.decrementAndGet() >= 0);
            tests.add(() -> tempRow.decrementAndGet() >= 0 && tempColumn.decrementAndGet() >= 0);
        }

    static int queensAttack(int size, int row, int column, int[][] obstacleArray) {
        rowIndex = --row;
        columnIndex = --column;
        boardSize = size;
        initObstacles(obstacleArray);
        return countPossibleMoves();
    }

    private static void initObstacles(int[][] obstacleArray){
        obstacles = Arrays.stream(obstacleArray)
                .collect(Collectors.groupingBy(a -> a[0] - 1,
                        Collectors.mapping(a -> a[1] - 1, Collectors.toList())));
    }

    static private int countPossibleMoves() {
        return tests.stream().mapToInt(QueenAttack::check).sum();
    }

    static private int check(Test<Boolean> condition) {
        tempRow = new AtomicInteger(rowIndex);
        tempColumn = new AtomicInteger(columnIndex);
        int count = 0;

        while(condition.test()){
            if(isObstacle(tempRow.get(), tempColumn.get())){
                break;
            }
            count++;
        }
        return count;
    }

    private static boolean isObstacle(int tempRow, int tempColumn) {
        return obstacles.containsKey(tempRow) && obstacles.get(tempRow).contains(tempColumn);
    }
}

@FunctionalInterface
interface Test<V> {
    V test();
}
