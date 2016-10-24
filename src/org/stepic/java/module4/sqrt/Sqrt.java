package org.stepic.java.module4.sqrt;

/**
 * Created by vitaly on 25/09/16.
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(16));
        System.out.println(sqrt(0));
        System.out.println(sqrt(-81));
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new java.lang.IllegalArgumentException("Expected non-negative number, got " + x);
        }
        else
            return Math.sqrt(x);
    }
}
