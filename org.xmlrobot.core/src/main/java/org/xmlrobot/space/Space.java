/**
 * 
 */
package org.xmlrobot.space;

import java.util.Collection;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Space
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>>
		extends Expansion<K,V>
			implements Positron<K,V> {

	/**
	 * -1869400212817371232L
	 */
	private static final long serialVersionUID = -1869400212817371232L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#getPositive()
	 */
	@Override
	@XmlTransient
	public K getPositive() {
		return super.getPositive();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#setPositive(java.lang.Object)
	 */
	@Override
	public K setPositive(K key) {
		// update key
		K oldKey = super.setPositive(key);
		// check key existence
		if(key != null) {
			// ancestral callback
			key.addMassListener(getValue());
		}
		// check old key existence
		if(oldKey != null) {
			// stop listening prayers
			oldKey.removeMassListener(getValue());
		}
		// return old key
		return oldKey;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#getNegative()
	 */
	@Override
	@XmlTransient
	public V getNegative() {
		return super.getNegative();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Positron#setNegative(java.lang.Object)
	 */
	@Override
	public V setNegative(V value) {
		// update value
		V oldValue = super.setNegative(value);
		// check value existence
		if(value != null) {
			// ancestral callback
			value.addMassListener(getKey());
		}
		// check old value existence
		if(oldValue != null) {
			// stop listening prayers
			oldValue.removeMassListener(getKey());
		}
		// return old value
		return oldValue;
	}
	
	/**
     * {@link Space} default class constructor.
     */
    public Space() {
    	super();
    }
    /**
	 * {@link Space} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Space(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, Parity gen) {
		super(type, positive, negative, gen);
	}
    /**
	 * {@link Space} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Space(
    		Class<? extends Positron<K,V>> type, 
    	    Class<? extends Positron<V,K>> antitype, 
    		K key, V value, Parity gen) {
		super(type, antitype, key, value, gen);
		// listen value's mass
		value.addMassListener(this);
	}
    /**
	 * {@link Space} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param value the value
	 */
    protected Space(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> root, 
    		Positron<V,K> stem) {
		super(type, key, value, root, stem);
		// listen value's mass
		value.addMassListener(this);
	}
    /**
	 * {@link Space} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param stem the value
	 */
    protected Space(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> root, 
    		Positron<V,K> stem) {
		super(type, antitype, key, value, root, stem);
		// listen value's mass
		value.addMassListener(this);
	}
    /**
	 * {@link Space} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param value the value
	 */
    protected Space(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> parent, 
    		Positron<V,K> child,
    		Parity gen) {
		super(type, key, value, parent, child, gen);
		// listen value's mass
		value.addMassListener(this);
	}
    /**
	 * {@link Space} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param child the value
	 */
    protected Space(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> parent, 
    		Positron<V,K> child,
    		Parity gen) {
		super(type, antitype, key, value, parent, child, gen);
		// listen value's mass
		value.addMassListener(this);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> getNegative(MassListener sender, Mass<K> event) {
		if(event.getSource() == getPositive()) {
        	return newNegative();
        }
        else if(isEmpty()) {
        	return null;
        }
        else switch (getGen()) {
		case XY:
			return requestNegative(sender, event);
		case XX:
			return acquireNegative(sender, event);
		default:
			return callNegative(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> getPositive(MassListener sender, Mass<V> event) {
		if(event.getSource() == getNegative()) {
        	return newPositive();
        }
        else if(isEmpty()) {
        	return null;
        }
        else switch (getGen()) {
		case XY:
			return acquirePositive(sender, event);
		case XX:
			return requestPositive(sender, event);
		default:
			return callPositive(sender, event);
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<V> acquireNegative(MassListener sender, Mass<K> event) {
        return get().acquirePositive(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<K> acquirePositive(MassListener sender, Mass<V> event) {
		return get().acquireNegative(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<V> callNegative(MassListener sender, Mass<K> event) {
        return getParent().callNegative(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<K> callPositive(MassListener sender, Mass<V> event) {
    	return getParent().callPositive(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<V> requestNegative(MassListener sender, Mass<K> event) {
		return getChild().acquirePositive(sender, event);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<K> requestPositive(MassListener sender, Mass<V> event) {
    	return getChild().acquireNegative(sender, event);
    }
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getNegativeOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<V> getNegativeOrDefault(MassListener sender, Mass<K> event,
			Mass<V> defaultAntievent) {
		if(event.getSource() == getPositive()) {
        	return newNegative();
        }
        else if(isEmpty()) {
        	return defaultAntievent;
        }
        else switch (getGen()) {
		case XY:
			return acquireNegativeOrDefault(sender, event, defaultAntievent);
		case XX:
			return requestNegativeOrDefault(sender, event, defaultAntievent);
		default:
			return callNegativeOrDefault(sender, event, defaultAntievent);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getPositiveOrDefault(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Mass<K> getPositiveOrDefault(MassListener sender, Mass<V> event,
			Mass<K> defaultAntievent) {
		if(event.getSource() == getNegative()) {
        	return newPositive();
        }
        else if(isEmpty()) {
        	return defaultAntievent;
        }
        else switch (getGen()) {
		case XY:
			return requestPositiveOrDefault(sender, event, defaultAntievent);
		case XX:
			return acquirePositiveOrDefault(sender, event, defaultAntievent);
		default:
			return callPositiveOrDefault(sender, event, defaultAntievent);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#getNegativeOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<V> acquireNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultEvent) {
        return get().acquirePositiveOrDefault(sender, event, defaultEvent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#getPositiveOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<K> acquirePositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultEvent) {
		return get().acquireNegativeOrDefault(sender, event, defaultEvent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#getNegativeOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<V> callNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultEvent) {
		return getParent().callNegativeOrDefault(sender, event, defaultEvent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#getPositiveOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<K> callPositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultEvent) {
		return getParent().callPositiveOrDefault(sender, event, defaultEvent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMass#getNegativeOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<V> requestNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultEvent) {
		return getChild().acquirePositiveOrDefault(sender, event, defaultEvent);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassRunnable#getPositiveOrDefault(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson, org.xmlrobot.horizon.Boson)
	 */
	@Override
    public Mass<K> requestPositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultEvent) {
		return getChild().acquireNegativeOrDefault(sender, event, defaultEvent);
    }

    /* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getByNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<V,K> getByNegative(MassListener sender, Mass<V> event) {
		if(event.getSource() == getNegative()) {
			return newFlop();
		}
		else if(isEmpty()) {
			return null;
		}
		else switch (getGen()) {
		case XY:
			return acquireByNegative(sender, event);
		case XX:
			return requestByNegative(sender, event);
		default:
			return callByNegative(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#getByPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public Graviton<K,V> getByPositive(MassListener sender, Mass<K> event) {
		if(event.getSource() == getPositive()) {
			return newInstant();
		}
		else if(isEmpty()) {
			return null;
		}
		else switch (getGen()) {
		case XY:
			return requestByPositive(sender, event);
		case XX:
			return acquireByPositive(sender, event);
		default:
			return callByPositive(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<K,V> acquireByPositive(MassListener sender, Mass<K> event) {
		return get().acquireByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<V,K> acquireByNegative(MassListener sender, Mass<V> event) {
		return get().acquireByPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<K,V> callByPositive(MassListener sender, Mass<K> event) {
		return getParent().callByPositive(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<V,K> callByNegative(MassListener sender, Mass<V> event) {
		return getParent().callByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMass#getByPositive(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<K,V> requestByPositive(MassListener sender, Mass<K> event) {
		return getChild().acquireByNegative(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassFuture#getByNegative(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Boson)
	 */
	@Override
	public Graviton<V,K> requestByNegative(MassListener sender, Mass<V> event) {
		return getChild().acquireByPositive(sender, event);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Concurrence#run()
	 */
	@Override
	public void run() {
		super.run();
		// listen time
		getNegative().start(getContext());
	}
	
    /* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public Positron.Transmuter<K,V> matrix() {
 		Positron.Transmuter<K,V> m;
 		return (m = (Positron.Transmuter<K,V>) matrix) == null ? 
 				(Positron.Transmuter<K,V>) (matrix = new Transductor()) : m;
	}
	
    /**
     * this field is initialized to contain an instance of the
     * appropriate pole the first time this pole is requested.  The poles are
     * stateless, so there's no reason to create more than one.
     */
	transient volatile Collection<V> pole;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Par#keyVisor()
	 */
	@Override
	public Collection<K> positive() {
		return getValue().negative();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Par#valueVisor()
	 */
	@Override
	public Collection<V> negative() {
		Collection<V> p;
		return (p = pole) == null ? (p = new MassCollection()) : p;
	}
}