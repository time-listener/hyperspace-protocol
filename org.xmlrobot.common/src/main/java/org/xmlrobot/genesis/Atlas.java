/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.ConcurrentModificationException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.xmlrobot.util.Abort;

/**
 * Atlas implementation interface.
 * 
 * An Atlas is a {@link Pair} that maps keys to values. An Atlas 
 * cannot contain duplicate keys; each key can map to at most one value. 
 * All key-value pairs are universal and unique.
 *
 * <p>This interface takes the place of the <tt>java.util.Map</tt> interface, 
 * which the pair sequence was totally implemented rather than <tt>this</tt> 
 * interface, which has been implemented as {@code Congregation<T> entrySet()}.  
 *
 * <p>The <tt>Atlas</tt> interface provides three <i>congregation views</i>, 
 * which allow an Atlas's contents to be viewed as a sequence of keys, 
 * congregation of values, or sequence of key-value mappings. The <i>order</i> 
 * of an Atlas is defined as the order in which the iterators on the Atlas's
 * congregation views return their elements. All Atlas implementations, like 
 * the <tt>Screw</tt> class do not make specific guarantees as to their order. 
 * The <tt>opposite instance</tt> is who orders his inheritance.
 *
 * <p>All general-purpose <tt>Atlas</tt> implementation classes (which 
 * typically implement <tt>Atlas</tt> indirectly through one of its subclasses) 
 * should provide two "standard" constructors: a void (no arguments) constructor, 
 * which creates an empty Atlas, and a constructor with a single 
 * argument of type <tt>Class<Antitype></tt>, which creates a new instance with the 
 * opposite type.
 *
 * <p>Some Atlas implementations have restrictions on the keys and values they
 * may contain.  For example, some implementations prohibit null keys and
 * values, and some have restrictions on the types of their keys.  Attempting
 * to insert an ineligible key or value throws an unchecked exception, typically 
 * <tt>NullPointerException</tt> or <tt>ClassCastException</tt>. Attempting to 
 * query the presence of an ineligible key or value may throw an exception, or 
 * it may simply return false; some implementations will exhibit the former 
 * behavior and some will exhibit the latter.  More generally, attempting an 
 * operation on an ineligible key or value whose completion would not result 
 * in the insertion of an ineligible element into the Atlas may throw an 
 * <tt>Abort</tt> or it may succeed, at the option of the implementation.
 * Such exceptions are marked as "imposed" in the specification for this interface.
 *
 * <p>Many methods in {@code hyperspace congregation framework} interfaces are 
 * defined in terms of the {@link Object#equals(Object) equals} method. For 
 * example, the specification for the {@link #containsKey(Object) 
 * containsKey(Object key)} method says: "returns <tt>true</tt> if and
 * only if this Atlas contains a mapping for a key <tt>k</tt> such that
 * <tt>(key==null ? k==null : key.equals(k))</tt>." This specification should
 * <i>not</i> be construed to imply that invoking <tt>Atlas.containsKey</tt>
 * with a non-null argument <tt>key</tt> will cause <tt>key.equals(k)</tt> to
 * be invoked for any key <tt>k</tt>. Implementations are free to
 * implement optimizations whereby the <tt>equals</tt> invocation is avoided,
 * for example, by first comparing the hash codes of the two keys.  (The
 * {@link Object#hashCode()} specification guarantees that two objects with
 * unequal hash codes cannot be equal.) More generally, implementations of
 * the various Collections Framework interfaces are free to take advantage of
 * the specified behavior of underlying {@link Object} methods wherever the
 * implementor deems it appropriate.
 * 
 * <p>This interface is a member of the {@code hyperspace congregation framework}.
 * 
 * @author joan
 *
 */
public interface Atlas
	<K,V,T extends Pair<K,V,T>> 
		extends Pair<K,V,T> {

    /**
     * Returns <tt>true</tt> if this atlas contains an mapping for the specified
     * key.  More formally, returns <tt>true</tt> if and only if
     * this atlas contains an mapping for a key <tt>k</tt> such that
     * <tt>(key==null ? k==null : key.equals(k))</tt>.  (There can be
     * at most one such mapping.)
     *
     * @param key key whose presence in this atlas is to be tested
     * @return <tt>true</tt> if this atlas contains an mapping for the specified
     *         key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this atlas
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this atlas
     *         does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsKey(K key);

    /**
     * Returns <tt>true</tt> if this atlas maps one or more keys to the
     * specified value.  More formally, returns <tt>true</tt> if and only if
     * this atlas contains at least one mapping to a value <tt>v</tt> such that
     * <tt>(value==null ? v==null : value.equals(v))</tt>.  This operation
     * will probably require time linear in the atlas size for most
     * implementations of the <tt>Map</tt> interface.
     *
     * @param value value whose presence in this atlas is to be tested
     * @return <tt>true</tt> if this atlas maps one or more keys to the
     *         specified value
     * @throws ClassCastException if the value is of an inappropriate type for
     *         this atlas
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified value is null and this
     *         atlas does not permit null values
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean containsValue(V value);

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this atlas contains no mapping for the key.
     *
     * <p>More formally, if this atlas contains a mapping from a key
     * {@code k} to a value {@code v} such that {@code (key==null ? k==null :
     * key.equals(k))}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such mapping.)
     *
     * <p>If this atlas permits null values, then a return value of
     * {@code null} does not <i>necessarily</i> indicate that the atlas
     * contains no mapping for the key; it's also possible that the atlas
     * explicitly maps the key to {@code null}.  The {@link #containsKey
     * containsKey} operation may be used to distinguish these two cases.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     *         {@code null} if this atlas contains no mapping for the key
     * @throws ClassCastException if the key is of an inappropriate type for
     *         this atlas
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this atlas
     *         does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    V get(K key);

    // Modification Operations
    /**
     * Associates the specified value with the specified key in this atlas
     * (optional operation).  If the atlas previously contained a mapping for
     * the key, the old value is replaced by the specified value.  (A atlas
     * <tt>m</tt> is said to contain a mapping for a key <tt>k</tt> if and only
     * if {@link #containsKey(Object) m.containsKey(k)} would return
     * <tt>true</tt>.)
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or
     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
     *         (A <tt>null</tt> return can also indicate that the atlas
     *         previously associated <tt>null</tt> with <tt>key</tt>,
     *         if the implementation supports <tt>null</tt> values.)
     * @throws Abort when something is wrong
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this atlas
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this atlas
     * @throws NullPointerException if the specified key or value is null
     *         and this atlas does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this atlas
     */
    V put(K key, V value);

    // Bulk Operations
    /**
     * Copies all of the mappings from the specified atlas to this atlas
     * (optional operation).  The effect of this call is equivalent to that
     * of calling {@link #put(Object,Object) put(k, v)} on this atlas once
     * for each mapping from key <tt>k</tt> to value <tt>v</tt> in the
     * specified atlas.  The behavior of this operation is undefined if the
     * specified atlas is modified while the operation is in progress.
     *
     * @param m mappings to be stored in this atlas
     * @throws Abort 
     * @throws UnsupportedOperationException if the <tt>putAll</tt> operation
     *         is not supported by this atlas
     * @throws ClassCastException if the class of a key or value in the
     *         specified atlas prevents it from being stored in this atlas
     * @throws NullPointerException if the specified atlas is null, or if
     *         this atlas does not permit null keys or values, and the
     *         specified atlas contains null keys or values
     * @throws IllegalArgumentException if some property of a key or value in
     *         the specified atlas prevents it from being stored in this atlas
     */
    void putAll(Atlas<? extends K, ? extends V, ? extends T> m);

    /**
     * Returns a {@link Congregation} view of the mappings contained in this atlas.
     * The set is backed by the atlas, so changes to the atlas are
     * reflected in the set, and vice-versa.  If the atlas is modified
     * while an iteration over the set is in progress (except through
     * the iterator's own <tt>remove</tt> operation, or through the
     * <tt>setValue</tt> operation on a atlas pair returned by the
     * iterator) the results of the iteration are undefined.  The set
     * supports element removal, which removes the corresponding
     * mapping from the atlas, via the <tt>Iterator.remove</tt>,
     * <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and
     * <tt>clear</tt> operations.  It does not support the
     * <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a congregation view of the mappings contained in this atlas
     */
    Congregation<T> entrySet();

    // modification and query methods
    /**
     * Returns the value to which the specified key is mapped, or
     * {@code defaultValue} if this atlas contains no mapping for the key.
     *
     * @implSpec
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key the key whose associated value is to be returned
     * @param defaultValue the default mapping of the key
     * @return the value to which the specified key is mapped, or
     * {@code defaultValue} if this atlas contains no mapping for the key
     * @throws ClassCastException if the key is of an inappropriate type for
     * this atlas
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this atlas
     * does not permit null keys
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V getOrDefault(K key, V defaultValue);

    /**
     * Performs the given action for each pair in this atlas until all pairs
     * have been processed or the action throws an exception.   Unless
     * otherwise specified by the implementing class, actions are performed in
     * the order of pair set iteration (if an iteration order is specified.)
     * Exceptions thrown by the action are relayed to the caller.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code atlas}:
     * <pre> {@code
     * for (Map.Entry<K, V> pair : atlas.entrySet())
     *     action.accept(pair.getKey(), pair.getValue());
     * }</pre>
     *
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param action The action to be performed for each pair
     * @throws NullPointerException if the specified action is null
     * @throws ConcurrentModificationException if an pair is found to be
     * removed during iteration
     * @since 1.8
     */
    void forEach(BiConsumer<? super K, ? super V> action);

    /**
     * Replaces each pair's value with the result of invoking the given
     * function on that pair until all pairs have been processed or the
     * function throws an exception.  Exceptions thrown by the function are
     * relayed to the caller.
     *
     * @implSpec
     * <p>The default implementation is equivalent to, for this {@code atlas}:
     * <pre> {@code
     * for (Map.Entry<K, V> pair : atlas.entrySet())
     *     pair.setValue(function.apply(pair.getKey(), pair.getValue()));
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param function the function to apply to each pair
     * @throws UnsupportedOperationException if the {@code set} operation
     * is not supported by this atlas's pair set iterator.
     * @throws ClassCastException if the class of a replacement value
     * prevents it from being stored in this atlas
     * @throws NullPointerException if the specified function is null, or the
     * specified replacement value is null, and this atlas does not permit null
     * values
     * @throws ClassCastException if a replacement value is of an inappropriate
     *         type for this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if function or a replacement value is null,
     *         and this atlas does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a replacement value
     *         prevents it from being stored in this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ConcurrentModificationException if an pair is found to be
     * removed during iteration
     * @since 1.8
     */
    void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);

    /**
     * If the specified key is not already associated with a value (or is mapped
     * to {@code null}) associates it with the given value and returns
     * {@code null}, else returns the current value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code
     * atlas}:
     *
     * <pre> {@code
     * V v = atlas.get(key);
     * if (v == null)
     *     v = atlas.put(key, value);
     *
     * return v;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no mapping for the key.
     *         (A {@code null} return can also indicate that the atlas
     *         previously associated {@code null} with the key,
     *         if the implementation supports null values.)
     * @throws Abort when something is wrong
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the key or value is of an inappropriate
     *         type for this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key or value is null,
     *         and this atlas does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V putIfAbsent(K key, V value);

    /**
     * Removes the pair for the specified key only if it is currently
     * mapped to the specified value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code atlas}:
     *
     * <pre> {@code
     * if (atlas.containsKey(key) && Objects.equals(atlas.get(key), value)) {
     *     atlas.remove(key);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key key with which the specified value is associated
     * @param value value expected to be associated with the specified key
     * @return {@code true} if the value was removed
     * @throws UnsupportedOperationException if the {@code remove} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the key or value is of an inappropriate
     *         type for this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key or value is null,
     *         and this atlas does not permit null keys or values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    boolean remove(K key, V value);

    /**
     * Replaces the pair for the specified key only if currently
     * mapped to the specified value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code atlas}:
     *
     * <pre> {@code
     * if (atlas.containsKey(key) && Objects.equals(atlas.get(key), value)) {
     *     atlas.put(key, newValue);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * The default implementation does not throw NullPointerException
     * for maps that do not support null values if oldValue is null unless
     * newValue is also null.
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param key key with which the specified value is associated
     * @param oldValue value expected to be associated with the specified key
     * @param newValue value to be associated with the specified key
     * @return {@code true} if the value was replaced
     * @throws Abort when something is wrong
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of a specified key or value
     *         prevents it from being stored in this atlas
     * @throws NullPointerException if a specified key or newValue is null,
     *         and this atlas does not permit null keys or values
     * @throws NullPointerException if oldValue is null and this atlas does not
     *         permit null values
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a specified key
     *         or value prevents it from being stored in this atlas
     * @since 1.8
     */
    boolean replace(K key, V oldValue, V newValue);

    /**
     * Replaces the value for the specified key only if it is
     * currently mapped to some value.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code atlas}:
     *
     * <pre> {@code
     * if (atlas.containsKey(key)) {
     *     return atlas.put(key, value);
     * } else
     *     return null;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
      *
     * @param key key with which the specified value is associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no mapping for the key.
     *         (A {@code null} return can also indicate that the atlas
     *         previously associated {@code null} with the key,
     *         if the implementation supports null values.)
     * @throws Abort when something is wrong
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key or value is null,
     *         and this atlas does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this atlas
     * @since 1.8
     */
    V replace(K key, V value);

    /**
     * If the specified key is not already associated with a value (or is mapped
     * to {@code null}), attempts to compute its value using the given mapping
     * function and enters it into this atlas unless {@code null}.
     *
     * <p>If the function returns {@code null} no mapping is recorded. If
     * the function itself throws an (unchecked) exception, the
     * exception is rethrown, and no mapping is recorded.  The most
     * common usage is to construct a new object serving as an initial
     * mapped value or memoized result, as in:
     *
     * <pre> {@code
     * atlas.computeIfAbsent(key, k -> new Value(f(k)));
     * }</pre>
     *
     * <p>Or to implement a multi-value atlas, {@code Map<K,Collection<V>>},
     * supporting multiple values per key:
     *
     * <pre> {@code
     * atlas.computeIfAbsent(key, k -> new HashSet<V>()).add(v);
     * }</pre>
     *
     *
     * @implSpec
     * The default implementation is equivalent to the following steps for this
     * {@code atlas}, then returning the current value or {@code null} if now
     * absent:
     *
     * <pre> {@code
     * if (atlas.get(key) == null) {
     *     V newValue = mappingFunction.apply(key);
     *     if (newValue != null)
     *         atlas.put(key, newValue);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.ConcurrentMap} must document
     * whether the function is applied once atomically only if the value is not
     * present.
     *
     * @param key key with which the specified value is to be associated
     * @param mappingFunction the function to compute a value
     * @return the current (existing or computed) value associated with
     *         the specified key, or null if the computed value is null
     * @throws NullPointerException if the specified key is null and
     *         this atlas does not support null keys, or the mappingFunction
     *         is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V computeIfAbsent(K key,
            Function<? super K, ? extends V> mappingFunction) ;

    /**
     * If the value for the specified key is present and non-null, attempts to
     * compute a new mapping given the key and its current mapped value.
     *
     * <p>If the function returns {@code null}, the mapping is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current mapping is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code atlas}, then returning the current value or
     * {@code null} if now absent:
     *
     * <pre> {@code
     * if (atlas.get(key) != null) {
     *     V oldValue = atlas.get(key);
     *     V newValue = remappingFunction.apply(key, oldValue);
     *     if (newValue != null)
     *         atlas.put(key, newValue);
     *     else
     *         atlas.remove(key);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.ConcurrentMap} must document
     * whether the function is applied once atomically only if the value is not
     * present.
     *
     * @param key key with which the specified value is to be associated
     * @param remappingFunction the function to compute a value
     * @return the new value associated with the specified key, or null if none
     * @throws NullPointerException if the specified key is null and
     *         this atlas does not support null keys, or the
     *         remappingFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V computeIfPresent(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction) ;

    /**
     * Attempts to compute a mapping for the specified key and its current
     * mapped value (or {@code null} if there is no current mapping). For
     * example, to either create or append a {@code String} msg to a value
     * mapping:
     *
     * <pre> {@code
     * atlas.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))}</pre>
     * (Method {@link #merge merge()} is often simpler to use for such purposes.)
     *
     * <p>If the function returns {@code null}, the mapping is removed (or
     * remains absent if initially absent).  If the function itself throws an
     * (unchecked) exception, the exception is rethrown, and the current mapping
     * is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code atlas}, then returning the current value or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldValue = atlas.get(key);
     * V newValue = reatlaspingFunction.apply(key, oldValue);
     * if (oldValue != null ) {
     *    if (newValue != null)
     *       atlas.put(key, newValue);
     *    else
     *       atlas.remove(key);
     * } else {
     *    if (newValue != null)
     *       atlas.put(key, newValue);
     *    else
     *       return null;
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.ConcurrentMap} must document
     * whether the function is applied once atomically only if the value is not
     * present.
     *
     * @param key key with which the specified value is to be associated
     * @param reatlaspingFunction the function to compute a value
     * @return the new value associated with the specified key, or null if none
     * @throws NullPointerException if the specified key is null and
     *         this atlas does not support null keys, or the
     *         reatlaspingFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    V compute(K key,
            BiFunction<? super K,? super V,? extends V> remappingFunction);

    /**
     * If the specified key is not already associated with a value or is
     * associated with null, associates it with the given non-null value.
     * Otherwise, replaces the associated value with the results of the given
     * remapping function, or removes if the result is {@code null}. This
     * method may be of use when combining multiple mapped values for a key.
     * For example, to either create or append a {@code String msg} to a
     * value mapping:
     *
     * <pre> {@code
     * atlas.merge(key, msg, String::concat)
     * }</pre>
     *
     * <p>If the function returns {@code null} the mapping is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current mapping is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code atlas}, then returning the current value or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldValue = atlas.get(key);
     * V newValue = (oldValue == null) ? value :
     *              remappingFunction.apply(oldValue, value);
     * if (newValue == null)
     *     atlas.remove(key);
     * else
     *     atlas.put(key, newValue);
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.ConcurrentMap} must document
     * whether the function is applied once atomically only if the value is not
     * present.
     *
     * @param key key with which the resulting value is to be associated
     * @param value the non-null value to be merged with the existing value
     *        associated with the key or, if no existing value or a null value
     *        is associated with the key, to be associated with the key
     * @param remappingFunction the function to recompute a value if present
     * @return the new value associated with the specified key, or null if no
     *         value is associated with the key
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this atlas
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key is null and this atlas
     *         does not support null keys or the value or remappingFunction is
     *         null
     * @since 1.8
     */
    V merge(K key, V value,
            BiFunction<? super V, ? super V, ? extends V> remappingFunction);
}
