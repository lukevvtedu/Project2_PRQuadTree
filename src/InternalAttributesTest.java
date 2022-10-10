
import student.TestCase;

/**
 * 
 */

/**
 * @author platt, jondef95
 * @version 1
 *
 */
public class InternalAttributesTest extends TestCase {

    private InternalAttributes node1;
    private InternalAttributes node2;
    private InternalAttributes node3;
    private PRNode leaf;
    /**
     * sets up the class
     */
    public void setUp() {
        node1 = new InternalAttributes();
        node2 = new InternalAttributes();
        node3 = new InternalAttributes();
        leaf = PRQuadTree.FLYLEAF;
    }

    /**
     * tests the remove method
     */
    public void testRemove()
    {
        Point1 searchPoint = new Point1("a", 54, 10);
        node1.insert(10, 10, 0, searchPoint);
        Point1 found = leaf.remove(0, 0, 0, searchPoint, false);
        assertNull(node1.remove(0, 4, 20, searchPoint, true));
        assertFalse(node1.remove(0, 0, 0, searchPoint, false) == found);
        Point1 p2 = new Point1("b", 0, 10);
        node1.insert(5, 20, 5, p2);
        assertTrue(node1.remove(20, 20, 20, searchPoint, false) == found);
    }
    /**
     * tests the adjustTree method
     */
    public void testAdjustTree()
    {
        assertSame(node1.adjustTree(0, 0, 10), PRQuadTree.FLYLEAF);
        PRQuadTree tree = new PRQuadTree();
        Point1 newPoint = new Point1("a", 1023, 1);
        tree.insert(newPoint);
        tree.insert(newPoint);
        tree.insert(new Point1("b", 1022, 1));
        tree.insert(new Point1("c", 1, 1));
        tree.remove(new Point1("c", 1, 1), true);
        tree.dump();
        assertTrue(systemOut().getHistory()
                .endsWith("1 quadtree nodes printed\n"));
        
    }
    
    public void testGetUnique() {
        assertTrue(node1.getUnique() == 4);
    }
    
}