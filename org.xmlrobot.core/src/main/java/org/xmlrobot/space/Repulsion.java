/**
 * 
 */
package org.xmlrobot.space;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Parity;
import org.xmlrobot.util.Commandment;

/**
 * @author joan
 *
 */
public abstract class Repulsion
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>> 
		extends Dilatation<K,V>
			implements Positron<K,V> {

	/**
	 * 2677857047197236447L
	 */
	private static final long serialVersionUID = 2677857047197236447L;

    /**
     * {@link Repulsion} default class constructor.
     */
    public Repulsion() {
    	super();
    }
    /**
	 * {@link Repulsion} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Repulsion(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
    /**
	 * {@link Repulsion} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Repulsion(
    		Class<? extends Positron<K,V>> type, 
    	    Class<? extends Positron<V,K>> antitype, 
    		K key, V value, Parity gen) {
		super(type, antitype, key, value, gen);
	}
    /**
	 * {@link Repulsion} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param value the value
	 */
    protected Repulsion(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> root,
    		Positron<V,K> stem) {
		super(type, key, value, root, stem);
	}
    /**
	 * {@link Repulsion} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Repulsion(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> root, 
    		Positron<V,K> stem) {
		super(type, antitype, key, value, root, stem);
	}
    /**
	 * {@link Repulsion} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param value the value
	 */
    protected Repulsion(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> parent,
    		Positron<V,K> child,
    		Parity gen) {
		super(type, key, value, parent, child, gen);
	}
    /**
	 * {@link Repulsion} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Repulsion(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> parent, 
    		Positron<V,K> child,
    		Parity gen) {
		super(type, antitype, key, value, parent, child, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void replaceAllNegatives(MassListener sender, Commandment<K, V> event) {
		// obey commandment
		setNegative(event.apply(getPositive(), getNegative()));
		// check emptiness
		if(!isEmpty()) {
			// commute by parity
			switch (getGen()) {
			case XY:
				reassignAllNegatives(sender, event);
				break;
			case XX:
				restoreAllNegatives(sender, event);
				break;
			default:
				relocateAllNegatives(sender, event);
				break;
			}	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void replaceAllPositives(MassListener sender, Commandment<V,K> event) {
		// apply unification function
		setPositive(event.apply(getNegative(), getPositive()));
		// check emptiness
		if(!isEmpty()) {
			// commute by parity
			switch (getGen()) {
			case XY:
				restoreAllPositives(sender, event);
				break;
			case XX:
				reassignAllPositives(sender, event);
				break;
			default:
				relocateAllPositives(sender, event);
				break;
			}	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replaceNegative(MassListener sender, Mass<K> event, Mass<V> antievent) {
		if(event.getSource() == getPositive()) {
			// update negative
    		data.getAndSet(Positron.NEGATIVE, antievent.getSource());
    	}
    	else if(!isEmpty()) {
    		return;
    	}
    	else switch (getGen()) {
		case XY:
			restoreNegative(sender, event, antievent);
			break;
		case XX:
			reassignNegative(sender, event, antievent);
			break;
		default:
			relocateNegative(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replacePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replacePositive(MassListener sender, Mass<V> event,	Mass<K> antievent) {
		if(event.getSource() == getNegative()) {
			// update negative
    		data.getAndSet(Positron.POSITIVE, antievent.getSource());
    	}
    	else if(!isEmpty()) {
    		return;
    	}
    	else switch (getGen()) {
		case XY:
			reassignPositive(sender, event, antievent);
			break;
		case XX:
			restorePositive(sender, event, antievent);
			break;
		default:
			relocatePositive(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replaceNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replaceNegative(MassListener sender, Mass<K> event,
			Mass<V> oldAntievent, Mass<V> newAntievent) {
		// check by positive
		if (event.getSource() == getPositive()) {
			// compare and set negatives
			data.compareAndSet(Positron.NEGATIVE, 
					oldAntievent.getSource(), newAntievent.getSource());
		}
		else if (isEmpty()) {
			return;
		}
		else switch (getGen()) {
		case XY:
			reassignNegative(sender, event, oldAntievent, newAntievent);
			break;
		case XX:
			restoreNegative(sender, event, oldAntievent, newAntievent);
			break;
		default:
			relocateNegative(sender, event, oldAntievent, newAntievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#replacePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void replacePositive(MassListener sender, Mass<V> event,
			Mass<K> oldAntievent, Mass<K> newAntievent) {
		if(event.getSource() == getNegative()) {
			// compare and set positive
    		data.compareAndSet(Positron.POSITIVE, 
    				oldAntievent.getSource(), newAntievent.getSource());
    	}
    	else if(isEmpty()) {
    		return;
    	}
    	else switch (getGen()) {
		case XY:
			restorePositive(sender, event, oldAntievent, newAntievent);
			break;
		case XX:
			reassignPositive(sender, event, oldAntievent, newAntievent);
			break;
		default:
			relocatePositive(sender, event, oldAntievent, newAntievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#restorePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void restorePositive(MassListener sender, Mass<V> event, Mass<K> oldAntievent, Mass<K> newAntievent) {
    	getChild().replaceNegative(sender, event, oldAntievent, newAntievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#restoreNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void restoreNegative(MassListener sender, Mass<K> event, Mass<V> oldAntievent, Mass<V> newAntievent) {
    	getChild().replacePositive(sender, event, oldAntievent, newAntievent);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#relocateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void relocateNegative(MassListener sender, Mass<K> event, Mass<V> oldAntievent, Mass<V> newAntievent) {
    	getParent().replaceNegative(sender, event, oldAntievent, newAntievent);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#relocatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void relocatePositive(MassListener sender, Mass<V> event, Mass<K> oldAntievent, Mass<K> newAntievent) {
		getParent().replacePositive(sender, event, oldAntievent, newAntievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#reassignNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void reassignNegative(MassListener sender, Mass<K> event, Mass<V> oldAntievent, Mass<V> newAntievent) {
    	get().replacePositive(sender, event, oldAntievent, newAntievent);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#reassignPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void reassignPositive(MassListener sender, Mass<V> event, Mass<K> oldAntievent, Mass<K> newAntievent) {
    	get().replaceNegative(sender, event, oldAntievent, newAntievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#restoreNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void restoreNegative(MassListener sender, Mass<K> event, Mass<V> value) {
    	getChild().replacePositive(sender, event, value);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#restorePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void restorePositive(MassListener sender, Mass<V> event, Mass<K> key) {
		getChild().replaceNegative(sender, event, key);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#relocateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void relocateNegative(MassListener sender, Mass<K> event, Mass<V> value) {
    	getParent().replaceNegative(sender, event, value);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#relocatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void relocatePositive(MassListener sender, Mass<V> event, Mass<K> key) {
		getParent().replacePositive(sender, event, key);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#reassignNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void reassignNegative(MassListener sender, Mass<K> event, Mass<V> value) {
    	get().replacePositive(sender, event, value);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#reassignPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
    public void reassignPositive(MassListener sender, Mass<V> event, Mass<K> key) {
		get().replaceNegative(sender, event, key);;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#restoreAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
    public void restoreAllPositives(MassListener sender, Commandment<V,K> function) {
		getChild().replaceAllNegatives(sender, function);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#restoreAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void restoreAllNegatives(MassListener sender, Commandment<K,V> function) {
		getChild().replaceAllPositives(sender, function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#relocateAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
    public void relocateAllPositives(MassListener sender, Commandment<V,K> function) {
		getParent().replaceAllPositives(sender, function);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#relocateAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void relocateAllNegatives(MassListener sender, Commandment<K,V> function) {
		getParent().replaceAllNegatives(sender, function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#reassignAllNegatives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void reassignAllNegatives(MassListener sender, Commandment<K,V> function) {
		get().replaceAllPositives(sender, function);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#reassignAllPositives(org.xmlrobot.MassListener, org.xmlrobot.util.Commandment)
	 */
	@Override
    public void reassignAllPositives(MassListener sender, Commandment<V,K> function) {
		get().replaceAllNegatives(sender, function);
    }
}