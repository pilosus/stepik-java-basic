package org.stepic.java.module2;
import org.junit.Assert;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by vitaly on 01/10/16.
 */
public class Module2Test {
    @org.junit.Test
    public void boolExp1() throws Exception {
        assertEquals(false, Module2.booleanExpression(false, false, false, false));
    }

    @org.junit.Test
    public void boolExp2() throws Exception {
        assertEquals(false, Module2.booleanExpression(true, true, true, true));
    }

    @org.junit.Test
    public void boolExp3() throws Exception {
        assertEquals(true, Module2.booleanExpression(false, false, true, true));
    }

    @org.junit.Test
    public void boolExp4() throws Exception {
        assertEquals(true, Module2.booleanExpression(true, false, true, false));
    }

    @org.junit.Test
    public void boolExp5() throws Exception {
        assertEquals(true, Module2.booleanExpression(true, false, false, true));
    }

    @org.junit.Test
    public void lYear1() throws Exception {
        assertEquals(0, Module2.leapYearCount(1));
    }

    @org.junit.Test
    public void lYear2() throws Exception {
        assertEquals(1, Module2.leapYearCount(4));
    }

    @org.junit.Test
    public void lYear3() throws Exception {
        assertEquals(24, Module2.leapYearCount(100));
    }

    @org.junit.Test
    public void lYear4() throws Exception {
        assertEquals(97, Module2.leapYearCount(400));
    }

    @org.junit.Test
    public void fBit1() throws Exception {
        assertEquals(0b101110, Module2.flipBit(0b101010, 3));
    }

    @org.junit.Test
    public void chExp1() throws Exception {
        assertEquals('h', Module2.charExpression(12));
    }

    @org.junit.Test
    public void chExp2() throws Exception {
        assertEquals('y', Module2.charExpression(29));
    }

    @org.junit.Test
    public void pot1() throws Exception {
        assertEquals(false, Module2.isPowerOfTwo(0));
    }

    @org.junit.Test
    public void pot2() throws Exception {
        assertEquals(true, Module2.isPowerOfTwo(1));
    }

    @org.junit.Test
    public void pot3() throws Exception {
        assertEquals(true, Module2.isPowerOfTwo(-2));
    }

    @org.junit.Test
    public void pot4() throws Exception {
        assertEquals(false, Module2.isPowerOfTwo(7));
    }

    @org.junit.Test
    public void pot5() throws Exception {
        assertEquals(true, Module2.isPowerOfTwo(1024));
    }

    @org.junit.Test
    public void palindrome1() throws Exception {
        assertEquals(false, Module2.isPalindrome("Hello"));
    }

    @org.junit.Test
    public void palindrome2() throws Exception {
        assertEquals(true, Module2.isPalindrome("Madam, I'm Adam!"));
    }

    @org.junit.Test
    public void factorial1() throws Exception {
        assertEquals(BigInteger.valueOf(1), Module2.factorial(1));
    }

    @org.junit.Test
    public void factorial2() throws Exception {
        assertEquals(BigInteger.valueOf(120), Module2.factorial(5));
    }

    @org.junit.Test
    public void merge1() throws Exception {
        int[] a1 = {0, 2};
        int[] a2 = {1, 3};
        int[] a3 = {0, 1, 2, 3};
        assertEquals(Arrays.toString(a3), Arrays.toString(Module2.mergeArrays(a1, a2)));
    }
}
