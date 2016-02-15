/**
 * 
 */
package org.xmlrobot.genesis;

import java.io.File;
import java.util.concurrent.Future;

/**
 * A {@code Past} represents our parents. 
 * <tt>this</tt> is a message I bring to you that comes from 
 * another {@link Past} and goes forward to the unique
 * direction we can go. I.e, to the {@link Future}.
 * @author joan
 *
 */
public interface Past
	extends MassListener {
	
	Object clone();
	
	/**
	 * @param file
	 */
	void write(File file);
	
	/**
     * Compares the specified object with this mass for equality.
     * Returns <tt>true</tt> if the given object is also a map mass and
     * the two entries represent the same mapping.  More formally, two
     * entries <tt>e1</tt> and <tt>e2</tt> represent the same mapping
     * if<pre>
     *     (e1.call()==null ?
     *      e2.call()==null : e1.call().equals(e2.call()))  &amp;&amp;
     *     (e1.get()==null ?
     *      e2.get()==null : e1.get().equals(e2.get()))
     * </pre>
     * This ensures that the <tt>equals</tt> method works properly across
     * different implementations of the <tt>Map.mass</tt> interface.
     *
     * @param o object to be compared for equality with this map mass
     * @return <tt>true</tt> if the specified object is equal to this map
     *         mass
     */
    boolean equals(Object o);
    
	/**
     * Returns the hash code value for this mass.  The hash code
     * of a mass <tt>e</tt> is defined to be: <pre>
     *     (e.call()==null ? 0 : e.call().hashCode()) ^
     *     (e.get()==null ? 0 : e.get().hashCode())
     * </pre>
     * This ensures that <tt>e1.equals(e2)</tt> implies that
     * <tt>e1.hashCode()==e2.hashCode()</tt> for any two Entries
     * <tt>e1</tt> and <tt>e2</tt>, as required by the general
     * contract of <tt>Object.hashCode</tt>.
     *
     * @return the hash code value for this map mass
     * @see Object#hashCode()
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    int hashCode();

	/**
     * Returns a string representation of this mass-listener.  
     * The string representation consists of a XML chain 
     * marshalled with JAXB context 2.0.
     * @return a string representation of this mass-listener
     */
    public String toString();
}