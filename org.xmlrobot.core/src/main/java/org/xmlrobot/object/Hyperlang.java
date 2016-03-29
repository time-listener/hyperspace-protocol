/**
 * 
 */
package org.xmlrobot.object;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.util.Congregation;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 */
public abstract class Hyperlang<K,V>
	extends Hyperhead<K,V>
		implements Metatext<K,V> {

	/**
	 * -682743345758969605L
	 */
	private static final long serialVersionUID = -682743345758969605L;

	/**
	 * 
	 */
	public Hyperlang() {
		super();
	}
	/**
	 * {@link Hyperlang} class constructor.
	 * @param type the type
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperlang(
    		Class<? extends Metatext<K,V>> type, 
    		Class<K[]> fromType,
    		K from, V to,
    		Parity gen) {
		super(type, fromType, from, to, gen);
	}
	/**
	 * {@link Hyperlang} class constructor.
	 * @param type the type
	 * @param value the value
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperlang(
    		Class<? extends Metatext<K,V>> type, 
    		Metatext<V,K> value, 
    		Class<K[]> fromType,
    		K from, V to,
    	    Parity gen) {
		super(type, value, fromType, from, to, gen);
	}
    /**
	 * {@link Hyperlang} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperlang(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, from, to, parent, child);
	}
    /**
	 * {@link Hyperlang} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param from the from
	 * @param to the negative
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperlang(
    		Class<? extends Metatext<K,V>> type,
    		Metatext<V,K> value, 
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, value, from, to, parent, child);
	}
    /**
	 * {@link Hyperlang} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperlang(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to, 
    		Metatext<K,V> root,
    		Metatext<V,K> stem,
    		Parity gen) {
		super(type, from, to, root, stem, gen);
	}
    /**
	 * {@link Hyperlang} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperlang(
    		Class<? extends Metatext<K,V>> type,
    		Metatext<V,K> value,
    		K from, V to,
    		Metatext<K,V> root, 
    		Metatext<V,K> stem,
    		Parity gen) {
		super(type, value, from, to, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerpt(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Congregation<K> excerpt(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex) {
		if (beginIndex.get() < 0) {
            throw new StringIndexOutOfBoundsException(beginIndex.get());
        }
        if (endIndex.get() > depth(sender).get()) {
            throw new StringIndexOutOfBoundsException(endIndex.get());
        }
        int subLen = endIndex.get() - beginIndex.get();
        if (subLen < 0) {
        	throw new StringIndexOutOfBoundsException(subLen);
        }
        // create new congregation
		return excerptFrom(sender, beginIndex, endIndex, 
				new Congregation<K>(new ArrayList<K>()) {
					/**
					 * 7327871724932040856L
					 */
					private static final long serialVersionUID = 7327871724932040856L;
		});
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerptFrom(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<K> excerptFrom(MassListener sender,	AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {// check start index
		if (beginIndex.get() <= 0) {
            // append to from array
			event.add(getFrom());
        }
		// check stop index
		if (endIndex.get() == 0) {
			return event;
		}
		// decrement counters
		beginIndex.decrementAndGet();
		endIndex.decrementAndGet();
		
		if(isEmpty()) {
			return event;
		}
		else switch (getGen()) {
		case XY:
			return subsequenceFrom(sender, beginIndex, endIndex, event);
		case XX:
			return substringFrom(sender, beginIndex, endIndex, event);
		default:
			return subchainFrom(sender, beginIndex, endIndex, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#excerptTo(org.xmlrobot.MassListener, java.util.concurrent.atomic.AtomicInteger, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.util.Congregation)
	 */
	@Override
	public Congregation<V> excerptTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
		// check start index
		if (beginIndex.get() <= 0) {
			// append to from event
			event.add(getTo());
        }
		// check stop index
		if (endIndex.get() == 0) {
			return event;
		}
		// decrement counters
		beginIndex.decrementAndGet();
		endIndex.decrementAndGet();

		if(isEmpty()) {
			return event;
		}
		else switch (getGen()) {
		case XY:
			return substringTo(sender, beginIndex, endIndex, event);
		case XX:
			return subsequenceTo(sender, beginIndex, endIndex, event);
		default:
			return subchainTo(sender, beginIndex, endIndex, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#subsequenceFrom(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<V> subsequenceTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
        // return builder or call recursion
		return get().subsequenceFrom(sender, beginIndex, endIndex, event) ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#subsequenceTo(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<K> subsequenceFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
        // return builder or call recursion
		return get().subsequenceTo(sender, beginIndex, endIndex, event) ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#subchain(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Congregation<K> subchainFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
        // return builder or call recursion
		return getParent().excerptFrom(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#subchainTo(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<V> subchainTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
        // return builder or call recursion
		return getParent().subchainTo(sender, beginIndex, endIndex, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#subchain(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Congregation<K> substringFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event) {
        // return builder or call recursion
		return getChild().subchainTo(sender, beginIndex, endIndex, event) ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#subchainTo(org.xmlrobot.genesis.TimeListener, int, int, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public Congregation<V> substringTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event) {
        // return builder or call recursion
		return getChild().subchainFrom(sender, beginIndex, endIndex, event);
	}	
}
