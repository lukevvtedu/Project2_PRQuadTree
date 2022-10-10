import java.io.FileNotFoundException;
import student.TestCase;

/**
 * Tests the Command File class
 * 
 * @author oehlingr19 and lukev
 * @version 1
 */
import student.TestCase;

/**
 * Test class to demonstrate proper use of the CommandParser
 * 
 * @author Jonathan DeFreeuw (jondef95), Preston Lattimer (platt)
 * @version 2
 */
public class CommandFileTest extends TestCase
{
    private CommandFile cmd;

    /**
     * tests to see if the parser will correctly handle an incorrect file
     */
    public void testSearchFail()
    {
        cmd = new CommandFile("fail");
        boolean success = cmd.parseFile();
        assertFalse(success);
    }

    /**
     * tests to see if the parser will correctly open and close a file does not
     * test the output of the parser
     */
    public void testSearchPass()
    {
        cmd = new CommandFile("P2SyntaxTest1.txt");
        boolean success = cmd.parseFile();
        assertTrue(success);
    }

    /**
     * tests checkDim for the variety of conditions that are available
     */
    /**
     * public void testCheckDim() { parser = new CommandParser("test.txt");
     * assertTrue(parser.checkDim(0, 0, 1, 1)); assertTrue(parser.checkDim(1, 1,
     * 1, 1)); assertFalse(parser.checkDim(0, 0, 1025, 1));
     * assertFalse(parser.checkDim(0, 0, 1, 1025));
     * assertFalse(parser.checkDim(-1, 1, 1, 1)); assertFalse(parser.checkDim(0,
     * -1, 1, 1)); assertFalse(parser.checkDim(-1, -1, 1, 1));
     * assertFalse(parser.checkDim(-1, -1, -1, 1));
     * assertFalse(parser.checkDim(-1, -1, -1, -1));
     * assertFalse(parser.checkDim(0, 0, 0, 0)); assertFalse(parser.checkDim(0,
     * 0, 1, 0));
     * 
     * }
     */

    /**
     * tests the parsers various tests
     */
    public void testParseFile()
    {
        cmd = new CommandFile("P2SyntaxTest1.txt");
        boolean success = cmd.parseFile();
        assertTrue(success);
    }
    public void testParseFile2()
    {
        cmd = new CommandFile("P2SyntaxTest2.txt");
        boolean success = cmd.parseFile();
        assertTrue(success);
    }
    public void testParseFile3()
    {
        cmd = new CommandFile("SkipListSampleInput.txt");
        boolean success = cmd.parseFile();
        assertTrue(success);
    }
    
    public void testNull() {
        cmd = new CommandFile("hi");
        assertFalse(cmd.parseFile());
    }
}