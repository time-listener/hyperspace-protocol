/**
 * 
 */
package org.xmlrobot.hyperspace;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;


/**
 * @author joan
 *
 * @param <K>
 * @param <V>
 * 
 * @parity YY
 * @since 3
 */
@XmlTransient
public abstract class Abstraction
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Unification<K,V> {

	/**
	 * 6580955180470674793L
	 */
	private static final long serialVersionUID = 6580955180470674793L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#getName()
	 */
	@Override
	public abstract String getName();

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Entity#context()
	 */
	@Override
	@XmlTransient
	public BundleContext getContext() {

		return message.getContext();
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#getAntitype()
	 */
	@Override
	@XmlElement
	public Class<? extends V> getAntitype() {

		return message.getAntitype();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#setAntitype(java.lang.Class)
	 */
	@Override
	public void setAntitype(Class<? extends V> value) {

		message.setAntitype(value);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#getAntitype()
	 */
	@Override
	@XmlElement
	public Class<? extends K> getType() {

		return message.getType();
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Phaser#setAntitype(java.lang.Class)
	 */
	@Override
	public void setType(Class<? extends K> value) {

		message.setType(value);
	}
	
    /**
     * {@link Abstraction} default class constructor.
     */
    public Abstraction() {
    	super();
    }
	/**
	 * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected Abstraction(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link Abstraction} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
    protected Abstraction(Class<? extends K> type, V stem, 
			Parity gen) {
		super(type, stem, gen);
	}
    
	/* (non-Javadoc)
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
	 */
	@Override
	public abstract Thread newThread(Runnable entity);
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#mass(org.xmlrobot.genesis.Message, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public abstract void mass(MassListener sender, Tachyon<?,?> event);
	
	/* (non-Javadoc)-
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public abstract void serviceChanged(ServiceEvent event) ;
}