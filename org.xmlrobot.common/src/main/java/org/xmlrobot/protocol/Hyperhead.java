/**
 * 
 */
package org.xmlrobot.protocol;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Entity's brain. 
 * It is the obsolete dictionary of always that is always changing.
 * 
 * @author joan
 *
 */
@XmlRootElement
public class Hyperhead
	extends Dictionary<String,Object> 
		implements MassListener {

	/**
	 * 4033084758368854561L
	 */
	private static final long serialVersionUID = 4033084758368854561L;
	
	/**
	 * The backing data
	 */
	Dictionary<String,Object> map;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#family()
	 */
	@Override
	@XmlTransient
	public ThreadGroup getFamily() {
		return getAndCast(FAMILY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#host()
	 */
	@Override
	@XmlTransient
	public ServiceRegistration<?> getHost() {
		return getAndCast(HOST);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {
		return null;
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
		put(PARITY, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#dna()
	 */
	@Override
	public MassListener dna() {
		return getAndCast(DNA);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#runner()
	 */
	@Override
	@XmlTransient
	public Thread getRunner() {
		return getAndCast(RUNNER);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getCommand()
	 */
	@Override
	@XmlElement
	public Command getCommand() {
		return getAndCast(COMMAND);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getContext()
	 */
	@Override
	@XmlTransient
	public BundleContext getContext() {
		return getAndCast(CONTEXT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setCommand(org.xmlrobot.util.Command)
	 */
	@Override
	public void push(Command value) {
		put(COMMAND, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) {
		put(CONTEXT, context);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
		put(CONTEXT, null);
	}
	
	/**
	 * {@link Hyperhead} default class constructor.
	 */
	public Hyperhead() {
		// create time-traveler message properties
		map = new Hashtable<String,Object>();
		// inherit dna
		put(TimeListener.DNA, this);
	}
	/**
	 * @param head
	 */
	public Hyperhead(MassListener head) {
		if(head == null ? true : !(head instanceof Hyperhead))
			throw new Abort();
		this.map = (Hyperhead) head;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {

		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#elements()
	 */
	@Override
	public Enumeration<Object> elements() {
		return map.elements();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#get(java.lang.Object)
	 */
	@Override
	public Object get(Object key) {
		return map.get(key);
	}
	/**
	 * Returns the hyperdictionary reference with the specified key. 
	 * @param key the input key
	 * @return the hyperdictionary reference with the specified key
	 */
	@SuppressWarnings("unchecked")
	public <X> X getAndCast(String key) {
		try {
			return (X) get(key);
		}
		catch(ClassCastException | NullPointerException unused) {
			return null;	
		}
	}
	
	@SuppressWarnings("unchecked")
	public <X> X putAndCast(String key, X value) {
		Object o;
		return (o = put(key, value)) != null ? (X) o : null;
	}
	/**
	 * @param key
	 * @param oldValue
	 * @param newValue
	 * @return
	 */
	public <X> boolean compareAndSet(String key, X oldValue, X newValue) {
		
		if(get(key) == oldValue) {
			put(key, newValue);
			return true;
		}
		else return false;
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object put(String key, Object value) {
		if(value != null)
			return map.put(key, value);
		else return map.remove(key);
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#size()
	 */
	@Override
	public int size() {
		return map.size();
	}
	/* (non-Javadoc)
	 * @see java.util.Dictionary#keys()
	 */
	@Override
	public Enumeration<String> keys() {
		return map.keys();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable command) {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		return;
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.Mass, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		return;
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
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// inherit family
		put(FAMILY, Thread.currentThread().getThreadGroup());
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#shutdown()
	 */
	@Override
	public void shutdown() {
		return;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#isShutdown()
	 */
	@Override
	public boolean isShutdown() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return false;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#execute(java.lang.Runnable, java.lang.Object)
	 */
	@Override
	public <T> Future<T> execute(Runnable task, T result) {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
			throws InterruptedException {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(
			Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAny(java.util.Collection)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAny(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
			long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		return null;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public <X extends TimeListener<X,Y>, Y extends TimeListener<Y,X>>
		void pulse(TimeListener<?,?> sender, Tachyon<Y,X> event) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> void echo(
			TimeListener<?,?> sender, Tachyon<X,Y> event) {
	}
}
