package org.stepic.java.module5.is2str;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.io.*;
import java.nio.charset.*;
import java.util.Arrays;

/**
 * Created by vitaly on 02/10/16.
 */
public class Stream2String {
    public static void main(String[] args) throws IOException {
        byte[] inputBytes =  {48, 49, 50, 51};
        String expected = "0123";

        Charset charset = StandardCharsets.US_ASCII;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        String actual = readAsString(inputStream, charset);
        //System.out.print(expected);
        System.out.print(actual);

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int block;
        while ((block = inputStream.read()) != -1) {
            outputStream.write(block);
        }
        return new String(outputStream.toByteArray(), charset);
    }

    public static String readAsString2(InputStream inputStream, Charset charset) throws IOException {
        Reader reader = new InputStreamReader(inputStream, charset);
        int read;
        StringBuilder sb = new StringBuilder();
        while ((read = reader.read()) >= 0) {
            sb.append((char) read);
        }
        return sb.toString();
    }
}
