package org.stepic.java.module6.generics;

/**
 * Created by vitaly on 08/10/16.
 * @url https://stackoverflow.com/questions/16382887/how-to-implement-equals-method-for-generics-using-instanceof
 */
public class Pair<T1, T2> {

    private T1 val1;
    private T2 val2;

    private Pair(T1 val1, T2 val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public T1 getFirst() {
        return val1;
    }

    public T2 getSecond() {
        return val2;
    }

    public static <T1, T2> Pair<T1, T2> of(T1 val1, T2 val2) {
        return new Pair<T1, T2>(val1, val2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (val1 != null ? !val1.equals(pair.val1) : pair.val1 != null) return false;
        return val2 != null ? val2.equals(pair.val2) : pair.val2 == null;

    }

    @Override
    public int hashCode() {
        int result = val1 != null ? val1.hashCode() : 0;
        result = 31 * result + (val2 != null ? val2.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        System.out.println(i);
        String s = pair.getSecond(); // "hello"
        System.out.println(s);

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        System.out.println(mustBeTrue);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustAlsoBeTrue);

        Pair<String, String> pair3 = Pair.of("hello", "there");
        boolean mustBeFalse = pair.equals(pair3); // false!
        System.out.println(mustBeFalse);
    }
}
