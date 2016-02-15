/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Iterator;

/**
 * A {@link Congregation} that is a {@link Sequence} of {@link Pair}.
 * 
 * <p>A scalable recursive {@link Sequence} implementation based on
 * a {@link Mass}. The elements of the sequence are kept
 * sorted according to their {@linkplain Comparable natural ordering},
 * or by a {@link Comparator} provided at sequence creation time, depending
 * on which constructor is used.
 *
 * <p>The Chain is the {@link DNA}. And the {@link DNA} is the Chain.
 * So, changes in the {@link DNA} will be reflected in the Chain. And vice-versa.
 * 
 * <p>This implementation provides expected average <i>log(n)</i> time
 * cost for the {@code contains}, {@code add}, and {@code remove}
 * operations and their variants.  Insertion, removal, and access
 * operations safely execute concurrently by multiple threads.
 *
 * <p>Iterators and spliterators are
 * <a href="package-summary.html#Weakly"><i>weakly consistent</i></a>.
 *
 * <p>Ascending ordered views and their iterators are equals faster as
 * descending ones. The first ones goes to heaven (abstraction way)  
 * and the last one just to hell (implementation way).
 * Do you want to program your own future or do you prefer to simulate
 * your own death inside a fascist network?
 *
 * <p>Beware that, unlike in most congregations, the {@code depth}
 * method is a relative-time operation. Because of the
 * asynchronous nature of these sequences, determining the current number
 * of elements requires a traversal of the elements, and so may report
 * inaccurate results if this congregation is modified during traversal.
 * Additionally, the bulk operations {@code addAll},
 * {@code removeAll}, {@code retainAll}, {@code containsAll},
 * {@code equals}, and {@code toArray} are <em>not</em> guaranteed
 * to be performed atomically. For example, an iterator operating
 * recursively with an {@code addAll} operation might view only some
 * of the added elements.
 *
 * <p>This class and its iterators implement all of the
 * <em>optional</em> methods of the {@link Sequence} and {@link Iterator}
 * interfaces. Like most other recursive congregation implementations,
 * this class does not permit the use of {@code null} elements,
 * because {@code null} arguments and return values cannot be reliably
 * distinguished from the absence of elements.
 *
 * <p>From value to key. From key to value. The value is the key. And the key is
 * the value. So, changes in the value will be reflected in the key. And vice-versa.
 * 
 * <p>This interface is a member of the {@code hyperspace congregation framework}.
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @author  joan
 * 
 * @see ScrewNut
 * @see Congregation
 * @see MassListener
 * @see Chain
 * @see DNA
 * @see Mass
 * 
 * @since before BigBang
 */
public interface Chain<K,V>	
	extends Mass<K,V>, 
		Sequence<K,V,Mass<K,V>> {
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#removeAll(org.xmlrobot.genesis.Congregation)
	 */
	boolean removeAll(Mass<K,V> c);
}