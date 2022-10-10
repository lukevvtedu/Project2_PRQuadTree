
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
    /**
     * sets up the class
     */
    public void setUp() {
        node1 = new InternalAttributes();
        node2 = new InternalAttributes();
        node3 = new InternalAttributes();
    }

    /**
     * tests the remove method
     */
    public void testRemove()
    {
        Point2 searchPoint = new Point2("a", 54, 10);
        assertNull(node1.remove(0, 4, 20, searchPoint, true));
    }
    /**
     * tests the adjustTree mehtod
     */
    public void testAdjustTree()
    {
        assertSame(node1.adjustTree(0, 0, 10), PRQuadTree.FLYLEAF);
        PRQuadTree tree = new PRQuadTree();
        Point2 newPoint = new Point2("a", 1023, 1);
        tree.insert(newPoint);
        tree.insert(newPoint);
        tree.insert(new Point2("b", 1022, 1));
        tree.insert(new Point2("c", 1, 1));
        tree.remove(new Point2("c", 1, 1), true);
        tree.dump();
        assertTrue(systemOut().getHistory()
                .endsWith("1 quadtree nodes printed\n"));
        
    }
    
}