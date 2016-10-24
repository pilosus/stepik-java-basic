package org.stepic.java.module3.hash;

/**
 * Created by vitaly on 24/09/16.
 */
public class MainComplex {
    public static void main(String[] args) {

        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        ComplexNumber c = new ComplexNumber(5, 7);

        if (a.equals(b)) {
            System.out.println("equals() works as expected");
        }

        if (a.hashCode() == b.hashCode()) {
            System.out.println("hashCode() works as expected");
        }

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());

        //a.equals(b) == true;
        //a.hashCode() == b.hashCode();
    }
}
