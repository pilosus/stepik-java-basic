package org.stepic.java.module4.logdemo;
import java.util.logging.*;
import java.util.Arrays;

/**
 * Created by vitaly on 28/09/16.
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/logging/Level.html">Logging Levels</a>
 */
public class LogDemo {

    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
        // default logging level INFO, all finer events will be ignored
        // default level could be redefined in .properties config file
        LOGGER.log(Level.FINE, "Started with arguments: {0}", Arrays.toString(args));

        try {
            randomFailingAlgorithm();
        }
        catch (IllegalStateException e) {
            LOGGER.log(Level.SEVERE, "Exception caught", e);
            System.exit(2);
        }
        LOGGER.fine("Finished successfully");

    }

    private static void randomFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Generated random number: {0}", randomNumber);
        if (randomNumber < 0.5) {
            throw new IllegalStateException("Invalid phase of the Moon");
        }
    }


}
