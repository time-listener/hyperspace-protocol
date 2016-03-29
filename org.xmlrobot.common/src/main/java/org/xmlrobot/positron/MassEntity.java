/**
 * 
 */
package org.xmlrobot.positron;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.TimeListener;

/**
 * A {@link MassEntity} {link DNA} {@link Chain} implementation interface.
 * @author joan
 *
 */
public interface MassEntity
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>> 
		extends Atom<K,V>, Chain<K,V> {

	@Override
	public K getPositive();
	@Override
	public K setPositive(K key);
	@Override
	public V getNegative();
	@Override
	public V setNegative(V value);
	@Override
	public default Collection<V> negative() {
		return isFuture() ? null : getValue().positive();
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public default int compareTo(Positron<K, V> o){
		return compare(get(), o.get());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	public default int reproduceTo(Positron<V,K> o) {
		// call hypergenesis computation
		return get().reproduce(get(), o.get());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaMap#size()
	 */
	@Override
	public default AtomicInteger span() {
		return depth(root());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaMap#isEmpty()
	 */
	@Override
	public default boolean isEmpty() {
		return isFuture() && isPast();
	}
}