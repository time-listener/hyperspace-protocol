/**
 * 
 */
package org.xmlrobot.object;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hypermath<K,V>
	extends Hyperclock<K,V> 
		implements Metatext<K,V> {
	
    /**
	 * 332240126552738906L
	 */
	private static final long serialVersionUID = 332240126552738906L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.object.Hypertext#span()
	 */
	@Override
	public AtomicInteger span() {
		return message.span();
	}
	
	/**
	 * {@link Hypermath} default class constructor.
	 */
	public Hypermath() {
		super();
	}
	/**
	 * {@link Hypermath} class constructor.
	 * @param type the type
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hypermath(
    		Class<? extends Metatext<K,V>> type, 
    		Class<K[]> fromType,
    		K from, V to,
    		Parity gen) {
		super(type, fromType, from, to, gen);
	}
	/**
	 * {@link Hypermath} class constructor.
	 * @param type the type
	 * @param antitype the antitype
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hypermath(
    		Class<? extends Metatext<K,V>> type, 
    	    Class<? extends Metatext<V,K>> antitype,
    		Class<K[]> fromType,
    		K from, V to,
    	    Parity gen) {
		super(type, antitype, fromType, from, to, gen);
	}
    /**
	 * {@link Hypermath} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hypermath(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to,
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, from, to, parent, child);
	}
    /**
	 * {@link Hypermath} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the negative
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hypermath(
    		Class<? extends Metatext<K,V>> type,
    	    Class<? extends Metatext<V,K>> antitype,
    		K from, V to,
    		Metatext<K,V> parent,
    		Metatext<V,K> child) {
		super(type, antitype, from, to, parent, child);
	}
    /**
	 * {@link Hypermath} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hypermath(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to,
    		Metatext<K,V> root, 
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, from, to, root, stem, gen);
	}
    /**
	 * {@link Hypermath} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hypermath(
    		Class<? extends Metatext<K,V>> type,
    	    Class<? extends Metatext<V,K>> antitype,
    		K from, V to,
    		Metatext<K,V> root,
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, antitype, from, to, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#indexOfTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger indexOfTo(MassListener sender, Mass<V> event) {
		if(event.getSource() == getTo()) {
			// start incrementing
			return new AtomicInteger(1);
		}
		else if(!isEmpty()) {
			// call recursion
			AtomicInteger order;

			switch (getGen()) {
			case XY:
				order = pointerOfTo(sender, event);
				break;
			case XX:
				order = positionOfTo(sender, event);
				break;
			default:
				order = orderOfTo(sender, event);
				break;
			}
			
			// negative it hasn't been found
			if(order.get() < 0)
				order.decrementAndGet();
			else
				order.incrementAndGet();
			// return result
			return order;
		}
		// start decrementing
		return new AtomicInteger(-1);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#indexOfFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger indexOfFrom(MassListener sender, Mass<K> event) {
		// check equality
		if(event.getSource() == getFrom()) {
			// start incrementing
			return new AtomicInteger(1);
		}
		else if(isEmpty()) {
			// start decrementing
			return new AtomicInteger(-1);	
		}
		else {
			// call recursion
			AtomicInteger order;

			switch (getGen()) {
			case XY:
				order = positionOfFrom(sender, event);
				break;
			case XX:
				order = pointerOfFrom(sender, event);
				break;
			default:
				order = orderOfFrom(sender, event);
				break;
			}
			// negative it hasn't been found
			if (order.get() < 0)
				order.decrementAndGet();
			else
				order.incrementAndGet();

			return order;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#lastIndexOfFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger lastIndexOfFrom(MassListener sender, Mass<V> event) {
		AtomicInteger N = depth(sender);
		N.addAndGet(-getValue().indexOfFrom(sender, event).get());
		return N;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#lastIndexOfTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public AtomicInteger lastIndexOfTo(MassListener sender, Mass<K> event) {
		AtomicInteger N = depth(sender);
		N.addAndGet(-getValue().indexOfTo(sender, event).get());
		return N;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#orderOfFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger orderOfFrom(MassListener sender, Mass<K> event) {
		// call recurrence
		return getParent().orderOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#orderOfTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger orderOfTo(MassListener sender, Mass<V> event) {
		// call recurrence
		return getParent().orderOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger pointerOfTo(MassListener sender, Mass<V> event) {
		// start decrementing
		return get().indexOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger pointerOfFrom(MassListener sender, Mass<K> event) {
		// start decrementing
		return get().indexOfTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger positionOfTo(MassListener sender, Mass<V> event) {
		// start decrementing
		return getChild().positionOfFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#indexOfTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public AtomicInteger positionOfFrom(MassListener sender, Mass<K> event) {
		// start decrementing
		return getChild().positionOfTo(sender, event);
	}
}