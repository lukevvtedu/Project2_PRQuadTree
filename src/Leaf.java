/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class Leaf implements PRNode {

    private PointList pl;

    /**
     * default constructor for the leaf class
     */
    public Leaf() {
        pl = new PointList();
    }


    /**
     * secondary constructor for the leaf object
     * 
     * @param point
     *            point being added to the leaf
     */
    public Leaf(Point1 point) {
        pl = new PointList(point);
    }


    /**
     * dumps the current leaves
     */
    @Override
    public int dump(int x, int y, int w, int depth) {
        String blank = "";
        for (int i = 0; i < depth; i++)
            blank += "  ";
        String title = blank + "Node at " + x + ", " + y + ", " + w + ":";
        System.out.println(title);
        PointNode curr = pl.getHead();
        while (curr != null) {
            String out = blank + curr.getData().toString();
            System.out.println(out);
            curr = curr.getNext();
        }
        return 1;
    }


    /**
     * moves the tree
     */
    @Override
    public PRNode adjustTree(int x, int y, int w) {
        if (pl.getSize() >= 4 && !pl.onlyDuplicates()) {
            InternalAttributes base = new InternalAttributes();
            while (pl.getHead() != null) {
                base.insert(x, y, w, pl.removeHead());
            }
            return base;
        }
        else if (pl.getSize() == 0) {
            return PRQuadTree.FLYWEIGHT;
        }
        else {
            pl.resize();
            return this;
        }
    }


    /**
     * inserts a node into the tree
     */
    @Override
    public PRNode insert(int x, int y, int w, Point1 point) {
        pl.insert(point);
        return adjustTree(x, y, w);
    }


    /**
     * gets the data of the list
     */
    public PointList getData() {
        return pl;
    }


    /**
     * outputs the duplicates
     */
    @Override
    public void duplicates() {
        pl.outputDupes();
    }


    /**
     * removes a point from the tree then moves the tree
     */
    public Point1 remove(int x, int y, int w, Point1 rem, boolean name) {
        Point1 out = pl.remove(rem, name);
        adjustTree(x, y, w);
        return out;
    }


    /**
     * checks if the leaf is unique
     */
    public int getUnique() {
        return pl.getSize();
    }
}
