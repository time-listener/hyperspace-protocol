/**
 * 
 */
package org.xmlrobot.space;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Instruction;
import org.xmlrobot.util.Parity;
import org.xmlrobot.util.Commandment;

/**
 * @author joan
 *
 */
public abstract class Expansion
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>>
		extends Repulsion<K,V>
			implements Positron<K,V> {

	/**
	 * 6197078208917947133L
	 */
	private static final long serialVersionUID = 6197078208917947133L;

	/**
     * {@link Expansion} default class constructor.
     */
    public Expansion() {
    	super();
    }
    /**
	 * {@link Expansion} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Expansion(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
    /**
	 * {@link Expansion} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Expansion(
    		Class<? extends Positron<K,V>> type, 
    	    Class<? extends Positron<V,K>> antitype, 
    		K key, V value, Parity gen) {
		super(type, antitype, key, value, gen);
	}
    /**
	 * {@link Expansion} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param root the key
	 * @param value the value
	 */
    protected Expansion(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> root,
    		Positron<V,K> stem) {
		super(type, key, value, root, stem);
	}
    /**
	 * {@link Expansion} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param key the positive
	 * @param value the negative
	 * @param root the parent
	 * @param stem the child
	 */
    protected Expansion(
    		Class<? extends Positron<K,V>> type,
    		Class<? extends Positron<V,K>> antitype,
    		K key, V value,
    		Positron<K,V> root,
    		Positron<V,K> stem) {
		super(type, antitype, key, value, root, stem);
	}
    /**
	 * {@link Expansion} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the key
	 * @param value the value
	 */
    protected Expansion(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> parent,
    		Positron<V,K> child,
    		Parity gen) {
		super(type, key, value, parent, child, gen);
	}
    /**
	 * {@link Expansion} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param key the positive
	 * @param value the negative
	 * @param parent the parent
	 * @param child the child
	 */
    protected Expansion(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> parent, 
    		Positron<V,K> child,
    		Parity gen) {
		super(type, antitype, key, value, parent, child, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void computeNegative(MassListener sender, Mass<K> event,
			Commandment<K,V> unificationFunction) {
		// check event by positive
        if(event.getSource() == getPositive()) {
        	// declare value
            V newValue;
            // apply and check result existence
            if ((newValue = unificationFunction.apply(event.getSource(), getNegative())) == null) {
            	// something to make free
                clear(sender);
            }
            else {
                // allocate or replace old unification
                setNegative(newValue);
            }
        }
    	// check if we arrived to the future
        else if(isEmpty()) {
    		return ;
        }
        // call recursion
        else switch (getGen()) {
		case XY:
			exploitNegative(sender, event, unificationFunction);
			break;
		case XX:
			operateNegative(sender, event, unificationFunction);
			break;
		default:
			processNegative(sender, event, unificationFunction);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void computePositive(MassListener sender, Mass<V> event,
			Commandment<V,K> unificationFunction) {
		// check event by negative
        if(event.getSource() == getNegative()) {
        	// declare new key
            K newKey;
            // apply and check result existence
            if ((newKey = unificationFunction.apply(event.getSource(), getPositive())) == null) {
                // delete positron
            	clear(sender);
            } else {
                // add or replace old unification
                setPositive(newKey);
            }
        }
    	// check if we arrived to the future
        else if(isEmpty()){
        	return ;
        }
        // call recursion
        else switch (getGen()) {
		case XY:
			operatePositive(sender, event, unificationFunction);
			break;
		case XX:
			exploitPositive(sender, event, unificationFunction);
			break;
		default:
			processPositive(sender, event, unificationFunction);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computeNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void computeNegativeIfAbsent(MassListener sender, Mass<K> event,
			Instruction<K,V> unificationFunction) {
		// check event by positive
    	if(event.getSource() == getPositive()) {
    		return;
    	}
    	// check if we arrived to the future
    	else if(isEmpty()) {
    		// declare new negative
    		V newNegative;
    		// execute instruction 
    		if((newNegative = unificationFunction.apply(event.getSource())) != null){
        		// put negative
        		putNegative(sender, event, new Mass<V>(newNegative));
    		}
    		return ;
    	}
    	// call recursion
    	else switch (getGen()) {
		case XY:
			operateNegativeIfAbsent(sender, event, unificationFunction);
			break;
		case XX:
			exploitNegativeIfAbsent(sender, event, unificationFunction);
			break;
		default:
			processNegativeIfAbsent(sender, event, unificationFunction);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#computePositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
	public void computePositiveIfAbsent(MassListener sender, Mass<V> event,
			Instruction<V,K> unificationFunction) {
		// check event by negative
    	if(event.getSource() == getNegative()) {
    		return;
    	}
    	// check if we arrived to the future. So. it's absent.
    	else if(isEmpty()) {
    		// declare new positive
    		K newPositive;
    		// execute instruction 
    		if((newPositive = unificationFunction.apply(event.getSource())) != null) {
        		// put new key-value mapping
    			putPositive(sender, event, new Mass<K>(newPositive));
    		}
    	}
    	// call recursion
    	else switch (getGen()) {
		case XY:
			exploitPositiveIfAbsent(sender, event, unificationFunction);
			break;
		case XX:
			operatePositiveIfAbsent(sender, event, unificationFunction);
			break;
		default:
			processPositiveIfAbsent(sender, event, unificationFunction);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#exploitNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
    public synchronized void exploitNegativeIfAbsent(MassListener sender, Mass<K> event, 
    		Instruction<K,V> unificationFunction) {
		get().computePositiveIfAbsent(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#exploitPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
    public synchronized void exploitPositiveIfAbsent(MassListener sender, Mass<V> event, 
    		Instruction<V,K> unificationFunction) {
		get().computeNegativeIfAbsent(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#processNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
    public synchronized void processNegativeIfAbsent(MassListener sender, Mass<K> event, 
    		Instruction<K,V> unificationFunction) {
		getParent().computeNegativeIfAbsent(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#processPositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
    public synchronized void processPositiveIfAbsent(MassListener sender, Mass<V> event, 
    		Instruction<V,K> unificationFunction) {
		getParent().computePositiveIfAbsent(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#operateNegativeIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
    public synchronized void operateNegativeIfAbsent(MassListener sender, Mass<K> event, 
    		Instruction<K,V> unificationFunction) {
		getChild().computePositiveIfAbsent(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#operatePositiveIfAbsent(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Instruction)
	 */
	@Override
    public synchronized void operatePositiveIfAbsent(MassListener sender, Mass<V> event, 
    		Instruction<V,K> unificationFunction) {
		getChild().computeNegativeIfAbsent(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#exploitNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public synchronized void exploitNegative(MassListener sender, Mass<K> event, 
    		Commandment<K,V> unificationFunction) {
		get().computePositive(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#exploitPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public synchronized void exploitPositive(MassListener sender, Mass<V> event, 
    		Commandment<V,K> unificationFunction) {
		get().computeNegative(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#processNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public synchronized void processNegative(MassListener sender, Mass<K> event, 
    		Commandment<K,V> unificationFunction) {
		getParent().computeNegative(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#processPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public synchronized void processPositive(MassListener sender, Mass<V> event, 
    		Commandment<V,K> unificationFunction) {
		getParent().computePositive(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#operateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public synchronized void operateNegative(MassListener sender, Mass<K> event, 
    		Commandment<K,V> unificationFunction) {
		getChild().computePositive(sender, event, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#operatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public synchronized void operatePositive(MassListener sender, Mass<V> event, 
    		Commandment<V,K> unificationFunction) {
		getChild().computeNegative(sender, event, unificationFunction);
    }
}