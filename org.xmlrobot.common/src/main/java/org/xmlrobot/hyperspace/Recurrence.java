/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Phaser;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * The mass of the past.
 * <br><br>
 * @author joan
 * 
 * @param <K>
 * @param <V>
 * 
 * @parity YY
 * @since 4
 */
@XmlTransient
public abstract class Recurrence
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Abstraction<K,V> {

	/**
	 * -4157408801054520292L
	 */
	private static final long serialVersionUID = -4157408801054520292L;

	/**
	 * The mass listeners.
	 */
	LinkedHashSet<MassListener> massListeners;
	
	/**
     * {@link Recurrence} default class constructor.
     */
	public Recurrence() {
    	super();
		// initialize mass listeners set
		massListeners = new LinkedHashSet<MassListener>();
    }
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Recurrence(Class<? extends K> type, Parity gen) {
		super(type, gen);
		// initialize mass listeners set
		massListeners = new LinkedHashSet<MassListener>();
	}
	/**
	 * {@link Recurrence} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Recurrence(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
		// initialize mass listeners set
		massListeners = new LinkedHashSet<MassListener>();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		
		synchronized (massListeners) {
			
			massListeners.add(listener);
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		// declare child
		TimeListener<K,V> child;
		// assign and check
		if((child = super.clone()) != null) {
			Recurrence<K,V> key = (Recurrence<K,V>) child;
			key.massListeners = new LinkedHashSet<MassListener>();
			return key;	
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		// avoid antimatter contact
		if(!sender.equals(get()) && !sender.equals(this))
			// broadcast event
			push(event);
	}
	/**
	 * Sends MASS to the past.
	 * @param sender {@link Source} the transmitter entity.
	 * @param event {@link Tachyon} the mass being sent.
	 */
	protected void push(Tachyon<?,?> event) {
		// a-synchronized
		for(MassListener listener : massListeners) {
			
			listener.mass(this, event);
		}
	}



    /**
     * @param runnable
     * @param output
     * @return
     */
    protected TimeListener<K,V> newMass(Runnable runnable, TimeListener<K,V> output)
    {
    	return null;
    }
	/**
     * Returns a {@code RunnableFuture} for the given runnable and default
     * value.
     *
     * @param runnable the runnable task being wrapped
     * @param output the default value for the returned future
     * @param <T> the type of the given value
     * @return a {@code RunnableFuture} which, when run, will run the
     * underlying runnable and which, as a {@code Future}, will yield
     * the given value as its result and provide for cancellation of
     * the underlying task
     * @since 1.6
     */
    @SuppressWarnings("unchecked")
	protected <T> Phaser<T> newPhaserFor(Runnable runnable, T output) {
    	
        return (Phaser<T>) new FutureTask<T>(runnable, output);
    }
    /**
     * Returns a {@code RunnableFuture} for the given callable task.
     *
     * @param callable the callable task being wrapped
     * @param <T> the type of the callable's result
     * @return a {@code RunnableFuture} which, when run, will call the
     * underlying callable and which, as a {@code Future}, will yield
     * the callable's result as its result and provide for
     * cancellation of the underlying task
     * @since 1.6
     */
    @SuppressWarnings("unchecked")
	protected <T> Phaser<T> newPhaserFor(Callable<T> callable) {
        return (Phaser<T>) new FutureTask<T>(callable);
    }
}