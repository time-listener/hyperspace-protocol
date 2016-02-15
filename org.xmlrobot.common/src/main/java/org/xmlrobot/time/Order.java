/**
 * 
 */
package org.xmlrobot.time;

import java.util.Arrays;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * We are the Borg. Lower your shields and surrender your ships. 
 * Your biological and technological distinctiveness will be added to our own. 
 * Resistance is futile. Your culture will adapt to service us. You will be assimilated. 
 * 
 * <p> All borg-assimilated implementors can execute only the inherited methods 
 * imposed by this class.
 * 
 * @author joan
 * 
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 12
 */
@XmlTransient
public abstract class Order
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Democracy<K,V> {

	/**
	 * -459719313096512453L
	 */
	private static final long serialVersionUID = -459719313096512453L;

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    
    /**
     * {@link Order} default class constructor.
     */
    public Order() {
    	super();
    }
	/**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Order(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param value the value
     * @param gen {@link Parity} the gender
	 */
    protected Order(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Order} class constructor.
	 * @param type the type
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Order(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderSuper(java.lang.Object)
	 */
	public synchronized K orderSuper(K listener) {
		// compare ourself self with new listener
		int cmp1 = compare(getType().cast(this), listener);
		// if listener is higher or equal than current instance, 
		// set child as new parent.
		if(cmp1 >= 0) {
			// order as parent
			return submitParent(listener);
		}
		// listener is lower than current instance
		else {
			// declare the child of inheritance
			K child;
			// assign and check existence
			if((child = getChild()) != null) {
				// let's compare with child
				int cmp2 = compare(child, listener);
				// do comparison
				if(cmp2 >= 0) {
					//Set listener as parent's child, a.k.a orderChild().
					return child.submitParent(listener);
				}
				else {
					// call recursion
					return child.orderSuper(listener);
				}
			}
			else {
				// order listener as child
				return submitChild(listener);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderInfer(java.lang.Object)
	 */
	public synchronized K orderInfer(K listener) {
		// compare ourself self with new listener
		int cmp1 = compare(call(), listener);
		// if listener is lower or equal than current instance, 
		// set child as new parent.
		if(cmp1 <= 0) {
			// submit as parent
			return submitParent(listener);
		}
		// listener is lower than current instance
		else {
			// declare the child of inheritance
			K child;
			// assign and check existence
			if((child = getChild()) != null) {
				// compare immediate child with listener
				int cmp2 = compare(child, listener);
				// do comparison
				if(cmp2 <= 0) {
					// set listener as new child, a.k.a child.orderParent().
					return child.submitParent(listener);
				}
				else {
					// call recursion
					return child.orderInfer(listener);
				}
			}
			else {
				// submit as immediate child
				return submitChild(listener);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderAt(java.lang.Object, int)
	 */
	public synchronized void orderAt(K listener, int N) {
		
		// declare child
		K child;
		// if N arrives to 0, it's the allocated child
		if(N == 0) {
			// assign and check child
			if((child = getChild()) != null) {
				//Set child as parent of grandson child and viceversa
				child.setParent(listener);
				listener.setChild(child);
			}
			// update child
			setChild(listener);
			listener.setParent(call());
		}
		else if((child = getChild()) != null) {
			// call recursion
			child.orderAt(listener, --N);
		}
		else {
			// although N is wrong, submit child 
			// on the bottom of inheritance,
			// because this is the future.
			setChild(listener);
		}
	}
	/**
     * {@inheritDoc}
     *
     * <p><tt>this</tt> implementation returns an array containing all the elements
     * returned by <tt>this</tt> collection's iterator in the same order, stored in
     * consecutive elements of the array, starting with index {@code 0}.
     * If the number of elements returned by the iterator is too large to
     * fit into the specified array, then the elements are returned in a
     * newly allocated array with length equal to the number of elements
     * returned by the iterator, even if the size of <tt>this</tt> collection
     * changes during iteration, as might happen if the collection permits
     * concurrent modification during iteration.  The {@code size} method is
     * called only as an optimization hint; the correct result is returned
     * even if the iterator returns a different number of elements.
     *
     * <p>This method is equivalent to:
     *
     *  <pre> {@code
     * List<E> list = new ArrayList<E>(size());
     * for (E e : this)
     *     list.add(e);
     * return list.toArray(a);
     * }</pre>
     *
     * @throws ArrayStoreException  {@inheritDoc}
     * @throws NullPointerException {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public synchronized <E> E[] toArray(E[] a) {
        // Estimate size of array; be prepared to see more or fewer elements
        int size = depth();
        E[] r = a.length >= size ? a :
                  (E[])java.lang.reflect.Array
                  .newInstance(a.getClass().getComponentType(), size);
        Iterator<K> it = iterator();

        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext()) { // fewer elements than expected
                if (a == r) {
                    r[i] = null; // null-terminate
                } else if (a.length < i) {
                    return Arrays.copyOf(r, i);
                } else {
                    System.arraycopy(r, 0, a, 0, i);
                    if (a.length > i) {
                        a[i] = null;
                    }
                }
                return a;
            }
            // one by one, like the Borg Imperium
            r[i] = (E)it.next();
        }
        // more elements than expected
        return it.hasNext() ? finishToArray(r, it) : r;
    }
    /* (non-Javadoc)
     * @see org.xmlrobot.genesis.TimeListener#toArray()
     */
    public synchronized Object[] toArray() {
        // Estimate size of array; be prepared to see more or fewer elements
        Object[] r = new Object[depth()];

		Iterator<K> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext()) // fewer elements than expected
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return it.hasNext() ? finishToArray(r, it) : r;
    }
    /**
     * Reallocates the array being used within toArray when the iterator
     * returned more elements than expected, and finishes filling it from
     * the iterator.
     *
     * @param r the array, replete with previously stored elements
     * @param it the in-progress iterator over this collection
     * @return array containing the elements in the given array, plus any
     *         further elements returned by the iterator, trimmed to size
     */
    @SuppressWarnings("unchecked")
    private static <T> T[] finishToArray(T[] r, Iterator<?> it) {
        int i = r.length;
        while (it.hasNext()) {
            int cap = r.length;
            if (i == cap) {
                int newCap = cap + (cap >> 1) + 1;
                // overflow-conscious code
                if (newCap - MAX_ARRAY_SIZE > 0)
                    newCap = hugeCapacity(cap + 1);
                r = Arrays.copyOf(r, newCap);
            }
            // one by one, like the Borg Imperium
            r[i++] = (T)it.next();
        }
        // trim if overallocated
        return (i == r.length) ? r : Arrays.copyOf(r, i);
    }
    /**
     * The huge capacity
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError
                ("Required array size too large");
        return (minCapacity > MAX_ARRAY_SIZE) ?
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    }
}
