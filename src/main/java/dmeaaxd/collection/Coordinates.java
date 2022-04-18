package dmeaaxd.collection;

/**
 * Organization coordinates.
 */

public class Coordinates {
    private int x;
    /**
     * Maximum field value: 422
     */
    private double y;

    public Coordinates(Integer x, Double y) {
        setX(x);
        setY(y);
    }

    @Override
    public String toString(){
        return "   x = " + this.x + "\n" + "   y = " + this.y + "\n";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
