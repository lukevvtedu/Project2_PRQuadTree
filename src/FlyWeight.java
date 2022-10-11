
/**
 * The default class for the flyweight class
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class FlyWeight implements PRNode {

    private static FlyWeight type = new FlyWeight();

    /**
     * placeholder flyweight
     */
    private FlyWeight() {
    }


    /**
     * gets the type of the flyweight
     * 
     * @return type of the flyweight
     */
    public static FlyWeight getInstance() {
        return type;
    }


    /**
     * gives the dump list of current items
     */
    @Override
    public int dump(int x, int y, int w, int depth) {
        String blank = "";
        for (int i = 0; i < depth; i++) {
            blank += "  ";
        }
        System.out.println(blank + "Node at " + x + ", " + y + ", " + w
            + ": Empty");
        return 1;
    }


    /**
     * inserts a leaf to the ndoe
     */
    @Override
    public PRNode insert(int x, int y, int w, Point1 p1) {
        Leaf leaf = new Leaf(p1);
        return leaf;
    }


    /**
     * gets the data of the list
     */
    @Override
    public PointList getData() {
        return null;
    }


    /**
     * function to help hand off the duplicates function
     */
    @Override
    public void duplicates() {
    }


    /**
     * function to help remove a point
     */
    @Override
    public Point1 remove(int x, int y, int w, Point1 point, boolean byName) {
        return null;
    }


    /**
     * function to help adjust the tree
     */
    @Override
    public PRNode adjustTree(int x, int y, int w) {
        return this;
    }


    /**
     * checks to see if point is unique
     */
    public int getUnique() {
        return 0;
    }

}
