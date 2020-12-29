package pl.lsobotka.hacker.rank.algorithms;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * */
public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> positions = new ArrayList<>();
        final int chunkSize = 7500;
        final AtomicInteger counter = new AtomicInteger();

        TreeMap<Integer, List<Integer>> sortedMap = ranked.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize, TreeMap::new, Collectors.toList()));

        if (sortedMap.size() == 1) {
            player.forEach(score -> positions.add(determinePosition(sortedMap.get(sortedMap.firstKey()), score)));
        } else {
            Integer firstPositionScore = sortedMap.get(sortedMap.firstKey()).get(0);
            Integer firstPlace = 1;
            List<Integer> lastChunk = sortedMap.get(sortedMap.lastKey());
            Integer lastPositionScore = lastChunk.get(lastChunk.size() - 1);
            Integer lastPlace = (sortedMap.size() - 1) * chunkSize + lastChunk.size() + 1;

            for (Integer score : player) {
                if (score >= firstPositionScore) {
                    positions.add(firstPlace);
                    continue;
                }
                if (score <= lastPositionScore) {
                    positions.add(lastPlace);
                    continue;
                }
                Integer foundPosition = chunkMap(sortedMap, score);
                positions.add(foundPosition);
            }
        }
        return positions;
    }

    public static Integer chunkMap(SortedMap<Integer, List<Integer>> sortedMap, Integer playerScore) {

        Integer firstKey = sortedMap.firstKey();
        Integer lastKey = sortedMap.lastKey();
        Integer centerListIndex = firstKey + (lastKey - firstKey) / 2;
        Integer centerPositionScore = sortedMap.get(centerListIndex).get(0);

        if (sortedMap.size() > 3) {
            if (playerScore > centerPositionScore) {
                SortedMap<Integer, List<Integer>> subMap = sortedMap.subMap(firstKey, centerListIndex);
                return chunkMap(subMap, playerScore);

            } else if (playerScore < centerPositionScore) {
                SortedMap<Integer, List<Integer>> subMap = sortedMap.tailMap(centerListIndex);
                return chunkMap(subMap, playerScore);
            } else {
                return centerListIndex * sortedMap.get(centerListIndex).size() + 1;
            }
        } else {
            for (int i = firstKey; i <= lastKey; i++) {
                Integer position = determinePosition(sortedMap.get(i), playerScore, i * sortedMap.get(centerListIndex).size());
                if (position != null) {
                    return position;
                }
            }
        }
        return lastKey * sortedMap.get(centerListIndex).size() + sortedMap.get(lastKey).size() + 1;
    }

    public static Integer determinePosition(List<Integer> ranked, int playerScore, int position) {
        position++;
        for (Integer score : ranked) {
            if (score <= playerScore)
                return position;
            position++;
        }
        return null;
    }

    public static int determinePosition(List<Integer> ranked, int playerScore) {
        int position = 1;
        for (Integer score : ranked) {
            if (score <= playerScore)
                return position;
            position++;
        }
        return ranked.size() + 1;
    }
}
