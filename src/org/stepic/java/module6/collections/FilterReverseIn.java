package org.stepic.java.module6.collections;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by vitaly on 08/10/16.
 */
public class FilterReverseIn {

    public static void main(String[] args) throws IOException {
        Charset charset = StandardCharsets.UTF_8;

        // read input stream
        Reader reader = new InputStreamReader(System.in, charset);
        int read;

        // create a string
        StringBuilder sb = new StringBuilder();
        while ((read = reader.read()) >= 0) {
            sb.append((char) read);
        }

        // parse string
        Reader stringReader = new StringReader(sb.toString());
        Scanner scanner = new Scanner(stringReader).useDelimiter("\\s+");

        // parse ints and add them to the queue
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int position = 0;
        while (scanner.hasNext()) {
            try {
                Integer num = Integer.parseInt(scanner.next());
                if ((position % 2) != 0) { deque.add(num); }
                position++;
            }
            catch (NumberFormatException e) {
                // ignore
            }
        }

        // print out elements in reverse order
        Writer w = new OutputStreamWriter(System.out, charset);

        Integer element;
        while ((element = deque.pollLast()) != null) {
            w.write(String.format("%s ", element));
        }
        w.flush();
    }
}
