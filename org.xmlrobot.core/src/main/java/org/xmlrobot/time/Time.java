/**
 * 
 */
package org.xmlrobot.time;

import org.xmlrobot.Continuum;
import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.genesis.PastCallable;
import org.xmlrobot.genesis.RunnableFuture;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Abstract time implementation class.
 * <p>n. A nonspatial {@link Continuum} in which events occur in apparently 
 * irreversible succession from the {@link PastCallable} through the current time to the {@link RunnableFuture}.
 * <p>n. An interval separating two points on this {@link Continuum}; a duration: 
 * a long time since the last concurrence; passed the time reading.
 * <p>n. A number, as of genomaps, hypercubes, or hyperedges, representing such an event: 
 * ran the course in a time just under four hyperedges.
 * All implementing instances will inherit {@link Time}. The {@link RunnableFuture}
 * is the last child of the inheritance (the last {@link PastCallable} 
 * entity). And the first parent is the {@link PastCallable} (the first 
 * {@link RunnableFuture} entity).
 *  
 * <p>All entities will live in a natural order hierarchy. IE, 
 * the class hierarchy of always that is always changing. 
 * 
 * <p>Hyperspace Navigation.
 * <br>
 * AN EXPANSIVE HISTORY OF TIME.
 * <br>
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the time
 * 
 * @parity YY
 * @since 18
 */
public abstract class Time
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Inheritance<K,V> 
			implements TimeListener<K,V> {
	
	/**
	 * -3653847222283301580L
	 */
	private static final long serialVersionUID = -3653847222283301580L;

	
    /**
     * {@link Time} default class constructor.
     */
    public Time() {
    	super();
    }
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Time(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Time(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param root the key
	 */
	protected Time(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param key the key
	 * @param value the value
	 */
    protected Time(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param parent the key
	 */
	protected Time(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param key the key
	 * @param value the value
	 */
    protected Time(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
		// set stem's future
		child.set(getKey());
		// set stem's past
		parent.set(value);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#injectKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	public void pushKey(MassListener sender, Tachyon<K,V> event) {
		// re-assign and check parent
		if(isPast()) {
			// turn back to the past
			tackKey(sender, event);
		}
		getParent().deliverKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#injectValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	public void pushValue(MassListener sender, Tachyon<V,K> event) {
		// re-assign and check parent
		if(isPast()) {
			// turn back to the past
			tackValue(sender, event);
		}
		getParent().deliverValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#submitValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void submitValue(MassListener sender, Tachyon<V,K> event) {
		// check future
		if(isFuture()) {
			// return to the past
			tickValue(sender, event);
		}
		// call recursion
		get().deliverKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#submitKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void submitKey(MassListener sender, Tachyon<K,V> event) {
		// re-assign and check parent
		if (isFuture()) {
			// pop key
			tickKey(sender, event);
		}
		// call recursion
		get().deliverValue(sender, event);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.PastCallable#pushKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
	public void injectKey(MassListener sender, Tachyon<K,V> event) {
		// re-assign and check child
		if (isPast()) {
			// flop and return to the future
			tackKey(sender, event);
		}
		// call recursion
		getChild().deliverValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#pushValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void injectValue(MassListener sender, Tachyon<V,K> event) {
		// re-assign and check child
		if(isPast()) {
			// flop and return to the future
			tackValue(sender, event);
		}
		// call recursion
		getChild().deliverKey(sender, event);
	}
}