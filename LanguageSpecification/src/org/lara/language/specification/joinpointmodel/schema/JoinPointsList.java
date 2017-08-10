//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in
// JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2014.03.12 at 05:44:48 PM GMT
//

package org.lara.language.specification.joinpointmodel.schema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for JoinPointsList complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="JoinPointsList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="global" type="{}GlobalJoinPoints" minOccurs="0"/>
 *         &lt;element name="joinpoint" type="{}JoinPointType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="root_class" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="root_alias" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JoinPointsList", propOrder = { "global", "joinpoint" })
public class JoinPointsList {

	protected GlobalJoinPoints global;
	@XmlElement(required = true)
	protected List<JoinPointType> joinpoint;
	@XmlAttribute(name = "root_class", required = true)
	@XmlIDREF
	@XmlSchemaType(name = "IDREF")
	protected Object rootClass;
	@XmlAttribute(name = "root_alias")
	protected String rootAlias;

	/**
	 * Gets the value of the global property.
	 * 
	 * @return possible object is {@link GlobalJoinPoints }
	 * 
	 */
	public GlobalJoinPoints getGlobal() {
		return global;
	}

	/**
	 * Sets the value of the global property.
	 * 
	 * @param value
	 *            allowed object is {@link GlobalJoinPoints }
	 * 
	 */
	public void setGlobal(GlobalJoinPoints value) {
		global = value;
	}

	/**
	 * Gets the value of the joinpoint property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the joinpoint property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getJoinpoint().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link JoinPointType }
	 * 
	 * 
	 */
	public List<JoinPointType> getJoinpoint() {
		if (joinpoint == null) {
			joinpoint = new ArrayList<>();
		}
		return joinpoint;
	}

	/**
	 * Gets the value of the rootClass property.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getRootClass() {
		return rootClass;
	}

	/**
	 * Sets the value of the rootClass property.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setRootClass(Object value) {
		rootClass = value;
	}

	/**
	 * Gets the value of the rootAlias property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRootAlias() {
		return rootAlias;
	}

	/**
	 * Sets the value of the rootAlias property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setRootAlias(String value) {
		rootAlias = value;
	}

}
