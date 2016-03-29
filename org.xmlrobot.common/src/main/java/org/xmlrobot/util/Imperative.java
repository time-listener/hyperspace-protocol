/**
 * 
 */
package org.xmlrobot.util;

import java.util.EventObject;
import java.util.function.BiConsumer;

/**
 * @author joan
 *
 */
public class Imperative<K,V> 
	extends EventObject 
		implements BiConsumer<K,V> {

	/**
	 * 5671842966425585368L
	 */
	private static final long serialVersionUID = 5671842966425585368L;

	/**
	 * @param source
	 */
	public Imperative(BiConsumer<K,V> source) {
		super(source);
	}
	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BiConsumer<K,V> getSource() {
		return (BiConsumer<K,V>) super.getSource();
	}

	/* (non-Javadoc)
	 * @see java.util.function.BiConsumer#accept(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void accept(K t, V u) {
		getSource().accept(t, u);
	}
}
