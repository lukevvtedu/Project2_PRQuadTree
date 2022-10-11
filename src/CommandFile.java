import java.util.Scanner;
import java.io.File;

import java.io.FileNotFoundException;

/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class CommandFile {

    private String fileName;
    private PointStorage storage;

    /**
     * The default constructor for the commandFile class
     * 
     * @param file
     *            The file being read from the given argument
     */
    public CommandFile(String file) {
        fileName = file;
        storage = new PointStorage();
    }


    /**
     * function used to run through the input file
     * 
     * @return successful run
     */
    public boolean run() {
        Scanner scan = null;
        Exception except = null;
        try {
            scan = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            except = e;
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        if (except == null) {
            while (scan.hasNext()) {
                String cmd = scan.next();
                switch (cmd) {
                    case ("insert"): {
                        cmdInsert(scan);
                        break;
                    }
                    case ("remove"): {
                        remove(scan);
                        break;
                    }
                    case ("regionsearch"): {
                        regionSearch(scan);
                        break;
                    }
                    case ("duplicates"): {
                        dupe();
                        break;
                    }
                    case ("search"): {
                        cmdSearch(scan);
                        break;
                    }
                    case ("dump"): {
                        storage.dump();
                        break;
                    }
                    default: {
                        break;
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * checks for duplicates using cmd
     */
    private void dupe() {
        System.out.println("Duplicate points:");
        storage.duplicates();
    }


    /**
     * checks if the string is a number
     * 
     * @param str
     *            input string
     * @return true if input is a number, false otherwise
     */
    private static boolean checkNum(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }


    /**
     * checks dimentions of the rectangle
     * 
     * @param x
     *            x value of placement
     * @param y
     *            y value of placement
     * @return true if within bounds
     */
    public boolean checkDim(int x, int y) {
        return (x >= 0 && y >= 0 && x < 1024 && y < 1024);
    }
    /**
     * searches a region for rectangles
     * 
     * @param scan
     *            scanner object
     */
    private void regionSearch(Scanner scan) {
        int x = scan.nextInt();
        int y = scan.nextInt();
        int width = scan.nextInt();
        int height = scan.nextInt();
        if (!(height < 1 | width < 1)) {
            System.out.println("Points intersecting region (" + x + ", " + y
                + ", " + width + ", " + height + "):");
            System.out.println("1 quadtree nodes visited");
        }
        else {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + width
                + ", " + height + ")");
        }
    }



    /**
     * remove function using cmd
     * 
     * @param scan
     *            scanner object
     */
    private void remove(Scanner scan) {
        String nextStr = scan.next();
        if (checkNum(nextStr)) {
        	int x = Integer.parseInt(nextStr);
            int y = scan.nextInt();
            if (checkDim(x, y)) {
                Point1 searchPoint = new Point1(null, x, y);
                Point1 found = storage.removeValue(searchPoint);
                if (found != null)
                    System.out.println("Point removed: " + found.toString());

                else
                    System.out.println("Point not found: (" + x + ", " + y
                            + ")");
            }
            else
                System.out.println("Point rejected: (" + x + ", " + y + ")");
        }
        else {
            Point1 found = storage.removeKey(nextStr);
            if (found == null)
                System.out.println("Point not removed: " + nextStr);
            else
                System.out.println("Point removed: " + found.toString());
        }
    }


    /**
     * insert function using cmd, name used for clarity
     * 
     * @param scan
     *            scanner object
     */
    private void cmdInsert(Scanner scan) {
        String nextStr = scan.next();
        int x = scan.nextInt();
        int y = scan.nextInt();
        char c = nextStr.charAt(0);
        if (checkDim(x, y) && Character.isAlphabetic(c)) {
            Point1 p = new Point1(nextStr, x, y);
            KVPair<String, Point1> pair = new KVPair<String, Point1>(nextStr, p);
            storage.insert(pair);
            System.out.println("Point inserted: (" + nextStr + ", " + x + ", " + y
                + ")");
        }
        else
            System.out.println("Point rejected: (" + nextStr + ", " + x + ", " + y
                + ")");
    }



    /**
     * searches using cmd. name for clarity
     * 
     * @param scan
     *            scanner object
     */
    private void cmdSearch(Scanner scan) {
        String nextStr = scan.next();
        SkipNode<String, Point1> skipNoder = storage.search(nextStr);
        if (null == storage.search(nextStr)) {
            System.out.println("Point not found: " + nextStr);
        }
        else {
            System.out.println("Point found: " + skipNoder.getValue().toString());
            while (skipNoder.next[0] != null && skipNoder.next[0].getKey().compareTo(skipNoder
                .getKey()) == 0) {
                skipNoder = skipNoder.next[0];
                System.out.println("Point found: " + skipNoder.getValue().toString());
            }
        }
    }




}
