package org.stepic.java.module5.checksum;

import java.io.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by vitaly on 01/10/16.
 */
public class CheckSumTest {
    @org.junit.Test
    public void checkSum1() throws Exception {
        byte[] data = {0x33, 0x45, 0x01};
        InputStream stream = new ByteArrayInputStream(data);
        assertEquals(71, CheckSum.checkSumOfStream(stream));
    }

}
