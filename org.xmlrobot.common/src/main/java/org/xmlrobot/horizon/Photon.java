/**
 * 
 */
package org.xmlrobot.horizon;

import org.xmlrobot.TimeListener;
import org.xmlrobot.positron.MassEntity;

/**
 * @author joan
 *
 */
public abstract class Photon
	<K extends TimeListener<? super K,? super V>,
	 V extends TimeListener<? super V,? super K>> 
		extends Graviton<K,V> {

	/**
	 * 933204028108570728L
	 */
	private static final long serialVersionUID = 933204028108570728L;

	/**
	 * @param source
	 */
	public Photon(MassEntity<K,V> source) {
		super(source);
	}
	
	/* (non-Javadoc)
	 * @see org.xmlrobot.horizon.Graviton#getSource()
	 */
	@Override
	public synchronized MassEntity<K,V> getSource() {
		return (MassEntity<K,V>) super.getSource();
	}
}
