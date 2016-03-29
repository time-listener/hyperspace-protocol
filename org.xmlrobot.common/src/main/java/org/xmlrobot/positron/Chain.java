/**
 * 
 */
package org.xmlrobot.positron;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.genesis.Sequence;
import org.xmlrobot.horizon.Graviton;

/**
 * {@link MassConcurrence} {@link Positron} {@link Sequence} implementation interface.
 * @author joan
 *
 */
public interface Chain<K,V>
	extends Positron<K,V>, Sequence<K,V,Positron<K,V>,Positron<V,K>> {
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public default int compareTo(Positron<K,V> o) {
		return getValue().compareTo(o.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	@Override
	public default int reproduceTo(Positron<V,K> o) {
		return matrix().reproduce(call(), o.call());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#size()
	 */
	@Override
	public default AtomicInteger span() {
		return depth(root());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#isEmpty()
	 */
	@Override
	public default boolean isEmpty() {
		return isPast() && isFuture();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#parMap()
	 */
	@Override
	public default Atom<V,K> parMap() {
		return (Atom<V,K>) getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#contains(java.lang.Object)
	 */
	@Override
	public default boolean contains(Positron<K,V> o) {
		// check if we are past and future and concur contains
		return isEmpty() ? false : getChild().hasValue(root(), new Graviton<K,V>(o) {

			/**
			 * -1597315879261127690L
			 */
			private static final long serialVersionUID = -1597315879261127690L;
			
		}) ;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#add(java.lang.Object)
	 */
	@Override
	public default void add(Positron<K,V> e) {
		// PUSH
		getChild().allocateValue(root(), new Graviton<K,V>(e) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -9054661471235076172L;

	
		});
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#remove(java.lang.Object)
	 */
	@Override
	public default void remove(Positron<K,V> o) {
		Objects.requireNonNull(o);
		if(!isPast())
			getChild().redeemValue(root(), new Graviton<K,V>(o) {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1371015548782534569L;

			});
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#bulk(org.xmlrobot.genesis.Sequence)
	 */
	@Override
	public default void bulk(Sequence<? extends K,? extends V,? extends Positron<K,V>,? extends Positron<V,K>> s) {
		Objects.requireNonNull(s);
		for(Positron<K,V> entry : s) {
			add(entry);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#addAll(java.util.Collection)
	 */
	@Override
	public default void addAll(Collection<? extends Positron<K,V>> c) {
		Objects.requireNonNull(c);
		for(Positron<K,V> entry : c) {
			add(entry);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#containsAll(java.util.Collection)
	 */
	@Override
	public default boolean containsAll(Collection<? extends Positron<K,V>> c) {
		Objects.requireNonNull(c);
		for (Positron<K,V> e : c)
            if (!contains(e))
                return false;
        return true;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#retainAll(java.util.Collection)
	 */
	@Override
	public default void retainAll(Collection<? extends Positron<K,V>> c) {
		Objects.requireNonNull(c);
        Iterator<Positron<K,V>> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
            }
        }
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#removeAll(java.util.Collection)
	 */
	public default void removeAll(Collection<? extends Positron<K,V>> c) {
		Objects.requireNonNull(c);
        if (span().get() > c.size()) {
            for (Iterator<? extends Positron<K,V>> i = c.iterator(); i.hasNext(); )
                redeemKey(i.next());
        } else {
            for (Iterator<?> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                }
            }
        }
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#indexOf(java.lang.Object)
	 */
	@Override
	public default int indexOf(Positron<V,K> o) {
		return isPast() ? 0 : getChild().pointerOfKey(root(), new Graviton<V,K>(o) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 2866371288503106631L;

			
		}).get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#lastIndexOf(java.lang.Object)
	 */
	@Override
	public default int lastIndexOf(Positron<V,K> o) {
		return isPast() ? 0 : getChild().lastIndexOfKey(root(), new Graviton<V,K>(o) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -2692317223708834575L;


			
		}).get();
	}
}