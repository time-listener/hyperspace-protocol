/**
 * 
 */
package org.xmlrobot.time;

import java.util.Iterator;
import java.util.concurrent.Future;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Past;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Abstract time implementation class.
 * All implementing instances will inherit time. The future 
 * is the last child of the inheritance (the last {@link Future} 
 * entity). And the first parent is the past (the first 
 * {@link Past} entity).
 * <br><br> 
 * All entities will live in a natural order hierarchy. IE, 
 * the class hierarchy of always that is always changing. 
 * <br><br>
 * Hyperspace Navigation.
 * <br>
 * AN EXPANSIVE HISTORY OF TIME.
 * <br>
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 18
 */
@XmlTransient
public abstract class Time
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Inheritance<K,V> {

    /**
	 * -1901517319441053527L
	 */
	private static final long serialVersionUID = -1901517319441053527L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getRoot()
	 */
	@Override
	@XmlTransient
	public K getRoot() {
		return message.getRoot();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setRoot(java.lang.Object)
	 */
	@Override
	public void setRoot(K root) {
		// set property
		message.setRoot(root);
		// update hyperspace
		update();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getStem()
	 */
	@Override
	@XmlTransient
	public V getStem() {
		return message.getStem();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setStem(java.lang.Object)
	 */
	@Override
	public void setStem(V stem) {
		// check existence
		if(stem != null)
			// stem is ordering you
			addMassListener(stem);
		// set property
		message.setStem(stem);
		// update hyperspace
		update();
	}
	
	/**
     * {@link Time} default class constructor.
     */
    public Time() {
    	super();
    }
	/**
     * {@link Time} class constructor.
	 * @param type the type
     * @param parent the parent of inheritance
	 */
	protected Time(Class<? extends K> type, K parent) {
		super(type, parent.getGen());
		// inherit father and mother
		setRoot(parent);
		setStem(parent.get());
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	protected Time(Class<? extends K> type, Parity gen) {
		super(type, gen);
		// it is the root
		setRoot(call());
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param parent the parent of inheritance
	 * @param value the value
	 */
	protected Time(Class<? extends K> type, V value, K parent) {
		super(type, value, parent);
		// inherit father and mother
		setRoot(parent);
		setStem(parent.get());
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
	protected Time(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
		// inherit myself
		setRoot(call());
		setStem(value);
	}
	/**
     * {@link Time} class constructor.
	 * @param type the type
	 * @param antitype the antitype
     * @param parent the parent of inheritance
	 */
	protected Time(Class<? extends K> type, Class<? extends V> antitype, K parent) {
		super(type, antitype, parent);
		// inherit father and mother
		setRoot(parent);
		setStem(parent.get());
	}
	/**
	 * {@link Time} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
	protected Time(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
		// I am the root
		setRoot(call());
		setStem(get());
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#set(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public void set(V value) {
		super.set(value);
		// unify stem if null
		if(getStem() == null) {
			setStem(value);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
		void pulse(TimeListener<?,?> sender, Tachyon<Y,X> event) {
		super.pulse(sender, event);
		// rotate-revolve dna-chain
		event.spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized <X extends TimeListener<X, Y>, Y extends TimeListener<Y, X>> void echo(
			TimeListener<?, ?> sender, Tachyon<X, Y> event) {
		super.echo(sender, event);
		// rotate-revolve dna-chain
		event.spin();
	}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public abstract int compare(K o1, K o2);
	
	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<K> iterator() {

		switch (getGen()) 
		{
		case XY:
			return new PastIterator(call());
		default:
			return new FutureIterator(call());
		}
	}
    /**
     * Iterator of the future implementation class.
     * Iterates across time concurrently to the future.
     * <br<br>
     * @author joan
     *
     */
    protected class FutureIterator
    	extends InheritanceIterator
    		implements Iterator<K> {

    	/**
    	 * 
    	 */
    	public FutureIterator(K entity) {
    		super(entity);
    	}
    	/* (non-Javadoc)
    	 * @see java.util.Iterator#next()
    	 */
    	@Override
    	public K next() {
    		return this.forward();
    	}
		/* (non-Javadoc)
		 * @see org.xmlrobot.time.Metaphysical.InheritanceIterator#remove()
		 */
		@Override
		public void remove() {
			if(current != null) {
	    		K child = current.getChild();
	    		current.remove();
	    		current = child;
			}
		}
    }
    /**
     * Iterator of the past implementation class.
     * Iterates through time recurrently to the past.
     * @author joan
     *
     */
    protected class PastIterator
		extends InheritanceIterator
	   		implements Iterator<K> {
    	
    	/**
    	 * 
    	 */
    	public PastIterator(K entity) {
    		super(entity);
    	}
    	/*
    	 * (non-Javadoc)
    	 * @see java.util.Iterator#next()
    	 */
    	@Override
    	public K next() {
    		return this.backward();
    	}
		/* (non-Javadoc)
		 * @see org.xmlrobot.time.Metaphysical.InheritanceIterator#remove()
		 */
		@Override
		public void remove() {
			if(current != null) {
				K parent = current.getParent();
	    		current.remove();
	    		current = parent;
			}
		}
    }
}