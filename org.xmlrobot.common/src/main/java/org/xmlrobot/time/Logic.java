/**
 * 
 */
package org.xmlrobot.time;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.hyperspace.Hyperspace;
import org.xmlrobot.space.Hyperclock;
import org.xmlrobot.util.Parity;

/**
 * Peace (XX), love (YY) and marijuana (XY) implementation class.
 * 
 * <p> Logic is the study of the principles of reasoning. 
 * As a form of science, logic is used to solve various problems 
 * through the implementation of abstract reasoning.
 * 
 * <p>Live long and prosper.
 *
 * @author joan YY
 *
 * @see Hyperclock
 * 
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 9
 */
@XmlTransient
public abstract class Logic
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Hyperspace<K,V> {
	
	/**
	 * -3935017533435449883L
	 */
	private static final long serialVersionUID = -3935017533435449883L;
	
    /**
     * {@link Logic} default class constructor.
     */
    public Logic() {
    	super();
    }
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Logic(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    protected Logic(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Logic} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Logic(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#swap(org.xmlrobot.genesis.TimeListener)
	 */
	public synchronized void swap(K listener) {
		// get parent and child
		K parent = getParent();
		K child = getChild();
		// check current inheritance
		if(child != null) {
			
			if(child != listener) {
				// set child as listener's child
				listener.setChild(child);
				// set child's parent as listener
				child.setParent(listener);

				if(parent != null) {
					
					if(parent != listener) {
						// set parent as listener's parent
						listener.setParent(parent);
						// set parent's child as listener
						parent.setChild(listener);	
					}
				}
				else {
					// nullify parent inheritance
					listener.setParent(null);
				}
			}
			else {
				// I am listener's child
				listener.setChild(call());
				// it is my parent
				setParent(listener);
				// check old parent existence
				if(parent != null) {
					// check if it is a parent's paranoia
					if(parent != listener) {
						// set parent as listener's parent
						listener.setParent(parent);
						// set parent's child as listener
						parent.setChild(listener);	
					}
				}
				else {
					// nullify parent inheritance
					listener.setParent(null);
				}
			}
		}
		else if(parent != null) {
			// nullify child inheritance
			listener.setChild(null);
			// set parent as listener's parent
			listener.setParent(parent);
			// set parent's child as listener
			parent.setChild(listener);
		}
		else {
			// nullify inheritance
			listener.setChild(null);
			listener.setParent(null);
		}
	}
	/* (non-Javadoc)
	 * @see java.util.Enumeration#hasMoreElements()
	 */
	@Override
	public boolean hasMoreElements() {
	
		return getChild() == null;
	}
	/* (non-Javadoc)
	 * @see java.util.Enumeration#nextElement()
	 */
	@Override
	public K nextElement() {

		return getChild();
	}
	/* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#contains(java.lang.Object)
     */
    public synchronized boolean contains(K o) {

    	K child;
    	
    	if(o == this) {
    		return true;
    	}
    	else if((child = getChild()) != null) {
    		return child.contains(o);
    	}
    	else {
    		return false;
    	}
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#isEmpty(java.lang.Object)
     */
    public boolean isEmpty() {
    	
    	return getChild() == null;
    }
	/**
     * Compares the specified object with this entry for equality.
     * Returns {@code true} if the given object is also a map entry and
     * the two entries represent the same mapping.  More formally, two
     * entries {@code e1} and {@code e2} represent the same mapping
     * if<pre>
     *   (e1.getKey()==null ?
     *    e2.getKey()==null :
     *    e1.getKey().equals(e2.getKey()))
     *   &amp;&amp;
     *   (e1.getValue()==null ?
     *    e2.getValue()==null :
     *    e1.getValue().equals(e2.getValue()))</pre>
     * This ensures that the {@code equals} method works properly across
     * different implementations of the {@code Map.Entry} interface.
     *
     * @param o object to be compared for equality with this map entry
     * @return {@code true} if the specified object is equal to this map
     *         entry
     * @see    #hashCode
     */
    public boolean equals(Object o) {
        if (!(o instanceof Congregation))
            return false;
        Congregation<?> i = (Congregation<?>)o;
        return equality(this, i);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return super.hashCode();
    }
    /**
     * Utility method for {@link TimeListener}.
     * Test for equality, checking for nulls.
     */
    public static boolean equality(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1 == o2;
    }
}