/**
 * 
 */
package org.xmlrobot.space;

import java.util.Objects;
import java.util.function.BiFunction;

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
 * @since 20
 */
@XmlTransient
public abstract class Dilatation<K,V>
	extends Singularity<K,V> { 

	/**
	 * -7033015578655002583L
	 */
	private static final long serialVersionUID = -7033015578655002583L;
	
	/**
	 * {@link Dilatation} default class constructor.
	 */
	public Dilatation() {
		super();
	}
	/**
     * {@link Dilatation} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
    protected Dilatation(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
	}
	/**
	 * {@link Dilatation} default class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param parity {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Mass<K,V> parent) {
		super(type, stem, parent);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Parity gen) {
		super(type, stem, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param parity {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param parent the parent of inheritance
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param antitype the value
	 * @param parity {@link Parity} the gender
	 */
	protected Dilatation(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#mergeNegative(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
     */
    public V merge(K key, V value,
            BiFunction<? super V,? super V,? extends V> remappingFunction) {
    	
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = getValue(key);
        V newValue = (oldValue == null) ? value :
                   remappingFunction.apply(oldValue, value);
        if(newValue == null) {
            remove(key);
        } else {
            putValue(key, newValue);
        }
        return newValue;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#mergePositive(java.lang.Object, java.lang.Object, java.util.function.BiFunction)
     */
    public K mergeInverted(V value, K key,
            BiFunction<? super K,? super K,? extends K> remappingFunction) {
    
    	return get().merge(value, key, remappingFunction);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#removeNegative(java.lang.Object)
     */
    public Mass<K,V> removeByKey(K key) {
    
    	Mass<K,V> child = getChild();
    	
    	if(key.equals(getKey())) {
    		remove();
    		return call(); //a.k.a getType().cast(this)
    	}
    	else if(child != null) {
    		
    		return child.removeByKey(key);
    	}
    	else {

        	return null;
    	}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#removePositive(java.lang.Object)
     */
    public Mass<V,K> removeByValue(V value) {
    	
    	return get().removeByKey(value);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#removeNegative(java.lang.Object, java.lang.Object)
     */
    public boolean removeByKey(K key, V value) {
    	
    	Mass<K,V> child = getChild();
    	
    	if(key.equals(getKey())) {
    		if(value.equals(getValue())) {
    			remove();
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	else if(child != null) {
    		return child.removeByKey(key, value);
    	}
    	else {
        	return false;
    	}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#removeByValue(java.lang.Object, java.lang.Object)
     */
    public boolean removeByValue(V value, K key) {
    	
    	return get().removeByKey(value, key);
    }
}
