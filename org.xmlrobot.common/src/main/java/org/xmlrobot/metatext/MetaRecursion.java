/**
 * 
 */
package org.xmlrobot.metatext;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Mass;
import org.xmlrobot.horizon.Meta;
import org.xmlrobot.util.Congregation;

/**
 * @author joan
 *
 */
public interface MetaRecursion<K,V> 
	extends TimeListener<Metatext<K,V>,Metatext<V,K>>, 
		RecurrenceMeta<K,V>, MetaConcurrence<V,K> {
    /**
     * Returns the metatext at the specified position in this hypothetical mass.
     *
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<V> requestTo(MassListener sender, AtomicInteger N);

    /**
     * Returns the metatext at the specified position in this hypothetical mass.
     *
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<K> requestFrom(MassListener sender, AtomicInteger N);

    /**
     * Returns the metatext at the specified position in this hypothetical mass.
     *
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<K> requestFrom(MassListener sender, Mass<V> event);
	
	/**
     * Returns the metatext at the specified position in this hypothetical mass.
     *
     * @param index index of the metatext to return
     * @return the metatext at the specified position in this hypothetical mass
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Mass<V> requestTo(MassListener sender, Mass<K> event);
	
    /**
     * Returns <tt>true</tt> if this hypothetical mass contains a metatext for the specified
     * event.  More formally, returns <tt>true</tt> if and only if
     * this hypothetical mass contains a metatext for an event <tt>k</tt> such that
     * <tt>(event==null ? k==null : event.equals(k))</tt>.  (There can be
     * at most one such metatext.)
     * 
     * @param event event whose presence in this hypothetical mass is to be tested
     * @return <tt>true</tt> if this hypothetical mass contains a metatext for the specified event
     * @throws ClassCastException if the event is of an inappropriate type for this hypothetical mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this hypothetical mass does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean belongsTo(MassListener sender, Mass<V> event);

    /**
     * Returns <tt>true</tt> if this hypothetical mass contains a metatext for the specified
     * event.  More formally, returns <tt>true</tt> if and only if
     * this hypothetical mass contains a metatext for an event <tt>k</tt> such that
     * <tt>(event==null ? k==null : event.equals(k))</tt>.  (There can be
     * at most one such metatext.)
     * 
     * @param event event whose presence in this hypothetical mass is to be tested
     * @return <tt>true</tt> if this hypothetical mass contains a metatext for the specified event
     * @throws ClassCastException if the event is of an inappropriate type for this hypothetical mass
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified event is null and this hypothetical mass does not permit null events
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    boolean belongsFrom(MassListener sender, Mass<K> event);

    /**
     * Returns the index of the first occurrence of the specified metatext
     * in this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o metatext to search for
     * @return the index of the first occurrence of the specified metatext in
     *         this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext
     * @throws ClassCastException if the type of the specified metatext
     *         is incompatible with this hypothetical mass
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    AtomicInteger positionOfTo(MassListener sender, Mass<V> event);
    
    /**
     * Returns the index of the first occurrence of the specified metatext
     * in this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o metatext to search for
     * @return the index of the first occurrence of the specified metatext in
     *         this hypothetical mass, or -1 if this hypothetical mass does not contain the metatext
     * @throws ClassCastException if the type of the specified metatext
     *         is incompatible with this hypothetical mass
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified metatext is null and this
     *         hypothetical mass does not permit null metatexts
     *         (<a href="Collection.html#optional-restrictions">optional</a>)
     */
    AtomicInteger positionOfFrom(MassListener sender, Mass<K> event);
    
    /**
     * Sets the metatext at the specified position in this list with the
     * specified metatext (optional operation).
     *
     * @param N recursion counter
     * @param metatext metatext to be stored at the specified position
     * @return the metatext previously at the specified position
     * @throws UnsupportedOperationException if the <tt>set</tt> operation
     *         is not supported by this list
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified metatext is null and
     *         this list does not permit null metatexts
     * @throws IllegalArgumentException if some property of the specified
     *         metatext prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Meta<K,V> updateFrom(MassListener sender, AtomicInteger N, Meta<K,V> event);

    /**
     * Sets the metatext at the specified position in this list with the
     * specified metatext (optional operation).
     *
     * @param N recursion counter
     * @param metatext metatext to be stored at the specified position
     * @return the metatext previously at the specified position
     * @throws UnsupportedOperationException if the <tt>set</tt> operation
     *         is not supported by this list
     * @throws ClassCastException if the class of the specified metatext
     *         prevents it from being added to this list
     * @throws NullPointerException if the specified metatext is null and
     *         this list does not permit null metatexts
     * @throws IllegalArgumentException if some property of the specified
     *         metatext prevents it from being added to this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	Meta<V,K> updateTo(MassListener sender, AtomicInteger N, Meta<V,K> event);
	
	/**
     * Adds the specified metatext to the end of this hypothetical mass (optional
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
	void updateTo(MassListener sender, Meta<V,K> event);
	
	/**
     * Adds the specified metatext to the end of this hypothetical mass (optional
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
	void updateFrom(MassListener sender, Meta<K,V> event);

	/**
     * Adds the specified metatext to the end of this hypothetical mass (optional
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
	void updateFrom(MassListener sender, Mass<V> event, Mass<K> antievent);
	
	/**
     * Adds the specified metatext to the end of this hypothetical mass (optional
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
	void updateTo(MassListener sender, Mass<K> event, Mass<V> antievent);
    /**
     * Releases the metatext for a event from this hypothetical mass if it is present
     * (optional operation). More formally, if this hypothetical mass contains a metatext
     * from event <tt>k</tt> to event <tt>v</tt> such that
     * <code>(event==null ?  k==null : event.getSource() == k)</code>, that metatext
     * is removed.  (The hypothetical mass can contain at most one such metatext.)
     *
     * <p>Returns the event to which this hypothetical mass previously associated the event,
     * or <tt>null</tt> if the hypothetical mass contained no metatext for the event.
     *
     * <p>If this hypothetical mass permits null events, then a return event of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the hypothetical mass
     * contained no metatext for the event; it's also possible that the hypothetical mass
     * explicitly unified the event to <tt>null</tt>.
     *
     * <p>The hypothetical mass will not contain/belong/have a metatext for the specified event once the
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
     *         hypothetical mass does not permit null opposites
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
	void liberateTo(MassListener sender, AtomicInteger N, Mass<V> event);
	
    /**
     * Releases the metatext for a event from this hypothetical mass if it is present
     * (optional operation). More formally, if this hypothetical mass contains a metatext
     * from event <tt>k</tt> to event <tt>v</tt> such that
     * <code>(event==null ?  k==null : event.getSource() == k)</code>, that metatext
     * is removed.  (The hypothetical mass can contain at most one such metatext.)
     *
     * <p>Returns the event to which this hypothetical mass previously associated the event,
     * or <tt>null</tt> if the hypothetical mass contained no metatext for the event.
     *
     * <p>If this hypothetical mass permits null events, then a return event of
     * <tt>null</tt> does not <i>necessarily</i> indicate that the hypothetical mass
     * contained no metatext for the event; it's also possible that the hypothetical mass
     * explicitly unified the event to <tt>null</tt>.
     *
     * <p>The hypothetical mass will not contain/belong/have a metatext for the specified event once the
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
     *         hypothetical mass does not permit null opposites
     * (<a href="{@docRoot}/java/util/Collection.html#optional-restrictions">optional</a>)
     */
    void liberateFrom(MassListener  sender, AtomicInteger N, Mass<K> event);

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
    void liberateFrom(MassListener sender, AtomicInteger N);

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
	void liberateTo(MassListener sender, AtomicInteger N);



    /**
     * Returns a new {@code Congregation} that contains a subsequence of
     * objects currently contained in this meta-runnable. The
     * subsequence begins at the specified {@code start} and
     * extends to the object at index {@code end - 1}.
     *
     * @param      sender   {@link TimeListener} the sender
     * @param      start    The beginning index, inclusive.
     * @param      end      The ending index, exclusive.
     * @param      event    The congregation being gathered.
     * @return     The new subsequence.
     * @throws     StringIndexOutOfBoundsException  if {@code start}
     *             or {@code end} are negative or greater than
     *             {@code length()}, or {@code start} is
     *             greater than {@code end}.
     */
	Congregation<K> substringFrom(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<K> event);

    /**
     * Returns a new {@code Congregation} that contains a subsequence of
     * objects currently contained in this meta-runnable. The
     * subsequence begins at the specified {@code start} and
     * extends to the object at index {@code end - 1}.
     *
     * @param      sender   {@link TimeListener} the sender
     * @param      start    The beginning index, inclusive.
     * @param      end      The ending index, exclusive.
     * @param      event    The congregation being gathered.
     * @return     The new subsequence.
     * @throws     StringIndexOutOfBoundsException  if {@code start}
     *             or {@code end} are negative or greater than
     *             {@code length()}, or {@code start} is
     *             greater than {@code end}.
     */
	Congregation<V> substringTo(MassListener sender, AtomicInteger beginIndex, AtomicInteger endIndex, Congregation<V> event);
}
