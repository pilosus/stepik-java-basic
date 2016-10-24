package org.stepic.java.module5.parseNums;

import java.io.*;
import org.junit.Assert;

/**
 * Created by vitaly on 02/10/16.
 *
 * In order to have your JUnit test working, add this Java Class file into your package,
 * then add JUnit 4 jar to the project's classpath:
 *   1. File -> Project Structure -> Modules -> Dependencies
 *   2. Click + (Add) -> JARs or directories
 *   3. Add IntelliJ dir/Contents/lib -> junit 4
 *   4. (Optionally for OS X) Add IntelliJ dir/Contents/lib -> hamcrest-core
 */

public class ParseNumsTest {
    @org.junit.Test
    public void parse1() throws Exception {
        String input = "1 2 3";
        String expected = "6.000000";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(Main.CHARSET));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // create custom output stream
        PrintStream customStream = new PrintStream(outputStream);

        // execute code
        Main.parseNums(inputStream, customStream, Main.CHARSET);

        System.out.printf("%-20s %-30s\n", "Test", new Exception("not thrown").getStackTrace()[0].getMethodName());
        System.out.printf("%-20s %-30s\n", "Input", input);
        System.out.printf("%-20s %-30s\n", "Expected output", expected);
        System.out.printf("%-20s %-30s\n", "Actual output", outputStream);
        System.out.println();

        // compare an expected output to the actual output
        Assert.assertEquals(expected, outputStream.toString());
    }

    @org.junit.Test
    public void parse2() throws Exception {
        String input = "a1 b2 c3";
        String expected = "0.000000";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(Main.CHARSET));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // create custom output stream
        PrintStream customStream = new PrintStream(outputStream);

        // execute code
        Main.parseNums(inputStream, customStream, Main.CHARSET);

        System.out.printf("%-20s %-30s\n", "Test", new Exception("not thrown").getStackTrace()[0].getMethodName());
        System.out.printf("%-20s %-30s\n", "Input", input);
        System.out.printf("%-20s %-30s\n", "Expected output", expected);
        System.out.printf("%-20s %-30s\n", "Actual output", outputStream);
        System.out.println();

        // compare an expected output to the actual output
        Assert.assertEquals(expected, outputStream.toString());
    }

    @org.junit.Test
    public void parse3() throws Exception {
        String input = "-1e3\n" +
                "18 .111 11bbb";
        String expected = "-981.889000";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(Main.CHARSET));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // create custom output stream
        PrintStream customStream = new PrintStream(outputStream);

        // execute code
        Main.parseNums(inputStream, customStream, Main.CHARSET);

        System.out.printf("%-20s %-30s\n", "Test", new Exception("not thrown").getStackTrace()[0].getMethodName());
        System.out.printf("%-20s %-30s\n", "Input", input);
        System.out.printf("%-20s %-30s\n", "Expected output", expected);
        System.out.printf("%-20s %-30s\n", "Actual output", outputStream);
        System.out.println();

        // compare an expected output to the actual output
        Assert.assertEquals(expected, outputStream.toString());
    }

}
