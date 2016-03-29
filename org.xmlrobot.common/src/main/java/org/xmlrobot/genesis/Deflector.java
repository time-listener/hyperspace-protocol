/**
 * 
 */
package org.xmlrobot.genesis;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;

/**
 * The navigable deflector was a component of many starships, 
 * and was used to deflect space debris, asteroids, microscopic 
 * particles and other objects that might have collided with 
 * the ship. 
 * 
 * At warp speed the deflector was virtually indispensable 
 * for most starships as even the most minute particle could cause 
 * serious damage to a ship when it was traveling at 
 * superluminal velocities.
 * 
 * It is also a {@link Past} that is {@link Future}.
 * 
 * <p>This interface is a member of the <tt>hyperspace congregation framework</tt>.</p>
 * <br>
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 */
public interface Deflector
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Reproductor<K,V>, Past<K>, Future<V> {

	/**
	 * Pulse propagation over the future. A.k.a <tt>tick</tt>.
	 * @param sender {@link MassListener} the sender of this event
	 * @param antievent {@link Tachyon} the antievent being transmitted.
	 */
	void pulse(MassListener sender, Tachyon<V,K> antievent);
	
	/**
	 * Echo diffusion through the past. A.k.a <tt>tack</tt>.
	 * @param sender {@link MassListener} the sender
	 * @param event {@link Tachyon} the antievent being transmitted.
	 */
	void echo(MassListener sender, Tachyon<K,V> event);
}