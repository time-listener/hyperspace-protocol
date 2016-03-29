/**
 * 
 */
package org.xmlrobot.common;

import org.xmlrobot.TimeListener;
import org.xmlrobot.horizon.Tachyon;

/**
 * @author joan
 *
 */
public class Instant extends Tachyon<Tick, Tack> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7752541539293184953L;

	/**
	 * @param source
	 */
	public Instant(TimeListener<Tick, Tack> source) {
		super(source);
	}

}
