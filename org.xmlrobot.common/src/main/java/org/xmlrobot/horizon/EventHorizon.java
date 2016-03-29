/**
 * 
 */
package org.xmlrobot.horizon;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.protocol.Hyperheader;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 */
public abstract class EventHorizon 
	extends Mass<MassListener> 
		implements MassListener {

	/**
	 * 4880023876140949813L
	 */
	private static final long serialVersionUID = 4880023876140949813L;

	/**
	 * @param source
	 */
	public EventHorizon(MassListener source) {
		super(source);
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
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) {
		getSource().start(context);
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) {
		getSource().stop(context);
	}
	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable command) {
		getSource().execute(command);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#mass(org.xmlrobot.horizon.Tachyon)
	 */
	@Override
	public <X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> void mass(MassListener source, Tachyon<X,Y> event) {
		getSource().mass(source, event);
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
	 * @see org.xmlrobot.genesis.MassListener#write(java.io.File)
	 */
	@Override
	public void write(File file) {
		getSource().write(file);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#toArray()
	 */
	@Override
	public Object[] toArray() {
		return getSource().toArray();
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
	public void setCommand(Command value) {
		getSource().setCommand(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getContext()
	 */
	@Override
	public BundleContext getContext() {
		return getSource().getContext();
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
	public void setGen(Parity value) {
		getSource().setGen(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#dna()
	 */
	@Override
	public Hyperheader dna() {
		return getSource().dna();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	@Override
	public void update() {
		getSource().update();
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
		getSource().serviceChanged(event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#depth()
	 */
	@Override
	public AtomicInteger depth(MassListener sender) {
		return getSource().depth(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#clear()
	 */
	@Override
	public void clear(MassListener sender) {
		getSource().clear(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#unify()
	 */
	@Override
	public void unify(MassListener sender) {
		getSource().unify(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#addMassListener(org.xmlrobot.MassListener)
	 */
	@Override
	public void addMassListener(MassListener listener) {
		getSource().addMassListener(listener);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.MassListener#removeMassListener(org.xmlrobot.MassListener)
	 */
	@Override
	public void removeMassListener(MassListener listener) {
		getSource().removeMassListener(listener);
	}
}