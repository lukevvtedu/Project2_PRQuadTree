/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class InternalAttributes implements PRNode {

    private PRNode northEast;
    private PRNode southEast;
    private PRNode southWest;
    private PRNode northWest;

    /**
     * constructor for InternalAttributes
     */
    public InternalAttributes() {
        northEast = PRQuadTree.FLYWEIGHT;
        northWest = PRQuadTree.FLYWEIGHT;
        southEast = PRQuadTree.FLYWEIGHT;
        southWest = PRQuadTree.FLYWEIGHT;
    }


    /**
     * inserts a node
     */
    @Override
    public PRNode insert(int x, int y, int w, Point1 point) {
        if (point.getX() < x + w / 2)
            if (point.getY() < y + w / 2)
                northWest = northWest.insert(x, y, w / 2, point);
            else
                southWest = southWest.insert(x, y + w / 2, w / 2, point);
        else if (point.getY() < y + w / 2)
            northEast = northEast.insert(x + w / 2, y, w / 2, point);
        else
            southEast = southEast.insert(x + w / 2, y + w / 2, w / 2, point);
        return this;
    }


    private int removeEmpty() {
        int nw = northWest.getUnique();
        int ne = northEast.getUnique();
        int sw = southWest.getUnique();
        int se = southEast.getUnique();
        return nw + ne + sw + se;
    }


    /**
     * adjusts the tree
     */
    @Override
    public PRNode adjustTree(int x, int y, int w) {
        northWest = northWest.adjustTree(x, y, w / 2);
        southWest = southWest.adjustTree(x, y + w / 2, w / 2);
        northEast = northEast.adjustTree(x + w / 2, y, w / 2);
        southEast = southEast.adjustTree(x + w / 2, y + w / 2, w / 2);
        int u = removeEmpty();
        if (u == 0) {
            return PRQuadTree.FLYWEIGHT;
        }
        else if (u < 4) {
            Leaf leaf = new Leaf();
            while (northWest.getData() != null && northWest.getData()
                .getHead() != null)
                leaf.insert(x, y, w, northWest.getData().removeHead());
            while (northEast.getData() != null && northEast.getData()
                .getHead() != null)
                leaf.insert(x, y, w, northEast.getData().removeHead());
            while (southWest.getData() != null && southWest.getData()
                .getHead() != null)
                leaf.insert(x, y, w, southWest.getData().removeHead());
            while (southEast.getData() != null && southEast.getData()
                .getHead() != null)
                leaf.insert(x, y, w, southEast.getData().removeHead());
            return leaf.adjustTree(x, y, w);
        }
        else {
            return this;
        }
    }


    @Override
    /**
     * dumps the nodes
     */
    public int dump(int x, int y, int w, int d) {
        String s = "";
        for (int i = 0; i < d; i++) {
            s += "  ";
        }
        s += "Node at " + x + ", " + y + ", " + w + ": Internal";
        System.out.println(s);
        int nd = d + 1;
        return 1 + northWest.dump(x, y, w / 2, nd) + northEast.dump(x + w / 2,
            y, w / 2, nd) + southWest.dump(x, y + w / 2, w / 2, nd) + southEast
                .dump(x + w / 2, y + w / 2, w / 2, nd);

    }


    /**
     * gets the data stores in the list
     */
    @Override
    public PointList getData() {
        return null;
    }


    /**
     * checks for duplicates
     */
    @Override
    public void duplicates() {
        northEast.duplicates();
        northWest.duplicates();
        southWest.duplicates();
        southEast.duplicates();
    }


    /**
     * removes a node based on its region
     * 
     * @param x
     *            x val
     * @param y
     *            y val
     * @param w
     *            width
     * @param point
     *            point
     * @param name
     *            if name
     * @return point 1
     */
    public Point1 remove(int x, int y, int w, Point1 point, boolean name) {
        Point1 p1 = null;
        if (point.getX() < x + w / 2)
            if (point.getY() < y + w / 2) {
                p1 = northWest.remove(x, y, w / 2, point, name);
            }
            else {
                p1 = southWest.remove(x, y + w / 2, w / 2, point, name);
            }
        else if (point.getY() < y + w / 2) {
            p1 = northEast.remove(x + w / 2, y, w / 2, point, name);
        }
        else {
            p1 = southEast.remove(x + w / 2, y + w / 2, w / 2, point, name);
        }
        return p1;
    }


    /**
     * returns the number of children
     * 
     * @return 4
     */
    public int getUnique() {
        return 4;
    }
}
