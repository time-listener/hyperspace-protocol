/**
 * 
 */
package org.xmlrobot.horizon;

import java.io.File;
import java.util.Collection;
import java.util.EventObject;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.Congregation;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.genesis.Phaser;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/** 
 * An <i>event horizon</i> is a boundary in hyperspace beyond which events 
 * cannot affect an outside {@code Observer}. It is defined as 
 * "<tt>the point of no return</tt>". I,e, the point at which the inheritance 
 * kingdom becomes so great as to make free impossible.
 * <br><br>
 *  @author joan
 */
public abstract class EventHorizon
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends EventObject 
			implements TimeListener<K,V> {
	
	/**
	 * -111830605057953142L
	 */
	private static final long serialVersionUID = -111830605057953142L;
	
	/**
	 * @param source
	 */
	public EventHorizon(TimeListener<K,V> source)
	{
		super(source);
	}
	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public synchronized TimeListener<K,V> getSource() {

		return (TimeListener<K,V>) super.getSource();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Abstract#dna()
	 */
	@Override
	public TimeListener<K,V> dna() {

		return getSource().dna();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#getParity()
	 */
	@Override
	public Parity getGen() {

		return getSource().getGen();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#setParity(org.xmlrobot.type.Parity)
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
	 * @see org.xmlrobot.genesis.MassListener#addMassListener(org.xmlrobot.genesis.Entity)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		
		getSource().addMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
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
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener entity, Takion<?,?> event) {
		
		getSource().mass(entity, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Hypergenesis#matrix()
	 */
	@Override
	public TimeListener.Transmitter<K,V> matrix() {

		return getSource().matrix();
	}


	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X, Y>, Y extends TimeListener<Y, X>> void pulse(
			TimeListener<?,?> sender, Takion<Y,X> event) {
		getSource().pulse(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Graviton)
	 */
	@Override
	public <X extends TimeListener<X, Y>, Y extends TimeListener<Y, X>> void echo(
			TimeListener<?,?> sender, Takion<X,Y> event) {
		getSource().echo(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	@Override
	public void update() {
		
		getSource().update();
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(V o) {
		
		return getSource().compareTo(o);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#getAntitype()
	 */
	@Override
	public Class<? extends V> getAntitype() {

		return getSource().getAntitype();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#setAntitype(java.lang.Class)
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
	 * @see java.util.concurrent.ExecutorService#shutdown()
	 */
	@Override
	public void shutdown() {
		
		getSource().shutdown();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isShutdown()
	 */
	@Override
	public boolean isShutdown() {

		return getSource().isShutdown();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#isTerminated()
	 */
	@Override
	public boolean isTerminated() {

		return getSource().isTerminated();
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#submit(java.lang.Runnable, java.lang.Object)
	 */
	@Override
	public <T> Phaser<T> execute(Runnable task, T result) {
		
		return getSource().execute(task, result);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAll(java.util.Collection)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
			throws InterruptedException {
		
		return getSource().invokeAll(tasks);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(
			Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {

		return getSource().invokeAll(tasks, timeout, unit);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAny(java.util.Collection)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {
		
		return getSource().invokeAny(tasks);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.ExecutorService#invokeAny(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
			long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		
		return getSource().invokeAny(tasks, timeout, unit);
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
	 * @see org.xmlrobot.genesis.Inheritance#call(int)
	 */
	@Override
	public K call(int N) {

		return getSource().call(N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#chaos(java.lang.Object, java.lang.Object)
	 */
	@Override
	public void polarize(K parent, K child) {
		
		getSource().polarize(parent, child);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#collect(java.util.List)
	 */
	@Override
	public Congregation<K> collect(Congregation<K> entities) {
		
		return getSource().collect(entities);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#getFuture()
	 */
	@Override
	public K getFuture() {

		return getSource().getFuture();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#getParent()
	 */
	@Override
	public K getParent() {

		return getSource().getParent();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#getPast()
	 */
	@Override
	public K getPast() {

		return getSource().getPast();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#orderAt(java.lang.Object, int)
	 */
	@Override
	public void orderAt(K listener, int index) {
		
		getSource().orderAt(listener, index);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#orderChild(java.lang.Object)
	 */
	@Override
	public K submitChild(K listener) {
	
		return getSource().submitChild(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#orderInfer(java.lang.Object)
	 */
	@Override
	public K orderInfer(K listener) {

		return getSource().orderInfer(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#orderParent(java.lang.Object)
	 */
	@Override
	public K submitParent(K listener) {

		return getSource().submitParent(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#orderSuper(java.lang.Object)
	 */
	@Override
	public K orderSuper(K listener) {
		
		return getSource().orderSuper(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#releaseFuture()
	 */
	@Override
	public K releaseChild() {

		return getSource().releaseChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#releasePast()
	 */
	@Override
	public K releaseParent() {

		return getSource().releaseParent();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#permute(int)
	 */
	@Override
	public K permute(int N) {
		
		return getSource().permute(N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#revolve()
	 */
	@Override
	public K revolve() {
	
		return getSource().revolve();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#rotate()
	 */
	@Override
	public K rotate() {

		return getSource().rotate();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#setChild(java.lang.Object)
	 */
	@Override
	public void setChild(K listener) {
	
		getSource().setChild(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#swap(java.lang.Object)
	 */
	@Override
	public void swap(K listener) {
		
		getSource().swap(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#setParent(java.lang.Object)
	 */
	@Override
	public void setParent(K listener) {
		
		getSource().setParent(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#getChild()
	 */
	@Override
	public K getChild() {

		return getSource().getChild();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#free()
	 */
	@Override
	public void remove() {
		
		getSource().remove();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Message#getType()
	 */
	@Override
	public Class<? extends K> getType() {
		
		return getSource().getType();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#setType(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> value) {
		
		getSource().setType(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#clear()
	 */
	@Override
	public void clear() {
		
		getSource().clear();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#add(java.lang.Object)
	 */
	@Override
	public boolean add(K e) {
		
		return getSource().add(e);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#delve(int)
	 */
	@Override
	public int delve(int counter) {

		return getSource().delve(counter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#getDepth()
	 */
	@Override
	public int depth() {

		return getSource().depth();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#isEmpty()
	 */
	@Override
	public boolean isEmpty() {

		return getSource().isEmpty();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(K entity) {
		
		return getSource().contains(entity);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#toArray()
	 */
	@Override
	public Object[] toArray() {

		return getSource().toArray();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#toArray(java.lang.Object[])
	 */
	@Override
	public <X> X[] toArray(X[] a) {

		return getSource().toArray(a);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#remove(java.lang.Object)
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
	 * @see org.xmlrobot.genesis.Inheritance#polarize()
	 */
	@Override
	public void polarize() {
		
		getSource().polarize();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#order(java.lang.Object)
	 */
	@Override
	public boolean order(K listener) {
	
		return getSource().order(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#release()
	 */
	@Override
	public K release() {

		return getSource().release();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#spin()
	 */
	@Override
	public void spin() {
		
		getSource().spin();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#submit(java.lang.Object)
	 */
	@Override
	public boolean submit(K entity) {
		
		return getSource().submit(entity);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#iterator()
	 */
	@Override
	public Iterator<K> iterator() {
		
		return getSource().iterator();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#containsAll(org.xmlrobot.genesis.Inheritance)
	 */
	@Override
	public boolean containsAll(K c) {
	
		return getSource().containsAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#addAll(org.xmlrobot.genesis.Inheritance)
	 */
	@Override
	public boolean addAll(K c) {
		
		return getSource().addAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#removeAll(org.xmlrobot.genesis.Inheritance)
	 */
	@Override
	public boolean removeAll(K c) {
		
		return getSource().removeAll(c);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Inheritance#retainAll(org.xmlrobot.genesis.Inheritance)
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
	 * @see org.xmlrobot.genesis.MassListener#genesis(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext hyperspace) {
		
		getSource().start(hyperspace);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
		
		getSource().stop(context);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Reproducible#output()
	 */
	@Override
	public V output() {
		
		return getSource().output();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#getCommand()
	 */
	@Override
	public Command getCommand() {

		return getSource().getCommand();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#setCommand(org.xmlrobot.util.Command)
	 */
	@Override
	public void push(Command state) {
		
		getSource().push(state);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#family()
	 */
	@Override
	public ThreadGroup getFamily() {
		
		return getSource().getFamily();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#host()
	 */
	@Override
	public ServiceRegistration<?> getHost() {

		return getSource().getHost();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#name()
	 */
	@Override
	public String getName() {

		return getSource().getName();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#runner()
	 */
	@Override
	public Thread getRunner() {

		return getSource().getRunner();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getContext()
	 */
	@Override
	public BundleContext getContext() {

		return getSource().getContext();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#write(java.io.File)
	 */
	@Override
	public void write(File file) {
	
		getSource().write(file);
	}
}
