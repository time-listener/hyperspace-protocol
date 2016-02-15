/**
 * 
 */
package org.xmlrobot.space;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.protocol.Hypermass;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Parity;

/**
 * Spacetime singularity implementation class.
 * <br><br>
 * This class creates the massive message.
 * <br><br>
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 19
 */
@XmlTransient
public abstract class Singularity<K,V> 
	extends Time<Mass<K,V>,Mass<V,K>>
		implements Mass<K,V> {

	/**
	 * -239201139092107139L
	 */
	private static final long serialVersionUID = -239201139092107139L;

	volatile Hypermass<K,V> mass;
	
	/**
	 * {@link Singularity} default class constructor.
	 */
	public Singularity() {
	
		super();
		// create message listener
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
     * {@link Singularity} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
    protected Singularity(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parity {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, parent);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, gen);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, Mass<K,V> parent) {
		super(type, stem, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, Parity gen) {
		super(type, stem, gen);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, K key, V value, Mass<K,V> parent) {
		super(type, stem, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Mass<V,K> stem, K key, V value, Parity gen) {
		super(type, stem, gen);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
		// instance listener message
		mass = new Hypermass<K,V>(super.dna());
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent the parent of inheritance
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, parent);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/**
	 * {@link Singularity} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Singularity(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Parity gen) {
		super(type, gen);
		// instance listener message		
		mass = new Hypermass<K,V>(super.dna(), key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Replicator#plasm()
	 */
	@Override
	public Mass<K,V> getReplicator() {
		
		return null;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Mass<K,V> clone() {
		try {
			Singularity<K,V> key = (Singularity<K,V>) super.clone();

			if(key instanceof Entity)
				key.mass = new Hypermass<K,V>(key.dna());
			else key.mass = new Hypermass<K,V>(key.dna(), getKey(), getValue());
			return key;
		}
		catch (ClassCastException | NullPointerException | Abort a) {

			return null;
		}
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.time.Logic#equals(java.lang.Object)
     */
    public boolean equals(Object o) {
        if (!(o instanceof Mass))
            return false;
        Mass<?,?> e = (Mass<?,?>)o;
        return equality(getKey(), e.getKey()) && equality(getValue(), e.getValue());
    }

    /**
     * Returns the hash code value for this map entry.  The hash code
     * of a map entry {@code e} is defined to be: <pre>
     *   (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
     *   (e.getValue()==null ? 0 : e.getValue().hashCode())</pre>
     * This ensures that {@code e1.equals(e2)} implies that
     * {@code e1.hashCode()==e2.hashCode()} for any two Entries
     * {@code e1} and {@code e2}, as required by the general
     * contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this map entry
     * @see    #equals
     */
    public int hashCode() {
    	return super.hashCode();
//        return (getKey()   == null ? 0 : getKey().hashCode()) ^
//               (getValue() == null ? 0 : getValue().hashCode());
    }
}