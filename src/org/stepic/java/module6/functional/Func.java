package org.stepic.java.module6.functional;
import java.util.Objects;
import java.util.function.*;

/**
 * Created by vitaly on 08/10/16.
 */
public class Func {

    /**
     * Problem on step 6.3.8
     * Return function implementing ternary operator logic for functional interfaces
     * @param condition
     * @param ifTrue
     * @param ifFalse
     * @param <T>
     * @param <U>
     * @return
     */
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (s)-> (condition.test(s)) ? ifTrue.apply(s) : ifFalse.apply(s);
    }

    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply(""));
        System.out.println(safeStringLength.apply("Hello"));
        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply("Hello")); // same as above

        Predicate<Integer> geZero = num -> num >= 0;
        System.out.println(ternaryOperator(geZero, x -> 1, x -> -1).apply(-7));
    }
}
