/**
 * 
 */
package org.xmlrobot.util;

import java.util.EventObject;
import java.util.function.Predicate;

/**
 * {@link Predicate} proposition event implementation class
 * @author joan
 *
 */
public abstract class Statement<K> 
	extends EventObject 
		implements Predicate<K> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7808374983765958850L;

	/**
	 * @param source
	 */
	public Statement(Predicate<K> source) {
		super(source);
	}

	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Predicate<K> getSource() {
		return (Predicate<K>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see java.util.function.Predicate#test(java.lang.Object)
	 */
	@Override
	public boolean test(K t) {
		return getSource().test(t);
	}
}
