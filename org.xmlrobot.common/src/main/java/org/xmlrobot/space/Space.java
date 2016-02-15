/**
 * 
 */
package org.xmlrobot.space;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.util.Parity;

/**
 * Space: the final frontier. These are the 
 * voyages of the starship Enterprise. Its five-year mission: to 
 * explore strange new worlds, to seek out new life and new 
 * civilizations, to boldly go where no man has gone before.
 * <br><br>
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 26
 */
@XmlTransient
public abstract class Space<K,V> 
	extends Contraction<K,V> {
	
	/**
	 * 3626502374824683675L
	 */
	private static final long serialVersionUID = 3626502374824683675L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getKey()
	 */
	@Override
	@XmlTransient
	public K getKey() {

		return mass.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setKey(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {
		
		K oldKey = mass.setKey(key);
		mass.update();
		return oldKey;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getValue()
	 */
	@Override
	@XmlTransient
	public V getValue() {
		
		return mass.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
	
		V oldValue = mass.setValue(value);
		mass.update();
		return oldValue;
	}
	
	/**
	 * {@link Space} default class constructor.
	 */
	public Space() {
		super();
	}
	/**
     * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
     * @param parent the parent of inheritance
	 */
	protected Space(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
	}
	/**
	 * {@link Space} default class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param gen {@link Parity} the gender
	 */
	protected Space(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Space(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Space(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Space(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Mass<K,V> parent) {
		super(type, stem, parent);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Space(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Parity gen) {
		super(type, stem, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parity {@link Parity} the gender
	 */
	protected Space(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param stem {@link Mass} the stem
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Space(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Space(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Space(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Space(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	/**
	 * {@link Space} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Space(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		// call constructor
		super(type, antitype, key, value, gen);
	}
}