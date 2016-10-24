package org.stepic.java.module6.collections;
import org.stepic.java.module3.hash.ComplexNumber;

import java.util.*;

/**
 * Created by vitaly on 08/10/16.
 */
public class CollectionExample {
    public Collection<?> collection = new HashSet<>();
    public Object object = new Object();


    public CollectionExample(Set<ComplexNumber> getCollection, Object object) {
        this.collection = collection;
        this.object = object;
    }

    /**
     * Problem on step 6.2.14
     * Return a symmetric difference (union without the intersection) of two given sets.
     * @param set1
     * @param set2
     * @param <T>
     * @return
     */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<T>();
        for (T element: set1) {
            if (!set2.contains(element)) { result.add(element); }
        }

        for (T element: set2) {
            if (!set1.contains(element)) { result.add(element); }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("hello");
        set.add("world");
        set.add("!");
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
                System.out.println(element);
        }

        Integer[] array1 = {1, 2, 3};
        Integer[] array2 = {0, 1, 2};
        Integer[] array3 = {0, 3};
        Set<Integer> set1 = new HashSet<>(Arrays.asList(array1));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(array2));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(array3));

        Set<Integer> actual = CollectionExample.symmetricDifference(set1, set2);
        System.out.println(set3.equals(actual));
    }
}
