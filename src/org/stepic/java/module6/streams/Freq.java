package org.stepic.java.module6.streams;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.*;
import java.io.*;

/**
 * Created by vitaly on 09/10/16.
 * @url https://stackoverflow.com/questions/21233183/java-8-stream-mapk-v-to-listt
 * @url https://stackoverflow.com/questions/29122394/word-frequency-count-java-8
 * @url https://shekhargulati.com/2015/09/19/word-count-example-in-java-8/
 */
public class Freq {

    public static void readInput() {
        Charset charset = StandardCharsets.UTF_8;
        Reader reader = new InputStreamReader(System.in, charset);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Stream<String> stream = bufferedReader.lines();
        stream
                .flatMap(line -> Stream.of(line.split("[\\p{Punct}\\s]+"))) // split line to words
                .map(String::toLowerCase) // make words lowercase
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // create map {word=<Integer>freq}
                .entrySet().stream() // convert map to stream
                .sorted(Comparator.comparing(Map.Entry::getKey)) // sort map by value to preserve words order
                .sorted(Comparator.comparing((Map.Entry<String, Long> entry) -> entry.getValue()).reversed()) // sort by freq
                .limit(10) // show <= 10 results
                .forEach(entry -> System.out.println(entry.getKey()));
    }

    public static void main(String[] args) {
        readInput();
    }
}
