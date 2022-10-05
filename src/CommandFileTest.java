import student.TestCase;

/**
 * Tests the Command File class
 * 
 * @author oehlingr19
 * @version 1
 */
public class CommandFileTest extends TestCase {
    
    private CommandFile cmd;
    /**
     * Sets up the test file (left blank intentionally)
     */
    public void setUp() {
        
    }


    /**
     * Main test function
     */
    public void testSearch() {
        cmd = new CommandFile("a");
        boolean pass = cmd.run();
        assertFalse(pass);
        cmd = new CommandFile("SkipListSampleInput.txt");
        pass = cmd.run();
        assertTrue(pass);
    }
    
    /**
     * tests the run function
     */
    public void testRun() {
        cmd = new CommandFile("TestRecs.txt");
        boolean pass = cmd.run();
        assertTrue(pass);
    }
    
    /**
     * tests the checkBounds function
     */
    public void testCheckBounds() {
        cmd = new CommandFile("TestRecs.txt");
        assertFalse(cmd.checkBounds(0, 0, 0, 0));
        assertFalse(cmd.checkBounds(0, 0, 0, 1));
        assertFalse(cmd.checkBounds(0, 0, 1, 0));
        assertTrue(cmd.checkBounds(0, 0, 1, 1));
        assertFalse(cmd.checkBounds(1024, 1024, 1024, 1024));
        assertFalse(cmd.checkBounds(1024, 500, 1024, 1024));
        assertFalse(cmd.checkBounds(500, 1024, 1024, 1024));
        assertFalse(cmd.checkBounds(500, 500, 1024, 1024));
        assertFalse(cmd.checkBounds(500, 500, 500, 1023));
        assertFalse(cmd.checkBounds(500, 500, 1023, 500));
        assertTrue(cmd.checkBounds(500, 500, 500, 500));
        
    }
}
