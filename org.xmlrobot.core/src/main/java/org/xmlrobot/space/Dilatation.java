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
public abstract class Dilatation
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>> 
		extends Gravity<K,V>
			implements Positron<K,V> {

	/**
	 * -1881807377123462151L
	 */
	private static final long serialVersionUID = -1881807377123462151L;
	
    /**
     * {@link Dilatation} default class constructor.
     */
    public Dilatation() {
    	super();
    }
    /**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Dilatation(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
    /**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Dilatation(
    		Class<? extends Positron<K,V>> type, 
    	    Class<? extends Positron<V,K>> antitype, 
    		K key, V value, Parity gen) {
		super(type, antitype, key, value, gen);
	}
    /**
	 * {@link Dilatation} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param value the value
	 */
    protected Dilatation(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> root, 
    		Positron<V,K> stem) {
		super(type, key, value, root, stem);
	}
    /**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Dilatation(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> root, 
    		Positron<V,K> stem) {
		super(type, antitype, key, value, root, stem);
	}
    /**
	 * {@link Dilatation} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param value the value
	 */
    protected Dilatation(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> parent, 
    		Positron<V,K> child,
    		Parity gen) {
		super(type, key, value, parent, child, gen);
	}
    /**
	 * {@link Dilatation} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Dilatation(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> parent, 
    		Positron<V,K> child,
    		Parity gen) {
		super(type, antitype, key, value, parent, child, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeNegative(MassListener sender, Mass<V> event) {
		if(event.getSource() == getNegative()) {
			clear(sender);
    	}
    	else if(isEmpty()) {
    		return ;
    	}
    	else switch(getGen()) {
    	case XY:
			releaseNegative(sender, event);
			break;
		case XX:
			liberateNegative(sender, event);
			break;
		default:
			redeemNegative(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removePositive(MassListener sender, Mass<K> event) {
		if(event.getSource() == getPositive()) {
    		clear(sender);
    	}
    	else if(isEmpty()) {
    		return;
    	}
    	else switch (getGen()) {
		case XY:
			liberatePositive(sender, event);
			break;
		case XX:
			releasePositive(sender, event);
			break;
		default:
			redeemPositive(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check by equality
    	if(event.getSource() == getNegative()) {
    		if(antievent.getSource() == getPositive()) {
    			clear(sender);
    		}
    		else return;
    	}
    	else if(isEmpty()) {
    		return;
    		
    	}
    	else switch (getGen()) {
		case XY:
			liberateNegative(sender, event, antievent);
			break;
		case XX:
			releaseNegative(sender, event, antievent);
			break;
		default:
			redeemNegative(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#removePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removePositive(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check by equality
    	if(event.getSource() == getPositive()) {
    		if(antievent.getSource() == getNegative()) {
    			clear(sender);
    		}
    		else return;
    	}
    	else if(isPast()) {
    		return ;
    	}
    	else switch (getGen()) {
		case XY:
			releasePositive(sender, event, antievent);
			break;
		case XX:
			liberatePositive(sender, event, antievent);
			break;
		default:
			redeemPositive(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#removeByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void redeemPositive(MassListener sender, Mass<K> event) {
    	get().redeemNegative(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void redeemNegative(MassListener sender, Mass<V> event) {
		get().redeemPositive(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#removeByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void releasePositive(MassListener sender, Mass<K> event) {
    	get().redeemNegative(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void releaseNegative(MassListener sender, Mass<V> event) {
		get().redeemPositive(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#removeByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void liberatePositive(MassListener sender, Mass<K> event) {
		get().redeemNegative(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void liberateNegative(MassListener sender, Mass<V> event) {
		get().redeemPositive(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#removeByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void redeemPositive(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getParent().redeemPositive(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void redeemNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getParent().redeemNegative(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#removeByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void releasePositive(MassListener sender, Mass<K> event, Mass<V> antievent) {
		get().releaseNegative(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void releaseNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		get().releasePositive(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#removeByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void liberateNegative(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getChild().liberatePositive(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#removeByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public void liberatePositive(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getChild().redeemNegative(sender, event, antievent);
    }
}