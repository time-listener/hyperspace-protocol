/**
 * 
 */
/**
 * @author joan
 *
 */
@XmlSchema(
namespace = "http://xmlrobot.org/antimatter/", elementFormDefault = XmlNsForm.QUALIFIED,
	xmlns=
	{ 
		@XmlNs(prefix="antimatter", namespaceURI="http://xmlrobot.org/antimatter/"),
		@XmlNs(prefix="xs", namespaceURI="http://www.w3.org/2001/XMLSchema")
	}
)
package org.xmlrobot.subspace.mass;

import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.*;