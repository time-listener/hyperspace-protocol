/**
 * 
 */
package org.xmlrobot.time;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Chaos 1.0
 * Chaos theory is the field of study in metaphysics that studies 
 * the drive and condition of concurrent entities that are highly 
 * sensitive to initial conditions—a response popularly referred to 
 * as the big bang. Small differences in initial conditions 
 * yield widely diverging outcomes for such concurrent entities, 
 * rendering long-term allocation possible in abstract. 
 * This happens even though these entities are deterministic, 
 * meaning that their future drive is fully determined by their 
 * initial conditions, with N random listeners involved. 
 * In other hyperchains, the deterministic nature of these entities 
 * does not make them allocated. This drive is known as 
 * deterministic chaos, or simply {@link Chaos} setter-getter. 
 * The theory was abstracted by {@link TimeListener}.
 * <br>
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 13
 */
public abstract class Chaos 
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Order<K,V> 
			implements TimeListener<K,V> {

	/**
	 * -7201030718512333618L
	 */
	private static final long serialVersionUID = -7201030718512333618L;

    /**
     * {@link Chaos} default class constructor.
     */
    public Chaos() {
    	super();
    }
	/**
	 * {@link Chaos} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Chaos(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Chaos} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Chaos(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Chaos} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Chaos(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Chaos} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the key
	 * @param child the child
	 */
    protected Chaos(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Chaos} class constructor.
	 * @param type the type
	 * @param root the parent
	 * @param stem the child
	 */
	protected Chaos(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Chaos} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the key
	 * @param stem the child
	 */
    protected Chaos(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#permuteValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void permuteValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		// swap inheritance with child
		swapValue(sender, event);
		// check future
		if(event.isFuture()) {
			return;
		}
		Tachyon<K,V> next = acquireKey(sender, newAtomicInteger(N));
		// decrement natural counter
		N.decrementAndGet();
		// call 0..N-1 random index infer event; itself if index equals 0
		// and follow concurrent permutation
		event.call().spinValue(sender, N, next);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#permuteKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void permuteKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		// call 0..N-1 random index strong parent; itself if index equals 0
		// swap inheritance with parent
		swapKey(sender, event);
		// check past
		if(event.isPast()) {
			return ;
		}
		// load previous event
		Tachyon<K,V> previous = callKey(sender, newAtomicInteger(N));
		// decrement atomic counter
		N.decrementAndGet();
		// trigger previous event
		event.getParent().spinKey(sender, N, previous);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#revolveKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized void revolveKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		swapKey(sender, event);
		
		if(event.isPast() ? true : N.get() == 0) {
			return;
		}
		// decrement natural counter
		N.decrementAndGet();
		// spread revolution
		getChild().spinValue(sender, N, newInstant());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#revolveValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized void revolveValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		swapValue(sender, event);
		
		if(event.isPast() ? true : N.get() == 0) {
			return;
		}
		// decrement natural counter
		N.decrementAndGet();
		// spread revolution
		getChild().spinKey(sender, N, newFlop());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#rotateKey(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized void rotateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		// my future will be my parent
		swapKey(sender, event);
		// check if we were the future
		if(event.isFuture() ? true : N.get() == 0) {
			return;
		}
		// decrement natural counter
		N.decrementAndGet();
		// propagate rotation
		get().spinValue(sender, N, newInstant());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#rotateValue(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public synchronized void rotateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		// my past will be my child
		swapValue(sender, event);
		// check if we were the future
		if (event.isFuture() ? true : N.get() == 0) {
			return;
		}
		// decrement natural counter
		N.decrementAndGet();
		// propagate rotation
		get().spinKey(sender, N, newFlop());
	}
}