package org.stepic.java.module4.remote;

/**
 * Created by vitaly on 28/09/16.
 */
public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
