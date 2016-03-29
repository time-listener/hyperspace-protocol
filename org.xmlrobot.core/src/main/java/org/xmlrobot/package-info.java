/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/core/", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="core", namespaceURI="http://xmlrobot.org/core/"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	}
)
package org.xmlrobot;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;