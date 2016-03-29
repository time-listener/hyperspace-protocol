/**
 * 
 */
package org.xmlrobot.space;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Imperative;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Attraction
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>> 
		extends Compression<K,V>
			implements Positron<K,V> {

	/**
	 * -1989484839105502373L
	 */
	private static final long serialVersionUID = -1989484839105502373L;

    /**
     * {@link Attraction} default class constructor.
     */
    public Attraction() {
    	super();
    }
    /**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Attraction(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, Parity gen) {
		super(type, positive, negative, gen);
	}
    /**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Attraction(
    		Class<? extends Positron<K,V>> type, 
    	    Positron<V,K> value, 
    		K positive, V negative, Parity gen) {
		super(type, value, positive, negative, gen);
	}
    /**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param root the key
	 */
    protected Attraction(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> root, Positron<V, K> stem) {
		super(type, positive, negative, root, stem);
	}
    /**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Attraction(
    		Class<? extends Positron<K,V>> type, 
    	    Positron<V,K> value, 
    		K positive, V negative, 
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, value, positive, negative, root, stem);
	}
    /**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the key
	 */
    protected Attraction(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> parent, Positron<V, K> child, Parity gen) {
		super(type, positive, negative, parent, child, gen);
	}
    /**
	 * {@link Attraction} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Attraction(
    		Class<? extends Positron<K,V>> type, 
    		Positron<V,K> value, K positive, V negative,
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, value, positive, negative, parent, child, gen);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#containsPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public boolean containsPositive(MassListener sender, Mass<K> event) {
		// check contained
		if(event.getSource() == getPositive()) {
			return true;
		}
		else if(isEmpty()) {
			return false;
		}
		else switch (getGen()) {
		case XY:
			return holdsPositive(sender, event);
		case XX:
			return belongsPositive(sender, event);
		default:
			return hasPositive(sender, event);
		}
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#containsNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public boolean containsNegative(MassListener sender, Mass<V> event) {
		// check contained
		if(event.getSource() == getNegative()) {
			return true;
		}
		else if(isFuture()) {
			return false;
		}
		else switch (getGen()) {
		case XY:
			return belongsNegative(sender, event);
		case XX:
			return holdsNegative(sender, event);
		default:
			return hasNegative(sender, event);
		}
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#hasPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean hasPositive(MassListener sender, Mass<K> event) {
		return getParent().hasPositive(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#hasNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public boolean hasNegative(MassListener sender, Mass<V> event) {
		return getParent().hasNegative(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#holdsNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean holdsNegative(MassListener sender, Mass<V> event) {
		return get().containsPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#holdsPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean holdsPositive(MassListener sender, Mass<K> event) {
		return get().containsNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#belongsPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean belongsPositive(MassListener sender, Mass<K> event) {
		return getChild().belongsNegative(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#belongsNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public boolean belongsNegative(MassListener sender, Mass<V> event) {
		return getChild().belongsPositive(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#forEachPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
    public void fromEachPositive(MassListener sender, Imperative<K,V> event) {
        // concurrent propagation
        get().forEachNegative(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forEachNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEachNegative(MassListener sender, Imperative<V,K> event) {
		// accept concurrently to the last child of evolution
		event.accept(getNegative(), getPositive());
		// check emptiness
		if(!isEmpty()) {
			switch (getGen()) {
			case XY:
				fromEachNegative(sender, event);
				break;
			case XX:
				forEveryNegative(sender, event);
				break;
			default:
				forAllNegative(sender, event);
				break;
			}	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forEachPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
	public void forEachPositive(MassListener sender, Imperative<K,V> event) {
    	// accept concurrently to the last child of evolution
		event.accept(getPositive(), getNegative());
		// check emptiness
        if(!isEmpty()) {
        	switch (getGen()) {
    		case XY:
    			forEveryPositive(sender, event);
    			break;
    		case XX:
    			fromEachPositive(sender, event);
    			break;
    		default:
    			forAllPositive(sender, event);
    			break;
    		}
        }
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#forEachNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
    public void fromEachNegative(MassListener sender, Imperative<V,K> event) {
		 // concurrent propagation
		get().forEachPositive(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#forEveryPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
    public void forEveryPositive(MassListener sender, Imperative<K,V> event) {
    	// concurrent propagation
        getChild().forEachNegative(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.CallableMass#forEveryNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
    public void forEveryNegative(MassListener sender, Imperative<V,K> event) {
		// concurrent propagation
        getChild().forEachPositive(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forAllPositive(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
    public void forAllPositive(MassListener sender, Imperative<K,V> event) {
    	// recurrent propagation
        getParent().forEachPositive(root(), event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#forAllNegative(org.xmlrobot.MassListener, org.xmlrobot.util.Imperative)
	 */
	@Override
    public void forAllNegative(MassListener sender, Imperative<V,K> event) {
		// recurrent propagation
		getParent().forEachNegative(root(), event);
    }
}
