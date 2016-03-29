/**
 * 
 */
package org.xmlrobot.positron;

import org.xmlrobot.MassListener;
import org.xmlrobot.genesis.Concurrence;
import org.xmlrobot.genesis.RunnableFuture;
import org.xmlrobot.horizon.Graviton;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.util.Imperative;
import org.xmlrobot.util.Instruction;
import org.xmlrobot.util.Commandment;

/**
 * A {@link MassFuture} that is {@link Concurrence}.
 * @author joan
 *
 */
public interface MassConcurrence<V,K>
	extends MassFuture<V>, RunnableFuture<Positron<V,K>> {
	
    /**
     * Returns <tt>true</tt> if this mass contains a positron for the specified
     * event.  More formally, returns <tt>true</tt> if and only if
     * this mass contains a positron for an event <tt>k</tt> such that
     * <tt>(event==null ? k==null : event.equals(k))</tt>.  (There can be
     * at most one such positron.)
     * 
     * @param event event whose presence in this mass is to be tested
     * @return <tt>true</tt> if this mass contains a positron for the specified event
     * @throws ClassCastException if the event is of an inappropriate type for this mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this mass does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean holdsPositive(MassListener sender, Mass<K> event);

    /**
     * Returns <tt>true</tt> if this mass unifies one or more opposites to the
     * specified event.  More formally, returns <tt>true</tt> if and only if
     * this mass contains at least one positron to a event <tt>n</tt> such that
     * <tt>(event==null ? n==null : event.equals(n))</tt>.  This operation
     * will probably require time linear in the mass depth for most
     * implementations of the <tt>Positron</tt> interface.
     *
     * @param event event whose presence in this mass is to be tested
     * @return <tt>true</tt> if this mass unifies one or more opposites to the specified event
     * @throws ClassCastException if the event is of an inappropriate type for this map
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this mass does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean holdsNegative(MassListener sender, Mass<V> event);
    
    /**
     * Attempts to compute a positron for the specified event and its current
     * unified antievent (or {@code null} if there is no current positron). For
     * example, to either create or append a {@code String} msg to an antievent
     * positron:
     *
     * <pre> {@code
     * mass.compute(event, (k, v) -> (v == null) ? msg : v.concat(msg))}</pre>
     * (Method {@link #merge merge()} is often simpler to use for such purposes.)
     *
     * <p>If the function returns {@code null}, the positron is removed (or
     * remains absent if initially absent).  If the function itself throws an
     * (unchecked) exception, the exception is rethrown, and the current positron
     * is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code mass}, then returning the current antievent or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldAntievent = mass.getNegative(root(), event);
     * V newAntievent = unificationFunction.apply(event.getSource(), oldAntievent);
     * if (oldAntievent != null ) {
     *    if (newAntievent != null)
     *       mass.putNegative(root(), event, new Boson<V>(newAntievent));
     *    else
     *       mass.removeByPositive(event);
     * } else {
     *    if (newAntievent != null)
     *       mass.putNegative(root(), event, newAntievent);
     *    else
     *       return null;
     * }
     * }</pre>
     *
     * <p>The default implementation makes total guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrentmass} must document
     * whether the function is applied once atomically only if the antievent is not
     * present.
     *
     * @param event event with which the specified antievent is to be associated
     * @param unificationFunction the function to compute a antievent
     * @return the new antievent associated with the specified event, or null if none
     * @throws NullPointerException if the specified event is null and
     *         this mass does not support null events, or the
     *         unificationFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    void exploitNegative(MassListener sender, Mass<K> event, 
    		Commandment<K,V> unificationFunction);
    
    /**
     * If the specified event is not already associated with a antievent (or is unified
     * to {@code null}), attempts to compute its antievent using the given positron
     * function and enters it into this mass unless {@code null}.
     *
     * <p>If the function returns {@code null} no positron is recorded. If
     * the function itself throws an (unchecked) exception, the
     * exception is rethrown, and no positron is recorded.  The most
     * common usage is to construct a new object serving as an initial
     * unified antievent or memorized result, as in:
     *
     * <pre> {@code
     * mass.computeIfAbsent(event, k -> new antievent(f(k)));
     * }</pre>
     *
     * <p>Or to implement a multi-antievent mass, {@code mass<K,Collection<V>>},
     * supporting multiple antievents per event:
     *
     * <pre> {@code
     * mass.computeIfAbsent(event, k -> new HashSet<V>()).add(v);
     * }</pre>
     *
     *
     * @implSpec
     * The default implementation is equivalent to the following steps for this
     * {@code mass}, then returning the current antievent or {@code null} if now
     * absent:
     *
     * <pre> {@code
     * if (mass.getNegative(event) == null) {
     *     V newAntievent = positronFunction.apply(event);
     *     if (newAntievent != null)
     *         mass.putNegative(event, newAntievent);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrentmass} must document
     * whether the function is applied once atomically only if the antievent is not
     * present.
     *
     * @param event event with which the specified antievent is to be associated
     * @param positronFunction the function to compute a antievent
     * @return the current (existing or computed) antievent associated with
     *         the specified event, or null if the computed antievent is null
     * @throws NullPointerException if the specified event is null and
     *         this mass does not support null events, or the positronFunction
     *         is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    void exploitNegativeIfAbsent(MassListener sender, Mass<K> event, 
    		Instruction<K,V> positronFunction);
    
    /**
     * Attempts to compute a positron for the specified event and its current
     * unified antievent (or {@code null} if there is no current positron). For
     * example, to either create or append a {@code String} msg to an antievent
     * positron:
     *
     * <pre> {@code
     * mass.compute(event, (k, v) -> (v == null) ? msg : v.concat(msg))}</pre>
     * (Method {@link #merge merge()} is often simpler to use for such purposes.)
     *2q!
     * <p>If the function returns {@code null}, the positron is removed (or
     * remains absent if initially absent).  If the function itself throws an
     * (unchecked) exception, the exception is rethrown, and the current positron
     * is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code mass}, then returning the current antievent or
     * {@code null} if absent:
     *
     * <pre> {@code
     * K oldKey = mass.getKey(event);
     * K newKey = unificationFunction.apply(event, oldKey);
     * if (oldKey != null ) {
     *    if (newKey != null)
     *       mass.putKey(event, newKey);
     *    else
     *       mass.removeByValue(event);
     * } else {
     *    if (newKey != null)
     *       mass.putKey(event, newKey);
     *    else
     *       return null;
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrentmass} must document
     * whether the function is applied once atomically only if the antievent is not
     * present.
     *
     * @param event event with which the specified antievent is to be associated
     * @param unificationFunction the function to compute an antievent
     * @return the new antievent associated with the specified event, or null if none
     * @throws NullPointerException if the specified event is null and
     *         this mass does not support null antievents, or the
     *         unificationFunction is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 2
     */
    void exploitPositive(MassListener sender, Mass<V> event, 
    		Commandment<V,K> unificationFunction);
    
    /**
     * If the specified event is not already associated with an antievent (or is unified
     * to {@code null}), attempts to compute its antievent using the given positron
     * function and enters it into this mass unless {@code null}.
     *
     * <p>If the function returns {@code null} no positron is recorded. If
     * the function itself throws an (unchecked) exception, the
     * exception is rethrown, and no positron is recorded.  The most
     * common usage is to construct a new object serving as an initial
     * unified antievent or memorized result, as in:
     *
     * <pre> {@code
     * mass.computePositiveIfAbsent(event, k -> new antievent(f(k)));
     * }</pre>
     *
     * <p>Or to implement a multi-antievent mass, {@code mass<K,Collection<V>>},
     * supporting multiple events per event:
     *
     * <pre> {@code
     * mass.computePositiveIfAbsent(event, k -> new HashSet<V>()).add(v);
     * }</pre>
     *
     *
     * @implSpec
     * The default implementation is equivalent to the following steps for this
     * {@code mass}, then returning the current antievent or {@code null} if now
     * absent:
     *
     * <pre> {@code
     * if (mass.getKey(event) == null) {
     *     V newValue = positronFunction.apply(event);
     *     if (newValue != null)
     *         mass.putKey(event, newKey);
     * }
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrentmass} must document
     * whether the function is applied once atomically only if the antievent is not
     * present.
     *
     * @param event event with which the specified antievent is to be associated
     * @param positronFunction the function to compute an antievent
     * @return the current (existing or computed) antievent associated with
     *         the specified event, or null if the computed antievent is null
     * @throws NullPointerException if the specified event is null and
     *         this mass does not support null antievents, or the positronFunction
     *         is null
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 2
     */
    void exploitPositiveIfAbsent(MassListener sender, Mass<V> event, 
    		Instruction<V,K> positronFunction);
    
    /**
     * Performs the given event for each mass in this mass until all mass
     * has been processed or the event throws an exception.   Unless
     * otherwise specified by the implementing class, events are performed in
     * the order of mass set iteration (if an iteration order is specified.)
     * Exceptions thrown by the event are relayed to the caller.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     * <pre> {@code
     * for (Positron<K,V> p : mass)
     *     event.accept(p.getKey(), p.getNegative());
     * }</pre>
     *
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event The event to be performed for each mass
     * @throws NullPointerException if the specified event is null
     * @throws ConcurrentModificationException if an mass is found to be
     * removed during iteration
     * @since 2
     */
    void fromEachNegative(MassListener sender, Imperative<V,K> event);
    
    /**
     * Performs the given action for each mass in this mass until all mass
     * have been processed or the action throws an exception.   Unless
     * otherwise specified by the implementing class, actions are performed in
     * the order of mass set iteration (if an iteration order is specified.)
     * Exceptions thrown by the action are relayed to the caller.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     * <pre> {@code
     * for (mass.mass<K, V> mass : mass.entrySet())
     *     action.accept(mass.getPositive(), mass.getNegative());
     * }</pre>
     *
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event The action to be performed for each mass
     * @throws NullPointerException if the specified action is null
     * @throws ConcurrentModificationException if an mass is found to be
     * removed during iteration
     * @since 1.8
     */
    void fromEachPositive(MassListener sender, Imperative<K,V> event);
    
	/**
	 * Inquires the inheritance for matching a positron.
	 * Return null if positron hasn't been found.
	 * @param event the antievent of the process that you're looking for.
	 */
	Graviton<V,K> acquireByNegative(MassListener sender, Mass<V> event);
    
    /**
	 * Inquires the inheritance for matching a particle.
	 * @param event the event of the process that you're looking for
	 * @return null if positron hasn't been found
	 */
	Graviton<K,V> acquireByPositive(MassListener sender, Mass<K> event);
    
    /**
     * Returns the antievent to which the specified event is unified,
     * or {@code null} if this mass contains no positron for the event.
     *
     * <p>More formally, if this mass contains a positron from an event
     * {@code k} to a antievent {@code v} such that {@code (event==null ? k==null :
     * event == k)}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such positron.)
     *
     * <p>If this mass permits null antievents, then a return antievent of
     * {@code null} does not <i>necessarily</i> indicate that the mass
     * contains no positron for the event; it's also possible that the mass
     * explicitly unifies the event to {@code null}.  The {@link #containsPositive
     * containsPositive} operation may be used to distinguish these two cases.
     *
     * @param event the event whose associated antievent is to be returned
     * @return the antievent to which the specified event is unified, or
     *         {@code null} if this mass contains no positron for the event
     * @throws ClassCastException if the event is of an inappropriate type for
     *         this mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this map
     *         does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    Mass<V> acquireNegative(MassListener sender, Mass<K> event);
    
    /**
     * Returns the antievent to which the specified event is unified, or
     * {@code defaultNegative} if this mass contains no positron for the event.
     *
     * @implSpec
     * The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event the event whose associated antievent is to be returned
     * @param defaultAntievent the default positron of the event
     * @return the antievent to which the specified event is unified, or
     * {@code defaultNegative} if this mass contains no positron for the event
     * @throws ClassCastException if the event is of an inappropriate type for
     * this mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this mass
     * does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    Mass<V> acquireNegativeOrDefault(MassListener sender, Mass<K> event, Mass<V> defaultAntievent);
   
    /**
     * Returns the antievent to which the specified event is unified,
     * or {@code null} if this mass contains no positron for the event.
     *
     * <p>More formally, if this mass contains a positron from a event
     * {@code k} to a antievent {@code v} such that {@code (event==null ? k==null :
     * event == k)}, then this method returns {@code v}; otherwise
     * it returns {@code null}.  (There can be at most one such positron.)
     *
     * <p>If this mass permits null opposites, then a return antievent of
     * {@code null} does not <i>necessarily</i> indicate that the mass
     * contains no positron for the event; it's also possible that the mass
     * explicitly unifies the event to {@code null}.  The {@link #containsKey
     * containsKey} operation may be used to distinguish these two cases.
     *
     * @param event the event whose associated antievent is to be returned
     * @return the antievent to which the specified event is unified, or
     *         {@code null} if this mass contains no positron for the event
     * @throws ClassCastException if the event is of an inappropriate type for
     *         this mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this map
     *         does not permit null opposites
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    Mass<K> acquirePositive(MassListener sender, Mass<V> event);

    /**
     * Returns the antievent to which the specified event is unified, or
     * {@code default-antievent} if this mass contains no positron for the event.
     *
     * @implSpec
     * The default implementation makes total guarantees about synchronization
     * or atomicity properties of this method. Any implementation not providing
     * atomicity guarantees must override this method and document its
     * recurrency properties.
     *
     * @param event the event whose associated antievent is to be returned
     * @param defaultAntievent the default positron of the event
     * @return the antievent to which the specified event is unified, or
     * {@code default-antievent} if this mass contains no positron for the event
     * @throws ClassCastException if the event is of an inappropriate type for
     * this mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this mass
     * does not permit null antievents
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    Mass<K> acquirePositiveOrDefault(MassListener sender, Mass<V> event, Mass<K> defaultAntievent);
    
    /**
     * If the specified event is not already associated with an event or is
     * associated with null, associates it with the given non-null event.
     * Otherwise, replaces the associated event with the results of the given
     * unification function, or removes if the result is {@code null}. This
     * method may be of use when combining multiple unified antievents for an event.
     * For example, to either create or append a {@code String msg} to a
     * event positron:
     *
     * <pre> {@code
     * mass.merge(event, msg, String::concat)
     * }</pre>
     *
     * <p>If the function returns {@code null} the positron is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current positron is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code mass}, then returning the current event or
     * {@code null} if absent:
     *
     * <pre> {@code
     * V oldAntievent = mass.getNegative(root(), event).getSource();
     * V newAntievent = (oldAntievent == null) ? event.getSource() :
     *              unificationFunction.apply(oldAntievent.getSource(), event.getSource());
     * if (newAntievent == null)
     *     mass.removeByPositive(root(), event);
     * else
     *     mass.putNegative(root(), event, newAntievent);
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrentmass} must document
     * whether the function is applied once atomically only if the event is not
     * present.
     *
     * @param event event with which the resulting event is to be associated
     * @param antievent the non-null antievent to be merged with the existing event
     *        associated with the event or, if no existing event or a null event
     *        is associated with the event, to be associated with the event
     * @param unificationFunction the function to recompute an event if present
     * @return the new event associated with the specified event, or null if no
     *         event is associated with the event
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or event
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this mass
     *         does not support null events or the event or unificationFunction is
     *         null
     * @since 1.8
     */
    void bindNegative(MassListener sender, Mass<K> event, Mass<V> antievent,
    		Commandment<V,V> unificationFunction);
    
    /**
     * If the specified event is not already associated with an antievent or is
     * associated with null, associates it with the given non-null antievent.
     * Otherwise, replaces the associated antievent with the results of the given
     * unification function, or removes if the result is {@code null}. This
     * method may be of use when combining multiple unified events for a event.
     * For example, to either create or append a {@code String msg} to a
     * antievent positron:
     *
     * <pre> {@code
     * mass.mergePositive(event, msg, String::concat)
     * }</pre>
     *
     * <p>If the function returns {@code null} the positron is removed.  If the
     * function itself throws an (unchecked) exception, the exception is
     * rethrown, and the current positron is left unchanged.
     *
     * @implSpec
     * The default implementation is equivalent to performing the following
     * steps for this {@code mass}, then returning the current antievent or
     * {@code null} if absent:
     *
     * <pre> {@code
     * K oldKey = mass.getKey(event);
     * K newKey = (oldValue == null) ? antievent :
     *              unificationFunction.apply(oldKey, event);
     * if (newValue == null)
     *     mass.removeByValue(event);
     * else
     *     mass.putKey(event, newKey);
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties. In particular, all implementations of
     * subinterface {@link java.util.concurrent.Concurrentmass} must document
     * whether the function is applied once atomically only if the antievent is not
     * present.
     *
     * @param event event with which the resulting antievent is to be associated
     * @param antievent the non-null antievent to be merged with the existing antievent
     *        associated with the event or, if no existing antievent or a null antievent
     *        is associated with the event, to be associated with the event
     * @param unificationFunction the function to recompute an antievent if present
     * @return the new antievent associated with the specified event, or null if no
     *         antievent is associated with the event
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this mass
     *         does not support null events  or the antievent or unificationFunction is
     *         null
     * @since 2
     */
    void bindPositive(MassListener sender, Mass<V> event, Mass<K> antievent,
    		Commandment<K,K> unificationFunction) ;
    
    // Modification Operations
    /**
     * Associates the specified antievent with the specified event in this mass
     * (optional operation).  If the mass previously contained a positron for
     * the event, the old antievent is replaced by the specified antievent.  (A mass
     * <tt>a</tt> is said to contain a positron for a event <tt>k</tt> if and only
     * if {@link #containsPositive(Object) m.containsPositive(k)} would return
     * <tt>true</tt>.)
     *
     * @param event event with which the specified antievent is to be associated
     * @param antievent antievent to be associated with the specified event
     * @return the previous antievent associated with <tt>event</tt>, or
     *         <tt>null</tt> if there was no positron for <tt>event</tt>.
     *         (A <tt>null</tt> return can also indicate that the mass
     *         previously associated <tt>null</tt> with <tt>event</tt>,
     *         if the implementation supports <tt>null</tt> antievents.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this mass
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     * @throws NullPointerException if the specified event or antievent is null
     *         and this mass does not permit null events or antievents
     * @throws IllegalArgumentException if some property of the specified event
     *         or antievent prevents it from being stored in this mass
     */
    void assignNegative(MassListener sender, Graviton<K,V> event);
    
    /**
     * Associates the specified antievent with the specified event in this mass
     * (optional operation).  If the mass previously contained a positron for
     * the event, the old antievent is replaced by the specified antievent.  (A mass
     * <tt>a</tt> is said to contain a positron for a event <tt>k</tt> if and only
     * if {@link #containsPositive(Object) m.containsPositive(k)} would return
     * <tt>true</tt>.)
     *
     * @param event event with which the specified antievent is to be associated
     * @param antievent antievent to be associated with the specified event
     * @return the previous antievent associated with <tt>event</tt>, or
     *         <tt>null</tt> if there was no positron for <tt>event</tt>.
     *         (A <tt>null</tt> return can also indicate that the mass
     *         previously associated <tt>null</tt> with <tt>event</tt>,
     *         if the implementation supports <tt>null</tt> antievents.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this mass
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     * @throws NullPointerException if the specified event or antievent is null
     *         and this mass does not permit null events or antievents
     * @throws IllegalArgumentException if some property of the specified event
     *         or antievent prevents it from being stored in this mass
     */
    void assignNegative(MassListener sender, Mass<K> event, Mass<V> antievent);

    /**
     * If the specified event is not already associated with a antievent (or is unified
     * to {@code null}) associates it with the given antievent and returns
     * {@code null}, else returns the current antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code
     * mass}:
     *
     * <pre> {@code
     * V v = mass.getNegative(event);
     * if (v == null)
     *     v = mass.putNegative(event, antievent);
     *
     * return v;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event event with which the specified antievent is to be associated
     * @param antievent antievent to be associated with the specified event
     * @return the previous antievent associated with the specified event, or
     *         {@code null} if there was no positron for the event.
     *         (A {@code null} return can also indicate that the mass
     *         previously associated {@code null} with the event,
     *         if the implementation supports null antievents.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the event or antievent is of an inappropriate
     *         type for this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event or antievent is null,
     *         and this mass does not permit null events or antievents
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of the specified event
     *         or antievent prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    void assignNegativeIfAbsent(MassListener sender, Mass<K> event, Mass<V> antievent);
    
    /**
     * Associates the specified event with the specified antievent in this mass
     * (optional operation).  If the mass previously contained a positron for
     * the antievent, the old event is replaced by the specified event.  (A mass
     * <tt>v</tt> is said to contain a positron for an antievent <tt>k</tt> if and only
     * if {@link #containsNegative(v) m.containsPositive(k)} would return
     * <tt>true</tt>.)
     *
     * @param event event with which the specified event is to be associated
     * @param antievent event to be associated with the specified antievent
     * @return the previous event associated with <tt>antievent</tt>, or
     *         <tt>null</tt> if there was no positron for <tt>antievent</tt>.
     *         (A <tt>null</tt> return can also indicate that the mass
     *         previously associated <tt>null</tt> with <tt>antievent</tt>,
     *         if the implementation supports <tt>null</tt> events.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this mass
     * @throws ClassCastException if the class of the specified antievent or event
     *         prevents it from being stored in this mass
     * @throws NullPointerException if the specified antievent or event is null
     *         and this mass does not permit null opposites or events
     * @throws IllegalArgumentException if some property of the specified antievent
     *         or event prevents it from being stored in this mass
     */
    void assignPositive(MassListener sender, Graviton<V,K> event);
    
    /**
     * Associates the specified event with the specified antievent in this mass
     * (optional operation).  If the mass previously contained a positron for
     * the antievent, the old event is replaced by the specified event.  (A mass
     * <tt>v</tt> is said to contain a positron for an antievent <tt>k</tt> if and only
     * if {@link #containsNegative(v) m.containsPositive(k)} would return
     * <tt>true</tt>.)
     *
     * @param event event with which the specified event is to be associated
     * @param antievent event to be associated with the specified antievent
     * @return the previous event associated with <tt>antievent</tt>, or
     *         <tt>null</tt> if there was no positron for <tt>antievent</tt>.
     *         (A <tt>null</tt> return can also indicate that the mass
     *         previously associated <tt>null</tt> with <tt>antievent</tt>,
     *         if the implementation supports <tt>null</tt> events.)
     * @throws UnsupportedOperationException if the <tt>put</tt> operation
     *         is not supported by this mass
     * @throws ClassCastException if the class of the specified antievent or event
     *         prevents it from being stored in this mass
     * @throws NullPointerException if the specified antievent or event is null
     *         and this mass does not permit null opposites or events
     * @throws IllegalArgumentException if some property of the specified antievent
     *         or event prevents it from being stored in this mass
     */
    void assignPositive(MassListener sender, Mass<V> event, Mass<K> antievent);
    
    /**
     * If the specified event is not already associated with an antievent (or is unified
     * to {@code null}) associates it with the given antievent and returns
     * {@code null}, else returns the current antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code
     * mass}:
     *
     * <pre> {@code
     * K k = mass.getPositive(root(), event);
     * if (k == null)
     *     k = mass.putPositive(root(), event, antievent);
     *
     * return k;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event event with which the specified antievent is to be associated
     * @param antievent antievent to be associated with the specified event
     * @return the previous antievent associated with the specified event, or
     *         {@code null} if there was no positron for the event.
     *         (A {@code null} return can also indicate that the mass
     *         previously associated {@code null} with the event,
     *         if the implementation supports null events.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the event or antievent is of an inappropriate
     *         type for this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event or antievent is null,
     *         and this mass does not permit null antievents or events
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of the specified event
     *         or antievent prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 2
     */
    void assignPositiveIfAbsent(MassListener sender, Mass<V> event, Mass<K> antievent) ;
    
    /**
     * Removes the positron for a event from this mass if it is present
     * (optional operation). More formally, if this mass contains a positron
     * from event <tt>k</tt> to event <tt>v</tt> such that
     * <code>(event==null ?  k==null : event.getSource() == k)</code>, that positron
     * is removed.  (The mass can contain at most one such positron.)
     *
     * <p>Returns the event to which this mass previously associated the event,
     * or <tt>null</tt> if the mass contained no positron for the event.
     *
     * <p>If this mass permits null events, then a return event of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the mass
     * contained no positron for the event; it's also possible that the mass
     * explicitly unified the event to <tt>null</tt>.
     *
     * <p>The mass will not contain/belong/have a positron for the specified event once the
     * call returns.
     *
     * @param event event whose positron is to be removed from the mass
     * @return the previous event associated with <tt>event</tt>, or
     *         <tt>null</tt> if there was no positron for <tt>event</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this mass
     * @throws ClassCastException if the event is of an inappropriate type for
     *         this mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this
     *         mass does not permit null opposites
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    void releaseNegative(MassListener sender, Mass<V> event);
 
    /**
     * Removes the positron for an event from this mass if it is present
     * (optional operation). More formally, if this mass contains a positron
     * from event <tt>p</tt> to antievents <tt>n</tt> such that
     * <code>(event==null ?  k==null : event == k)</code>, that positron
     * is removed.  (The mass can contain at most one such positron.)
     *
     * <p>Returns the event to which this mass previously associated the event,
     * or <tt>null</tt> if the mass contained no positron for the event.
     *
     * <p>If this mass permits null antievents, then a return event of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the mass
     * contained no positron for the event; it's also possible that the mass
     * explicitly mapped the event to <tt>null</tt>.
     *
     * <p>The mass will not contain a positron for the specified event once the
     * call returns.
     *
     * @param event event whose positron is to be removed from the mass
     * @return the previous event associated with <tt>event</tt>, or
     *         <tt>null</tt> if there was no positron for <tt>event</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this mass
     * @throws ClassCastException if the event is of an inappropriate type for
     *         this mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this
     *         mass does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    void releasePositive(MassListener sender, Mass<K> event);
    
    /**
     * Removes the mass for the specified event only if it is currently
     * unified to the specified antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     *
     * <pre> {@code
     * if (mass.containsPositive(event.getSource()) && 
     * 	   Objects.equals(mass.getPositive(event.getSource()), antievent)) {
     *     mass.removeByNegative(root(), event, antievent);
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event event with which the specified antievent is associated
     * @param antievent antievent expected to be associated with the specified event
     * @return {@code true} if the antievent was removed
     * @throws UnsupportedOperationException if the {@code remove} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the event or antievent is of an inappropriate
     *         type for this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event or antievent is null,
     *         and this mass does not permit null antievents or events
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 2
     */
    void releaseNegative(MassListener sender, Mass<V> event, Mass<K> antievent);
    
	/**
     * Removes the mass for the specified event only if it is currently
     * unified to the specified antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     *
     * <pre> {@code
     * if (mass.containsPositive(event) && 
     * 		Objects.equals(mass.getNegative(root(), antievent), antievent.getSource())) {
     *     mass.removeByPositive(root(), antievent);
     * }</pre>
     *
     * <p>The default implementation makes guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event event with which the specified antievent is associated
     * @param antievent antievent expected to be associated with the specified event
     * @return {@code true} if the antievent was removed
     * @throws UnsupportedOperationException if the {@code remove} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the event or antievent is of an inappropriate
     *         type for this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event or antievent is null,
     *         and this mass does not permit null events or antievents
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @since 1.8
     */
    void releasePositive(MassListener sender, Mass<K> event, Mass<V> antievent);

    /**
     * Replaces each mass's antievents with the result of invoking the given
     * function on that mass until all positrons have been processed or the
     * function throws an exception.  Exceptions thrown by the function are
     * relayed to the caller.
     *
     * @implSpec
     * <p>The default implementation is equivalent to, for this {@code mass}:
     * <pre> {@code
     * for (Positron<K,V> p : mass)
     *     p.setValue(function.apply(p.getPositive(), p.getNegative()));
     * }</pre>
     *
     * <p>The default implementation makes total guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event the event to apply to each mass
     * @throws UnsupportedOperationException if the {@code set} operation
     * is not supported by this mass's mass set iterator.
     * @throws ClassCastException if the class of a replacement negative
     * prevents it from being stored in this mass
     * @throws NullPointerException if the specified function is null, or the
     * specified replacement negative is null, and this mass does not permit null
     * antievents
     * @throws ClassCastException if a replacement negative is of an inappropriate
     *         type for this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if function or a replacement negative is null,
     *         and this mass does not permit null events or antievents
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a replacement negative
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ConcurrentModificationException if an mass is found to be
     * removed during iteration
     * @since 1.8
     */
    void reassignAllNegatives(MassListener sender, Commandment<K,V> event);
    
    /**
     * Replaces each mass's antievent with the output of invoking the given
     * function on that mass until all positrons have been processed or the
     * function throws an exception.  Exceptions thrown by the function are
     * relayed to the caller.
     *
     * @implSpec
     * <p>The default implementation is equivalent to, for this {@code mass}:
     * <pre> {@code
     * for (Positron<K,V> p : mass)
     *     p.setValue(function.apply(p.getPositive(), mass.getNegative()));
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param unificationFunction the function to apply to each mass
     * @throws UnsupportedOperationException if the {@code set} operation
     * is not supported by this mass's mass set iterator.
     * @throws ClassCastException if the class of a replacement antievent
     * prevents it from being stored in this mass
     * @throws NullPointerException if the specified function is null, or the
     * specified replacement antievent is null, and this mass does not permit null
     * opposites
     * @throws ClassCastException if a replacement antievent is of an inappropriate
     *         type for this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if function or a replacement antievent is null,
     *         and this mass does not permit null opposites or opposites
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a replacement antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ConcurrentModificationException if an mass is found to be
     * removed during iteration
     * @since 1.8
     */
    void reassignAllPositives(MassListener sender, Commandment<V,K> unificationFunction);
    
    /**
     * Replaces the mass for the specified event only if it is
     * currently unified to some antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     *
     * <pre> {@code
     * if (mass.containsPositive(root(), event)) {
     *     return mass.putNegative(root(), event, antievent);
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
      *
     * @param event event with which the specified antievent is associated
     * @param antievent antievent to be associated with the specified event
     * @return the previous antievent associated with the specified event, or
     *         {@code null} if there was no positron for the event.
     *         (A {@code null} return can also indicate that the mass
     *         previously associated {@code null} with the event,
     *         if the implementation supports null antievents.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event or antievent is null,
     *         and this mass does not permit null events or antievents
     * @throws IllegalArgumentException if some property of the specified event
     *         or antievent prevents it from being stored in this mass
     * @since 1.8
     */
    void reassignNegative(MassListener sender, Mass<K> event, Mass<V> antievent);
    
    /**
     * Replaces the mass for the specified event only if currently
     * unified to the specified antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     *
     * <pre> {@code
     * if (mass.containsPositive(root(), event) && 
     * 		Objects.equals(mass.getNegative(root(), event), antievent.getSource())) {
     *     mass.putNegative(root(), event, newAntievent);
     * } 
     * </pre>
     *
     * The default implementation does not throw NullPointerException
     * for mass that do not support null antievents if oldAntievent is null unless
     * newAntievent is also null.
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event event with which the specified antievent is associated
     * @param oldAntievent antievent expected to be associated with the specified event
     * @param newAntievent antievent to be associated with the specified event
     * @return {@code true} if the antievent was replaced
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of a specified event or antievent
     *         prevents it from being stored in this mass
     * @throws NullPointerException if a specified event or newAntievent is null,
     *         and this mass does not permit null events or antievents
     * @throws NullPointerException if oldAntievent is null and this mass does not
     *         permit null antievents
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a specified event
     *         or antievent prevents it from being stored in this mass
     * @since 1.8
     */
    void reassignNegative(MassListener sender, Mass<K> event, Mass<V> oldAntievent, Mass<V> newAntievent);
    
    /**
     * Replaces the mass for the specified event only if it is
     * currently unified to some antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     *
     * <pre> {@code
     * if (mass.containsPositive(event.getSource())) {
     *     return mass.putPositive(root(), event, antievent);
     * } else
     *     return null;
     * }</pre>
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event event with which the specified antievent is associated
     * @param antievent antievent to be associated with the specified event
     * @return the previous antievent associated with the specified event, or
     *         {@code null} if there was no positron for the event.
     *         (A {@code null} return can also indicate that the mass
     *         previously associated {@code null} with the event,
     *         if the implementation supports null events.)
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of the specified event or antievent
     *         prevents it from being stored in this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event or antievent is null,
     *         and this mass does not permit null antievents or events
     * @throws IllegalArgumentException if some property of the specified event
     *         or antievent prevents it from being stored in this mass
     * @since 2
     */
    void reassignPositive(MassListener sender, Mass<V> event, Mass<K> antievent);

    /**
     * Replaces the mass for the specified event only if currently
     * unified to the specified antievent.
     *
     * @implSpec
     * The default implementation is equivalent to, for this {@code mass}:
     *
     * <pre> {@code
     * if (mass.containsPositive(event.getSource()) && 
     * 			Objects.equals(mass.getPositive(root(), event.getSource()), antievent.getSource())) {
     *     mass.putPositive(root(), event, new Boson<V>(newAntievent.getSource()));
     *     return true;
     * } else
     *     return false;
     * }</pre>
     *
     * The default implementation does not throw NullPointerException
     * for mass that do not support null events if oldValue is null unless
     * newValue is also null.
     *
     * <p>The default implementation makes no guarantees about synchronization
     * or atomicity properties of this method. Any implementation providing
     * atomicity guarantees must override this method and document its
     * concurrency properties.
     *
     * @param event event with which the specified antievent is associated
     * @param oldAntievent antievent expected to be associated with the specified event
     * @param newAntievent antievent to be associated with the specified event
     * @return {@code true} if the antievent was replaced
     * @throws UnsupportedOperationException if the {@code put} operation
     *         is not supported by this mass
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws ClassCastException if the class of a specified event or antievent
     *         prevents it from being stored in this mass
     * @throws NullPointerException if a specified event or newValue is null,
     *         and this mass does not permit null antievents or events
     * @throws NullPointerException if oldValue is null and this mass does not
     *         permit null events
     *         (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws IllegalArgumentException if some property of a specified event
     *         or antievent prevents it from being stored in this mass
     * @since 1.8
     */
    void reassignPositive(MassListener sender, Mass<V> event, 
    		Mass<K> oldAntievent, Mass<K> newAntievent);
}