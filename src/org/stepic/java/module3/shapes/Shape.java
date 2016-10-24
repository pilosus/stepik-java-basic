package org.stepic.java.module3.shapes;

/**
 * Created by vitaly on 24/09/16.
 */


public class Shape {
    private final Color color;

    public Shape(Color color) { this.color = color; }

    public Color getColor() { return color; }

    public double getArea() { return Double.NaN; }

}
