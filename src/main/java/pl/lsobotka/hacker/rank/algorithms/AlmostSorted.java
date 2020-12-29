package pl.lsobotka.hacker.rank.algorithms;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 * */
public class AlmostSorted {

    public String almostSorted(List<Integer> ints) {
        List<Integer> sorted = ints.stream().sorted().collect(Collectors.toList());

        if(sorted.equals(ints)){
            return "yes";
        }

        Map<Integer, Integer> diff = getDiff(ints, sorted);

        if(diff.size() == 2){
            List<Integer> keys = new ArrayList<>(diff.keySet());
            Collections.sort(keys);
            return String.format("yes\nswap %d %d", keys.get(0)+1, keys.get(1)+1);
        }

        int min = diff.keySet().stream().mapToInt(Integer::intValue).min().orElse(0);
        int max = diff.keySet().stream().mapToInt(Integer::intValue).max().orElse(0);

        for(int i = min; i < max; i++){
            Integer first = diff.get(i) != null ? diff.get(i) : ints.get(i);
            Integer second = diff.get(i + 1) != null ? diff.get(i+1) : ints.get(i+1);
            if(first.compareTo(second) < 0){
                return "no";
            }
        }
        return String.format("yes\nreverse %d %d", min+1, max+1);
    }

    private Map<Integer, Integer> getDiff(List<Integer>unsorted, List<Integer>sorted){
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        if(unsorted.size() == sorted.size()){
            for(int i = 0; i < unsorted.size(); i++){
                Integer unsortedElement = unsorted.get(i);
                Integer sortedElement = sorted.get(i);
                if(unsortedElement.compareTo(sortedElement) != 0){
                    diffMap.put(i, unsorted.get(i));
                }
            }
        }
        return diffMap;
    }

}
