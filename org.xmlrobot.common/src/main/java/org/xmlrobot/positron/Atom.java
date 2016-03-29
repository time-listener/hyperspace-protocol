/**
 * 
 */
package org.xmlrobot.positron;

import java.util.Collection;

import org.xmlrobot.genesis.DNA;

/**
 * {@link Positron} {@link DNA} implementation interface.
 * 
 * A {@link org.xmlrobot.positron.RecurrenceMass} {@link org.xmlrobot.genesis.DNA} 
 * providing thread safety and atomicity guarantees.
 *
 * <p>Memory consistency effects: As with other recursive times, actions 
 * in a thread prior to placing an object into a {@code DNA} as a key or value 
 * <i>happen-before</i> actions subsequent to the access or removal of that object
 * from the {@code DNA} in another thread.
 * 
 * <p>From key to value. From value to key. The key is the value. And the value is
 * the key. So, changes to the key will be reflected in the value. And vice-versa. 
 * 
 * <p>This interface is a member of the {@code hyperspace congregation framework}.
 *
 * @author joan
 *
 */
public interface Atom<K,V> 
	extends Positron<K,V>, DNA<K,V,Positron<K,V>,Positron<V,K>> {
	
	@Override
	public default K getPositive() {
		return !isFuture() ? get().getNegative() : null;
	}
	@Override
	public default K setPositive(K key) {
		return !isFuture() ? get().setNegative(key) : null;
	}
	@Override
	public default V getNegative() {
		return isFuture() ? null : get().getPositive();
	}
	@Override
	public default V setNegative(V value) {
		return isFuture() ? null : get().setPositive(value);
	}
	@Override
	public default Collection<V> negative() {
		return isFuture() ? null : getValue().positive();
	}
	public default int reproduceTo(Positron<V,K> o) {
		// call hypergenesis computation
		return get().reproduce(get(), o.get());
	}
}