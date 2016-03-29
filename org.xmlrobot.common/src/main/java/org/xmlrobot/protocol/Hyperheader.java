/**
 * 
 */
package org.xmlrobot.protocol;

import java.io.File;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public class Hyperheader 
	extends Dictionary<String,AtomicReference<?>> 
		implements MassListener {

	/**
	 * -808100937927062520L
	 */
	private static final long serialVersionUID = -808100937927062520L;
	
	Dictionary<String,AtomicReference<?>> map;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getCommand()
	 */
	@Override
	public Command getCommand() {
		return getAndCast(COMMAND);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#push(org.xmlrobot.util.Command)
	 */
	@Override
	public void setCommand(Command value) {
		set(COMMAND, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getContext()
	 */
	@Override
	public BundleContext getContext() {
		return getAndCast(CONTEXT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getFamily()
	 */
	@Override
	public ThreadGroup getFamily() {
		return getAndCast(FAMILY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getHost()
	 */
	@Override
	public ServiceRegistration<?> getHost() {
		return getAndCast(HOST);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getName()
	 */
	@Override
	public String getName() {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getRunner()
	 */
	@Override
	public Thread getRunner() {
		return getAndCast(FAMILY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getGen()
	 */
	@Override
	public Parity getGen() {
		return getAndCast(PARITY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#setGen(org.xmlrobot.util.Parity)
	 */
	@Override
	public void setGen(Parity value) {
		set(PARITY, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#dna()
	 */
	@Override
	public Hyperheader dna() {
		return this;
	}
	
	/**
	 * 
	 */
	public Hyperheader() {
		// create time-traveler message properties
		map = new Hashtable<String,AtomicReference<?>>();
		// initialize header
		initializeHeader(Parity.YY);
	}
	/**
	 * 
	 */
	public Hyperheader(Parity gen) {
		// create time-traveler message properties
		map = new Hashtable<String,AtomicReference<?>>();
		// initialize header
		initializeHeader(gen);
	}
	/**
	 * @param head
	 */
	protected Hyperheader(Hyperheader map) {
		if(map == null)
			throw new Abort();
		this.map = map;
	}
	/**
	 * @param gen
	 */
	private void initializeHeader(Parity gen) {
		// inherit gender
		declareAndSet(PARITY, gen);	
		// inherit default startup command
		declareAndSet(COMMAND, Command.GENESIS);
		// declare dna
		declareAndSet(DNA, this);
		// declare runner
		this.<Thread>declare(RUNNER);
		// declare family
		this.<ThreadGroup>declare(FAMILY);
		// declare hyperspace
		this.<BundleContext>declare(CONTEXT);
		// declare hyperspace host
		this.<ServiceRegistration<?>>declare(HOST);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#size()
	 */
	@Override
	public int size() {
		return map.size();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#keys()
	 */
	@Override
	public Enumeration<String> keys() {
		return map.keys();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#elements()
	 */
	@Override
	public Enumeration<AtomicReference<?>> elements() {
		return map.elements();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#get(java.lang.Object)
	 */
	@Override
	public AtomicReference<?> get(Object key) {
		return map.get(key);
	}
	/**
	 * Gets the reference for current access key.
	 * @param key the access key
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public <X> AtomicReference<X> getReference(String key) {
		return (AtomicReference<X>) map.get(key);
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public AtomicReference<?> put(String key, AtomicReference<?> value) {
		if(value != null)
			return map.put(key, value);
		else return map.remove(key);
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#remove(java.lang.Object)
	 */
	@Override
	public AtomicReference<?> remove(Object key) {	
		return map.remove(key);
	}
	/**
	 * Returns the hyperdictionary reference with the specified key. 
	 * @param key the input key
	 * @return the hyperdictionary reference with the specified key
	 */
	public <X> X getAndCast(String key) {
		return this.<X>getReference(key).get();
	}
	/**
	 * Puts the hyperdictionary reference with the specified key. 
	 * @param key
	 * @param value
	 * @return
	 */
	public <X> X getAndSet(String key, X value) {
		return this.<X>getReference(key).getAndSet(value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public <X> void set(String key, X value) {
		getReference(key).set(value);
	}
	/**
	 * @param key
	 * @param oldValue
	 * @param newValue
	 * @return
	 */
	public <X> boolean compareAndSet(String key, X oldValue, X newValue) {	
		return getReference(key).compareAndSet(oldValue, newValue);
	}
	/**
	 * @param key
	 */
	<X> AtomicReference<?> declare(String key){
		// put new reference to dictionary
		return put(key, new AtomicReference<X>());
	}
	/**
	 * @param key
	 * @param value
	 */
	<X> AtomicReference<?> declareAndSet(String key, X value){
		return put(key, new AtomicReference<X>(value));
	}
	
	// congregation implementation
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) {
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable command) {
		return;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// inherit family now
		declareAndSet(FAMILY, Thread.currentThread().getThreadGroup());
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void mass(MassListener sender, Tachyon<X,Y> event) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#toArray()
	 */
	@Override
	public Object[] toArray() {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	@Override
	public void update() {
		return;
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#clear()
	 */
	@Override
	public void clear(MassListener sender) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#depth()
	 */
	@Override
	public AtomicInteger depth(MassListener sender) {
		return new AtomicInteger(0);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#write(java.io.File)
	 */
	@Override
	public void write(File file) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void addMassListener(MassListener listener) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#unify()
	 */
	@Override
	public void unify(MassListener sender) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#removeMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void removeMassListener(MassListener listener) {
		
	}
}