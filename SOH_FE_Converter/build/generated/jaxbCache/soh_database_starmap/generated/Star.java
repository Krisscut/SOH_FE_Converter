//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.5-2 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2015.10.19 à 05:23:28 PM CEST 
//


package generated;

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
 *         &lt;element ref="{}resource"/>
 *       &lt;/sequence>
 *       &lt;attribute name="diameter" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="hab" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="orbit" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="shell" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="spectralClass" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="starId" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
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
@XmlRootElement(name = "star")
public class Star {

    @XmlElement(required = true)
    protected Resource resource;
    @XmlAttribute(name = "diameter", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String diameter;
    @XmlAttribute(name = "hab", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String hab;
    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "orbit", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String orbit;
    @XmlAttribute(name = "shell", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String shell;
    @XmlAttribute(name = "size", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String size;
    @XmlAttribute(name = "spectralClass")
    @XmlSchemaType(name = "anySimpleType")
    protected String spectralClass;
    @XmlAttribute(name = "starId", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String starId;

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
     * Obtient la valeur de la propriété diameter.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiameter() {
        return diameter;
    }

    /**
     * Définit la valeur de la propriété diameter.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiameter(String value) {
        this.diameter = value;
    }

    /**
     * Obtient la valeur de la propriété hab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHab() {
        return hab;
    }

    /**
     * Définit la valeur de la propriété hab.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHab(String value) {
        this.hab = value;
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
     * Obtient la valeur de la propriété orbit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrbit() {
        return orbit;
    }

    /**
     * Définit la valeur de la propriété orbit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrbit(String value) {
        this.orbit = value;
    }

    /**
     * Obtient la valeur de la propriété shell.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShell() {
        return shell;
    }

    /**
     * Définit la valeur de la propriété shell.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShell(String value) {
        this.shell = value;
    }

    /**
     * Obtient la valeur de la propriété size.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSize() {
        return size;
    }

    /**
     * Définit la valeur de la propriété size.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSize(String value) {
        this.size = value;
    }

    /**
     * Obtient la valeur de la propriété spectralClass.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpectralClass() {
        return spectralClass;
    }

    /**
     * Définit la valeur de la propriété spectralClass.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpectralClass(String value) {
        this.spectralClass = value;
    }

    /**
     * Obtient la valeur de la propriété starId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStarId() {
        return starId;
    }

    /**
     * Définit la valeur de la propriété starId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStarId(String value) {
        this.starId = value;
    }

}
