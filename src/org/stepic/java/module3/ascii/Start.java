package org.stepic.java.module3.ascii;

/**
 * Created by vitaly on 24/09/16.
 */
public class Start {
    public static void main(String[] args) {
        byte[] data = new byte[]{1, 2, 3, 65, 66, 67, 68, 69};
        AsciiCharSequence a = new AsciiCharSequence(data);
        System.out.println(a);
        System.out.println("sub(2,2) = " + a.subSequence(2,2));
        System.out.println("length of sub(2,2) = " + a.subSequence(2,2).length());
        System.out.println("sub(2,5) = " + a.subSequence(2,5));
        System.out.println("length sub(2,5) = " + a.subSequence(2,5).length());
    }
}
