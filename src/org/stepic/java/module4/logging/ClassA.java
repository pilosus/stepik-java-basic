package org.stepic.java.module4.logging;
import java.util.logging.*;

/**
 * Created by vitaly on 29/09/16.
 */
public class ClassA {

    public static void main(String[] args) {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

        Logger loggerParent = Logger.getLogger("org.stepic.java");
        loggerParent.setLevel(Level.ALL);

        ConsoleHandler handlerConsole = new ConsoleHandler();
        handlerConsole.setLevel(Level.ALL);
        handlerConsole.setFormatter(new XMLFormatter());
        loggerParent.addHandler(handlerConsole);

        loggerParent.setUseParentHandlers(false);
    }


}
