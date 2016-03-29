/**
 * 
 */
package org.xmlrobot.time;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Democracy implementation class.
 * 
 * Why don't we define this term collectively?
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 11
 */
public abstract class Democracy
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Freedom<K,V> 
			implements TimeListener<K,V> {

	/**
	 * 1581805954083115896L
	 */
	private static final long serialVersionUID = 1581805954083115896L;

    /**
     * {@link Democracy} default class constructor.
     */
    public Democracy() {
    	super();
    }
	/**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Democracy(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Democracy(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param parent the key
	 */
	protected Democracy(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
    protected Democracy(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param root the key
	 */
	protected Democracy(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Democracy} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the parent
	 * @param stem the child
	 */
    protected Democracy(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#switchKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void switchKey(MassListener sender, Tachyon<K,V> event) {
		// declare listener inheritance
		K parent = event.getParent();
		V child = event.getChild();
		V future = event.get();
		K past = event.call();
		// set parent's future
		getParent().set(event.getValue());
		// set listener value's parent
		event.setChild(getChild());
		// set child's future
		getChild().set(event.getKey());
		// set listener's parent
		event.setParent(getParent());
		// set listener's future
		event.set(get());
		// set future's parent
		get().setParent(event.getValue());
		// set listener value's future
		event.put(call());
		// set past's parent
		call().setParent(event.getKey());
		// set listener parent's future
		parent.set(getValue());
		// set value's parent
		setChild(child);
		// set listener child's future
		child.set(getKey());
		// set parent
		setParent(parent);
		// set future
		set(future);
		// set listener future's parent
		future.setChild(getKey());
		// set value's future
		getValue().set(past);
		// set past parent
		past.setChild(getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#switchValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void switchValue(MassListener sender, Tachyon<V,K> event) {
		// declare listener inheritance
		V parent = event.getParent();
		K child = event.getChild();
		K future = event.get();
		V past = event.call();
		// set parent's future
		getParent().set(event.getKey());
		// set event's parent
		event.setParent(getChild());
		// set child's future
		getChild().set(event.getValue());
		// set event value's parent
		event.setChild(getParent());
		// set event's future
		event.set(call());
		// set past's parent
		call().setParent(event.getValue());
		// set event value's future
		event.put(get());
		// set future's parent
		get().setParent(event.getKey());
		// set parent's future
		parent.set(getKey());
		// set parent
		setParent(child);
		// set child's future
		child.set(getValue());
		// set value's parent
		setChild(parent);
		// set future
		set(past);
		// set past's parent
		past.setParent(getValue());
		// set value's future
		getValue().set(future);
		// set future's parent
		future.setParent(getKey());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#commuteValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void commuteValue(MassListener sender, Tachyon<V,K> event) {
		// declare listener inheritance
		V parent = event.getParent();
		K child = event.getChild();
		K future = event.get();
		V past = event.call();
		// set parent's future
		getParent().put(event.getValue());
		// set event's parent
		event.getKey().setParent(getChild());
		// set child's future
		getParent().set(event.getKey());
		// set event value's parent
		event.getKey().setChild(getParent());
		// set event's future
		event.getKey().set(call());
		// set past's parent
		call().setParent(event.getValue());
		// set event value's future
		event.getKey().put(get());
		// set future's parent
		get().setParent(event.getKey());
		// set parent's future
		parent.set(getKey());
		// set parent
		getValue().setChild(child);
		// set child's future
		child.set(getValue());
		// set value's parent
		getValue().setParent(parent);
		// set future
		getValue().put(past);
		// set past's parent
		past.setParent(getValue());
		// set value's future
		getValue().set(future);
		// set future's parent
		future.setParent(getKey());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#commuteKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void commuteKey(MassListener sender, Tachyon<K,V> event) {
		// declare listener inheritance
		K parent = event.getParent();
		V child = event.getChild();
		V future = event.get();
		K past = event.call();
		// set parent's future
		getChild().put(event.getValue());
		// set listener value's parent
		event.getValue().setParent(getChild());
		// set child's future
		getChild().set(event.getKey());
		// set listener's parent
		event.getValue().setChild(getParent());
		// set listener's future
		event.getValue().put(get());
		// set future's parent
		get().setParent(event.getValue());
		// set listener value's future
		event.getValue().set(call());
		// set past's parent
		get().setChild(event.getKey());
		// set listener parent's future
		parent.put(getKey());
		// set value's parent
		getValue().setParent(child);
		// set listener child's future
		child.put(getValue());
		// set parent
		getValue().setChild(parent);
		// set future
		getValue().put(future);
		// set listener future's parent
		future.setChild(getKey());
		// set value's future
		getValue().set(past);
		// set past parent
		past.setChild(getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#exchangeValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void exchangeValue(MassListener sender, Tachyon<V,K> event) {
		// declare listener inheritance
		V parent = event.getParent();
		K child = event.getChild();
		K future = event.get();
		V past = event.call();
		// set parent's future
		getChild().set(event.getValue());
		// set event's parent
		event.getValue().setChild(getChild());
		// set child's future
		getChild().put(event.getKey());
		// set event value's parent
		event.getValue().setParent(getParent());
		// set event's future
		event.getValue().put(call());
		// set past's parent
		get().setParent(event.getKey());
		// set event value's future
		event.getValue().set(get());
		// set future's parent
		get().setChild(event.getValue());
		// set parent's future
		parent.set(getKey());
		// set parent
		getKey().setParent(child);
		// set child's future
		child.put(getKey());
		// set value's parent
		getKey().setChild(parent);
		// set future
		getKey().set(past);
		// set past's parent
		past.setChild(getKey());
		// set value's future
		getKey().put(future);
		// set future's parent
		future.setChild(getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#exchangeKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public void exchangeKey(MassListener sender, Tachyon<K,V> event) {
		// declare listener inheritance
		K parent = event.getParent();
		V child = event.getChild();
		V future = event.get();
		K past = event.call();
		// set parent's future
		getParent().set(event.getValue());
		// set listener value's parent
		event.getKey().setChild(getChild());
		// set child's future
		getParent().put(event.getKey());
		// set listener's parent
		event.getKey().setParent(getParent());
		// set listener's future
		event.getKey().set(get());
		// set future's parent
		call().setChild(event.getValue());
		// set listener value's future
		event.getKey().put(call());
		// set past's parent
		call().setParent(event.getKey());
		// set listener parent's future
		parent.set(getValue());
		// set value's parent
		getValue().setParent(child);
		// set listener child's future
		child.put(getValue());
		// set parent
		getValue().setChild(parent);
		// set future
		getValue().put(future);
		// set listener future's parent
		future.setParent(getValue());
		// set value's future
		getValue().set(past);
		// set past parent
		past.setParent(getKey());
	}
}