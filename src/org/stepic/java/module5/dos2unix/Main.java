package org.stepic.java.module5.dos2unix;

import java.io.*;

/**
 * Created by vitaly on 01/10/16.
 */
public class Main {
    private static final int N = 10;
    private static final int R = 13;
    protected static PrintStream out = System.out;
    protected static InputStream in = System.in;

    /**
     * Run DOS to Unix string formatter.
     * Press Ctrl + D to terminate reading input.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        dos2unix(Main.in, Main.out);
    }

    /**
     * Change '\r\n' byte sequences in the given input to '\n', putting the result to the given ouput stream.
     * @param out
     * @throws IOException
     */
    public static void dos2unix(InputStream in, PrintStream out) throws IOException {
        int block;
        int flag = -1;

        while ((block = in.read()) != -1) {
            if (block == R) {
                if (flag == R) { out.write(R); }
                flag = block;
                continue;
            }

            if (block != N && flag == R) { out.write(flag); }

            out.write(block);
            flag = block;
        }
        if (flag == R) { out.write(flag); }

        out.flush();
    }
}
