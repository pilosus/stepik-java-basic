package org.stepic.java.module4.remote;

/**
 * Created by vitaly on 28/09/16.
 */
public class MainRobot {

    public static void main(String[] args) {
        System.out.println("Let's get started");
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        // flag to mark if moveRobotTo() succeeded or not
        boolean robotMoved = false;

        // make 3 attempts to connect to the robot and move it
        for (int i = 0; i < 3; i++) {
            try (RobotConnection robotConn = robotConnectionManager.getConnection()) {
                robotConn.moveRobotTo(toX, toY);
                // robot moved successfully
                robotMoved = true;
                return;
            }
            // exception cause: connection failed || closing resources failed
            catch (RobotConnectionException e) {
                // robot moved, but closing resources failed, ignore and return
                if (robotMoved == true) { return; }

                // 3 attempts to connect failed
                if (i == 2) {
                    throw new RobotConnectionException("Connection failure: " + e.getMessage());
                }
            }
            // other exceptions should be overthrown
            catch (Exception ex) { throw ex; }
        }

    }
}
