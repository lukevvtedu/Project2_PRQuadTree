import student.TestCase;

/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class PointListTest extends TestCase {

    private PointList list;
    private Point1 p1;
    private Point1 p2;
    private Point1 p3;
    private Point1 p4;

    /**
     * sets up the information for the tests
     */
    public void setUp() {
        list = new PointList();
        p1 = new Point1("a", 1, 20);
        p2 = new Point1("b", 10, 30);
        p3 = new Point1("c", 140, 10);
        p4 = new Point1("d", 200, 200);
    }


    /**
     * tests the insert method
     */
    public void testInsert() {
        list.insert(p1);
        list.insert(p2);
        assertEquals(2, list.getSize());
    }


    /**
     * tests the dupes method
     */
    public void testOutputDupes() {
        list.insert(p1);
        list.insert(p2);
        list.insert(p1);
        list.insert(p1);
        list.outputDupes();
        assertTrue(systemOut().getHistory().endsWith("(1, 20)\n"));
    }


    /**
     * tests remove
     */
    public void testRemove() {
        list.remove(null, true);
        list.remove(null, false);
        list.remove(p1, true);
        list.remove(p1, false);
        assertEquals(0, list.getSize());
        list.insert(p1);
        list.insert(p2);
        list.insert(p1);
        list.remove(p1, true);
        list.remove(p2, false);
        assertEquals(1, list.getSize());
    }


    /**
     * tests remove again
     */
    public void testRemove2() {
        list.insert(p1);
        assertNull(list.remove(p2, true));
        Point1 p5 = new Point1("a", 10, 30);
        list.insert(p5);
        list.insert(p2);
        assertEquals(p2, list.remove(p2, true));
        list.insert(p1);
        list.insert(p3);
        list.insert(p4);
        list.remove(p4, false);
        assertEquals(4, list.getSize());

    }


    /**
     * tests remove again
     */
    public void testRemove3() {
        list.insert(p1);
        list.remove(p2, false);
        assertEquals(1, list.getSize());
    }
}
