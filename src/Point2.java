public class Point2
{
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