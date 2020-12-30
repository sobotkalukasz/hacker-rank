package pl.lsobotka.hacker.rank.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */
public class TimeInWords {

    private final static Map<Integer, String> hours;

    static {
        hours = new HashMap<>();
        hours.put(1, "one");
        hours.put(2, "two");
        hours.put(3, "three");
        hours.put(4, "four");
        hours.put(5, "five");
        hours.put(6, "six");
        hours.put(7, "seven");
        hours.put(8, "eight");
        hours.put(9, "nine");
        hours.put(10, "ten");
        hours.put(11, "eleven");
        hours.put(12, "twelve");
    }

    private final static Map<Integer, String> minutes;

    static {
        minutes = new HashMap<>();
        minutes.put(0, "o' clock");
        minutes.put(1, "one");
        minutes.put(2, "two");
        minutes.put(3, "three");
        minutes.put(4, "four");
        minutes.put(5, "five");
        minutes.put(6, "six");
        minutes.put(7, "seven");
        minutes.put(8, "eight");
        minutes.put(9, "nine");
        minutes.put(10, "ten");
        minutes.put(11, "eleven");
        minutes.put(12, "twelve");
        minutes.put(13, "thirteen");
        minutes.put(14, "fourteen");
        minutes.put(15, "quarter");
        minutes.put(16, "sixteen");
        minutes.put(17, "seventeen");
        minutes.put(18, "eighteen");
        minutes.put(19, "nineteen");
        minutes.put(20, "twenty");
        minutes.put(21, "twenty one");
        minutes.put(22, "twenty two");
        minutes.put(23, "twenty three");
        minutes.put(24, "twenty four");
        minutes.put(25, "twenty five");
        minutes.put(26, "twenty six");
        minutes.put(27, "twenty seven");
        minutes.put(28, "twenty eight");
        minutes.put(29, "twenty nine");
        minutes.put(30, "half");
    }

    private final static String TO = "to";
    private final static String PAST = "past";

    static String timeInWords(int h, int m) {

        int minute = effectiveMinute(m);
        int hour = m != minute ? h + 1 : h;

        boolean isPlural = minute > 1;

        List<String> time = new ArrayList<>();

        if (m == 0) {
            time.add(hours.get(hour));
            time.add(minutes.get(minute));
        } else {
            time.add(minutes.get(minute));
            if (minute % 15 != 0) time.add(isPlural ? "minutes" : "minute");

            time.add(m <= 30 ? PAST : TO);
            time.add(hours.get(hour));
        }

        return String.join("\s", time);
    }

    static int effectiveMinute(int min) {
        return min > 30 ? 60 - min : min;
    }

}
