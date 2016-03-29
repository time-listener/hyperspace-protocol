/**
 * 
 */
package org.xmlrobot.space;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Contraction
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>>
		extends Attraction<K,V> 
			implements Positron<K,V> {

	/**
	 * 1617909715965556007L
	 */
	private static final long serialVersionUID = 1617909715965556007L;

    /**
     * {@link Contraction} default class constructor.
     */
    public Contraction() {
    	super();
    }
    /**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Contraction(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, Parity gen) {
		super(type, positive, negative, gen);
	}
    /**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Contraction(
    		Class<? extends Positron<K,V>> type, 
    	    Positron<V,K> value, 
    		K positive, V negative, Parity gen) {
		super(type, value, positive, negative, gen);
	}
    /**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param root the key
	 */
    protected Contraction(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, positive, negative, root, stem);
	}
    /**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Contraction(
    		Class<? extends Positron<K,V>> type, 
    		Positron<V,K> value, K positive, V negative,  
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, value, positive, negative, root, stem);
	}
    /**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the key
	 */
    protected Contraction(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, positive, negative, parent, child, gen);
	}
    /**
	 * {@link Contraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Contraction(Class<? extends Positron<K,V>> type, 
    		Positron<V,K> value, K positive, V negative, 
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, value, positive, negative, parent, child, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putNegative(MassListener sender, Mass<K> event,
			Mass<V> antievent) {
		switch (getGen()) {
		case XY:
			assignNegative(sender, event, antievent);
			break;
		case XX:
			updateNegative(sender, event, antievent);
			break;
		default:
			setNegative(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putPositive(MassListener sender, Mass<V> event,
			Mass<K> antievent) {
		switch (getGen()) {
		case XY:
			updatePositive(sender, event, antievent);
			break;
		case XX:
			assignPositive(sender, event, antievent);
			break;
		default:
			setPositive(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public synchronized void assignNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		if (event.getSource() == getPositive()) {
			setNegative(antievent.getSource());
		} 
		else if (isFuture()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					antievent.getSource(), event.getSource(), 
					getValue(), getKey(), Parity.opposite(getGen()));
		}
		// call recursion
		else get().assignPositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public synchronized void assignPositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check event existence
		if (event.getSource() == getNegative()) {
			setPositive(antievent.getSource());
		}
		// check future
		else if (isFuture()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getValue(), getKey(), Parity.opposite(getGen()));
		}
		// call recursion
		else get().assignNegative(sender, event, antievent);
		
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public synchronized void setNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		if (event.getSource() == getPositive()) {
			setNegative(antievent.getSource());
		}
		else if (isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getChild(), getParent(), Parity.opposite(getGen()));
		}
		// call recursion
		else getParent().assignNegative(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public synchronized void setPositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check event existence
		if (event.getSource() == getNegative()) {
			setPositive(antievent.getSource());
		}
		// check future
		else if (isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getChild(), getParent(), Parity.opposite(getGen()));
		}
		// call recursion
		else getParent().assignPositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#updateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public synchronized void updateNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		if(event.getSource() == getPositive()) {
			setNegative(antievent.getSource());
		}
		else if(isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getChild(), getParent(), Parity.opposite(getGen()));
		}
		// call recursion
		else getChild().updatePositive(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#updatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public synchronized void updatePositive(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check event existence
		if(event.getSource() == getNegative()) {
			setPositive(antievent.getSource());
		}
		// check future
		else if(isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getChild(), getParent(), Parity.opposite(getGen()));
		}
		// call recursion
		else getChild().updateNegative(sender, event, antievent);
	}
}