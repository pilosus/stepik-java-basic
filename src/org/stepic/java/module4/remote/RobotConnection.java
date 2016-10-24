package org.stepic.java.module4.remote;

/**
 * Created by vitaly on 28/09/16.
 */
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}
