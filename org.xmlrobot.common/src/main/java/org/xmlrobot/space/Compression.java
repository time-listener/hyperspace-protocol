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
 * @since 24
 */
@XmlTransient
public abstract class Compression<K,V>
		extends Attraction<K,V> {
	
	/**
	 * 6778033923929257030L
	 */
	private static final long serialVersionUID = 6778033923929257030L;
	
	/**
	 * {@link Compression} default class constructor.
	 */
	public Compression() {
	
		super();
	}
	/**
     * {@link Compression} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
    protected Compression(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
	}
	/**
	 * Compression default class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Compression(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Mass<K,V> parent) {
		super(type, stem, parent);
	}
	/**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Parity gen) {
		super(type, stem, gen);
	}
	/**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parity {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * {@link Compression} class constructor.
	 * @param type the inherited type
	 * @param stem {@link Mass} the stem
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * {@link Compression} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	/**
	 * Compression class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Compression(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		super(type, antitype, key, value, gen);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Compression<K,V> clone() {
		
		return (Compression<K,V>) super.clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callPositive(java.lang.Object)
	 */
	@Override
	public Mass<K,V> call(K key) {

		Mass<K,V> child = getChild();
		
		if(key.equals(getKey())) {
			
			return call(); // a.k.a. this
		}
		else if(child != null) {
			
			return child.call(key);
		}
		else {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#callNegative(java.lang.Object)
	 */
	@Override
	public Mass<V,K> callReversed(V value) {
		
		return get().call(value);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getNegative(java.lang.Object)
     */
    public V getValue(K key) {
        
    	Mass<K,V> child = getChild();
        
        if(key.equals(getKey())) {
        	
        	return getValue();
        }
        else if(child != null) {
        	
        	return child.getValue(key);
        }
        else {
        	return null;
        }
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getPositive(java.lang.Object)
     */
    public K getKey(V value) {
        
        return get().getValue(value);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getOrDefault(java.lang.Object, java.lang.Object)
     */
    public V getValueOrDefault(K key, V defaultValue) {
        V v;
        return (((v = getValue(key)) != null) || containsKey(key))
            ? v
            : defaultValue;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#getOrDefault(java.lang.Object, java.lang.Object)
     */
    public K getKeyOrDefault(V value, K defaultKey) {
        
    	return get().getValueOrDefault(value, defaultKey);
    }
}
