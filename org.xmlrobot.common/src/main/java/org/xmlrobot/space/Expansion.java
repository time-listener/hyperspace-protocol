/**
 * 
 */
package org.xmlrobot.space;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Mass;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 21
 */
@XmlTransient
public abstract class Expansion <K,V>
	extends Dilatation<K,V> {

	/**
	 * 2134119281050685155L
	 */
	private static final long serialVersionUID = 2134119281050685155L;
	
	/**
	 * {@link Expansion} default class constructor.
	 */
	public Expansion() {
		super();
	}
	/**
	 * Expansion default class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * Expansion class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * Expansion class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, K key, V value, Parity gen)	{
		super(type, key, value, gen);
	}
	/**
	 * Expansion class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param parity {@link Parity} the gender
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) throws Abort {
		super(type, stem, key, value, parent);
	}
	/**
	 * Expansion class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * Expansion class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, Parity gen) {
		
		super(type, antitype, gen);
	}
	/**
	 * Expansion class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, K key, V value, Parity gen) {
		
		super(type, key, value, gen);
	}
	/**
	 * Expansion class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Expansion(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}
	
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#computeIfAbsent(java.lang.Object, java.util.function.Function)
     */
    public V computeIfAbsent(K key, 
    		Function<? super K,? extends V> mappingFunction) {
    	
    	Objects.requireNonNull(mappingFunction);
        V v;
        if ((v = getValue(key)) == null) {
            V newValue;
            if ((newValue = mappingFunction.apply(key)) != null) {
        		putValue(key, newValue);	
                return newValue;
            }
        }
        return v;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#computePositiveIfAbsent(java.lang.Object, java.util.function.Function)
     */
    public K computeInvertedIfAbsent(V value, 
    		Function<? super V,? extends K> mappingFunction) {
    	Objects.requireNonNull(mappingFunction);
        K k;
        if ((k = getKey(value)) == null) {
            K newKey;
            if ((newKey = mappingFunction.apply(value)) != null) {
        		putKey(value, newKey);	
                return newKey;
            }
        }
        return k;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#compute(java.lang.Object, java.util.function.BiFunction)
     */
    public V compute(K key,
    		BiFunction<? super K,? super V,? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = getValue(key);
        V newValue = remappingFunction.apply(key, oldValue);
        
        if (newValue == null) {
            // delete mapping
            if (oldValue != null || containsKey(key)) {
                // something to remove
                remove(key);
                return null;
            } else {
                // nothing to do. Leave things as they were.
                return null;
            }
        } else {
            // add or replace old mapping
            putValue(key, newValue);
            return newValue;
        }
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#computePositive(java.lang.Object, java.util.function.BiFunction)
     */
    public K computeInverted(V value,
    		BiFunction<? super V, ? super K, ? extends K> remappingFunction) {
    	Objects.requireNonNull(remappingFunction);
        K oldKey = getKey(value);
        K newKey = remappingFunction.apply(value, oldKey);
        
        if (newKey == null) {
            // delete mapping
            if (oldKey != null || containsValue(value)) {
                // something to remove
                remove(value);
                return null;
            } else {
                // nothing to do. Leave things as they were.
                return null;
            }
        } else {
            // add or replace old mapping
            putKey(value, newKey);
            return newKey;
        }
    }

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computeNegativeIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	public V computeIfPresent(K key, 
			BiFunction<? super K,? super V,? extends V> remappingFunction) {
		Objects.requireNonNull(remappingFunction);
        V oldValue;
        if ((oldValue = getValue(key)) != null) {
            V newValue = remappingFunction.apply(key, oldValue);
            if (newValue != null) {
                try {
            		putValue(key, newValue);	
				} catch (Abort e) {
					e.printStackTrace();
				}
                return newValue;
            } else {
                remove(key);
                return null;
            }
        } else {
            return null;
        }
    }	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#computePositiveIfPresent(java.lang.Object, java.util.function.BiFunction)
	 */
	public K computeInvertedIfPresent(V value, 
			BiFunction<? super V,? super K,? extends K> remappingFunction) {
		Objects.requireNonNull(remappingFunction);
        K oldKey;
        if ((oldKey = getKey(value)) != null) {
            K newKey = remappingFunction.apply(value, oldKey);
            if (newKey != null) {
                try {
            		putKey(value, newKey);	
				} catch (Abort e) {
					e.printStackTrace();
				}
                return newKey;
            } else {
                remove(value);
                return null;
            }
        } else {
            return null;
        }
	}
}
