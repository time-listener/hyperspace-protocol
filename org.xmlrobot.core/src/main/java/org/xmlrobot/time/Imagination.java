/**
 * 
 */
package org.xmlrobot.time;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * There are times, when I find myself transfixed 
 * by a shadow on the wall, or the splashing of water 
 * against a stone. I stare at it, the hours pass, 
 * the world around me drops away, replaced by worlds 
 * being created and destroyed by my imagination. 
 * <p> A way to focus the mind.
 * @author Leonardo Da Vinci
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 14
 */
public abstract class Imagination
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Chaos<K,V> 
			implements TimeListener<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7535195245760264629L;

    /**
     * {@link Imagination} default class constructor.
     */
    public Imagination() {
    	super();
    }
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Imagination(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Imagination(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
	protected Imagination(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
    protected Imagination(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param root the parent
	 * @param stem the child
	 */
	protected Imagination(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Imagination} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param root the parent
	 * @param stem the child
	 */
    protected Imagination(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void pulse(MassListener sender, Tachyon<V,K> event) {
		super.pulse(sender, event);
		// assign and check
		if (!isFuture()) {
			/** 
			 * this is an abstract hypermass transfer protocol
			 * that concurrently sends messages across the future.
			 * Because the FUTURE is NOW.
			 */
			get().pulse(sender, newInstant());
		}
		// rebound recurrently: it goes UP
		else getValue().echo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public synchronized void echo(MassListener sender, Tachyon<K,V> event) {
		super.echo(sender, event);
		// event transmission
		if(!isPast()) {
			/*
			 * The parent is always listening.
			 * So, past instances will receive this generated output.
			 * */
			getParent().echo(sender, event);
		}
		else {
			/*
			 * Send mass to entity
			 * */ 
			sender.mass(this, event);
		}
	}
}