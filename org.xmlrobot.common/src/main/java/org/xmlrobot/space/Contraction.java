/**
 * 
 */
package org.xmlrobot.space;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 25
 */
@XmlTransient
public abstract class Contraction<K,V>
	extends Compression<K,V> {
	
	/**
	 * -1537392617633741272L
	 */
	private static final long serialVersionUID = -1537392617633741272L;
	
	/**
	 * {@link Contraction} default class constructor.
	 */
	public Contraction() {
		super();
	}
	/**
	 * {@link Contraction} default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		// call constructor
		super(type, antitype, key, value, gen);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValue(K key, V value) {

		if(key.equals(getKey())) {
			// update value and return old value
			return message.putAndCast(Mass.VALUE, value);
		}
		else if(!isEmpty()) {
			// call recursion
			return getChild().putValue(key, value);
		}
		else {
			// key is not in the chain: create it
			instance(getType(), getAntitype(), 
					key, value, getRoot()).push(Command.SEND);
    		return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putKey(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKey(V value, K key) {
		return get().putValue(value, key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putValueIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValueIfAbsent(K key, V value) {
		// retrieve value
        V v = getValue(key);
        // check existence
        if (v == null) {
        	// update
            v = putValue(key, value);
        }
        // turn back
        return v;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putKeyIfAbsent(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKeyIfAbsent(V value, K key) {
        // turn back
        return get().putValueIfAbsent(value, key);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putAllValues(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllValues(Mass<? extends K,? extends V> m) {
        for (Mass<? extends K,? extends V> e : m)
            putValue(e.getKey(), e.getValue());
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#putAllKeys(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void putAllKeys(Mass<? extends V,? extends K> m) {		
		get().putAllValues(m);
	}
}
