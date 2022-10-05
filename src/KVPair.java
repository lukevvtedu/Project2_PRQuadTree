/* *** ODSATag: KVPair *** */
// KVPair class definition
/**
 * 
 * @author oehlingr19
 * @version 1.0
 *
 * @param <K>
 *            The key from the given input
 * @param <E>
 *            The element of the given object
 */
public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {
    private K theKey;
    private E theVal;

    /**
     * default KVPair constructor
     * 
     * @param k
     *            Key of the object
     * @param e
     *            Element of the object
     */
    KVPair(K k, E e) {
        theKey = k;
        theVal = e;
    }


    /**
     * compares key values
     * 
     * @param it
     *            key value being compared
     * @return compared value
     */
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    /**
     * compares key values
     * 
     * @param it
     *            key value being compared
     * @return compared value
     */
    public int compareTo(K it) {
        return theKey.compareTo(it);
    }


    /**
     * getter for key
     * 
     * @return key value
     */
    public K key() {
        return theKey;
    }


    /**
     * getter for element
     * 
     * @return element value
     */
    public E value() {
        return theVal;
    }

}
/* *** ODSAendTag: KVPair *** */
