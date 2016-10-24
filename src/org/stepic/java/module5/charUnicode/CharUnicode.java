package org.stepic.java.module5.charUnicode;

import java.io.*;
import java.nio.charset.*;
import java.util.Arrays;

/**
 * Created by vitaly on 02/10/16.
 */
public class CharUnicode {
    public static final char CH = 'Ы';

    public static void main(String[] args) throws UnsupportedEncodingException {
        Charset charset = StandardCharsets.UTF_8;
        //Charset charset = StandardCharsets.US_ASCII;
        byte[] bytes = "Ы".getBytes(charset);

        for (byte b: bytes) {
            System.out.print(Byte.toUnsignedInt(b) + ", ");
        }
    }
}
