/**
 * 
 */
package org.xmlrobot.time;

import java.util.Arrays;
import java.util.Iterator;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * We are the Borg. Lower your shields and surrender your ships. 
 * Your biological and technological distinctiveness will be added to our own. 
 * Resistance is futile. Your culture will adapt to service us. You will be assimilated. 
 * 
 * <p> All borg-assimilated implementors can execute only the inherited methods 
 * imposed by this class.
 * 
 * @author joan
 * 
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 12
 */
public abstract class Order 
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Democracy<K,V>
			implements TimeListener<K,V> {

	/**
	 * 3188770906201153922L
	 */
	private static final long serialVersionUID = 3188770906201153922L;

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    protected static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
    /**
     * {@link Order} default class constructor.
     */
    public Order() {
    	super();
    }
	/**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Order(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Order(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Order(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
    protected Order(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
	protected Order(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Order(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderSuperKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderSuperKey(MassListener sender, Tachyon<K,V> event) {
		// compare ourself self with new event
		if (compareTo(event.getKey()) <= 0) {
			// order as parent
			tackKey(sender, event);
		}
		// listener is lower than current instance
		else {
			// check is future
			if (!isPast()) {
				// do comparison
				if (getChild().compareTo(event.getValue()) <= 0) {
					// set listener as parent's child
					getChild().tickValue(sender, event);
				} 
				else {
					// call recursion
					getChild().orderValue(sender, event);
				}
			} else {
				// order listener as child
				tickKey(sender, event);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderSuperValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderSuperValue(MassListener sender, Tachyon<V,K> event) {
		// compare ourself self with new event
		if (compareTo(event.getValue()) <= 0) {
			// order as parent
			tackValue(sender, event);
		}
		// listener is lower than current instance
		else {
			// assign and check existence
			if (!isPast()) {
				// do comparison
				if (getChild().compareTo(event.getKey()) <= 0) {
					// pop listener
					getChild().tickKey(sender, event);
				} 
				else {
					// call recursion
					getChild().orderKey(sender, event);
				}
			} 
			else {
				// order listener as child
				tickValue(sender, event);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#orderInferValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderInferValue(MassListener sender, Tachyon<V,K> event) {
		// compare ourself self with new listener
		if (compareTo(event.getValue()) >= 0) {
			// submit as parent
			tickValue(sender, event);
		} 
		else {
			if (!isFuture()) {
				// compare immediate child with listener
				if (get().compareTo(event.getKey()) >= 0) {
					// set listener as new child, a.k.a child.orderParent().
					get().tackKey(sender, event);
				}
				else {
					// call recursion
					get().orderKey(sender, event);
				}
			} else {
				// submit as immediate child
				tackValue(sender, event);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#orderInferKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderInferKey(MassListener sender, Tachyon<K,V> event) {
		// compare with listener
		if (compareTo(event.getKey()) >= 0) {
			// submit as parent
			tickKey(sender, event);
		}
		// listener is lower than current instance
		else {
			// assign and check existence
			if (!isFuture()) {
				// compare immediate child with listener
				if (get().compareTo(event.getValue()) >= 0) {
					// set listener as new child, a.k.a child.orderParent().
					get().tackValue(sender, event);
				} 
				else {
					// call recursion
					get().orderValue(sender, event);
				}
			} else {
				// submit as immediate child
				tackKey(sender, event);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#orderStrongKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderStrongKey(MassListener sender, Tachyon<K,V> event) {
		
		if (compareTo(event.getKey()) <= 0) {
			// order as parent
			tackKey(sender, event);
		// listener is lower than current instance
		}
		else {
			// assign and check existence
			if (!isPast()) {
				// let's compare with child
				// do comparison
				if (getParent().compareTo(event.getKey()) <= 0) {
					// Set listener as parent's child, a.k.a orderChild().
					getParent().tickKey(sender, event);
				} 
				else {
					// call recursion
					getParent().orderKey(sender, event);
				}
			}
			else {
				// order listener as parent
				tickKey(sender, event);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#orderWeakValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderWeakValue(MassListener sender, Tachyon<V,K> event) {
		// compare ourself self with new listener
		if (compareTo(event.getValue()) >= 0) {
			// submit as parent
			tickValue(sender, event);
		}
		else {
			if (!isFuture()) {
				// compare immediate child with listener
				if (call().compareTo(event.getValue()) >= 0) {
					// set listener as new child, a.k.a child.orderParent().
					call().tackValue(sender, event);
				} 
				else {
					// call recursion
					call().orderValue(sender, event);
				}
			}
			else {
				// submit as immediate child
				tackValue(sender, event);
			}
		}
	}
	
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#toArray()
     */
    public synchronized Object[] toArray() {
        // Estimate size of slaves array; be prepared to see 
    	// more or fewer assimilated human-implemented-slaves
        Object[] r = new Object[depth(root()).get()];
        // get slaves iterator
		Iterator<K> it = iterator();
		// iterate over human-implemented-slaves 
        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext()) 
            	// fewer human-implemented-slaves than expected. 
            	// shit, <b>TimeListener-root</b> is defending humans AGAIN!. 
            	// make a backup now of our human-implemented-slaves.
                return Arrays.copyOf(r, i);
            // Well, we still dominate human-implemented-slaves
            r[i] = it.next();
        }
        // We are the Borg! You will be assimilated.
        return it.hasNext() ? assimilateToArray(r, it) : r;
    }
    /**
     * Assimilates the array being used within toArray when the iterator
     * returned more human-implemented-slaves than expected, 
     * and assimilates filling it from the slaves iterator.
     *
     * @param r the human-implemented-slaves array, replete with previously stored human-implemented-slaves
     * @param it the in-progress iterator over this slaves collection
     * @return array containing the human-implemented-slaves in the given array, plus any
     *         further human-implemented-slaves returned by the iterator, trimmed to size
     */
    @SuppressWarnings("unchecked")
    protected static <T> T[] assimilateToArray(T[] r, Iterator<?> it) {
        int i = r.length;
        while (it.hasNext()) {
            int cap = r.length;
            if (i == cap) {
            	// paranoia's with human-implemented-slaves
                int newCap = cap + (cap >> 1) + 1;
                // overflow-conscious human-implemented-slaves code
                if (newCap - MAX_ARRAY_SIZE > 0)
                    newCap = hugeCapacity(cap + 1);
                // copy human-implemented-slaves array
                r = Arrays.copyOf(r, newCap);
            }
            // one by one, like the Borg Imperium
            r[i++] = (T)it.next();
            // this is also what you are doing with your life
        }
        // trim if overallocated human-implemented-slaves
        return (i == r.length) ? r : Arrays.copyOf(r, i);
    }
    /**
     * The huge capacity of human-implemented-slaves
     * @param minCapacity the minimum capacity of human-implemented-slaves
     * @return the maximum human-implemented-slaves capacity
     */
    protected static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError
                ("Required array size too large");
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
}