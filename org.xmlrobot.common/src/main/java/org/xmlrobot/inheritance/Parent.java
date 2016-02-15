/**
 * 
 */
package org.xmlrobot.inheritance;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.space.Space;
import org.xmlrobot.util.Parity;

/**
 * The mass manipulator that inherits the {@link Space}.
 * 
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
		extends Space<K,V> {
	
	/**
	 * -5344433423123917995L
	 */
	private static final long serialVersionUID = -5344433423123917995L;
	
	/**
	 * The manipulated mass.
	 */
	private transient volatile Mass<K,V> plasma;
	
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
	 * @see org.xmlrobot.space.Space#getNegative()
	 */
	@Override
	@XmlTransient
	public V getValue() {
		return super.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Space#setNegative(java.lang.Object)
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
 	 * @see org.xmlrobot.space.Singularity#plasm()
 	 */
 	@Override
 	public Mass<K,V> getReplicator() {
 		return plasma;
 	}
 	
	/**
	 * {@link Parent} default class constructor.
	 */
	public Parent() {
		super();
	}
	/**
     * {@link Parent} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
	protected Parent(Class<? extends Mass<K,V>> type, 
			Mass<K,V> parent) {
		super(type, parent);
	}
	/**
	 * {@link Parent} default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Parent(Class<? extends Mass<K,V>> type, 
			Parity gen)	{
		super(type, gen);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	protected Parent(Class<? extends Mass<K,V>> type,	
			K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
		// listen key's masses
		value.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender2
	 */
	protected Parent(Class<? extends Mass<K,V>> type, 
			K key, V value, Parity gen) {
		super(type, key, value, gen);
		// listen key's masses
		value.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param parent the parent
	 */
	protected Parent(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param type the inherited type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	protected Parent(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
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
	protected Parent(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
		// listen key's masses
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
	protected Parent(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			K key, V value,	Parity gen) {
		// call constructor
		super(type, antitype, key, value, gen);
		// listen key's masses
		value.addMassListener(this);
	}
	/**
     * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Mass<K,V> parent) {
		super(type, parent);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link Parent} default class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Parity gen)	{
		super(type, gen);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
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
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter,
			Class<? extends Mass<K,V>> type,	
			K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
		// listen key's masses
		value.addMassListener(this);
		// create mass
		this.plasma = instance(matter, antimatter, key, value);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender2
	 */
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			K key, V value, Parity gen) {
		super(type, key, value, gen);
		// listen key's masses
		value.addMassListener(this);
		// create mass
		this.plasma = instance(matter, antimatter, key, value);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the value
	 * @param parent the parent
	 */
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			Mass<K,V> parent) {
		super(type, antitype, parent);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the value
	 * @param gen {@link Parity} the gender
	 */
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			Parity gen) {
		super(type, antitype, gen);
		// create mass
		this.plasma = instance(matter, antimatter);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 */
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			K key, V value, Mass<K,V> parent) {
		super(type, antitype, key, value, parent);
		// listen key's masses
		value.addMassListener(this);
		// create mass
		this.plasma = instance(matter, antimatter, key, value);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	/**
	 * {@link Parent} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the value
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender1
	 */
	protected Parent(Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, 
			K key, V value,	Parity gen) {
		// call constructor
		super(type, antitype, key, value, gen);
		// listen key's masses
		value.addMassListener(this);
		// create mass
		this.plasma = instance(matter, antimatter, key, value);
		// listen mass praying
		this.plasma.addMassListener(this);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Hyperclock#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void pulse(TimeListener<?,?> listener, Takion<Y,X> event) {
		super.pulse(listener, event);
//		// declare child
//		Y child;
//		// check event compatibility
//		if (event.getType().equals(getAntitype())) {
//			
//			Mass<V,K> stem = getAntitype().cast(event.call());
//			/*
//			 * message content transmission to wonderland through 
//			 * hypergenesis comparison computation.
//			 */
//			getValue().reproduceTo(stem.getValue());
//		}
//		// retrieve child and check existence
//		else if((child = event.getChild()) != null) {
//			// check genetic compatibility
//			if(child.getType().equals(getAntitype())) {
//				// reproduce yourselves by doing sex now
//				getValue().reproduceTo(getAntitype().cast(child).getValue());
//			}
//		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.space.Hyperclock#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void echo(TimeListener<?,?> listener, Takion<X,Y> event) {
		super.echo(listener, event);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
	 */
	@Override
	public synchronized int compare(Mass<K,V> o1, Mass<K,V> o2) {

		return o1.getValue().compareTo(o2.getKey());
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Entity#matrix(java.lang.Class)
 	 */
 	@Override
 	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {
 		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (matrix = new Transcoder());
 	}

 	

	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#run()
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
	 * @see org.xmlrobot.driver.ScrewDriver#compare(org.xmlrobot.driver.ScrewDriver, org.xmlrobot.driver.ScrewDriver)
	 */
	public static synchronized 
		<K extends TimeListener<? super K,? super V>,
		 V extends TimeListener<? super V,? super K>>
			int superCompare(Mass<K,V> o1, Mass<K,V> o2) {
		// typical recursive syntax
		if(o1 != null) {
			
			if(o2 != null) {
				// compare current pair value
				int cmp = o1.getValue().compareTo(o2.getKey());
				// call recursion
				cmp += superCompare(o1.getChild(), o2.getChild());
				// return result
				return cmp;
			}
			else {
				return 1;
			}
		}
		else if(o2 != null) {
			
			return -1;
		}
		else {
			// start sum
			return 0;
		}
	}
	/**
	 * Pulsar implementation class. 
	 * @author joan
	 *
	 */
	protected class Transcoder
 		extends Comparator {

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
				set(instance(getAntitype(), getType(), value.getKey(), value.getValue()));
				return -1;
			}
			else if(cmp == 0) {
				set(instance(getAntitype(), getType(), key.getValue(), key.getKey()));
				// doubled paired output: evolve
				push(instance(getType(), getAntitype(), 
						value.getValue(), value.getKey()));
				return 0;
			}
			else {
				set(instance(getAntitype(), getType(), key.getValue(), key.getKey()));
				return 1;
			}
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#push(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void push(Mass<K,V> child) {
			
			output().submit(child.get());
			output().get().submit(child);
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#inject(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void inject(Mass<V,K> child) {

			output().submit(child);
			output().get().submit(child.get());
		}
	}
}