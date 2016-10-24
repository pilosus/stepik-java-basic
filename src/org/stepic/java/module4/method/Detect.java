package org.stepic.java.module4.method;

/**
 * Created by vitaly on 25/09/16.
 */
public class Detect {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();

        //IllegalArgumentException ex = new IllegalArgumentException("Test");
        //ex.printStackTrace();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    /**
     * Реализуйте метод, позволяющий другим методам узнать, откуда их вызвали.
     * Метод getCallerClassAndMethodName() должен возвращать имя класса и метода, откуда вызван метод,
     * вызвавший данный утилитный метод. Или null (нулевую ссылку, а не строку "null"), если метод,
     * вызвавший getCallerClassAndMethodName() является точкой входа в программу, т.е. его никто не вызывал.
     *
     * Это актуально, например, в библиотеках логирования, где для каждого сообщения в логе надо выводить класс и метод,
     * откуда сообщение было залогировано.
     * @return String
     *
     * При тестировании этой программы в среде разработки вы можете получить другой результат:
     * вместо null в первой строчке будет напечатан какой-то посторонний класс и метод. Это связано с тем,
     * что среда разработки обычно запускает не ваш класс, а свой собственный, который затем уже вызывает ваш.
     * Чтобы этого избежать, запускайте программу командой "java" в командной строке.
     */
    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();

        if (stackTraceElements.length > 2) {
            StackTraceElement callerElement = stackTraceElements[2];
            return callerElement.getClassName() + "#" + callerElement.getMethodName();
        }
        return null;
    }
}
