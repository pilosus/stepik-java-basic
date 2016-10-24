package org.stepic.java.module6.streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.*;
import java.util.stream.*;

/**
 * Created by vitaly on 09/10/16.
 */
public class MinMax {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        // your implementation here
        List<? extends T> list = stream.sorted(order).collect(Collectors.toList());
        if (list.size() == 0) {
            minMaxConsumer.accept(null, null);
        }
        else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void main(String[] args) {

    }
}
