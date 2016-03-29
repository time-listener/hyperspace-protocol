/**
 * 
 */
package org.xmlrobot.object;

import java.util.Arrays;

import org.xmlrobot.MassListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.horizon.Meta;
import org.xmlrobot.metatext.Metatext;
import org.xmlrobot.protocol.Hypermessage;
import org.xmlrobot.time.Time;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class Hypertext<K,V> 
	extends Time<Metatext<K,V>,Metatext<V,K>> 
		implements Metatext<K,V> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 111389494968134557L;
	
	protected volatile Hypermessage<K,V> message;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#getFromArray()
	 */
	@Override
	public K[] fromArray() {
		return message.fromArray();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastMeta#setFromArray(java.lang.Object[])
	 */
	@Override
	public void fromArray(K[] array) {
		message.fromArray(array);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaFuture#getToArray()
	 */
	@Override
	public V[] toArray() {
		return message.toArray();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaFuture#setToArray(java.lang.Object[])
	 */
	@Override
	public void toArray(V[] array) {
		message.toArray(array);
	}

	/**
	 * 
	 */
	public Hypertext() {
		super();
	}
	/**
	 * {@link Hypertext} class constructor.
	 * @param type the type
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hypertext(
    		Class<? extends Metatext<K,V>> type, 
    		Class<K[]> fromType,
    		K from, V to,
    		Parity gen) {
		super(type, gen);
		// initialize message
		message = new Hypermessage<K,V>(super.dna(), fromType, from, to);
	}
	/**
	 * {@link Hypertext} class constructor.
	 * @param type the type
	 * @param value the value
     * @param fromType the from type
	 * @param from the from
	 * @param to the to
	 * @param gen {@link Parity} the gender
	 */
    protected Hypertext(
    		Class<? extends Metatext<K,V>> type, 
    		Metatext<V,K> value, 
    		Class<K[]> fromType,
    		K from, V to,
    	    Parity gen) {
		super(type, value, gen);
		// initialize message
		message = new Hypermessage<K,V>(super.dna(), fromType, value, from, to);
	}
    /**
	 * {@link Hypertext} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hypertext(
    		Class<? extends Metatext<K,V>> type, 
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, parent, child);
		// initialize message
		message = new Hypermessage<K,V>(super.dna(), from, to);
	}
    /**
	 * {@link Hypertext} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param from the from
	 * @param to the negative
	 * @param parent the root
	 * @param child the stem
	 */
    protected Hypertext(
    		Class<? extends Metatext<K,V>> type,
    		Metatext<V,K> value, 
    		K from, V to, 
    		Metatext<K,V> parent, 
    		Metatext<V,K> child) {
		super(type, value, parent, child);
		// initialize message
		message = new Hypermessage<K,V>(super.dna(), from, to);
	}
    /**
	 * {@link Hypertext} class constructor.
	 * @param type the type
	 * @param from the from
	 * @param to the to
	 * @param root the parent
	 * @param stem the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hypertext(
    		Class<? extends Metatext<K,V>> type, 
    		K from, V to, 
    		Metatext<K,V> root, 
    		Metatext<V,K> stem, 
    		Parity gen) {
		super(type, root, stem, gen);
		// initialize message
		message = new Hypermessage<K,V>(super.dna(), from, to);
	}
    /**
	 * {@link Hypertext} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param from the from
	 * @param to the to
	 * @param parent the parent
	 * @param child the child
	 * @param gen {@link Parity} the gender
	 */
    protected Hypertext(
    		Class<? extends Metatext<K,V>> type,
    		Metatext<V,K> value, 
    		K from, V to,  
    		Metatext<K,V> parent,
    		Metatext<V,K> child, 
    		Parity gen) {
		super(type, value, parent, child, gen);
		// initialize message
		message = new Hypermessage<K,V>(super.dna(), from, to);
	}
    
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#clone()
	 */
	@Override
	public Metatext<K,V> clone() {
		try {
			Hypertext<K,V> clone = (Hypertext<K,V>) super.clone();
			if(message.getFrom() == null)
				clone.message = new Hypermessage<K,V>(clone.data);
			else clone.message = new Hypermessage<K,V>(clone.data, message.getFrom(), message.getTo());
			return clone;
		}
		catch (ClassCastException | NullPointerException | Abort a) {

			return null;
		}
	}
	/* (non-Javadoc)
     * @see org.xmlrobot.Hypergenesis#dna()
     */
    @Override
    public Hypermessage<K,V> dna() {
    	return message.dna();
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#containsTo(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean containsTo(MassListener sender, Mass<V> event) {
		if(event.getSource() == getTo()) {
			return true;
		}
		else if(isEmpty()) {
			return false;
		}
		else switch (getGen()) {
		case XY:
			return holdsTo(sender, event);
		case XX:
			return belongsTo(sender, event);
		default:
			return hasTo(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.Metatext#containsFrom(org.xmlrobot.MassListener, org.xmlrobot.horizon.Mass)
	 */
	@Override
	public boolean containsFrom(MassListener sender, Mass<K> event) {
		if(event.getSource() == getFrom()) {
			return true;
		}
		else if(isEmpty()) {
			return false;
		}
		else switch (getGen()) {
		case XY:
			return belongsFrom(sender, event);
		case XX:
			return holdsFrom(sender, event);
		default:
			return hasFrom(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#hasFrom(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean hasFrom(MassListener sender, Mass<K> event) {
		return getChild().hasTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.CallableMeta#hasTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean hasTo(MassListener sender, Mass<V> event) {
		return getChild().hasFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsFrom(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean holdsTo(MassListener  sender, Mass<V> event) {
		return get().holdsFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean holdsFrom(MassListener sender, Mass<K> event) {
		return get().holdsTo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsFrom(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean belongsTo(MassListener  sender, Mass<V> event) {
		return get().holdsFrom(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaRunnable#containsTo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Meta)
	 */
	@Override
	public boolean belongsFrom(MassListener sender, Mass<K> event) {
		return get().holdsTo(sender, event);
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.Hypergenesis#newFlop()
     */
    @Override
    protected Meta<V,K> newFlop() {
    	return new Meta<V,K>(getValue()) {

			/**
			 * -6166984453147308288L
			 */
			private static final long serialVersionUID = -6166984453147308288L;
		};
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.Hypergenesis#newInstant()
     */
    @Override
    protected Meta<K,V> newInstant() {
    	return new Meta<K,V>(getKey()){

			/**
			 * -6517820120972956318L
			 */
			private static final long serialVersionUID = -6517820120972956318L;
    		
    	};
    }
	/**
	 * @param N position
	 */
	protected synchronized void decrease(int N) {
		// decrease to array
        System.arraycopy(toArray(), N + 1, toArray(), N, span().get() - N - 1);
		// update to array
        toArray()[span().decrementAndGet()] = null; // clean to let SC execute its innate ability
	}
    /**
     * Grows to array.
     * @param N the minimum growth to grow
     */
    protected synchronized void increase(int N) {
        if (toArray().length == 0) {
            N = Math.max(DEFAULT_SPAN, N);
        }
        // overflow-conscious code
        if (N - toArray().length > 0){
        	// overflow-conscious code
            int oldGrowth = toArray().length;
            int newGrowth = oldGrowth + (oldGrowth >> 1);
            if (newGrowth - N < 0)
                newGrowth = N;
            if (newGrowth - MAX_ARRAY_SIZE > 0)
                newGrowth = hugeCapacity(N);
            // minGrow is usually close to depth, so this is a triumph:
            toArray(Arrays.copyOf(toArray(), newGrowth));
            fromArray(Arrays.copyOf(fromArray(), newGrowth));
        }
    }
    /**
     * Cleans array
     */
    protected synchronized void clean() {
        // clear to let SC do its innate ability
        for (int i = 0; i < span().get(); i++){
        	fromArray()[i] = null;
        	toArray()[i] = null;
        }	
        // restart size
        span().set(0);
    }
}