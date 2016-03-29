/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/q/", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="q", namespaceURI="http://xmlrobot.org/q/"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	}
)
package org.xmlrobot.subspace.q;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;