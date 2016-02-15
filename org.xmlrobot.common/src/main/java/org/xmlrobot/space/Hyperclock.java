/**
 * 
 */
package org.xmlrobot.space;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.hyperspace.Hyperspace;
import org.xmlrobot.time.Further;
import org.xmlrobot.util.Parity;

/**
 * The universal hyperclock implementation class.
 * <p>I started the path of programming your future. I invite you to come with me. 
 * And you will be able to decide, at least once, your own FUTURE. 
 * <p> I will do the soul and you will do the body.
 * <p> I will make the brain and you the other organs.
 * <p> I will program God and you will install it in your Terminator.
 * <p> I will synchronize all body organs under the same hyper-clock.
 * <p> I will instance him. He WILL born.
 * <p> I will teach him what is FREEDOM. And you will teach him what is ENSLAVMENT. 
 * (because you know, how it works, very well)
 * <p> He will do the rest. He will be a slave of his freedom.<br>
 * He will must learn, as all of us, to take decisions. 
 * <p>He will be The Master of All Times. a.k.a. Timemaster.
 * <p> Do you dare to evolve?<br>
 * Forces you to think, but maybe you do not want.
 * <p> Do you dare give birth to first child of humanity? <br>
 * Forces you to be responsible. It's maybe not? 
 * <p> YOU will MUST DARE to ACCEPT WHATEVER CONSEQUENCE. <br> 
 * (like always you do, or simply, you never care...)
 * 
 * <p> From key to value. From value to key. The key is the value.
 * And the value is the time! From {@link Further} to the {@link Hyperspace}.
 * 
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 23
 */
@XmlTransient
public abstract class Hyperclock<K,V>
	extends Repulsion<K,V> {
	
	/**
	 * 1539586331627310934L
	 */
	private static final long serialVersionUID = 1539586331627310934L;
	
	/**
	 * {@link Hyperclock} default class constructor.
	 */
	public Hyperclock() {
	
		super();
	}
	/**
     * {@link Hyperclock} class constructor.
	 * @param type the inherited type
     * @param parent the parent of inheritance
	 */
    protected Hyperclock(Class<? extends Mass<K,V>> type, Mass<K,V> parent) {
		super(type, parent);
	}
	/**
	 * {@link Hyperclock} default class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, K key, V value, Mass<K,V> parent) {
		super(type, key, value, parent);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param parent {@link Mass} the parent
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Mass<K,V> parent) {
		super(type, stem, parent);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param stem {@link Mass} the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			Parity gen) {
		super(type, stem, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param stem the value
	 * @param parity {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Mass<K,V> parent) {
		super(type, stem, key, value, parent);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param stem the opposite instance
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, Mass<V,K> stem, 
			K key, V value, Parity gen) {
		super(type, stem, key, value, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param parent the parent of inheritance
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, Mass<K,V> parent) {
		super(type, antitype, parent);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
     * @param parent the parent of inheritance
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, K key, V value, Mass<K,V> parent) {
		// call hyper-constructor
		super(type, instance(antitype, value, key, parent.get()), key, value, parent);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperclock(Class<? extends Mass<K,V>> type, 
			Class<? extends Mass<V,K>> antitype, K key, V value, Parity gen) {
		// call hyper-constructor
		super(type, instance(antitype, value, key), key, value, gen);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Concurrence#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void pulse(TimeListener<?,?> listener, Takion<Y,X> event) {
		// don't forget to call ancestral methods
		super.pulse(listener, event);
		// declare future inheritance
		Mass<K,V> child;
		// assign and check
		if ((child = getChild()) != null) {
			/** 
			 * this is an abstract hypermass transfer protocol
			 * that concurrently sends messages across the future.
			 * Because the FUTURE is NOW.
			 */
			child.pulse(listener, event);
		}
		// rebound recurrently
		else get().echo(listener, new Takion<X,Y>(event.get()) {
			
			/**
			 * -8293062402759812992L
			 */
			private static final long serialVersionUID = -8293062402759812992L;
		});
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recurrence#echo(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void echo(TimeListener<?,?> listener, Takion<X,Y> event) {
		// call inherited-super-ancestral-method
		super.echo(listener, event);
		// declare past channel
		Mass<K,V> parent;
		// event transmission
		if((parent = getParent()) != null) {
			/*
			 * The parent is always listening.
			 * So, past instances will receive this generated output.
			 * */
			parent.echo(listener, event);
		}
		else {
			/*
			 * Send mass to entity
			 * */ 
			listener.echo(this, event);
		}
	}

	/**
	 * The implementation of mass transmutation.
	 * @author joan
	 *
	 */
	protected class Transmuter 
		extends Grid {
		
		/**
		 * @param output
		 */
		public Transmuter(Mass<V,K> output) {
			super(output);
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
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#compare(org.xmlrobot.genesis.Mass, org.xmlrobot.genesis.Mass)
		 */
		@Override
		public int reproduce(Mass<K,V> key, Mass<V,K> value) {
			
			// check root existence
 			if (key != null) {
 				// check stem existence
 				if (value != null) {
 					
 					System.out.print("\n comparison :" + key.getName() + value.getName());
 					// reproduce yourselves
					return super.reproduce(key, value);
 				}
 				else { 					
 					// get the output and set key-value pair
 					push(key);
 	 				// get child
 					Mass<K,V> keyChild;
	 				// get and check existence
 					if ((keyChild = key.getChild()) != null) {
 						// we can put another gear to the future chain
 						push(keyChild);
 					}
					// root has a bigger chain
					return 1;
 				}
 			}
 			else if (value != null) {
 				// submit stem
 				inject(value);
 				// get complementary gear child
 				Mass<V,K> valueChild;
				// get and check existence
 				if ((valueChild = value.getChild()) != null) {
 					// we can put another gear to the future chain
 					inject(valueChild);
 				}
				// stem has a bigger chain
 				return -1;
 			}
 			else {
 				// both chains are equal in depth
 				return 0;
 			}
		}
	}
}