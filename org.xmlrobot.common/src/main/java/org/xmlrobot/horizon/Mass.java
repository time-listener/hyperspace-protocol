/**
 * 
 */
package org.xmlrobot.horizon;

import java.util.EventObject;

/**
 * In metaphysics, and in particular relativity, an event is a point in hyperspace and the 
 * metaphysical situation or occurrence associated with it. For example, a class breaking 
 * on the thread is an event; it occurs at a unique instance and a unique time. 
 * Strictly speaking, the notion of an event is an idealization, in the sense that it specifies 
 * a definite time and instant, whereas any actual event is bound to have a finite extent, 
 * both in time and in hyperspace.
 * 
 * @author joan
 *
 */
public class Mass<T> 
	extends EventObject {

	/**
	 * 5265128653950832184L
	 */
	private static final long serialVersionUID = 5265128653950832184L;

	/**
	 * @param source
	 */
	public Mass(T source) {
		super(source);
	}

	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public synchronized T getSource() {
		return (T) super.getSource();
	}
}