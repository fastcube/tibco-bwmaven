//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.23 at 10:11:20 AM CET 
//


package com.tibco.xmlns.dd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="componentSoftwareName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minimumComponentSoftwareVersionNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="minimumComponentSoftwareVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minimumTRAVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="configVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keyword" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "componentSoftwareName",
    "minimumComponentSoftwareVersionNumber",
    "minimumComponentSoftwareVersion",
    "minimumTRAVersion",
    "configVersion",
    "keyword"
})
@XmlRootElement(name = "ComponentSoftwareReference")
public class ComponentSoftwareReference {

    protected String componentSoftwareName;
    protected Long minimumComponentSoftwareVersionNumber;
    protected String minimumComponentSoftwareVersion;
    protected String minimumTRAVersion;
    protected String configVersion;
    protected List<String> keyword;

    /**
     * Gets the value of the componentSoftwareName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComponentSoftwareName() {
        return componentSoftwareName;
    }

    /**
     * Sets the value of the componentSoftwareName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComponentSoftwareName(String value) {
        this.componentSoftwareName = value;
    }

    /**
     * Gets the value of the minimumComponentSoftwareVersionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinimumComponentSoftwareVersionNumber() {
        return minimumComponentSoftwareVersionNumber;
    }

    /**
     * Sets the value of the minimumComponentSoftwareVersionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinimumComponentSoftwareVersionNumber(Long value) {
        this.minimumComponentSoftwareVersionNumber = value;
    }

    /**
     * Gets the value of the minimumComponentSoftwareVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinimumComponentSoftwareVersion() {
        return minimumComponentSoftwareVersion;
    }

    /**
     * Sets the value of the minimumComponentSoftwareVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinimumComponentSoftwareVersion(String value) {
        this.minimumComponentSoftwareVersion = value;
    }

    /**
     * Gets the value of the minimumTRAVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinimumTRAVersion() {
        return minimumTRAVersion;
    }

    /**
     * Sets the value of the minimumTRAVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinimumTRAVersion(String value) {
        this.minimumTRAVersion = value;
    }

    /**
     * Gets the value of the configVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfigVersion() {
        return configVersion;
    }

    /**
     * Sets the value of the configVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfigVersion(String value) {
        this.configVersion = value;
    }

    /**
     * Gets the value of the keyword property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyword property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyword().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getKeyword() {
        if (keyword == null) {
            keyword = new ArrayList<String>();
        }
        return this.keyword;
    }

}
