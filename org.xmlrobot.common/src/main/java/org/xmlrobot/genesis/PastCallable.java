/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Set;
import java.util.concurrent.Callable;

import org.xmlrobot.MassListener;

/**
 * A {@link Past} 
 * @author joan
 *
 */
public interface PastCallable<K> 
	extends Past<K>, Callable<K>, MassListener {

	/**
	 * The key.
	 */
	public static final String KEY = "past-callable.key";
	
	/**
	 * The parent.
	 */
	public static final String PARENT = "past-callable.parent";
	
	/**
	 * The root.
	 */
	public static final String ROOT = "past-callable.root";

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#call()
	 */
	@Override
	K call();

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#put(java.lang.Object)
	 */
	@Override
	K put(K listener);
	
	/**
	 * Returns the key associated to this past callable.
	 * @return the key associated to this past callable
	 */
	K getKey();
	
	/**
	 * Returns the root of inheritance.
	 * @return the root of inheritance
	 */
	K getRoot();
	
	/**
	 * Sets the root of inheritance.
	 * @param listener the root of inheritance
	 */
	K setRoot(K listener);
	
	/**
	 * Returns the parent of inheritance.
	 * @return the parent of inheritance
	 */
	K getParent();
	
	/**
	 * Sets the parent of inheritance
	 * @param listener the parent of inheritance
	 */
	K setParent(K listener);

	/**
	 * Check if current instance is the past.
	 * @return true if current instance is the past.
	 */
	boolean isPast();
	
	/**
     * Returns a {@link Set} view of the keys contained in this past.
     * The set is backed by the past, so changes to the past are
     * reflected in the set, and vice-versa.
     * @return a set view of the keys contained in this past
     */
	Set<K> keySet();
}