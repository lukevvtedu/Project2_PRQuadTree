import student.TestCase;

/**
 * tests the KVPair class
 * 
 * @author oehlingr19 and lukev
 * @version 1
 */
public class KVPairTest extends TestCase {
    private KVPair<String, Integer> kv1;
    private KVPair<String, Integer> kv2;
    private KVPair<String, Integer> kv3;

    /**
     * Sets up the test
     */
    public void setUp() {
        kv1 = new KVPair<String, Integer>("a", 1);
        kv2 = new KVPair<String, Integer>("a", 2);
        kv3 = new KVPair<String, Integer>("b", 3);
    }


    /**
     * tests the compare function
     */
    public void testCompare() {
        assertEquals(kv1.compareTo(kv2), 0);
        assertFalse(kv1.compareTo(kv3) == 0);
        assertEquals(kv1.compareTo("a"), 0);
        assertEquals(kv1.compareTo(kv2.key()), 0);
        assertFalse(kv1.key().compareTo(kv3.key()) == 1);
    }


    /**
     * tests the key getter function
     */
    public void testKey() {
        assertEquals(kv1.key(), "a");
        assertEquals(kv2.key(), "a");
        assertEquals(kv1.key(), kv2.key());
    }


    /**
     * tests the value getter function
     */
    public void testValue() {
        assertTrue(kv1.value() == 1);
        assertFalse(kv1.value() == kv2.value());
        assertFalse(kv3.value() == 2);
    }

}
