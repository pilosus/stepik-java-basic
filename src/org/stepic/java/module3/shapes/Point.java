package org.stepic.java.module3.shapes;

/**
 * Created by vitaly on 24/09/16.
 */
public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    @Override
    public String toString() { return "(" + x + ", " + y + ")"; }
}
