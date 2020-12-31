package pl.lsobotka.hacker.rank.daysofcode;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
 * https://www.hackerrank.com/challenges/30-regex-patterns/problem
 * */
public class RegexTraining {

    private static final Pattern p = Pattern.compile("[A-z@]*gmail\\.com");

    public static List<String> namesGmailAccounts(List<String> namesEmails){
        return namesEmails.stream()
                .map(s -> s.split("\s"))
                .filter(name -> p.matcher(name[1]).matches())
                .map(arr -> arr[0]).sorted().collect(Collectors.toList());

    }

}
