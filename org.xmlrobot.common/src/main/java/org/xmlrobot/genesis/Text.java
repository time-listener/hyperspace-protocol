/**
 * 
 */
package org.xmlrobot.genesis;

/**
 * @author joan
 *
 */
public interface Text 
	extends CharSequence {
	
	/**
	 * Concatenates recursively <tt>this</tt> text value to 
	 * the specified output {@link StringBuilder}.
	 * @param o {@link StringBuilder} the output 
	 * @return the {@link StringBuilder} output
	 */
	StringBuilder concat(StringBuilder o);
	
	/**
	 * Concatenates recursively <tt>this</tt> text value to 
	 * the specified output {@link String}.
	 * @param str {@link String} the string to concatenate current text value
	 * @return the output
	 */
	String concat(String str);
	
	/**
     * Returns a string that is a substring of this string. The
     * substring begins at the specified {@code beginIndex} and
     * extends to the character at index {@code endIndex - 1}.
     * Thus the length of the substring is {@code endIndex-beginIndex}.
     * <p>
     * Examples:
     * <blockquote><pre>
     * "hamburger".substring(4, 8) returns "urge"
     * "smiles".substring(1, 5) returns "mile"
     * </pre></blockquote>
     *
     * @param      beginIndex   the beginning index, inclusive.
     * @param      endIndex     the ending index, exclusive.
     * @return     the specified substring.
     * @exception  IndexOutOfBoundsException  if the
     *             {@code beginIndex} is negative, or
     *             {@code endIndex} is larger than the length of
     *             this {@code String} object, or
     *             {@code beginIndex} is larger than
     *             {@code endIndex}.
     */
	String substring(int beginIndex, int endIndex);
	
	/**
     * Returns a string builder that is synchronizing this string. The
     * substring begins at the specified {@code beginIndex} and
     * extends to the character at index {@code endIndex - 1}.
     * Thus the length of the substring is {@code endIndex-beginIndex}.
     * <p>
     * Examples:
     * <blockquote><pre>
     * "hamburger".substring(4, 8) returns "urge"
     * "smiles".substring(1, 5) returns "mile"
     * </pre></blockquote>
     *
     * @param	   builder the current builder  
     * @param      beginIndex   the beginning index, inclusive.
     * @param      endIndex     the ending index, exclusive.
     * @return     the specified substring.
     * @exception  IndexOutOfBoundsException  if the
     *             {@code beginIndex} is negative, or
     *             {@code endIndex} is larger than the length of
     *             this {@code String} object, or
     *             {@code beginIndex} is larger than
     *             {@code endIndex}.
     */
	StringBuilder substring(StringBuilder builder, int beginIndex, int endIndex);

	/* (non-Javadoc)
	 * @see java.lang.CharSequence#toString()
	 */
	@Override
	String toString();
}
