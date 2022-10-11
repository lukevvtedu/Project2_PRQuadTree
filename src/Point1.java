/**
 * The default class for the point1 class
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class Point1 implements Comparable<Point1> {
    private int x;
    private int y;
    private String name;

    /**
     * constructor for the point1 object
     * 
     * @param pn
     *            name of the point
     * @param px
     *            x value of the point
     * @param py
     *            y value of the point
     */
    public Point1(String pn, int px, int py) {
        name = pn;
        x = px;
        y = py;
    }


    /**
     * sets the name to the node
     * 
     * @param pn
     *            name being set
     */
    public void setName(String pn) {
        name = pn;
    }


    /**
     * getter function for x
     * 
     * @return x value
     */
    public int getX() {
        return x;
    }


    /**
     * getter function for y
     * 
     * @return y value
     */
    public int getY() {
        return y;
    }


    /**
     * compares two values
     * 
     * @param p
     *            the point
     * @return the comapred val
     * 
     */
    public int compareTo(Point1 p) {
        if (this.x == p.getX()) {
            return p.getY() - this.y;
        }
        else
            return p.getX() - this.x;
    }


    /**
     * compares two objects
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Point1) {
            Point1 p = (Point1)o;
            return (this.x == p.getX() && this.y == p.getY());
        }
        return false;
    }


    /**
     * getter function for the name
     * 
     * @return name
     */
    String getName() {
        return name;
    }


    /**
     * converts to a string
     * 
     * @return the string
     */
    public String toString() {
        return "(" + name + ", " + x + ", " + y + ")";
    }


    /**
     * outputs the values of the point to a string
     * 
     * @return string of values
     */
    public String outputCoord() {
        return "(" + x + ", " + y + ")";
    }
}
