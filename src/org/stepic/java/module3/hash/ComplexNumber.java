package org.stepic.java.module3.hash;

/**
 * Created by vitaly on 24/09/16.
 */
public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(int re, int im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() { return re; }

    public double getIm() { return im; }

    @Override
    public String toString() { return re + "+" + im + "i"; }

    @Override
    public boolean equals(Object anObject) {
        // compare the object with itself
        if (this == anObject) {
            return true;
        }
        // compare the object with another object
        if (anObject instanceof ComplexNumber) {
            ComplexNumber other = (ComplexNumber) anObject;

            return (other.getRe() == this.getRe()) &&
                    (other.getIm() == this.getIm());
        }
        return false;
    }

    /**
     * Return hashCode using formula:
     * result = p * q + c, г,
     *          where p = 17, q = 37
     * Collisions are inevitable:
     * https://stackoverflow.com/questions/18856530/complex-number-equals-method
     * https://habrahabr.ru/post/169733/
     * https://habrahabr.ru/post/168195/
     * @return int
     */
    @Override
    public int hashCode() {

        int result = 17;
        long longBitsRe = Double.doubleToLongBits(getRe());
        long longBitsIm = Double.doubleToLongBits(getIm());
        result = 37 * result + (int)(longBitsRe - (longBitsRe >>> 32)) + (int)(longBitsIm - (longBitsIm >>> 32));
        return result;
    }
}
