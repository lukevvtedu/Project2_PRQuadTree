
/**
 * Database that will contain the data structures used for a point-region
 * problem
 * 
 * @author Jonathan DeFreeuw (jondef95) Preston Lattimer (platt)
 * @version 1
 */
public class PointStorage
{

    /**
     * creates the skipList for the database
     */
    private SkipList<String, Point2> list;
    /**
     * declares the quadtree for the database
     */
    private PRQuadTree       tree;

    /**
     * initializes the SkipList and QuadTree for the Database
     */
    public PointStorage()
    {
        list = new SkipList<String, Point2>();
        tree = new PRQuadTree();
    }

    /**
     * insert a KVPair into the data structures of the database
     * 
     * @param pair
     *            is the value to be inserted
     */
    public void insert(KVPair<String, Point2> pair)
    {
        list.insert(pair);
        tree.insert(pair.theVal);
    }

    /**
     * 
     * remove a value from the database based on the key
     * 
     * @param key
     *            is the key to be searched
     * @return the value in the SkipList and quadtree
     */
    public Point2 removeKey(String key)
    {
        Point2 output = list.removeKey(key);
        if (output == null)
            return null;
        tree.remove(output, true);
        return output;
    }

    /**
     * remove a value from the database based on the value
     * 
     * @param val
     *            is the value to be found
     * @return the value in the SkipList and quadtree
     */
    public Point2 removeValue(Point2 val)
    {
        Point2 search = tree.remove(val, false);
        if (search == null)
            return null;
        list.removeKey(search.getName());
        return search;
    }

    /**
     * find all duplicate points in the quad tree
     */
    public void duplicates()
    {
        tree.duplicates();
    }

    /**
     * outputs the data using the quad tree
     */
    public void dump()
    {
        list.dump();
        tree.dump();
    }

    /**
     * searches for a specific key value
     * 
     * @param key
     *            the key that is being searched for
     * @return the node in the SkipList that contains that specific key
     */
    public SkipNode<String, Point2> search(String key)
    {
        return list.search(key);
    }

    /**
     * find all points within a specific region in the quadtree
     * 
     * @param region
     *            the region that is being used to search for points in the
     *            quadtree
     */
    public void regionSearch(Rectangle region)
    {
    }
}