import student.TestCase;

/**
 * Test for the SkipNode class
 * 
 * @author oehlingr19
 * @version 1
 */
public class SkipNodeTest extends TestCase {

    private SkipNode<String, Integer> sn1;
    private SkipNode<String, Integer> sn2;
    private SkipNode<String, Integer> sn3;

    /**
     * Sets up the test file (left blank intentionally)
     */
    public void setUp() {
        sn1 = new SkipNode<String, Integer>(null, null, 1);
        sn2 = new SkipNode<String, Integer>("a", 10, 1);
        sn3 = new SkipNode<String, Integer>("b", 50, 5);

    }


    /**
     * tests a null node key and value
     */
    public void testNullNode() {
        assertNull(sn1.key());
        assertNull(sn1.element());
    }


    /**
     * tests two non-null Nodes for equivalence
     */
    public void testNonNullNode() {
        sn2 = sn3;
        assertEquals(sn2.key(), "b");
        assertEquals(sn2.key(), sn3.key());

        assertTrue(sn2.element() == 50);
        assertTrue(sn2.element() == sn3.element());
    }
}
