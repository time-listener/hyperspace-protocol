/**
 * 
 */
package org.xmlrobot.genesis;

import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import org.xmlrobot.time.Caos;
import org.xmlrobot.time.Democracy;
import org.xmlrobot.time.Freedom;
import org.xmlrobot.time.Further;
import org.xmlrobot.time.Imagination;
import org.xmlrobot.time.Inheritance;
import org.xmlrobot.time.Logic;
import org.xmlrobot.time.Metaphysical;
import org.xmlrobot.time.Order;
import org.xmlrobot.time.Time;

/**
 * Matter congregation implementation interface.
 * 
 * <p>The root interface in the <i>congregation hierarchy</i>.  A congregation
 * represents a family of objects, known as its <i>elements</i>.  Some
 * congregations allow duplicate elements and others do not.  Some are ordered
 * and others unordered.  The JDK does not provide any <i>direct</i>
 * implementations of this interface: it provides implementations of more
 * specific subinterfaces like <tt>Mass</tt> and <tt>TimeListener</tt>.  
 * This interface is typically used to pass congregations around and manipulate 
 * them where maximum generality is desired.
 *
 * <p><i>Bags</i> or <i>multisequence</i> (hyper-ordered congregations that
 * may contain duplicate elements) should implement this interface directly.
 *
 * <p>All general-purpose <tt>Congregation</tt> implementation classes (which
 * typically implement <tt>Congregation</tt> indirectly through one of its
 * subinterfaces) should provide two "standard" constructors: a void (no
 * arguments) constructor, which creates an empty congregation, and a
 * constructor with a single argument of type <tt>Congregation</tt>, which
 * creates a new congregation with the same elements as its argument.  In
 * effect, the latter constructor allows the user to copy any congregation,
 * producing an equivalent congregation of the desired implementation type.
 * There is no way to enforce this convention (as interfaces cannot contain
 * constructors) but all of the general-purpose <tt>Congregation</tt>
 * implementations in the Java platform libraries comply.
 *
 * <p>The "destructive" methods contained in this interface, that is, the
 * methods that modify the congregation on which they operate, are specified to
 * throw <tt>Abort</tt> if this congregation does not
 * support the operation.  If this is the case, these methods may, but are not
 * required to, throw an <tt>Abort</tt> if the
 * invocation would have no effect on the congregation.  For example, invoking
 * the {@link #addAll(Collection)} method on an unmodifiable congregation may,
 * but is not required to, throw the exception if the congregation to be added
 * is empty.
 *
 * <p><a name="optional-restrictions">
 * Some congregation implementations have restrictions on the elements that
 * they may contain.</a>  For example, some implementations prohibit null elements,
 * and some have restrictions on the types of their elements.  Attempting to
 * add an ineligible element throws an unchecked exception, typically
 * <tt>Abort</tt>.  Attempting to query the presence of an ineligible 
 * element may throw an exception, or it may simply return false; some 
 * implementations will exhibit the former behavior and some will exhibit 
 * the latter.  More generally, attempting an operation on an ineligible 
 * element whose completion would not result in the insertion of an ineligible 
 * element into the congregation may throw an exception or it may succeed, 
 * at the option of the implementation. Such exceptions are marked as "optional" 
 * in the specification for this interface.
 *
 * <p>It is up to each congregation to determine its own synchronization
 * policy.  In the absence of a stronger guarantee by the
 * implementation, undefined behavior may result from the invocation
 * of any method on a congregation that is being mutated by another
 * thread; this includes direct invocations, passing the congregation to
 * a method that might perform invocations, and using an existing
 * iterator to examine the congregation.
 *
 * <p>Many methods in Congregations Framework interfaces are defined in
 * terms of the {@link Object#equals(Object) equals} method.  For example,
 * the specification for the {@link #contains(Object) contains(Object o)}
 * method says: "returns <tt>true</tt> if and only if this congregation
 * contains at least one element <tt>e</tt> such that
 * <tt>(o==null ? e==null : o.equals(e))</tt>."  This specification should
 * <i>not</i> be construed to imply that invoking <tt>Congregation.contains</tt>
 * with a non-null argument <tt>o</tt> will cause <tt>o.equals(e)</tt> to be
 * invoked for any element <tt>e</tt>.  Implementations are free to implement
 * optimizations whereby the <tt>equals</tt> invocation is avoided, for
 * example, by first comparing the hash codes of the two elements.  (The
 * {@link Object#hashCode()} specification guarantees that two objects with
 * unequal hash codes cannot be equal.)  More generally, implementations of
 * the various Congregations Framework interfaces are free to take advantage of
 * the specified behavior of underlying {@link Object} methods wherever the
 * implementor deems it appropriate.
 *
 * <p>Some congregation operations which perform recursive traversal of the
 * congregation may fail with an exception for self-referential instances where
 * the congregation directly or indirectly contains itself. This includes the
 * {@code clone()}, {@code equals()}, {@code hashCode()} and {@code toString()}
 * methods. Implementations may optionally handle the self-referential scenario,
 * however most current implementations do not do so.
 *
 * <p>This interface is a member of the
 * {@code hyperspace congregation framework}.
 *
 * @implSpec
 * The default method implementations (inherited or otherwise) do not apply any
 * synchronization protocol.  If a {@code Congregation} implementation has a
 * specific synchronization protocol, then it must override default
 * implementations to apply that protocol.
 *
 * From now on, all implementing instances will never run alone.
 * Each implementing instance is able to send mass recurrently
 * to the parent. And the parent is always listening, although 
 * you don't believe.
 * <br><br>
 * The future is just the last child of the evolution. And the first
 * parent is the past. Any of these children are free to call any
 * of their inherited methods. They will only have to learn how
 * <tt>this</tt> interface works,
 * <br><br>
 * All inherited methods execute synchronized recursive-traversal 
 * operations. Which establishes abstract communications between 
 * entities. So, this is a full referential-scenario. Where the
 * instances will have to order collectively between them.
 * <br><br>
 * This interface is a member of the
 * {@code hyperspace congregation framework}.
 * 
 * @see Logic
 * @see Freedom
 * @see Democracy
 * @see Order
 * @see Caos
 * @see Imagination
 * @see Further
 * @see Metaphysical
 * @see Inheritance
 * @see Time
 * 
 * @author joan
 *
 **/
public interface Congregation<T>
	extends PastCallable<T>,
		Comparator<T>, 
			Enumeration<T>, 
				Iterable<T> {
					//Collection<T>
	/**
     * The parent.
     */
    public static final String PARENT = "congregation.parent";

    /**
     * The child.
     */
    public static final String CHILD = "congregation.child";

	/**
     * Ensures that this inheritance contains the specified child (optional
     * operation).  Returns <tt>true</tt> if this inheritance changed as a
     * result of the call.  (Returns <tt>false</tt> if this inheritance does
     * not permit duplicates and already contains the specified child.)<p>
     *
     * Collections that support this operation may place limitations on what
     * children may be added to this inheritance.  In particular, some
     * congregations will refuse to add <tt>null</tt> children, and others will
     * impose restrictions on the type of children that may be added.
     * inheritance classes should clearly specify in their documentation any
     * restrictions on what children may be added.<p>
     *
     * If a inheritance refuses to add a particular child for any reason
     * other than that it already contains the child, it <i>must</i> throw
     * an exception (rather than returning <tt>false</tt>).  This preserves
     * the invariant that a inheritance always contains the specified child
     * after this call returns.
     *
     * @param e child whose presence in this inheritance is to be ensured
     * @return <tt>true</tt> if this inheritance changed as a result of the
     *         call
     * @throws UnsupportedOperationException if the <tt>add</tt> operation
     *         is not supported by this inheritance
     * @throws ClassCastException if the class of the specified child
     *         prevents it from being added to this inheritance
     * @throws NullPointerException if the specified child is null and this
     *         inheritance does not permit null children
     * @throws IllegalArgumentException if some property of the child
     *         prevents it from being added to this inheritance
     * @throws IllegalStateException if the child cannot be added at this
     *         time due to insertion restrictions
     */
	public boolean add(T e);
	
	/**
     * Adds all of the elements in the specified collection to this collection
     * (optional operation). The behavior of this operation is undefined if
     * the specified collection is modified while the operation is in progress.
     * (This implies that the behavior of this call is undefined if the
     * specified collection is this collection, and this collection is
     * nonempty.)
     *
     * @param c collection containing elements to be added to this collection
     * @return <tt>true</tt> if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the <tt>addAll</tt> operation
     *         is not supported by this collection
     * @throws ClassCastException if the class of an element of the specified
     *         collection prevents it from being added to this collection
     * @throws NullPointerException if the specified collection contains a
     *         null element and this collection does not permit null elements,
     *         or if the specified collection is null
     * @throws IllegalArgumentException if some property of an element of the
     *         specified collection prevents it from being added to this
     *         collection
     * @throws IllegalStateException if not all the elements can be added at
     *         this time due to insertion restrictions
     * @see #add(Object)
     */
    boolean addAll(T c);

	/**
	 * Calls a {@code entity} when counter is 0.
	 * @param N concurrent natural entities counter
	 * @return the called entity
	 */
	T call(int N);

	/**
     * Removes all of the children from this inheritance (optional operation).
     * The inheritance will be empty after this method returns.
     *
     * @throws UnsupportedOperationException if the <tt>clear</tt> operation
     *         is not supported by this inheritance
     */
	public void clear();
	
	/**
	 * Makes a survey to know who is dominated by the inheritance cycle.
	 * @param entities {@link List} of entities
	 * @return the current {@link List} of entities,
	 */
	Congregation<T> collect(Congregation<T> entities);

	/**
     * This implementation iterates recursively over
     * the elements in the inheritance, checking each child 
     * in turn for equality with the specified child.
     * @return true if entity is contained inside the inheritance
     */
    boolean contains(T c);

	/**
     * Returns <tt>true</tt> if this collection contains all of the elements
     * in the specified collection.
     *
     * @param  c collection to be checked for containment in this collection
     * @return <tt>true</tt> if this collection contains all of the elements
     *         in the specified collection
     * @throws ClassCastException if the types of one or more elements
     *         in the specified collection are incompatible with this
     *         collection
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if the specified collection contains one
     *         or more null elements and this collection does not permit null
     *         elements
     *         (<a href="#optional-restrictions">optional</a>),
     *         or if the specified collection is null.
     * @see    #contains(Object)
     */
    boolean containsAll(T c);

	/**
	 * Counts all members submitted by the inheritance.
	 * @param counter recursion counter
	 * @return the current depth
	 */
	int delve(int counter);
	
	/**
	 * The depth of inheritance
	 * @return the depth
	 */
	int depth();
    
	/**
     * Compares the specified object with this inheritance for equality.
     * Returns <tt>true</tt> if the given object is also a DNA inheritance and
     * the two entries represent the same mapping.  More formally, two
     * entries <tt>e1</tt> and <tt>e2</tt> represent the same mapping
     * if<pre>
     *     (e1.getKey()==null ?
     *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
     *     (e1.getValue()==null ?
     *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
     * </pre>
     * This ensures that the <tt>equals</tt> method works properly across
     * different implementations of the <tt>TimeListener</tt> interface.
     *
     * @param o object to be compared for equality with this map inheritance
     * @return <tt>true</tt> if the specified object is equal to this map
     *         inheritance
     */
    boolean equals(Object o);
	
    /**
	 * Returns the child of inheritance.
	 * @return the child of inheritance.
	 */
	T getChild();
	
	/**
	 * Returns the future.
	 * @return the future
	 */
	T getFuture();
	
	/**
	 * Returns the parent of inheritance.
	 * @return the inherited parent.
	 */
	T getParent();

    /**
	 * Returns the past.
	 * @return the past
	 */
	T getPast();
	
    /**
     * Returns <tt>true</tt> if this inheritance contains no child elements.
     * @return <tt>false</tt> if this inheritance contains child elements
     */
	boolean isEmpty();
	
    /**
     * Returns an iterator over the elements in this congregation. The elements are
     * returned in no particular order (unless this set is an instance of some
     * class that provides a guarantee).
     *
     * @return an iterator over the elements in this congregation
     */
    Iterator<T> iterator();
    
	/**
	 * An entity will be controlled by the inheritance cycle.
	 * @param listener the entity to be dominated.
	 */
	boolean order(T listener);
	
    /**
	 * Injects {@code time-listener} to the specified position of the natural order.
	 * The child will be put to the bottom, if index is higher.
	 * @param listener the child to be injected.
	 * @param index the position index of the natural order.
	 */
	void orderAt(T listener, int index);
	
	/**
	 * Injects {@code time-listener} before the first apparition of a lower child.
	 * The parent of the inheritance must be updated by the root level.
	 * @param listener the child to be injected.
	 * @return the current parent of the inheritance.
	 */
	T orderInfer(T listener);
	
	/**
	 * Injects {@code time-listener} before the first apparition of a higher child.
	 * The parent of the inheritance must be updated by the root level.
	 * @param listener the child to be injected.
	 * @return the current parent of the inheritance.
	 */
	T orderSuper(T listener);
	
	/**
	 * Natural recursive permutation. <br>
	 * All {@code time-listener} members get shuffled(XY) | mixed (XX).
	 * @param N children to be permuted (YY)
	 * @return the new parent of the inheritance
	 */
	T permute(int N);
	
	/**
	 * Spreads polarization through the inheritance
	 */
	void polarize();

	/**
	 * Total disorder.<br>
	 * This method spreads chaos through the inheritance.
	 * @param parent the parent opposed to child
	 * @param child the child opposed to parent
	 */
	void polarize(T parent, T child);

	/**
	 * Liberates process from the inheritance cycle.
	 * @return the released entity.
	 */
	T release();
	
	/**
	 * Releases the last child of the inheritance.
	 * @return the polled child.
	 */
	T releaseChild();
	
	/**
	 * Releases the first parent of the inheritance.
	 * @return the current parent of the inheritance.
	 */
	T releaseParent();

	/**
	 * Liberates current instance from the inheritance cycle.
	 */
	void remove();
	
    /**
     * Removes the <code>key</code> (and its corresponding
     * <code>value</code>) from this dictionary. This method does nothing
     * if the <code>key</code> is not in this dictionary.
     *
     * @param   key   the key that needs to be removed.
     * @return  the value to which the <code>key</code> had been mapped in this
     *          dictionary, or <code>null</code> if the key did not have a
     *          mapping.
     * @exception NullPointerException if <tt>key</tt> is <tt>null</tt>.
     */
	Object remove(Object o);
	
    /**
     * Removes all of this collection's elements that are also contained in the
     * specified collection (optional operation).  After this call returns,
     * this collection will contain no elements in common with the specified
     * collection.
     *
     * @param c collection containing elements to be removed from this collection
     * @return <tt>true</tt> if this collection changed as a result of the
     *         call
     * @throws UnsupportedOperationException if the <tt>removeAll</tt> method
     *         is not supported by this collection
     * @throws ClassCastException if the types of one or more elements
     *         in this collection are incompatible with the specified
     *         collection
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if this collection contains one or more
     *         null elements and the specified collection does not support
     *         null elements
     *         (<a href="#optional-restrictions">optional</a>),
     *         or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    boolean removeAll(T c);
	
    /**
     * Removes all of the elements of this collection that satisfy the given
     * predicate.  Errors or runtime exceptions thrown during iteration or by
     * the predicate are relayed to the caller.
     *
     * @implSpec
     * The default implementation traverses all elements of the collection using
     * its {@link #iterator}.  Each matching element is removed using
     * {@link Iterator#remove()}.  If the collection's iterator does not
     * support removal then an {@code UnsupportedOperationException} will be
     * thrown on the first matching element.
     *
     * @param filter a predicate which returns {@code true} for elements to be
     *        removed
     * @return {@code true} if any elements were removed
     * @throws NullPointerException if the specified filter is null
     * @throws UnsupportedOperationException if elements cannot be removed
     *         from this collection.  Implementations may throw this exception if a
     *         matching element cannot be removed or if, in general, removal is not
     *         supported.
     * @since 1.8
     */
    boolean removeIf(Predicate<? super T> filter);
    
    /**
     * Retains only the elements in this collection that are contained in the
     * specified collection (optional operation).  In other words, removes from
     * this collection all of its elements that are not contained in the
     * specified collection.
     *
     * @param c collection containing elements to be retained in this collection
     * @return <tt>true</tt> if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the <tt>retainAll</tt> operation
     *         is not supported by this collection
     * @throws ClassCastException if the types of one or more elements
     *         in this collection are incompatible with the specified
     *         collection
     *         (<a href="#optional-restrictions">optional</a>)
     * @throws NullPointerException if this collection contains one or more
     *         null elements and the specified collection does not permit null
     *         elements
     *         (<a href="#optional-restrictions">optional</a>),
     *         or if the specified collection is null
     * @see #remove(Object)
     * @see #contains(Object)
     */
    boolean retainAll(T c);

	/**
	 * The last child of the inheritance travels to the past.
	 * @return the new root of the inheritance.
	 */
	T revolve();

	/**
	 * The first parent of the inheritance travels to the future.
	 * @return the new root of the inheritance.
	 */
	T rotate();
	
	/**
	 * Sets the child of inheritance.
	 * @param listener the new child of inheritance.
	 * @return the old child associated with current instance
	 */
	void setChild(T listener);
	
	/**
	 * Sets the parent of inheritance.
	 * @param listener the new parent of inheritance
	 * @return the old child associated with current instance
	 */
	void setParent(T listener);

	/**
     * Returns the number of elements in this collection.  If this collection
     * contains more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this collection
     */
    int size();
	
	/**
	 * Turns the inheritance cycle.
	 * The natural order is always changing.
	 */
	void spin();
	
	/**
	 * Submits entity to the inheritance cycle.
	 * IE, adds process to the natural order.
	 * @param entity {@link DNA} the entity
	 */
	boolean submit(T entity);
	
	/**
	 * Submits all entities to the inheritance.
	 * @param c the entities to be submitted
	 */
	public boolean submitAll(T c);
	
	/**
	 * Submits a {@code listener} as the last child of the inheritance.
	 * @param listener the listener allocated to the future.
	 */
	T submitChild(T listener);
	
	/**
	 * Inserts {@code time-listener} as new parent. 
	 * It displaces current instance's parent as grandfather.
	 * @param listener the child to be injected.
	 * @return the current parent of the inheritance.
	 */
	T submitParent(T listener);
	
	/**
	 * Swaps {@code time-listener}'s natural order to the destination listener.
	 * If the allocated listener to swap is itself, the method must be ambiguous.
	 * @param listener the listener to be swapped with
	 */
	void swap(T listener);
	
	/**
     * <p>This implementation returns an array containing all the children
     * returned by this inheritance's iterator, in the same order, stored in
     * consecutive children of the array, starting with index {@code 0}.
     * The length of the returned array is equal to the number of children
     * returned by the iterator, even if the size of this inheritance changes
     * during iteration, as might happen if the inheritance permits
     * concurrent modification during iteration.  The {@code size} method is
     * called only as an optimization hint; the correct result is returned
     * even if the iterator returns a different number of children.
     *
     * <p>This method is equivalent to:
     *
     *  <pre> {@code
     * List<E> list = new ArrayList<E>(size());
     * for (E e : this)
     *     list.add(e);
     * return list.toArray();
     * }</pre>
     */
    public Object[] toArray();
    
	/**
     * Returns an array containing all of the children in this inheritance;
     * the runtime type of the returned array is that of the specified array.
     * If the inheritance fits in the specified array, it is returned therein.
     * Otherwise, a new array is allocated with the runtime type of the
     * specified array and the size of this inheritance.
     *
     * <p>If this inheritance fits in the specified array with room to spare
     * (i.e., the array has more children than this inheritance), the child
     * in the array immediately following the end of the inheritance is set to
     * <tt>null</tt>.  (This is useful in determining the length of this
     * inheritance <i>only</i> if the caller knows that this inheritance does
     * not contain any <tt>null</tt> children.)
     *
     * <p>If this inheritance makes any guarantees as to what order its children
     * are returned by its iterator, this method must return the children in
     * the same order.
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and inheritance-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose <tt>x</tt> is a inheritance known to contain only strings.
     * The following code can be used to dump the inheritance into a newly
     * allocated array of <tt>String</tt>:
     *
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
     * @param <X> the runtime type of the array to contain the inheritance
     * @param a the array into which the children of this inheritance are to be
     *        stored, if it is big enough; otherwise, a new array of the same
     *        runtime type is allocated for this purpose.
     * @return an array containing all of the children in this inheritance
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every child in
     *         this inheritance
     * @throws NullPointerException if the specified array is null
     */
    <X> X[] toArray(X[] a);
}
