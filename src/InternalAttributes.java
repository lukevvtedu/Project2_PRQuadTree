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


    @Override
    /**
     * 
     */
    public int dump(int x, int y, int width, int depth) {
        String s = "";
        for (int i = 0; i < depth; i++) {
            s += "  ";
        }
        s += "Node at " + x + ", " + y + ", " + width + ": Internal";
        System.out.println(s);
        int nd = depth + 1;
        return 1 + northWest.dump(x, y, width / 2, nd) + northEast.dump(x
            + width / 2, y, width / 2, nd) + southWest.dump(x, y + width
                / 2, width / 2, nd) + southEast.dump(x + width / 2, y
                    + width / 2, width / 2, nd);

    }


    /**
     * insert a new Point in a child of the current internal node; recursive in
     * that it will continue following internal nodes if the child chosen is
     * internal, otherwise the function will end when it reaches a leaf
     * 
     * @param x
     *            - x coordinate of the top left corner of the current region
     * @param y
     *            - y coordinate of the top left corner of the current region
     * @param width
     *            - width of the current region
     * @param point
     *            - Point that will be added to the tree
     * @return the root of the subtree that is changed after insert
     */
    @Override
    public PRNode insert(int x, int y, int width, Point1 point) {
        if (point.getX() < x + width / 2)
            if (point.getY() < y + width / 2)
                northWest = northWest.insert(x, y, width / 2, point);
            else
                southWest = southWest.insert(x, y + width / 2, width / 2,
                    point);
        else if (point.getY() < y + width / 2)
            northEast = northEast.insert(x + width / 2, y, width / 2, point);
        else
            southEast = southEast.insert(x + width / 2, y + width / 2, width
                / 2, point);
        return this;
    }


    /**
     * gets the data stored in the internal node; which is null because the
     * internal node stores no information except pointers to its children
     * 
     * @return null because there is no data in the internal node
     */
    @Override
    public PointList getData() {
        return null;
    }


    @Override
    public void duplicates() {
        northEast.duplicates();
        northWest.duplicates();
        southWest.duplicates();
        southEast.duplicates();
    }

    public Point1 remove(
        int x,
        int y,
        int width,
        Point1 point,
        boolean name) {
        Point1 p1 = null;
        if (point.getX() < x + width / 2)
            if (point.getY() < y + width / 2) {
                p1 = northWest.remove(x, y, width / 2, point,
                    name);
            }
            else {
                p1 = southWest.remove(x, y + width / 2, width / 2,
                    point, name);
            }
        else if (point.getY() < y + width / 2) {
            p1 = northEast.remove(x + width / 2, y, width / 2,
                point, name);
        }
        else {
            p1 = southEast.remove(x + width / 2, y + width / 2, width
                / 2, point, name);
        }
        return p1;
    }

    private int removeEmpty() {
        int nw = northWest.getUnique();
        int ne = northEast.getUnique();
        int sw = southWest.getUnique();
        int se = southEast.getUnique();
        return nw + ne + sw + se;
    }


    @Override
    public PRNode adjustTree(int x, int y, int width) {
        northWest = northWest.adjustTree(x, y, width / 2);
        southWest = southWest.adjustTree(x, y + width / 2, width / 2);
        northEast = northEast.adjustTree(x + width / 2, y, width / 2);
        southEast = southEast.adjustTree(x + width / 2, y + width / 2, width
            / 2);
        int u = removeEmpty();
        if (u == 0) {
            return PRQuadTree.FLYWEIGHT;
        }
        else if (u < 4) {
            Leaf leaf = new Leaf();
            while (northWest.getData() != null && northWest.getData()
                .getHead() != null)
                leaf.insert(x, y, width, northWest.getData().removeHead());
            while (northEast.getData() != null && northEast.getData()
                .getHead() != null)
                leaf.insert(x, y, width, northEast.getData().removeHead());
            while (southWest.getData() != null && southWest.getData()
                .getHead() != null)
                leaf.insert(x, y, width, southWest.getData().removeHead());
            while (southEast.getData() != null && southEast.getData()
                .getHead() != null)
                leaf.insert(x, y, width, southEast.getData().removeHead());
            return leaf.adjustTree(x, y, width);
        }
        else {
            return this;
        }
    }


    /**
     * @return the number of children -- 4
     */
    public int getUnique() {
        return 4;
    }
}
