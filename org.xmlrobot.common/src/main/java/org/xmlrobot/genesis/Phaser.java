/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.concurrent.RunnableFuture;

/**
 * Antimatter phaser<V> implementation interface.
 * 
 * Phasers are the most common and standard directed energy weapon 
 * in the arsenal of Starfleet and several other powers. 
 * Most phasers are classified as particle weapons and fire nadion 
 * particle beams, but some like the Ferengi hand phaser 
 * are classified as plasma weapons and fire forced plasma beams. 
 * Based on the intensity and field of the beam and a variety of 
 * adjustments, a wide variety of effects can be achieved.
 * 
 * <p>The root interface in the <i>phaser hierarchy</i>.
 * A {@link RunnableFuture} {@link Executor} that is {@link Reproducible}.
 * I.e, the implementation of tick-tack, tick-tack, tick-tack...
 * Or maybe, run-run, run-run, run-run. Key is the value. And value is the TIME.
 * 
 * <p>This interface is a member of the {@code hyperspace congregation framework}.
 * @author joan
 */
public interface Phaser<V>
	extends MassListener, 
		RunnableFuture<V>, 
			Reproducible<V> {

	/**
	 * The stem.
	 */
	public static final String STEM = "phaser.stem";

	/**
	 * Returns the stem of inheritance.
	 * @return the stem of inheritance
	 */
	V getStem();

	/**
	 * Sets the stem of inheritance.
	 * @param root the stem of inheritance
	 */
	void setStem(V stem);
	
	/**
	 * {@inheritDoc}
     * Returns the value corresponding to this hypergenesis.  If the mapping
     * has been removed from the backing hypergenesis (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     * @return the value corresponding to this hypergenesis
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypergenesis has been
     *         removed from the backing hypergenesis.
     */
	V get();
	
	/**
	 * {@inheritDoc}
     * Returns the value corresponding to this hypergenesis.  If the mapping
     * has been removed from the backing hypergenesis (by the iterator's
     * <tt>remove</tt> operation), the results of this call are undefined.
     * @return the value corresponding to this hypergenesis
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the hypergenesis has been
     *         removed from the backing hypergenesis.
     */
	V get(long timeout, java.util.concurrent.TimeUnit unit);
	
	/**
     * Replaces the value corresponding to this phaser with the specified
     * value (optional operation). (Writes through to the phaser.) The
     * behavior of this call is undefined if the mapping has already been
     * removed from the phaser (by the iterator's <tt>remove</tt> operation).
     *
     * @param value new value to be stored in this phaser
     * @return old antimatter corresponding to the phaser
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by the backing phaser
     * @throws ClassCastException if the class of the specified antimatter
     *         prevents it from being stored in the backing phaser
     * @throws NullPointerException if the backing phaser does not permit
     *         null antimatter, and the specified antimatter is null
     * @throws IllegalArgumentException if some property of this antimatter
     *         prevents it from being stored in the backing phaser
     * @throws IllegalStateException implementations may, but are not
     *         required to, throw this exception if the phaser has been
     *         removed from the backing phaser.
     */
	void set(V value);

    /**
     * 
     * Submits a Runnable task for execution and returns a Future
     * representing that task. The Future's {@code get} method will
     * return the given result upon successful completion.
     *
     * @param task the task to submit
     * @param result the result to return
     * @param <T> the type of the result
     * @return a Future representing pending completion of the task
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     * @throws NullPointerException if the task is null
     */
    <X> Phaser<X> execute(Runnable task, X result);

    /**
     * Submits a Runnable task for execution and returns a Future
     * representing that task. The Future's {@code get} method will
     * return {@code null} upon <em>successful</em> completion.
     *
     * @param task the task to submit
     * @return a Future representing pending completion of the task
     * @throws RejectedExecutionException if the task cannot be
     *         scheduled for execution
     * @throws NullPointerException if the task is null
     */
    void execute(Runnable task);
}