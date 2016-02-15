/**
 * 
 */
package org.xmlrobot.horizon;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Mass;

/**
 * @author joan
 *
 */
public abstract class Graviton<K,V>
	extends Takion<Mass<K,V>,Mass<V,K>> 
		implements Mass<K,V> {

	/**
	 * -8308143676394793152L
	 */
	private static final long serialVersionUID = -8308143676394793152L;

	/**
	 * @param source
	 * @param command
	 */
	public Graviton(Mass<K,V> source) {
		
		super(source);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#brain()
	 */
	@Override
	public Mass<K, V> getReplicator() {
	
		return getSource().getReplicator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.EventHorizon#clone()
	 */
	@Override
	public Mass<K,V> clone() {
		
		return (Mass<K, V>) super.clone();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Darkmass#getSource()
	 */
	@Override
	public synchronized Mass<K,V> getSource() {

		return (Mass<K,V>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getPositive()
	 */
	@Override
	public K getKey() {
		
		return getSource().getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setPositive(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {

		return getSource().setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getNegative()
	 */
	@Override
	public V getValue() {

		return getSource().getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setNegative(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {

		return getSource().setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#collectPositive(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<K> collectKeys(Congregation<K> output) {

		return getSource().collectKeys(output);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#collectNegative(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<V> collectValues(Congregation<V> output) {

		return getSource().collectValues(output);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callPositive(java.lang.Object)
	 */
	@Override
	public Mass<K,V> call(K key) {

		return getSource().call(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callNegative(java.lang.Object)
	 */
	@Override
	public Mass<V,K> callReversed(V value) {

		return getSource().callReversed(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#containsPositive(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {
		
		return getSource().containsKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#containsNegative(java.lang.Object)
	 */
	@Override
	public boolean containsValue(V value) {

		return getSource().containsValue(value);
	}


	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putNegative(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValue(K key, V value) {

		return getSource().putValue(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putPositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKey(V value, K key) {
		
		return getSource().putKey(value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putAllNegative(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void putAllValues(Mass<? extends K, ? extends V> m) {
		
		getSource().putAllValues(m);		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putAllPositive(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void putAllKeys(Mass<? extends V, ? extends K> m) {
		
		getSource().putAllKeys(m);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putNegativeIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValueIfAbsent(K positive, V negative) {
	
		return getSource().putValueIfAbsent(positive, negative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putPositiveIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKeyIfAbsent(V negative, K positive) {
		
		return getSource().putKeyIfAbsent(negative, positive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removeNegative(java.lang.Object)
	 */
	@Override
	public Mass<K,V> removeByKey(K positive) {

		return getSource().removeByKey(positive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removePositive(java.lang.Object)
	 */
	@Override
	public Mass<V,K> removeByValue(V negative) {

		return getSource().removeByValue(negative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getNegative(java.lang.Object)
	 */
	@Override
	public V getValue(K positive) {

		return getSource().getValue(positive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getPositive(java.lang.Object)
	 */
	@Override
	public K getKey(V negative) {
	
		return getSource().getKey(negative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getNegativeOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V getValueOrDefault(K positive, V defaultNegative) {
		
		return getSource().getValueOrDefault(positive, defaultNegative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getPositiveOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K getKeyOrDefault(V negative, K defaultPositive) {

		return getSource().getKeyOrDefault(negative, defaultPositive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#forEachPositive(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachKey(BiConsumer<? super K, ? super V> action) {
		
		getSource().forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#forEachNegative(java.util.function.BiConsumer)
	 */
	@Override
	public void forEachValue(BiConsumer<? super V, ? super K> action) {
		
		getSource().forEachValue(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceAllNegative(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllValues(BiFunction<? super K, ? super V, ? extends V> function) {
		
		getSource().replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceAllPositive(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAllKeys(BiFunction<? super V, ? super K, ? extends K> function) {
		
		getSource().replaceAllKeys(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removeNegative(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByKey(K positive, V negative) {

		return getSource().removeByKey(positive, negative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#removePositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean removeByValue(V negative, K positive) {
		
		return getSource().removeByValue(negative, positive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceNegative(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceValue(K positive, V oldNegative, V newNegative) {
		
		return getSource().replaceValue(positive, oldNegative, newNegative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replacePositive(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replaceKey(V negative, K oldPositive, K newPositive) {
		
		return getSource().replaceKey(negative, oldPositive, newPositive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replaceNegative(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V replaceValue(K positive, V negative) {
		
		return getSource().replaceValue(positive, negative);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#replacePositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K replaceKey(V negative, K positive) {
		
		return getSource().replaceKey(negative, positive);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeIfAbsentByKey(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public V computeIfAbsent(K key,
			Function<? super K, ? extends V> mappingFunction) {

		return getSource().computeIfAbsent(key, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeInvertedIfAbsent(java.lang.Object, java.util.function.Function)
	 */
	@Override
	public K computeInvertedIfAbsent(V value,
			Function<? super V, ? extends K> mappingFunction) {
		return getSource().computeInvertedIfAbsent(value, mappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V computeIfPresent(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		
		return getSource().computeIfPresent(key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeInvertedIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K computeInvertedIfPresent(V value,
			BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		
		return getSource().computeInvertedIfPresent(value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#compute(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V compute(K key,
			BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		
		return getSource().compute(key, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeInverted(java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K computeInverted(V value,
			BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
		
		return getSource().computeInverted(value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public V merge(K key, V value,
			BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
		
		return getSource().merge(key, value, remappingFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#mergeInverted(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
	 */
	@Override
	public K mergeInverted(V value, K key,
			BiFunction<? super K, ? super K, ? extends K> remappingFunction) {
	
		return getSource().mergeInverted(value, key, remappingFunction);
	}
}
