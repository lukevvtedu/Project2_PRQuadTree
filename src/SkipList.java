import java.lang.reflect.Array;
import java.util.Random;
import student.TestableRandom;

/**
 * The SkipList class create a SkipList data structure
 * 
 * @author oehlingr19
 * @version 1
 *
 * @param <K>
 *            The given key from the input
 * @param <E>
 *            The given element from the input
 */
public class SkipList<K extends Comparable<K>, E> {

    static private Random rnd = new Random(); // Random number generator
    private SkipNode<K, E> head; // Private member of the SkipList object
    private int level; // Where the deepest node is in the SkipList
    private int size; // The total number of items in the SkipList

    /**
     * Default SkipList constructor
     */
    public SkipList() {
        rnd = new TestableRandom();
        head = new SkipNode<K, E>(null, null, 0);
        level = -1;
        size = 0;
    }


    /**
     * Pick a level using a geometric distribution
     * 
     * @return random level of depth
     */
    public int randomLevel() {
        int lev;
        for (lev = 0; rnd.nextBoolean(); lev++) {
            // Left intentionally blank
        }
        return lev;
    }


    /**
     * Moves the head of the SkipList
     * 
     * @param newLevel
     *            depth of the head
     */
    private void adjustHead(int newLevel) {
        SkipNode<K, E> temp = head;
        head = new SkipNode<K, E>(null, null, newLevel);
        for (int i = 0; i <= level; i++) {
            head.getForward()[i] = temp.getForward()[i];
        }
        level = newLevel;
    }


    /**
     * Inserts a key and element into the skiplist
     * **Adjusted from the OpenDSA**
     * 
     * @param k
     *            key of the given input
     * @param e
     *            element of the given input
     * @return true to get output
     */
    public boolean insert(K k, E e) {
        int newLevel = randomLevel();
        if (level < newLevel) {
            adjustHead(newLevel);
        }
        @SuppressWarnings("unchecked") // Generic array allocation
        SkipNode<K, E>[] update = (SkipNode<K, E>[])Array.newInstance(
            SkipNode.class, level + 1);
        SkipNode<K, E> x = head; // Start at header node
        for (int i = level; i >= 0; i--) { // Find insert position
            while ((x.getForward()[i] != null) && (k.compareTo(x.getForward()[i]
                .key()) > 0)) {
                x = x.getForward()[i];
            }
            update[i] = x; // Track end at level i
        }
        x = new SkipNode<K, E>(k, e, newLevel);
        for (int i = 0; i <= newLevel; i++) { // Splice into list
            x.getForward()[i] = update[i].getForward()[i]; // Who x points to
            update[i].getForward()[i] = x; // Who y points to
        }
        size++; // Increment dictionary size
        return true;
    }


    /**
     * Removes a node from the SkipList base on its key value
     * 
     * @param k
     *            key that is being parsed to remove node
     * @return The removed node, null if non-existent
     */
    public SkipNode<K, E> remove(K k) {
        SkipNode<K, E> x = head;
        SkipNode<K, E> search = search(k);
        int lev = x.getForward().length - 1;
        if (search == null) {
            return search;
        }
        SkipNode<K, E>[] newSearch = search.getForward();
        while (x != null) {
            for (int i = lev; i >= 0; i--) {
                i = lev;
                if (x == null) {
                    break;
                }
                SkipNode<K, E> xFor = x.getForward()[i];
                if (xFor != null) {
                    if (xFor == search) {
                        xFor = newSearch[i];
                    }
                }
                x = x.getForward()[0];
                if (x != null) {
                    lev = x.getForward().length - 1;
                }
            }
        }
        size--;
        return search;
    }


    /**
     * Removes a node by its element
     * 
     * @param e
     *            the element being parsed to remove a node
     * @return The removed node, null if non-existent
     */
    public SkipNode<K, E> remove(E e) {
        SkipNode<K, E> x = head;
        SkipNode<K, E> search = search(e);
        if (search == null) {
            return search;
        }
        SkipNode<K, E>[] newSearch = search.getForward();
        int lev = x.getForward().length - 1;
        while (x != null) {
            for (int i = lev; i > -1; i--) {
                if (x.getForward()[i] != null) {
                    if ((x.getForward()[i] == search)) {
                        x.getForward()[i] = newSearch[i];
                    }
                }
            }
            x = x.getForward()[0];
            if (x != null) {
                lev = x.getForward().length - 1;
            }
        }
        size--;
        return search;
    }


    /**
     * Search for a node based on its key value
     * 
     * @param k
     *            the key being parsed to find the node
     * @return The found node, null if non-existent
     */
    private SkipNode<K, E> search(K k) {
        SkipNode<K, E> x = head;
        for (int i = level; i > -1; i--) {
            while ((x.getForward()[i] != null) && (x.getForward()[i].key()
                .compareTo(k) < 0)) {
                x = x.getForward()[i];
            }
        }
        x = x.getForward()[0];
        if ((x != null) && (x.key().compareTo(x.key()) == 0)) {
            return x;
        }
        else {
            return null;
        }
    }


    /**
     * Finds a node based on its element
     * 
     * @param e
     *            the element being parsed to find the node
     * @return The found node, null if non-existent
     */
    private SkipNode<K, E> search(E e) {
        SkipNode<K, E> x = head;
        int lev = level;
        if (x.getForward().length != 1) {
            while (x != null) {
                for (int i = lev; i > -1; i--) {
                    if (x.getForward()[i] != null) {
                        if (e.equals(x.getForward()[i].element())) {
                            x = x.getForward()[i];
                            return x;
                        }
                    }
                }
                x = x.getForward()[0];
                if (x != null) {
                    lev = x.getForward().length - 1;
                }
            }
        }
        else {
            while (x != null) {
                if (x.getForward()[0] == null) {
                    return null;
                }
                if (e.equals(x.getForward()[0].element())) {
                    x = x.getForward()[0];
                    return x;
                }
                x = x.getForward()[0];
            }
        }
        return null;
    }


    /**
     * Creates a list of all nodes
     * 
     * @return All found nodes within the SkipList
     */
    public SkipNode<K, E>[] dump() {
        SkipNode<K, E> x = head;
        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] dump = new SkipNode[1];
        int dumpLength = 0;
        while (x != null) {
            if (dumpLength == 0) {
                dump[0] = new SkipNode<K, E>(x.key(), x.element(), x
                    .getForward().length);
                dumpLength++;
            }
            else {
                @SuppressWarnings("unchecked")
                SkipNode<K, E>[] temp = new SkipNode[dump.length + 1];
                System.arraycopy(dump, 0, temp, 0, dump.length);
                temp[temp.length - 1] = new SkipNode<K, E>(x.key(), x.element(),
                    x.getForward().length);
                dump = temp;
            }
            x = x.getForward()[0];
        }
        return dump;
    }


    /**
     * Searches for all KVPairs within the SkipList given a key
     * 
     * @param k
     *            the key being parsed to find all KVPairs
     * @return The found KVPairs
     */
    public SkipNode<K, E>[] find(K k) {
        SkipNode<K, E> x = head;
        @SuppressWarnings("unchecked")
        SkipNode<K, E>[] found = new SkipNode[1];
        int lev = level;
        for (int i = lev; i >= 0; i--) {
            while ((x.getForward()[i] != null) && (x.getForward()[i].key()
                .compareTo(k) < 0))
                x = x.getForward()[i];
        }
        x = x.getForward()[0];
        if ((x != null) && (x.key().compareTo(x.key()) == 0)) {
            @SuppressWarnings("unchecked")
            SkipNode<K, E>[] temp = new SkipNode[found.length + 1];
            System.arraycopy(found, 0, temp, 0, found.length);
            temp[temp.length - 1] = new SkipNode<K, E>(k, x.element(), 0);
            found = temp;
            lev = x.getForward().length - 1;
        }
        return found;
    }
}
