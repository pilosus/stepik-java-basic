package org.stepic.java.module5.dos2unix;

import java.io.*;
import org.junit.Assert;
import java.util.Arrays;

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
public class Dos2UnixTest {
    @org.junit.Test
    public void d2u1() throws Exception {
        byte[] inputBytes =  {65, 66, 13, 13, 10, 10, 13, 67, 13, 13};
        byte[] outputBytes = {65, 66, 13,   10,   10, 13, 67, 13, 13};

        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // set input stream
        System.setIn(inputStream);

        // create custom output stream
        PrintStream customStream = new PrintStream(outputStream);

        // save standard output stream
        PrintStream oldStream = System.out;

        // switch to custom output stream in order to write output to a ByteArray
        System.setOut(customStream);

        // execute code
        Main.dos2unix(Main.in, Main.out);

        // switch back to the standard output stream in order to print out to the console
        System.out.flush();
        System.setOut(oldStream);

        // a nicer alternative for iteration over bytes
        // for (byte b: outputStream.toByteArray()) { System.out.print(b + ", "); }
        System.out.printf("%-20s %-30s\n", "Input", Arrays.toString(inputBytes));
        System.out.printf("%-20s %-30s\n", "Expected output", Arrays.toString(outputBytes));
        System.out.printf("%-20s %-30s\n", "Actual output", Arrays.toString(outputStream.toByteArray()));

        // compare an expected output to the actual output
        Assert.assertEquals(Arrays.toString(outputBytes),
                Arrays.toString(outputStream.toByteArray()));
    }

}
