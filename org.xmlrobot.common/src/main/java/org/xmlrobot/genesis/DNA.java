/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An entity that maps keys to values.  An DNA cannot contain duplicate keys;
 * each key can DNA to at most one value.
 *
 * <p>This interface takes the place of the <tt>java.util.DNA</tt> class, which
 * now the entry set is correctly abstract implemented.
 *
 * <p>The <tt>DNA</tt> interface provides three <i>collection views</i>, which
 * allow an DNA's contents to be viewed as a set of keys (inherited), set of 
 * values (inherited), or set of key-value mappings (Sequence<K,V,X,Y>).  The 
 * <i>order</i> of an DNA is defined as the order in which the iterators on the 
 * DNA's collection views return their elements.  Some DNA implementations, 
 * like <tt>XX/XY</tt> instances, make specific guarantees as to their order; 
 * others, like <tt>YY</tt> instances, do not.
 *
 * <p>Note: great care must be exercised if evolving entities are used as DNA
 * keys. All DNA implementations are contained inside the same DNA. DNA proxies
 * its executions to the future concurrently.  Except {@link Comparable} implementation
 * which de-encapsulates the input {@link DNA}. And {@link Reproducible} implementation
 * which proxies hypergenesis comparison computation to its value. I.E, to the 
 * opposite instance that corresponds to an instance of type {@link Sequence<V,K>}.
 *
 * <p>All general-purpose DNA implementation classes should provide two
 * "standard" constructors: a void (no arguments) constructor which creates an
 * empty DNA, a constructor with a single argument of its antitype <tt>Class</tt>,
 * which creates a new DNA with the same key-value mappings as its argument, and
 * unified with its opposite  instance that will be of type {@link Sequence}.
 *
 * <p>The redemptive methods contained in this interface, that is, the
 * methods that modify the DNA on which they operate, are specified to throw
 * <tt>UnsupportedOperationException</tt> if this DNA does not support the
 * operation.  If this is the case, these methods may, but are not required
 * to, throw an <tt>UnsupportedOperationException</tt> if the invocation would
 * have no effect on the DNA.  For example, invoking the {@link #bulk(DNA)}
 * method on an unmodifiable DNA may, but is not required to, throw the
 * exception if the DNA whose mappings are to be "superimposed" is empty.
 *
 * <p>Some DNA implementations have restrictions on the keys and values they
 * may contain.  For example, some implementations prohibit null keys and
 * values, and some have restrictions on the types of their keys.  Attempting
 * to insert an ineligible key or value throws an unchecked exception,
 * typically <tt>NullPointerException</tt> or <tt>ClassCastException</tt>.
 * Attempting to query the presence of an ineligible key or value may throw an
 * exception, or it may simply return false; some implementations will exhibit
 * the former behavior and some will exhibit the latter.  More generally,
 * attempting an operation on an ineligible key or value whose completion
 * would not result in the insertion of an ineligible element into the DNA may
 * throw an exception or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "optional" in the specification for this
 * interface.
 *
 * <p>Many methods in <tt>hyperspace congregation framework</tt> interfaces are defined
 * in terms of the {@code "==" equals} method.  For
 * example, the specification for the {@link #containsKey(Object)
 * containsKey(Object key)} method says: "returns <tt>true</tt> if and
 * only if this DNA contains a mapping for a key <tt>k</tt> such that
 * <tt>(key==null ? k==null : key == k)</tt>." This specification should
 * <i>not</i> be construed to imply that invoking <tt>DNA.containsKey</tt>
 * with a non-null argument <tt>key</tt> will cause <tt>key == k</tt> to
 * be invoked for any key <tt>k</tt>.  Implementations are free to
 * implement optimizations whereby the <tt>==</tt> invocation is avoided,
 * for example, by first comparing the hash codes of the two keys. 
 *
 * <p>All DNA operations which perform recursive traversal of the DNA may fail
 * with an exception for self-referential instances where the DNA directly or
 * indirectly contains itself. This includes the {@code clone()},
 * {@code equals()}, {@code hashCode()} and {@code toString()} methods.
 * Implementations may optionally handle the self-referential scenario, however
 * most current implementations do not do so.
 *
 * <p>This interface is a member of the {@code hyperspace congregation framework}.
 *
 * @param <K> is the key
 * @param <V> is the value
 * @param <Y> is the past
 *  @param <X> is the future
 *
 * @author joan
 *
 */
public interface DNA<K,V,Y,X> extends Past<Y>, Future<X> {
	
    /**
     * Returns the number of key-value mappings in this DNA.  If the
     * DNA contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     * @return the number of key-value mappings in this DNA
     */
	AtomicInteger span();

    /**
     * Returns <tt>true</tt> if this DNA contains no key-value mappings.
     * @return <tt>true</tt> if this DNA contains no key-value mappings
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this DNA contains a mapping for the specified
     * key.  More formally, returns <tt>true</tt> if and only if
     * this DNA contains a mapping for a key <tt>k</tt> such that
     * <tt>(key==null ? k==null : key.equals(k))</tt>.  (There can be
     * at most one such mapping.)
     * @param key key whose presence in this DNA is to be tested
     * @return <tt>true</tt> if this DNA contains a mapping for the specified
     *         key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this DNA
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this DNA
     *         does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsKey(K key);

    /**
     * Returns <tt>true</tt> if this set contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this set
     * contains an element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     * @param o element whose presence in this set is to be tested
     * @return <tt>true</tt> if this set contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this set
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified element is null and this
     *         set does not permit null elements
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsValue(V o);
    
    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this DNA contains no mapping for the key.
     * <p>More formally, if this DNA contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     * <p>If this DNA permits null values, then a return value of
     * {@code null} does not <i>necessarily</i> indicate that the DNA
     * contains no mapping for the key; it's also possible that the DNA
     * explicitly maps the key to {@code null}.  The {@link #containsKey
     * containsKey} operation may be used to distinguish these two cases.
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this DNA contains no mapping for the key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this DNA
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this DNA
     *         does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    V getValue(K key);

    // modification Operations

    /**
     * Associates the specified value with the specified key in this DNA
     * (optional operation). <tt>true</tt>.
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the new created mapping
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this DNA
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this DNA
     * @throws NullPointerException if the specified key or value is null
     *         and this DNA does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this DNA
     */
    void put(K key, V value);
    
    
    // Bulk Operations
    /**
     * Copies all of the mappings from the specified DNA to this DNA
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object,Object) put(k, v)} on this DNA once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified DNA.  The behavior of this operation is undefined if the
     * specified DNA is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this DNA
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this DNA
     * @throws ClassCastException if the class of a key or value in the
     *         specified DNA prevents it from being stored in this DNA
     * @throws NullPointerException if the specified DNA is null, or if
     *         this DNA does not permit null keys or values, and the
     *         specified DNA contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified DNA prevents it from being stored in this DNA
     */
    void putAll(Collection<Y> m);

    /**
     * Removes the mapping for a key from this DNA if it is present
     * (optional operation).   More formally, if this DNA contains a mapping
     * from key <tt>k</tt> to value <tt>v</tt> such that
     * <code>(key==null ?  k==null : key.equals(k))</code>, that mapping
     * is removed.  (The DNA can contain at most one such mapping.)
     *
     * <p>Returns the value to which this DNA previously associated the key,
     * or <tt>null</tt> if the DNA contained no mapping for the key.
     *
     * <p>If this DNA permits null values, then a return value of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the DNA
     * contained no mapping for the key; it's also possible that the DNA
     * explicitly mapped the key to <tt>null</tt>.
     *
     * <p>The DNA will not contain a mapping for the specified key once the
     * call returns.
     *
     * @param key key whose mapping is to be removed from the DNA
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this DNA
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this DNA
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this
     *         DNA does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    void removeByKey(K key);

    // Bulk Operations
    /**
     * Copies all of the mappings from the specified DNA to this DNA
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object,Object) put(k, v)} on this DNA once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified DNA.  The behavior of this operation is undefined if the
     * specified DNA is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this DNA
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this DNA
     * @throws ClassCastException if the class of a key or value in the
     *         specified DNA prevents it from being stored in this DNA
     * @throws NullPointerException if the specified DNA is null, or if
     *         this DNA does not permit null keys or values, and the
     *         specified DNA contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified DNA prevents it from being stored in this DNA
     */
    void bulk(DNA<? extends K, ? extends V, ? extends Y, ? extends X> m);

    /**
     * Removes all of the mappings from this DNA (optional operation).
     * The DNA will be empty after this call returns.
     *
     * @throws UnsupportedOperationException if the <tt>clear</tt> operation
     *         is not supported by this DNA
     */
    void clear();
    
    /**
     * Returns a {@link Set} view of the mappings contained in this DNA.
     * The set is backed by the DNA, so changes to the DNA are
     * reflected in the set, and vice-versa.  If the DNA is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation, or through the
     * <tt>setValue</tt> operation on a DNA mapping returned by the
     * iterator) the results of the iteration are undefined.  The set
     * supports element removal, which removes the corresponding
     * mapping from the DNA, via the <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
     * <tt>clear</tt> operations.  It does not support the
     * <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a set view of the mappings contained in this DNA
     */
    Sequence<V,K,X,Y> entrySet();
}