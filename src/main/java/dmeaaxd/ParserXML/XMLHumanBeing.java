package dmeaaxd.ParserXML;

import org.simpleframework.xml.*;

@Root(name = "HumanBeing")

/*
  This class is needed in order to get all the HumanBeing values
 */

public class XMLHumanBeing {

    @Attribute
    private String id;
    @Element(name = "name")
    private String name;
    @Element(name = "creationDate")
    private String creationDate;

    @Element(name = "realHero")
    private String realHero;
    @Element(name = "hasToothpick")
    private String hasToothpick;
    @Element(name = "impactSpeed")
    private String impactSpeed;
    @Element(name = "weaponType")
    private String weaponType;
    @Element(name = "mood")
    private String mood;
    @Element(name = "car")
    private String car;
    @Element(name = "coordinates")
    private XMLCoordinates coordinates;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getRealHero() {
        return realHero;
    }

    public String getHasToothpick() {
        return hasToothpick;
    }

    public String getImpactSpeed() {
        return impactSpeed;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public String getMood() {
        return mood;
    }

    public String getCar() {
        return car;
    }

    public XMLCoordinates getCoordinates() {
        return coordinates;
    }
}