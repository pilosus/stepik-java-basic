package org.stepic.java.module5.procbuilderDemo;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xml.internal.serializer.utils.SystemIDResolver;

import java.io.*;
import java.lang.ProcessBuilder.Redirect;

/**
 * Created by vitaly on 03/10/16.
 */
public class ProcessDemo {
    public static void main(String[] args) throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("ls", "-l")
                .directory(new File("/Users/vitaly/git/stepik-java-basics"))
                .redirectInput(Redirect.from(new File("/dev/null")))
                .redirectOutput(Redirect.PIPE)
                .redirectError(Redirect.INHERIT);

        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
            reader.lines().forEach(System.out::println);
        }

        int exitValue = process.waitFor();
        if (exitValue != 0) {
            System.err.println("Subprocess terminated abnormally");
        }
    }
}
