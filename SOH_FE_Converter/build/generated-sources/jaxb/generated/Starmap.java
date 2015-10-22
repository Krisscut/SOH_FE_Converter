//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.10.22 à 11:27:30 AM CEST 
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
 *         &lt;element ref="{}galaxy" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="empire" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "galaxy"
})
@XmlRootElement(name = "starmap")
public class Starmap {

    @XmlElement(required = true)
    protected List<Galaxy> galaxy;
    @XmlAttribute(name = "empire", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String empire;

    /**
     * Gets the value of the galaxy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the galaxy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGalaxy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Galaxy }
     * 
     * 
     */
    public List<Galaxy> getGalaxy() {
        if (galaxy == null) {
            galaxy = new ArrayList<Galaxy>();
        }
        return this.galaxy;
    }

    /**
     * Obtient la valeur de la propriété empire.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpire() {
        return empire;
    }

    /**
     * Définit la valeur de la propriété empire.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpire(String value) {
        this.empire = value;
    }

}
