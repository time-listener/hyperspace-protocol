/**
 * 
 */
package org.xmlrobot.time;

import java.util.Iterator;
import java.util.Objects;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * Democracy implementation class.
 * 
 * Why don't we define this term collectively?
 * 
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 11
 */
@XmlTransient
public abstract class Democracy
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Freedom<K,V> {
	/**
	 * 8541717449385538047L
	 */
	private static final long serialVersionUID = 8541717449385538047L;

    /**
     * {@link Democracy} default class constructor.
     */
    public Democracy() {
    	super();
    }
	/**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Democracy(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    protected Democracy(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Democracy(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#delve(int)
	 */
	public synchronized int delve(int counter) {
		return isEmpty() ? ++counter : getChild().delve(++counter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getDepth()
	 */
	@Override
	public synchronized int depth() {
		return !isEmpty() ? getChild().delve(0) : 0;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#size()
	 */
	@Override
	public int size() {
		return depth();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#collect(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public synchronized Congregation<K> collect(Congregation<K> entities) {
		// add current instance to allocated congregation
		entities.add(getType().cast(this));
		// check if we are the future
		if(!isEmpty()) {
			// call concurrently
			return getChild().collect(entities);
		}
		else {
			// turn back result
			return entities;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#call(int)
	 */
	public synchronized K call(int N) {
		return N <= 0 ? call() : !isEmpty() ? getChild().call(--N) : null;
	}
    /**
     * {@inheritDoc}
     * <p>This implementation iterates over the specified congregation,
     * checking each element returned by the iterator in turn to see
     * if it's contained in this congregation.  If all elements are so
     * contained <tt>true</tt> is returned, otherwise <tt>false</tt>.
     *
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @see #contains(Object)
     */
    public boolean containsAll(K c) {
        for (K e : c)
            if (!contains(e))
                return false;
        return true;
    }
    /**
     * {@inheritDoc}
     * <p>This implementation iterates over the specified collection, and adds
     * each object returned by the iterator to this collection, in turn.
     *
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> unless <tt>add</tt> is
     * overridden (assuming the specified collection is non-empty).
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IllegalStateException         {@inheritDoc}
     *
     * @see #add(Object)
     */
    public boolean addAll(K c) {
        boolean modified = false;
        for (K e : c)
            if (add(e))
                modified = true;
        return modified;
    }
    /**
     * {@inheritDoc}
     * <p>This implementation iterates over this collection, checking each
     * element returned by the iterator in turn to see if it's contained
     * in the specified collection.  If it's not so contained, it's removed
     * from this collection with the iterator's <tt>remove</tt> method.
     *
     * <p>Note that this implementation will throw an
     * <tt>UnsupportedOperationException</tt> if the iterator returned by the
     * <tt>iterator</tt> method does not implement the <tt>remove</tt> method
     * and this collection contains one or more elements not present in the
     * specified collection.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     *
     * @see #remove(Object)
     * @see #contains(Object)
     */
    public boolean retainAll(K c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<K> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

}