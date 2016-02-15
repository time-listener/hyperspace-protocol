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
     * {@link Attraction} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
    protected Attraction(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
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
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Mass<K,V> parent) {
		super(type, stem, parent);
	}
	/**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Parity gen) {
		super(type, stem, gen);
	}
	/**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param parity {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * {@link Attraction} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * {@link Attraction} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Attraction(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
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
     * @see org.xmlrobot.genesis.TimeListener#containsPositive(java.lang.Object)
     */
	public boolean containsKey(K positive) {
        
		Mass<K,V> child = getChild();
		
		if(positive.equals(getKey())) {
			return true;
		}
		else if(child != null) {
			return child.containsKey(positive);
		}
		else {
			return false;
		}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#containsNegative(java.lang.Object)
     */
    public boolean containsValue(V negative)
    {
    	return get().containsKey(negative);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#collectKeys(java.util.Set)
	 */
	@Override
	public Congregation<K> collectKeys(Congregation<K> keys)
	{
		keys.add(getKey());
		
		Mass<K,V> child = getChild();
		
		if(child != null)
		{
			return child.collectKeys(keys);
		}
		else
		{
			return keys;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#collectValues(java.util.Collection)
	 */
	@Override
	public Congregation<V> collectValues(Congregation<V> values)
	{
		return get().collectKeys(values);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#forEachPositive(java.util.function.BiConsumer)
     */
    public void forEachKey(BiConsumer<? super K,? super V> action) {

    	Objects.requireNonNull(action);
        for (Mass<K,V> entry : this) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            action.accept(k, v);
        }
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#forEachNegative(java.util.function.BiConsumer)
     */
    public void forEachValue(BiConsumer<? super V, ? super K> action) {

    	get().forEachKey(action);
    }
}
