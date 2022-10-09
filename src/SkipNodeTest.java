import static org.junit.Assert.assertNotEquals;
import student.TestCase;

/**
 * Test for the SkipNode class
 * 
 * @author oehlingr19 and lukev
 * @version 1
 */
public class SkipNodeTest extends TestCase
{

    private SkipNode<String, Integer> node2;
    private SkipNode<String, Integer> node3;
    private KVPair<String, Integer>   pair;

    /**
     * sets up the test cases
     */
    public void setUp()
    {
        pair = null;
        node2 = new SkipNode<String, Integer>(pair, 1);
    }

    /**
     * tests the getKey method properly
     */
    public void testGetKey()
    {
        assertNull(node2.getKey());
    }

    /**
     * tests that a node with no pair returns null
     */
    public void testGetPair()
    {
        assertNull(node2.getPair());
    }

    /**
     * tests that a node with a KVPair returns that pair by testing its key
     */
    public void testGetPairRight()
    {
        KVPair<String, Integer> newPair = new KVPair<String, Integer>(
                "hello!", 1);
        node3 = new SkipNode<String, Integer>(newPair, 4);
        assertFuzzyEquals(node3.getPair().key(), "hello!");
    }

}