import student.TestCase;

/**
 * Tests the flyweight class
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class FlyWeightTest extends TestCase {

    private PRQuadTree t1;
    private Leaf l1;

    /**
     * setup function
     */
    public void setUp() {
        t1 = new PRQuadTree();
        l1 = new Leaf();
    }


    /**
     * tests the dump function
     */
    public void testDump() {
        Point1 p1 = new Point1("a", 0, 0);
        t1.FLYLEAF.dump(0, 0, 2, 0);
        assertEquals("Node at 0, 0, 2: Empty\n", systemOut().getHistory());
        assertFalse(l1 == t1.FLYLEAF.insert(0, 0, 4, p1));
        assertNull(t1.FLYLEAF.getData());
        assertNull(t1.FLYLEAF.remove(0, 0, 4, p1, false));
        systemOut().clearHistory();
        t1.FLYLEAF.dump(0, 0, 0, 2);
        assertEquals("    Node at 0, 0, 0: Empty\n", systemOut().getHistory());
    }
}
