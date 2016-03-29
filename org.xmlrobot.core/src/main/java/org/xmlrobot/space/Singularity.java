/**
 * 
 */
package org.xmlrobot.space;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.protocol.Hypermass;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Parity;

/**
 * Spacetime singularity implementation class.
 * <br><br>
 * This class creates the massive message.
 * <br><br>
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 19
 */
public abstract class Singularity
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>> 
		extends Time<Positron<K,V>,Positron<V,K>>
			implements Positron<K,V> {

	/**
	 * -239201139092107139L
	 */
	private static final long serialVersionUID = -239201139092107139L;

	protected volatile Hypermass<K,V> mass;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#dna()
	 */
	@Override
	public Hypermass<K,V> dna() {
		return mass.dna();
	}
    /**
     * {@link Singularity} default class constructor.
     */
    public Singularity() {
    	super();
    	// initialize mass
    	mass = new Hypermass<K,V>(super.dna());
    }
    /**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Singularity(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, Parity gen) {
		super(type, gen);
    	// initialize mass
    	mass = new Hypermass<K,V>(super.dna(), positive, negative);
	}
    /**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param positive the positive
	 * @param negative the negative
	 * @param gen {@link Parity} the gender
	 */
    protected Singularity(
    		Class<? extends Positron<K,V>> type, 
    	    Positron<V,K> value, 
    		K positive, V negative, Parity gen) {
		super(type, value, gen);
    	// initialize mass
    	mass = new Hypermass<K,V>(super.dna(), positive, negative);
	}
    /**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param root the root
	 * @param stem the stem
	 */
    protected Singularity(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, root, stem);
    	// initialize mass
    	mass = new Hypermass<K,V>(super.dna(), positive, negative);
	}
    /**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param positive the key
	 * @param negative the value
	 */
    protected Singularity(
    		Class<? extends Positron<K,V>> type, 
    	    Positron<V,K> value, 
    		K positive, V negative, 
    		Positron<K,V> root, Positron<V,K> stem) {
		super(type, value, root, stem);
    	// initialize mass
    	mass = new Hypermass<K,V>(super.dna(), positive, negative);
	}
    
    /**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the parent
	 * @param child the child
	 * @param gen {@link Parity} the gender
	 */
    protected Singularity(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, parent, child, gen);
    	// initialize mass
    	mass = new Hypermass<K,V>(super.dna(), positive, negative);
	}
    /**
	 * {@link Singularity} class constructor.
	 * @param type the type
	 * @param positive the positive
	 * @param negative the negative
	 * @param parent the parent
	 * @param child the child
	 * @param gen {@link Parity} the gender
	 */
    protected Singularity(
    		Class<? extends Positron<K,V>> type, 
    		K positive, V negative, 
    		Positron<V,K> value, 
    		Positron<K,V> parent, Positron<V,K> child, Parity gen) {
		super(type, value, parent, child, gen);
    	// initialize mass
    	mass = new Hypermass<K,V>(super.dna(), positive, negative);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void putNegative(MassListener sender, Graviton<K,V> event) {
		switch (getGen()) {
		case XY:
			assignNegative(sender, event);
			break;
		case XX:
			updateNegative(sender, event);
			break;
		default:
			setNegative(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.Positron#putPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void putPositive(MassListener sender, Graviton<V,K> event) {
		switch (getGen()) {
		case XY:
			updatePositive(sender, event);
			break;
		case XX:
			assignPositive(sender, event);
			break;
		default:
			setPositive(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#updateNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void updateNegative(MassListener sender, Graviton<K,V> event) {
		super.injectKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassRecursion#updatePositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void updatePositive(MassListener sender, Graviton<V,K> event) {
		super.injectValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void setNegative(MassListener sender, Graviton<K,V> event) {
		super.pushKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.RecurrenceMass#setPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void setPositive(MassListener sender, Graviton<V,K> event) {
		super.pushValue(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignNegative(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void assignNegative(MassListener sender, Graviton<K,V> event) {
		super.submitKey(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.positron.MassConcurrence#assignPositive(org.xmlrobot.MassListener, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void assignPositive(MassListener sender, Graviton<V,K> event) {
		super.submitValue(sender, event);
	}
    
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Positron<K,V> clone() {
		try {
			Singularity<K,V> clone = (Singularity<K,V>) super.clone();
			if(mass.getPositive() == null)
				clone.mass = new Hypermass<K,V>(clone.data);
			else clone.mass = new Hypermass<K,V>(clone.data, mass.getPositive(), mass.getNegative());
			return clone;
		}
		catch (ClassCastException | NullPointerException | Abort a) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#newPong()
	 */
	protected Graviton<V,K> newFlop() { 
		
		return new Graviton<V,K>(getValue()) {

			/**
			 * -4754985946176492700L
			 */
			private static final long serialVersionUID = -4754985946176492700L;
		};
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#newPing()
	 */
	protected Graviton<K, V> newInstant() {
		return new Graviton<K,V>(getKey()) {

			/**
			 * -2405628439914991130L
			 */
			private static final long serialVersionUID = -2405628439914991130L;
		};
	}

	
	/**
	 * @author joan
	 */
	protected class MassCollection 
		extends AbstractCollection<V> {
		
		transient Iterator<V> iterator;
		
		/*
		 * (non-Javadoc)
		 * @see java.util.AbstractCollection#iterator()
		 */
		@Override
		public Iterator<V> iterator() {
			return iterator != null ? iterator : (iterator = 
					new MassIterator(getGen().equals(Parity.XY) ? 
							getFutureKey(root()).getKey() : callPastKey(root()).getKey()));
		}
		/*
		 * (non-Javadoc)
		 * @see java.util.AbstractCollection#size()
		 */
		@Override
		public int size() {
			return depth(root()).get();
		}
	}
	/**
	 * Value {@link Iterator} implementation class.
	 * @author joan
	 */
	protected class MassIterator
		extends Hypergear<Positron<K,V>,Positron<V,K>>
			implements Iterator<V> {
		
		/**
		 * @param entity
		 */
		public MassIterator(Positron<K,V> entity) {
			super(entity);
		}
		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		@Override
		public V next() {
			return getGen().equals(Parity.XY) ? 
					backward().getNegative() : forward().getNegative();
		}
		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		@Override
		public void remove() {
			return;
		}
	}
	/**
	 * Returns a new positive event.
	 * @return a new positive event
	 */
	protected Mass<K> newPositive() {
		// instance boson
		return new Mass<K>(getPositive());
	}
	/**
	 * Returns a new negative event.
	 * @return a new negative event
	 */
	protected Mass<V> newNegative() {
		// create boson
		return new Mass<V>(getNegative());
	}
	
    /**
     * Returns a comparator that compares {@link Map.Entry} in natural order on key.
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing an entry with a null key.
     * @param  <K> the {@link Comparable} type of then map keys
     * @param  <V> the type of the map values
     * @return a comparator that compares {@link Map.Entry} in natural order on key.
     * @see Comparable
     * @since 1.8
     */
    protected static <K extends Comparable<? super K>, V> java.util.Comparator<Map.Entry<K,V>> comparingByKey() {
        return (java.util.Comparator<Map.Entry<K,V>> & Serializable)
            (c1, c2) -> c1.getKey().compareTo(c2.getKey());
    }
    /**
     * Returns a comparator that compares {@link Map.Entry} in natural order on value.
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing an entry with null values.
     * @param <K> the type of the map keys
     * @param <V> the {@link Comparable} type of the map values
     * @return a comparator that compares {@link Map.Entry} in natural order on value.
     * @see Comparable
     * @since 1.8
     */
    protected static <K,V extends Comparable<? super V>> java.util.Comparator<Map.Entry<K,V>> comparingByValue() {
        return (java.util.Comparator<Map.Entry<K,V>> & Serializable)
            (c1, c2) -> c1.getValue().compareTo(c2.getValue());
    }
    /**
     * Returns a comparator that compares {@link Map.Entry} by key using the given
     * {@link Comparator}.
     * <p>The returned comparator is serializable if the specified comparator
     * is also serializable.
     * @param  <K> the type of the map keys
     * @param  <V> the type of the map values
     * @param  cmp the key {@link Comparator}
     * @return a comparator that compares {@link Map.Entry} by the key.
     * @since 1.8
     */
    protected static <K,V> java.util.Comparator<Map.Entry<K,V>> comparingByKey(java.util.Comparator<? super K> cmp) {
        Objects.requireNonNull(cmp);
        return (java.util.Comparator<Map.Entry<K,V>> & Serializable)
            (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
    }
    /**
     * Returns a comparator that compares {@link Map.Entry} by value using the given
     * {@link Comparator}.
     * <p>The returned comparator is serializable if the specified comparator
     * is also serializable.
     * @param  <K> the type of the map keys
     * @param  <V> the type of the map values
     * @param  cmp the value {@link Comparator}
     * @return a comparator that compares {@link Map.Entry} by the value.
     * @since 1.8
     */
    protected static <K,V> java.util.Comparator<Map.Entry<K,V>> comparingByValue(java.util.Comparator<? super V> cmp) {
        Objects.requireNonNull(cmp);
        return (java.util.Comparator<Map.Entry<K,V>> & Serializable)
            (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
    }
}