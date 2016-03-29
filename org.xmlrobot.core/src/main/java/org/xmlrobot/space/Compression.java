/**
 * 
 */
package org.xmlrobot.space;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Congregation;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Compression
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>>
		extends Singularity<K,V> 
			implements Positron<K,V>{

	/**
	 * 7293262304322817772L
	 */
	private static final long serialVersionUID = 7293262304322817772L;

    /**
     * {@link Compression} default class constructor.
     */
    public Compression() {
    	super();
    }
    /**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Compression(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, Parity gen) {
		super(type, positive, negative, gen);
	}
    /**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Compression(
    		Class<? extends Positron<K,V>> type, 
    	    Positron<V,K> value, 
    		K positive, V negative, Parity gen) {
		super(type, value, positive, negative, gen);
	}
    /**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param root the key
	 */
    protected Compression(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, positive, negative, root, stem);
	}
    /**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Compression(
    		Class<? extends Positron<K,V>> type, 
    		Positron<V,K> value, 
    		K positive, V negative,  
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, value, positive, negative, root, stem);
	}
    /**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the key
	 */
    protected Compression(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, positive, negative, parent, child, gen);
	}
    /**
	 * {@link Compression} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Compression(
    		Class<? extends Positron<K,V>> type, 
    		Positron<V,K> value, K positive, V negative,
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, positive, negative, value, parent, child, gen);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setAllNegatives(org.xmlrobot.util.Congregation)
	 */
	@Override
	public void putAllNegatives(Congregation<Positron<K,V>> c) {
        for (Positron<K,V> p : c)
            putNegative(root(), new Mass<K>(p.getPositive()), new Mass<V>(p.getNegative()));
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setAllPositives(org.xmlrobot.util.Congregation)
	 */
	@Override
	public void putAllPositives(Congregation<Positron<V,K>> c) {
        for (Positron<V,K> e : c)
            putPositive(root(), new Mass<V>(e.getPositive()), new Mass<K>(e.getNegative()));
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		if (event.getSource() == getPositive()) {
			return;
		}
		// check future
		else if (isEmpty()) {
			putNegative(sender, event, antievent);
		}
		// call recursion
		else switch (getGen()) {
		case XY:
			updateNegativeIfAbsent(sender, event, antievent);
			break;
		case XX:
			assignNegativeIfAbsent(sender, event, antievent);
			break;
		default:
			setNegativeIfAbsent(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#setPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putPositiveIfAbsent(MassListener sender, Mass<V> event,
			Mass<K> antievent) {
		// check event existence
		if (event.getSource() == getNegative()) {
			return;
		}
		// check future
		else if (isEmpty()) {
			putPositive(sender, event, antievent);
		}
		// call recursion
		else switch (getGen()) {
		case XY:
			assignPositiveIfAbsent(sender, event, antievent);
			break;
		case XX:
			updatePositiveIfAbsent(sender, event, antievent);
			break;
		default:
			setPositiveIfAbsent(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#putNegativeIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public synchronized void assignNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		get().putPositiveIfAbsent(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#putPositiveIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public synchronized void assignPositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check event existence
		get().putNegativeIfAbsent(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#putNegativeIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public synchronized void setNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		getParent().putNegativeIfAbsent(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#putPositiveIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public synchronized void setPositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getParent().putPositiveIfAbsent(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#putNegativeIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public synchronized void updateNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent) {
		getChild().putPositiveIfAbsent(sender, event, antievent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#putPositiveIfAbsent(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public synchronized void updatePositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) {
		getChild().putNegativeIfAbsent(sender, event, antievent);
    }
}