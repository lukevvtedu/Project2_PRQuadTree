import student.TestCase;

/**
 * Test class for the leaf class
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class LeafTest extends TestCase {

    private PRNode leaf;

    /**
     * sets up the test
     */
    public void setUp() {
        leaf = PRQuadTree.FLYWEIGHT;
    }


    /**
     * tests the adjustTree
     */
    public void testAdjustTree() {
        Point1 p1 = new Point1("a", 20, 20);
        leaf.insert(1, 1, 0, p1);
        assertEquals(leaf.adjustTree(20, 20, 3), leaf);
    }
}
