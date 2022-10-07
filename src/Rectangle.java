/**
 * 
 * @author oehlingr19 and lukev
 * @version 1
 * 
 *          creates the Rectangle class
 * 
 */
public class Rectangle {

    private int rx;
    private int ry;
    private int rw;
    private int rh;
    private String name;

    /**
     * Default constructor for rectangle objects
     * 
     * @param name
     *            The name of the rectangle
     * @param x
     *            The x Position of the rectangle
     * @param y
     *            The y Position of the rectangle
     * @param w
     *            The width of the rectangle
     * @param h
     *            The height of the rectangle
     */
    public Rectangle(String name, int x, int y, int w, int h) {
        this.rx = x;
        this.ry = y;
        this.rh = h;
        this.rw = w;
        this.name = name;
    }


    /**
     * getter function for names
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }


    /**
     * getter function for x position
     * 
     * @return x position
     */
    public int xPos() {
        return this.rx;
    }


    /**
     * getter function for y position
     * 
     * @return y position
     */
    public int yPos() {
        return this.ry;
    }


    /**
     * getter function for width
     * 
     * @return the width
     */
    public int getW() {
        return this.rw;
    }


    /**
     * getter function for height
     * 
     * @return the height
     */
    public int getH() {
        return this.rh;
    }


    /**
     * sets rectangle values to a string value
     * 
     * @return the rectangle values in a string
     */
    public String toString() {
        return name + ", " + rx + ", " + ry + ", " + rw + ", " + rh;
    }


    /**
     * checker to make sure created variables are equal to real variables
     * 
     * @param o
     *            A rectangle object
     * @return the values of a rectangle are consistent
     */
    public boolean equals(Object o) {
        int x = ((Rectangle)o).xPos();
        int y = ((Rectangle)o).yPos();
        int w = ((Rectangle)o).getW();
        int h = ((Rectangle)o).getH();
        if (this.rx == x && this.ry == y && this.rw == w && this.rh == h) {
            return true;
        }
        else {
            return false;
        }
    }
}
