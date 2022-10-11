/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class PRQuadTree {
    /**
     * public value to hand off instances
     */
    public static final FlyWeight FLYWEIGHT = FlyWeight.getInstance();
    private PRNode base;

    /**
     * default PRQuadTree constructor
     */
    public PRQuadTree() {
        base = PRQuadTree.FLYWEIGHT;
    }


    /**
     * inserts a new point
     * 
     * @param p
     */
    public void insert(Point1 pointer) {
        if (pointer == null)
            return;
        base = base.insert(0, 0, 1024, pointer);
    }

    /**
     * removes a point
     * @param p1 point being removed
     * @param name if removing by name
     * @return removed point
     */
    public Point1 remove(Point1 p1, boolean name) {
        Point1 output = base.remove(0, 0, 1024, p1, name);
        base = base.adjustTree(0, 0, 1024);
        return output;
    }
    /**
     * dumps the nodes in the tree
     */
    public void dump() {
        System.out.println("QuadTree dump:");
        System.out.println(base.dump(0, 0, 1024, 0)
            + " quadtree nodes printed");
    }


    /**
     * finds the dupes
     */
    public void duplicates() {
        base.duplicates();
    }




}
