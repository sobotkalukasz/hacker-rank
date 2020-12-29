package pl.lsobotka.hacker.rank.algorithms;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 */
public class GridSearch {

    static String gridSearch(String[] grid, String[] pattern) {
        boolean found = false;
        int patLen = pattern.length;
        for(int index = 0; index <= grid.length - patLen; index++){
            if(grid[index].contains(pattern[0])){
                Set<Integer> foundIndexes = foundCommonIndexes(grid[index], pattern[0]);

                for(int patternIndex = 1; patternIndex < patLen; patternIndex++){
                    String currentWord = grid[index + patternIndex];
                    String currentPattern = pattern[patternIndex];
                    if(currentWord.contains(currentPattern)){
                        Set<Integer> foundInnerIndexes = foundCommonIndexes(currentWord, currentPattern);
                        foundIndexes.retainAll(foundInnerIndexes);
                        if(foundIndexes.isEmpty()){
                            break;
                        }
                        if(patternIndex == patLen-1){
                            found = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if(found){
                break;
            }
        }
        return found ? "YES" : "NO";
    }

    private static Set<Integer> foundCommonIndexes(String word, String pattern){
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher(word);
        Set<Integer> commonIndexes = new HashSet<>();
        int startIndex = 0;
        while(matcher.find(startIndex++)){
            commonIndexes.add(matcher.start());
        }
        return commonIndexes;
    }
}
