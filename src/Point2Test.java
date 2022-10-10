import student.TestCase;

/**
 * @author CS3114 staff
 * @version 2
 */
public class Point2Test extends TestCase
{

    /**
     * This method sets up the tests that follow.
     */
    public void setUp()
    {
    }

    // ----------------------------------------------------------

    // ----------------------------------------------------------
    /**
     * Test command parser syntax on mostly bad input
     *
     * @throws Exception
     */
    public void testSyntax1() throws Exception
    {
        Point2 testClass = new Point2();
        String[] args = new String[1];
        args[0] = "P2SyntaxTest1.txt";
        Point2.main(args);
        assertEquals("Point rejected: (point, -10, -10)\n"
                + "Point rejected: (point2, 10, -10)\n" + "Duplicate points:\n"
                + "SkipList dump:\n" + "Node has depth 1, Value (null)\n"
                + "SkipList size is: 0\n" + "QuadTree dump:\n"
                + "Node at 0, 0, 1024: Empty\n"
                + "1 quadtree nodes printed\n" + "Point not found: point\n"
                + "Point not removed: point\n" + "Point rejected: (10, -10)\n"
                + "Point not found: (10, 10)\n"
                + "Points intersecting region (-10, -10, 10, 10):\n"
                + "1 quadtree nodes visited\n"
                + "Rectangle rejected: (3, 3, 2, -1)\n",
                systemOut().getHistory());
    }

    
    public void testSyntax3() throws Exception
    {
        System.out.println("");
        System.out.println("");
        String[] args = new String[1];
        args[0] = "test.txt";
        Point2.main(args);
        assertTrue(systemOut().getHistory()
                .endsWith("Point not removed: point\n"
                        + "Point removed: (northeast, 1, 1000)\n"
                        + "Point rejected: (10, -10)\n"
                        + "Point removed: (testPoint, 5, 5)\n"));
                        
    }
}