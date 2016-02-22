/**
 * 
 */
package org.xmlrobot.time;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * Chaos 1.0
 * <br>
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 13
 */
@XmlTransient
public abstract class Caos
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Order<K,V> {

	/**
	 * -6079174607554085226L
	 */
	private static final long serialVersionUID = -6079174607554085226L;
	
    /**
     * {@link Caos} default class constructor.
     */
    public Caos() {
    	super();
    }
	/**
	 * {@link Caos} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Caos(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Caos} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    protected Caos(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Caos} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Caos(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#permute(int)
	 */
	@Override
	public synchronized K permute(int N) {
		// call 0..N-1 random index infer child; itself if index equals 0
		K child = call(nextInt(N));
		// give current instance's natural order to the infer child
		swap(child);
		// declare future
		K future;
		// have we arrived to the future ? 
		return N <= 1 ?
				// so return to the past
				getPast()
				// have we a grandchild ?
				: (future = child.getChild()) != null ?
						// so, follow the natural permutation
						future.permute(--N) 
						// or return the first parent
						: getPast();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#chaos()
	 */
	@Override
	public synchronized void polarize() {
		
		K past = getChild();
		K future = getChild().getFuture();
		
		future.polarize(past, future);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#chaos(org.xmlrobot.genesis.Inheritance, org.xmlrobot.genesis.Inheritance)
	 */
	public synchronized void polarize(K parent, K child) {
		
		if(parent != null && child != null) {
			//total disorder
			parent.swap(child);
			//call recursion chaos synchrony
			polarize(child.getChild(), parent.getParent());
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#revolve()
	 */
	@Override
	public synchronized K revolve() {

		K past = getPast();	
		K future = getFuture();		
	
		//So, !equals this && future.parent != null. I.e. it's empty.
		if(past != future) {
			
			//Disconnect parent's future
			future.getParent().setChild(null);
			future.setParent(null);
				
			//Set FUTURE as new PAST
			past.setParent(future);
			future.setChild(past);
			
			future.setParent(null);
			
			//Return the new past;
			return future;
		}
		else
		{
			return past;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#rotate()
	 */
	@Override
	public synchronized K rotate() {
		
		K past = getPast();	
		K future = getFuture();		
	
		//So, equals this
		if(past != future)
		{
			//Disconnect PAST's child from parent
			if (past.getChild() != null) {

				past.getChild().setParent(null);
				past.setChild(null);
			}
			
			//Update inheritance
			future.setChild(past);
			past.setParent(future);
			
			//Return to the past
			return future.getPast();
		}
		else
		{
			return past;
		}
	}
}