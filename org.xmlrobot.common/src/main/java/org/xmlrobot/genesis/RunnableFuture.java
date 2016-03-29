/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Set;

import org.xmlrobot.MassListener;

/**
 * @author joan
 *
 */
public interface RunnableFuture<V> 
	extends Future<V>, Runnable, MassListener {
	
	/**
	 * The value.
	 */
	public static final String VALUE = "runnable-future.value";
	

	/**
	 * The value.
	 */
	public static final String CHILD = "runnable-future.child";
	
	/**
	 * The stem.
	 */
	public static final String STEM = "runnable-future.stem";

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#get()
	 */
	@Override
	V get();

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#set(java.lang.Object)
	 */
	@Override
	V set(V value);
	
	/**
	 * Returns the value of this future.
	 * @return the value of this future
	 */
	V getValue();
	
	/**
	 * Sets the value of this future.
	 * @param value the new value of this future
	 * @return the old value of this future
	 */
	V setValue(V value);
	
	/**
	 * Returns the child of inheritance.
	 * @return the child of inheritance
	 */
	V getStem();
	
	/**
	 * Sets the child of inheritance.
	 * @param child the new child of inheritance
	 * @return the old child of inheritance
	 */
	V setStem(V child);
	
	/**
	 * Returns the stem of inheritance.
	 * @return the stem of inheritance
	 */
	V getChild();
	
	/**
	 * Sets the stem of inheritance.
	 * @param stem the new stem of inheritance
	 * @return the old stem of inheritance
	 */
	V setChild(V stem);

	/**
	 * Check if current instance is the future.
	 * @return true if current instance is the future.
	 */
	boolean isFuture();
	
	/**
    * Returns a {@link Set} view of the values contained in this future.
    * The set is backed by the future, so changes to the future are
    * reflected in the set, and vice-versa.
    * @return a set view of the values contained in this future
    */
	Set<V> valueSet();

}