import student.TestCase;

/**
 * Test used for the SkipList
 * 
 * @author oehlingr19
 * @version 1
 *
 */
public class SkipListTest extends TestCase {
    
    private SkipList<String, Integer> sl;
    private KVPair<String, Integer> kv1;
    private KVPair<String, Integer> kv2;
    
    /**
     * Sets up the test file (left blank intentionally)
     */
    public void setUp() {
        sl = new SkipList<String, Integer>();
        kv1 = new KVPair<String, Integer>("a", 1);
        kv2 = new KVPair<String, Integer>("b", 2);
    }

    /**
     * tests the insert method
     */
    public void testInsert() {
        assertTrue(sl.insert(kv1.key(), kv1.value()));
        assertTrue(sl.insert(kv2.key(), kv2.value()));
    }
    
}
