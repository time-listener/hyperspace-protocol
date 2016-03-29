/**
 * 
 */
package org.xmlrobot.util;

import java.util.Enumeration;

/**
 * Enumeration implementation.
 * @author joan
 *
 * @param <V> the type of elements returned by the enumerator
 */
public interface Enumerable<V> {
	
    /**
     * Returns an enumerator over elements of type {@code V}.
     * @return an Enumerator.
     */
	Enumeration<V> enumerator();
}
