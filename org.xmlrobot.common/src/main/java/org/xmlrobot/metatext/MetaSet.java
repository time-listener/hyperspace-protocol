/**
 * 
 */
package org.xmlrobot.metatext;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.genesis.Sequence;
import org.xmlrobot.horizon.Meta;

/**
 * A {@link Metatext} that is {@link Sequence}.
 * @author joan
 *
 */
public interface MetaSet<K,V> 
	extends Metatext<K,V>, Sequence<K,V,Metatext<K,V>,Metatext<V,K>>  {
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#clear()
	 */
	@Override
	public default void clear(){
		clear(root());
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public default int compareTo(Metatext<K,V> o) {
		return getValue().compareTo(o.getValue());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	@Override
	public default int reproduceTo(Metatext<V,K> o) {
		return matrix().reproduce(call(), o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#size()
	 */
	@Override
	public default AtomicInteger span() {
		return depth(root());
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#parMap()
	 */
	@Override
	public default MetaMap<V,K> parMap() {
		return (MetaMap<V,K>) getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#contains(java.lang.Object)
	 */
	@Override
	public default boolean contains(Metatext<K,V> o) {
		// check if we are past and future and concur contains
		return containsKey(root(), new Meta<K, V>(o){

			/**
			 * 
			 */
			private static final long serialVersionUID = 2751678510370894991L;
			
		});
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#add(java.lang.Object)
	 */
	@Override
	public default void add(Metatext<K,V> e) {
		// PUSH
		allocateKey(root(), new Meta<K,V>(e) {

			/**
			 * -2622973505254404323L
			 */
			private static final long serialVersionUID = -2622973505254404323L;

	
		});
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#remove(java.lang.Object)
	 */
	@Override
	public default void remove(Metatext<K,V> o) {
		Objects.requireNonNull(o);
		liberateKey(root(), new Meta<K,V>(o) {

			/**
			 * 2650613124108586473L
			 */
			private static final long serialVersionUID = 2650613124108586473L;
		});
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#bulk(org.xmlrobot.genesis.Sequence)
	 */
	@Override
	public default void bulk(Sequence<? extends K,? extends V,? extends Metatext<K,V>,? extends Metatext<V,K>> s) {
		Objects.requireNonNull(s);
		for(Metatext<K,V> entry : s) {
			add(entry);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#addAll(java.util.Collection)
	 */
	@Override
	public default void addAll(Collection<? extends Metatext<K,V>> c) {
		Objects.requireNonNull(c);
		for(Metatext<K,V> entry : c) {
			add(entry);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#containsAll(java.util.Collection)
	 */
	@Override
	public default boolean containsAll(Collection<? extends Metatext<K,V>> c) {
		Objects.requireNonNull(c);
		for (Metatext<K,V> e : c)
            if (!contains(e))
                return false;
        return true;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#retainAll(java.util.Collection)
	 */
	@Override
	public default void retainAll(Collection<? extends Metatext<K,V>> c) {
		Objects.requireNonNull(c);
        Iterator<Metatext<K,V>> it = iterator();
        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
            }
        }
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#removeAll(java.util.Collection)
	 */
	public default void removeAll(Collection<? extends Metatext<K,V>> c) {
		Objects.requireNonNull(c);
        if (span().get() > c.size()) {
            for (Iterator<? extends Metatext<K,V>> i = c.iterator(); i.hasNext(); )
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
	public default int indexOf(Metatext<V,K> o) {
		return indexOfValue(root(), new Meta<V,K>(o){

			/**
			 * -5053450311576991120L
			 */
			private static final long serialVersionUID = -5053450311576991120L;
			
		}).get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Sequence#lastIndexOf(java.lang.Object)
	 */
	@Override
	public default int lastIndexOf(Metatext<V,K> o) {
		return lastIndexOfValue(root(), new Meta<V,K>(o) {

			/**
			 * 1978552575650191906L
			 */
			private static final long serialVersionUID = 1978552575650191906L;
			
		}).get();
	}
}