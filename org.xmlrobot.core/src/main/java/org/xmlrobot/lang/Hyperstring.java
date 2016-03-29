/**
 * 
 */
package org.xmlrobot.lang;

import org.xmlrobot.metatext.MetaMap;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.object.Hyperobject;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hyperstring 
	extends Hyperobject<Character,Integer> 
		implements MetaMap<Character,Integer> {
	
	/**
	 * -340864647399150399L
	 */
	private static final long serialVersionUID = -340864647399150399L;
	
	/**
     * {@link Hyperstring} default class constructor.
     */
    public Hyperstring() {
    	super();
    }
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperstring(
    		Class<? extends Hyperstring> type,
    		Character from, Integer to,
    		Parity gen) {
		super(type, Character[].class, from, to, gen);
	}
	/**
	 * {@link Hyperstring} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperstring(
    		Class<? extends Hyperstring> type, 
    	    Class<? extends Hyperinteger> antitype,
    		Character from, Integer to,
    	    Parity gen) {
		super(type, antitype, Character[].class, from, to, gen);
	}
    /**
	 * {@link Hyperstring} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param root the key
	 * @param value the value
	 */
    protected Hyperstring(
    		Class<? extends Hyperstring> type, 
    		Character key, Integer value, 
    		Hyperstring root, Hyperinteger stem) {
		super(type, key, value, root, stem);
	}
    /**
	 * {@link Hyperstring} class constructor.
	 * @param type the type
	 * @param key the key
	 * @param value the value
	 * @param root the root
	 * @param stem the stem
	 */
    protected Hyperstring(
    		Class<? extends Hyperstring> type, 
    		Class<? extends Hyperinteger> antitype, 
    		Character key, Integer value,
    		Hyperstring root, 
    		Hyperinteger stem) {
		super(type, antitype, key, value, root, stem);
	}
    /**
	 * {@link Hyperstring} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
    protected Hyperstring(
    		Class<? extends Hyperstring> type, 
    		Character key, Integer value, 
    		Hyperstring parent, Hyperinteger child, Parity gen) {
		super(type, key, value, parent, child, gen);
	}
    /**
	 * {@link Hyperstring} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Hyperstring(
    		Class<? extends Hyperstring> type, 
    		Class<? extends Hyperinteger> antitype, 
    		Character key, Integer value,
    		Hyperstring parent, 
    		Hyperinteger child,
    		Parity gen) {
		super(type, antitype, key, value, parent, child, gen);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Metatext<Character,Integer> o) {
		return getTo().compareTo(o.getTo());
	}
	
}