import student.TestCase;

/**
 * test case for the point storage
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class PointStorageTest  extends TestCase
{
    private PointStorage p1;


    /**
     * sets up the test case
     */
    public void setUp()
    {
        p1 = new PointStorage();
    }

    /**
     * tests the methods in the storage class
     */
    public void test()
    {
        p1.regionSearch(null);
        assertNull(p1.removeKey("a"));
    }

}