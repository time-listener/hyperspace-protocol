/**
 * 
 */
package org.xmlrobot.util;

import java.util.EventObject;
import java.util.function.BiFunction;

/**
 * @author joan
 *
 */
public class Commandment<K,V> 
	extends EventObject 
		implements BiFunction<K,V,V> {

	/**
	 * 4843010130015601316L
	 */
	private static final long serialVersionUID = 4843010130015601316L;

	/**
	 * @param source
	 */
	public Commandment(BiFunction<K,V,V> source) {
		super(source);
	}

	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BiFunction<K,V,V> getSource() {
		return (BiFunction<K,V,V>) super.getSource();
	}

	/* (non-Javadoc)
	 * @see java.util.function.BiFunction#apply(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V apply(K t, V u) {
		return getSource().apply(t, u);
	}
}
