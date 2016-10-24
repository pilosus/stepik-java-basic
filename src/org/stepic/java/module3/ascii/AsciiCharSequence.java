package org.stepic.java.module3.ascii;
import java.lang.CharSequence;

/**
 * Created by vitaly on 24/09/16.
 */
public class AsciiCharSequence implements CharSequence  {
    byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public final int length() {
        return bytes.length;
    }

    @Override
    public final char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public final String toString() {
        return new String(bytes);
    }

    @Override
    public final CharSequence subSequence(int start, int end) {
        int length = end - start;
        byte[] sub = new byte[length];
        for (int i = 0, j = start; i < length; i++, j++) {
            sub[i] = bytes[j];
        }
        return new AsciiCharSequence(sub);
    }
}
