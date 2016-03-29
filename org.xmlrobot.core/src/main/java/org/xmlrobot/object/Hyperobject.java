/**
 * 
 */
package org.xmlrobot.object;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hyperobject<K,V> 
	extends Hyperbody<K,V> 
		implements Metatext<K,V> {

	/**
	 * -353112447622126146L
	 */
	private static final long serialVersionUID = -353112447622126146L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#getFrom()
	 */
	@Override
	@XmlTransient
	public K getFrom() {
		return message.getFrom();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#setFrom(java.lang.Object)
	 */
	@Override
	public K setFrom(K key) {
		return message.setFrom(key);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#getTo()
	 */
	@Override
	@XmlTransient
	public V getTo() {
		return message.getTo();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#setTo(java.lang.Object)
	 */
	@Override
	public V setTo(V value) {
		return message.setTo(value);
	}
	
	/**
	 * {@link Hyperobject} default class constructor.
	 */
	public Hyperobject() {
		super();
	}
	/**
	 * {@link Hyperobject} class constructor.
	 * @param type the type
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperobject(
    		Class<? extends Metatext<K,V>> type,
    		Class<K[]> fromType,
    		K from, V to,
    		Parity gen) {
		super(type, fromType, from, to, gen);
	}
	/**
	 * {@link Hyperobject} class constructor.
	 * @param type the type
	 * @param antitype the antitype
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperobject(
    		Class<? extends Metatext<K,V>> type, 
    	    Class<? extends Metatext<V,K>> antitype,
    		Class<K[]> fromType,
    		K from, V to,
    	    Parity gen) {
		super(type, antitype, fromType, from, to, gen);
	}
    /**
	 * {@link Hyperobject} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperobject(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, from, to, parent, child);
	}
    /**
	 * {@link Hyperobject} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the negative
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperobject(
    		Class<? extends Metatext<K,V>> type,
    		Class<? extends Metatext<V,K>> antitype,
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, antitype, from, to, parent, child);
	}
    /**
	 * {@link Hyperobject} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperobject(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to, 
    		Metatext<K,V> root, 
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, from, to, root, stem, gen);
	}
    /**
	 * {@link Hyperobject} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperobject(
    		Class<? extends Metatext<K,V>> type,
    		Class<? extends Metatext<V,K>> antitype,
    		K from, V to,
    		Metatext<K,V> root,
    		Metatext<V,K> stem,
    		Parity gen) {
		super(type, antitype, from, to, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> getFrom(MassListener sender, Mass<V> event) {
		if(event.getSource() == getTo()) {
			return new Mass<K>(getFrom());
		}
		else if(isEmpty()) {
			return null;
		}
		else switch (getGen()) {
		case XY:
			return acquireFrom(sender, event);
		case XX:
			return requestFrom(sender, event);
		default:
			return callFrom(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> getTo(MassListener sender, Mass<K> event) {
		if(event.getSource() == getFrom()) {
			return new Mass<V>(getTo());
		}
		else if(isEmpty()) {
			return null;
		}
		else switch (getGen()) {
		case XY:
			return requestTo(sender, event);
		case XX:
			return acquireTo(sender, event);
		default:
			return callTo(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#acquireFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> acquireFrom(MassListener sender, Mass<V> event) {
		return get().getTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#acquireTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> acquireTo(MassListener sender, Mass<K> event) {
		return get().getFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#callTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> callTo(MassListener sender, Mass<K> event) {
		return getParent().callTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#callFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> callFrom(MassListener sender, Mass<V> event) {
		return getParent().callFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#requestTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> requestTo(MassListener sender, Mass<K> event) {
		return getChild().getFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#requestFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> requestFrom(MassListener sender, Mass<V> event) {
		return getChild().getTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<V> getTo(MassListener sender, AtomicInteger N) {
		switch (getGen()) {
		case XY:
			return acquireTo(sender, N);
		case XX:
			return requestTo(sender, N);
		default:
			return callTo(sender, N);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#getFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<K> getFrom(MassListener sender, AtomicInteger N) {
		switch (getGen()) {
		case XY:
			return requestFrom(sender, N);
		case XX:
			return acquireFrom(sender, N);
		default:
			return callFrom(sender, N);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#callFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<K> callFrom(MassListener sender, AtomicInteger N) {
    	return new Mass<K>(super.callKey(sender, N).getKey().getFrom());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#callTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<V> callTo(MassListener sender, AtomicInteger N) {
    	return new Mass<V>(super.callValue(sender, N).getValue().getTo());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#requestFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<K> requestFrom(MassListener sender, AtomicInteger N) {
    	return new Mass<K>(super.requestKey(sender, N).getKey().getFrom());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#requestTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<V> requestTo(MassListener sender, AtomicInteger N) {
    	return new Mass<V>(super.requestValue(sender, N).getValue().getTo());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#acquireFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<K> acquireFrom(MassListener sender, AtomicInteger N) {
    	return new Mass<K>(super.acquireKey(sender, N).getValue().getTo());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#acquireTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Mass<V> acquireTo(MassListener sender, AtomicInteger N) {
    	return new Mass<V>(super.acquireValue(sender, N).getKey().getFrom());
	}
	
    /**
     * this field is initialized to contain an instance of the
     * appropriate pole the first time this pole is requested.  The poles are
     * stateless, so there's no reason to create more than one.
     */
	transient volatile Collection<V> pole;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#head()
	 */
	@Override
	public Collection<K> head() {
		return getValue().body();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Metatext#body()
	 */
	@Override
	public Collection<V> body() {
		Collection<V> p;
		return (p = pole) == null ? (p = new AbstractCollection<V>() {

			@Override
			public Iterator<V> iterator() {
				
				return null;
			}

			@Override
			public int size() {
				
				return 0;
			}
		}) : p ;
	}
}