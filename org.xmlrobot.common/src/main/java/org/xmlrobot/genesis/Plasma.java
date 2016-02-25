/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * 
 * Plasma is a state of matter. To be more exact, plasma is an ionized gaseous
 * state, which is commonly seen in an electrical arc.
 * <p>
 * Plasma is the main energy medium used to channel power to systems via EPS
 * conduits in almost all starfleet's starships.
 * <p>
 * A plasma relay technician is responsible for rerouting plasma to systems they
 * are not currently allocated to. 
 * <p>
 * All implementing instances will be able to replicate some type of mass.
 * <p>
 * 
 * @author joan
 */
public interface Plasma<K,V> extends Mass<K,V> {

	/**
	 * Turns back the mass replicator.
 	 * <p>Earl Grey Tea, <tt>hot</tt>.
	 * @return the replicated mass.
	 */
	Mass<K,V> getReplicator();
}