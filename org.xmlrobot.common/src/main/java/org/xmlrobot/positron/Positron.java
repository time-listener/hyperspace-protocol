/**
 * 
 */
package org.xmlrobot.positron;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.space.Space;
import org.xmlrobot.util.Parity;


/**
 * @author joan
 *
 */
@XmlTransient
public abstract class Positron<K,V>
	extends Space<K,V> {
	
	/**
	 * 4469845856208225940L
	 */
	private static final long serialVersionUID = 4469845856208225940L;

	/**
     * {@link Positron} default class constructor.
	 */
	public Positron() {
		super();
	}
	/**
	 * {@link Positron} default class constructor.
	 * @param type the inherited type
	 */
	public Positron(Class<? extends Mass<K,V>> type) {
		super(type, Parity.YY);
	}
	/**
     * {@link Positron} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
	public Positron(Class<? extends Mass<K,V>> type, 
			Mass<K,V> parent) {
		super(type, parent);
	}
	/**
	 * {@link Positron} class constructor.
	 * @param type the inherited type
	 */
	public Positron(Class<? extends Mass<K,V>> type, 
			K key, V value) {
		super(type, key, value, Parity.YY);
	}
	/**
	 * {@link Positron} class constructor.
	 * @param type the inherited type
	 * @param key {@link String} the key
	 * @param value {@link Object} the value
	 * @param parent the parent of inheritance
	 */
	public Positron(Class<? extends Mass<K,V>> type, 
			K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Positron} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 */
	public Positron(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype) {
		super(type, antitype, Parity.YY);
	}
	/**
	 * {@link Positron} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	public Positron(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
	}
	/**
	 * {@link Positron} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key {@link String} the key
	 * @param value {@link Object} the value
	 */
	public Positron(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value) {
		// call constructor
		super(type, antitype, key, value, Parity.YY);
	}
	/**
	 * {@link Positron} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param parent {@link Positron} the parent
	 */
	public Positron(Class<? extends Mass<K,V>> type, Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
	
		return;
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#matrix()
	 */
	@Override
	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {

		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (Quantum) (matrix = new Quantum());
	}

	
	/**
	 * @author joan
	 *
	 */
	protected class Quantum 
		extends Comparator {
		
		/**
		 * 
		 */
		public Quantum() {
			super();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#push(org.xmlrobot.genesis.Mass)
		 */
		@Override
		public void push(Mass<K,V> child) {
			output().get().add(child);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#inject(org.xmlrobot.genesis.Mass)
		 */
		@Override
		public void inject(Mass<V,K> child) {
			output().add(child);	
		}
	}
}
