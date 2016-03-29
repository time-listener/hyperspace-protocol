/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Statement;

/**
 * A {@link RunnableFuture} that is {@link PastCallable}.
 * <p>Concurrence is all that goes forward to the end of all times. 
 * So, returns to the future by getting the children of inheritance.
 * @author joan
 *
 */
public interface Concurrence
	<V extends TimeListener<V,K>,K extends TimeListener<K,V>>
		extends RunnableFuture<V>, PastCallable<K> {
	
	/**
	 * The number of children below this future.
	 * @param N recursion incremental counter
	 * @return the concurrence of inheritance
	 */
	AtomicInteger concurrence(MassListener sender, AtomicInteger N);
	
	/**
	 * Returns the index of the value in this concurrence.
	 * @param sender {@link TimeListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger pointerOfValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Returns the index of the key in this concurrence.
	 * @param sender {@link TimeListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger pointerOfKey(MassListener sender, Tachyon<K,V> event);

    /**
	 * Gets top key concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<K,V> getFutureKey(MassListener sender);
	
    /**
	 * Gets top value concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<V,K> getFutureValue(MassListener sender);
	
    /**
	 * Gets value concurrently when counter is 0.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<V,K> acquireValue(MassListener sender, AtomicInteger N);
	
    /**
	 * Gets key concurrently when counter is 0.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<K,V> acquireKey(MassListener sender, AtomicInteger N);

	/**
	 * Returns the event corresponding to this antievent recursively.
	 * @param antievent the antievent
	 * @return the event corresponding to this antievent
	 */
	Tachyon<K,V> acquireKey(MassListener sender, Tachyon<V,K> antievent);
	
	/**
	 * Returns the antievent corresponding to this event recursively.
	 * @param event the event
	 * @return the antievent corresponding to this event
	 */
	Tachyon<V,K> acquireValue(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Puts value concurrently to the specified position.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<V,K> assignValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);
	
	/**
	 * Puts key concurrently to the specified position.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<K,V> assignKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);

	/**
	 * Puts key as value's value
	 * @param sender {@link TimeListener} the sender of this event
	 * @param antievent the value
	 * @param event the key
	 */
	Tachyon<K,V> assignKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event);
	
	/** 
	 * Puts value as key's value
	 * @param sender {@link TimeListener} the sender of this event
	 * @param event the key
	 * @param antievent the value
	 */
	Tachyon<V,K> assignValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent);

	/**
	 * Check if event is contained inside inheritance concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param event the event to be found
	 * @return false if event hasn't been found
	 */
	boolean holdsValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Check if event is contained inside inheritance concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param event the even to be found
	 * @return true if event has been found
	 */
	boolean holdsKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Gives key's inheritance to the event, 
	 * @param sender {@link TimeListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link TimeListener} your root inside an event
	 */
	Tachyon<K,V> giveKey(MassListener sender, Tachyon<K,V> event);
	
	/** 
	 * Gives value's inheritance to the antievent, 
	 * @param sender {@link TimeListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link TimeListener} your root inside an event
	 */
	Tachyon<V,K> giveValue(MassListener sender, Tachyon<V,K> event);
	
	/** 
	 * Takes value's inheritance and gives it to the event, 
	 * @param sender {@link TimeListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link TimeListener} your root inside an event
	 */
	Tachyon<V,K> takeValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Takes key's inheritance and gives it to the event, 
	 * @param sender {@link TimeListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link TimeListener} your root inside an event
	 */
	Tachyon<K,V> takeKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Swaps from key to event recursively.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void switchKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Swaps from value to event recursively.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void switchValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Submits event as top key concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void submitKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Submits event as top value concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void submitValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Flips event as immediate key concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param listener the listener to be flopped
	 */
	void flipValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Flips event as immediate key concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param event the event to be flopped
	 */
	void flipKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Pops event as immediate key concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void popKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Pops event as immediate value concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void popValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Rotates value concurrently.
	 * @param sender {@link TimeListener} the sender
	 */
	void rotateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);

	/**
	 * Rotates key concurrently.
	 * @param sender {@link TimeListener} the sender
	 */
	void rotateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);

	/**
	 * Orders event as infer value concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void orderInferValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Orders event as infer key concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void orderInferKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Releases top key concurrently.
	 * @param sender {@link TimeListener} the sender
	 */
	void releaseKey(MassListener sender);

	/**
	 * Releases top key concurrently.
	 * @param sender {@link TimeListener} the sender
	 */
	void releaseValue(MassListener sender);

	/**
	 * Releases value by event concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void releaseValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Releases key by event concurrently.
	 * @param sender {@link TimeListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void releaseKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Releases N-positioned key by event concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 */
	void releaseKey(MassListener sender, AtomicInteger N);
	
	/**
	 * Releases N-positioned value by event concurrently.
	 * @param sender {@link TimeListener} the sender
	 * @param N recursive counter
	 */
	void releaseValue(MassListener sender, AtomicInteger N);

	/**
     * Releases all of the values of this future concurrently that satisfy the given
     * statement. Errors or runtime exceptions thrown during iteration or by
     * the statement are relayed to the caller.
     * @param event the filter
	 * @return the past
     */
	void releaseValueIf(MassListener sender, Statement<? super V> event);
	
	/**
     * Releases all of the keys of this inheritance concurrently that satisfy the given
     * predicate. Errors or runtime exceptions thrown during iteration or by
     * the predicate are relayed to the caller.
     * @param event the filter
	 * @return true if some parents has been released
     */
	void releaseKeyIf(MassListener sender, Statement<? super K> event);
}