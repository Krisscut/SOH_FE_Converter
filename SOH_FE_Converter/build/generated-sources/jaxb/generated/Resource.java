//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.10.06 à 02:17:29 PM CEST 
//


package generated;

import java.math.BigInteger;
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
 *       &lt;attribute name="abundance" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="abundanceZone1" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="abundanceZone2" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="abundanceZone3" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="quality" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="qualityZone1" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="qualityZone2" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="qualityZone3" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "resource")
public class Resource {

    @XmlAttribute(name = "abundance")
    protected BigInteger abundance;
    @XmlAttribute(name = "abundanceZone1")
    protected BigInteger abundanceZone1;
    @XmlAttribute(name = "abundanceZone2")
    protected BigInteger abundanceZone2;
    @XmlAttribute(name = "abundanceZone3")
    protected BigInteger abundanceZone3;
    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "quality")
    protected BigInteger quality;
    @XmlAttribute(name = "qualityZone1")
    protected BigInteger qualityZone1;
    @XmlAttribute(name = "qualityZone2")
    protected BigInteger qualityZone2;
    @XmlAttribute(name = "qualityZone3")
    protected BigInteger qualityZone3;

    /**
     * Obtient la valeur de la propriété abundance.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAbundance() {
        return abundance;
    }

    /**
     * Définit la valeur de la propriété abundance.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAbundance(BigInteger value) {
        this.abundance = value;
    }

    /**
     * Obtient la valeur de la propriété abundanceZone1.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAbundanceZone1() {
        return abundanceZone1;
    }

    /**
     * Définit la valeur de la propriété abundanceZone1.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAbundanceZone1(BigInteger value) {
        this.abundanceZone1 = value;
    }

    /**
     * Obtient la valeur de la propriété abundanceZone2.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAbundanceZone2() {
        return abundanceZone2;
    }

    /**
     * Définit la valeur de la propriété abundanceZone2.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAbundanceZone2(BigInteger value) {
        this.abundanceZone2 = value;
    }

    /**
     * Obtient la valeur de la propriété abundanceZone3.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAbundanceZone3() {
        return abundanceZone3;
    }

    /**
     * Définit la valeur de la propriété abundanceZone3.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAbundanceZone3(BigInteger value) {
        this.abundanceZone3 = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété quality.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQuality() {
        return quality;
    }

    /**
     * Définit la valeur de la propriété quality.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQuality(BigInteger value) {
        this.quality = value;
    }

    /**
     * Obtient la valeur de la propriété qualityZone1.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQualityZone1() {
        return qualityZone1;
    }

    /**
     * Définit la valeur de la propriété qualityZone1.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQualityZone1(BigInteger value) {
        this.qualityZone1 = value;
    }

    /**
     * Obtient la valeur de la propriété qualityZone2.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQualityZone2() {
        return qualityZone2;
    }

    /**
     * Définit la valeur de la propriété qualityZone2.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQualityZone2(BigInteger value) {
        this.qualityZone2 = value;
    }

    /**
     * Obtient la valeur de la propriété qualityZone3.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getQualityZone3() {
        return qualityZone3;
    }

    /**
     * Définit la valeur de la propriété qualityZone3.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setQualityZone3(BigInteger value) {
        this.qualityZone3 = value;
    }

}
