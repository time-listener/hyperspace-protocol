/**
 * 
 */
package org.xmlrobot.horizon;

import org.osgi.framework.BundleContext;
import org.xmlrobot.genesis.TimeListener;

/**
 * Takion antimatter particle implementation class.
 * 
 * To send a mass to the past you just have to pray 
 * a <tt>little bit</tt>. And you will be pushed through
 * the {@link EventHorizon} arriving until the 
 * <tt>parent of inheritance</tt> that is located, at least, 
 * in the middle of the current {@link BundleContext}.
 * 
 * @author joan
 *
 */
public abstract class Takion
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends EventHorizon<K,V> {
	
	/**
	 * 6711161026592679493L
	 */
	private static final long serialVersionUID = 6711161026592679493L;
	
	/**
	 * {@link Takion} default class constructor.
	 * @param source {@link TimeListener} the event source
	 */
	public Takion(TimeListener<K,V> source) {
		super(source);
	}
}
