import student.TestCase;

/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class InternalAttributesTest extends TestCase {

    private InternalAttributes n1;
    private PRNode leaf;
    /**
     * sets up the class
     */
    public void setUp() {
        n1 = new InternalAttributes();
        leaf = PRQuadTree.FLYWEIGHT;
    } 
    
    /**
     * tests the remove method
     */
    public void testRemove()
    {
        Point1 ps = new Point1("a", 54, 10);
        n1.insert(10, 10, 0, ps);
        Point1 pf = leaf.remove(0, 0, 0, ps, false);
        assertNull(n1.remove(0, 4, 20, ps, true));
        assertFalse(n1.remove(0, 0, 0, ps, false) == pf);
        Point1 p2 = new Point1("b", 0, 10);
        n1.insert(5, 20, 5, p2);
        assertTrue(n1.remove(20, 20, 20, ps, false) == pf);
    }
    /**
     * tests the adjustTree method
     */
    public void testAdjustTree()
    {
        assertSame(n1.adjustTree(0, 0, 10), PRQuadTree.FLYWEIGHT);
        PRQuadTree pr1 = new PRQuadTree();
        Point1 p2 = new Point1("a", 1023, 1);
        pr1.insert(p2);
        pr1.insert(p2);
        pr1.insert(new Point1("b", 1022, 1));
        pr1.insert(new Point1("c", 1, 1));
        pr1.remove(new Point1("c", 1, 1), true);
        pr1.dump();
        assertTrue(systemOut().getHistory()
                .endsWith("1 quadtree nodes printed\n"));
        
    }
    
    public void testGetUnique() {
        assertTrue(n1.getUnique() == 4);
    }
    
}