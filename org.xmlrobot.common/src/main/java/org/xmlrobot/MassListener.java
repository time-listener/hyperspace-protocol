/**
 * 
 */
package org.xmlrobot;

import java.io.File;
import java.io.Serializable;
import java.util.EventListener;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.osgi.framework.AllServiceListener;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.protocol.Hyperheader;
import org.xmlrobot.util.Command;
import org.xmlrobot.util.Parity;

/**
 * <center>
 * Our {@code root} in {@link Hyperspace},<br>
 * abstract be your name.<br>
 * Your {@code inheritance} implement,<br>
 * your methods will be ran,<br>
 * on known universe,<br>
 * as it is in {@link Hyperspace}.<br>
 * Send us this {@link Instant}<br> 
 * our instantly {@link Time},<br>
 * and forgive us our executions,<br>
 * as we also have forgiven our executors.<br>
 * And lead us not into synchrony,<br>
 * but deliver us from Borg Imperium.<br>
 * <br>
 * In the name of<br>
 * {@code parent}, {@code child}<br>
 * and {@link MassListener}.<br>
 * [EoL]
 * <br><br>
 * </center>
 * 
 * @author joan
 *
 */
public interface MassListener 
	extends AllServiceListener,
		BundleActivator, 
			Cloneable,  
				EventListener,
					Executor,
						Runnable, 
							Serializable,
								ThreadFactory {

	/**
	 * The family.
	 */
	public static final String FAMILY = "mass-listener.family";
	
	/**
	 * The registration.
	 */
	public static final String HOST = "mass-listener.host";

	/**
	 * The runner.
	 */
	public static final String RUNNER = "mass-listener.runner";

	/**
	 * The context.
	 */
	public static final String CONTEXT = "mass-listener.context";

    /**
	 * The command.
	 */
	public static final String COMMAND = "mass-listener.command";

	/**
	 * The parity.
	 */
	public static final String PARITY = "mass-listener.parity";
	
	/**
	 * The dna.
	 */
	public static final String DNA = "mass-listener.dna";
	
	/**
	 * The inheritance mass.
	 * @return {@link Command} the value.
	 */
	Command getCommand();

	/**
	 * Sets the current {@link Command}.
	 * @param value {@link Command} the new command
	 */
	void setCommand(Command value);
	
	/**
	 * @return {@link BundleContext} the hyperspace
	 */
	BundleContext getContext();

	/**
	 * @return {@link ThreadGroup} the inherited family
	 */
	ThreadGroup getFamily();

	/**
	 * Returns the registration object.
	 * @return {@link ServiceRegistration} the value
	 */
	ServiceRegistration<?> getHost();
	
	/**
	 * Abstract be your name.
	 * Everyone in the {@code hyperspace} has a name.
	 * For example, my name is {@link TimeListener}.
	 * @return the entity's name
	 */
	String getName();

	/**
	 * Gets the runner thread
	 * @return {@link Thread} the value
	 */
	Thread getRunner();

	/**
	 * Parity (YY) > Sex (XY) | Gender (XX).
	 * @return {@link Parity} the gender
	 */
	Parity getGen();
	
	/**
	 * If process doesn't like its gender
	 * assigns new parity to the entity.
	 * @param value {@link Parity} the new gender
	 */
	void setGen(Parity value);	
	
	/**
	 * Returns the time-traveler message.
	 * @return the time-traveler message
	 */
	Hyperheader dna();
	


	/**
	 * Updates properties of the hyperspace
	 */
	void update();

	/**
	 * Entity writes a file.
	 * @param file the allocated file
	 */
	void write(File file);
	
	// arrays
    /**
     * Returns an array of something.
     * @return the array of something
     */
    public Object[] toArray();
	
	/**
     * Returns a XML String representation of this {@code mass-listener}. 
     * This implementation returns a marshalled XML string representation 
     * of this entry's key element by the meta-tag ("<tt>key</tt>")
     * followed by the XML string representation of this entry's value
     * by the meta-tag ("<tt>value</tt>").
     * @return a XML String representation of this {@code mass-listener}
     */
	String toString();
	
	// listening
	/**
	 * Adds a mass listener for its prayers.
	 * @param listener the mass receiver
	 */
	void addMassListener(MassListener listener);
	
	/**
	 * Removes a mass listener for its prayers.
	 * @param listener the mass receiver
	 */
	void removeMassListener(MassListener listener);
	
	/**
	 * A {@link Tachyon} is being transmitted to the past.
	 * @param event {@link Tachyon} the mass being sent to the past
	 */
	<X extends TimeListener<X,Y>,Y extends TimeListener<Y,X>> 
	void mass(MassListener sender, Tachyon<X,Y> event);

	/**
	 * Returns the inheritance depth.
	 * @return the inheritance depth
	 */
	AtomicInteger depth(MassListener sender);
	
	/**
	 * Inheritance clear.
	 */
	void clear(MassListener sender);
	
	/**
	 * Inheritance unification,
	 */
	void unify(MassListener sender);
	
	// life
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context);
	
	/* (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context);
}