public interface PRNode
{

    /**
     * 
     * outputs the value of the node, then recurses to the next node if it is an
     * internal node
     * 
     * @param x
     *            - x coordinate of the top left corner of the current region
     * @param y
     *            - y coordinate of the top left corner of the current region
     * @param width
     *            - width of the current region
     * @param depth
     *            - depth of the current node, relative to the root (0)
     * @return the number of nodes visited
     */
    public int dump(int x, int y, int width, int depth);

    /**
     * inserts a new Point to the QuadTree; recurses down internal nodes and
     * stops at leaf nodes
     * 
     * @param x
     *            - x coordinate of the top left corner of the current region
     * @param y
     *            - y coordinate of the top left corner of the current region
     * @param width
     *            - width of the current region
     * @param newPoint
     *            - Point that is being added to the list
     * @return the root of the subtree after the tree has been traversed
     */
    public PRNode insert(int x, int y, int width, Point2 newPoint);

    /**
     * fixes the tree after removal of a point
     * @param x the x point to look for
     * @param y the y point to look for
     * @param width the width of adjustment
     * @return the node that was adjusted
     */
    public PRNode adjustTree(int x, int y, int width);
    /**
     * getter for the data stored in the node
     * 
     * @return data in the node
     */
    public PointList getData();
    /**
     * looks for duplicate points
     */
    public void duplicates();
    /**
     * removes a point
     * @param x is the x point to look for
     * @param y the y point to look for
     * @param width the width of search
     * @param removePoint what point to remove
     * @param byName whether the name is necessary for SkipList
     * @return the node that is removed
     */
    public Point2 remove(int x, int y, int width, Point2 removePoint, 
            boolean byName);
    
    /**
     * @return whether a node is unique
     */
    public int getUnique();

}