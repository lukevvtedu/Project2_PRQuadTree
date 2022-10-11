/* *** ODSATag: KVPair *** */
// KVPair class definition
/**
 * 
 * @author oehlingr19 and lukev
 * @version 1.0
 *
 * @param <K>
 *            The key from the given input
 * @param <E>
 *            The element of the given object
 */

public class KVPair<K extends Comparable<K>, E>
    implements Comparable<KVPair<K, E>> {

    /**
     * key being stored
     */
    K theKey;

    /**
     * element being stored
     */
    E theVal;

    /**
     * constructor for kvPair
     * 
     * @param k
     *            key
     * @param e
     *            element
     */
    public KVPair(K k, E e) {
        theKey = k;
        theVal = e;
    }


    /**
     * returns the key
     * 
     * @return the key
     */
    public K key() {
        return theKey;
    }


    /**
     * returns the value
     * 
     * @return the value
     */
    public E value() {
        return theVal;
    }


    /**
     * compares the kvpair
     */
    public int compareTo(KVPair<K, E> it) {
        return theKey.compareTo(it.key());
    }


    /**
     * compares the key value
     * 
     * @param it
     *            the key value
     * @return the key
     */
    public int compareTo(K it) {
        return theKey.compareTo(it);
    }


    /**
     * puts the key and value into a string
     */
    public String toString() {
        return theKey.toString() + ", " + theVal.toString();
    }
}
