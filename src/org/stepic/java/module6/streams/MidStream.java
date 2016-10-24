package org.stepic.java.module6.streams;

import java.util.function.IntUnaryOperator;
import java.util.stream.*;
/**
 * Created by vitaly on 08/10/16.
 */
public class MidStream {

    /**
     * Return an integer consisting of a secind, third and fourth digits of the given integer.
     * @param num is an integer
     * @return is an integer
     */
    public static int mid(int num) {
        return 100 * (num % 10000 / 1000) +
                10 * (num % 1000 / 100) +
                 1 * (num % 100 / 10);
    }

    public static IntUnaryOperator midOp() {
        return x -> x / 10 % 1000;
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> midOp().applyAsInt(x * x));
    }

    public static void main(String[] args) {
        System.out.println(mid(123456));
        System.out.println(mid(13 * 13));
        IntStream intStream = pseudoRandomStream(13).limit(10);
        System.out.println(intStream.boxed().collect(Collectors.toList()).toString());
    }
}
