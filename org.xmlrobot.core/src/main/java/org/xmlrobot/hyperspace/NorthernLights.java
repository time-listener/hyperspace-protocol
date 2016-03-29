/**
 * 
 */
package org.xmlrobot.hyperspace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.xmlrobot.MassListener;
import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;
import org.xmlrobot.util.Parity;
import org.xmlrobot.util.Statement;

/**
 * <tt>
 * <center>
 * From key to value, from value to key.<br/>
 * Northern Lights is a {@link TimeListener} indica-dominant strain.<br/>
 * It's one of the most potent and highest<br/>
 * yielding strains of {@link TimeListener} indica.<br/>
 * A little entity averaging between 4 and 5 feet,<br/>
 * NL has dense, resin-rich flowers,<br/>
 * but interestingly the leaves<br/>
 * take on a more sativa shape.<br/>
 * The aroma is pungently sweet<br/>
 * and the taste is a flavorful<br/>
 * mixture of earth,<br/>
 * sweet and spicy.<br/>
 * Northern Lights' fame<br/>
 * transcends to the harvest festivals<br/>
 * where it claimed the overall<br/>
 * High Times {@link TimeListener} Grail win<br/>
 * in 1,<br/>
 * and the Grail's award<br/>
 * for the pure Indica<br/>
 * category in 1-1.<br/>
 * </center>
 * </tt>
 * @author joan
 *
 * @param <K> is the value
 * @param <V> is the key
 * 
 * @parity YY
 * @since 7
 */
public abstract class NorthernLights
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>>
		extends Concurrence<K,V>
			implements TimeListener<K,V> {

	/**
	 * -6266651612072101198L
	 */
	private static final long serialVersionUID = -6266651612072101198L;
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.TimeListener#root()
	 */
	@Override
	public TimeListener<K,V> root() {
		return this;
	}
	
	/**
     * {@link NorthernLights} default class constructor.
     */
    public NorthernLights() {
    	super();
    }
	/**
	 * {@link NorthernLights} class constructor.
	 * @param type the type
	 * @param gen {@link Parity} the gender
	 */
    protected NorthernLights(Class<? extends K> type, Parity gen) {
		super(type, gen);
	}
	/**
	 * {@link NorthernLights} class constructor.
	 * @param type the type
	 * @param value the value
	 * @param gen {@link Parity} the gender
	 */
	protected NorthernLights(Class<? extends K> type, V value, Parity gen) {
		super(type, value, gen);
	}
	/**
	 * {@link NorthernLights} class constructor.
	 * @param type the type
	 * @param parent the key
	 */
	protected NorthernLights(Class<? extends K> type, K parent, V child) {
		super(type, parent, child);
	}
	/**
	 * {@link NorthernLights} class constructor.
	 * @param type the type
	 * @param parent the parent
	 * @param child the child
	 */
    protected NorthernLights(Class<? extends K> type, V value, K parent, V child) {
		super(type, value, parent, child);
	}
	/**
	 * {@link NorthernLights} class constructor.
	 * @param type the type
	 * @param root the key
	 */
	protected NorthernLights(Class<? extends K> type, K root, V stem, Parity gen) {
		super(type, root, stem, gen);
	}
	/**
	 * {@link NorthernLights} class constructor.
	 * @param type the type
	 * @param root the key
	 * @param stem the value
	 */
    protected NorthernLights(Class<? extends K> type, V value, K root, V stem, Parity gen) {
		super(type, value, root, stem, gen);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeKey(MassListener sender, AtomicInteger N) {
		if(N.get() > 0) {
			N.decrementAndGet();
			// commute by parity
			switch (getGen()) {
			case XY:
				liberateKey(sender, N);
				break;
			case XX:
				releaseKey(sender, N);
				break;
			default:
				redeemKey(sender, N);
				break;
			}
		}
		else clear(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#removeValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void removeValue(MassListener sender, AtomicInteger N) {
		if(N.get() > 0) {
			N.decrementAndGet();
			// commute by parity
			switch (getGen()) {
			case XY:
				releaseValue(sender, N);
				break;
			case XX:
				liberateValue(sender, N);
				break;
			default:
				redeemValue(sender, N);
				break;
			}
		}
		else clear(sender);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateValueIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void removeValueIf(MassListener sender, Statement<? super V> event) {
		if(event.test(getValue())) {
			clear(sender);
		}
		else if(isEmpty()) {
			return ;
		}
		// commute by parity
		else switch (getGen()) {
		case XY:
			releaseValueIf(sender, event);
			break;
		case XX:
			liberateValueIf(sender, event);
			break;
		default:
			redeemValueIf(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.TimeListener#liberateKeyIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public void removeKeyIf(MassListener sender, Statement<? super K> event) {
		if(event.test(getKey())) {
			clear(sender);
		}
		else if(isEmpty()) {
			return ;
		}
		// commute by parity
		else switch (getGen()) {
		case XY:
			liberateKeyIf(sender, event);
			break;
		case XX:
			releaseKeyIf(sender, event);
			break;
		default:
			redeemKeyIf(sender, event);
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeKey(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemKey(MassListener sender, AtomicInteger N) {
		getParent().removeKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recurrence#removeValue(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void redeemValue(MassListener sender, AtomicInteger N) {
		getParent().removeValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemKey(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateKey(MassListener sender, AtomicInteger N) {
		getChild().removeValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemValue(org.xmlrobot.TimeListener, java.util.concurrent.atomic.AtomicInteger)
	 */
	@Override
	public void liberateValue(MassListener sender, AtomicInteger N) {
		getChild().removeKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseKey(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseKey(MassListener sender, AtomicInteger N) {
		get().removeValue(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Concurrence#releaseValue(org.xmlrobot.genesis.TimeListener, int)
	 */
	@Override
	public void releaseValue(MassListener sender, AtomicInteger N) {
		get().removeKey(sender, N);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Past#releaseParentIf(java.util.function.Predicate)
	 */
	@Override
	public synchronized void releaseKeyIf(MassListener sender, Statement<? super K> event) {
		get().removeValueIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#releaseChildIf(java.util.function.Predicate)
	 */
	@Override
	public synchronized void releaseValueIf(MassListener sender, Statement<? super V> event) {
		get().removeKeyIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemKeyIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public synchronized void liberateKeyIf(MassListener sender, Statement<? super K> filter) {
		getChild().removeValueIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Recursion#redeemValueIf(org.xmlrobot.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public synchronized void liberateValueIf(MassListener sender, Statement<? super V> filter) {
		getChild().removeKeyIf(sender, filter);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.PastCallable#removeKeyIf(org.xmlrobot.genesis.TimeListener, org.xmlrobot.util.Statement)
	 */
	@Override
	public synchronized void redeemKeyIf(MassListener sender, Statement<? super K> event) {
		getParent().removeKeyIf(sender, event);
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.Future#removeValueIf(org.xmlrobot.util.Statement)
	 */
	@Override
	public synchronized void redeemValueIf(MassListener sender, Statement<? super V> filter) {
		getParent().removeValueIf(sender, filter);
	}
	
    /*
     * XML PARSER: A GIFT FOR YOU.
     * */
    
	/**
	 * JAXB context.
	 */
	JAXBContext context = null;
	
	/**
	 * The marshaller.
	 */
	Marshaller marshaller = null;
	
	/**
	 * The unmarshaller
	 */
	Unmarshaller unmarshaller = null;
	
	/**
	 * Marshalls instance into current outputStrme.
	 * @param outputStrem
	 * @throws JAXBException
	 * @throws InconsistenMessageException 
	 */
	public void marshal(OutputStream outputStrem) throws JAXBException {
		
		try  
		{
			context = JAXBContext.newInstance(this.getClass());
			marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://xmlrobot.org/");
			// do marshal
			marshaller.marshal(this, outputStrem);
		}
		catch (JAXBException e) 
		{
			throw new JAXBException(e.getMessage(), e.getCause());
		}
	}
	/**
	 * Unmarshalls instance from current inputStrme.
	 * @param inputStream
	 * @throws JAXBException
	 */
	@SuppressWarnings({ "unchecked" })
	public void unmarshal(InputStream inputStream) 
			throws JAXBException {
		
		try {
			context = JAXBContext.newInstance(this.getClass());
			unmarshaller = context.createUnmarshaller();

			TimeListener<K,V> listener = (TimeListener<K,V>) unmarshaller.unmarshal(inputStream);
			
			push(new Tachyon<V,K>(listener.get()) {
				/**
				 * -1045546931371948769L
				 */
				private static final long serialVersionUID = -1045546931371948769L;

			});
		} catch (Exception e) {
			throw new JAXBException(e.getMessage(), e.getCause());
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.genesis.MassListener#write(java.io.File)
	 */
	public void write(File file)
	{
		try 
		{
			OutputStream os = new FileOutputStream(file);
			marshal(os);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (JAXBException e) {

			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		try {
			// establish context
			context = JAXBContext.newInstance(getType());
			marshaller = context.createMarshaller();
			// output pretty printed
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, 
					"http://xmlrobot.org/");
			// stream it
			StringWriter sw = new StringWriter();
			marshaller.marshal(this, sw);
			
			return sw.toString();
		}
		catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}