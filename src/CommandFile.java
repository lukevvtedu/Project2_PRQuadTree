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

    private String input;
    private PointStorage storage;

    /**
     * The default constructor for the commandFile class
     * 
     * @param st
     *            The file being read from the given argument
     */
    public CommandFile(String file) {
        input = file;
        storage = new PointStorage();
    }


    /**
     * function used to run through the input file
     * 
     * @return successful run
     */
    public boolean run() {
        Scanner s = null;
        Exception d = null;
        try {
            s = new Scanner(new File(input));
        }
        catch (FileNotFoundException e) {
            d = e;
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        if (d == null) {
            while (s.hasNext()) {
                String cmd = s.next();
                switch (cmd) {
                    case ("insert"): {
                        cmdInsert(s);
                        break;
                    }
                    case ("remove"): {
                        remove(s);
                        break;
                    }
                    case ("regionsearch"): {
                        regionSearch(s);
                        break;
                    }
                    case ("duplicates"): {
                        dupe();
                        break;
                    }
                    case ("search"): {
                        cmdSearch(s);
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
     * insert function using cmd, name used for clarity
     * 
     * @param s
     *            scanner object
     */
    private void cmdInsert(Scanner s) {
        String st = s.next();
        int x = s.nextInt();
        int y = s.nextInt();
        char c = st.charAt(0);
        if (checkDim(x, y) && Character.isAlphabetic(c)) {
            Point1 p = new Point1(st, x, y);
            KVPair<String, Point1> pair = new KVPair<String, Point1>(st, p);
            storage.insert(pair);
            System.out.println("Point inserted: (" + st + ", " + x + ", " + y
                + ")");
        }
        else
            System.out.println("Point rejected: (" + st + ", " + x + ", " + y
                + ")");
    }


    /**
     * remove function using cmd
     * 
     * @param s
     *            scanner object
     */
    private void remove(Scanner s) {
        String st = s.next();
        if (!checkNum(st)) {
            Point1 found = storage.removeKey(st);
            if (found == null)
                System.out.println("Point not removed: " + st);
            else
                System.out.println("Point removed: " + found.toString());
        }
        else {
            int x = Integer.parseInt(st);
            int y = s.nextInt();
            if (checkDim(x, y)) {
                Point1 searchPoint = new Point1(null, x, y);
                Point1 found = storage.removeValue(searchPoint);
                if (found == null)
                    System.out.println("Point not found: (" + x + ", " + y
                        + ")");
                else
                    System.out.println("Point removed: " + found.toString());
            }
            else
                System.out.println("Point rejected: (" + x + ", " + y + ")");
        }
    }


    /**
     * searches a region for rectangles
     * 
     * @param s
     *            scanner object
     */
    private void regionSearch(Scanner s) {
        int x = s.nextInt();
        int y = s.nextInt();
        int w = s.nextInt();
        int h = s.nextInt();
        if (!(h < 1 | w < 1)) {
            System.out.println("Points intersecting region (" + x + ", " + y
                + ", " + w + ", " + h + "):");
            System.out.println("1 quadtree nodes visited");
        }
        else {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w
                + ", " + h + ")");
        }
    }


    /**
     * searches using cmd. name for clarity
     * 
     * @param s
     *            scanner object
     */
    private void cmdSearch(Scanner s) {
        String st = s.next();
        SkipNode<String, Point1> sn1 = storage.search(st);
        if (null == storage.search(st)) {
            System.out.println("Point not found: " + st);
        }
        else {
            System.out.println("Point found: " + sn1.getValue().toString());
            while (sn1.next[0] != null && sn1.next[0].getKey().compareTo(sn1
                .getKey()) == 0) {
                sn1 = sn1.next[0];
                System.out.println("Point found: " + sn1.getValue().toString());
            }
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

}
