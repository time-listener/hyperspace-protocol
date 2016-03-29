	/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlElement;

import org.xmlrobot.Hypergenesis;
import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * The unification of everything and nothing.
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 2
 *
 */
public abstract class Unification
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Hypergenesis<K,V>
			implements TimeListener<K,V> {

	/**
	 * 5574710177408508814L
	 */
	private static final long serialVersionUID = 5574710177408508814L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#getType()
	 */
	@Override
	@XmlElement
	public Class<? extends K> getType() {
		return data.getType();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> value) {
		data.setType(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#getAntitype()
	 */
	@Override
	@XmlElement
	public Class<? extends V> getAntitype() {
		return data.getAntitype();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#setAntitype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> value) {
		data.setAntitype(value);
	}
	
	/**
     * {@link Unification} default class constructor.
     */
	public Unification() {
		super();
	}
	/**
     * {@link Unification} class constructor.
	 * @param type the type
     * @param gen {@link Parity} the gender
	 */
	protected Unification(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
 	/**
     * {@link Unification} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Unification(Class<? extends K> type, V value, Parity gen) {
		super(type, value.getType(), value, gen);
		// put past
		set(value);
		// set future
		put(getKey());
	}
	/**
     * {@link Unification} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Unification(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
	/**
	 * @param type
	 * @param value
	 * @param parent
	 * @param child
	 * @param gen
	 */
	protected Unification(Class<? extends K> type, V value, K parent, V child){
		super(type, value.getType(), value, parent, child);
		// put past
		put(parent.call());
		// set future
		set(child.call());
	}
	/**
     * {@link Unification} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Unification(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem);
	}
	/**
	 * @param type
	 * @param value
	 * @param root
	 * @param stem
	 * @param gen
	 */
	protected Unification(Class<? extends K> type, V value, K root, V stem, Parity gen){
		super(type, value.getType(), value, root, stem);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#unify()
	 */
	@Override
	public void unify(MassListener sender) {
		// set value's future
		put(getKey());
		// set future
		set(getValue());
		// set parent
		setParent(getKey());
		// set child
		setChild(getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#allocateValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void allocateValue(MassListener source, Tachyon<V,K> event) {
		// commute event
		switch (getGen()) {
		case YY:
			deliverValue(source, event);
			break;
		default:
			orderValue(source, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#allocateKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void allocateKey(MassListener source, Tachyon<K,V> event) {
		switch (getGen()) {
		case YY:
			deliverKey(source, event);
			break;
		default:
			orderKey(source, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#deliverValue(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void deliverValue(MassListener sender, Tachyon<V,K> event) {
		// commute by parity
		switch (getGen()) {
		case XY:
			submitValue(sender, event);
			break;
		case XX:
			injectValue(sender, event);
			break;
		default:
			pushValue(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#deliverKey(org.xmlrobot.MassListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void deliverKey(MassListener sender, Tachyon<K,V> event) {
		// commute by parity
		switch (getGen()) {
		case XY:
			injectKey(sender, event);
			break;
		case XX:
			submitKey(sender, event);
			break;
		default:
			pushKey(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#orderValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderValue(MassListener sender, Tachyon<V,K> event) {
		switch (getGen()) {
		case XY:
			orderInferValue(sender, event);
			break;
		case XX:
			orderSuperValue(sender, event);
			break;
		default:
			orderWeakValue(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#orderKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void orderKey(MassListener sender, Tachyon<K,V> event) {
		switch (getGen()) {
		case XY:
			orderSuperKey(sender, event);
			break;
		case XX:
			orderInferKey(sender, event);
			break;
		default:
			orderStrongKey(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#sendKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> sendKey(MassListener sender, Tachyon<K,V> event) {
		switch (getGen()) {
		case XY:
			return lendKey(sender, event);
		case XX:
			return giveKey(sender, event);
		default:
			return openKey(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#sendValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> sendValue(MassListener sender, Tachyon<V,K> event) {
		switch (getGen()) {
		case XY:
			return giveValue(sender, event);
		case XX:
			return lendValue(sender, event);
		default:
			return openValue(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#receiveKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> receiveKey(MassListener sender, Tachyon<K,V> event) {
		switch (getGen()) {
		case XY:
			return takeKey(sender, event);
		case XX:
			return borrowKey(sender, event);
		default:
			return closeKey(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#receiveValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> receiveValue(MassListener sender, Tachyon<V,K> event) {
		switch (getGen()) {
		case XY:
			return borrowValue(sender, event);
		case XX:
			return takeValue(sender, event);
		default:
			return closeValue(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tickKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tickKey(MassListener sender, Tachyon<K,V> event) {
		switch (getGen()) {
		case XY:
			popKey(sender, event);
			break;
		case XX:
			flipKey(sender, event);
			break;
		default:
			pingKey(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tickValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tickValue(MassListener sender, Tachyon<V,K> event) {
		switch (getGen()) {
		case XY:
			flipValue(sender, event);
			break;
		case XX:
			popValue(sender, event);
			break;
		default:
			pingValue(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tackValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tackValue(MassListener sender, Tachyon<V,K> event) {
		switch (getGen()) {
		case XY:
			pollValue(sender, event);
			break;
		case XX:
			flopValue(sender, event);
			break;
		default:
			pongValue(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#tackKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void tackKey(MassListener sender, Tachyon<K,V> event) {
		switch (getGen()) {
		case XY:
			flopKey(sender, event);
			break;
		case XX:
			pollKey(sender, event);
			break;
		default:
			pongKey(sender, event);
			break;
		}
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.TimeListener#spinValue(org.xmlrobot.TimeListener)
     */
    @Override
	public synchronized void spinValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
    	switch (getGen()) {
		case XY:
			rotateValue(sender, N, event);
			break;
		case XX:
			revolveValue(sender, N, event);
			break;
		default:
			permuteValue(sender, N, event);
			/*AtomicInteger depth = depth();
			Tachyon<K,V> event = acquireKey(sender, newAtomicInteger(depth));
			permuteKeyOffspring(sender, depth, event);*/
			break;
		}
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.TimeListener#spinKey(org.xmlrobot.TimeListener)
     */
    @Override
	public synchronized void spinKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
    	switch (getGen()) {
		case XY:
			revolveKey(sender, N, event);
			break;
		case XX:
			rotateKey(sender, N, event);
			break;
		default:
			permuteKey(sender, N, event);
			/*AtomicInteger recurrence = recurrence(sender, new AtomicInteger(0));
			Tachyon<V,K> event = callValue(sender, newAtomicInteger(recurrence));
			permuteValueAncestry(sender, recurrence, event);*/
			break;
		}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.TimeListener#swapKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public void swapKey(MassListener sender, Tachyon<K,V> event) {
    	switch (getGen()) {
		case XY:
			commuteKey(sender, event);
			break;
		case XX:
			exchangeKey(sender, event);
			break;
		default:
			switchKey(sender, event);
			break;
		}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.TimeListener#swapValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public void swapValue(MassListener sender, Tachyon<V,K> event) {
    	switch (getGen()) {
		case XY:
			exchangeValue(sender, event);
			break;
		case XX:
			commuteValue(sender, event);
			break;
		default:
			switchValue(sender, event);
			break;
		}
    }
	/**
	 * Iterator of the past implementation class. Iterates through time concurrently to the future.
	 * <p>This class is a member of the <tt>hyperspace congregation framework</tt></p>.
	 * @author joan
	 */
	protected class FutureIterator
		extends Hypergear<K,V>
	   		implements Iterator<K> {
	   	/**
	   	 * 
	   	 */
	   	public FutureIterator(K entity) {
	   		super(entity);
	   	}
	   	
	   	/*
	   	 * (non-Javadoc)
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
			K k = next;
			if(current != null) {
		   		// remove current child from inheritance
				current.clear(root());
		   		// check if we are on the limits
				if(k != null) {
		    		current = k;
		    		next = k.get().getValue();
				}
			}
			else throw new NoSuchElementException();
		}
	}
	/**
	 * Iterator of the past implementation class. Iterates through time
	 * recurrently to the past.
	 * <p>This class is a member of the <tt>hyperspace congregation framework</tt></p>
	 * @author joan
	 */
	protected class PastIterator 
		extends Hypergear<K,V> 
			implements Iterator<K> {

		/**
		 * {@link PastIterator} default class constructor.
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
		/*
		 * (non-Javadoc)
		 * @see org.xmlrobot.time.Metaphysical.InheritanceIterator#remove()
		 */
		@Override
		public void remove() {
			K k = next;
			if (current != null) {
				// remove current child from inheritance
				current.clear(root());
				// check if we are on the limits
				if (k != null) {
					current = k;
					next = k.getParent();
				}
			} 
			else throw new NoSuchElementException();
		}
	}
	/**
	 * Enumerator of the past implementation class. Enumerates across time
	 * recurrently to the past.
	 * <p>This class is a member of the <tt>hyperspace congregation framework</tt></p>.
	 * @author joan
	 */
	protected class PastEnumerator 
		extends Hypergear<V, K> 
			implements Enumeration<V> {

		/**
		 * @param value
		 */
		public PastEnumerator(V value) {
			super(value);
		}

		/*
		 * (non-Javadoc)
		 * @see java.util.Enumeration#nextElement()
		 */
		@Override
		public V nextElement() {
			return this.backward();
		}
	}
	/**
	 * Enumerator of the future implementation class. Enumerates across time
	 * concurrently to the future.
	 * <p>This class is a member of the <tt>hyperspace congregation framework</tt></p>.
	 * @author joan
	 */
	protected class FutureEnumerator 
		extends Hypergear<V, K> 
			implements Enumeration<V> {
		/**
		 * @param value
		 */
		public FutureEnumerator(V value) {
			super(value);
		}
		/*
		 * (non-Javadoc)
		 * @see java.util.Enumeration#nextElement()
		 */
		@Override
		public V nextElement() {
			return this.forward();
		}
	}
}