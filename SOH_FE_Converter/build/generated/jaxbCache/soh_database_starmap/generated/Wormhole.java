//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.10.06 à 02:17:29 PM CEST 
//


package generated;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="destSystemId" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="destX" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="destY" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="destZ" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="explored" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="polarity" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "wormhole")
public class Wormhole {

    @XmlAttribute(name = "destSystemId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String destSystemId;
    @XmlAttribute(name = "destX", required = true)
    protected BigDecimal destX;
    @XmlAttribute(name = "destY", required = true)
    protected BigDecimal destY;
    @XmlAttribute(name = "destZ", required = true)
    protected BigDecimal destZ;
    @XmlAttribute(name = "explored")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String explored;
    @XmlAttribute(name = "polarity", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String polarity;

    /**
     * Obtient la valeur de la propriété destSystemId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestSystemId() {
        return destSystemId;
    }

    /**
     * Définit la valeur de la propriété destSystemId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestSystemId(String value) {
        this.destSystemId = value;
    }

    /**
     * Obtient la valeur de la propriété destX.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDestX() {
        return destX;
    }

    /**
     * Définit la valeur de la propriété destX.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDestX(BigDecimal value) {
        this.destX = value;
    }

    /**
     * Obtient la valeur de la propriété destY.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDestY() {
        return destY;
    }

    /**
     * Définit la valeur de la propriété destY.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDestY(BigDecimal value) {
        this.destY = value;
    }

    /**
     * Obtient la valeur de la propriété destZ.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDestZ() {
        return destZ;
    }

    /**
     * Définit la valeur de la propriété destZ.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDestZ(BigDecimal value) {
        this.destZ = value;
    }

    /**
     * Obtient la valeur de la propriété explored.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExplored() {
        return explored;
    }

    /**
     * Définit la valeur de la propriété explored.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExplored(String value) {
        this.explored = value;
    }

    /**
     * Obtient la valeur de la propriété polarity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolarity() {
        return polarity;
    }

    /**
     * Définit la valeur de la propriété polarity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolarity(String value) {
        this.polarity = value;
    }

}
