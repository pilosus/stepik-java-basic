package org.stepic.java.module5.checksum;

import java.io.*;

/**
 * Created by vitaly on 01/10/16.
 */
public class CheckSum {

    public static void main(String[] args) {
        System.out.println("Let's get started");
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int dataBlock = 0;
        int checkSum = 0;
        while ((dataBlock = inputStream.read()) != -1) {
            checkSum = Integer.rotateLeft(checkSum, 1) ^ dataBlock;
        }
        return checkSum;
    }
}
