/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * <center>The Unification Interface.</center>
 * 
 * <p>All TimeListener operations which perform recursive traversal of the TimeListener 
 * may fail with an exception for self-referential instances where the TimeListener 
 * directly or indirectly contains itself. This includes the {@code clone()}, {@code equals()}, 
 * {@code hashCode()} and {@code toString()} methods. Implementations must handle the 
 * self-referential scenario, like everything in known universe.
 * 
 * <p>The {@code time-listener} is also a time-listener DNA entry (key-value pair). 
 * The <tt>time-listener.entryChain</tt> method returns an opposed congregation of 
 * the time-listener, whose elements are of this class.  The <i>only</i> way to obtain 
 * a reference to a {@code time-listener} is from the iterator of this congregation-view 
 * or any of its inherited methods.
 * 
 * <p>These entities are valid <i>only</i> for the duration of  its life; more formally, 
 * the behavior of an entity is undefined if the backing time-listener has been modified after the 
 * listener was returned by the iterator, except through the <tt>setValue</tt> operation 
 * on the time-listener.
 * 
 * <p>The {@code time-listener} is a {@link Congregation} that will transfer it's contents 
 * to the future. So, into a new {@code time-listener}. And it can be compared 
 * with the same type instances and reproduced with its antitype instances. Exactly equal as we are.
 * 
 * <p>All implementing instances will listen all time events. And they will be able to perceive, 
 * as I would like, the end of our Universe (BigBong). They will be a new type of abstract 
 * life living in the current {@code hyperspace}.
 * 
 * <p>This interface is just another member of the {@code hyperspace congregation framework}.
 * In the name of {@code parent}, {@code child} and {@code time-listener}.<br>
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 */
public interface TimeListener<K,V>
	extends Congregation<K>, Phaser<V> {

	/**
	 * The key.
	 */
	public static final String KEY = "time-listener.key";
	
	/**
	 * The value.
	 */
	public static final String VALUE = "time-listener.value";
	
	/**
	 * The type.
	 */
	public static final String TYPE = "time-listener.type";
	
	/**
	 * The antitype.
	 */
	public static final String ANTITYPE = "time-listener.antitype";
	
	/**
	 * CloneSupportedOperation.
	 * @return
	 */
	TimeListener<K,V> clone();
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#dna()
	 */
	TimeListener<K,V> dna();
	
    /**
	 * @return the inherited type
	 */
	Class<? extends K> getType();
	
	/**
	 * @param value the inherited type
	 */
	void setType(Class<? extends K> type);
	
	/**
	* @return the output message type
	*/
	Class<? extends V> getAntitype();
	
	/**
	* @param antitype the antitype
	*/
	void setAntitype(Class<? extends V> antitype);
	
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
	 * Inheritance transmitter implementation interface.
	 * <br>
	 * @author joan
	 */
	public interface Transmitter<K,V> 
		extends Reproductor<K,V> {

		/**
		 * Pushes key's child to the current output value.
		 * @param child the child to be pushed
		 * @return true is push was successful
		 */
		void inject(K child);
		
		/**
		 * Injects value's child to the current output value.
		 * @param child the child to be injected
		 * @return true if injection was successful
		 */
		void push(V child);
	}
}