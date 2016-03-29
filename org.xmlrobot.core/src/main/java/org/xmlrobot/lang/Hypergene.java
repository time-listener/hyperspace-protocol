/**
 * 
 */
package org.xmlrobot.lang;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.positron.Positron;
import org.xmlrobot.space.Space;

/**
 * @author joan
 *
 */
public class Hypergene
	extends Space<Hyperstring,Hyperinteger> {

	/**
	 * -7385859490045873850L
	 */
	private static final long serialVersionUID = -7385859490045873850L;

	/**
	 * 
	 */
	public Hypergene() {

	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Recursion#compareTo(org.xmlrobot.genesis.TimeListener)
	 */
	@Override
	public int compareTo(Positron<Hyperstring,Hyperinteger> o) {
		return getNegative().compareTo(o.getNegative());
	}
	/* (non-Javadoc)
	 * @see org.osgi.framework.ServiceListener#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.Hypergenesis#getName()
	 */
	@Override
	public String getName() {
		return null;
	}
}
