//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.10.21 à 05:50:10 PM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}resource" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fauna" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="flora" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resource"
})
@XmlRootElement(name = "biosphere")
public class Biosphere {

    @XmlElement(required = true)
    protected List<Resource> resource;
    @XmlAttribute(name = "fauna", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String fauna;
    @XmlAttribute(name = "flora", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String flora;

    /**
     * Gets the value of the resource property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resource property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Resource }
     * 
     * 
     */
    public List<Resource> getResource() {
        if (resource == null) {
            resource = new ArrayList<Resource>();
        }
        return this.resource;
    }

    /**
     * Obtient la valeur de la propriété fauna.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFauna() {
        return fauna;
    }

    /**
     * Définit la valeur de la propriété fauna.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFauna(String value) {
        this.fauna = value;
    }

    /**
     * Obtient la valeur de la propriété flora.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlora() {
        return flora;
    }

    /**
     * Définit la valeur de la propriété flora.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlora(String value) {
        this.flora = value;
    }

}
