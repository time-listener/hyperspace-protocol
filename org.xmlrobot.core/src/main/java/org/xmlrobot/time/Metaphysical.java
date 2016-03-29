/**
 * 
 */
package org.xmlrobot.time;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Mataphysical layer class.
 * 
 * <p> Programmatic philosophy, or maybe, the physics of ideas.
 * 
 * <p> Metaphysics is a programmatic philosophy that examines the 
 * nature of reality including relationships between the mind, 
 * matter and antimatter. It can also deal with onirics programming.
 * Or physics of ideas.
 * 
 * <p> When one's imagination cannot provide an answer, one must seek 
 * out a greater imagination. There are times when even I find myself 
 * kneeling in prayer. 
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 16
 */
public abstract class Metaphysical
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Further<K,V>
			implements TimeListener<K,V> {

	/**
	 * 5697033858767605254L
	 */
	private static final long serialVersionUID = 5697033858767605254L;
	
    /**
     * {@link Metaphysical} default class constructor.
     */
    public Metaphysical() {
    	super();
    }
	/**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Metaphysical(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Metaphysical(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Metaphysical(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
    protected Metaphysical(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param root the parent
	 * @param stem the child
	 */
	protected Metaphysical(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Metaphysical} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the parent
	 * @param stem the child
	 */
    protected Metaphysical(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}
    
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.MassListener#depth()
     */
    @Override
    public AtomicInteger depth(MassListener sender) {
    	return recurrence(sender, concurrence(sender, new AtomicInteger(1)));
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#getFutureValue(org.xmlrobot.TimeListener)
	 */
	@Override
	@XmlTransient
	public synchronized Tachyon<V,K> getFutureValue(MassListener sender) {
		return !isFuture() ? get().getFutureKey(sender) : newFlop();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#getFutureKey(org.xmlrobot.TimeListener)
	 */
	@Override
	@XmlTransient
	public synchronized Tachyon<K,V> getFutureKey(MassListener sender) {
		return !isFuture() ? get().getFutureValue(sender) : newInstant();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callPastKey(org.xmlrobot.TimeListener)
	 */
	@Override
	public synchronized Tachyon<K,V> callPastKey(MassListener sender) {
		return isPast() ? newInstant() : getParent().callPastKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callPastValue(org.xmlrobot.TimeListener)
	 */
	@Override
	public synchronized Tachyon<V,K> callPastValue(MassListener sender) {
		return isPast() ? newFlop() : getParent().callPastValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Enumerable#enumerator()
	 */
	@Override
	public Enumeration<V> enumerator() {
		switch (getGen()) {
		case XY:
			return new FutureEnumerator(getValue());
		default:
			return new PastEnumerator(getValue());
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<K> iterator() {
		switch (getGen()) 
		{
		case XY:
			return new PastIterator(getKey());
		default:
			return new FutureIterator(getKey());
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#pointerOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger indexOfKey(MassListener sender, Tachyon<K,V> event) {
		if(event.getKey() == getKey()) {
			// start incrementing
			return new AtomicInteger(1);
		}
		else if(!isPast()) {
			// declare order
			AtomicInteger order;
			// commute by gender type
			switch (getGen()) {
			case XY:
				order = pointerOfKey(sender, event);
			case XX:
				order = positionOfKey(sender, event);
			default:
				order = orderOfKey(sender, event);
			}
			// check result
			if(order.get() < 0)
				// it hasn't been found
				order.decrementAndGet();
			else
				// it has been found
				order.incrementAndGet();
			// return order
			return order;
		}
		// start decrementing
		return new AtomicInteger(-1);
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#pointerOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger indexOfValue(MassListener sender, Tachyon<V,K> event) {
		if(event.getKey() == getKey()) {
			// start incrementing
			return new AtomicInteger(1);
		}
		else if(!isPast()) {
			// call recursion
			AtomicInteger order;

			switch (getGen()) {
			case XY:
				order = positionOfValue(sender, event);
			case XX:
				order = pointerOfValue(sender, event);
			default:
				order = orderOfValue(sender, event);
			}
			// negative it hasn't been found
			if(order.get() < 0)
				order.decrementAndGet();
			else
				order.incrementAndGet();
			
			return order;
		}
		// start decrementing
		return new AtomicInteger(-1);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#positionOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger positionOfKey(MassListener sender, Tachyon<K,V> event) {
		// call recursion
		return getChild().indexOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#positionOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger positionOfValue(MassListener sender, Tachyon<V,K> event) {
		// call recursion
		return getChild().indexOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Order#orderOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger orderOfKey(MassListener sender, Tachyon<K,V> event) {
		// call recursion
		return getParent().indexOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#orderOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger orderOfValue(MassListener sender, Tachyon<V,K> event) {
		// call recursion
		return getParent().indexOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#pointerOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger pointerOfKey(MassListener sender, Tachyon<K,V> event) {
		// call recursion
		return get().indexOfValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#pointerOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger pointerOfValue(MassListener sender, Tachyon<V,K> event) {
		// call recursion
		return get().indexOfKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#lastIndexOfKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger lastIndexOfKey(MassListener sender, Tachyon<K,V> event) {
		AtomicInteger N = depth(sender);
		N.addAndGet(-getValue().indexOfValue(sender, event).get());
		return N;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#lastIndexOfValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public AtomicInteger lastIndexOfValue(MassListener sender, Tachyon<V,K> event) {
		AtomicInteger N = depth(sender);
		N.addAndGet(-getValue().indexOfKey(sender, event).get());
		return N;
	}
}