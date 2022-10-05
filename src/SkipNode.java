
/**
 * Default SkipNode class
 * 
 * @author oehlingr19
 * @version 1
 *
 * @param <K>
 *            key of the object
 * @param <E>
 *            element of the object
 */
class SkipNode<K extends Comparable<K>, E> {
    private KVPair<K, E> rec;
    private SkipNode<K, E>[] forward;

    /**
     * getter for the element of an object
     * 
     * @return the element value
     */
    public E element() {
        return rec.value();
    }


    /**
     * getter for the key of an object
     * 
     * @return the key value
     */
    public K key() {
        return rec.key();
    }


    /**
     * Default constructor for a SkipNode object
     * 
     * @param k
     *            key of the object
     * @param e
     *            element of the object
     * @param level
     *            depth of the node
     */
    @SuppressWarnings("unchecked")
    public SkipNode(K k, E e, int level) {
        rec = new KVPair<K, E>(k, e);
        forward = new SkipNode[level + 1];
        for (int i = 0; i < level; i++) {
            forward[i] = null;
        }
    }


    /**
     * finds the next node
     * 
     * @return the next node
     */
    public SkipNode<K, E>[] getForward() {
        return forward;
    }

}
