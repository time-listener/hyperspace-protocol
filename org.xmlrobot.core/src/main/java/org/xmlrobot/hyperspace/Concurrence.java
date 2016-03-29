/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Mass of the future.
 * <br><br>
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 6
 * @author joan
 */
public abstract class Concurrence 
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Recursion<K,V>
			implements TimeListener<K,V> {
	
	/**
	 * -8918966892741751641L
	 */
	private static final long serialVersionUID = -8918966892741751641L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#get()
	 */
	@Override
	public V get() {
		return data.get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#set(java.lang.Object)
	 */
	@Override
	public V set(V listener) {
		// update key
		V oldValue = data.set(listener);
		// update value
		getValue().dna().put(listener);
		// update hyperspace
		update();
		// return old value
		return oldValue;
	}
  	/**
     * {@link Concurrence} default class constructor.
     */
	public Concurrence() {
    	super();
    }
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the inherited type
	 * @param gen {@link Parity} the gender
	 */
	protected Concurrence(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Concurrence(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Concurrence(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the type
	 * @param value the value
     * @param parent the key
	 * @param child the child
	 */
	protected Concurrence(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the type
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
	protected Concurrence(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
	/**
	 * {@link Concurrence} class constructor.
	 * @param type the type
	 * @param value the value
     * @param root the key
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
	protected Concurrence(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Concurrence#concurrence(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public AtomicInteger concurrence(MassListener sender, AtomicInteger N) {
    	N.incrementAndGet();
    	return isFuture() ? N : get().concurrence(sender, N);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Concurrence#acquireKey(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public Tachyon<K,V> acquireKey(MassListener sender, AtomicInteger N) {
		return get().getValue(sender, N);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Concurrence#acquireValue(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public Tachyon<V,K> acquireValue(MassListener sender, AtomicInteger N) {
		return get().getKey(sender, N);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#acquireKey(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> acquireKey(MassListener sender, Tachyon<V,K> event) {
		return get().getValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#acquireValue(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> acquireValue(MassListener sender, Tachyon<K,V> event) {
		return get().getKey(sender, event);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Concurrence#assignValue(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> assignValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return get().setKey(sender, N, event);	
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Concurrence#assignKey(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> assignKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return get().setValue(sender, N, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#assignKey(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> assignKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return get().setValue(sender, antievent, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#assignValue(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> assignValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return get().setKey(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public synchronized void execute(Runnable command) {
		newThread(command).start();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#run()
	 */
	@Override
	public void run() {
		super.run();
		// check if we are the future
		if (!isFuture()) {
			// execute future now
			get().start(getContext());	
		}
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		Thread life = new Thread(getFamily(), r, getType().getName() + "." + getName(), 0);
        if (life.isDaemon())
            life.setDaemon(false);
        if (life.getPriority() != Thread.MAX_PRIORITY)
            life.setPriority(Thread.MAX_PRIORITY);
        return life;
	}
}