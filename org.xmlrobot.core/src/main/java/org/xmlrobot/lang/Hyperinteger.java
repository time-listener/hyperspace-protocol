/**
 * 
 */
package org.xmlrobot.lang;

import org.xmlrobot.metatext.MetaSet;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.object.Hyperobject;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hyperinteger
	extends Hyperobject<Integer,Character>
		implements MetaSet<Integer,Character> {

	/**
	 * 3991395513255739387L
	 */
	private static final long serialVersionUID = 3991395513255739387L;
	
	/**
     * {@link Hyperinteger} default class constructor.
     */
    public Hyperinteger() {
    	super();
    }
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperinteger(
    		Class<? extends Hyperinteger> type,
    		Integer from, Character to,
    		Parity gen) {
		super(type, Integer[].class, from, to, gen);
	}
	/**
	 * {@link Hyperinteger} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperinteger(
    		Class<? extends Hyperinteger> type, 
    	    Class<? extends Hyperstring> antitype,
    		Integer from, Character to,
    	    Parity gen) {
		super(type, antitype, Integer[].class, from, to, gen);
	}
    /**
	 * {@link Hyperinteger} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param value the value
	 */
    protected Hyperinteger(
    		Class<? extends Hyperinteger> type, 
    		Integer key, Character value, 
    		Hyperinteger root,
    		Hyperstring stem) {
		super(type, key, value, root, stem);
	}
    /**
	 * {@link Hyperinteger} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Hyperinteger(
    		Class<? extends Hyperinteger> type, 
    		Class<? extends Hyperstring> antitype, 
    		Integer key, Character value,
    		Hyperinteger root, 
    		Hyperstring stem) {
		super(type, antitype, key, value, root, stem);
	}
    /**
	 * {@link Hyperinteger} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param value the value
	 */
    protected Hyperinteger(
    		Class<? extends Hyperinteger> type, 
    		Integer key, Character value, 
    		Hyperinteger parent,
    		Hyperstring child, 
    		Parity gen) {
		super(type, key, value, parent, child, gen);
	}
    /**
	 * {@link Hyperinteger} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Hyperinteger(
    		Class<? extends Hyperinteger> type, 
    		Class<? extends Hyperstring> antitype, 
    		Integer key, Character value,
    		Hyperinteger parent, 
    		Hyperstring child,
    		Parity gen) {
		super(type, antitype, key, value, parent, child, gen);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Metatext<Integer, Character> o) {
		return getTo().compareTo(o.getTo());
	}
}