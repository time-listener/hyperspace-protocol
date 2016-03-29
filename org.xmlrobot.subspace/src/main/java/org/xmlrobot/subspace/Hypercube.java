/**
 * 
 */
package org.xmlrobot.subspace;

import java.util.concurrent.atomic.AtomicReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.lang.Hyperstring;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.subspace.mass.Hypermap;
import org.xmlrobot.subspace.mass.Hyperset;
import org.xmlrobot.util.Parity;

/**
 * The hypercube. 
 * 
 * <p>In metaphysics, a hypercube is an N-dimensional analogue of a map and a set. 
 * It is a closed, compact, convex entity whose 1-abstract consists of congregation of 
 * opposite parallel par sequences aligned in each of the hyperspace's dimensions, 
 * concurrent to each other and of the same depth. A unit hypercube's longest 
 * recursion factor in N-dimensions is equal to N.
 * 
 * <p>It is one of the datagrams being sent between entities to get communicated through the 
 * abstract protocol. Some hypercube examples: word, one, phrase, two, oration, three, mass, 
 * four, sermon, five order, six, XML, seven, javadoc, eight, etc.
 * 
 * <p>The hypercube is the hyperchain. And the hyperchain is the hypercube. So, changes 
 * in the hypercube will be reflected in the hyperchain. And vice-versa.
 * 
 * <p>This class is just another member of the {@code hyperspace congregation framework}
 * 
 * @author joan
 * @parity XY
 * @since 1513.1
 */
@XmlRootElement
public final class Hypercube 
	extends Hyperstring {
	
	/**
	 * 6719183340586278648L
	 */
	private static final long serialVersionUID = 6719183340586278648L;

	/**
	 * The backing map,
	 */
	Hypermap map;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getName()
	 */
	@Override
	@XmlElement
	public String getName() {
		return characterArrayToString(fromArray());
	}
	
	/**
	 * {@link Hypercube} default class constructor.
	 */
	public Hypercube() {
		super();
	}
	/**
	 * {@link Hypercube} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
	public Hypercube(Character key, Integer value) {
		super(Hypercube.class, key, value, Parity.XY);
		// instance map
		map = new Hypermap(Hyperset.class, key, value);
	}
	/**
	 * {@link Hypercube} class constructor.
	 * @param antitype the antitype
	 * @param key the key
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
    public Hypercube(Class<Hyperchain> antitype, Character from, Integer to) {
		super(Hypercube.class, antitype, from, to, Parity.XY);
		// listen map
		map.addMassListener(getValue());
		map.getValue().addMassListener(this);
	}
    /**
	 * {@link Hypercube} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param parent the key
	 * @param value the value
	 */
    public Hypercube(Character key, Integer value, Hypercube parent, Hyperchain child) {
		super(Hypercube.class, key, value, parent, child);
		// instance map
		map = new Hypermap(Hyperset.class, key, value, parent.map, child.set);
	}
    /**
	 * {@link Hypercube} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param parent the root
	 * @param child the stem
	 */
    public Hypercube(Class<Hyperchain> antitype, Character key, Integer value, Hypercube parent, Hyperchain child) {
		super(Hypercube.class, antitype, key, value, parent, child);
		// listen map
		map.addMassListener(getValue());
		map.getValue().addMassListener(this);
	}
    /**
	 * {@link Hypercube} class constructor.
	 * @param key the key
	 * @param value the value
	 * @param root the root
	 * @param stem the stem
	 */
    public Hypercube(Character key, Integer value, Hypercube root, Hyperchain stem, Parity gen) {
		super(Hypercube.class, key, value, root, stem, gen);
		// instance map
		map = new Hypermap(Hyperset.class, key, value, root.map, stem.set);
	}
    /**
	 * {@link Hypercube} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param stem the value
	 */
    public Hypercube(Class<Hyperchain> antitype, Character key, Integer value, Hypercube root, Hyperchain stem, Parity gen) {
		super(Hypercube.class, antitype, key, value, root, stem, gen);
		// listen map
		map.addMassListener(getValue());
		map.getValue().addMassListener(this);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void put(Character key, Integer value) {
		// create chain
		Hyperchain chain = new Hyperchain(Hypercube.class, value, key, (Hyperchain) getValue(), this);
		// add chain
		entrySet().add(chain);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Hyperspace#setValue(org.xmlrobot.TimeListener)
	 */
	@Override
	public Metatext<Integer,Character> setValue(Metatext<Integer,Character> value) {
		Hyperchain chain = (Hyperchain) value;
		chain.set = (Hyperset) map.getValue();
		return super.setValue(value);
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		// get reference
		ServiceReference<?> ref = event.getServiceReference();
		try {
			Object obj = ref.getProperty(TimeListener.KEY);
			AtomicReference<?> atom = (AtomicReference<?>) obj; 
			// assign and check
			if (atom.get() instanceof Hypercube) {
				// commute command
				if (event.getType() == ServiceEvent.REGISTERED) {
					// cast reference
					Hypercube cube = (Hypercube) atom.get();
					
					if(!map.containsFrom(root(), new Mass<Character>(cube.getFrom()))){
						// new key-value par
						map.put(cube.getFrom(), cube.getTo());	
					}
				}
			}
		}
		catch (ClassCastException | NullPointerException ex) {
			return;
		}
	}
}