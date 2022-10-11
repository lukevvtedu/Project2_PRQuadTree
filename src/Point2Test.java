import student.TestCase;

/**
 * Test class for point2
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class Point2Test extends TestCase {
    private String[] args;

    /**
     * sets up the test
     */
    public void setUp() {
        args = new String[1];
    }


    /**
     * tests the files to extend coverage
     * 
     * @throws Exception
     */
    public void testFiles() throws Exception {
        args[0] = "PRQTF1.txt";
        Point2.main(args);
        assertEquals("Point rejected: (point, -10, -10)\n"
            + "Point rejected: (point2, 10, -10)\n" + "Duplicate points:\n"
            + "SkipList dump:\n" + "Node has depth 1, Value (null)\n"
            + "SkipList size is: 0\n" + "QuadTree dump:\n"
            + "Node at 0, 0, 1024: Empty\n" + "1 quadtree nodes printed\n"
            + "Point not found: point\n" + "Point not removed: point\n"
            + "Point rejected: (10, -10)\n" + "Point not found: (10, 10)\n"
            + "Points intersecting region (-10, -10, 10, 10):\n"
            + "1 quadtree nodes visited\n"
            + "Rectangle rejected: (3, 3, 2, -1)\n", systemOut().getHistory());
        
        args[0] = "test.txt";
        Point2.main(args);
        assertTrue(systemOut().getHistory().endsWith(
            "Point not removed: point\n"
                + "Point removed: (northeast, 1, 1000)\n"
                + "Point rejected: (10, -10)\n"
                + "Point removed: (testPoint, 5, 5)\n"));
    }

}
