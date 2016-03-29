/**
 * 
 */
package org.xmlrobot.metatext;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.genesis.DNA;
import org.xmlrobot.horizon.Mass;

/**
 * A {@link Metatext} that is {@link MetaMap}.
 * @author joan
 *
 */
public interface MetaMap<K,V> 
	extends Metatext<K,V>, DNA<K,V,Metatext<K,V>,Metatext<V,K>> {

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#entrySet()
	 */
	@Override
	public default MetaSet<V,K> entrySet() {
		return (MetaSet<V,K>) getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#clear()
	 */
	@Override
	public default void clear() {
		clear(root());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void put(K key, V value);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putAll(java.util.Collection)
	 */
	@Override
	public default void putAll(Collection<Metatext<K,V>> m) {
		// put all pars under inheritance force
		for(Metatext<K,V> par : m)
			put(par.getFrom(), par.getTo());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#size()
	 */
	@Override
	public default AtomicInteger span() {
		return depth(root());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#removeByKey(java.lang.Object)
	 */
	@Override
	public default void removeByKey(K key) {
		releaseFrom(root(), new AtomicInteger(0), new Mass<K>(key));
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getValue(java.lang.Object)
	 */
	@Override
	public default V getValue(K key) {
		return acquireTo(root(), new Mass<K>(key)).getSource();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#containsValue(java.lang.Object)
	 */
	@Override
	public default boolean containsValue(V value) {
		return containsTo(root(), new Mass<V>(value));
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#containsKey(java.lang.Object)
	 */
	@Override
	public default boolean containsKey(K key) {
		return containsFrom(root(), new Mass<K>(key));
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#bulk(org.xmlrobot.genesis.DNA)
	 */
	@Override
	public default void bulk(DNA<? extends K,? extends V,
			? extends Metatext<K,V>,
			? extends Metatext<V,K>> m) {
		// put all children
		for(Metatext<K,V> par : m)
			put(par.getFrom(), par.getTo());
	}
}
