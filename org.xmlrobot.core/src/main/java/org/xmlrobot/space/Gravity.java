/**
 * 
 */
package org.xmlrobot.space;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.util.Commandment;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Gravity
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>> 
		extends Contraction<K,V>
			implements Positron<K,V> {

	/**
	 * 881059332716381271L
	 */
	private static final long serialVersionUID = 881059332716381271L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#getPositive()
	 */
	@Override
	public K getPositive() {
		return mass.getPositive();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.PastMass#setPositive(java.lang.Object)
	 */
	@Override
	public K setPositive(K key) {
		// update key
		K oldKey = mass.setPositive(key);
		// update value
		getValue().dna().setNegative(key);
		// update hyperspace
		mass.update();
		// return old key
		return oldKey;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#getNegative()
	 */
	@Override
	public V getNegative() {
		return mass.getNegative();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassFuture#setNegative(java.lang.Object)
	 */
	@Override
	public V setNegative(V value) {
		// update key
		V oldValue = mass.setNegative(value);
		// update value
		getValue().dna().setPositive(value);
		// update hyperspace
		mass.update();
		// return old value
		return oldValue;
	}
	
    /**
     * {@link Gravity} default class constructor.
     */
    public Gravity() {
    	super();
    }
    /**
	 * {@link Gravity} class constructor.
	 * @param type the type
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Gravity(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, Parity gen) {
		super(type, key, value, gen);
	}
    /**
	 * {@link Gravity} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param key the positive
	 * @param value the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Gravity(
    		Class<? extends Positron<K,V>> type, 
    	    Class<? extends Positron<V,K>> antitype, 
    		K key, V value, Parity gen) {
		super(type, instance(antitype, value, key, Parity.opposite(gen)), 
				key, value, gen);
	}
    /**
	 * {@link Gravity} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param root the parent
	 * @param stem the child
	 */
    protected Gravity(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, key, value, root, stem);
	}
    /**
	 * {@link Gravity} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param key the positive
	 * @param value the negative
	 * @param root the parent
	 * @param stem the child
	 */
    protected Gravity(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> root, Positron<V,K> stem) {
    	// call hyper-constructor
		super(type, instance(antitype, value, key, stem, root), 
				key, value, root, stem);
	}
    /**
	 * {@link Gravity} class constructor.
	 * @param key the positive
	 * @param value the negative
	 * @param parent the parent
	 * @param child the child
	 */
    protected Gravity(
    		Class<? extends Positron<K,V>> type, 
    		K key, V value, 
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, key, value, parent, child, gen);
	}
    /**
	 * {@link Gravity} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param key the positive
	 * @param value the negative
	 * @param parent the parent
	 * @param child the child
	 */
    protected Gravity(
    		Class<? extends Positron<K,V>> type, 
    		Class<? extends Positron<V,K>> antitype, 
    		K key, V value,
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
    	// call hyper-constructor
		super(type, instance(antitype, value, key, child, parent, Parity.opposite(gen)), 
				key, value, parent, child, gen);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.TimeListener)
     */
    @Override
    public int compareTo(Positron<K,V> o) {
    	return getNegative().compareTo(o.getNegative());
    }
    

	/**
	 * The implementation of mass transmutation.
	 * @author joan
	 */
	protected class Transductor 
		extends Grid
			implements Positron.Transmuter<K,V> {
		
		/**
		 * @param output
		 */
		public Transductor() {
			super(instance(getAntitype(), getType(), 
					getNegative(), getPositive(), getStem(), getRoot()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#push(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void inject(Positron<K,V> key) {
			// clone child
			put(key.getPositive(), key.getNegative());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#inject(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void push(Positron<V,K> value) {
			// clone child
			put(value.getNegative(), value.getPositive());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Mass.Transmuter#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(K key, V value){
			// submit to the future
			output.putNegative(output, new Mass<V>(value), new Mass<K>(key));
		}
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#mergeNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void mergeNegative(MassListener sender, Mass<K> event,
			Mass<V> antievent, Commandment<V,V> unificationFunction) {
		 // check equality
    	if(event.getSource() == getPositive()) {
    		// execute function and update returned negative
            setNegative(unificationFunction.apply(getNegative(), antievent.getSource()));
    	}
    	else if(isEmpty()) {
    		return ;
    	}
    	else switch (getGen()) {
		case XY:
			bindNegative(sender, event, antievent, unificationFunction);
			break;
		case XX:
			engageNegative(sender, event, antievent, unificationFunction);
			break;
		default:
			unifyNegative(sender, event, antievent, unificationFunction);;
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#mergePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void mergePositive(MassListener sender, Mass<V> event,
			Mass<K> antievent, Commandment<K,K> unificationFunction) {
		// check equality
    	if(event.getSource() == getNegative()) {
    		// execute function and update returned positive
    		setPositive(unificationFunction.apply(getPositive(), antievent.getSource()));
    	}
    	else if(isEmpty()) {
    		return ;
    	}
    	else switch (getGen()) {
		case XY:
			engagePositive(sender, event, antievent, unificationFunction);
			break;
		case XX:
			bindPositive(sender, event, antievent, unificationFunction);
			break;
		default:
			unifyPositive(sender, event, antievent, unificationFunction);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#bindNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public void bindNegative(MassListener sender, Mass<K> event, Mass<V> antievent, 
    		Commandment<V,V> unificationFunction) {
        get().mergePositive(sender, event, antievent, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#bindPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
    public void bindPositive(MassListener sender, Mass<V> event, Mass<K> antievent, 
    		Commandment<K,K> unificationFunction) {
		get().mergeNegative(sender, event, antievent, unificationFunction);
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#unifyNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void unifyNegative(MassListener sender, Mass<K> event, Mass<V> antievent, Commandment<V,V> unificationFunction) {
       getParent().mergeNegative(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#unifyPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void unifyPositive(MassListener sender, Mass<V> event, Mass<K> antievent, Commandment<K,K> unificationFunction) {
		getParent().mergePositive(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#engageNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void engageNegative(MassListener sender, Mass<K> event, Mass<V> antievent, Commandment<V,V> unificationFunction) {
        getChild().mergePositive(sender, event, antievent, unificationFunction);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#engagePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass, org.xmlrobot.util.Commandment)
	 */
	@Override
	public void engagePositive(MassListener sender, Mass<V> event, Mass<K> antievent, Commandment<K,K> unificationFunction) {
		getChild().mergeNegative(sender, event, antievent, unificationFunction);
	}
}