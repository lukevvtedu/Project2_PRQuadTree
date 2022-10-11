/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class PointStorage {

    private SkipList<String, Point1> sl;
    private PRQuadTree pr;

    /**
     * default constructor for point storage
     */
    public PointStorage() {
        sl = new SkipList<String, Point1>();
        pr = new PRQuadTree();
    }

    /**
     * searches for the specific node
     * 
     * @param k
     *            key being searched
     * @return searched pair
     */
    public SkipNode<String, Point1> search(String k) {
        return sl.search(k);
    }


    /**
     * searches a region for rectangles
     * 
     * @param r
     *            rectangle being searched
     */
    public void regionSearch(Rectangle r) {
        // left blank intentionally
    }

    /**
     * removes the key from the point
     * 
     * @param k
     *            key being removed
     * @return removed key
     */
    public Point1 removeKey(String k) {
        Point1 out = sl.removeKey(k);
        if (out == null)
            return null;
        pr.remove(out, true);
        return out;
    }

    /**
     * inserts a kv pair object
     * 
     * @param kv
     *            kv object being added
     */
    public void insert(KVPair<String, Point1> kv) {
        sl.insert(kv);
        pr.insert(kv.theVal);
    }

    /**
     * removes value from the point
     * 
     * @param e
     *            value being removed
     * @return removed value
     */
    public Point1 removeValue(Point1 e) {
        Point1 p1 = pr.remove(e, false);
        if (p1 == null)
            return null;
        sl.removeKey(p1.getName());
        return p1;
    }


    /**
     * finds the duplicates
     */
    public void duplicates() {
        pr.duplicates();
    }


    /**
     * dumps the data found
     */
    public void dump() {
        sl.dump();
        pr.dump();
    }



}
