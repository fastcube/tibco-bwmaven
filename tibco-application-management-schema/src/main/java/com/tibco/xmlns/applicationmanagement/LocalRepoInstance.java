//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.23 at 10:11:20 AM CET 
//


package com.tibco.xmlns.applicationmanagement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.tibco.com/xmlns/ApplicationManagement}RepoInstanceType">
 *       &lt;sequence>
 *         &lt;element name="encoding" type="{http://www.tibco.com/xmlns/ApplicationManagement}encodingType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "encoding"
})
public class LocalRepoInstance
    extends RepoInstanceType
{

    @XmlElement(defaultValue = "ISO8859-1")
    protected EncodingType encoding;

    /**
     * Gets the value of the encoding property.
     * 
     * @return
     *     possible object is
     *     {@link EncodingType }
     *     
     */
    public EncodingType getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link EncodingType }
     *     
     */
    public void setEncoding(EncodingType value) {
        this.encoding = value;
    }

}