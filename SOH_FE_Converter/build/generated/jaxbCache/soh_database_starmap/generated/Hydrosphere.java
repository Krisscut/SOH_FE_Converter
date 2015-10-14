//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.10.14 à 11:11:20 AM CEST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{}resource" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="surfaceLiquid" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
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
@XmlRootElement(name = "hydrosphere")
public class Hydrosphere {

    protected Resource resource;
    @XmlAttribute(name = "surfaceLiquid", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String surfaceLiquid;

    /**
     * Obtient la valeur de la propriété resource.
     * 
     * @return
     *     possible object is
     *     {@link Resource }
     *     
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Définit la valeur de la propriété resource.
     * 
     * @param value
     *     allowed object is
     *     {@link Resource }
     *     
     */
    public void setResource(Resource value) {
        this.resource = value;
    }

    /**
     * Obtient la valeur de la propriété surfaceLiquid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurfaceLiquid() {
        return surfaceLiquid;
    }

    /**
     * Définit la valeur de la propriété surfaceLiquid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurfaceLiquid(String value) {
        this.surfaceLiquid = value;
    }

}
