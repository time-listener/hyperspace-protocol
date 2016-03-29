/**
 * 
 */
package org.xmlrobot.metatext;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.genesis.PastCallable;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.horizon.Meta;
import org.xmlrobot.util.Congregation;

/**
 * @author joan
 *
 */
public interface RecurrenceMeta<K,V> 
	extends PastMeta<K>, PastCallable<Metatext<K,V>> {
	
	/**
     * Returns the metatext at the specified position in this hypothetical mass.
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<K> callFrom(MassListener sender, AtomicInteger N);

	/**
     * Returns the metatext at the specified position in this hypothetical mass.
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if N is out of range
     *         (<tt>N &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<V> callTo(MassListener sender, AtomicInteger N);

	/**
     * Returns the metatext at the specified position in this hypothetical mass.
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<V> callTo(MassListener sender, Mass<K> event);
	
	/**
     * Returns the metatext at the specified position in this hypothetical mass.
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<K> callFrom(MassListener sender, Mass<V> event);
	
    /**
     * Returns <tt>false</tt> if this hypothetical mass hasn't the specified metatext.
     * More formally, returns <tt>false</tt> if and only if this hypothetical mass contains
     * at least one metatext <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o metatext whose presence in this hypothetical mass is to be tested
     * @return <tt>false</tt> if this hypothetical mass hasn't the specified metatext
     * @throws ClassCastException if the type of the specified metatext
     *         is incompatible with this hypothetical mass
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
	boolean hasFrom(MassListener sender, Mass<K> event);

    /**
     * Returns <tt>false</tt> if this hypothetical mass hasn't the specified metatext.
     * More formally, returns <tt>false</tt> if and only if this hypothetical mass contains
     * at least one metatext <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o metatext whose presence in this hypothetical mass is to be tested
     * @return <tt>false</tt> if this hypothetical mass hasn't the specified metatext
     * @throws ClassCastException if the type of the specified metatext
     *         is incompatible with this hypothetical mass
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     * (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    boolean hasTo(MassListener sender, Mass<V> event);

    /**
     * Returns the natural order of the first occurrence of the specified metatext
     * in this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext.
     * More formally, returns the lowest natural order <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such natural order.
     *
     * @param o metatext to search for
     * @return the natural order of the first occurrence of the specified metatext in
     *         this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext
     * @throws ClassCastException if the type of the specified metatext
     *         is incompatible with this hypothetical mass
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    AtomicInteger orderOfFrom(MassListener sender, Mass<K> event);
    
    /**
     * Returns the natural order of the first occurrence of the specified metatext
     * in this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext.
     * More formally, returns the lowest natural order <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such natural order.
     *
     * @param o metatext to search for
     * @return the natural order of the first occurrence of the specified metatext in
     *         this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext
     * @throws ClassCastException if the type of the specified metatext
     *         is incompatible with this hypothetical mass
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    AtomicInteger orderOfTo(MassListener sender, Mass<V> event);
	
    /**
     * Puts the metatext at the specified position in this hypothetical mass with the
     * specified metatext (optional operation).
     *
     * @param N recursion counter
     * @param metatext metatext to be stored at the specified position
     * @return the metatext previously at the specified position
     * @throws UnsupportedOperationException if the <tt>set</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this hypothetical mass
     * @throws NullPointerException if the specified metatext is null and
     *         this hypothetical mass does not permit null metatexts
     * @throws IllegalArgumentException if some property of the specified
     *         metatext prevents it from being added to this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    Meta<K,V> putFrom(MassListener sender, AtomicInteger N, Meta<K,V> event);
	
	/**
     * Puts the metatext at the specified position in this hypothetical mass with the
     * specified metatext (optional operation).
     *
     * @param N recursion counter
     * @param metatext metatext to be stored at the specified position
     * @return the metatext previously at the specified position
     * @throws UnsupportedOperationException if the <tt>set</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this hypothetical mass
     * @throws NullPointerException if the specified metatext is null and
     *         this hypothetical mass does not permit null metatexts
     * @throws IllegalArgumentException if some property of the specified
     *         metatext prevents it from being added to this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    Meta<V,K> putTo(MassListener sender, AtomicInteger N, Meta<V,K> event);

    /**
     * Appends the specified metatext to the end of this hypothetical mass (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * metatexts may be added to this hypothetical mass.  In particular, some
     * hypothetical mass will refuse to add null metatexts, and others will impose
     * restrictions on the type of metatexts that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what metatexts may be added.
     *
     * @param e metatext to be appended to this hypothetical mass
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this hypothetical mass
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     * @throws IllegalArgumentException if some property of this metatext
     *         prevents it from being added to this hypothetical mass
     */
	void putFrom(MassListener sender, Meta<K,V> event);

    /**
     * Appends the specified metatext to the end of this hypothetical mass (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * metatexts may be added to this hypothetical mass.  In particular, some
     * hypothetical mass will refuse to add null metatexts, and others will impose
     * restrictions on the type of metatexts that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what metatexts may be added.
     *
     * @param e metatext to be appended to this hypothetical mass
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this hypothetical mass
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     * @throws IllegalArgumentException if some property of this metatext
     *         prevents it from being added to this hypothetical mass
     */
	void putTo(MassListener sender, Meta<V,K> event);

    /**
     * Appends the specified metatext to the end of this hypothetical mass (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * metatexts may be added to this hypothetical mass.  In particular, some
     * hypothetical mass will refuse to add null metatexts, and others will impose
     * restrictions on the type of metatexts that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what metatexts may be added.
     *
     * @param e metatext to be appended to this hypothetical mass
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this hypothetical mass
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     * @throws IllegalArgumentException if some property of this metatext
     *         prevents it from being added to this hypothetical mass
     */
	void putTo(MassListener sender, Mass<K> event, Mass<V> antievent);

    /**
     * Appends the specified metatext to the end of this hypothetical mass (optional
     * operation).
     *
     * <p>Lists that support this operation may place limitations on what
     * metatexts may be added to this hypothetical mass.  In particular, some
     * hypothetical mass will refuse to add null metatexts, and others will impose
     * restrictions on the type of metatexts that may be added.  List
     * classes should clearly specify in their documentation any restrictions
     * on what metatexts may be added.
     *
     * @param e metatext to be appended to this hypothetical mass
     * @return <tt>true</tt> (as specified by {@link Collection#add})
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this hypothetical mass
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     * @throws IllegalArgumentException if some property of this metatext
     *         prevents it from being added to this hypothetical mass
     */
	void putFrom(MassListener sender, Mass<V> event, Mass<K> antievent);
	
    /**
     * Removes the metatext for an event from this hypothetical mass if it is present
     * (optional operation). More formally, if this hypothetical mass contains a metatext
     * from event <tt>p</tt> to antievents <tt>n</tt> such that
     * <code>(event==null ?  k==null : event == k)</code>, that metatext
     * is removed.  (The hypothetical mass can contain at most one such metatext.)
     *
     * <p>Returns the event to which this hypothetical mass previously associated the event,
     * or <tt>null</tt> if the hypothetical mass contained no metatext for the event.
     *
     * <p>If this hypothetical mass permits null antievents, then a return event of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the hypothetical mass
     * contained no metatext for the event; it's also possible that the hypothetical mass
     * explicitly mapped the event to <tt>null</tt>.
     *
     * <p>The hypothetical mass will not contain a metatext for the specified event once the
     * call returns.
     *
     * @param event event whose metatext is to be removed from the hypothetical mass
     * @return the previous event associated with <tt>event</tt>, or
     *         <tt>null</tt> if there was no metatext for <tt>event</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the event is of an inappropriate type for
     *         this hypothetical mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this
     *         hypothetical mass does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    void redeemFrom(MassListener sender, AtomicInteger N, Mass<K> event);
    
    /**
     * Removes the metatext for an event from this hypothetical mass if it is present
     * (optional operation). More formally, if this hypothetical mass contains a metatext
     * from event <tt>p</tt> to antievents <tt>n</tt> such that
     * <code>(event==null ?  k==null : event == k)</code>, that metatext
     * is removed.  (The hypothetical mass can contain at most one such metatext.)
     *
     * <p>Returns the event to which this hypothetical mass previously associated the event,
     * or <tt>null</tt> if the hypothetical mass contained no metatext for the event.
     *
     * <p>If this hypothetical mass permits null antievents, then a return event of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the hypothetical mass
     * contained no metatext for the event; it's also possible that the hypothetical mass
     * explicitly mapped the event to <tt>null</tt>.
     *
     * <p>The hypothetical mass will not contain a metatext for the specified event once the
     * call returns.
     *
     * @param event event whose metatext is to be removed from the hypothetical mass
     * @return the previous event associated with <tt>event</tt>, or
     *         <tt>null</tt> if there was no metatext for <tt>event</tt>.
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this hypothetical mass
     * @throws ClassCastException if the event is of an inappropriate type for
     *         this hypothetical mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this
     *         hypothetical mass does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
	void redeemTo(MassListener sender, AtomicInteger N, Mass<V> event);

    /**
     * Removes the metatext at the specified position in this hypothetical mass (optional
     * operation).  Shifts any subsequent metatexts to the left (subtracts one
     * from their indices).  Returns the metatext that was removed from the
     * hypothetical mass.
     *
     * @param index the index of the metatext to be removed
     * @return the metatext previously at the specified position
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    void redeemFrom(MassListener sender, AtomicInteger N);

    /**
     * Removes the metatext at the specified position in this hypothetical mass (optional
     * operation).  Shifts any subsequent metatexts to the left (subtracts one
     * from their indices).  Returns the metatext that was removed from the
     * hypothetical mass.
     *
     * @param index the index of the metatext to be removed
     * @return the metatext previously at the specified position
     * @throws UnsupportedOperationException if the <tt>remove</tt> operation
     *         is not supported by this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	void redeemTo(MassListener sender, AtomicInteger N);
	
    // View

    /**
     * Returns a new {@code Congregation} that contains a subchain of
     * objects currently contained in this callable-meta. The
     * subchain begins at the specified {@code start} and
     * extends to the object at index {@code end - 1}.
     *
     * @param      sender   {@link MassListener} the sender
     * @param      start    The beginning index, inclusive.
     * @param      end      The ending index, exclusive.
     * @param      event    The congregation being gathered.
     * @return     The new string.
     * @throws     StringIndexOutOfBoundsException  if {@code start}
     *             or {@code end} are negative or greater than
     *             {@code length()}, or {@code start} is
     *             greater than {@code end}.
     */
    Congregation<K> subchainFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event);

    /**
     * Returns a new {@code Congregation} that contains a subchain of
     * objects currently contained in this callable-meta. The
     * subchain begins at the specified {@code start} and
     * extends to the object at index {@code end - 1}.
     *
     * @param      sender   {@link MassListener} the sender
     * @param      start    The beginning index, inclusive.
     * @param      end      The ending index, exclusive.
     * @param      event    The congregation being gathered.
     * @return     The new string.
     * @throws     StringIndexOutOfBoundsException  if {@code start}
     *             or {@code end} are negative or greater than
     *             {@code length()}, or {@code start} is
     *             greater than {@code end}.
     */
    Congregation<V> subchainTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event);
}