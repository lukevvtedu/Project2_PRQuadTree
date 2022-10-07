import student.TestCase;

/**
 * Tests used for the main function
 * 
 * @author oehlingr19 and lukev
 * @version 1
 *
 */
public class Rectangle1Test extends TestCase {

    /**
     * Sets up the test file (left blank intentionally)
     */
    public void setUp() {

    }


    /**
     * Main test function
     */
    public void testRec() {
        Rectangle1 testR = new Rectangle1();
        assertNotNull(testR);
        Rectangle1.main(new String[] { "" });
        Rectangle1.main(new String[] { "SkipListSampleInput.txt" });

    }

}
