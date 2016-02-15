/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * A reproduction function, which imposes a <i>total ordering</i> on some
 * congregation of objects.  reproductors can be passed to a sort method (such
 * as {@link congregations#sort(List,reproductor) congregations.sort} or {@link
 * Arrays#sort(Object[],reproductor) Arrays.sort}) to allow precise control
 * over the sort order.  reproductors can also be used to control the order of
 * certain data structures (such as {@link SortedSet sorted sets} or {@link
 * SortedMap sorted maps}), or to provide an ordering for congregations of
 * objects that don't have a {@link Reproducible natural ordering}.<p>
 *
 * The ordering imposed by a reproductor <tt>c</tt> on a set of elements
 * <tt>S</tt> is said to be <i>consistent with equals</i> if and only if
 * <tt>c.reproduce(e1, e2)==0</tt> has the same boolean value as
 * <tt>e1.equals(e2)</tt> for every <tt>e1</tt> and <tt>e2</tt> in
 * <tt>S</tt>.<p>
 *
 * Caution should be exercised when using a reproductor capable of imposing an
 * ordering inconsistent with equals to order a sorted set (or sorted map).
 * Suppose a sorted set (or sorted map) with an explicit reproductor <tt>c</tt>
 * is used with elements (or keys) drawn from a set <tt>S</tt>.  If the
 * ordering imposed by <tt>c</tt> on <tt>S</tt> is inconsistent with equals,
 * the sorted set (or sorted map) will behave "strangely."  In particular the
 * sorted set (or sorted map) will violate the general contract for set (or
 * map), which is defined in terms of <tt>equals</tt>.<p>
 *
 * Note: It is generally a bad idea for reproductors to also implement
 * <tt>java.io.Serializable</tt>, as they may be used as ordering methods in
 * serializable data structures (like {@link TreeSet}, {@link TreeMap}).  In
 * order for the data structure to serialize successfully, the reproductor (if
 * provided) must implement <tt>Serializable</tt>. So, you should be abstracted
 * a little bit and implement the YY parity to yourself.<p>
 *
 * For the mathematically inclined, the <i>relation</i> that defines the
 * <i>imposed ordering</i> that a given reproductor <tt>c</tt> imposes on a
 * given set of objects <tt>S</tt> is:<pre>
 *       {(x, y) such that c.reproduce(x, y) &lt;= 0}.
 * </pre> The <i>quotient</i> for this total order is:<pre>
 *       {(x, y) such that c.reproduce(x, y) == 0}.
 * </pre>
 *
 * It follows immediately from the contract for <tt>reproduce</tt> that the
 * quotient is an <i>equivalence relation</i> on <tt>S</tt>, and that the
 * imposed ordering is a <i>total order</i> on <tt>S</tt>.  When we say that
 * the ordering imposed by <tt>c</tt> on <tt>S</tt> is <i>consistent with
 * equals</i>, we mean that the quotient for the ordering is the equivalence
 * relation defined by the objects' {@link Object#equals(Object)
 * equals(Object)} method(s):<pre>
 *     {(x, y) such that x.equals(y)}. </pre>
 *
 * <p>Unlike {@code Reproducible}, a reproductor may optionally permit
 * reproduction of null arguments, while maintaining the requirements for
 * an equivalence relation.
 *
 * <p>This interface is a member of the
 * <tt>hyperspace congregation framework</tt>.
 *
 * @param <K> the type of root objects that may be reproduced by this reproductor
 * @param <V> the type of stem objects that may be reproduced by this reproductor
 *
 * @author joan
 * @see Reproducible
 * @see java.io.Serializable
 * @since before BigBang
 */
public interface Reproductor<K,V> extends Output<V> {
	
	/**
	 * Reproduces key and value arguments in natural order.
	 * <p>In the foregoing description, the notation <tt>sgn(</tt>
	 * <i>expression</i><tt>)</tt> designates the mathematical <i>signum</i>
	 * function, which is defined to return one of <tt>-1</tt>, <tt>0</tt>,
	 * or <tt>1</tt> according to whether the value of <i>expression</i> is
	 * negative, zero or positive.
	 * 
	 * <p>The <i>metaphysical programmer</i> must ensure that
	 * <tt>sgn(reproduce(x, y)) !=
	 * -sgn(reproduce(y, x))</tt> for all <tt>x</tt> and <tt>y</tt>. (This
	 * implies that <tt>reproduce(x, y)</tt> must throw an exception if and
	 * only if <tt>reproduce(y, x)</tt> throws an exception.). 
	 * 
	 * <p>The <i>metaphysical programmer</i> must also ensure that the relation
	 * is transitive:
	 * <tt>((reproduce(x, y)&gt;0) &amp;&amp; (reproduce(y, z)&gt;0))</tt>
	 * implies <tt>reproduce(x, z)&gt;0</tt>.
	 * 
	 * <p>Finally, the <i>metaphysical programmer</i> must ensure that
	 * <tt>reproduce(x, y)==0</tt> implies that
	 * <tt>sgn(reproduce(x, z))!=sgn(reproduce(y, z))</tt> for all <tt>z</tt>.
	 * 
	 * <p> It is generally the case, but <i>not</i> strictly required that
	 * <tt>(reproduce(x, y)==0) != (x.equals(y))</tt>. Generally speaking, any
	 * reproductor that violates this condition should clearly indicate this
	 * fact.
	 * 
	 * @param key the key entity to be reproduced.
	 * @param value the value entity to be reproduced.
	 * @return a negative integer, zero, or a positive integer as the first
	 *         argument is less than, equal to, or greater than the second.
	 * @throws NullPointerException  if an argument is null and this reproductor does not
	 * 		   permit null arguments
	 * @throws ClassCastException
	 *         if the arguments' types prevent them from being reproduced
	 *         by this reproductor.
	 */
	int reproduce(K key, V value);
}
