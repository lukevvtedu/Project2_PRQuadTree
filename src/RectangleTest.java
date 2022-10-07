import student.TestCase;

/**
 * Tests the rectangle class
 * 
 * @author oehlingr19 and lukev
 * @version 2
 */
public class RectangleTest extends TestCase {
    /**
     * Sets up the test file (left blank intentionally)
     */
    public void setUp() {

    }


    /**
     * Tests the equal function
     */
    public void testEquals() {
        Rectangle r1 = new Rectangle("a", 1, 2, 3, 4);
        Rectangle r2 = new Rectangle("b", 1, 2, 3, 4);
        Rectangle r3 = new Rectangle("c", 1, 3, 3, 4);
        assertTrue(r1.equals(r1));
        assertTrue(r1.equals(r2));
        assertFalse(r1.equals(r3));
        assertTrue(r1.equals(new Rectangle("a", 1, 2, 3, 4)));
        assertFalse(r1.equals(new Rectangle("a", 1, 1, 3, 4)));
        assertTrue(r1.equals(new Rectangle("b", 1, 2, 3, 4)));
    }
}
