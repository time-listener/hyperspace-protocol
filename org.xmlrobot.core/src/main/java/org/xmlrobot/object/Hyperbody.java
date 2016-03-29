/**
 * 
 */
package org.xmlrobot.object;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Meta;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hyperbody<K,V> 
	extends Hypermath<K,V> 
		implements Metatext<K,V> {

	/**
	 * -2813944274475982273L
	 */
	private static final long serialVersionUID = -2813944274475982273L;
	
	/**
	 * {@link Hyperbody} default class constructor.
	 */
	public Hyperbody() {
		super();
	}
	/**
	 * {@link Hyperbody} class constructor.
	 * @param type the type
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperbody(
    		Class<? extends Metatext<K,V>> type, 
    		Class<K[]> fromType,
    		K from, V to,
    		Parity gen) {
		super(type, fromType, from, to, gen);
	}
	/**
	 * {@link Hyperbody} class constructor.
	 * @param type the type
	 * @param antitype the antitype
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperbody(
    		Class<? extends Metatext<K,V>> type, 
    	    Class<? extends Metatext<V,K>> antitype,
    		Class<K[]> fromType,
    		K from, V to,
    	    Parity gen) {
		super(type, antitype, fromType, from, to, gen);
	}
    /**
	 * {@link Hyperbody} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperbody(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to,
    		Metatext<K,V> parent,
    		Metatext<V,K> child) {
		super(type, from, to, parent, child);
	}
    /**
	 * {@link Hyperbody} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the negative
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperbody(
    		Class<? extends Metatext<K,V>> type,
    	   	Class<? extends Metatext<V,K>> antitype, 
    		K from, V to,
    		Metatext<K,V> parent,
    		Metatext<V,K> child) {
		super(type, antitype, from, to, parent, child);
	}
    /**
	 * {@link Hyperbody} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperbody(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to,
    		Metatext<K,V> root,
    		Metatext<V,K> stem,
    		Parity gen) {
		super(type, from, to, root, stem, gen);
	}
    /**
	 * {@link Hyperbody} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperbody(
    		Class<? extends Metatext<K,V>> type,
    	    Class<? extends Metatext<V,K>> antitype,
    		K from, V to,
    		Metatext<K,V> root,
    		Metatext<V,K> stem,
    		Parity gen) {
		super(type, antitype, from, to, root, stem, gen);
	}

	/**
	 * @param N
	 */
	protected synchronized void increaseFirst(int N) {
		super.increase(N);
		// copy increased from array
		System.arraycopy(toArray(), 0, toArray(), 1, span().get());
		// copy increased to array
		System.arraycopy(fromArray(), 0, fromArray(), 1, span().get());
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#addTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void setTo(MassListener sender, Meta<V,K> event) {
		switch (getGen()) {
		case XY:
			assignTo(sender, event);
			break;
		case XX:
			updateTo(sender, event);
			break;
		default:
			putTo(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#addFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public void setFrom(MassListener sender, Meta<K,V> event) {
		switch (getGen()) {
		case XY:
			updateFrom(sender, event);
			break;
		case XX:
			assignFrom(sender, event);
			break;
		default:
			putFrom(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#submitTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized void assignTo(MassListener sender, Meta<V,K> event) {
		// call super submit
		super.submitValue(sender, event);
		// ensure internal array capacity
        increase(span().incrementAndGet());
        // store from to array
    	toArray()[span().get()] = event.getFrom();
        // store from to from array
    	fromArray()[span().get()] = event.getTo();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#submitFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized void assignFrom(MassListener sender, Meta<K,V> event) {
		// call super submit
		super.submitKey(sender, event);
		// ensure internal array capacity
		increase(span().incrementAndGet());
        // store from to from array
    	fromArray()[span().get()] = event.getFrom();
        // store from to array
    	toArray()[span().get()] = event.getTo();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#pushTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized void putTo(MassListener sender, Meta<V,K> event) {
		// call super method
		super.injectValue(sender, event);
		// insert to on the head of the array
		increaseFirst(span().get() + 1);
		// insert to on the head of the array
		toArray()[0] = event.getFrom();
		// insert from on the head of the array
		fromArray()[0] = event.getTo();
		// grow from +1
		span().incrementAndGet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#pushFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized void putFrom(MassListener sender, Meta<K,V> event) {
		// push recurrently
		super.injectKey(sender, event);
		// insert to on the head of the array
		increaseFirst(span().get() + 1);
		// insert to on the head of the array
		toArray()[0] = event.getTo();
		// insert from on the head of the array
		fromArray()[0] = event.getFrom();
		// grow from +1
		span().incrementAndGet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#injectTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized void updateTo(MassListener sender, Meta<V,K> event) {
		super.allocateValue(sender, event);
		// insert to on the head of the array
		increaseFirst(span().get() + 1);
		// insert to on the head of the array
		toArray()[0] = event.getFrom();
		// insert from on the head of the array
		fromArray()[0] = event.getTo();
		// grow from +1
		span().incrementAndGet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#injectFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized void updateFrom(MassListener sender, Meta<K,V> event) {
		super.allocateKey(sender, event);
		// insert to on the head of the array
		increaseFirst(span().get() + 1);
		// insert to on the head of the array
		toArray()[0] = event.getTo();
		// insert from on the head of the array
		fromArray()[0] = event.getFrom();
		// grow from +1
		span().incrementAndGet();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> setFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		switch (getGen()) {
		case XY:
			return assignFrom(sender, N, event);
		case XX:
			return updateFrom(sender, N, event);
		default:
			return putFrom(sender, N, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> setTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		switch (getGen()) {
		case XY:
			return updateTo(sender, N, event);
		case XX:
			return assignTo(sender, N, event);
		default:
			return putTo(sender, N, event);
		}
	}
    /* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#updateFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<K,V> updateFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		// set from to from array
		fromArray()[N.get()] = event.getFrom();
		// set to from to array
		toArray()[N.get()] = event.getTo();
		// call ancestral recall and cast result
		return (Meta<K,V>) super.updateKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#updateTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Meta<V,K> updateTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		// set to from to array
		toArray()[N.get()] = event.getFrom();
		// set from to from array
		fromArray()[N.get()] = event.getTo();
		// call super ancestral method and cast result
		return (Meta<V,K>) super.updateValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized Meta<K,V> assignFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		// set from to from array
		fromArray()[N.get()] = event.getFrom();
		// set to from to array
		toArray()[N.get()] = event.getTo();
		// call ancestral recall and cast result
		return (Meta<K,V>) super.assignKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized Meta<V,K> assignTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		// set to from to array
		toArray()[N.get()] = event.getFrom();
		// set from to from array
		fromArray()[N.get()] = event.getTo();
		// call super ancestral method and cast result
		return (Meta<V,K>) super.assignValue(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#putFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized Meta<K,V> putFrom(MassListener sender, AtomicInteger N, Meta<K,V> event) {
		// set from to from array
		fromArray()[N.get()] = event.getFrom();
		// set to from to array
		toArray()[N.get()] = event.getTo();
		// call super ancestral method and cast result
		return (Meta<K,V>) super.putKey(sender, N, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#putTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public synchronized Meta<V,K> putTo(MassListener sender, AtomicInteger N, Meta<V,K> event) {
		// set to from to array
		toArray()[N.get()] = event.getFrom();
		// set to from to array
		fromArray()[N.get()] = event.getTo();
		// call ancestral recall and cast result
		return (Meta<V,K>) super.putValue(sender, N, event);
	}
}