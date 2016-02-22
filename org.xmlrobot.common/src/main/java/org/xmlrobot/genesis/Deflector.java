/**
 * 
 */
package org.xmlrobot.genesis;

import java.time.Instant;
import java.util.EventListener;

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
 * Activate deflectors to the maximum amplitude. Energy.
 * <br>
 * @author joan
 */
public interface Deflector extends EventListener {

	/**
	 * Pulse propagation over the future. A.k.a <tt>tick</tt>.
	 * @param sender {@link TimeListener} the listener getting in contact.
	 * @param instant {@link Instant} the instant being transmitted.
	 */
	<X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> sender, Tachyon<Y,X> event);
	
	/**
	 * Echo diffusion through the past. A.k.a <tt>tack</tt>.
	 * @param sender {@link TimeListener} the listener getting in contact.
	 * @param instant {@link Instant} the instant being transmitted.
	 */
	<X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void echo(TimeListener<?,?> sender, Tachyon<X,Y> event);
}