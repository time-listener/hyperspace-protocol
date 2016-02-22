/**
 * 
 */
package org.xmlrobot.inheritance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.genesis.Replicator;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.space.Space;
import org.xmlrobot.time.Inheritance;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The Parent of {@link Inheritance}.
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 27
 */
@XmlTransient
public abstract class Parent
	<K extends TimeListener<? super K,? super V>, 
	 V extends TimeListener<? super V,? super K>>
		extends Space<K,V>
			implements Replicator<K,V> {
	
	/**
	 * -5344433423123917995L
	 */
	private static final long serialVersionUID = -5344433423123917995L;
	
	/**
	 * The manipulated mass.
	 */
	transient volatile Mass<K,V> plasma;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getKey()
	 */
	@Override
	@XmlTransient
	public K getKey() {
		return super.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setKey(java.lang.Object)
	 */
	@Override
	public K setKey(K key) {
		return super.setKey(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#getValue()
	 */
	@Override
	@XmlTransient
	public V getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		V oldValue = super.setValue(value);
		// check existence
		if(value != null)
			// ancestral callback
			value.addMassListener(this);
		// follow settling
		return oldValue;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	@XmlElement
	public String getName() {
		// inherited be your name
		K key;
		// assign and check
		return (key = getKey()) != null ? key.getName() : new String();
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Replicator#getPlasma()
 	 */
 	@Override
 	@XmlTransient
 	public Mass<K,V> getPlasma() {
 		return plasma;
 	}
 	
	/**
	 * {@link Parent} default class constructor.
	 */
	public Parent() {
		super();
	}
	/**
	 * {@link Parent} default class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Parent(
			Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Parent<K,V>> type, 
			Parity gen)	{
		super(type, gen);
		// create mass
		plasma = instance(matter, antimatter);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	protected Parent(
			Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter,
			Class<? extends Parent<K,V>> type,	
			K key, V value, Parent<K,V> parent) {
		super(type, key, value, parent);
		// listen value's masses
		value.addMassListener(this);
		// create mass
		plasma = instance(matter, antimatter, key, value, parent.getPlasma());
	}
	/**
	 * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Parent(
			Class<? extends Mass<K,V>> matter,
			Class<? extends Mass<V,K>> antimatter,
			Class<? extends Parent<K,V>> type,
			K key, V value, Parity gen) {
		super(type, key, value, gen);
		// listen value's masses
		value.addMassListener(this);
		// create mass
		plasma = instance(matter, antimatter, key, value);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	protected Parent(
			Class<? extends Parent<K,V>> type, 
			Class<? extends Parent<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	protected Parent(
			Class<? extends Parent<K,V>> type, 
			Class<? extends Parent<V,K>> antitype, 
			K key, V value, Parent<K,V> parent) {
		super(type, antitype, key, value, parent);
		// listen value's masses
		value.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender1
	 */
	protected Parent(
			Class<? extends Parent<K,V>> type, 
			Class<? extends Parent<V,K>> antitype, 
			K key, V value,	Parity gen) {
		// call constructor
		super(type, antitype, key, value, gen);
		// listen value's masses
		value.addMassListener(this);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Time#compare(org.xmlrobot.genesis.TimeListener, org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized int compare(Mass<K,V> o1, Mass<K,V> o2) {
		return o1.getValue().compareTo(o2.getKey());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Inheritance#run()
	 */
	@Override
	public void run() {
		// hollow run
		super.run();
		// declare value
		V value;
		// assign and check
		if((value = super.getValue()) != null) {
			// listen time
			value.start(getContext());
		}
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.hyperspace.Recursion#set(org.xmlrobot.genesis.TimeListener)
 	 */
 	@Override
	public void set(Mass<V,K> value) {
		super.set(value);
		// cast source
		Parent<V,K> stem = (Parent<V,K>) value;
		// set child's plasma
		stem.plasma = plasma.get();
		// my plasma is listened by my root's plasma
		stem.plasma.setStem(plasma.getRoot());
		stem.plasma.setRoot(plasma.getStem());
		// listen plasma masses
		stem.plasma.addMassListener(this);
		plasma.addMassListener(stem);
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
 	 */
 	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		// assign and check
		if (ref.getProperty(TimeListener.KEY) == this) {
			// commute command
			if (event.getType() == ServiceEvent.REGISTERED) {

				plasma.push(Command.SUBMIT);
			} 
			else if (event.getType() == ServiceEvent.UNREGISTERING) {
				// release replication
				plasma.push(Command.RELEASE);
			}
		}
	}

 	// matrix implementation
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.Hypergenesis#matrix()
 	 */
 	@Override
 	public Mass.Transmuter<K,V> matrix() {
 		Mass.Transmuter<K,V> m;
 		return (m = (Mass.Transmuter<K,V>) matrix) == null ? 
 				(Mass.Transmuter<K,V>) (matrix = new Transcoder()) : m;
 	}

	/**
	 * Information transcoder implementation class. 
	 * @author joan
	 *
	 */
	protected class Transcoder
 		extends Comparator
 			implements Mass.Transmuter<K,V> {

		/**
		 * {@link Transcoder} default class constructor.
		 */
		public Transcoder() {
			super();
		}

		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Hypergenesis.Comparator#compare(java.lang.Object, java.lang.Object)
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
		 * @see org.xmlrobot.genesis.Mass.Transmuter#set(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(K key, V value) {
			if(get() == null)
				set(instance(getAntitype(), getType(), value, key));
			else inject(instance(getType(), getAntitype(), key, value));
		}
	}
}