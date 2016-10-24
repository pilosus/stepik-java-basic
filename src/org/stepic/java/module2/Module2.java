package org.stepic.java.module2;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by vitaly on 15/09/16.
 */

public class Module2 {
    public static void main(String[] args) {
        System.out.println("Module 2 has started!");
    }

    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        //  совершенная дизъюнктивная нормальная форма
        return (!a & !b & c & d) |
                (!a & b & !c & d) |
                (!a & b & c & !d) |
                (a & !b & !c & d) |
                (a & !b & c & !d) |
                (a & b & !c & !d);

        //return ((a?1:0) + (b?1:0) + (c?1:0) + (d?1:0) == 2);
    }

    public static int leapYearCount(int year) {
        return (year / 4) - (year / 100) + (year / 400);
    }

    public static boolean doubleExpression(double a, double b, double c) {
        double e = 0.0001;
        return Math.abs((a + b) - c) < e;
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        // https://stackoverflow.com/questions/47981/how-do-you-set-clear-and-toggle-a-single-bit-in-c-c
        return value ^= 1 << (bitIndex - 1);
    }

    /**
     * Return a char that's 12 chars further after backslash sign in Unicode table.
     * @param a
     * @return
     */
    public static char charExpression(int a) {
        char offset = (char) a;
        return (char) ((char) '\\' + offset);
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        value = Math.abs(value);
        return (value != 0) && ((value & (value - 1)) == 0);
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        String sanitizedText = text.toLowerCase().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder newStr = new StringBuilder(sanitizedText);
        return sanitizedText.equals(String.valueOf(newStr.reverse()));
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int i = 0, j = 0;

        while (i < a1.length && j < a2.length) {
            res[i + j] = a1[i] < a2[j] ? a1[i++] : a2[j++];
        }

        while (i < a1.length) {
            res[i + j] = a1[i++];
        }

        while (j < a2.length) {
            res[i + j] = a2[j++];
        }
        return res;
    }

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder fullText = new StringBuilder();
        for (String role : roles) {
            fullText.append(role + ":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":"))
                    fullText.append((i + 1) + ")" + textLines[i].substring(textLines[i].indexOf(":") + 1) + "\n");
            }
            fullText.append("\n");
        }
        return fullText.toString();
    }
}
