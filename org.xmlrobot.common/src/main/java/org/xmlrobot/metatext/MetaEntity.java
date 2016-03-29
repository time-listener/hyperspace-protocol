/**
 * 
 */
package org.xmlrobot.metatext;

import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.genesis.Entity;

/**
 * @author joan
 *
 */
public interface MetaEntity<K,V> 
	extends MetaMap<K,V>, MetaSet<K,V>,
		Entity<K,V,Metatext<K,V>,Metatext<V,K>> {
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.metatext.MetaMap#clear()
	 */
	@Override
	public void clear();
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MetaMap#size()
	 */
	@Override
	public default AtomicInteger span() {
		return depth(root());
	}
}