/**
 * 
 */
package org.xmlrobot.util;

import java.util.Collection;
import java.util.Iterator;

import org.xmlrobot.horizon.Mass;

/**
 * @author joan
 *
 */
public abstract class Congregation<T> 
	extends Mass<Collection<T>> 
		implements Collection<T> {

	/**
	 * 5028963007532640579L
	 */
	private static final long serialVersionUID = 5028963007532640579L;
	
	/**
	 * @param source
	 */
	public Congregation(Collection<T> source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@Override
	public Collection<T> getSource() {
		return (Collection<T>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#size()
	 */
	@Override
	public int size() {
		return getSource().size();
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return getSource().isEmpty();
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(Object o) {
		return getSource().contains(o);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return getSource().iterator();
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#toArray()
	 */
	@Override
	public Object[] toArray() {
		return getSource().toArray();
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#toArray(java.lang.Object[])
	 */
	@Override
	public <X> X[] toArray(X[] a) {
		return getSource().toArray(a);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	@Override
	public boolean add(T e) {
		return getSource().add(e);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		return getSource().remove(o);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		return getSource().containsAll(c);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	@Override
	public boolean addAll(Collection<? extends T> c) {
		return getSource().addAll(c);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		return getSource().removeAll(c);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		return getSource().retainAll(c);
	}
	/* (non-Javadoc)
	 * @see java.util.Collection#clear()
	 */
	@Override
	public void clear() {
		getSource().clear();
	}
}
