/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * The future output.
 * @author joan
 *
 */
public interface Output<V> extends Future<V> {
	
    /* (non-Javadoc)
     * @see java.util.concurrent.Future#cancel(boolean)
     */
    boolean cancel(boolean mayInterruptIfRunning);

    /* (non-Javadoc)
     * @see java.util.concurrent.Future#isCancelled()
     */
    boolean isCancelled();

    /* (non-Javadoc)
     * @see java.util.concurrent.Future#isDone()
     */
    boolean isDone();

    /* (non-Javadoc)
     * @see java.util.concurrent.Future#get()
     */
    V get();

    /* (non-Javadoc)
     * @see java.util.concurrent.Future#get(long, java.util.concurrent.TimeUnit)
     */
    V get(long timeout, TimeUnit unit);
	
	/**
	 * Sets the new future.
	 * @param value the new future
	 */
	void set(V value);
}