package org.stepic.java.module3.robot;

/**
 * Created by vitaly on 23/09/16.
 */

public class Robot {
    int xc;
    int yc;
    Direction dir;

    // constructor
    public Robot(int xc, int yc, Direction dir) {
        this.xc = xc;
        this.yc = yc;
        this.dir = dir;
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return dir;
    }

    public int getX() {
        // текущая координата xc
        return xc;
    }

    public int getY() {
        // текущая координата yc
        return yc;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        switch (dir) {
            case UP:
                dir = Direction.LEFT;
                break;
            case DOWN:
                dir = Direction.RIGHT;
                break;
            case LEFT:
                dir = Direction.DOWN;
                break;
            case RIGHT:
                dir = Direction.UP;
                break;
        }
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        switch (dir) {
            case UP:
                dir = Direction.RIGHT;
                break;
            case DOWN:
                dir = Direction.LEFT;
                break;
            case LEFT:
                dir = Direction.UP;
                break;
            case RIGHT:
                dir = Direction.DOWN;
                break;
        }
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        switch (dir) {
            case UP:
                yc++;
                break;
            case DOWN:
                yc--;
                break;
            case LEFT:
                xc--;
                break;
            case RIGHT:
                xc++;
                break;
        }
    }



    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int deltaX = toX - robot.getX();
        int deltaY = toY - robot.getY();

        // change direction along X axis
        if (deltaX < 0) {
            // turn dir LEFT
            while (Direction.LEFT != robot.getDirection()) {
                robot.turnLeft();
            }
        }
        else if (deltaX > 0) {
            // turn dir RIGHT
            while (Direction.RIGHT != robot.getDirection()) {
                robot.turnRight();
            }
        }

        // step forward along X axis
        while (toX != robot.getX()) {
            robot.stepForward();
        }

        // change direction along Y axis
        if (deltaY < 0) {
            // turn dir DOWN
            while (Direction.DOWN != robot.getDirection()) {
                robot.turnLeft();
            }
        }
        else if (deltaY > 0) {
            // turn dir UP
            while (Direction.UP != robot.getDirection()) {
                robot.turnRight();
            }
        }

        // step forward along Y axis
        while (toY != robot.getY()) {
            robot.stepForward();
        }

    }

    // inheritance
    public class Android extends Robot {

        // constructor
        public Android() {
            // super-class constructor
            super(0, 0, Direction.UP);
        }

    }

    public static void main(String[] args) {
        System.out.println("Let's get started!");
    }
}
