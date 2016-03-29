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
 * A {@link PastCallable} that is {@link RunnableFuture}.
 * <p>Recurrence is all that goes backward to the origin. 
 * I.e, turns back to the past by calling the parent of inheritance.
 * 
 * @author joan
 *
 */
public interface Recurrence
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends PastCallable<K>, RunnableFuture<V> {

	/**
	 * Returns the number of parents above this past.
	 * @param N natural recursive counter
	 * @return the recurrence of inheritance
	 */
	AtomicInteger recurrence(MassListener sender, AtomicInteger N);

	/**
	 * Returns the order of the key in this recurrence.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger orderOfKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Returns the order of the value in this recurrence.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger orderOfValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Turns back the antievent corresponding to this event recursively.
	 * @param event the event
	 * @return the antievent corresponding to this event
	 */
	Tachyon<V,K> callValue(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Turns back the event corresponding to this antievent recursively.
	 * @param antievent the antievent of this event
	 * @return the event corresponding to this antievent
	 */
	Tachyon<K,V> callKey(MassListener sender, Tachyon<V,K> antievent);
	
    /**
	 * Calls key recurrently when counter is 0.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<K,V> callKey(MassListener sender, AtomicInteger N);

    /**
	 * Calls value recurrently when counter is 0.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<V,K> callValue(MassListener sender, AtomicInteger N);

	/**
	 * Sets value recurrently to the specified position.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<V,K> putValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);
	
	/**
	 * Sets key recurrently to the specified position.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<K,V> putKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);

	/**
	 * Puts key as value's value
	 * @param sender {@link MassListener} the sender of this event
	 * @param antievent the value
	 * @param event the key
	 */
	Tachyon<K,V> putKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event);
	
	/** 
	 * Puts value as key's value
	 * @param sender {@link MassListener} the sender of this event
	 * @param event the key
	 * @param antievent the value
	 */
	Tachyon<V,K> putValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent);
	
	/** 
	 * Gives value's inheritance to the antievent, 
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<V,K> openValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Gives key's inheritance to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<K,V> openKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Takes key's inheritance and gives it to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<K,V> closeKey(MassListener sender, Tachyon<K,V> event);
	
	/** 
	 * Takes value's inheritance and gives it to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<V,K> closeValue(MassListener sender, Tachyon<V,K> event);
	
    /**
	 * Calls top value recurrently.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<V,K> callPastValue(MassListener sender);
	
    /**
	 * Calls top key recurrently.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<K,V> callPastKey(MassListener sender);

	/**
	 * Check if event is had inside inheritance recurrently.
	 * @param sender {@link MassListener} the sender
	 * @param event the even to be found
	 * @return true if event has been found
	 */
	boolean hasKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Check if event is had inside inheritance recurrently.
	 * @param sender {@link MassListener} the sender
	 * @param event the event to be found
	 * @return false if event hasn't been found
	 */
	boolean hasValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Swaps from key to event recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void exchangeKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Swaps from value to event recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void exchangeValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Injects event as top value recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void pushValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Injects event as top key recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void pushKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Flops event as immediate key recurrently.
	 * @param sender {@link MassListener} the sender
	 * @param event the event to be flopped
	 */
	void flopKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Flops event as immediate key recurrently.
	 * @param sender {@link MassListener} the sender
	 * @param listener the listener to be flopped
	 */
	void flopValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Polls event as immediate value recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void pollValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Polls event as immediate key recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void pollKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Revolves key recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void revolveKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);

	/**
	 * Revolves value recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void revolveValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);

	/**
	 * Orders event as super key concurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void orderSuperKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Orders event as super value concurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void orderSuperValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Removes top key recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void redeemValue(MassListener sender);
	
	/**
	 * Removes top key recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void redeemKey(MassListener sender);

	/**
	 * Removes N-positioned key recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void redeemKey(MassListener sender, AtomicInteger N);
	
	/**
	 * Removes N-positioned value recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void redeemValue(MassListener sender, AtomicInteger N);

	/**
	 * Removes value by event recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void redeemValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Removes key by event recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void redeemKey(MassListener sender, Tachyon<K,V> event);

	/**
     * Removes all of the keys of this inheritance recurrently that satisfy the given
     * statement. Errors or runtime exceptions thrown during iteration or by
     * the statement are relayed to the caller.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Statement} the event
     */
	void redeemKeyIf(MassListener sender, Statement<? super K> event);
	
	/**
     * Removes all of the values of this past recurrently that satisfy the given
     * statement. Errors or runtime exceptions thrown during iteration or by
     * the statement are relayed to the caller.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Statement} the event
     */
	void redeemValueIf(MassListener sender, Statement<? super V> event);
}