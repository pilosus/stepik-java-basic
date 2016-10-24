package org.stepic.java.module5.charAscii;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Created by vitaly on 02/10/16.
 */
public class CharAscii {
    public static final String CH = "Ы";

    public static void main(String[] args) throws IOException {
        Charset charset = StandardCharsets.US_ASCII;
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);

        writer.write(Arrays.toString(CH.getBytes(charset)));
        writer.write(CH);

        writer.flush();

    }
}
