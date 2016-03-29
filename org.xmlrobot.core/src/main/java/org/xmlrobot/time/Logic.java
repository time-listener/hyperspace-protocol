/**
 * 
 */
package org.xmlrobot.time;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.hyperspace.Hyperspace;
import org.xmlrobot.util.Parity;

/**
 * Peace (XX), love (YY) and marijuana (XY) implementation class.
 * <p> Logic is the study of the principles of reasoning. 
 * As a form of science, logic is used to solve various problems 
 * through the implementation of abstract reasoning.
 * <p>Live long and prosper.
 * 
 * @author joan YY
 *
 * @see Hyperclock
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 9
 *
 */
public abstract class Logic
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Hyperspace<K,V> 
			implements TimeListener<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8412022895632713684L;

    /**
     * {@link Logic} default class constructor.
     */
    public Logic() {
    	super();
    }
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Logic(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Logic(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Logic(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
    protected Logic(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param root the root
	 * @param stem the stem
	 * @param gen {@link Parity} the gender
	 */
	protected Logic(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the root
	 * @param stem the stem
	 * @param gen {@link Parity} the gender
	 */
    protected Logic(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#isPast()
	 */
	@Override
	public boolean isPast() {
		return getParent() == getRoot();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#isFuture()
	 */
	@Override
	public boolean isFuture() {
		return get() == getStem();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return isPast() || isFuture();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#clear()
	 */
	@Override
	public synchronized void clear(MassListener sender) {
		// set key's value
		getParent().set(get());
		// set value's key
		get().setParent(getChild());
		// set parent's value
		getChild().set(call());
		// set child's key
		call().setParent(getParent());
		// unify 
		unify(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#holdsKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
    public boolean containsKey(MassListener sender, Tachyon<K,V> event) {
		if(event.getKey() == getKey()){
			return true;
		}
		else if(isEmpty()){
			return false;
		}
		else switch (getGen()) {
		case XY:
			return holdsKey(sender, event);
		case XX:
			return belongsKey(sender, event);
		default:
			return hasKey(sender, event);
		}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.TimeListener#holdsValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public boolean containsValue(MassListener sender, Tachyon<V,K> event) {
    	if(event.getKey() == getValue()) {
			return true;
		}
		else if(isEmpty()){
			return false;
		}
		else switch (getGen()) {
		case XY:
			return belongsValue(sender, event);
		case XX:
			return holdsValue(sender, event);
		default:
			return hasValue(sender, event);
		}
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#containsKey(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean holdsKey(MassListener sender, Tachyon<K,V> event) {
		return get().containsValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#containsValue(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean holdsValue(MassListener sender, Tachyon<V,K> event) {
		return get().containsKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#hasKey(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean hasKey(MassListener sender, Tachyon<K,V> event) {
		return getParent().hasKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#hasValue(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean hasValue(MassListener sender, Tachyon<V,K> event) {
		return getParent().hasValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#belongsKey(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean belongsKey(MassListener sender, Tachyon<K,V> event) {
		return getChild().belongsValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#belongsValue(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public boolean belongsValue(MassListener sender, Tachyon<V,K> event) {
		return getChild().belongsKey(sender, event);
	}
}