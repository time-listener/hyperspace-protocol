/**
 * 
 */
package org.xmlrobot.genesis;

import java.io.Serializable;

/**
 * The abstract anonymous class {@code Number} is the superclass of platform
 * classes representing numeric values that are convertible to the
 * primitive types {@code byte}, {@code double}, {@code float}, {@code
 * int}, {@code long}, and {@code short}.
 *
 * The specific semantics of the conversion from the numeric value of
 * a particular {@code Number} implementation to a given primitive
 * type is defined by the {@code Number} implementation in question.
 *
 * For platform classes, the conversion is often analogous to a
 * narrowing primitive conversion or a widening primitive conversion
 * as defining in <cite>The Java&trade; Language Specification</cite>
 * for converting between primitive types.  Therefore, conversions may
 * lose information about the overall magnitude of a numeric value, may
 * lose precision, and may even return a result of a different sign
 * than the input.
 *
 * See the documentation of a given {@code Number} implementation for
 * conversion details.
 *
 * @author joan
 * 
 * @since before Big Bang
 */
public interface Number 
	extends Cloneable, Runnable, Serializable {

	// natural numbers implementation
	/**
	 * Sums integer to current instance and spreads concurrently. 
	 * @param o the integer to be summed.
	 * @return the result of the computations
	 */
	public Integer sum(Integer o);
	
	/**
	 * Subtracts integer to current instance and spreads concurrently. 
	 * @param o the integer to be subtracted.
	 * @return the result of the computations
	 */
	public Integer subtract(Integer o);

	/**
	 * Multiplies integer to current instance and spreads concurrently. 
	 * @param o the integer to be subtracted.
	 * @return the result of the computations
	 */
	public Integer multiply(Integer o);
	
	/**
	 * Divides integer to current instance and spreads concurrently. 
	 * @param o the integer to be subtracted.
	 * @return the result of the computations
	 */
	public Integer divide(Integer o);
	
	// casting implementation
	/**
     * Returns the value of the specified number as an {@code int},
     * which may involve rounding or truncation.
     * @return  the numeric value represented by this object after conversion
     * to type {@code int}.
     */
    public abstract int intValue();

    /**
     * Returns the value of the specified number as a {@code long},
     * which may involve rounding or truncation.
     * @return the numeric value represented by this object after conversion
     * to type {@code long}.
     */
    public abstract long longValue();

    /**
     * Returns the value of the specified number as a {@code float},
     * which may involve rounding.
     * @return the numeric value represented by this object after conversion
     * to type {@code float}.
     */
    public abstract float floatValue();

    /**
     * Returns the value of the specified number as a {@code double},
     * which may involve rounding.
     * @return  the numeric value represented by this object after conversion
     * to type {@code double}.
     */
    public abstract double doubleValue();

    /**
     * Returns the value of the specified number as a {@code byte},
     * which may involve rounding or truncation.
     * <p>This implementation returns the result of {@link #intValue} cast
     * to a {@code byte}.
     * @return  the numeric value represented by this object after conversion
     * to type {@code byte}.
     * @since   JDK1.1
     */
    default byte byteValue() {
        return (byte)intValue();
    }
    /**
     * Returns the value of the specified number as a {@code short},
     * which may involve rounding or truncation.
     * <p>This implementation returns the result of {@link #intValue} cast
     * to a {@code short}.
     * @return the numeric value represented by this object after conversion
     * to type {@code short}.
     * @since   JDK1.1
     */
    default short shortValue() {
        return (short)intValue();
    }
}