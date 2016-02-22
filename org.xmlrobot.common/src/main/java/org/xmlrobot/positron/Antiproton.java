/**
 * 
 */
package org.xmlrobot.positron;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.Mass;

/**
 * Positronic brain implementation class.
 * 
 * @author joan
 *
 */
@XmlTransient
public abstract class Antiproton<K,V>
	extends Positron<K,V>
		implements Entity<K,V> {
	
	/**
	 * -5258262313814614511L
	 */
	private static final long serialVersionUID = -5258262313814614511L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		return !isEmpty() ? getChild().getName() : new String();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	public K getKey() {
		return !isEmpty() ? getChild().getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {
		return !isEmpty() ? getChild().setKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	public V getValue() {
		return !isEmpty() ? getChild().getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		return !isEmpty() ? getChild().setValue(value) : null;
	}
	
	/**
     * {@link Antiproton} default class constructor.
	 */
	public Antiproton() {
		super();
	}
	/**
     * {@link Antiproton} class constructor.
	 * @param type the type
	 */
	protected Antiproton(Class<? extends Mass<K,V>> type) {
		super(type);
	}
	/**
     * {@link Antiproton} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 */
	protected Antiproton(Class<? extends Mass<K,V>> type,
			Class<? extends Mass<V,K>> antitype) {
		super(type, antitype);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compare(org.xmlrobot.positron.Positron, org.xmlrobot.positron.Positron)
	 */
	@Override
	public int compare(Mass<K,V> o1, Mass<K,V> o2) {
		// typical recursive composition
		if (o1 != null) {

			if (o2 != null) {
				// get current identifier pairs difference
				int cmp = o1.compareTo(o2.get());
				// call recursion
				cmp += compare(o1.getChild(), o2.getChild());
				// return result
				return cmp;
			} else {
				return 1;
			}
		} else if (o2 != null) {

			return -1;
		} else {
			// starting-finishing
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compareTo(org.xmlrobot.positron.Electron)
	 */
	@Override
	public int compareTo(Mass<V,K> o) {
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<V,K> o) {
		return matrix().reproduce(o.get().getChild(), get().getChild());
	}



	// matrix implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.inheritance.Parent#matrix()
 	 */
 	@Override
 	public Mass.Transmuter<K,V> matrix() {
 		Mass.Transmuter<K,V> m;
 		return (m = (Mass.Transmuter<K,V>) matrix) != null ? 
 				m : (Mass.Transmuter<K,V>) (matrix = new Hadron());
 	}
	/**
	 * <b>root</b>'s mass transmitter.
	 * @author joan
	 */
	protected class Hadron
 		extends Translocator {
		
		/**
		 * {@link Hadron} default class constructor.
		 */
		public Hadron() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Antiproton<V,K> get() {
			return (Antiproton<V,K>) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.space.Hyperclock.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(K key, V value) {
			get().put(value, key);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public V get(K key) {
    	return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public abstract V put(K key, V value);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#putAll(org.xmlrobot.genesis.Atlas)
	 */
	@Override
	public void putAll(
			Atlas<? extends K, ? extends V, ? extends Mass<K,V>> m) {
		for(Mass<K,V> positron : m)
			put(positron.getKey(), positron.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#entrySet()
	 */
	@Override
	public Congregation<Mass<K,V>> entrySet() {
    	return getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V getOrDefault(K key, V defaultValue) {
    	return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super K, ? super V> action) {
    	if(!isEmpty())
    		getChild().forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putIfAbsent(K key, V value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(K key, V value) {
    	return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(K key, V oldValue, V newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V replace(K key, V value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
    	if(!isEmpty())
    		getChild().replaceAllValues(function);
	}
	// space implementation
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValue(K key, V value) {
		return !isEmpty() ? getChild().putValue(key, value) : put(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKey(V value, K key) {
		return !isEmpty() ? getChild().putKey(value, key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValueIfAbsent(K key, V value) {
		return !isEmpty() ? getChild().putValueIfAbsent(key, value) : put(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putKeyIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKeyIfAbsent(V value, K key) {
		return !isEmpty() ? getChild().putKeyIfAbsent(value, key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllValues(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllValues(Mass<? extends K, ? extends V> m) {
		if(!isEmpty())
			super.putAllValues(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Contraction#putAllKeys(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllKeys(Mass<? extends V, ? extends K> m) {
		if(!isEmpty())
			super.putAllKeys(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#call(java.lang.Object)
	 */
	@Override
	public Mass<K,V> call(K key) {
		return !isEmpty() ? getChild().call(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#callReversed(java.lang.Object)
	 */
	@Override
	public Mass<V, K> callReversed(V value) {
		return !isEmpty() ? getChild().callReversed(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValue(java.lang.Object)
	 */
	@Override
	public V getValue(K key) {
		return !isEmpty() ? getChild().getValue(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getKey(java.lang.Object)
	 */
	@Override
	public K getKey(V value) {
		return !isEmpty() ? getChild().getKey(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getValueOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V getValueOrDefault(K key, V defaultValue) {
		return !isEmpty() ? getChild().getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Compression#getKeyOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K getKeyOrDefault(V value, K defaultKey) {
		return !isEmpty() ? getChild().getKeyOrDefault(value, defaultKey) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {
		return !isEmpty() ? getChild().containsKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(V value) {
		return !isEmpty() ? getChild().containsValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<K> collectKeys(Congregation<K> keys) {
		return !isEmpty() ? getChild().collectKeys(keys) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#collectValues(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<V> collectValues(Congregation<V> values) {
		return !isEmpty() ? getChild().collectValues(values) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super K, ? super V> action) {
		if(!isEmpty())
			super.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Attraction#forEachValue(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachValue(BiConsumer<? super V, ? super K> action) {
		if(!isEmpty())
			super.forEachValue(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(K key, V oldValue, V newValue) {
		return !isEmpty() ? getChild().replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceKey(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceKey(V value, K oldKey, K newKey) {
		return !isEmpty() ? getChild().replaceKey(value, oldKey, newKey) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllValues(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(BiFunction<? super K, ? super V, ? extends V> function) {
		if(!isEmpty())
			super.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceAllKeys(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllKeys(BiFunction<? super V, ? super K, ? extends K> function) {
		if(!isEmpty())
			super.replaceAllKeys(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V replaceValue(K key, V value) {
		return !isEmpty() ? getChild().replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Repulsion#replaceKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K replaceKey(V value, K key) {
		return !isEmpty() ? getChild().replaceKey(value, key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public V computeIfAbsent(K key,
			Function<? super K, ? extends V> mappingFunction) {
		return !isEmpty() ? getChild().computeIfAbsent(key, mappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeInvertedIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public K computeInvertedIfAbsent(V key,
			Function<? super V, ? extends K> mappingFunction) {
		return !isEmpty() ? getChild().computeInvertedIfAbsent(key, mappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V compute(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return !isEmpty() ? getChild().compute(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeInverted(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K computeInverted(V value,
			BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return !isEmpty() ? getChild().computeInverted(value, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V computeIfPresent(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		return !isEmpty() ? getChild().computeIfPresent(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Expansion#computeInvertedIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K computeInvertedIfPresent(V key,
			BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		return !isEmpty() ? getChild().computeInvertedIfPresent(key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V merge(K key, V value,
			BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		return !isEmpty() ? getChild().merge(key, value, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#mergeInverted(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K mergeInverted(V value, K key,
			BiFunction<? super K, ? super K, ? extends K> remappingFunction) {
		return !isEmpty() ? getChild().mergeInverted(value, key, remappingFunction) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object)
	 */
	@Override
	public Mass<K,V> removeByKey(K key) {
		return !isEmpty() ? getChild().removeByKey(key) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByValue(java.lang.Object)
	 */
	@Override
	public Mass<V,K> removeByValue(V value) {
		return !isEmpty() ? getChild().removeByValue(value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(K key, V value) {
		return !isEmpty() ? getChild().removeByKey(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Dilatation#removeByValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByValue(V value, K key) {
		return !isEmpty() ? getChild().removeByValue(value, key) : null;
	}
}