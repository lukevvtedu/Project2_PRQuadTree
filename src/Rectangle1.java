// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- oehlingr19 and lukev

/**
 * 
 * @author oehlingr19 and lukev
 * @version 1
 *          This function is the main function thats runs the code.
 */
public class Rectangle1 {
    /**
     * main function to run the code
     * 
     * @param args
     *            Name of the command given through the arguments of the
     *            system run file
     * 
     */
    public static void main(String[] args) {
        CommandFile cmd = new CommandFile(args[0]);
        cmd.parseFile();
    }
}
