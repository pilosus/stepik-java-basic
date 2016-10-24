package org.stepic.java.module5.parseNums;

import java.io.*;
import java.nio.charset.*;
import java.util.Scanner;
import java.util.Locale;

/**
 * Created by vitaly on 02/10/16.
 */

public class Main {
    protected static Charset CHARSET = StandardCharsets.UTF_8;
    protected static InputStream IN =  System.in;
    protected static PrintStream OUT = System.out;

    public static void main(String[] args) throws IOException {
        parseNums(Main.IN, Main.OUT, Main.CHARSET);
    }

    public static void parseNums(InputStream inputStream,
                                 PrintStream outputStream,
                                 Charset charset) throws IOException {
        // read input stream
        Reader reader = new InputStreamReader(inputStream, charset);
        int read;
        StringBuilder sb = new StringBuilder();
        while ((read = reader.read()) >= 0) {
            sb.append((char) read);
        }

        // parse string
        Reader stringReader = new StringReader(sb.toString());

        Scanner scanner = new Scanner(stringReader)
                .useDelimiter("\\s+")
                .useLocale(Locale.forLanguageTag("ru"));

        double result = 0.0;
        while (scanner.hasNext()) {
            try {
                double num = Double.parseDouble(scanner.next());
                result += num;
            }
            catch (NumberFormatException e) {
                // ignore
            }
        }

        // output a double to the 6th position after the floating point
        //outputStream.printf("%.6f", result);
        Writer w = new OutputStreamWriter(outputStream, charset);
        w.write(String.format("%.6f", result));
        w.flush();
    }
}
