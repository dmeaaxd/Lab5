package dmeaaxd.collection;

/**
 * Part of the Organization structure.
 */

public class Car {
    /**
     * Field cannot be null
     */
    private boolean cool;

    public Car(Boolean car) {
        setCool(car);
    }

    @Override
    public String toString(){
        return "car = " + this.cool + "\n";
    }

    public boolean isCool() {
        return cool;
    }

    public void setCool(boolean cool) {
        this.cool = cool;
    }
}
