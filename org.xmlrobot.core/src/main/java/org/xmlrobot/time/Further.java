/**
 * 
 */
package org.xmlrobot.time;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * From further to the hyperspace.
 *  
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 15
 */
public abstract class Further 
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Imagination<K,V>
			implements TimeListener<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2184821261241766530L;

    /**
     * {@link Further} default class constructor.
     */
    public Further() {
    	super();
    }
	/**
	 * {@link Further} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Further(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Further} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Further(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Further} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Further(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Further} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
    protected Further(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Further} class constructor.
	 * @param type the type
	 * @param root the parent
	 * @param stem the child
	 */
	protected Further(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Further} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the parent
	 * @param stem the child
	 */
    protected Further(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeKey(org.xmlrobot.TimeListener)
	 */
	@Override
	public void removeKey(MassListener sender) {
		// assign and check
		if (isEmpty()) {
			// free
			clear(sender);
		}
		// commute by parity
		switch (getGen()) {
		case XY:
			releaseKey(sender);
			break;
		case XX:
			liberateKey(sender);
			break;
		default:
			redeemKey(sender);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeValue(org.xmlrobot.TimeListener)
	 */
	@Override
	public void removeValue(MassListener sender) {
		// assign and check
		if (isEmpty()) {
			// clear current instance
			clear(sender);
		}
		// commute by parity
		else switch (getGen()) {
		case XY:
			liberateValue(sender);
			break;
		case XX:
			releaseValue(sender);
			break;
		default:
			redeemValue(sender);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#releaseParent()
	 */
	@Override
	public synchronized void releaseKey(MassListener sender) {
		// call recurrent recursion
		get().removeValue(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#releaseChild()
	 */
	@Override
	public synchronized void releaseValue(MassListener sender) {
		// call concurrent recursion
		get().removeKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#removeKey()
	 */
	@Override
	public synchronized void redeemKey(MassListener sender) {
		// call recurrent recursion
		getParent().removeKey(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#removeValue()
	 */
	@Override
	public synchronized void redeemValue(MassListener sender) {
		// call recurrent recursion
		getParent().removeValue(sender);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#redeemKey(org.xmlrobot.TimeListener)
     */
    @Override
	public synchronized void liberateKey(MassListener sender) {
		// call recurrent recursion
		getChild().removeValue(sender);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#redeemValue(org.xmlrobot.TimeListener)
     */
    @Override
	public synchronized void liberateValue(MassListener sender) {
		// call recurrent recursion
		getChild().removeKey(sender);
	}
}