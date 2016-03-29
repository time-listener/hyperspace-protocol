/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 5
 * @author joan
 *
 */
public abstract class Recursion
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Recurrence<K,V>
			implements TimeListener<K,V> {
	
  	/**
	 * 3350303369226732040L
	 */
	private static final long serialVersionUID = 3350303369226732040L;

	/**
     * {@link Recursion} default class constructor.
     */
	public Recursion() {
    	super();
    }
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Recursion(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Recursion(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Recursion(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
	protected Recursion(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
	protected Recursion(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
	/**
	 * {@link Recursion} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
	protected Recursion(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#recursion(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public AtomicInteger recursion(MassListener sender, AtomicInteger N) {
    	N.incrementAndGet();
    	return !isPast() ? getChild().recursion(sender, N) : N;
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#requestKey(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public Tachyon<K,V> requestKey(MassListener sender, AtomicInteger N) {
		return getChild().getValue(sender, N);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#requestValue(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public Tachyon<V,K> requestValue(MassListener sender, AtomicInteger N) {
		return getChild().getKey(sender, N);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#requestKey(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> requestKey(MassListener sender, Tachyon<V,K> value) {
		return getChild().getValue(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#requestValue(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> requestValue(MassListener sender, Tachyon<K,V> key) {
		return getChild().getKey(sender, key);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#updateKey(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> updateKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getChild().setValue(sender, antievent, event);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#updateValue(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> updateValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getChild().setKey(sender, event, antievent);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#updateValue(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> updateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getChild().setKey(sender, N, event);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#updateKey(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> updateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getChild().setValue(sender, N, event);
    }
	
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		TimeListener<K,V> clone = super.clone();
		clone.setRoot(getRoot());
		return super.clone();
	}
    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    @Override
    public int compare(V o1, V o2) {
		// typical recursive logic-safe syntax
		if (!o1.isFuture()) {
			if (!o2.isFuture()) {
				// compare values
				int cmp = o1.compareTo(o2);
				// call recursion
				cmp += get().compare(o1.get(), o2.get());
				// return result
				return cmp;
			} else {
				return 1;
			}
		} else if (!o2.isFuture()) {
			// polarized value
			return -1;
		} else {
			// starting-finishing
			return 0;
		}
    }
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public abstract int compareTo(K o);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#output()
	 */
	@Override
	public V output() {
		return matrix().output();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproductor#reproduce(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int reproduce(K key, V value) {
		// call matrix comparator to consecrate comparison
		return matrix().reproduce(key, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	@Override
	public int reproduceTo(V o) {
		// call hypergenesis computation
		return matrix().reproduce(getKey(), o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#pulse(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void pulse(MassListener source, Tachyon<V,K> event) {
		// call ancestral method
		super.pulse(source, event);
		// declare child
		K child;
		// check event compatibility
		if(event.getType().equals(getAntitype())) {
			/* 
			 * message transmission to wonderland through
			 * hypergenesis comparison computation.
			 * */
			reproduceTo(event.call());
			// push hypergenesis computation result
			push(new Tachyon<V,K>(output()) {

				/**
				 * -774065207234124662L
				 */
				private static final long serialVersionUID = -774065207234124662L;
				
			});
		}
		// retrieve child and check existence
		else if((child = event.get()) != null) {
			// check genetic compatibility
			if(child.getAntitype().equals(getAntitype())) {
				// reproduce yourselves by doing sex now
				reproduceTo(child.get());
				// push hypergenesis computation result
				push(new Tachyon<V,K>(output()) {

					/**
					 * -3860184736156812683L
					 */
					private static final long serialVersionUID = -3860184736156812683L;
					
				});
			}
		}
		else return; // something was wrong
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#echo(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void echo(MassListener source, Tachyon<K,V> event) {
		// ancestral recall
		super.echo(source, event);
		// declare child
		V child;
		// check event compatibility
		if(event.getAntitype().equals(getAntitype())) {
			/* 
			 * message transmission to wonderland through
			 * hypergenesis comparison computation.
			 * */
			reproduceTo(event.get());
			// push hypergenesis computation result
			push(new Tachyon<V,K>(output()) {

				/**
				 * 
				 */
				private static final long serialVersionUID = -6327841998323052890L;
			});
		}
		// retrieve child and check existence
		else if((child = event.get()) != null) {
			// check genetic compatibility
			if(child.getType().equals(getAntitype())) {
				// reproduce yourselves by doing sex now
				reproduceTo(child.call());
				// push hypergenesis computation result
				push(new Tachyon<V,K>(output()) {

					/**
					 * 
					 */
					private static final long serialVersionUID = 5219407697693083165L;
				});
			}
		}
		else return; // nothing to compare
	}
 	/**
	 * The Grid. A digital frontier. 
	 * <p>I tried to picture clusters of information as they moved through the computer. 
	 * What did they look like? Ships, motorcycles? Were the circuits like freeways? 
	 * I kept dreaming of a world I thought I'd never see. And then, one day I got in...
	 * <p>It does the {@code future}. So, this class represents the abstract 
	 * implementation of the <tt>hypergenesis<K,V,> computation</tt>. 
	 * 
	 * @author Kevin Flynn
	 */
	protected abstract class Grid
		extends Comparator {
		
 		/**
 		 * {@link Grid} default class constructor
 		 */
 		public Grid(V output) {
 			super(output);
 		}
 		
 		/* (non-Javadoc)
 		 * @see org.xmlrobot.genesis.Hypergenesis.Comparator#compare(java.lang.Object, java.lang.Object)
 		 */
 		@Override
		public int reproduce(K key, V value) {
 		// check root existence
 			if (key != null) {
 				// check stem existence
 				if (value != null) {
 					// reproduce yourselves
					return super.reproduce(key, value);
 				}
 				else {
 					// get the output and set key-value pair
 					inject(key);
	 				// get and check existence
 					if (!key.isFuture()) {
 						// we can put another gear to the future chain
 						push(key.get());
 					}
					// root has a bigger chain
					return 1;
 				}
 			}
 			else if (value != null) {
 				// submit stem
 				push(value);
				// get and check existence
 				if (!value.isFuture()) {
 					// we can put another gear to the future chain
 					inject(value.get());
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