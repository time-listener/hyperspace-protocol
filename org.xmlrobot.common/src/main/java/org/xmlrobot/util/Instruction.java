/**
 * 
 */
package org.xmlrobot.util;

import java.util.EventObject;
import java.util.function.Function;

/**
 * @author joan
 *
 */
public abstract class Instruction<K,V> 
	extends EventObject
		implements Function<K,V> {

	/**
	 * 4843010130015601316L
	 */
	private static final long serialVersionUID = 4843010130015601316L;

	/**
	 * @param source
	 */
	public Instruction(Function<K,V> source) {
		super(source);
	}
	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Function<K,V> getSource() {
		return (Function<K,V>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see java.util.function.Function#apply(java.lang.Object)
	 */
	@Override
	public V apply(K t) {
		return getSource().apply(t);
	}
}
