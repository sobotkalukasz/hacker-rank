package pl.lsobotka.hacker.rank.algorithms;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://www.hackerrank.com/challenges/encryption/problem
 * */
public class Encryption {

    static String encryption(String s) {
        int length = s.length();
        double sqrt = Math.sqrt(length);
        double columns = Math.floor(sqrt);
        double rows = Math.ceil(sqrt);

        if(rows*columns < length){
            columns = rows;
        }

        char[][]encoded = new char[(int)rows][(int)columns];

        AtomicInteger counter = new AtomicInteger();

        for(int i=0; i<columns; i++){
            for(int j=0; j<rows; j++){
                int index = counter.getAndIncrement();
                if(index < length){
                    encoded[j][i] = s.charAt(index);
                } else {
                    encoded[j][i] = ' ';
                }
            }
        }

        return Stream.of(encoded)
                    .map(String::new)
                    .map(String::trim)
                    .collect(Collectors.joining(" "));

    }

}
