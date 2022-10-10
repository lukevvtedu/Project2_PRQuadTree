/**
 * Leaf node for the PR-QuadTree. Only node to contain data; contains a
 * linkedlist of Points
 * 
 * @author Preston Lattimer (platt) Jonathan DeFreeuw (jondef95)
 * @version 1
 *
 */
public class Leaf implements PRNode
{
    /**
     * linkedlist of Points stored in the leaf node
     */
    private PointList data;

    /**
     * creates a quadleaf
     */
    public Leaf()
    {
        data = new PointList();
    }

    /**
     * standard constructor for the leaf; when a leaf is created, it will have
     * data stored into it, so a new Point is inserted and a new LinkedList is
     * made
     * 
     * @param startPoint
     *            initial point stored in the LinkedList
     */
    public Leaf(Point1 startPoint)
    {
        data = new PointList(startPoint);
    }

    /**
     * outputs that the current node, with the parameters, is leaf node outputs
     * each value of the LinkedList the leaf contains
     * 
     * @param x
     *            - x coordinate of the top left corner of the current region
     * @param y
     *            - y coordinate of the top left corner of the current region
     * @param width
     *            - width of the current region
     * @param depth
     *            - depth of the current node, relative to the root (depth 0)
     * @return the number of nodes visited
     */
    @Override
    public int dump(int x, int y, int width, int depth)
    {
        String spaces = "";
        for (int i = 0; i < depth; i++)
            spaces += "  ";
        String title = spaces + "Node at " + x + ", " + y + ", " + width
                + ":";
        System.out.println(title);
        PointNode curr = data.getHead();
        while (curr != null)
        {
            String output = spaces + curr.getData().toString();
            System.out.println(output);
            curr = curr.getNext();
        }
        return 1;
    }

    /**
     * helper function that adjusts the tree if a leaf node contains 4 data
     * points creates a new internal node, adds the data from the LinkedList as
     * children, and returns the internal node if it is made, otherwise return
     * this
     * 
     * @param x
     *            - x coordinate of the top left corner of the current region
     * @param y
     *            - y coordinate of the top left corner of the current region
     * @param width
     *            - size of the current region
     * @return the root of the subtree after is has been adjusted
     */
    @Override
    public PRNode adjustTree(int x, int y, int width)
    {
        if (data.getSize() >= 4 && !data.onlyDuplicates())
        {
            InternalAttributes root = new InternalAttributes();
            while (data.getHead() != null)
            {
                root.insert(x, y, width, data.removeHead());
            }
            return root;
        }
        else if (data.getSize() == 0)
        {
            return PRQuadTree.FLYLEAF;
        }
        else
        {
            data.resize();
            return this;
        }
    }

    /**
     * insert a new Point in the current node; once the insert has found this
     * leaf node, then it is finished moving down the end of this tree
     * 
     * @param x
     *            - x coordinate of the top left corner of the current region
     * @param y
     *            - y coordinate of the top left corner of the current region
     * @param width
     *            - width of the current region
     * @param newPoint
     *            - Point that will be added to the tree
     * @return the root of the subtree that is being inserted after adjusting
     */
    @Override
    public PRNode insert(int x, int y, int width, Point1 newPoint)
    {
        data.insert(newPoint);
        return adjustTree(x, y, width);
    }

    /**
     * returns the pointer to the linkedlist stored in this leaf node
     * 
     * @return the pointer to the linkedlist
     */
    public PointList getData()
    {
        return data;
    }

    @Override
    public void duplicates()
    {
        data.outputDuplicates();
    }

    /**
     * removes the leaf node and adjusts the tree
     * @param x is the x value searched
     * @param y is the y value searched
     * @param width is the width of the interval
     * @param removePoint is the point to be removed
     * @param byName is whether or not we remove name for SkipList
     * @return the point that is removed
     */
    public Point1 remove(int x, int y, int width, Point1 removePoint,
            boolean byName)
    {
        Point1 output = data.remove(removePoint, byName);
        adjustTree(x, y, width);
        return output;
    }

    /**
     * @return whether or not this is unique
     */
    public int getUnique()
    {
        return data.getSize();
    }
}