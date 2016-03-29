/**
 * 
 */
package org.xmlrobot.object;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hyperclock<K,V> 
	extends Hyperlang<K,V>
		implements Metatext<K,V> {

	/**
	 * -8771534028220094958L
	 */
	private static final long serialVersionUID = -8771534028220094958L;
	
	/**
	 * {@link Hyperclock} default class constructor.
	 */
	public Hyperclock() {
		super();
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperclock(
    		Class<? extends Metatext<K,V>> type, 
    		Class<K[]> fromType,
    		K from, V to,
    		Parity gen) {
		super(type, fromType, from, to, gen);
	}
	/**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param antitype the antitype
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperclock(
    		Class<? extends Metatext<K,V>> type, 
    	    Class<? extends Metatext<V,K>> antitype,
    		Class<K[]> fromType,
    		K from, V to,
    	    Parity gen) {
		super(type, instance(antitype, to, from, Parity.opposite(gen)), 
				fromType, from, to, gen);
	}
    /**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperclock(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, from, to, parent, child);
	}
    /**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the negative
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hyperclock(
    		Class<? extends Metatext<K,V>> type,
    	    Class<? extends Metatext<V,K>> antitype, 
    		K from, V to,
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, instance(antitype, to, from, child, parent), 
				from, to, parent, child);
	}
    /**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperclock(
    		Class<? extends Metatext<K,V>> type,
    		K from, V to, 
    		Metatext<K,V> root, 
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, from, to, root, stem, gen);
	}
    /**
	 * {@link Hyperclock} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperclock(
    		Class<? extends Metatext<K,V>> type,
    		Class<? extends Metatext<V,K>> antitype, 
    		K from, V to,
    		Metatext<K,V> root, 
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, instance(antitype, to, from, stem, root), 
				from, to, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		switch (getGen()) {
		case XY:
			assignTo(sender, event, antievent);
			break;
		case XX:
			updateTo(sender, event, antievent);
			break;
		default:
			putTo(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#setTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void setFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		switch (getGen()) {
		case XY:
			updateFrom(sender, event, antievent);
			break;
		case XX:
			assignFrom(sender, event, antievent);
			break;
		default:
			putFrom(sender, event, antievent);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#putFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		if (event.getSource() == getFrom()) {
			setTo(antievent.getSource());
		} else if (isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), event.getSource(),
					antievent.getSource(), getChild(), getParent(),
					Parity.opposite(getGen()));
		}
		// call recursion
		else getParent().setTo(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.RecurrenceMeta#putTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void putFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check event existence
		if (event.getSource() == getTo()) {
			setFrom(antievent.getSource());
		}
		// check future
		else if (isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getChild(), getParent(), Parity.opposite(getGen()));
		}
		// call recursion
		else getParent().setFrom(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#updateTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check event existence
		if (event.getSource() == getTo()) {
			setFrom(antievent.getSource());
		}
		// check future
		else if (isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), event.getSource(),
					antievent.getSource(), getChild(), getParent(),
					Parity.opposite(getGen()));
		}
		// call recursion
		else getChild().setTo(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaRecursion#updateFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void updateTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		if (event.getSource() == getFrom()) {
			setTo(antievent.getSource());
		} 
		else if (isPast()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getChild(), getParent(), Parity.opposite(getGen()));
		}
		// call recursion
		else getChild().setFrom(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void assignFrom(MassListener sender, Mass<V> event, Mass<K> antievent) {
		// check event existence
		if (event.getSource() == getTo()) {
			setFrom(antievent.getSource());
		}
		// check future
		else if (isFuture()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), 
					event.getSource(), antievent.getSource(), 
					getValue(), getKey(), Parity.opposite(getGen()));
		}
		// call recursion
		else get().setTo(sender, event, antievent);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaConcurrence#assignFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public void assignTo(MassListener sender, Mass<K> event, Mass<V> antievent) {
		// check event existence
		if (event.getSource() == getFrom()) {
			setTo(antievent.getSource());
		} else if (isFuture()) {
			// key is not in the chain: create it
			instance(getAntitype(), getType(), antievent.getSource(),
					event.getSource(), getValue(), getKey(),
					Parity.opposite(getGen()));
		}
		// call recursion
		else get().setFrom(sender, event, antievent);
	}

    
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#matrix()
	 */
	@Override
	public Metatext.Translocator<K,V> matrix() {
		Metatext.Translocator<K,V> m;
 		return (m = (Metatext.Translocator<K,V>) matrix) != null ? 
 				m : (Metatext.Translocator<K,V>) (matrix = new Hypermatrix());
	}
	
	/**
	 * Information transcoder implementation class. 
	 * @author joan
	 */
	protected class Hypermatrix
 		extends Comparator {

		/**
		 * {@link Transcoder} default class constructor.
		 */
		public Hypermatrix() {
			super(instance(getAntitype(), getType(), getStem(), getRoot()));
		}

		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Hypergenesis.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int reproduce(Metatext<K,V> key, Metatext<V,K> value) {
			
			int cmp = super.compare(key.getValue(), value);
			
			if(key.getGen().equals(Parity.XY) ? cmp > 0 : cmp < 0) {
				output().setTo(value.getTo());
				output().setFrom(value.getFrom());
				return -1;
			}
			else if(cmp == 0) {
				output().setTo(key.getFrom());
				output().setFrom(key.getTo());
				// doubled paired output: evolve
				push(instance(getAntitype(), getAntitype(), 
						value.getFrom(), value.getTo(), 
						getStem(), getRoot()));
				return 0;
			}
			else {
				output().setTo(key.getFrom());
				output().setFrom(key.getTo());
				return 1;
			}
		}
	}
 	/**
	 * The Hypergrid. A hyper-digital hyper-frontier. 
	 * <p>I hyper-tried to hyper-picture hyper-clusters of hyper-information as they hyper-moved through 
	 * the hyper-computer. What did they hyper-look like? Hyper-Ships, hyper-motorcycles? Were the hyper-circuits 
	 * like hyper-freeways? I kept hyper-dreaming of a hyper-world I hyper-thought I'd hyper-never see. 
	 * And then, one hypercube I got in...
	 * <p>It does the {@code hyper-future}. So, this class represents the hyper-abstract 
	 * hyper-implementation of the <tt>hypergenesis<K,V,> hyper-computation</tt>. 
	 * 
	 * @author joan
	 */
	protected class Hypergrid
		extends Grid
			implements Metatext.Translocator<K,V> {

		/**
		 * @param output
		 */
		public Hypergrid() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#push(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void inject(Metatext<K,V> key) {
			// clone child
			put(key.getFrom(), key.getTo());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.Hypergenesis.Comparator#inject(org.xmlrobot.genesis.TimeListener)
		 */
		@Override
		public void push(Metatext<V,K> value) {
			// clone child
			put(value.getTo(), value.getFrom());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.genesis.Metatext.Translocator#put(java.lang.Object, java.lang.Object)
		 */
		@Override
		public void put(K from, V to) {
			// instantiate and run super push
			super.push(instance(getAntitype(), getType(), to, from, output().getValue(), output()));			
		}
	}
	
}