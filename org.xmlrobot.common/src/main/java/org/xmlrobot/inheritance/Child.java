/**
 * 
 */
package org.xmlrobot.inheritance;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.Atlas;
import org.xmlrobot.genesis.Entity;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Mass;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity XY
 * @since 28
 */
@XmlTransient
public abstract class Child
	<K extends TimeListener<? super K,? super V>, 
	 V extends TimeListener<? super V,? super K>>
		extends Parent<K,V>
			 implements Entity<K,V> {
	/**
	 * 2604725583626718586L
	 */
	private static final long serialVersionUID = 2604725583626718586L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getKey()
	 */
	@Override
	@XmlTransient
	public K getKey() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getKey() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setKey(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public K setKey(K key) {
		Mass<K,V> child;
		if((child = getChild()) != null )
			return child.setKey(key);
		else return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#getValue()
	 */
	@Override
	@XmlTransient
	public V getValue() {
		Mass<K,V> child;
		return (child = getChild()) != null ? child.getValue() : null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#setValue(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public V setValue(V value) {
		Mass<K,V> child;
		if((child = getChild()) != null) 
			return child.setValue(value);
		else return null;
	}
	
	/**
     * {@link Child} default class constructor.
	 */
	public Child() {
		super();
	}
	/**
	 * {@link Child} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 */
	protected Child(
			Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter, 
			Class<? extends Parent<K,V>> type,
			Parity gen) {
		super(matter, antimatter, type, gen);
	}
	/**
	 * {@link Child} class constructor.
	 * @param matter the matter type
	 * @param antimatter the antimatter type
	 * @param type the inherited type
	 * @param antitype the inherited antitype
	 */
	protected Child(
			Class<? extends Mass<K,V>> matter, 
			Class<? extends Mass<V,K>> antimatter,
			Class<? extends Child<K,V>> type, 
			Class<? extends Parent<V,K>> antitype,
			Parity gen) {
		super(matter, antimatter, type, antitype, gen);
	}
	
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.driver.ScrewDriver#pulse(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
 	 */
 	@Override
	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> listener, Takion<Y,X> event) {
 		// ancestral recall
 		super.pulse(listener, event);
		// rotate inheritance 1/2
 		spin();
 	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.gravity.Past#echo(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
 	 */
 	@Override
 	public synchronized <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
 		void echo(TimeListener<?, ?> listener, Takion<X, Y> event) {
		super.echo(listener, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.driver.ScrewDriver#compare(org.xmlrobot.driver.ScrewDriver, org.xmlrobot.driver.ScrewDriver)
	 */
	@Override
	public synchronized int compare(Mass<K,V> o1, Mass<K,V> o2) {
		
		if(o1 != null) {
			
			if(o2 != null) {
				
				return Parent.superCompare(o1.getChild(), o2.getChild()); 
			}
			return 1;
		}
		else if(o2 != null) {
			
			return -1;
		}
		else {
			return 0;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#compareTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int compareTo(Mass<V,K> o) {
	
		return get().compare(get().getChild(), o.getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.time.Freedom#removeAll(org.xmlrobot.genesis.Congregation)
	 */
	public boolean removeAll(Parent<K,V> c) {
		
        Objects.requireNonNull(c);
        boolean modified = false;

        if (depth() > c.depth()) {
            for (Iterator<Mass<K,V>> i = c.iterator(); i.hasNext(); )
                modified |= (remove(i.next()) != null ? true : false );
        } 
        else {
            for (Iterator<Mass<K,V>> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
        }
        return modified;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Recursion#reproduceTo(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public int reproduceTo(Mass<V,K> o) {

		return matrix().reproduce(o.get().getChild(), get().getChild());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Atlas#get(java.lang.Object)
	 */
	public V get(K key) {
		Mass<K,V> child;
    	return (child = getChild()) != null ? child.getValue(key) : null;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.Atlas#put(java.lang.Object, java.lang.Object)
     */
    public abstract V put(K key, V value);
    
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#putAll(org.xmlrobot.collections.Map)
     */
    public void putAll(Atlas<? extends K, ? extends V, ? extends Mass<K,V>> m) {
    	for(Mass<K,V> e : m)
			put(e.getKey(), e.getValue());
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#entrySet()
     */
    @Override
    public Congregation<Mass<K,V>> entrySet() {
    	return getChild();
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#forEach(java.util.function.BiConsumer)
     */
    public void forEach(BiConsumer<? super K, ? super V> action) {
    	Mass<K,V> child;
    	if((child = getChild()) != null )
    		child.forEachKey(action);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#getOrDefault(java.lang.Object, java.lang.Object)
     */
    public V getOrDefault(K key, V defaultValue) {
    	Mass<K,V> child;
    	return (child = getChild()) != null ? child.getValueOrDefault(key, defaultValue) : null;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#replaceAll(java.util.function.BiFunction)
     */
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
    	Mass<K,V> child;
    	if((child = getChild()) != null)
    		child.replaceAllValues(function);
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#putIfAbsent(java.lang.Object, java.lang.Object)
     */
    public V putIfAbsent(K key, V value) {
    	Mass<K,V> child;
		return (child = getChild()) != null ? child.putValueIfAbsent(key, value) : null;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#remove(java.lang.Object, java.lang.Object)
     */
    public boolean remove(K key, V value) {
    	Mass<K,V> child;
    	return (child = getChild()) != null ? child.removeByKey(key, value) : null;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#replace(java.lang.Object, java.lang.Object, java.lang.Object)
     */
    public boolean replace(K key, V oldValue, V newValue){
    	Mass<K,V> child;
		return (child = getChild()) != null ? child.replaceValue(key, oldValue, newValue) : null;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.collections.Map#replace(java.lang.Object, java.lang.Object)
     */
    public V replace(K key, V value) {
    	Mass<K,V> child;
		return (child = getChild()) != null ? child.replaceValue(key, value) : null;
    }
	/* (non-Javadoc)
	 * @see org.xmlrobot.gravity.Gravity#run()
	 */
	@Override
	public final void run() {
		// avoid concurrent calls to run
		if (!message.compareAndSet(RUNNER, null, Thread.currentThread())) {
			// because it is already running
			return;
		}
		else {
			// life starts here
			super.run();
	    	// life ends here
	    	push(Command.TRANSFER);
		}
	}
 	/* (non-Javadoc)
 	 * @see org.xmlrobot.driver.ScrewDriver#matrix()
 	 */
 	@Override
 	public TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> matrix() {
 		TimeListener.Transmitter<Mass<K,V>,Mass<V,K>> m;
 		return (m = matrix) != null ? m : (Transductor) (matrix = new Transductor());
 	}
	/**
	 * God's mass emitter.
	 * @author joan
	 *
	 */
	protected class Transductor
 		extends Transmuter {
		/**
		 * {@link Transductor} default class constructor.
		 */
		public Transductor() {
			super(instance(getAntitype(), getType()));
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#output()
		 */
		@Override
		public Child<V,K> get() {
			return (Child<V,K>) super.get();
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#push(org.xmlrobot.genesis.Mass)
		 */
		@Override
		public void push(Mass<K,V> child) {
			get().put(child.getValue(), child.getKey());
		}
		/* (non-Javadoc)
		 * @see org.xmlrobot.gravity.Recursion.Grid#inject(org.xmlrobot.genesis.Mass)
		 */
		@Override
		public void inject(Mass<V,K> child) {
			get().put(child.getKey(), child.getValue());
		}
	}
}
