/**
 * 
 */
package org.xmlrobot.hyperspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * The current <tt>hyperspace</tt> implementation class.
 * 
 * <p>Hyperspace allows for near instantaneous transportation between two points, 
 * however an object traveling through hyperspace cannot independently control 
 * its exiting point. To travel to a congregation destination a corresponding hyperspace 
 * gate must be implemented at the destination. This second gate effectively pulls 
 * the object out of hyperspace and back to normal space.
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
@XmlTransient
public abstract class Hyperspace
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends NorthernLights<K,V> {

	/**
	 * -2410739439956912487L
	 */
	private static final long serialVersionUID = -2410739439956912487L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#host()
	 */
	@Override
	@XmlTransient
	public ServiceRegistration<?> getHost() {
		return message.getHost();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#command()
	 */
	@Override
	@XmlElement
	public Command getCommand() {
		return message.getCommand();
	}
	/**
	 * @return
	 */
	public boolean isRegistered() {
		return getHost() != null;
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
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected Hyperspace(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public final synchronized void start(BundleContext context) {
		// avoid concurrent calls to start
		if(!message.compareAndSet(CONTEXT, null, context)) {
			// because it is already started
			return;
		}
		else {
			super.start(context);
			// the entity is registered into the hyperspace by itself
			ServiceRegistration<?> host = 
					context.registerService(TimeListener.class, this, message);
			// finally, save entity's registration object.
			message.put(HOST, host);
		} 
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public final synchronized void stop(BundleContext context) {
		// avoid concurrent calls to stop
		if(!message.compareAndSet(CONTEXT, context, null)) {
			// because it is already stopped
			return;
		}
		else {
			super.stop(context);
			// assign and check
			if(isRegistered())
				// auto-execution
				getHost().unregister();
				// nullify host
				message.put(HOST, null);
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#update()
	 */
	public void update() {
		if(isRegistered())
			getHost().setProperties(message);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#push(org.xmlrobot.util.Command)
	 */
	@Override
	public void push(Command value) {
		// set command header
		message.push(value);
		// stream entity's properties
		update();
		// submit abstract command into the hyperspace
		push(new Tachyon<K,V>(this) {
			/**
			 * 3217060066232920443L
			 */
			private static final long serialVersionUID = 3217060066232920443L;
		});
	}
	/**
	 * @param o
	 */
	public void pùsh(V o) {
		// submit abstract command into the hyperspace
		push(new Tachyon<V,K>(o) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -6129167743799704604L;
		});
	}
}