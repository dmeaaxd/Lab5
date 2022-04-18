package dmeaaxd.collection;

import java.util.Date;

/**
 * Data storage structure
 */

public class HumanBeing implements java.lang.Comparable<HumanBeing> {
    /**
     * The field cannot be null, The field value must be greater than 0, The value of this field must be unique, The value of this field must be generated automatically
     */
    private Long id;
    /**
     * Field cannot be null, String cannot be empty
     */
    private String name;
    /**
     * Field cannot be null
     */
    private Coordinates coordinates;
    /**
     * The field cannot be null, the value of this field must be generated automatically
     */
    private java.util.Date creationDate;
    /**
     * Field cannot be null
     */
    private Boolean realHero;
    /**
     * Field can be null
     */
    private Boolean hasToothpick;
    /**
     * Maximum field value: 782
     */
    private long impactSpeed;
    /**
     * Field cannot be null
     */
    private WeaponType weaponType;
    /**
     * Field cannot be null
     */
    private Mood mood;
    /**
     * Field cannot be null
     */
    private Car car;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public long getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(long impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public HumanBeing(Long id, String name, Coordinates coordinates, Date creationDate, Boolean realHero, Boolean hasToothpick, Long impactSpeed, WeaponType weaponType, Mood mood, Car car){
        this.creationDate = new java.util.Date();
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.weaponType = weaponType;
        this.mood = mood;
        this.car = car;
    }

    @Override
    public int compareTo(HumanBeing o) {
        if (this == o)
            return 0;
        if (o == null || getClass() != o.getClass())
            return -1;

        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_RESET = "\u001B[0m";
        return ANSI_BLUE + "===============" + ANSI_BLUE +
                ANSI_RESET +"\n"+"id = "+id+"\n"+
                "name = "+name+"\n"+
                "coordinates:" + "\n" +
                coordinates.toString() +
                "creationDate = "+creationDate+"\n"+
                "realHero = "+realHero+"\n"+
                "hasToothPick = "+hasToothpick+"\n"+
                "impactSpeed = "+impactSpeed+"\n"+
                "weaponType = "+weaponType+"\n"+
                "mood = "+mood+"\n"+
                car.toString() + ANSI_RESET +
                ANSI_BLUE + "===============" + ANSI_BLUE;
    }
}
