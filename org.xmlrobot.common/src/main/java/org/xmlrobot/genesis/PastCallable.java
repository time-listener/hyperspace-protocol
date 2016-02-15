/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * A {@link Past} that is {@link Callable}.
 * {@link PastCallable} instances will be able 
 * to emit to the {@link Future}.
 * Successful execution of the {@code run} method 
 * causes completion of the {@code Future} and allows 
 * to read its results.
 * <br><br>
 * @author joan
 *
 */
public interface PastCallable<K> 
	extends Past, Callable<K> {
	
	/**
     * Returns the root corresponding to this mass.
     * @return the root corresponding to this mass
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the entry has been
     *         removed from the backing map.
     */
	K call();
}
