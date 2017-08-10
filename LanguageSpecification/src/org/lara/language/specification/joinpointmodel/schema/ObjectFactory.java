//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in
// JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.03.12 at 05:44:48 PM GMT
//

package org.lara.language.specification.joinpointmodel.schema;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the
 * org.lara.language.specification.joinpointmodel.schema package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _Joinpoints_QNAME = new QName("", "joinpoints");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package:
	 * org.lara.language.specification.joinpointmodel.schema
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GlobalJoinPoints }
	 * 
	 */
	public GlobalJoinPoints createGlobalJoinPoints() {
		return new GlobalJoinPoints();
	}

	/**
	 * Create an instance of {@link Select }
	 * 
	 */
	public Select createSelect() {
		return new Select();
	}

	/**
	 * Create an instance of {@link JoinPointsList }
	 * 
	 */
	public JoinPointsList createJoinPointsList() {
		return new JoinPointsList();
	}

	/**
	 * Create an instance of {@link JoinPointType }
	 * 
	 */
	public JoinPointType createJoinPointType() {
		return new JoinPointType();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link JoinPointsList
	 * }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "joinpoints")
	public JAXBElement<JoinPointsList> createJoinpoints(JoinPointsList value) {
		return new JAXBElement<>(ObjectFactory._Joinpoints_QNAME, JoinPointsList.class, null, value);
	}

}
