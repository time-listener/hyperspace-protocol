package org.xmlrobot.subspace;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceReference;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.lang.Hyperinteger;
import org.xmlrobot.lang.Hyperstring;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.subspace.mass.Hypermap;
import org.xmlrobot.subspace.mass.Hyperset;
import org.xmlrobot.util.Parity;

/**
 * The hyperchain.
 * 
 * <p>In metaphysics, a hyperchain is an N-dimensional analogue of a set and a map. 
 * It is a closed, compact, convex entity whose 1-abstract consists of congregation of 
 * opposite parallel entry chains aligned in each of the hyperspace's dimensions, 
 * recurrent to every other and of the same depth. A unit hyperchain's longest 
 * recursion factor in N-dimensions is equal to N.
 * 
 * <p>It is one of the datagrams being sent between entities to get communicated through the 
 * abstract protocol. Some hyperchain examples: one, word, two, phrase, three, oration, four, 
 * mass, five, sermon, six, order, seven, XML, eight, javadoc, etc.
 * 
 * <p>The hypercube is the hyperchain. And the hyperchain is the hypercube. So, changes 
 * in the hypercube will be reflected in the hyperchain. And vice-versa.
 * 
 * <p>This class is just another member of the {@code hyperspace congregation framework}
 * 
 * @author joan
 *
 */
@XmlRootElement
public class Hyperchain 
	extends Hyperinteger {

	/**
	 * -59178645027008260L
	 */
	private static final long serialVersionUID = -59178645027008260L;

	/**
	 * The backing set.
	 */
	Hyperset set;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#getName()
	 */
	@Override
	@XmlElement
	public String getName() {	
		return characterArrayToString(toArray());
	}

	/**
     * {@link Hyperchain} default class constructor.
     */
	public Hyperchain() {
    	super();
    }
	/**
	 * {@link Hyperchain} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperchain(Integer from, Character to) {
		super(Hyperchain.class, from, to, Parity.XX);
	}
	/**
	 * {@link Hyperchain} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperchain(Class<Hypercube> antitype, Integer from, Character to) {
		super(Hyperchain.class, antitype, from, to, Parity.XX);
	}
    /**
	 * {@link Hyperchain} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param value the value
	 */
    protected Hyperchain(Integer key, Character value, Hyperchain root, Hyperstring stem) {
		super(Hyperchain.class, key, value, root, stem);
	}
    /**
	 * {@link Hyperchain} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Hyperchain(Class<Hypercube> antitype, 
    		Integer key, Character value, Hyperchain root, Hyperstring stem) {
		super(Hyperchain.class, antitype, key, value, root, stem);
	}
    /**
	 * {@link Hyperchain} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param value the value
	 */
    protected Hyperchain(Integer key, Character value, Hyperchain parent, Hypercube child, Parity gen) {
		super(Hyperchain.class, key, value, parent, child, gen);
	}
    /**
	 * {@link Hyperchain} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Hyperchain(Class<Hypercube> antitype,
    		Integer key, Character value, Hyperchain parent, Hypercube child, Parity gen) {
    	super(Hyperchain.class, antitype, key, value, parent, child, gen);
    }
    
    /* (non-Javadoc)
     * @see org.xmlrobot.hyperspace.Hyperspace#setValue(org.xmlrobot.TimeListener)
     */
    @Override
    public Metatext<Character,Integer> setValue(Metatext<Character,Integer> value) {
		Hypercube cube = (Hypercube) value;
		cube.map = (Hypermap) set.getValue();
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
			if (atom.get() instanceof Hyperchain) {
				// commute command
				if (event.getType() == ServiceEvent.UNREGISTERING) {
					Mass<Integer> key = new Mass<Integer>(((Hyperchain) atom.get()).getFrom());
					// new key-value par
					set.redeemFrom(root(), new AtomicInteger(0), key);
				}
			}
		}
		catch (ClassCastException | NullPointerException ex) {
			return;
		}
	}
}
