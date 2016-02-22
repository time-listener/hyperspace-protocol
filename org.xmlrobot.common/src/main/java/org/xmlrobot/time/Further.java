/**
 * 
 */
package org.xmlrobot.time;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * From further to the hyperspace.
 *  
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 15
 */
@XmlTransient
public abstract class Further
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Imagination<K,V> {

	/**
	 * -3130094331480663355L
	 */
	private static final long serialVersionUID = -3130094331480663355L;
	
	
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
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Further(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#releaseFuture()
	 */
	@Override
	public synchronized K releaseChild() {
		// declare child
		K child;
		// assign and check
		if((child = getChild()) == null) {
			// declare parent
			K parent;
			// assign and check
			if((parent = getParent()) != null) {
				// update inheritance
				parent.setChild(null);
				// return parent of inheritance
				return parent.getPast();
			}
			else {
				// everything released
				return null;
			}
		}
		// call concurrent recursion
		else return child.releaseChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#releasePast()
	 */
	@Override
	public synchronized K releaseParent() {
		// declare parent
		K parent;
		// assign and check
		if((parent = getParent()) == null) {
			// declare child
			K child;
			// assign and check
			if((child = getChild()) != null) {
				// update inheritance
				setChild(null);
				child.setParent(null);
				// return new parent
				return child;
			}
			// nothing to release
			else return null;	
		}
		// call recurrent recursion
		else return parent.releaseParent();
	}
}