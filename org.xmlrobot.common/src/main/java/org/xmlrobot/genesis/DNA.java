/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.xmlrobot.util.Abort;

/**
 * An {@link org.xmlrobot.genesis.Atlas} providing thread safety and atomicity
 * guarantees.
 * 
 * <p>The DNA is the {@link Chain}. And the {@link Chain} is the DNA.
 * So, changes in the {@link Chain} will be reflected in the DNA. And vice-versa.
 *
 * <p>Memory consistency effects: As with other recursive congregations, actions 
 * in a thread prior to placing an object into a {@code DNA} as a key or value 
 * <i>happen-before</i> actions subsequent to the access or removal of that object
 * from the {@code DNA} in another thread.
 * 
 * <p>From key to value. From value to key. The key is the value. And the value is
 * the key. So, changes to the key will be reflected in the value. And vice-versa. 
 * 
 * <p>This interface is a member of the {@code hyperspace congregation framework}.
 *
 * @param <K> is the key
 * @param <V> is the value
 * @param <T> is the inherited type
 * @param <U> is the unification type
 *
 * @author  joan
 * 
 * @see Screw
 * @see Chain
 * @see Mass
 * 
 * @since before BigBang
 */
public interface DNA<K,V> 
	extends Mass<K,V>, 
		Atlas<K,V,Mass<K,V>> {
	
    /**
     * {@inheritDoc}
     *
     * @implNote This implementation assumes that the DNA cannot
     * contain null values and {@code get()} returning null unambiguously means
     * the key is absent. Implementations which support null values
     * <strong>must</strong> override this default implementation.
     *
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.8
     */
    @Override
    V getOrDefault(K key, V defaultValue);
    
   /**
     * {@inheritDoc}
     *
     * @implSpec The default implementation is equivalent to, for this
     * {@code DNA}:
     * <pre> {@code
     * for ((Mass<K, V> pair : DNA.entrySet())
     *     action.accept(pair.getKey(), pair.getValue());
     * }</pre>
     *
     * @implNote The default implementation assumes that
     * {@code IllegalStateException} thrown by {@code getKey()} or
     * {@code getValue()} indicates that the pair has been removed and cannot
     * be processed. Operation continues for subsequent pairs.
     *
     * @throws NullPointerException {@inheritDoc}
     * @since 1.8
     */
    @Override
    void forEach(BiConsumer<? super K, ? super V> action);

    /**
     * If the specified key is not already associated
     * with a value, associate it with the given value.
     * This is equivalent to
     *  <pre> {@code
     * if (!DNA.containsKey(key))
     *   return DNA.put(key, value);
     * else
     *   return DNA.get(key);
     * }</pre>
     *
     * except that the action is performed atomically.
     *
     * @implNote This implementation intentionally re-abstracts the
     * inappropriate default provided in {@code Map}.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no DNAping for the key.
     *         (A {@code null} return can also indicate that the DNA
     *         previously associated {@code null} with the key,
     *         if the implementation supports null values.)
     * @throws Abort when something is wrong
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this DNA
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this DNA
     * @throws NullPointerException if the specified key or value is null,
     *         and this DNA does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this DNA
     */
     V putIfAbsent(K key, V value);

    /**
     * Removes the pair for a key only if currently DNAped to a given value.
     * This is equivalent to
     *  <pre> {@code
     * if (DNA.containsKey(key) && Objects.equals(DNA.get(key), value)) {
     *   DNA.remove(key);
     *   return true;
     * } else
     *   return false;
     * }</pre>
     *
     * except that the action is performed atomically.
     *
     * @implNote This implementation intentionally re-abstracts the
     * inappropriate default provided in {@code Map}.
     *
     * @param key key with which the specified value is associated
     * @param value value expected to be associated with the specified key
     * @return {@code true} if the value was removed
     * @throws UnsupportedOperationException if the {@code remove} operation
     *         is not supported by this DNA
     * @throws ClassCastException if the key or value is of an inappropriate
     *         type for this DNA
     *         (<a href="../Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified key or value is null,
     *         and this DNA does not permit null keys or values
     *         (<a href="../Collection.html#optional-restrictions">optional</a>)
     */
     boolean remove(K key, V value);

    /**
     * Replaces the pair for a key only if currently DNAped to a given value.
     * This is equivalent to
     *  <pre> {@code
     * if (DNA.containsKey(key) && Objects.equals(DNA.get(key), oldValue)) {
     *   DNA.put(key, newValue);
     *   return true;
     * } else
     *   return false;
     * }</pre>
     *
     * except that the action is performed atomically.
     *
     * @implNote This implementation intentionally re-abstracts the
     * inappropriate default provided in {@code Map}.
     *
     * @param key key with which the specified value is associated
     * @param oldValue value expected to be associated with the specified key
     * @param newValue value to be associated with the specified key
     * @return {@code true} if the value was replaced
     * @throws Abort when something is wrong
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this DNA
     * @throws ClassCastException if the class of a specified key or value
     *         prevents it from being stored in this DNA
     * @throws NullPointerException if a specified key or value is null,
     *         and this DNA does not permit null keys or values
     * @throws IllegalArgumentException if some property of a specified key
     *         or value prevents it from being stored in this DNA
     */
    boolean replace(K key, V oldValue, V newValue);

    /**
     * Replaces the pair for a key only if currently DNAped to some value.
     * This is equivalent to
     *  <pre> {@code
     * if (DNA.containsKey(key)) {
     *   return DNA.put(key, value);
     * } else
     *   return null;
     * }</pre>
     *
     * except that the action is performed atomically.
     *
     * @implNote This implementation intentionally re-abstracts the
     * inappropriate default provided in {@code Map}.
     *
     * @param key key with which the specified value is associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the specified key, or
     *         {@code null} if there was no DNAping for the key.
     *         (A {@code null} return can also indicate that the DNA
     *         previously associated {@code null} with the key,
     *         if the implementation supports null values.)
     * @throws Abort 
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this DNA
     * @throws ClassCastException if the class of the specified key or value
     *         prevents it from being stored in this DNA
     * @throws NullPointerException if the specified key or value is null,
     *         and this DNA does not permit null keys or values
     * @throws IllegalArgumentException if some property of the specified key
     *         or value prevents it from being stored in this DNA
     */
    V replace(K key, V value);

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * <p>The default implementation is equivalent to, for this {@code DNA}:
     * <pre> {@code
     * for ((Map.Entry<K, V> pair : DNA.entrySet())
     *     do {
     *        K k = pair.getKey();
     *        V v = pair.getValue();
     *     } while(!replace(k, v, function.apply(k, v)));
     * }</pre>
     *
     * The default implementation may retry these steps when multiple
     * threads attempt updates including potentially calling the function
     * repeatedly for a given key.
     *
     * <p>This implementation assumes that the DNA cannot contain null
     * values and {@code get()} returning null unambiguously means the key is
     * absent. Implementations which support null values <strong>must</strong>
     * override this default implementation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     * @since 1.8
     */
    @Override
    void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * The default implementation is equivalent to the following steps for this
     * {@code DNA}, then returning the current value or {@code null} if now
     * absent:
     *
     * <pre> {@code
     * if (DNA.get(key) == null) {
     *     V newValue = mappingFunction.apply(key);
     *     if (newValue != null)
     *         return DNA.putIfAbsent(key, newValue);
     * }
     * }</pre>
     *
     * The default implementation may retry these steps when multiple
     * threads attempt updates including potentially calling the mapping
     * function multiple times.
     *
     * <p>This implementation assumes that the DNA cannot contain null
     * values and {@code get()} returning null unambiguously means the key is
     * absent. Implementations which support null values <strong>must</strong>
     * override this default implementation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.8
     */
    @Override
    V computeIfAbsent(K key,
            Function<? super K, ? extends V> mappingFunction);

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code DNA}, then returning the current value or
     * {@code null} if now absent. :
     *
     * <pre> {@code
     * if (DNA.get(key) != null) {
     *     V oldValue = DNA.get(key);
     *     V newValue = remappingFunction.apply(key, oldValue);
     *     if (newValue != null)
     *         DNA.replace(key, oldValue, newValue);
     *     else
     *         DNA.remove(key, oldValue);
     * }
     * }</pre>
     *
     * The default implementation may retry these steps when multiple threads
     * attempt updates including potentially calling the remapping function
     * multiple times.
     *
     * <p>This implementation assumes that the DNA cannot contain null
     * values and {@code get()} returning null unambiguously means the key is
     * absent. Implementations which support null values <strong>must</strong>
     * override this default implementation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.8
     */
    @Override
    V computeIfPresent(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction) ;

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code DNA}, then returning the current value or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldValue = DNA.get(key);
     * V newValue = remappingFunction.apply(key, oldValue);
     * if (oldValue != null ) {
     *    if (newValue != null)
     *       DNA.replace(key, oldValue, newValue);
     *    else
     *       DNA.remove(key, oldValue);
     * } else {
     *    if (newValue != null)
     *       DNA.putIfAbsent(key, newValue);
     *    else
     *       return null;
     * }
     * }</pre>
     *
     * The default implementation may retry these steps when multiple
     * threads attempt updates including potentially calling the remapping
     * function multiple times.
     *
     * <p>This implementation assumes that the DNA cannot contain null
     * values and {@code get()} returning null unambiguously means the key is
     * absent. Implementations which support null values <strong>must</strong>
     * override this default implementation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.8
     */
    @Override
    V compute(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction);

    /**
     * {@inheritDoc}
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code DNA}, then returning the current value or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldValue = DNA.get(key);
     * V newValue = (oldValue == null) ? value :
     *              remappingFunction.apply(oldValue, value);
     * if (newValue == null)
     *     DNA.remove(key);
     * else
     *     DNA.put(key, newValue);
     * }</pre>
     *
     * <p>The default implementation may retry these steps when multiple
     * threads attempt updates including potentially calling the remapping
     * function multiple times.
     *
     * <p>This implementation assumes that the DNA cannot contain null
     * values and {@code get()} returning null unambiguously means the key is
     * absent. Implementations which support null values <strong>must</strong>
     * override this default implementation.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     * @since 1.8
     */
    @Override
    V merge(K key, V value,
            BiFunction<? super V, ? super V, ? extends V> remappingFunction);
}