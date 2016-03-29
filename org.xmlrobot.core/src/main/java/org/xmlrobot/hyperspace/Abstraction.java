/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * Abstract be your name!
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 3
 */
public abstract class Abstraction
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Unification<K,V> 
			implements TimeListener<K,V> {

	/**
	 * 6383857538184584122L
	 */
	private static final long serialVersionUID = 6383857538184584122L;

	/**
	 * JAXB context.
	 */
	JAXBContext context = null;
	
	/**
	 * The marshaller.
	 */
	Marshaller marshaller = null;
	
	/**
	 * The unmarshaller
	 */
	Unmarshaller unmarshaller = null;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#getParent()
	 */
	@Override
	@XmlTransient
	public K getRoot() {
		return data.getRoot();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#setParent(java.lang.Object)
	 */
	@Override
	public K setRoot(K root) {
		// set property
		K oldRoot = data.setRoot(root);
		// update value
		getValue().dna().setStem(root);
		// update hyperspace
		update();
		return oldRoot;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getStem()
	 */
	@Override
	@XmlTransient
	public V getStem() {
		return data.getStem();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setStem(java.lang.Object)
	 */
	@Override
	public V setStem(V stem) {
		// set property
		V oldStem = data.setStem(stem);
		// update value
		getValue().dna().setRoot(stem);
		// update hyperspace
		update();
		return oldStem;
	}
	
    /**
     * {@link Abstraction} default class constructor.
     */
    public Abstraction() {
    	super();
    }
	/**
	 * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Abstraction(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
    protected Abstraction(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
		value.dna().setRoot(value);
		value.dna().setStem(getKey());
	}
	/**
     * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param parent the key
	 */
	protected Abstraction(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
    /**
	 * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param parent the key
	 * @param value the value
	 */
    protected Abstraction(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
		// set parent future's parent
		parent.get().setParent(value);
		// set child future's parent
		child.get().setParent(getKey());
	}
	/**
     * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param root the key
	 */
	protected Abstraction(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
    /**
	 * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param root the key
	 * @param value the value
	 */
    protected Abstraction(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#giveKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
	public Tachyon<K,V> giveKey(MassListener sender, Tachyon<K,V> event) {
		// re-assign inheritance
		getParent().set(event.getValue());
		event.getValue().setParent(getChild());
		getChild().set(event.getKey());
		event.getKey().setParent(getParent());
		event.getKey().set(get());
		get().setParent(event.getValue());
		event.getValue().set(call());
		call().setParent(event.getKey());
		// unify
		unify(sender);
		// return new event
		return newInstant();
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#giveValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> giveValue(MassListener sender, Tachyon<V,K> event) {
		// re-assign inheritance
		getChild().set(event.getValue());
		event.getValue().setParent(getParent());
		getParent().set(event.getKey());
		event.getKey().setParent(getChild());
		event.getKey().set(call());
		call().setParent(event.getValue());
		event.getValue().set(get());
		get().setParent(event.getKey());		
		// unify
		unify(sender);
		// return new event
		return newFlop();
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#takeKey(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> takeKey(MassListener sender, Tachyon<K,V> event) {
    	// take event's parents
    	event.getParent().set(getValue());
    	getValue().setParent(event.getChild());
    	event.getChild().set(getKey());
    	getValue().setChild(event.getParent());
    	// take event's children
    	getValue().put(event.get());
    	event.get().setParent(getValue());
    	getValue().set(event.call());
    	event.call().setParent(getKey());
    	// unify event
    	event.unify(sender);
    	// return taken event
    	return event;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#takeValue(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> takeValue(MassListener sender, Tachyon<V,K> event) {
    	// take event's parents
    	event.getChild().set(getValue());
    	getValue().setParent(event.getParent());
    	event.getParent().set(getKey());
    	getValue().setChild(event.getChild());
    	// take event's children
    	getValue().set(event.get());
    	event.call().setParent(getValue());
    	getValue().put(event.call());
    	event.get().setParent(getKey());
    	// unify event
    	event.unify(sender);
    	// out
    	return event;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#lendKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
	public Tachyon<K,V> lendKey(MassListener sender, Tachyon<K,V> event) {
		// re-assign inheritance
		getParent().put(event.getKey());
		event.getKey().setParent(getParent());
		getChild().put(event.getValue());
		event.getValue().setParent(getChild());
		event.getValue().set(call());
		get().setChild(event.getKey());
		event.getKey().set(get());
		call().setChild(event.getValue());
		// unify
		unify(sender);
		// return new event
		return newInstant();
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#lendValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> lendValue(MassListener sender, Tachyon<V,K> event) {
		// re-assign inheritance
		getParent().set(event.getKey());
		event.getValue().setChild(getChild());
		getChild().set(event.getValue());
		event.getKey().setChild(getParent());
		event.getKey().put(get());
		call().setChild(event.getKey());
		event.getValue().put(call());
		get().setChild(event.getValue());		
		// unify
		unify(sender);
		// return new event
		return newFlop();
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#borrowKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> borrowKey(MassListener sender, Tachyon<K,V> event) {
    	// take event's parents
    	event.getChild().put(getValue());
    	getValue().setChild(event.getParent());
    	event.getParent().put(getKey());
    	getValue().setParent(event.getChild());
    	// take event's children
    	getValue().set(event.call());
    	event.call().setChild(getValue());
    	getValue().put(event.get());
    	event.get().setChild(getKey());
    	// unify event
    	event.unify(sender);
    	return event;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recursion#borrowValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> borrowValue(MassListener sender, Tachyon<V,K> event) {
    	// take event's parents
    	event.getParent().set(getKey());
    	getValue().setChild(event.getChild());
    	event.getChild().set(getValue());
    	getValue().setParent(event.getParent());
    	// take event's children
    	getValue().set(event.get());
    	event.get().setParent(getKey());
    	getValue().put(event.call());
    	event.get().setChild(getValue());
    	// unify event
    	event.unify(sender);
    	// out
    	return event;
    }

    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#openKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
	public Tachyon<K,V> openKey(MassListener sender, Tachyon<K,V> event) {
		// re-assign inheritance
		getParent().put(event.getKey());
		event.getKey().setParent(getParent());
		getChild().put(event.getValue());
		event.setChild(getChild());
		event.put(call());
		get().setChild(event.getKey());
		event.set(get());
		call().setChild(event.getValue());
		// unify
		unify(sender);
		// return new event
		return newInstant();
	}
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#openValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> openValue(MassListener sender, Tachyon<V,K> event) {
		// re-assign inheritance
		getParent().set(event.getKey());
		event.setParent(getChild());
		getChild().set(event.getValue());
		event.setChild(getParent());
		event.put(get());
		call().setChild(event.getKey());
		event.set(call());
		get().setChild(event.getValue());		
		// unify
		unify(sender);
		// return new event
		return newFlop();
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#closeKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<K,V> closeKey(MassListener sender, Tachyon<K,V> event) {
    	// take event's parents
    	event.getChild().put(getValue());
    	setChild(event.getChild());
    	event.getParent().put(getKey());
    	setChild(event.getChild());
    	// take event's children
    	put(event.call());
    	event.call().setChild(getValue());
    	set(event.get());
    	event.get().setChild(getKey());
    	// unify event
    	event.unify(sender);
    	return event;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Recurrence#closeValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
     */
    @Override
    public Tachyon<V,K> closeValue(MassListener sender, Tachyon<V,K> event) {
    	// take event's parents
    	event.getParent().set(getKey());
    	setChild(event.getParent());
    	event.getChild().set(getValue());
    	setChild(event.getParent());
    	// take event's children
    	put(event.get());
    	event.get().setParent(getKey());
    	set(event.call());
    	event.call().setParent(getValue());
    	// unify event
    	event.unify(sender);
    	// out
    	return event;
    }
    
	/*
	 * The inheritance map
	 * */
	transient volatile Map<K,V> inheritanceMap;
	
 	/**
 	 * The key set
 	 */
 	transient volatile Set<K> keySet;
 	
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Past#keySet()
 	 */
 	@Override
 	public Set<K> keySet() {
 		// check existence
 		if(keySet == null) {
 			keySet = new AbstractSet<K>() {

 				/* (non-Javadoc)
 				 * @see java.util.AbstractCollection#iterator()
 				 */
 				@Override
 				public Iterator<K> iterator() {
 					return getGen().equals(Parity.XY) ? 
 							new PastIterator(getFutureKey(root()).getKey()) 
 							: new FutureIterator(callPastKey(root()).getKey());
 				}
 				/* (non-Javadoc)
 				 * @see java.util.AbstractCollection#size()
 				 */
 				@Override
 				public int size() {
 					return depth(root()).get();
 				}
 				/* (non-Javadoc)
 				 * @see java.util.AbstractCollection#isEmpty()
 				 */
 				@Override
 				public boolean isEmpty() {
 					return getGen().equals(Parity.XY) ? 
 							isPast() : isFuture();
 				}
 			};
 		}
 		return keySet;
 	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.genesis.Future#valueSet()
 	 */
 	@Override
 	public Set<V> valueSet() {
 		return get().keySet();
 	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#inheritanceMap()
	 */
	@Override
	public Map<K,V> inheritance() {
		return inheritanceMap == null ? 
				(inheritanceMap =
				
				/**
				 * @author joan
				 *
				 */
				new AbstractMap<K,V>() { 

					transient volatile Set<Map.Entry<K,V>> entrySet;
					
					@Override
					public Set<java.util.Map.Entry<K, V>> entrySet() {
						
						return entrySet == null ? (entrySet = 
								
						/**
						 * @author joan
						 *
						 */
						new AbstractSet<Map.Entry<K,V>>() {

							transient volatile Iterator<java.util.Map.Entry<K,V>> iterator;
							
							@Override
							public Iterator<java.util.Map.Entry<K, V>> iterator() {
								return iterator != null ? 
										(iterator = new InheritanceIterator(getGen().equals(Parity.XY) ? 
												getFutureKey(root()).getKey()
												: callPastKey(root()).getKey()))
										: iterator;
							}

							@Override
							public int size() {
								return depth(root()).get();
							}
						}) : entrySet;
					} 
					
				}) : inheritanceMap;
	}
	
	/**
	 * @author joan
	 *
	 */
	protected class InheritanceIterator 
		extends Hypergear<K,V> 
			implements Iterator<Map.Entry<K,V>> {

		/**
		 * @param entity
		 */
		protected InheritanceIterator(K entity) {
			super(entity);
		}
		
		@Override
		public boolean hasNext() {
			return next != null;
		}
		@Override
		public java.util.Map.Entry<K,V> next() {
			return getGen().equals(Parity.XY) ? backward() : forward();
		}
	}
}