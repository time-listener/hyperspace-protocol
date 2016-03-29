/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * @author joan
 *
 */
public interface Past<K> 
	extends Comparable<K>, Iterable<K> {

	/**
	 * The past.
	 */
	public static final String PAST = "past";

	/**
	 * The type.
	 */
	public static final String TYPE = "type";
	
	/**
	 * Returns the past associated to current instance.
	 * @return the past associated to current instance
	 */
	K call();
	
	/**
	 * Puts the past.
	 * @param listener the new past
	 */
	K put(K listener);
	
	/**
	 * Returns the type.
	 * @return the type.
	 */
	Class<? extends K> getType();
	
	/**
	 * Sets the type.
	 * @param type the type
	 */
	void setType(Class<? extends K> type);

}
