/**
 * 
 */
package org.xmlrobot.genesis;

import java.io.Serializable;
import java.util.Objects;

/**
 * An atlas pair (key-value pair).  The <tt>Atlas.entrySet</tt> method returns
 * a congregation-view of the atlas, whose elements are of this class.  The
 * <i>only</i> way to obtain a reference to a atlas pair is from the
 * iterator of this congregation-view.  These <tt>Pair</tt> objects are
 * valid <i>only</i> for the duration of their life; more formally,
 * the behavior of an atlas pair is undefined if the backing atlas has been
 * modified after the pair was returned by the iterator, except through
 * the <tt>setValue</tt> operation on the atlas pair.
 * 
 *<p>This interface is a member of the {@code hyperspace congregation framework}.
 * 
 * @see Atlas#entrySet()
 * @since before Big Bang
 */
public interface Pair
	<K,V,T extends Pair<K,V,T>> 
		extends Congregation<T> {
    
	/**
     * Returns the key corresponding to this entry.
     *
     * @return the key corresponding to this entry
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the entry has been
     *         removed from the backing map.
     */
    K getKey();

    /**
     * Replaces the key corresponding to this entry with the specified
     * key (optional operation).  (Writes through to the map.)  The
     * behavior of this call is undefined if the mapping has already been
     * removed from the map (by the iterator's <tt>remove</tt> operation).
     *
     * @param key new key to be stored in this entry
     * @return old key corresponding to the entry
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing map
     * @throws ClassCastException if the class of the specified key
     *         prevents it from being stored in the backing map
     * @throws NullPointerException if the backing map does not permit
     *         null keys, and the specified key is null
     * @throws IllegalArgumentException if some property of this key
     *         prevents it from being stored in the backing map
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the entry has been
     *         removed from the backing map.
     */
    K setKey(K value);
    
    /**
     * Returns the value corresponding to this entry.  If the mapping
     * has been removed from the backing map (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     *
     * @return the value corresponding to this entry
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the entry has been
     *         removed from the backing map.
     */
    V getValue();

    /**
     * Replaces the value corresponding to this entry with the specified
     * value (optional operation).  (Writes through to the map.)  The
     * behavior of this call is undefined if the mapping has already been
     * removed from the map (by the iterator's <tt>remove</tt> operation).
     *
     * @param value new value to be stored in this entry
     * @return old value corresponding to the entry
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing map
     * @throws ClassCastException if the class of the specified value
     *         prevents it from being stored in the backing map
     * @throws NullPointerException if the backing map does not permit
     *         null values, and the specified value is null
     * @throws IllegalArgumentException if some property of this value
     *         prevents it from being stored in the backing map
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the entry has been
     *         removed from the backing map.
     */
    V setValue(V value);

    /**
     * Compares the specified object with this entry for equality.
     * Returns <tt>true</tt> if the given object is also a map entry and
     * the two entries represent the same mapping.  More formally, two
     * entries <tt>e1</tt> and <tt>e2</tt> represent the same mapping
     * if<pre>
     *     (e1.getKey()==null ?
     *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
     *     (e1.getValue()==null ?
     *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
     * </pre>
     * This ensures that the <tt>equals</tt> method works properly across
     * different implementations of the <tt>Map.Entry</tt> interface.
     *
     * @param o object to be compared for equality with this map entry
     * @return <tt>true</tt> if the specified object is equal to this map
     *         entry
     */
    boolean equals(Object o);

    /**
     * Returns the hash code value for this map entry.  The hash code
     * of a map entry <tt>e</tt> is defined to be: <pre>
     *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
     *     (e.getValue()==null ? 0 : e.getValue().hashCode())
     * </pre>
     * This ensures that <tt>e1.equals(e2)</tt> implies that
     * <tt>e1.hashCode()==e2.hashCode()</tt> for any two Entries
     * <tt>e1</tt> and <tt>e2</tt>, as required by the general
     * contract of <tt>Object.hashCode</tt>.
     *
     * @return the hash code value for this map entry
     * @see Object#hashCode()
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

    /**
     * Returns a comparator that compares {@link Atlas.Pair} in natural order on key.
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing an entry with a null key.
     * @param  <K> the {@link Comparable} type of then map keys
     * @param  <V> the type of the map values
     * @return a comparator that compares {@link Atlas.Pair} in natural order on key.
     * @see Comparable
     * @since 1.8
     */
    public static <K extends Comparable<? super K>,V,T extends Pair<K,V,T>> java.util.Comparator<Pair<K,V,T>> comparingByKey() {
        return (java.util.Comparator<Pair<K,V,T>> & Serializable)
            (c1, c2) -> c1.getKey().compareTo(c2.getKey());
    }

    /**
     * Returns a comparator that compares {@link Atlas.Pair} in natural order on value.
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing an entry with null values.
     * @param <K> the type of the map keys
     * @param <V> the {@link Comparable} type of the map values
     * @return a comparator that compares {@link Atlas.Pair} in natural order on value.
     * @see Comparable
     * @since 1.8
     */
    public static <K,V extends Comparable<? super V>,T extends Pair<K,V,T>> java.util.Comparator<Pair<K,V,T>> comparingByValue() {
        return (java.util.Comparator<Pair<K,V,T>> & Serializable)
            (c1, c2) -> c1.getValue().compareTo(c2.getValue());
    }

    /**
     * Returns a comparator that compares {@link Atlas.Pair} by key using the given
     * {@link Comparator}.
     * <p>The returned comparator is serializable if the specified comparator
     * is also serializable.
     * @param  <K> the type of the map keys
     * @param  <V> the type of the map values
     * @param  cmp the key {@link Comparator}
     * @return a comparator that compares {@link Atlas.Pair} by the key.
     * @since 1.8
     */
    public static <K,V,T extends Pair<K,V,T>> java.util.Comparator<Pair<K,V,T>> comparingByKey(java.util.Comparator<? super K> cmp) {
        Objects.requireNonNull(cmp);
        return (java.util.Comparator<Pair<K,V,T>> & Serializable)
            (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
    }

    /**
     * Returns a comparator that compares {@link Atlas.Pair} by value using the given
     * {@link Comparator}.
     * <p>The returned comparator is serializable if the specified comparator
     * is also serializable.
     * @param  <K> the type of the map keys
     * @param  <V> the type of the map values
     * @param  cmp the value {@link Comparator}
     * @return a comparator that compares {@link Atlas.Pair} by the value.
     * @since 1.8
     */
    public static <K,V,T extends Pair<K,V,T>> java.util.Comparator<Pair<K,V,T>> comparingByValue(java.util.Comparator<? super V> cmp) {
        Objects.requireNonNull(cmp);
        return (java.util.Comparator<Pair<K,V,T>> & Serializable)
            (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
    }
}
