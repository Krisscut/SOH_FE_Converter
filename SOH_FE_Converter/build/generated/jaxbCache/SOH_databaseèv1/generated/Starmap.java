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
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="galaxy" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="sector" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="system" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="wormhole" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;attribute name="destX" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="destY" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="destZ" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="destSystemId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="polarity" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="explored" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="star" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="starId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="spectralClass" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="hab" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="shell" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="planet" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="geosphere" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                         &lt;attribute name="resourceZones" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="hydrosphere" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="surfaceLiquid" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="atmosphere" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="composition" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                                 &lt;element name="biosphere" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="fauna" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                         &lt;attribute name="flora" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="planetId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="bodyType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="systemId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="z" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="eod" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="sectorId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="z" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="empire" type="{http://www.w3.org/2001/XMLSchema}string" />
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

    protected List<Starmap.Galaxy> galaxy;
    @XmlAttribute(name = "empire")
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
     * {@link Starmap.Galaxy }
     * 
     * 
     */
    public List<Starmap.Galaxy> getGalaxy() {
        if (galaxy == null) {
            galaxy = new ArrayList<Starmap.Galaxy>();
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
     *         &lt;element name="sector" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="system" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="wormhole" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;attribute name="destX" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="destY" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="destZ" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="destSystemId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="polarity" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="explored" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="star" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="starId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="spectralClass" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="hab" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="shell" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="planet" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="geosphere" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                               &lt;attribute name="resourceZones" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="hydrosphere" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="surfaceLiquid" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="atmosphere" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="composition" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                       &lt;element name="biosphere" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="fauna" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                               &lt;attribute name="flora" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="planetId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="bodyType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="systemId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="z" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="eod" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="sectorId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="z" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "sector"
    })
    public static class Galaxy {

        protected List<Starmap.Galaxy.Sector> sector;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Gets the value of the sector property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sector property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSector().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Starmap.Galaxy.Sector }
         * 
         * 
         */
        public List<Starmap.Galaxy.Sector> getSector() {
            if (sector == null) {
                sector = new ArrayList<Starmap.Galaxy.Sector>();
            }
            return this.sector;
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
         * <p>Classe Java pour anonymous complex type.
         * 
         * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="system" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="wormhole" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;attribute name="destX" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="destY" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="destZ" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="destSystemId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="polarity" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="explored" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="star" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
         *                           &lt;/sequence>
         *                           &lt;attribute name="starId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="spectralClass" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="hab" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="shell" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="planet" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="geosphere" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                     &lt;attribute name="resourceZones" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="hydrosphere" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="surfaceLiquid" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="atmosphere" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="composition" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                             &lt;element name="biosphere" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="fauna" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                     &lt;attribute name="flora" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                           &lt;attribute name="planetId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="bodyType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="systemId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="z" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="eod" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="sectorId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="z" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "system"
        })
        public static class Sector {

            protected List<Starmap.Galaxy.Sector.System> system;
            @XmlAttribute(name = "sectorId")
            protected String sectorId;
            @XmlAttribute(name = "name")
            protected String name;
            @XmlAttribute(name = "x")
            protected String x;
            @XmlAttribute(name = "y")
            protected String y;
            @XmlAttribute(name = "z")
            protected String z;

            /**
             * Gets the value of the system property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the system property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSystem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Starmap.Galaxy.Sector.System }
             * 
             * 
             */
            public List<Starmap.Galaxy.Sector.System> getSystem() {
                if (system == null) {
                    system = new ArrayList<Starmap.Galaxy.Sector.System>();
                }
                return this.system;
            }

            /**
             * Obtient la valeur de la propriété sectorId.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSectorId() {
                return sectorId;
            }

            /**
             * Définit la valeur de la propriété sectorId.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSectorId(String value) {
                this.sectorId = value;
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
             * Obtient la valeur de la propriété x.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getX() {
                return x;
            }

            /**
             * Définit la valeur de la propriété x.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setX(String value) {
                this.x = value;
            }

            /**
             * Obtient la valeur de la propriété y.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getY() {
                return y;
            }

            /**
             * Définit la valeur de la propriété y.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setY(String value) {
                this.y = value;
            }

            /**
             * Obtient la valeur de la propriété z.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZ() {
                return z;
            }

            /**
             * Définit la valeur de la propriété z.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZ(String value) {
                this.z = value;
            }


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
             *         &lt;element name="wormhole" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;attribute name="destX" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="destY" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="destZ" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="destSystemId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="polarity" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="explored" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="star" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
             *                 &lt;/sequence>
             *                 &lt;attribute name="starId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="spectralClass" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="hab" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="shell" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="planet" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="geosphere" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
             *                           &lt;/sequence>
             *                           &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                           &lt;attribute name="resourceZones" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="hydrosphere" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
             *                           &lt;/sequence>
             *                           &lt;attribute name="surfaceLiquid" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="atmosphere" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
             *                           &lt;/sequence>
             *                           &lt;attribute name="composition" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                   &lt;element name="biosphere" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
             *                           &lt;/sequence>
             *                           &lt;attribute name="fauna" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                           &lt;attribute name="flora" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *                 &lt;attribute name="planetId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="bodyType" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="systemId" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="z" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="eod" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "wormhole",
                "star",
                "planet"
            })
            public static class System {

                protected List<Starmap.Galaxy.Sector.System.Wormhole> wormhole;
                protected List<Starmap.Galaxy.Sector.System.Star> star;
                protected List<Starmap.Galaxy.Sector.System.Planet> planet;
                @XmlAttribute(name = "systemId")
                protected String systemId;
                @XmlAttribute(name = "name")
                protected String name;
                @XmlAttribute(name = "x")
                protected String x;
                @XmlAttribute(name = "y")
                protected String y;
                @XmlAttribute(name = "z")
                protected String z;
                @XmlAttribute(name = "eod")
                protected String eod;

                /**
                 * Gets the value of the wormhole property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the wormhole property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getWormhole().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Starmap.Galaxy.Sector.System.Wormhole }
                 * 
                 * 
                 */
                public List<Starmap.Galaxy.Sector.System.Wormhole> getWormhole() {
                    if (wormhole == null) {
                        wormhole = new ArrayList<Starmap.Galaxy.Sector.System.Wormhole>();
                    }
                    return this.wormhole;
                }

                /**
                 * Gets the value of the star property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the star property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getStar().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Starmap.Galaxy.Sector.System.Star }
                 * 
                 * 
                 */
                public List<Starmap.Galaxy.Sector.System.Star> getStar() {
                    if (star == null) {
                        star = new ArrayList<Starmap.Galaxy.Sector.System.Star>();
                    }
                    return this.star;
                }

                /**
                 * Gets the value of the planet property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the planet property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getPlanet().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link Starmap.Galaxy.Sector.System.Planet }
                 * 
                 * 
                 */
                public List<Starmap.Galaxy.Sector.System.Planet> getPlanet() {
                    if (planet == null) {
                        planet = new ArrayList<Starmap.Galaxy.Sector.System.Planet>();
                    }
                    return this.planet;
                }

                /**
                 * Obtient la valeur de la propriété systemId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSystemId() {
                    return systemId;
                }

                /**
                 * Définit la valeur de la propriété systemId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSystemId(String value) {
                    this.systemId = value;
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
                 * Obtient la valeur de la propriété x.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getX() {
                    return x;
                }

                /**
                 * Définit la valeur de la propriété x.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setX(String value) {
                    this.x = value;
                }

                /**
                 * Obtient la valeur de la propriété y.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getY() {
                    return y;
                }

                /**
                 * Définit la valeur de la propriété y.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setY(String value) {
                    this.y = value;
                }

                /**
                 * Obtient la valeur de la propriété z.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getZ() {
                    return z;
                }

                /**
                 * Définit la valeur de la propriété z.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setZ(String value) {
                    this.z = value;
                }

                /**
                 * Obtient la valeur de la propriété eod.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEod() {
                    return eod;
                }

                /**
                 * Définit la valeur de la propriété eod.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEod(String value) {
                    this.eod = value;
                }


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
                 *         &lt;element name="geosphere" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *                 &lt;attribute name="resourceZones" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="hydrosphere" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="surfaceLiquid" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="atmosphere" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="composition" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *         &lt;element name="biosphere" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="fauna" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *                 &lt;attribute name="flora" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *       &lt;attribute name="planetId" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="bodyType" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="zone" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "geosphere",
                    "hydrosphere",
                    "atmosphere",
                    "biosphere"
                })
                public static class Planet {

                    protected List<Starmap.Galaxy.Sector.System.Planet.Geosphere> geosphere;
                    protected List<Starmap.Galaxy.Sector.System.Planet.Hydrosphere> hydrosphere;
                    protected List<Starmap.Galaxy.Sector.System.Planet.Atmosphere> atmosphere;
                    protected List<Starmap.Galaxy.Sector.System.Planet.Biosphere> biosphere;
                    @XmlAttribute(name = "planetId")
                    protected String planetId;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "bodyType")
                    protected String bodyType;
                    @XmlAttribute(name = "orbit")
                    protected String orbit;
                    @XmlAttribute(name = "zone")
                    protected String zone;

                    /**
                     * Gets the value of the geosphere property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the geosphere property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getGeosphere().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Starmap.Galaxy.Sector.System.Planet.Geosphere }
                     * 
                     * 
                     */
                    public List<Starmap.Galaxy.Sector.System.Planet.Geosphere> getGeosphere() {
                        if (geosphere == null) {
                            geosphere = new ArrayList<Starmap.Galaxy.Sector.System.Planet.Geosphere>();
                        }
                        return this.geosphere;
                    }

                    /**
                     * Gets the value of the hydrosphere property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the hydrosphere property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getHydrosphere().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Starmap.Galaxy.Sector.System.Planet.Hydrosphere }
                     * 
                     * 
                     */
                    public List<Starmap.Galaxy.Sector.System.Planet.Hydrosphere> getHydrosphere() {
                        if (hydrosphere == null) {
                            hydrosphere = new ArrayList<Starmap.Galaxy.Sector.System.Planet.Hydrosphere>();
                        }
                        return this.hydrosphere;
                    }

                    /**
                     * Gets the value of the atmosphere property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the atmosphere property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getAtmosphere().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Starmap.Galaxy.Sector.System.Planet.Atmosphere }
                     * 
                     * 
                     */
                    public List<Starmap.Galaxy.Sector.System.Planet.Atmosphere> getAtmosphere() {
                        if (atmosphere == null) {
                            atmosphere = new ArrayList<Starmap.Galaxy.Sector.System.Planet.Atmosphere>();
                        }
                        return this.atmosphere;
                    }

                    /**
                     * Gets the value of the biosphere property.
                     * 
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the biosphere property.
                     * 
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getBiosphere().add(newItem);
                     * </pre>
                     * 
                     * 
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link Starmap.Galaxy.Sector.System.Planet.Biosphere }
                     * 
                     * 
                     */
                    public List<Starmap.Galaxy.Sector.System.Planet.Biosphere> getBiosphere() {
                        if (biosphere == null) {
                            biosphere = new ArrayList<Starmap.Galaxy.Sector.System.Planet.Biosphere>();
                        }
                        return this.biosphere;
                    }

                    /**
                     * Obtient la valeur de la propriété planetId.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPlanetId() {
                        return planetId;
                    }

                    /**
                     * Définit la valeur de la propriété planetId.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPlanetId(String value) {
                        this.planetId = value;
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
                     * Obtient la valeur de la propriété bodyType.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getBodyType() {
                        return bodyType;
                    }

                    /**
                     * Définit la valeur de la propriété bodyType.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setBodyType(String value) {
                        this.bodyType = value;
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
                     * Obtient la valeur de la propriété zone.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getZone() {
                        return zone;
                    }

                    /**
                     * Définit la valeur de la propriété zone.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setZone(String value) {
                        this.zone = value;
                    }


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
                     *         &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                     *       &lt;/sequence>
                     *       &lt;attribute name="composition" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                    public static class Atmosphere {

                        protected List<Resource> resource;
                        @XmlAttribute(name = "composition")
                        protected String composition;

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
                         * Obtient la valeur de la propriété composition.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getComposition() {
                            return composition;
                        }

                        /**
                         * Définit la valeur de la propriété composition.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setComposition(String value) {
                            this.composition = value;
                        }

                    }


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
                     *         &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                     *       &lt;/sequence>
                     *       &lt;attribute name="fauna" type="{http://www.w3.org/2001/XMLSchema}string" />
                     *       &lt;attribute name="flora" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                    public static class Biosphere {

                        protected List<Resource> resource;
                        @XmlAttribute(name = "fauna")
                        protected String fauna;
                        @XmlAttribute(name = "flora")
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
                     *         &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                     *       &lt;/sequence>
                     *       &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
                     *       &lt;attribute name="resourceZones" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                    public static class Geosphere {

                        protected List<Resource> resource;
                        @XmlAttribute(name = "diameter")
                        protected String diameter;
                        @XmlAttribute(name = "resourceZones")
                        protected String resourceZones;

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
                         * Obtient la valeur de la propriété resourceZones.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        public String getResourceZones() {
                            return resourceZones;
                        }

                        /**
                         * Définit la valeur de la propriété resourceZones.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *     
                         */
                        public void setResourceZones(String value) {
                            this.resourceZones = value;
                        }

                    }


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
                     *         &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                     *       &lt;/sequence>
                     *       &lt;attribute name="surfaceLiquid" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                    public static class Hydrosphere {

                        protected List<Resource> resource;
                        @XmlAttribute(name = "surfaceLiquid")
                        protected String surfaceLiquid;

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

                }


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
                 *         &lt;element ref="{}resource" maxOccurs="unbounded" minOccurs="0"/>
                 *       &lt;/sequence>
                 *       &lt;attribute name="starId" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="orbit" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="spectralClass" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="size" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="hab" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="shell" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="diameter" type="{http://www.w3.org/2001/XMLSchema}string" />
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
                public static class Star {

                    protected List<Resource> resource;
                    @XmlAttribute(name = "starId")
                    protected String starId;
                    @XmlAttribute(name = "name")
                    protected String name;
                    @XmlAttribute(name = "orbit")
                    protected String orbit;
                    @XmlAttribute(name = "spectralClass")
                    protected String spectralClass;
                    @XmlAttribute(name = "size")
                    protected String size;
                    @XmlAttribute(name = "hab")
                    protected String hab;
                    @XmlAttribute(name = "shell")
                    protected String shell;
                    @XmlAttribute(name = "diameter")
                    protected String diameter;

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

                }


                /**
                 * <p>Classe Java pour anonymous complex type.
                 * 
                 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;attribute name="destX" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="destY" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="destZ" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="destSystemId" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="polarity" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="explored" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Wormhole {

                    @XmlAttribute(name = "destX")
                    protected String destX;
                    @XmlAttribute(name = "destY")
                    protected String destY;
                    @XmlAttribute(name = "destZ")
                    protected String destZ;
                    @XmlAttribute(name = "destSystemId")
                    protected String destSystemId;
                    @XmlAttribute(name = "polarity")
                    protected String polarity;
                    @XmlAttribute(name = "explored")
                    protected String explored;

                    /**
                     * Obtient la valeur de la propriété destX.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDestX() {
                        return destX;
                    }

                    /**
                     * Définit la valeur de la propriété destX.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDestX(String value) {
                        this.destX = value;
                    }

                    /**
                     * Obtient la valeur de la propriété destY.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDestY() {
                        return destY;
                    }

                    /**
                     * Définit la valeur de la propriété destY.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDestY(String value) {
                        this.destY = value;
                    }

                    /**
                     * Obtient la valeur de la propriété destZ.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getDestZ() {
                        return destZ;
                    }

                    /**
                     * Définit la valeur de la propriété destZ.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setDestZ(String value) {
                        this.destZ = value;
                    }

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

                }

            }

        }

    }

}
