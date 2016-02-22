/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * The mass replicator.
 * <p> All implementing instances will be able to replicate some type of mass.
 * <p> Earl Grey Tea, <tt>hot</tt>.
 * 
 * @author joan
 */
public interface Replicator<K,V> extends Mass<K,V> {

	/**
	 * Plasma is a state of matter. To be more exact, plasma is an ionized gaseous state, 
	 * which is commonly seen in an electrical arc.
	 * <p>Plasma is the main energy medium used to channel power to systems via EPS conduits 
	 * in almost  all starships. 
	 * <p>A plasma relay technician is responsible for rerouting plasma to systems they are not 
	 * currently allocated to.
	 * 
	 * @return the replicated mass.
	 */
	Mass<K,V> getPlasma();
	
}