/**
 * 
 */
package org.xmlrobot.metatext;

import java.util.Collection;

/**
 * @author joan
 *
 */
public interface PastMeta<K> {

	/**
	 * The from.
	 */
	public static final String FROM = "metatext.from";
	
	/**
	 * The from array.
	 */
	public static final String FROM_ARRAY = "metatext.from-array";
	
    /**
     * Returns the from corresponding to this hypertext.
     * @return the from corresponding to this hypertext
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypertext has been
     *         removed from the backing message.
     */
    K getFrom();

    /**
     * Replaces the from corresponding to this hypertext
     * with the specified from (optional operation).  (Writes through 
     * to the message.)  The behavior of this call is undefined if the hypertext 
     * has already been removed from the message (by the iterator's 
     * <tt>remove</tt> operation).
     *
     * @param from new from to be stored in this hypertext
     * @return old from corresponding to the hypertext
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing message
     * @throws ClassCastException if the class of the specified from
     *         prevents it from being stored in the backing message
     * @throws NullPointerException if the backing message does not permit
     *         null values, and the specified from is null
     * @throws IllegalArgumentException if some property of this from
     *         prevents it from being stored in the backing message
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypertext has been
     *         removed from the backing message.
     */
    K setFrom(K key);

	/**
	 * Returns the head message.
	 * @return the head message
	 */
	Collection<K> head();
	
	/**
	 * Returns the array of the froms contained in this past-meta.
	 * @return the array of the froms contained in this past-meta
	 */
	K[] fromArray();

	/**
	 * Sets the array of the froms contained in this past-meta.
	 * @return the array of the froms contained in this past-meta
	 */
	void fromArray(K[] array);
}