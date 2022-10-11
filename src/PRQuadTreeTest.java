import student.TestCase;
/**
 * tests prquadtree
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class PRQuadTreeTest extends TestCase {

    private PRQuadTree t1;
    private Point1 p1;
    private Point1 p2;
    private Point1 p3;
    private Point1 p4;
    

    /**
     * sets up the test
     */
    public void setUp() throws Exception {
        t1 = new PRQuadTree();
        p1 = new Point1("a", 0, 20);
        p2 = new Point1("b", 30, 50);
        p3 = new Point1("c", 130, 150);
        p4 = new Point1("d", 220, 220);
    }


    /**
     * tests insert
     */
    public void testInsert() {
        t1.insert(p1);
        t1.insert(p2);
        t1.insert(p3);
        t1.insert(p4);
        t1.insert(null);
        t1.dump();
        assertEquals(
              "QuadTree dump:\n"
            + "Node at 0, 0, 1024: Internal\n"
            + "  Node at 0, 0, 512: Internal\n"
            + "    Node at 0, 0, 256: Internal\n"
            + "      Node at 0, 0, 128:\n"
            + "      (a, 0, 20)\n"
            + "      (b, 30, 50)\n"
            + "      Node at 128, 0, 128: Empty\n"
            + "      Node at 0, 128, 128: Empty\n"
            + "      Node at 128, 128, 128:\n"
            + "      (c, 130, 150)\n"
            + "      (d, 220, 220)\n"
            + "    Node at 256, 0, 256: Empty\n"
            + "    Node at 0, 256, 256: Empty\n"
            + "    Node at 256, 256, 256: Empty\n"
            + "  Node at 512, 0, 512: Empty\n"
            + "  Node at 0, 512, 512: Empty\n"
            + "  Node at 512, 512, 512: Empty\n"
            + "13 quadtree nodes printed\n", 
            systemOut().getHistory());
    }
    

    /**
     * tests duplicates
     */
    public void testDuplicates() {
        t1.insert(p1);
        t1.insert(p2);
        t1.insert(p4);
        Point1 p5 = new Point1("a", 0, 20);
        Point1 p6 = new Point1("a", 1, 30);
        Point1 p7 = new Point1("d", 2, 40);
        Point1 p8 = new Point1("e", 220, 220);
        t1.insert(p5);
        t1.insert(p6);
        t1.insert(p7);
        t1.insert(p8);
        t1.duplicates();
        assertFalse("(0, 20)\n(150, 0)\n" == systemOut().getHistory());
        assertEquals("(0, 20)\n(220, 220)\n", systemOut().getHistory());
        assertFalse(p7 == p3);
        
    }
    
    /**
     * tests remove
     */
    public void testRemove() {
        t1.remove(p1, true);
        t1.remove(p1, false);
        t1.insert(p1);
        t1.dump();
        t1.remove(p1, true);
        t1.dump();
        t1.insert(p1);
        t1.insert(p1);
        t1.insert(p1);
        t1.insert(p2);
        t1.dump();
        t1.remove(p1, false);
        t1.dump();
        
    }
}
