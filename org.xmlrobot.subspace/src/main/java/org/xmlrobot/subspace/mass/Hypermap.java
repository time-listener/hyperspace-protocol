package org.xmlrobot.subspace.mass;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.lang.Hyperstring;
import org.xmlrobot.metatext.MetaMap;
import org.xmlrobot.util.Parity;

/**
 * A {@link Hyperpar} that is {@link MetaMap}.
 * {@link Character} is the key {@link Integer} is the value.
 * @author joan
 */
@XmlRootElement
public class Hypermap 
	extends Hyperstring {

	/**
	 * -7185825228654393308L
	 */
	private static final long serialVersionUID = -7185825228654393308L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.antimatter.Hyperpar#getName()
	 */
	@Override
	public String getName() {
		return characterArrayToString(fromArray());
	}
	
	/**
	 * {@link Hypermap} default class constructor.
	 */
	public Hypermap() {
		super();
	}
	/**
	 * {@link Hypermap} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	public Hypermap(Character key, Integer value) {
		super(Hypermap.class, key, value, Parity.XY);
	}
	/**
	 * {@link Hypermap} class constructor.
	 * @param antitype the antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	public Hypermap(Class<Hyperset> antitype, Character from, Integer to) {
		super(Hypermap.class, antitype, from, to, Parity.XY);
	}
    /**
	 * {@link Hypermap} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param root the key
	 * @param value the value
	 */
	public Hypermap(Character key, Integer value, Hypermap root, Hyperset stem) {
		super(Hypermap.class, key, value, root, stem);
	}
    /**
	 * {@link Hypermap} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param root the root
	 * @param stem the stem
	 */
	public Hypermap(Class<Hyperset> antitype, Character key, Integer value, Hypermap root, Hyperset stem) {
		super(Hypermap.class, antitype, key, value, root, stem);
	}
    /**
	 * {@link Hypermap} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param parent the parent
	 * @param child the child
	 */
	public Hypermap(Character key, Integer value, Hypermap parent, Hyperset child, Parity gen) {
		super(Hypermap.class, key, value, parent, child, gen);
	}
    /**
	 * {@link Hypermap} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param child the value
	 */
	public Hypermap(Class<Hyperset> antitype, Character key, Integer value, Hypermap parent, Hyperset child,
    		Parity gen) {
		super(Hypermap.class, antitype, key, value, parent, child, gen);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.DNA#put(java.lang.Object, java.lang.Object)
	 */
	public void put(Character key, Integer value) {
		// instance par
		Hypermap par = new Hypermap(Hyperset.class, 
				key, value, this, (Hyperset) getValue());
		// call sequence for order
		entrySet().add(par.getValue());
	}

	@Override
	public void serviceChanged(ServiceEvent event) {
		// TODO Auto-generated method stub
		
	}
}