package org.stepic.java.module5.nioDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by vitaly on 03/10/16.
 */
public class NioDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/vitaly/git/stepik-java-basics/01_intro/HelloWorld.java");

        // non-blocking access
        // pro: fast (non-blocking access)
        // contra: difficult to use (lower level module)
        try (ReadableByteChannel in = FileChannel.open(path);
             WritableByteChannel out = Channels.newChannel(System.out)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (in.read(buffer) >= 0 || buffer.position() != 0) {
                buffer.flip();
                out.write(buffer);
                buffer.compact();
            }
        }

        /*
        // blocking access
        // pro: easier to use (high level module)
        // contra: may be slower (blocking access)
        try (InputStream in = Files.newInputStream(path);
             OutputStream out = System.out) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read()) > 0) {
                out.write(buffer, 0, bytesRead);
            }
        }
        */

    }
}

