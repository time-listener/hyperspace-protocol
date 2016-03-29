package org.xmlrobot.subspace.mass;

import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.lang.Hyperinteger;
import org.xmlrobot.metatext.MetaSet;

/**
 * A {@link Hyperentry} that is {@link MetaSet}.
 * {@link Integer} is the key. {@link Character} is the value.
 * @author joan
 *
 */
@XmlRootElement
public final class Hyperset extends Hyperinteger {

	/**
	 * 2776973801628200812L
	 */
	private static final long serialVersionUID = 2776973801628200812L;

	/* (non-Javadoc)
	 * @see org.xmlrobot.subspace.matter.Hyperentry#getName()
	 */
	@Override
	public String getName() {
		return characterArrayToString(toArray());
	}

	/**
	 * 
	 */
	public Hyperset() {
		super();
	}
	
	@Override
	public void serviceChanged(ServiceEvent event) {
		
	}
	
}