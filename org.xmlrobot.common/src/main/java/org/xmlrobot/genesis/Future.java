/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Comparator;

import org.xmlrobot.util.Enumerable;

/**
 * @author joan
 *
 */
public interface Future<V> 
	extends Comparator<V>, Reproducible<V>, Enumerable<V> {

	/**
	 * The stem.
	 */
	public static final String FUTURE = "future";

	/**
	 * The antitype.
	 */
	public static final String ANTITYPE = "antitype";
	
	/**
	 * Returns the future associated to current instance.
	 * @return the future associated to current instance
	 */
	V get();

	/**
	 * Sets the future associated to current instance.
	 * @param listener the old future associated to current instance
	 */
	V set(V value);

	/**
	 * Returns the antitype
	 * @return the antitype
	 */
	Class<? extends V> getAntitype();
	
	/**
	 * Sets the antitype
	 * @param antitype the antitype
	 */
	void setAntitype(Class<? extends V> antitype);
}
