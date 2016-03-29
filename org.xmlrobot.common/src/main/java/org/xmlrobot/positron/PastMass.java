/**
 * 
 */
package org.xmlrobot.positron;

import java.util.Collection;

/**
 * The past of mass.
 * @author joan
 *
 */
public interface PastMass<K> {

	/**
	 * The positive.
	 */
	public static final String POSITIVE = "positron.key";
	
    /**
     * Returns the key corresponding to this positron.
     * @return the key corresponding to this positron
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the positron has been
     *         removed from the backing mass.
     */
    K getPositive();

    /**
     * Replaces the positive corresponding to this positron
     * with the specified positive (optional operation).  (Writes through 
     * to the mass.)  The behavior of this call is undefined if the positron 
     * has already been removed from the mass (by the iterator's 
     * <tt>remove</tt> operation).
     *
     * @param positive new positive to be stored in this positron
     * @return old positive corresponding to the positron
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing mass
     * @throws ClassCastException if the class of the specified positive
     *         prevents it from being stored in the backing mass
     * @throws NullPointerException if the backing mass does not permit
     *         null values, and the specified positive is null
     * @throws IllegalArgumentException if some property of this positive
     *         prevents it from being stored in the backing mass
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the positron has been
     *         removed from the backing mass.
     */
    K setPositive(K key);
    
	/**
	 * Returns the pole positive.
	 * @return the pole positive
	 */
	Collection<K> positive();
}