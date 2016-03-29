/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Mass of the past.
 * 
 * @author joan
 * 
 * @param <K>
 * @param <V>
 * 
 * @parity YY
 * @since 4
 */
public abstract class Recurrence
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Abstraction<K,V> 
			implements TimeListener<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7189559876960626778L;

	/**
	 * The mass listeners
	 */
	LinkedHashSet<MassListener> listeners;
	
	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */
	@Override
	public K call() {
		// past is future's value
		return data.call();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#put(java.lang.Object)
	 */
	public K put(K listener){
		// update key
		K oldValue = data.put(listener);
		// update value
		getValue().dna().set(listener);
		// update hyperspace
		update();
		// return old value
		return oldValue;
	}
	
	/**
     * {@link Recurrence} default class constructor.
     */
	public Recurrence() {
    	super();
    }
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Recurrence(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Recurrence(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
     * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Recurrence(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
		// send mass to stem
		addMassListener(getStem());
	}
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
	protected Recurrence(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
		// send mass to stem
		addMassListener(getStem());
	}
	/**
     * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param root the root
	 * @param stem the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Recurrence(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
		// send mass to stem
		addMassListener(stem);
	}
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the root
	 * @param stem the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Recurrence(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
		// send mass to stem
		addMassListener(stem);
	}
	
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#recurrence(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public AtomicInteger recurrence(MassListener sender, AtomicInteger N) {
    	N.incrementAndGet();
    	return !isPast() ? getParent().recurrence(sender, N) : N;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#callKey(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public Tachyon<K,V> callKey(MassListener sender, AtomicInteger N) {
		// follow calling
		return getParent().getKey(sender, N);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#callValue(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
     */
    @Override
    public Tachyon<V,K> callValue(MassListener sender, AtomicInteger N) {
    	return getParent().getValue(sender, N);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callKey(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> callKey(MassListener sender, Tachyon<V,K> value) {
		return getParent().getKey(sender, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#callValue(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> callValue(MassListener sender, Tachyon<K,V> key) {
		return getParent().getValue(sender, key);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#putKey(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> putKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		return getParent().setKey(sender, antievent, event);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#putValue(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> putValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		return getParent().setValue(sender, event, antievent);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#putValue(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> putValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		return getParent().setValue(sender, N, event);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#putKey(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> putKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		return getParent().setKey(sender, N, event);
    }
    
    /*
     * MASS LISTENING.
     * */
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public synchronized void addMassListener(MassListener listener) {
		if(listeners == null)
			listeners = new LinkedHashSet<MassListener>();
		listeners.add(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#removeMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void removeMassListener(MassListener listener) {
		if(listeners != null)
			listeners.remove(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void mass(MassListener sender, Tachyon<X,Y> event) {
		// avoid antimatter contact
		if(sender != getValue() && sender != this) {
			// event broadcast
			for(MassListener listener : listeners) {
				listener.mass(root(), event);
			}
		}
	}
	/**
	 * Sends MASS to the past recurrently.
	 * @param event {@link Tachyon} the mass being sent.
	 */
	protected void push(Tachyon<V,K> event) {
		// event broadcast
		for (MassListener listener : listeners) {
			listener.mass(root(), event);
		}
	}
}