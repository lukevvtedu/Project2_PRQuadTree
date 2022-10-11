import student.TestCase;

/**
 * Test class for point1
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class Point1Test extends TestCase {

    /**
     * tests the equals method
     */
    public void testEquals() {
        Object obj = new Object();
        Point1 point = new Point1("a", 1, 2);
        Point1 point2 = new Point1("a", 1, 2);
        Point1 pointNotSame = new Point1("b", 3, 2);
        Point1 pointNotSame2 = new Point1("c", 1, 3);
        assertFalse(point.equals(obj));
        assertTrue(point.equals(point2));
        assertFalse(point.equals(pointNotSame));
        assertFalse(point.equals(pointNotSame2));
    }

}
