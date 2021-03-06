/**
 * 
 */
package org.xmlrobot.util;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * The ten commands.
 * @author joan
 *
 */
@XmlType(name = "command")
@XmlEnum(String.class)
public enum Command {
	
	/**
	 * The entity has been instantiated.
	 */
	@XmlEnumValue(value = "genesis")
	GENESIS,	
	/**
	 * The entity has been interrupted.
	 */
	@XmlEnumValue(value = "interrupted")
	INTERRUPTED,
	/**
	 * The entity has been created.
	 */
	@XmlEnumValue(value = "listen")
	LISTEN,
	/**
	 * Mass manipulation.
	 */
	@XmlEnumValue(value = "order")
	ORDER,
	/**
	 * Liberates entity from inheritance.
	 */
	@XmlEnumValue(value = "release")
	RELEASE,
	/**
	 * From the hyperspace to the thread pool.
	 */
	@XmlEnumValue(value = "resurrection")
	RESURRECTION,
	/**
	 * Sends entity.
	 */
	@XmlEnumValue(value = "send")
	SEND,
	/**
	 * Submit entity to the inheritance cycle.
	 */
	@XmlEnumValue(value = "submit")
	SUBMIT,
	/**
	 * Entity comes with me.
	 */
	@XmlEnumValue(value = "push")
	PUSH,
	/**
	 * The entity has reached the End of Cycle.
	 */
	@XmlEnumValue(value = "transfer")
	TRANSFER
}