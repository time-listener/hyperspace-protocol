/**
 * 
 */
package org.xmlrobot.space;

import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.function.BiConsumer;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
@XmlTransient
public abstract class Attraction<K,V>
	extends Hyperclock<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3640465384016023196L;

	/**
	 * {@link Attraction} default class constructor.
	 */
	public Attraction() {
	
		super();
	}
	/**
	 * Attraction default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * Attraction class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parity {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * Attraction class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * Attraction class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * Attraction class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen)	{
		super(type, antitype, key, value, gen);
	}
	/**
	 * Attraction class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(K key) {
		if(key.equals(getKey())) {
			return true;
		}
		else if(!isEmpty()) {
			return getChild().containsKey(key);
		}
		else {
			return false;
		}
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#containsValue(java.lang.Object)
	 */
	@Override
    public boolean containsValue(V value) {
    	return get().containsKey(value);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#collectKeys(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<K> collectKeys(Congregation<K> keys) {
		// add key to congregation
		keys.add(getKey());
		// check if we are the future
		if(!isEmpty()) {
			// follow collecting
			return getChild().collectKeys(keys);
		}
		else {
			// turn back result
			return keys;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#collectValues(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<V> collectValues(Congregation<V> values) {
		return get().collectKeys(values);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#forEachKey(java.util.function.BiConsumer)
	 */
	@Override
    public void forEachKey(BiConsumer<? super K,? super V> action) {
    	Objects.requireNonNull(action);
        for (Mass<K,V> child : this) {
            K k;
            V v;
            try {
                k = child.getKey();
                v = child.getValue();
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            action.accept(k, v);
        }
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#forEachValue(java.util.function.BiConsumer)
	 */
	@Override
    public void forEachValue(BiConsumer<? super V, ? super K> action) {
    	get().forEachKey(action);
    }
}
