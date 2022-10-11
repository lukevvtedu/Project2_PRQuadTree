import student.TestCase;
/**
 * test class for command file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class CommandFileTest extends TestCase
{
    private CommandFile cmd;

    /**
     * tests search function
     */
    public void testSearch()
    {
        cmd = new CommandFile("no");
        boolean yes = cmd.run();
        assertFalse(yes);
        cmd = new CommandFile("PRQTF1.txt");
        yes = cmd.run();
        assertTrue(yes);
    }

    /**
     * test runs using different text files
     */
    public void testrun()
    {
        cmd = new CommandFile("PRQTF1.txt");
        boolean yes = cmd.run();
        assertTrue(yes);
        cmd = new CommandFile("PRQTF2.txt");
        yes = cmd.run();
        assertTrue(yes);
        cmd = new CommandFile("sample.txt");
        yes = cmd.run();
        assertTrue(yes);
        cmd = new CommandFile("hi");
        assertFalse(cmd.run());
    }
}