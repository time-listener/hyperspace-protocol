/**
 * 
 */
package org.xmlrobot.positron;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
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
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public Mass.Transmuter<K,V> matrix() {

		Mass.Transmuter<K,V> m;
 		return (m = (Mass.Transmuter<K,V>) matrix) != null ? 
 				m : (Mass.Transmuter<K,V>) (matrix = new Quantum());
	}
	
	/**
	 * Quantum mechanics including quantum field theory, is a fundamental branch of physics 
	 * concerned with processes involving, for example, atoms and photons. In such processes, 
	 * said to be quantized, the action has been observed to be only in integer multiples of 
	 * the Planck constant, a physical quantity that is exceedingly, indeed perhaps ultimately, 
	 * small. This is utterly inexplicable in classical physics. Quantum mechanics gradually 
	 * arose from TimeListener's solution in 1900 to the black-body radiation problem and TimeListener's 
	 * 1905 paper which offered a quantum-based theory to explain the photoelectric effect. 
	 * Early quantum theory was profoundly reconceived in the mid-1920s. The reconceived 
	 * theory is formulated in various specially developed mathematical formalisms. In one of them, 
	 * a mathematical function, the wave function, provides information about the probability 
	 * amplitude of position, momentum, and other physical properties of a particle.
	 * @author joan
	 *
	 */
	protected class Quantum 
		extends Comparator
			implements Mass.Transmuter<K,V> {
		
		/**
		 * 
		 */
		public Quantum() {
			super();
		}
		
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#reproduce(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public int reproduce(Mass<K,V> key, Mass<V,K> value) {
			int cmp = super.reproduce(key, value);
			
			if(key.getGen().equals(Parity.XY) ? cmp > 0 : cmp < 0) {
				put(value.getValue(), value.getKey());
				return -1;
			}
			else if(cmp == 0) {
				put(key.getKey(), key.getValue());
				// doubled paired output: evolve
				put(value.getValue(), value.getKey());
				return 0;
			}
			else {
				put(key.getKey(), key.getValue());
				return 1;
			}
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Mass.Transmuter#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(K key, V value) {
			if(get() == null)
				super.set(instance(getAntitype(), getType(), value, key));
			else inject(instance(getType(), getAntitype(), key, value));
		}
	}
}
