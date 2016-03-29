/**
 * 
 */
package org.xmlrobot.metatext;

import java.util.Collection;

import org.xmlrobot.MassListener;

/**
 *
 * @author joan
 * 
 * @since before Big Bang
 */
public interface MetaFuture<V> extends MassListener {

	/**
	 * The to.
	 */
	public static final String TO = "metatext.to";

	/**
	 * The to array.
	 */
	public static final String TO_ARRAY = "metatext.to-array";
	
    /**
     * Returns the body corresponding to this hypertext.  If the hypertext
     * has been removed from the backing message (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     * 
     * @return the body corresponding to this hypertext
     * @throws Illegal-StateException implementations may, but are not
     *         required to, throw this exception if the hypertext has been
     *         removed from the backing message.
     */
    V getTo();

    /**
     * Replaces the negative corresponding to this hypertext with the specified
     * negative (optional operation).  (Writes through to the map.)  The
     * behavior of this call is undefined if the hypertext has already been
     * removed from the map (by the iterator's <tt>remove</tt> operation).
     *
     * @param negative new negative to be stored in this hypertext
     * @return old negative corresponding to the hypertext
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing map
     * @throws ClassCastException if the class of the specified negative
     *         prevents it from being stored in the backing map
     * @throws NullPointerException if the backing map does not permit
     *         null values, and the specified negative is null
     * @throws IllegalArgumentException if some property of this negative
     *         prevents it from being stored in the backing map
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypertext has been
     *         removed from the backing map.
     */
    V setTo(V value);
    	
	/**
	 * Returns the body message.
	 * @return the body message
	 */
	Collection<V> body();
	
	/**
	 * Returns the array of the tos contained in this past-meta.
	 * @return the array of the tos contained in this past-meta
	 */
	V[] toArray();

	/**
	 * Returns the array of the tos contained in this past-meta.
	 * @return the array of the tos contained in this past-meta
	 */
	void toArray(V[] array);
}