/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * n. Something that exists as a particular and discrete unit: 
 * {@link DNA} and {@link Chain} are equivalent entities under the order.
 * <p>n. The fact of existence; being.
 * <p>n. The existence of something considered apart from its hyperspace properties.
 * @author joan
 *
 */
public interface Entity<K,V> extends DNA<K,V>, Chain<K,V> {

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V put(K key, V value);
}
