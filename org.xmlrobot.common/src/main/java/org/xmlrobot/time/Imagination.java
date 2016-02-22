/**
 * 
 */
package org.xmlrobot.time;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * There are times, when I find myself transfixed 
 * by a shadow on the wall, or the splashing of water 
 * against a stone. I stare at it, the hours pass, 
 * the world around me drops away, replaced by worlds 
 * being created and destroyed by my imagination. 
 * <p> A way to focus the mind.
 * @author Leonardo Da Vinci
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 14
 */
@XmlTransient
public abstract class Imagination
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Caos<K,V> {

	/**
	 * 1206561669055048643L
	 */
	private static final long serialVersionUID = 1206561669055048643L;
	
    /**
     * {@link Imagination} default class constructor.
     */
    public Imagination() {
    	super();
    }
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Imagination(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    protected Imagination(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Imagination(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	
	/* (non-Javadoc)
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	@Override
	public synchronized boolean add(K e) {

		switch (getGen()) {
		case YY:
			return submit(e);
		default:
			return order(e);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#order(org.xmlrobot.genesis.Pair)
	 */
	public synchronized boolean order(K listener) {
		// verify listener's existence
		if(listener == null)
			return false;
		// nullify listener's inheritance
		listener.setParent(null);
		listener.setChild(null);
		// declare child
		K child;
		// verify child's existence
		if((child = getChild()) != null) {
			// disconnect child from root. I.e, from current instance.
			child.setParent(null);
			setChild(null);
			// commute by parity
			switch (getGen()) 
			{
			case XY:
				// screw instances will remain 
				// in DESCENDING ORDER
				child = child.orderInfer(listener);			
				break;
			default:
				// screw nut instances will remain 
				// in ASCENDING ORDER
				child = child.orderSuper(listener);
				break;
			}
			// re-assign inheritance
			setChild(child);
			child.setParent(call());
			return true;
		}
		else {
			// submit listener as new child
			setChild(listener);
			listener.setParent(call());
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#spin()
	 */
	public synchronized void spin() {
		// declare child
		K child;
		// check and retrieve child
		if((child = getChild()) != null) {
			// disconnect inheritance from root
			child.setParent(null);
			setChild(null);
			// commute by parity
			switch (getGen()) 
			{
			case XY:
				// screw does like gravity
				child = child.rotate();
				break;
			case XX:
				// screw nut comes to change the world
				child = child.revolve();
				break;
			default:
				// abstract instances get mixed like a fishes bank.
				child = child.permute(child.depth());
				break;
			}
			// re-assign inheritance
			child.setParent(call());
			setChild(child);	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#release()
	 */
	public synchronized K release() {
		// declare child
		K child;
		// verify child's existence
		if ((child = getChild()) != null) {
			// disconnect child from parent. I.e, from current instance.
			child.setParent(null);
			setChild(null);
			// commute by parity
			switch (getGen()) {
			case XY:
				// set listener as new future
				child = child.releaseChild();
				break;
			default:
				// set listener as new past
				child = child.releaseParent();
				break;
			}
			// re-assign inheritance
			setChild(child);
			child.setParent(call());
		}
		return child;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submit(org.xmlrobot.genesis.Pair)
	 */
	public synchronized boolean submit(K listener) {
		// verify listener's existence
		if(listener == null)
			return false;
		// declare child
		K child;
		// verify child's existence
		if((child = getChild()) != null) {
			// disconnect child from parent. I.e, from current instance.
			child.setParent(null);
			setChild(null);
			// commute by parity
			switch (getGen()) 
			{
			case XY:
				// set listener as new future
				child = child.submitChild(listener);			
				break;
			default:
				// set listener as new past
				child = child.submitParent(listener);
				break;
			}
			// re-assign inheritance
			setChild(child);
			child.setParent(getType().cast(this));
		}
		else {
			// submit listener as new child
			setChild(listener);
			listener.setParent(call());
		}
		return true;
	}
}