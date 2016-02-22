/**
 * 
 */
package org.xmlrobot.horizon;

import java.io.File;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.Phaser;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Parity;

/**
 * Tachyon antimatter particle implementation class.
 * 
 * <p>A tachyon or tachyonic particle is a hypothetical particle that always moves faster than light. 
 * The word comes from the pronounced tachy, meaning rapid. It was coined in 1967 by {@link TimeListener}. 
 * The complementary particle types are called luxon (XY) and bradyon (XX), which both exist. 
 * The possibility of particles moving faster than light was first proposed by {@link TimeListener}, 
 * {@link TimeListener}, and {@link TimeListener} in 1962, although the term they used for it was 
 * "meta-particle".
 * 
 * <p>To send a mass to the past you just have to pray a little <tt>bit</tt>. And you will be pushed through
 * the {@link EventHorizon} arriving until the <tt>parent of inheritance</tt> that is located across the 
 * {@link BundleContext}.
 * 
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 */
public abstract class Tachyon
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends EventHorizon
			implements TimeListener<K,V> {
	
	/**
	 * 6711161026592679493L
	 */
	private static final long serialVersionUID = 6711161026592679493L;

	@SuppressWarnings("unchecked")
	@Override
	public synchronized TimeListener<K,V> getSource() {
		return (TimeListener<K,V>) source;
	}
	
	/**
	 * {@link Tachyon} default class constructor.
	 * @param source {@link TimeListener} the event source
	 */
	public Tachyon(TimeListener<K,V> source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getRoot()
	 */
	@Override
	public K getRoot() {
		return getSource().getRoot();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#setRoot(java.lang.Object)
	 */
	@Override
	public void setRoot(K root) {
		getSource().setRoot(root);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#getStem()
	 */
	@Override
	public V getStem() {
		return getSource().getStem();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#setStem(java.lang.Object)
	 */
	@Override
	public void setStem(V stem) {
		getSource().setStem(stem);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#dna()
	 */
	@Override
	public TimeListener<K,V> dna() {
		return getSource().dna();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getGen()
	 */
	@Override
	public Parity getGen() {
		return getSource().getGen();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#setGen(org.xmlrobot.util.Parity)
	 */
	@Override
	public void setGen(Parity parity) {
		getSource().setGen(parity);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public TimeListener<K,V> clone() {
		return getSource().clone();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.MassListener)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		getSource().addMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable command) {
		getSource().execute(command);
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		getSource().run();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public Thread newThread(Runnable r) {
		return getSource().newThread(r);
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		getSource().serviceChanged(event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.MassListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public void mass(MassListener entity, Tachyon<?,?> event) {
		getSource().mass(entity, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#matrix()
	 */
	@Override
	public TimeListener.Transmitter<K,V> matrix() {
		return getSource().matrix();
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(V o) {
		return getSource().compareTo(o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getAntitype()
	 */
	@Override
	public Class<? extends V> getAntitype() {
		return getSource().getAntitype();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setAntitype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> type) {
		getSource().setAntitype(type);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#get()
	 */
	@Override
	public V get() {
		return getSource().get();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#call()
	 */
	@Override
	public K call() {
		return getSource().call();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#get(long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public V get(long timeout, TimeUnit unit) {
		return getSource().get(timeout, unit);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#set(java.lang.Object)
	 */
	@Override
	public void set(V value) {
		getSource().set(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#execute(java.lang.Runnable, java.lang.Object)
	 */
	@Override
	public <T> Phaser<T> execute(Runnable task, T result) {
		return getSource().execute(task, result);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#cancel(boolean)
	 */
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return getSource().cancel(mayInterruptIfRunning);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isCancelled()
	 */
	@Override
	public boolean isCancelled() {
		return getSource().isCancelled();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Future#isDone()
	 */
	@Override
	public boolean isDone() {
		return getSource().isDone();
	}
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(K o1, K o2) {
		return getSource().compare(o1, o2);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#reproduceTo(java.lang.Object)
	 */
	@Override
	public int reproduceTo(V o) {
		return getSource().reproduceTo(o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#call(int)
	 */
	@Override
	public K call(int N) {
		return getSource().call(N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#polarize(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void polarize(K parent, K child) {
		getSource().polarize(parent, child);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#collect(org.xmlrobot.genesis.Congregation)
	 */
	@Override
	public Congregation<K> collect(Congregation<K> entities) {
		return getSource().collect(entities);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getFuture()
	 */
	@Override
	public K getFuture() {
		return getSource().getFuture();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getParent()
	 */
	@Override
	public K getParent() {
		return getSource().getParent();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getPast()
	 */
	@Override
	public K getPast() {
		return getSource().getPast();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderAt(java.lang.Object, int)
	 */
	@Override
	public void orderAt(K listener, int index) {
		getSource().orderAt(listener, index);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submitChild(java.lang.Object)
	 */
	@Override
	public K submitChild(K listener) {
		return getSource().submitChild(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderInfer(java.lang.Object)
	 */
	@Override
	public K orderInfer(K listener) {
		return getSource().orderInfer(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submitParent(java.lang.Object)
	 */
	@Override
	public K submitParent(K listener) {
		return getSource().submitParent(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#orderSuper(java.lang.Object)
	 */
	@Override
	public K orderSuper(K listener) {
		return getSource().orderSuper(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#releaseChild()
	 */
	@Override
	public K releaseChild() {
		return getSource().releaseChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#releaseParent()
	 */
	@Override
	public K releaseParent() {
		return getSource().releaseParent();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#permute(int)
	 */
	@Override
	public K permute(int N) {
		return getSource().permute(N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#revolve()
	 */
	@Override
	public K revolve() {
		return getSource().revolve();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#rotate()
	 */
	@Override
	public K rotate() {
		return getSource().rotate();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#setChild(java.lang.Object)
	 */
	@Override
	public void setChild(K listener) {
		getSource().setChild(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#swap(java.lang.Object)
	 */
	@Override
	public void swap(K listener) {
		getSource().swap(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#setParent(java.lang.Object)
	 */
	@Override
	public void setParent(K listener) {
		getSource().setParent(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#getChild()
	 */
	@Override
	public K getChild() {
		return getSource().getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#remove()
	 */
	@Override
	public void remove() {
		getSource().remove();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getType()
	 */
	@Override
	public Class<? extends K> getType() {
		return getSource().getType();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> value) {
		getSource().setType(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#clear()
	 */
	@Override
	public void clear() {
		getSource().clear();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#add(java.lang.Object)
	 */
	@Override
	public boolean add(K e) {
		return getSource().add(e);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#delve(int)
	 */
	@Override
	public int delve(int counter) {
		return getSource().delve(counter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#depth()
	 */
	@Override
	public int depth() {
		return getSource().depth();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return getSource().isEmpty();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(K entity) {
		return getSource().contains(entity);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#toArray()
	 */
	@Override
	public Object[] toArray() {
		return getSource().toArray();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#toArray(java.lang.Object[])
	 */
	@Override
	public <X> X[] toArray(X[] a) {
		return getSource().toArray(a);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#remove(java.lang.Object)
	 */
	@Override
	public Object remove(Object o) {
		return getSource().remove(o);
	}
	/* (non-Javadoc)
	 * @see java.util.Enumeration#hasMoreElements()
	 */
	@Override
	public boolean hasMoreElements() {
		return getSource().hasMoreElements();
	}
	/* (non-Javadoc)
	 * @see java.util.Enumeration#nextElement()
	 */
	@Override
	public K nextElement() {
		return getSource().nextElement();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#polarize()
	 */
	@Override
	public void polarize() {
		getSource().polarize();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#order(java.lang.Object)
	 */
	@Override
	public boolean order(K listener) {
		return getSource().order(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#release()
	 */
	@Override
	public K release() {
		return getSource().release();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#spin()
	 */
	@Override
	public void spin() {
		getSource().spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submit(java.lang.Object)
	 */
	@Override
	public boolean submit(K entity) {
		return getSource().submit(entity);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#iterator()
	 */
	@Override
	public Iterator<K> iterator() {
		return getSource().iterator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#containsAll(java.lang.Object)
	 */
	@Override
	public boolean containsAll(K c) {
		return getSource().containsAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#addAll(java.lang.Object)
	 */
	@Override
	public boolean addAll(K c) {
		return getSource().addAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#removeAll(java.lang.Object)
	 */
	@Override
	public boolean removeAll(K c) {
		return getSource().removeAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#retainAll(java.lang.Object)
	 */
	@Override
	public boolean retainAll(K c) {
		return getSource().retainAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#removeIf(java.util.function.Predicate)
	 */
	@Override
	public boolean removeIf(Predicate<? super K> filter) {
		return getSource().removeIf(filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#size()
	 */
	@Override
	public int size() {
		return getSource().size();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Congregation#submitAll(java.lang.Object)
	 */
	@Override
	public boolean submitAll(K c) {
		return getSource().submitAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#output()
	 */
	@Override
	public V output() {
		return getSource().output();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#write(java.io.File)
	 */
	@Override
	public void write(File file) {
		getSource().write(file);
	}
}
