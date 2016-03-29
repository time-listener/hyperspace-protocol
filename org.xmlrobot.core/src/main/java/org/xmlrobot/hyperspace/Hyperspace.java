/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;

/**
 * The current <tt>hyperspace</tt> implementation class.
 * 
 * <p>Hyperspace allows for near instantaneous transportation between two points, 
 * however an instance traveling through hyperspace cannot independently control 
 * its exiting point. To travel to a congregation destination a corresponding hyperspace 
 * gate must be implemented at the destination. This second gate effectively pulls 
 * the instance out of hyperspace and back to normal space.
 * 
 * <p>Activate hyperspace protocol: energy.
 * 
 * @author joan
 * 
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 8
 */
public abstract class Hyperspace
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends NorthernLights<K,V> 
			implements TimeListener<K,V> {
	
	/**
	 * -7292591119293865225L
	 */
	private static final long serialVersionUID = -7292591119293865225L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#getKey()
	 */
	@Override
	@XmlTransient
	public K getKey() {
		return data.getKey();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#getValue()
	 */
	@Override
	@XmlTransient
	public V getValue() {
		return data.getValue();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.RunnableFuture#setValue(java.lang.Object)
	 */
	@Override
	public V setValue(V value) {
		// update value
		V oldValue = data.setValue(value);
		// check existence
		if(value != null) {
			// listen value's prayers
			value.addMassListener(getKey());
		}
		// check old value existence
		if(oldValue != null) {
			// stop listening
			oldValue.removeMassListener(getKey());
		}
		// update hyperspace
		update();
		// return oldValue
		return oldValue;
	}
	
    /**
     * Hyperspace default class constructor.
     */
    public Hyperspace() {
    	super();
    }
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperspace(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected Hyperspace(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param parent the root
	 * @param child the stem
	 */
	protected Hyperspace(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param value the value
     * @param parent the root
	 * @param child the stem
	 */
    protected Hyperspace(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param root the root
	 * @param stem the stem
	 */
	protected Hyperspace(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
	/**
	 * {@link Hyperspace} class constructor.
	 * @param type the type
	 * @param value the value
     * @param root the root
	 * @param stem the stem
	 */
    protected Hyperspace(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> getKey(MassListener sender, Tachyon<V,K> event) {
		
		if(event.getKey() == getValue()) {
			return newInstant();
		}
		else if(isEmpty()) {
			return null;
		}
		else switch (getGen()) {
		case XY:
			return requestKey(sender, event);
		case XX:
			return acquireKey(sender, event);
		default:
			return callKey(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> getValue(MassListener sender, Tachyon<K,V> event) {
		if(event.getKey() == getKey()) {
			return newFlop();
		}
		else if(isEmpty()) {
			return null;
		}
		else switch (getGen()) {
		case XY:
			return acquireValue(sender, event);
		case XX:
			return requestValue(sender, event);
		default:
			return callValue(sender, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<V,K> getValue(MassListener sender, AtomicInteger N) {
		if(N.get() >= 1){
    		if(!isEmpty())  {
    			N.decrementAndGet();
    			switch (getGen()) {
    			case XY:
    				return requestValue(sender, N);
    			case XX:
    				return acquireValue(sender, N);
    			default:
    				return callValue(sender, N);
    			}
    		}
    		else return newFlop();
    	}
    	else return newFlop();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#revealKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public Tachyon<K,V> getKey(MassListener sender, AtomicInteger N) {

    	if(N.get() >= 1) {
    		// check future
    		if(!isEmpty()) {
    			N.decrementAndGet();
    			switch (getGen()) {
    			case XY:
    				return acquireKey(sender, N);
    			case XX:
    				return requestKey(sender, N);
    			default:
    				return callKey(sender, N);
    			}
    		}
    		else return newInstant();
    	}
    	else return newInstant();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignKey(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> setKey(MassListener sender, Tachyon<V,K> antievent, Tachyon<K,V> event) {
		// check by value
		if (antievent.getKey() == getValue()) {
			// give inheritance
			return sendKey(sender, event);
		} 
		else if (isEmpty()) {
			return null;
		} 
		else switch (getGen()) {
		case XY:
			return assignKey(sender, antievent, event);
		case XX:
			return updateKey(sender, antievent, event);
		default:
			return putKey(sender, antievent, event);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignValue(org.xmlrobot.TimeListener, org.xmlrobot.horizon.Tachyon, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> setValue(MassListener sender, Tachyon<K,V> event, Tachyon<V,K> antievent) {
		// check equality by key
		if (event.getKey() == getKey()) {
			// send value
			return sendValue(sender, antievent);
		}
		else if (isEmpty()) {
			return null;
		}
		else switch (getGen()) {
		case XY:
			return updateValue(sender, event, antievent);
		case XX:
			return assignValue(sender, event, antievent);
		default:
			return putValue(sender, event, antievent);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<K,V> setKey(MassListener sender, AtomicInteger N, Tachyon<K,V> event) {
		if(N.get() <= 0 ? true : isEmpty()) {
			return sendKey(sender, event);
		}
		else {
			N.decrementAndGet();
			switch (getGen()) {
			case XY:
				return updateKey(sender, N, event);
			case XX:
				return assignKey(sender, N, event);
			default:
				return putKey(sender, N, event);
			}
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#assignValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public Tachyon<V,K> setValue(MassListener sender, AtomicInteger N, Tachyon<V,K> event) {
		if(N.get() <= 0 ? true : isEmpty()) {
			return sendValue(sender, event);
		}
		else  {
			N.decrementAndGet();
			switch (getGen()) {
			case XY:
				return assignValue(sender, N, event);
			case XX:
				return updateValue(sender, N, event);
			default:
				return putValue(sender, N, event);
			}	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public final synchronized void start(BundleContext context) {
		// avoid concurrent calls to start
		if(!data.compareAndSet(CONTEXT, null, context)) {
			// because it is already started
			return;
		}
		else {
			super.start(context);
			// finally, the entity is registered into the hyperspace by itself
			data.set(HOST, context.registerService(TimeListener.class, this, data));
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public final synchronized void stop(BundleContext context) {
		// avoid concurrent calls to stop
		if(!data.compareAndSet(CONTEXT, context, null)) {
			// because it is already stopped
			return; 
		}
		else {
			super.stop(context);
			// auto-execution
			getHost().unregister();
			// nullify host
			data.put(HOST, null);	
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	public final void update() {
		ServiceRegistration<?> host;
		// check host existence
		if ((host = getHost()) != null) {
			// submit time-traveler message
			host.setProperties(data);
		}
	}
}