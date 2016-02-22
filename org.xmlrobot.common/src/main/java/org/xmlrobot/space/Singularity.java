/**
 * 
 */
package org.xmlrobot.space;

import java.util.Iterator;

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
	/**
	 * Mass {@link Iterator} implementation class.
	 * @author joan
	 */
	protected class MassIterator 
		extends InheritanceIterator 
			implements Iterator<Mass<K,V>> {

		/**
		 * @param entity
		 */
		public MassIterator(Mass<K,V> entity) {
			super(entity);
		}
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Mass<K,V> next() {
			return getGen().equals(Parity.XY) ? backward() : forward();
		}

		/* (non-Javadoc)
		 * @see org.xmlrobot.time.Metaphysical.InheritanceIterator#remove()
		 */
		@Override
		public void remove() {
			return;	
		}
	}
	/**
	 * Key {@link Iterator} implementation class.
	 * @author joan
	 */
	protected class KeyIterator
		extends InheritanceIterator
			implements Iterator<K> {

		/**
		 * @param entity
		 */
		public KeyIterator(Mass<K,V> entity) {
			super(entity);
		}
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public K next() {
			return getGen().equals(Parity.XY) ? 
					backward().getKey() : forward().getKey();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.time.Metaphysical.InheritanceIterator#remove()
		 */
		@Override
		public void remove() {
			return;		
		}
	}
	/**
	 * Value {@link Iterator} implementation class.
	 * @author joan
	 */
	protected class ValueIterator
		extends InheritanceIterator
			implements Iterator<V> {
		/**
		 * @param entity
		 */
		public ValueIterator(Mass<K,V> entity) {
			super(entity);
		}
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public V next() {
			return getGen().equals(Parity.XY) ? 
					backward().getValue() : forward().getValue();
		}

		/* (non-Javadoc)
		 * @see org.xmlrobot.time.Metaphysical.InheritanceIterator#remove()
		 */
		@Override
		public void remove() {
			return;
		}
	}
}