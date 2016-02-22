/**
 * 
 */
package org.xmlrobot.horizon;

import java.util.Collection;
import java.util.EventObject;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.util.Command;

/** 
 * An <i>event horizon</i> is a boundary in hyperspace beyond which events 
 * cannot affect an outside {@code Observer}. It is defined as 
 * "<tt>the point of no return</tt>". I,e, the point at which the inheritance 
 * kingdom becomes so great as to make free impossible.
 * <br><br>
 *  @author joan
 */
public abstract class EventHorizon
		extends EventObject 
			implements MassListener {
	
	/**
	 * -111830605057953142L
	 */
	private static final long serialVersionUID = -111830605057953142L;

	/* (non-Javadoc)
	 * @see java.util.EventObject#getSource()
	 */
	@Override
	public synchronized MassListener getSource() {
		return (MassListener) super.getSource();
	}
	
	/**
	 * @param source
	 */
	public EventHorizon(MassListener source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#pulse(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public <X extends TimeListener<X, Y>, Y extends TimeListener<Y, X>> void pulse(
			TimeListener<?,?> sender, Tachyon<Y,X> event) {
		getSource().pulse(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Deflector#echo(org.xmlrobot.genesis.TimeListener, org.xmlrobot.horizon.Takion)
	 */
	@Override
	public <X extends TimeListener<X, Y>, Y extends TimeListener<Y, X>> void echo(
			TimeListener<?,?> sender, Tachyon<X,Y> event) {
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
	 * @see org.xmlrobot.genesis.Executor#shutdown()
	 */
	@Override
	public void shutdown() {
		getSource().shutdown();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#isShutdown()
	 */
	@Override
	public boolean isShutdown() {
		return getSource().isShutdown();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#isTerminated()
	 */
	@Override
	public boolean isTerminated() {
		return getSource().isTerminated();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
			throws InterruptedException {
		return getSource().invokeAll(tasks);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAll(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> List<Future<T>> invokeAll(
			Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		return getSource().invokeAll(tasks, timeout, unit);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAny(java.util.Collection)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {
		return getSource().invokeAny(tasks);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Executor#invokeAny(java.util.Collection, long, java.util.concurrent.TimeUnit)
	 */
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
			long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		return getSource().invokeAny(tasks, timeout, unit);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#start(org.osgi.framework.BundleContext)
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
	 * @see org.xmlrobot.genesis.MassListener#getCommand()
	 */
	@Override
	public Command getCommand() {
		return getSource().getCommand();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#push(org.xmlrobot.util.Command)
	 */
	@Override
	public void push(Command state) {
		getSource().push(state);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getFamily()
	 */
	@Override
	public ThreadGroup getFamily() {
		return getSource().getFamily();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getHost()
	 */
	@Override
	public ServiceRegistration<?> getHost() {
		return getSource().getHost();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getName()
	 */
	@Override
	public String getName() {
		return getSource().getName();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getRunner()
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
}
