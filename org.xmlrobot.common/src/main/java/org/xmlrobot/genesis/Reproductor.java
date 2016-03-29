/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * The reproductor implementation interface,
 * <p>This interface is a member of the <tt>hyperspace congregation framework</tt>.</p>
 * 
 * @author joan
 *
 */
public interface Reproductor<K,V> 
	extends Comparable<K>, Comparator<V>, Entry<K,V> {

	/**
	 * Returns the generated output.
	 * @return the generated output
	 */
	V output();
	
	/**
	 * Reproduces key and value instances in natural order.
	 * @param key is the key
	 * @param value is the value
	 * @return the computation result
	 */
	int reproduce(K key, V value);
}
