/**
 * interface for the PRNode
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public interface PRNode {

    /**
     * dumps the nodes
     * 
     * @param x
     *            x value
     * @param y
     *            y value
     * @param w
     *            width
     * @param d
     *            depth
     * @return dump file
     */
    public int dump(int x, int y, int w, int d);


    /**
     * inserts a node
     * 
     * @param x
     *            x value
     * @param y
     *            y value
     * @param w
     *            width
     * @param p
     *            new point being inserted
     * @return inserted point
     */
    public PRNode insert(int x, int y, int w, Point1 p);


    /**
     * adjusts the tree
     * 
     * @param x
     *            x value
     * @param y
     *            y value
     * @param w
     *            width
     * @return adjusted tree
     */
    public PRNode adjustTree(int x, int y, int w);


    /**
     * gets the data
     * 
     * @return data
     */
    public PointList getData();


    /**
     * checks for dupes
     */
    public void duplicates();


    /**
     * removes a point
     * 
     * @param x
     *            x value
     * @param y
     *            y value
     * @param w
     *            width
     * @param rem
     *            removed node
     * @param name
     *            if removing by name
     * @return removed point
     */
    public Point1 remove(int x, int y, int w, Point1 rem, boolean name);


    /**
     * returns unique values
     * 
     * @return values
     */
    public int getUnique();

}
