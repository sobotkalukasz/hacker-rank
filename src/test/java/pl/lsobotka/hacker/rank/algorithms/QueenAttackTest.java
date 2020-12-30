package pl.lsobotka.hacker.rank.algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pl.lsobotka.hacker.rank.BaseTest;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueenAttackTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("queenAttackData")
    public void queenAttackTest(int boardSize, int posX, int posY, int[][] obstacles, int expectedOutput) {
        int actualOutput = QueenAttack.queensAttack(boardSize, posX, posY, obstacles);
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> queenAttackData() {
        return Stream.of(
                Arguments.of(5, 4, 3, new int[][]{{5, 5}, {4, 2}, {2, 3}}, 10),
                Arguments.of(4, 4, 4, new int[][]{}, 9),
                Arguments.of(1, 1, 1, new int[][]{}, 0)
        );
    }

    @Test
    public void queenAttackFromFile() throws Exception {
        String whiteSpace = "\s";
        String inputPath = "QueenAttack_Input";

        Deque<String> input = new LinkedList<>(getFileInput(inputPath));

        String[] nk = input.removeFirst().split(whiteSpace);
        int boardSize = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = input.removeFirst().split(whiteSpace);
        int posX = Integer.parseInt(r_qC_q[0]);
        int posY = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];
        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = input.removeFirst().split(whiteSpace);
            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int actualOutput = QueenAttack.queensAttack(boardSize, posX, posY, obstacles);
        assertEquals(872, actualOutput);
    }
}
