import java.util.Scanner;
import java.io.File;

/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19
 * @version 2
 *
 */
public class CommandFile {
    private SkipList<String, Rectangle> slist;
    private String fileName;

    /**
     * The default constructor for the commandFile class
     * 
     * @param name
     *            The file being read from the given argument
     */
    public CommandFile(String name) {
        this.fileName = name;
        slist = new SkipList<String, Rectangle>();
    }


    /**
     * Main function for running the given commands from the text file
     * @return true if file is found, false otherwise
     */
    public boolean run() {
        Scanner s = null;
        String tName = "";
        int tx;
        int ty;
        int th;
        int tw;
        try {
            s = new Scanner(new File(fileName));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (s != null) {

            while (s.hasNext()) {
                String str = s.next();

                switch (str) {
                    case "insert":
                        tName = s.next();
                        tx = s.nextInt();
                        ty = s.nextInt();
                        tw = s.nextInt();
                        th = s.nextInt();
                        insert(tName, tx, ty, tw, th);
                        break;

                    case "dump":
                        dump();
                        break;

                    case "remove":
                        tName = s.next();
                        if (checkNum(tName)) {
                            tx = Integer.parseInt(tName);
                            ty = s.nextInt();
                            tw = s.nextInt();
                            th = s.nextInt();
                            removeByCoords(tx, ty, tw, th);
                        }
                        else {
                            removeByName(tName);
                        }
                        break;

                    case "regionsearch":
                        tx = s.nextInt();
                        ty = s.nextInt();
                        tw = s.nextInt();
                        th = s.nextInt();
                        regionSearch(tx, ty, tw, th);
                        break;

                    case "intersections":
                        intersections();
                        break;

                    case "search":
                        tName = s.next();
                        search(tName);
                        break;

                    default:
                        break;
                }
            }
            s.close();
            return true;
        }

        else {
            return false;
        }

    }


    /**
     * The insert command takes the given rectangle from the file and adds it to
     * the SkipList
     * 
     * @param name
     *            The name of the rectangle
     * @param x
     *            The x Position of the rectangle
     * @param y
     *            The y Position of the rectangle
     * @param w
     *            The width of the rectangle
     * @param h
     *            The height of the rectangle
     */
    public void insert(String name, int x, int y, int w, int h) {
        Rectangle r;
        String type = name + ", " + x + ", " + y + ", " + w + ", " + h + ")";
        if (checkBounds(x, y, w, h) == false) {
            System.out.println("Rectangle rejected: (" + type);
        }
        else {
            System.out.println("Rectangle inserted: (" + type);
            r = new Rectangle(name, x, y, w, h);
            slist.insert(name, r);
        }
    }


    /**
     * Creates a dump list of all existing elements in the SkipList
     */
    public void dump() {
        SkipNode<String, Rectangle>[] d = slist.dump();
        System.out.println("skipList dump: ");
        if (d.length == 1) {
            System.out.println("Node has depth 1, Value (null)");
        }
        else {
            for (int i = 0; i < d.length; i++) {
                System.out.print("Node has depth " + (d[i].getForward().length)
                    + ", Value (");
                if (d[i].element() != null) {
                    System.out.print(d[i].element().toString() + ")\n");
                }
                else {
                    System.out.print(d[i].element() + ")\n");
                }
            }
        }
        System.out.println("SkipList size is: " + (d.length - 1));
    }


    /**
     * Removes an element based on its Name
     * 
     * @param name
     *            The name of the rectangle
     */
    public void removeByName(String name) {
        SkipNode<String, Rectangle> rem = slist.remove(name);
        if (rem != null) {
            System.out.println("Rectangle removed: (" + rem.element().toString()
                + ")");
        }
        else {
            System.out.println("Rectangle not removed: (" + name + ")");
        }
    }


    /**
     * Removes an element based on its position within a given range
     * 
     * @param x
     *            The x Position of the rectangle
     * @param y
     *            The y Position of the rectangle
     * @param w
     *            The width of the rectangle
     * @param h
     *            The height of the rectangle
     */
    public void removeByCoords(int x, int y, int w, int h) {
        if (checkBounds(x, y, w, h) == false) {
            System.out.println("Rectangle rejected: (" + x + ", " + y + ", " + w
                + ", " + h + ")");
        }
        else {
            Rectangle r = new Rectangle("", x, y, w, h);
            SkipNode<String, Rectangle> rem = slist.remove(r);
            if (rem != null) {
                System.out.println("Rectangle removed: (" + rem.element()
                    .toString() + ")");
            }
            else {
                System.out.println("Rectangle not removed: (" + r.toString()
                    .substring(2) + ")");
            }
        }
    }


    /**
     * Searches for rectangles within a given range
     * 
     * @param x
     *            The x Position of the rectangle
     * @param y
     *            The y Position of the rectangle
     * @param w
     *            The width of the rectangle
     * @param h
     *            The height of the rectangle
     */
    public void regionSearch(int x, int y, int w, int h) {
        String type = x + ", " + y + ", " + w + ", " + h + ")";
        if (w <= 0 || h <= 0) {
            System.out.println("Rectangle rejected: (" + type);
        }
        else {
            System.out.print("Rectangles intersection region (" + type + ":\n");
            Rectangle rj = new Rectangle("", x, y, w, h);
            SkipNode<String, Rectangle>[] d = slist.dump();
            for (int i = 1; i < d.length; i++) {
                Rectangle ri = d[i].element();
                int jxTot = rj.xPos() + rj.getW();
                int ixTot = ri.xPos() + ri.getW();
                int jyTot = rj.yPos() + rj.getH();
                int iyTot = ri.yPos() + ri.getH();
                if (jxTot > ri.xPos() || ixTot > rj.xPos() || jyTot > ri.yPos()
                    || iyTot > rj.yPos()) {
                    System.out.println("(" + ri.toString() + ")");
                }
            }
        }
    }


    /**
     * Parses through the SkipList to find all intersecting pairs
     */
    public void intersections() {
        System.out.println("Intersection pairs: ");
        SkipNode<String, Rectangle>[] d = slist.dump();
        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d.length; j++) {
                if (j != i) {
                    Rectangle rj = d[j].element();
                    Rectangle ri = d[i].element();
                    int jxPos = rj.xPos();
                    int ixPos = ri.xPos();
                    int jyPos = rj.yPos();
                    int iyPos = ri.yPos();

                    int jxTot = jxPos + rj.getW();
                    int ixTot = ixPos + ri.getW();
                    int jyTot = jyPos + rj.getH();
                    int iyTot = iyPos + ri.getH();

                    if (jxTot > ixPos || ixTot > jxPos || jyTot > iyPos
                        || iyTot > jyPos) {
                        System.out.println("(" + rj.toString() + " | " + ri
                            .toString() + ")");
                    }
                }
            }
        }
    }


    /**
     * Searches for an element based on its name
     * 
     * @param name
     *            The name of the rectangle being searched for
     */
    public void search(String name) {
        SkipNode<String, Rectangle>[] search = slist.find(name);
        if (search.length == 1) {
            System.out.println("Rectangle not found: (" + name + ")");
        }
        else {
            System.out.println("Rectangles found:");
            for (int i = 0; i < search.length; i++) {
                if (search[i] != null) {
                    int x = search[i].element().xPos();
                    int y = search[i].element().yPos();
                    int w = search[i].element().getW();
                    int h = search[i].element().getH();
                    System.out.println("(" + search[i].element().getName()
                        + ", " + x + ", " + y + ", " + w + ", " + h + ")");
                }
            }
        }
    }


    /**
     * Helper function to check if a parse is within the accepted boundaries.
     * Parse cannot be less than 0
     * 
     * @param x
     *            The x position of the parse
     * @param y
     *            The y position of the parse
     * @param w
     *            The height of the parse
     * @param h
     *            The width of the parse
     * @return True with the bounds are greater than 0, false otherwise
     */
    public boolean checkBounds(int x, int y, int w, int h) {
        int xAxis = x + w;
        int yAxis = y + h;
        if (x < 0 || x >= 1024 || y < 0 || y >= 1024 || w <= 0 || h <= 0) {
            return false;
        }
        else if (xAxis > 1024 || yAxis > 1024) {
            return false;
        }
        else {
            return true;
        }
    }


    /**
     * Checks to see if the input string is a number
     * 
     * @param s
     *            Name of the rectangle being checked
     * @return True if the input is a number, false otherwise
     */
    private boolean checkNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}