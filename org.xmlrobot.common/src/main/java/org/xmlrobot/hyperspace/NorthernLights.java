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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlTransient;

import org.xmlrobot.genesis.TimeListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.util.Parity;

/**
 * @author joan
 *
 * @param <K> is the key
 * @param <V> is the value
 * 
 * @parity YY
 * @since 7
 */
@XmlTransient
public abstract class NorthernLights
	<K extends TimeListener<K,V>,V extends TimeListener<V,K>> 
		extends Concurrence<K,V> {

	/**
	 * 2912262260515103834L
	 */
	private static final long serialVersionUID = 2912262260515103834L;

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
	 * @param antitype the antitype
	 * @param gen {@link Parity} the gender
	 */
    protected NorthernLights(Class<? extends K> type, Class<? extends V> antitype, Parity gen) {
		super(type, antitype, gen);
	}
	
	/**
     * Returns a XML String representation of this {@code time-listener}. 
     * This implementation returns a marshalled XML string representation 
     * of this entry's key element by the meta-tag ("<tt>key</tt>")
     * followed by the XML string representation of this entry's value
     * by the meta-tag ("<tt>value</tt>").
     *
     * @return a XML String representation of this {@code time-listener}
     */
	@Override
	public String toString() {
		
		try {
			Class<?> type = this.getClass();
			// establish context
			context = JAXBContext.newInstance(type);
			marshaller = context.createMarshaller();

			// output pretty printed
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, 
					"http://xmlrobot.org/");
			
			// stream it
			StringWriter sw = new StringWriter();
			marshaller.marshal(this, sw);	
			String strXml = sw.toString();
			
			return strXml;
		}
		catch (JAXBException e) 
		{
			e.printStackTrace();
			return null;
		}
	}
	/**
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
	}/**
	 * @param inputStream
	 * @throws JAXBException
	 */
	@SuppressWarnings({ "unchecked" })
	public void unmarshal(InputStream inputStream) 
			throws JAXBException {
		
		try {
			context = JAXBContext.newInstance(this.getClass());
			unmarshaller = context.createUnmarshaller();

			TimeListener<K,V> listener = (TimeListener<K,V>) unmarshaller
					.unmarshal(inputStream);
			push(new Takion<K,V>(listener) {
				/**
				 * -1045546931371948769L
				 */
				private static final long serialVersionUID = -1045546931371948769L;

			});

			// @SuppressWarnings("unchecked")
			// Imagination<K, V, G, C, T> obj = (Imagination<K, V, G, C,
			// T>)unmarshaller.unmarshal(inputStream);
			// MarshallEvent(new MarshallerEvent(obj,
			// MarshallerEventType.OBJECT_UNMARSHALLED));
		} catch (Exception e) {
			throw new JAXBException(e.getMessage(), e.getCause());
		}
	}
	/**
	 * @param file
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
}
