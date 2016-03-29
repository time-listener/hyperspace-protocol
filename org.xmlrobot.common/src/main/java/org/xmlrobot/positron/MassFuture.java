/**
 * 
 */
package org.xmlrobot.positron;

import java.util.Collection;

/**
 * Mass of the {@link Future}.
 * @author joan
 *
 */
public interface MassFuture<V> {

	/**
	 * The negative.
	 */
	public static final String NEGATIVE = "positron.negative";

    /**
     * Returns the negative corresponding to this positron.  If the positron
     * has been removed from the backing mass (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     * 
     * @return the negative corresponding to this positron
     * @throws Illegal-StateException implementations may, but are not
     *         required to, throw this exception if the positron has been
     *         removed from the backing mass.
     */
    V getNegative();

    /**
     * Replaces the negative corresponding to this positron with the specified
     * negative (optional operation).  (Writes through to the map.)  The
     * behavior of this call is undefined if the positron has already been
     * removed from the map (by the iterator's <tt>remove</tt> operation).
     *
     * @param negative new negative to be stored in this positron
     * @return old negative corresponding to the positron
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing map
     * @throws ClassCastException if the class of the specified negative
     *         prevents it from being stored in the backing map
     * @throws NullPointerException if the backing map does not permit
     *         null values, and the specified negative is null
     * @throws IllegalArgumentException if some property of this negative
     *         prevents it from being stored in the backing map
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the positron has been
     *         removed from the backing map.
     */
    V setNegative(V value);
    
	/**
	 * Returns the pole negative.
	 * @return the pole negative
	 */
	Collection<V> negative();
}