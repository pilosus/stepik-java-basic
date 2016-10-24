package org.stepic.java.module3.integral;

import java.util.function.DoubleUnaryOperator;

/**
 * Created by vitaly on 24/09/16.
 */
public class Integral {

    /**
     * http://www.mathcs.emory.edu/~cheung/Courses/170/Syllabus/07/rectangle-method.html
     * https://ru.wikipedia.org/wiki/Метод_прямоугольников
     * @param f function value in the given point
     * @param a starting point of the interval
     * @param b end point of the interval
     * @return integral value on the interval for a given function f
     */
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        //return f.applyAsDouble(a);
        double result = 0.0;
        double width = 1e-6;
        double steps = Math.ceil((b - a) / width);

        for (int i = 0; i < steps; i++) {
            result += f.applyAsDouble(a + width * (i + 0.5));
        }

        result *= width;

        return result;
    }

    public static void main(String[] args) {
        double ten = integrate(x -> 1, 0, 10);
        System.out.println(ten);

    }
}
