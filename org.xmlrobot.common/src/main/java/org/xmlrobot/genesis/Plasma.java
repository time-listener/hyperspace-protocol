/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * The mass replicator.
 * 
 * Plasma is a state of matter. To be more exact, 
 * plasma is an ionized gaseous state, which is 
 * commonly seen in an electrical arc. 
 * 
 * Plasma is the main energy medium used to 
 * channel power to systems via EPS conduits in almost 
 * all starships. 
 * 
 * A plasma relay technician is responsible for 
 * rerouting plasma to systems they are not 
 * currently allocated to.
 * 
 * <p> All implementing instances will be able to replicate some type of mass.
 * 
 * <p> Earl Grey Tea, <tt>hot</tt>.
 * 
 * @author joan
 */
public interface Plasma<K,V> {

	/**
	 * Returns the replicator of the mass.
	 * @return the replicator of the mass.
	 */
	Mass<K,V> getReplicator();
}