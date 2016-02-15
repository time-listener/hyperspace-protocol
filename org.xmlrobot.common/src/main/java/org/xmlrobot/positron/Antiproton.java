/**
 * 
 */
package org.xmlrobot.positron;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.TimeListener;
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
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	public K getKey() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getKey() : null ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	public V getValue() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getValue() : null ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {
		Mass<K,V> child;
		if ((child = getChild()) != null ) 
			return child.setKey(key);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		Mass<K,V> child;
		if ((child = getChild()) != null ) 
			return child.setValue(value);
		else return null;
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
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<V,K> o) {

		return matrix.reproduce(o.get().getChild(), get().getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#compareTo(org.xmlrobot.positron.Electron)
	 */
	@Override
	public int compareTo(Mass<V,K> o) {
	
		return get().compare(get().getChild(), o.getChild());
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
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	@Override
	public V get(K key) {
		// declare child
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getValue(key) : null;
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
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getChild() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#getOrDefault(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V getOrDefault(K key, V defaultValue) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#forEach(java.util.function.BiConsumer)
	 */
	@Override
	public void forEach(BiConsumer<? super K, ? super V> action) {
		Mass<K,V> child;
		if((child = getChild()) != null) 
			child.forEachKey(action);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putIfAbsent(K key, V value) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#remove(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean remove(K key, V value) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.removeByKey(key, value) : false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean replace(K key, V oldValue, V newValue) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replace(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V replace(K key, V value) {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#replaceAll(java.util.function.BiFunction)
	 */
	@Override
	public void replaceAll(
			BiFunction<? super K, ? super V, ? extends V> function) {
		Mass<K,V> child;	
		if((child = getChild()) != null)
			child.replaceAllValues(function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {		
 		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (matrix = new Quantum());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getName() : new String();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// they belong to the hyperspace with me
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Plasma#replicator()
	 */
	@Override
	public Mass<K,V> getReplicator() {
		// this is the plasma
		return this;
	}
}