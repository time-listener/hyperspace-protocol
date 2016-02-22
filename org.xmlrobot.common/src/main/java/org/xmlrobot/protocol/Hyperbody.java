/**
 * 
 */
package org.xmlrobot.protocol;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Phaser;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * Massive message body implementation class.
 * 
 * @author joan
 * @parity YY
 */
@XmlRootElement
public class Hyperbody
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Hyperhead implements TimeListener<K,V> {
	
	/**
	 * -7589606931673287328L
	 */
	private static final long serialVersionUID = -7589606931673287328L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#get()
	 */
	@Override
	public V get() {
		return getAndGet(VALUE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#set(java.lang.Object)
	 */
	@Override
	public void set(V value) {
		set(VALUE, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#call()
	 */
	@Override
	public K call() {
		return getAndGet(KEY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#dna()
	 */
	@Override
	public TimeListener<K,V> dna() {
		return getAndGet(DNA);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getGen()
	 */
	@Override
	@XmlElement
	public Parity getGen() {
		return getAndGet(PARITY);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setGen(org.xmlrobot.util.Parity)
	 */
	@Override
	public void setGen(Parity gene) {
		set(PARITY, gene);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getType()
	 */
	@Override
	@XmlElement
	public Class<K> getType() {
		return getAndGet(TYPE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> type) {
		set(TYPE, type);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#getAntitype()
	 */
	@Override
	@XmlElement
	public Class<? extends V> getAntitype() {
		return getAndGet(ANTITYPE);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Mass#setAntitype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> value) {
		set(ANTITYPE, value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getChild()
	 */
	@Override
	@XmlTransient
	public K getChild() {
		return getAndGet(CHILD);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#setChild(java.lang.Object)
	 */
	@Override
	public void setChild(K listener) {
		set(CHILD, listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getParent()
	 */
	@Override
	@XmlTransient
	public K getParent() {
		return getAndGet(PARENT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#setParent(java.lang.Object)
	 */
	@Override
	public void setParent(K listener) {
		set(PARENT, listener);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getRoot()
	 */
	@Override
	public K getRoot() {
		return getAndGet(ROOT);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setRoot(java.lang.Object)
	 */
	@Override
	public void setRoot(K root) {
		set(ROOT, root);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getStem()
	 */
	@Override
	public V getStem() {
		return getAndGet(STEM);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setStem(java.lang.Object)
	 */
	@Override
	public void setStem(V stem) {
		set(STEM, stem);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.protocol.Hyperhead#getName()
	 */
	@Override
	@XmlElement
	public String getName() {
		
		return call().getName();
	}
	
	/**
	 * {@link Hyperbody} default class constructor.
	 */
	public Hyperbody() {
		this(Parity.YY);
	}
	/**
	 * {@link Hyperbody} class constructor.
	 */
	public Hyperbody(Parity parity) {
		this(new Hyperhead());
		// start dna initialization
		initializeDna((Hyperhead) map);
		// inherit parity
		set(PARITY, parity);
	}
	/**
	 * {@link Hyperbody} class constructor.
	 */
	public Hyperbody(Class<? extends K> type, K key, Parity parity) {
		this(parity);
		// inherit key
		set(KEY, key);
		// inherit type
		set(TYPE, type);
	}
	/**
	 * {@link Hyperbody} class constructor.
	 */
	public Hyperbody(Class<? extends K> type, K key, V value, Parity parity) {
		this(type, key, parity);
		// inherit value
		set(VALUE, value);
		// inherit antitype
		set(ANTITYPE, value.getType());
	}
	/**
	 * @param map
	 * @throws Abort
	 */
	public Hyperbody(MassListener map) {
		super(map);
	}
	
	/**
	 * @param parity
	 */
	private void initializeDna(Hyperhead map) {
		// inherit default startup command
		map.set(COMMAND, Command.GENESIS);
		// update dna reference
		map.set(DNA, this);
		// declare child
		map.<K>declare(CHILD);
		// declare parent
		map.<K>declare(PARENT);
		// declare root
		map.<K>declare(ROOT);
		// declare root
		map.<V>declare(STEM);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Hyperbody<K,V> clone() {

		@SuppressWarnings("unchecked")
		Hyperbody<K,V> dna = (Hyperbody<K,V>) super.clone();
		return dna;
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void pulse(TimeListener<?,?> sender, Tachyon<Y,X> event) {
		
		call().pulse(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> void echo(
			TimeListener<?,?> sender, Tachyon<X,Y> event) {
		
		call().echo(sender, event);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable entity) {

		call().execute(entity);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable entity) {

		return call().newThread(entity);
	}

	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		
		call().serviceChanged(event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Tachyon<?,?> event) {
		
		call().mass(sender, event);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#shutdown()
	 */
	@Override
	public void shutdown() {
	
		call().shutdown();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#submit(java.lang.Runnable, java.lang.Object)
	 */
	@Override
	public <T> Phaser<T> execute(Runnable task, T result) {

		return call().execute(task, result);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		
		return call().isCancelled();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isDone()
	 */
	@Override
	public boolean isDone() {
		
		return call().isDone();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isShutdown()
	 */
	@Override
	public boolean isShutdown() {

		return call().isShutdown();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isTerminated()
	 */
	@Override
	public boolean isTerminated() {

		return call().isTerminated();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAll(java.util.Collection)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
			throws InterruptedException {

		return call().invokeAll(tasks);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(
			Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {

		return call().invokeAll(tasks, timeout, unit);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAny(java.util.Collection)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {

		return call().invokeAny(tasks);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAny(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
			long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {

		return call().invokeAny(tasks, timeout, unit);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#cancel(boolean)
	 */
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {

		return call().cancel(mayInterruptIfRunning);
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(V o) {
	
		return call().compareTo(o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#call(int)
	 */
	@Override
	public K call(int N) {

		return call().call(N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#polarize(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void polarize(K parent, K child) {
		
		call().polarize(parent, child);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#remove()
	 */
	@Override
	public void remove() {
		
		call().remove();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getFuture()
	 */
	@Override
	public K getFuture() {

		return call().getFuture();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getPast()
	 */
	@Override
	public K getPast() {

		return call().getPast();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderAt(java.lang.Object, int)
	 */
	@Override
	public void orderAt(K listener, int index) {
		
		call().orderAt(listener, index);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submitChild(java.lang.Object)
	 */
	@Override
	public K submitChild(K listener) {
		
		return call().submitChild(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderInfer(java.lang.Object)
	 */
	@Override
	public K orderInfer(K listener) {
		
		return call().orderInfer(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submitParent(java.lang.Object)
	 */
	@Override
	public K submitParent(K listener) {
		
		return call().submitParent(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderSuper(java.lang.Object)
	 */
	@Override
	public K orderSuper(K listener) {

		return call().orderSuper(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#permute(int)
	 */
	@Override
	public K permute(int N) {

		return call().permute(N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#releaseChild()
	 */
	@Override
	public K releaseChild() {

		return call().releaseChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#releaseParent()
	 */
	@Override
	public K releaseParent() {
		
		return call().releaseParent();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#revolve()
	 */
	@Override
	public K revolve() {

		return call().revolve();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#rotate()
	 */
	@Override
	public K rotate() {

		return call().rotate();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#swap(java.lang.Object)
	 */
	@Override
	public void swap(K listener) {
		
		call().swap(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#add(java.lang.Object)
	 */
	@Override
	public boolean add(K e) {

		return call().add(e);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#delve(int)
	 */
	@Override
	public int delve(int counter) {

		return call().delve(counter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#depth()
	 */
	@Override
	public int depth() {

		return call().depth();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(K entity) {

		return call().contains(entity);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#toArray()
	 */
	@Override
	public Object[] toArray() {

		return call().toArray();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#toArray(java.lang.Object[])
	 */
	@Override
	public <X> X[] toArray(X[] a) {

		return call().toArray(a);
	}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(K o1, K o2) {
		
		return call().compare(o1, o2);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#collect(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<K> collect(Congregation<K> entities) {
		
		return call().collect(entities);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#clear()
	 */
	@Override
	public void clear() {
		
		call().clear();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#get(long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public V get(long timeout, TimeUnit unit) {

		return call().get(timeout, unit);
	}
	/* (non-Javadoc)
	 * @see java.util.Enumeration#hasMoreElements()
	 */
	@Override
	public boolean hasMoreElements() {
		return call().hasMoreElements();
	}
	/* (non-Javadoc)
	 * @see java.util.Enumeration#nextElement()
	 */
	@Override
	public K nextElement() {
		return call().nextElement();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#iterator()
	 */
	@Override
	public Iterator<K> iterator() {
		return call().iterator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#containsAll(java.lang.Object)
	 */
	@Override
	public boolean containsAll(K c) {
		return call().containsAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#addAll(java.lang.Object)
	 */
	@Override
	public boolean addAll(K c) {
		return call().addAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#removeAll(java.lang.Object)
	 */
	@Override
	public boolean removeAll(K c) {
		return call().removeAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#retainAll(java.lang.Object)
	 */
	@Override
	public boolean retainAll(K c) {
		return call().retainAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#polarize()
	 */
	@Override
	public void polarize() {
		call().polarize();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#order(java.lang.Object)
	 */
	@Override
	public boolean order(K listener) {
		return call().order(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#release()
	 */
	@Override
	public K release() {
		return call().release();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#spin()
	 */
	@Override
	public void spin() {
		call().spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submit(java.lang.Object)
	 */
	@Override
	public boolean submit(K entity) {
		
		return call().submit(entity);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#removeIf(java.util.function.Predicate)
	 */
	@Override
	public boolean removeIf(Predicate<? super K> filter) {

		return call().removeIf(filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#matrix()
	 */
	@Override
	public TimeListener.Transmitter<K,V> matrix() {

		return call().matrix();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	@Override
	public int reproduceTo(V o) {
		
		return call().reproduceTo(o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submitAll(java.lang.Object)
	 */
	@Override
	public boolean submitAll(K c) {
		
		return call().submitAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.Mass)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		
		call().addMassListener(listener);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#output()
	 */
	@Override
	public V output() {
		
		return call().output();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	@Override
	public void update() {
		
		K key;
		if((key = call()) != null)
			key.update();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#write(java.io.File)
	 */
	@Override
	public void write(File file) {
		call().write(file);
	}
}
