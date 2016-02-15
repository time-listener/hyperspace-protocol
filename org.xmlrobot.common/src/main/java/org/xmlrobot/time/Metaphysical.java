/**
 * 
 */
package org.xmlrobot.time;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * Mataphysical layer class.
 * 
 * <p> Programmatic philosophy, or maybe, the physics of ideas.
 * 
 * <p> Metaphysics is a programmatic philosophy that examines the 
 * nature of reality including relationships between the mind and 
 * matter. It can also deal with onirics programming.
 * 
 * <p> When one's imagination cannot provide an answer, one must seek 
 * out a greater imagination. There are times when even I find myself 
 * kneeling in prayer. 
 * 
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 16
 */
@XmlTransient
public abstract class Metaphysical
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Further<K,V> {
	
	/**
	 * -6819264682037012460L
	 */
	private static final long serialVersionUID = -6819264682037012460L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getFuture()
	 */
	@Override
	public K getFuture() {
		K child = getChild();
		return child != null ? child.getFuture() : call();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getPast()
	 */
	@Override
	public K getPast() {
		K parent = getParent();
		return parent != null ? parent.getPast() : call();
	}
	
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
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Metaphysical(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderChild(java.lang.Object)
	 */
	public synchronized K submitChild(K listener) {
		// declare child
		K child;
		// re-assign and check child
		if((child = getChild()) == null) {
			// update inheritance
			listener.setParent(call());
			setChild(listener);
			// return the current parent of inheritance
			return getPast();	
		}
		// call recursion
		else return child.submitChild(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#orderParent(org.xmlrobot.genesis.TimeListener)
	 */
	public synchronized K submitParent(K listener) {
		// declare parent of inheritance
		K parent;
		// re-assign and check parent
		if((parent = getParent()) != null) {
			// set inheritance
			parent.setChild(listener);
			listener.setParent(parent);
		}
		// update inheritance
		setParent(listener);
		listener.setChild(getType().cast(this));
		// return the current parent
		return getPast();
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Congregation#submitAll(java.lang.Object)
     */
    public boolean submitAll(K c) {
    	boolean modified = false;
        for (K e : c)
        	if(submit(e))
        		modified = true;
        return modified;
    }
    /**
     * Iterator of the future implementation class.
     * Iterates over time concurrently to the future.
     * <br<br>
     * @author joan
     *
     */
    protected class FutureIterator
    	<T extends Congregation<T>> 
    		implements Iterator<T> {

    	T current;
    	T next;
    	int index;
    	/**
    	 * 
    	 */
    	public FutureIterator(T entry) {
    		current = next = entry;
    	}

    	/* (non-Javadoc)
    	 * @see java.util.Iterator#hasNext()
    	 */
    	@Override
    	public boolean hasNext() {
    		return next != null;
    	}

    	/* (non-Javadoc)
    	 * @see java.util.Iterator#next()
    	 */
    	@Override
    	public T next() {
    		return this.nextListener();
    	}
    	/**
    	 * @return the next future gear
    	 */
    	final T nextListener() {
    		T g = next;

    		if (g == null) {
    			if (current == null) {
    				throw new NoSuchElementException();
    			}
    		} 
    		else {
    			current = g;
    			next = g.getChild();
    		}
    		return g;
    	}
    }
    /**
     * Iterator of the past implementation class.
     * Iterates through time recurrently to the past.
     * @author joan
     *
     */
    protected class PastIterator
    	<T extends Congregation<T>> 
    		implements Iterator<T> {
    	
    	T current;
    	T prev;
    	int index;
    	/**
    	 * 
    	 */
    	public PastIterator(T entry) {
    		current = prev = entry;
    	}
    	/*
    	 * (non-Javadoc)
    	 * @see java.util.Iterator#hasNext()
    	 */
    	@Override
    	public boolean hasNext() {
    		return prev != null;
    	}
    	/*
    	 * (non-Javadoc)
    	 * @see java.util.Iterator#next()
    	 */
    	@Override
    	public T next() {
    		return this.previousListener();
    	}
    	/**
    	 * @return the next future gear
    	 */
    	final T previousListener() {
    		T g = prev;

    		if (g == null) {
    			if (current == null) {
    				throw new NoSuchElementException();
    			}
    		} 
    		else {
    			current = g;
    			prev = g.getParent();
    		}
    		return g;
    	}
    }
}