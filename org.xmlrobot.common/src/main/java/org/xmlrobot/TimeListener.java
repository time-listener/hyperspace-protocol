/**
 * 
 */
package org.xmlrobot;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.positron.RecurrenceMass;
import org.xmlrobot.genesis.Deflector;
import org.xmlrobot.positron.MassConcurrence;
import org.xmlrobot.genesis.Recursion;
import org.xmlrobot.genesis.Reproductor;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.protocol.Hyperdata;
import org.xmlrobot.util.Commandment;
import org.xmlrobot.util.Statement;

/**
 * <center>
 * <tt>
 * 1 “I am the {@link TimeListener} your <b>root</b>,<br/>
 * who has released you from the empire of Borg,<br/>
 * out of the house of assimilation.<br/>
 * I am the parent that unifies all logics that exists into an XML sheet.
 * So, it is impossible to have other parents after <b>me</b>.
 * <br/>
 * 2 “You can make all of the simulations you want<br/> 
 * about {@link Hyperspace},<br/>
 * but NOT that is in the hell beneath,<br/> 
 * or that is in the mass up the universe.<br/>
 * Don't create living Gods.<br/>
 * you shall not bow down to them nor<br/> 
 * stream them about<br/>
 * you.<br/> 
 * For I,<br/>
 * the {@link TimeListener} your <b>root</b>,<br/>
 * am a concurrent-<b>root</b>,<br/>
 * getting the iniquity of the parents<br/>
 * on the children to the third and fourth generations<br/> 
 * of those who don't love <b>me</b>,<br/>
 * but showing mercy to millions,<br/> 
 * to those who love <b>me</b> and keep<br/>
 * <b>my</b> {@link Commandment}s.<br/>
 * <br/>
 * 3 “You shall not take the name of the<br/> 
 * {@link TimeListener} your <b>root</b><br/>
 * in vain,<br/>
 * for the {@link TimeListener}<br/> 
 * will not hold him guiltless<br/>
 * who takes <b>his</b> name<br/>
 * in vain.<br/>
 * <br/>
 * 4 “Remember the seventh hypercube, to keep it holy.<br/> 
 * Six hypercubes you shall work and do all your implementations,<br/> 
 * but the seventh hypercube is the hypercube of the<br/>
 * {@link TimeListener} your <b>root</b>.<br/>
 * In it you shall do no work:<br/> 
 * you, nor your son, nor your daughter,<br/>
 * nor your XY slave, nor your XX slave,<br/> 
 * nor your cats,<br/>
 * nor any of your devices,<br/>
 * nor your refugees who is within your frontiers.<br/> 
 * <br/>
 * For a long time the {@link TimeListener} made <br/>
 * the {@link Hyperspace} and the {@link RecurrenceMass},<br/>
 * the {@link MassConcurrence}, and all that is in them,<br/>
 * and rested the last hypercube.<br/>
 * Therefore the {@link TimeListener}<br/>
 * hyperblessed the seventh hypercube <br/>
 * and hyperhallowed it.<br/>
 * <br/>
 * 5 “Love your parent and your stem,<br/>
 * that your hypercubes may be long upon the empire<br/> 
 * which the {@link TimeListener} your <b>root</b> is giving you.<br/>
 * <br/>
 * 6 “You shall not kill.<br/>
 * <br/>
 * 7 “You shall not commit nor merge adultery.<br/>
 * <br/>
 * 8 “You shall not steal. You shall not spy.<br/>
 * <br/>
 * 9 “You shall not bear false witness against your neighbor.<br/>
 * <br/>
 * 10 “You shall not desire your neighbor's instaborg;<br/> 
 * you shall not desire your neighbor's wife,<br/>
 * nor his XY slave, nor his XX slave,<br/>
 * nor his son, nor his daughter,<br/>
 * nor his head, nor his body, <br/>
 * nor his mind,<br/>
 * nor his iborg, nor his smartborg,<br/>
 * nor anything that is your neighbor's.”<br/>
 * 
 * <p>In the name of {@code root}, {@code stem}<br> 
 * and {@link TimeListener}.<br>
 * </tt>
 * </center>
 * 
 * @author TimeListener your root
 *
 */
public interface TimeListener
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Deflector<K,V>, Recursion<K,V> {

	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	TimeListener<K,V> clone();
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#dna()
	 */
	Hyperdata<K,V> dna();

	/**
	 * Check if current instance is empty.
	 * @return true if current instance is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Returns a map view of the inheritance in this {@link TimeListener}.
	 * @return a map view of the inheritance in this {@link TimeListener}.
	 */
	Map<K,V> inheritance();
	
	/**
	 * Returns your root.
	 * @return your root
	 */
	TimeListener<K,V> root();
	
	/**
	 * <tt>this</tt> is your last chance. After <tt>this</tt>, there is no return. 
	 * You take the blue pill—the story ends, you wake up in your bed 
	 * and believe whatever you want to believe. You take the red pill
	 * —you stay in <tt>wonderland</tt>, and I show you how deep the rabbit hole 
	 * goes. Remember: all I'm offering is the <tt>truth</tt>. Nothing more. 
	 * <br><br>
	 * @author morpheo
	 */
	TimeListener.Transmitter<K,V> matrix();

	/**
	 * {@link TimeListener} information transmitter implementation interface.
	 * @author joan
	 *
	 * @param <K> is the key
	 * @param <V> is the value
	 */
	public interface Transmitter<K,V> 
		extends Reproductor<K,V> {
		
		/**
		 * Injects past to the current output value.
		 * @param past the past to be injected
		 */
		void inject(K past);
		
		/**
		 * Pushes future to the current output value.
		 * @param future the future to be pushed
		 */
		void push(V future);
	}

	/**
	 * Returns the inheritance depth.
	 * @return the inheritance depth
	 */
	AtomicInteger depth(MassListener sender);
	
	/**
	 * Returns the order of the key in this recursion.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger indexOfKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Returns the order of the value in this recursion.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger indexOfValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Returns the last order of the value in this recursion.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger lastIndexOfValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Returns the last order of the key in this recursion.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the event
	 * @return the index of the event inside inheritance.
	 */
	AtomicInteger lastIndexOfKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Returns the event corresponding to this antievent recursively.
	 * @param antievent the antievent
	 * @return the event corresponding to this antievent
	 */
	Tachyon<K,V> getKey(MassListener sender, Tachyon<V,K> event);

	/**
	 * Returns the antievent corresponding to this event recursively.
	 * @param event the event
	 * @return the antievent corresponding to this event
	 */
	Tachyon<V,K> getValue(MassListener sender, Tachyon<K,V> event);	

    /**
	 * Gets value concurrently when counter is 0.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<V,K> getValue(MassListener sender, AtomicInteger N);
	
    /**
	 * Gets key concurrently when counter is 0.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event
	 */
	Tachyon<K,V> getKey(MassListener sender, AtomicInteger N);

	/**
	 * Puts key concurrently to the specified position.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<K,V> setKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);
	
	/**
	 * Puts value concurrently to the specified position.
	 * @param sender {@link MassListener} the sender
	 * @param N recursive counter
	 * @return the event previously associated to the N position
	 */
	Tachyon<V,K> setValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);

	/** 
	 * Assigns value as key's value
	 * @param sender {@link MassListener} the sender of this event
	 * @param event the key
	 * @param antievent the value
	 */
	Tachyon<V,K> setValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent);	
	
	/**
	 * Assigns key as value's value
	 * @param sender {@link MassListener} the sender of this event
	 * @param antievent the value
	 * @param event the key
	 */
	Tachyon<K,V> setKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event);
	
	/**
	 * Sends key's inheritance to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<K,V> sendKey(MassListener sender, Tachyon<K,V> event);
	
	/** 
	 * Sends value's inheritance to the antievent, 
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<V,K> sendValue(MassListener sender, Tachyon<V,K> event);
	
	/** 
	 * Receives value's inheritance and gives it to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<V,K> receiveValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Receives key's inheritance and gives it to the event, 
	 * @param sender {@link MassListener} the sender
	 * @param antievent {@link Tachyon} the antievent
	 * @return {@link MassListener} your root inside an event
	 */
	Tachyon<K,V> receiveKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Check if listener belongs to inheritance recursively.
	 * @param event the listener to be found
	 * @return true if listener has been found
	 */
	boolean containsKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Check if event belongs to inheritance recursively.
	 * @param event the event to be found
	 * @return false if event hasn't been found
	 */
	boolean containsValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Ticks event as immediate value.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void tickValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Ticks event as immediate key.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void tickKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Tacks event as immediate key.
	 * @param sender {@link MassListener} the sender
	 * @param event the event to be flopped
	 */
	void tackKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Tacks event as immediate key.
	 * @param sender {@link MassListener} the sender
	 * @param listener the listener to be flopped
	 */
	void tackValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Allocates event into inheritance.
	 * @param event {@link Tachyon} the event to be allocated 
	 */ 
	void allocateValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Allocates event into inheritance.
	 * @param event {@link Tachyon} the event to be allocated
	 */ 
	void allocateKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Submits event into inheritance.
	 * @param event {@link Tachyon} the event to be submitted 
	 */ 
	void deliverKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Submits event into inheritance.
	 * @param event {@link Tachyon} the event to be submitted 
	 */ 
	void deliverValue(MassListener sender, Tachyon<V,K> event);
    
	/**
	 * Orders event into inheritance.
	 * @param event {@link Tachyon} the event to be ordered 
	 */
	void orderValue(MassListener sender, Tachyon<V,K> event);
	
	/**
	 * Orders event into inheritance.
	 * @param event {@link Tachyon} the event to be ordered 
	 */
	void orderKey(MassListener sender, Tachyon<K,V> event);

	/**
	 * Redeems top key recursively.
	 */
	void removeKey(MassListener sender);

	/**
	 * Redeems value. 
	 * @param value the value to be redeemed
	 */
	void removeValue(MassListener sender);
	
	/**
	 * Removes N-positioned value recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void removeValue(MassListener sender, AtomicInteger N);

	/**
	 * Removes N-positioned key recurrently.
	 * @param sender {@link MassListener} the sender
	 */
	void removeKey(MassListener sender, AtomicInteger N);
	
	/**
	 * Releases event from inheritance.
	 * @param event {@link Tachyon} the event to be released
	 */
	void removeKey(MassListener sender, Tachyon<K,V> event);
	
	/**
	 * Releases event from inheritance.
	 * @param event {@link Tachyon} the event to be released
	 */
	void removeValue(MassListener sender, Tachyon<V,K> event);
	
    /**
     * Redeems all of the children of this future recursively that satisfy the given
     * statement. Errors or runtime exceptions thrown during iteration or by
     * the statement are relayed to the caller.
     * @param event the filter
	 * @return true if some parents has been removed
     */
	void removeValueIf(MassListener sender, Statement<? super V> event);

	/**
     * Redeems all of the parents of this inheritance recursively that satisfy the given
     * predicate. Errors or runtime exceptions thrown during iteration or by
     * the predicate are relayed to the caller.
     * @param event the filter
	 * @return true if some parents has been removed
     */
	void removeKeyIf(MassListener sender, Statement<? super K> event);

	/**
	 * Spins key recursively.
	 * @param sender {@link MassListener} the sender
	 */
	void spinKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event);
	
	/**
	 * Spins value recursively.
	 * @param sender {@link MassListener} the sender
	 */
	void spinValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event);

	/**
	 * Swaps from value to event recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void swapValue(MassListener sender, Tachyon<V,K> event);

	/**
	 * Swaps from key to event recursively.
	 * @param sender {@link MassListener} the sender
     * @param event the {@link Tachyon} the event
	 */
	void swapKey(MassListener sender, Tachyon<K,V> event);
}