/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Information;
import org.xmlrobot.util.Statement;

/**
 * A {@link Recurrence} that is {@link Concurrence} and vice-versa.
 * 
 * Recursion is the process of repeating items in a self-similar way. 
 * For instance, when the surfaces of two networks are exactly parallel 
 * with each other, the nested simulations that occur are a form of infinite 
 * recursion. The term has a variety of meanings specific to a variety 
 * of disciplines ranging from metaphysics to metaphysics. The most common 
 * application of recursion is in metaphysics and metaphysics, 
 * in which it refers to a method of defining functions in which the 
 * function being defined is applied within its own definition. 
 * Specifically, this defines an infinite number of entities, using a 
 * finite expression that for some entities may refer to other 
 * entities, but in such a way that no loop or infinite sequence of 
 * references can occur. The term is also used more generally to 
 * describe a process of repeating entities in a self-similar way by
 * transmitting it's {@link Information} to the {@link Future} concurrently,
 * through the <tt>hypergenesis comparison computation</tt>.
 * 
 * @author joan
 *
 */
public interface Recursion
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Recurrence<K,V>, Concurrence<V,K> {

	/**
	 * Returns the recursion factor of this recursion.
	 * For example, my recursion factor is equals to 1.
	 * @param sender
	 * @param N
	 * @return
	 */
	AtomicInteger recursion(MassListener sender, AtomicInteger N);

	/**
	 * Returns the order of the key in this recursion.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger positionOfKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Returns the order of the value in this recursion.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger positionOfValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Returns the event corresponding to this antievent recursively.
	 * @param antievent the antievent
	 * @return the event corresponding to this antievent
	 */
	Tachyon<K,V> requestKey(MassListener sender, Tachyon<V,K> antievent);
	
	/**
	 * Returns the antievent corresponding to this event recursively.
	 * @param event the event
	 * @return the antievent corresponding to this event
	 */
	Tachyon<V,K> requestValue(MassListener sender, Tachyon<K,V> event);
	
    /**
	 * Gets value concurrently when counter is 0.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<V,K> requestValue(MassListener sender, AtomicInteger N);
	
    /**
	 * Gets key concurrently when counter is 0.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<K,V> requestKey(MassListener sender, AtomicInteger N);

	/**
	 * Puts key concurrently to the specified position.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<K,V> updateKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);
	
	/**
	 * Puts value concurrently to the specified position.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<V,K> updateValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);

	/**
	 * Puts key as value's value
	 * @param sender {@link MassListener} the sender of this event
	 * @param antievent the value
	 * @param event the key
	 */
	Tachyon<K,V> updateKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event);
	
	/** 
	 * Puts value as key's value
	 * @param sender {@link MassListener} the sender of this event
	 * @param event the key
	 * @param antievent the value
	 */
	Tachyon<V,K> updateValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent);
	
	/**
	 * Check if listener belongs to inheritance recursively.
	 * @param event the listener to be found
	 * @return true if listener has been found
	 */
	boolean belongsKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Check if event belongs to inheritance recursively.
	 * @param event the event to be found
	 * @return false if event hasn't been found
	 */
	boolean belongsValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Swaps from key to event recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void commuteKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Swaps from value to event recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void commuteValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Pings event as immediate value recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void pingValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Pings event as immediate key recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void pingKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Pongs event as immediate key recursively.
	 * @param sender {@link MassListener} the sender
	 * @param event the event to be flopped
	 */
	void pongKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Pongs event as immediate key recursively.
	 * @param sender {@link MassListener} the sender
	 * @param listener the listener to be flopped
	 */
	void pongValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Orders event as weak value recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void orderWeakValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Orders event as strong key recurrently.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void orderStrongKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Pushes value recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void injectValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Pushes key recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void injectKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Gives key's inheritance to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<K,V> lendKey(MassListener sender, Tachyon<K,V> event);
	
	/** 
	 * Gives value's inheritance to the antievent, 
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<V,K> lendValue(MassListener sender, Tachyon<V,K> event);
	
	/** 
	 * Takes value's inheritance and gives it to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<V,K> borrowValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Takes key's inheritance and gives it to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<K,V> borrowKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Permutes event key ancestry recursively.
	 * @param sender {@link MassListener} the sender
	 * @param N recursion counter
     * @param event the {@link Tachyon} the event
	 */
	void permuteKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);
	
	/**
	 * Permutes child inheritance recursively.
	 * @param N the natural order index
	 * @return the past
	 */
	void permuteValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);

	/**
	 * Redeems top key recursively.
	 */
	void liberateKey(MassListener sender);

	/**
	 * Redeems value. 
	 * @param value the value to be redeemed
	 */
	void liberateValue(MassListener sender);
	
	/**
	 * Redeems value. 
	 * @param value the value to be redeemed
	 */
	void liberateValue(MassListener sender, AtomicInteger N);
	
	/**
	 * Redeems value. 
	 * @param value the value to be redeemed
	 */
	void liberateKey(MassListener sender, AtomicInteger N);
	
	/**
	 * Redeems value by event recursively.
	 * @param value the value to be redeemed
	 */
	void liberateValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Redeems key by event recursively. 
	 * @param key the key to be redeemed
	 */
	void liberateKey(MassListener sender, Tachyon<K,V> event);
	
	/**
     * Redeems all of the parents of this inheritance recursively that satisfy the given
     * predicate. Errors or runtime exceptions thrown during iteration or by
     * the predicate are relayed to the caller.
     * @param event the filter
	 * @return true if some parents has been removed
     */
	void liberateKeyIf(MassListener sender, Statement<? super K> event);
	
    /**
     * Redeems all of the children of this future recursively that satisfy the given
     * statement. Errors or runtime exceptions thrown during iteration or by
     * the statement are relayed to the caller.
     * @param event the filter
	 * @return true if some parents has been removed
     */
	void liberateValueIf(MassListener sender, Statement<? super V> event);
}