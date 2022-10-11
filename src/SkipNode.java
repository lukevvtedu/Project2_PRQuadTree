
/**
 * Default SkipNode class
 * 
 * @author oehlingr19 and lukev
 * @version 1
 *
 * @param <K>
 *            key of the object
 * @param <E>
 *            element of the object
 */
public class SkipNode<K extends Comparable<K>, E> {

    /**
     * skip list used for storage
     */
    public SkipNode<K, E>[] next;

    private KVPair<K, E> pair;
    private int level;

    /**
     * skipnode constructor
     * 
     * @param kv
     *            kv pair
     * @param lev
     *            level
     */
    @SuppressWarnings("unchecked")
    public SkipNode(KVPair<K, E> kv, int lev) {
        level = lev;
        pair = kv;
        next = (SkipNode<K, E>[])new SkipNode[lev + 1];
        for (int i = 0; i < level; i++) {
            next[i] = null;
        }
    }


    /**
     * gets level
     * 
     * @return the level
     */
    public int getLevel() {
        return level;
    }


    /**
     * gets the kv pair
     * 
     * @return kv pair
     */
    public KVPair<K, E> getPair() {
        if (pair != null)
            return pair;
        return null;
    }


    /**
     * gets the key
     * 
     * @return the key
     */
    public K getKey() {
        if (pair != null) {
            return pair.key();
        }
        return null;
    }


    /**
     * gets the value
     * 
     * @return the value
     */
    public E getValue() {
        if (pair != null) {
            return pair.value();
        }
        return null;
    }
}
