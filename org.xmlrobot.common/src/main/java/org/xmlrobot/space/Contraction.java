/**
 * 
 */
package org.xmlrobot.space;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Mass;
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
     * {@link Contraction} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
    protected Contraction(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
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
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Mass<K,V> parent) {
		super(type, stem, parent);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Parity gen) {
		super(type, stem, gen);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parity {@link Parity} the gender
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the inherited type
	 * @param stem {@link Mass} the stem
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * {@link Contraction} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Contraction(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, Mass<K,V> parent) {
		super(type, antitype, parent);
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
	 * @see org.xmlrobot.genesis.TimeListener#putPositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V putValue(K key, V value) {

		Mass<K,V> child;
		
		if(key.equals(getKey())) {
			// update value and return old value
			return message.getAndSet(Mass.VALUE, value);
		}
		else if((child = getChild()) != null) {
			// call recursion
			return child.putValue(key, value);
		}
		else {
			// key is not in the chain
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putPositive(java.lang.Object, java.lang.Object)
	 */
	@Override
	public K putKey(V value, K key) {

		return get().putValue(value, key);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	public V putValueIfAbsent(K key, V value) {
		
        V v = getValue(key);
        
        if (v == null) {
            v = putValue(key, value);
        }

        return v;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putIfAbsent(java.lang.Object, java.lang.Object)
	 */
	public K putKeyIfAbsent(V value, K key) {
		
		return get().putValueIfAbsent(value, key);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putAll(org.xmlrobot.genesis.TimeListener)
	 */
	public void putAllValues(Mass<? extends K,? extends V> m) {
        for (Mass<? extends K,? extends V> e : m)
            putValue(e.getKey(), e.getValue());
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#putAllPositive(org.xmlrobot.genesis.TimeListener)
	 */
	public void putAllKeys(Mass<? extends V,? extends K> m) {
		
		get().putAllValues(m);
	}
}
