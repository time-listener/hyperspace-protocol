/**
 * 
 */
package org.xmlrobot.object;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hyperhead<K,V>
	extends Hypertext<K,V> 
		implements Metatext<K,V> {

	/**
	 * 690490214636168164L
	 */
	private static final long serialVersionUID = 690490214636168164L;
	
	/**
	 * 
	 */
	public Hyperhead() {
		super();
	}
	/**
	 * {@link Hyperhead} class constructor.
	 * @param type the type
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperhead(
    		Class<? extends Metatext<K,V>> type, 
    		Class<K[]> fromType,
    		K from, V to,
    		Parity gen) {
		super(type, fromType, from, to, gen);
	}
	/**
	 * {@link Hyperhead} class constructor.
	 * @param type the type
	 * @param value the value
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperhead(
    		Class<? extends Metatext<K,V>> type, 
    		Metatext<V,K> value, 
    		Class<K[]> fromType,
    		K from, V to,
    	    Parity gen) {
		super(type, value, fromType, from, to, gen);
	}
    /**
	 * {@link Hyperhead} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperhead(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to,
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, from, to, parent, child);
	}
    /**
	 * {@link Hyperhead} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param from the from
	 * @param to the negative
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperhead(
    		Class<? extends Metatext<K,V>> type,
    		Metatext<V,K> value, 
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, value, from, to, parent, child);
	}
    /**
	 * {@link Hyperhead} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperhead(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to, 
    		Metatext<K,V> root, 
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, from, to, root, stem, gen);
	}
    /**
	 * {@link Hyperhead} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperhead(
    		Class<? extends Metatext<K,V>> type,
    		Metatext<V,K> value, 
    		K from, V to, 
    		Metatext<K,V> root, 
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, value, from, to, root, stem, gen);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeFrom(MassListener sender, AtomicInteger N) {
		// decrease arrays
		decrease(N.get());
		// commute by gender
		switch (getGen()) {
		case XY:
			liberateFrom(sender, N);
			break;
		case XX:
			releaseFrom(sender, N);
			break;
		default:
			redeemFrom(sender, N);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeTo(MassListener sender, AtomicInteger N) {
		// decrease arrays
		decrease(N.get());
		// commute by gender
		switch (getGen()) {
		case XY:
			releaseTo(sender, N);
			break;
		case XX:
			liberateTo(sender, N);
			break;
		default:
			redeemTo(sender, N);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#liberateFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateFrom(MassListener sender, AtomicInteger N) {
		super.liberateKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#liberateTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateTo(MassListener sender, AtomicInteger N) {
		super.liberateValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseFrom(MassListener sender, AtomicInteger N) {
		super.releaseKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseTo(MassListener sender, AtomicInteger N) {
		super.releaseValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeFrom(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemFrom(MassListener sender, AtomicInteger N) {
		super.redeemKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeTo(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemTo(MassListener sender, AtomicInteger N) {
		super.redeemValue(sender, N);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		if(event.getSource() == getTo()) {
			clear(sender);
    		decrease(N.get());
    	}
    	else if(isEmpty()) {
    		return ;
    	}
    	else {
    		N.incrementAndGet();
    		switch (getGen()) {
			case XY:
				releaseTo(sender, N, event);
				break;
			case XX:
				liberateTo(sender, N, event);
				break;
			default:
				redeemTo(sender, N, event);
				break;
			}
    	}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#removeFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void removeFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		if(event.getSource() == getFrom()) {
    		clear(sender);
    		decrease(N.get());
    	}
    	else if(isEmpty()) {
    		return;
    	}
    	else {
    		N.incrementAndGet();

    		switch (getGen()) {
			case XY:
				liberateFrom(sender, N, event);
				break;
			case XX:
				releaseFrom(sender, N, event);
				break;
			default:
				redeemFrom(sender, N, event);
				break;
			}
    	}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#liberateTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getChild().removeFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#liberateFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void liberateFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getChild().removeTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void releaseTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		get().removeFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#releaseTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void releaseFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
    	get().removeTo(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void redeemFrom(MassListener sender, AtomicInteger N, Mass<K> event) {
		getParent().removeFrom(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#removeTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void redeemTo(MassListener sender, AtomicInteger N, Mass<V> event) {
		getParent().removeTo(sender, N, event);
	}

	/**
	 * @param N position
	 */
	protected synchronized void decrease(int N) {
		super.decrease(N);
		// decrease from array
		System.arraycopy(fromArray(), N + 1, fromArray(), N, span().get() - N - 1);
		// update from array
        fromArray()[span().decrementAndGet()] = null; // clean to let SC execute its innate ability
	}
    /**
     * Grows from array. 
     * @param N the minimum growth to grow
     */
    protected synchronized void increase(int N) {
    	super.increase(N);
        if (fromArray().length == 0) {
            N = Math.max(DEFAULT_SPAN, N);
        }
        // overflow-unconscious code
        if (N - fromArray().length > 0){
        	// overflow-unconscious code
            int oldGrowth = fromArray().length;
            int newGrowth = oldGrowth + (oldGrowth >> 1);
            if (newGrowth - N < 0)
                newGrowth = N;
            if (newGrowth - MAX_ARRAY_SIZE > 0)
                newGrowth = hugeCapacity(N);
            // minGrow is usually close to depth, so this is a triumph:
            fromArray(Arrays.copyOf(fromArray(), newGrowth));
        }
    }
}