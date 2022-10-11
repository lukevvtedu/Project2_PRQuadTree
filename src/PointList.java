/**
 * basic linked list implementation; based on storing Points
 * 
 * @author oehlingr19 and lukev
 * @version 1
 */
public class PointList {
    
    private PointNode point;
    private int size;
    private int unique;
    private boolean dupe;

    /**
     * default constructor for the LinkedList
     */
    public PointList() {
        point = null;
        size = 0;
        unique = 0;
        dupe = true;
    }


    /**
     * creates a LinkedList based on a single node
     * 
     * @param p1
     *            the data that will start the list
     */
    public PointList(Point1 p1) {
        point = new PointNode(p1);
        size = 1;
        unique = 1;
        dupe = true;
    }


    /**
     * This method returns the duplicate points in the linked
     * list
     */
    public void outputDupes() {
        PointNode p3 = point;
        String out = "";
        while (p3.getNext() != null) {
            if (p3.getData().equals(p3.getNext().getData())) {
                if (!(out.contains(p3.getNext().getData()
                    .outputCoord()))) {
                    out += p3.getNext().getData().outputCoord();
                    System.out.println(p3.getNext().getData().outputCoord());
                }
            }
            p3 = p3.getNext();
        }
    }


    /**
     * get the pointer to the point of the list
     * 
     * @return the point of the list
     */
    public PointNode getHead() {
        return point;
    }

    /**
     * removes the point from the list, and replaces the point with the next node
     * 
     * @return the data stored in the point of the node
     */
    public Point1 removeHead() {
        if (point.getNext() != null) {
            Point1 p2 = point.getData();
            point = point.getNext();
            return p2;
        }
        else {
            Point1 out = point.getData();
            point = null;
            return out;
        }
    }


    /**
     * inserts a specific Point into the list; inserts at the end so that it can
     * be determined if there are any dupe in the list; sorted by
     * coordinate in ascending order, first by x coordinate, then by y
     * coordinate
     * 
     * @param newPoint
     *            the Point that will be added to the node
     */
    public void insert(Point1 newPoint) {
        PointNode n1 = new PointNode(newPoint);
        if (point == null) {
            point = n1;
            unique++;
            size++;
        }
        else {
            PointNode p3 = point;
            while (p3.getNext() != null) {
                if (!p3.getData().equals(newPoint))
                    dupe = false;
                if (newPoint.compareTo(p3.getData()) >= 0) {
                    n1.setNext(p3.getNext());
                    p3.setNext(n1);
                    size++;
                    return;
                }
                p3 = (p3.getNext());
            }
            p3.setNext(n1);
            size++;
        }
    }



    /**
     * get the size of the list; size should not include dupe
     * 
     * @return size of the list, no dupe
     */
    public int getSize() {
        return size;
    }


    /**
     * changes the size of the list depending on whether unique points exist
     */
    public void resize() {
        if (point == null) {
            size = 0;
            unique = 0;
        }
        else {
            PointNode p3 = point;
            int s1 = 1;
            int u1 = 1;
            while (p3.getNext() != null) {
                if (!p3.getData().equals(p3.getNext().getData())) {
                    u1++;
                }
                s1++;
                p3 = p3.getNext();
            }
            size = s1;
            unique = u1;
        }
    }


    /**
     * removes a point and checks to see whether it is supposed
     * to be returned by name or by value. if by name will check against
     * other points in the linked list
     * 
     * @param ps
     *            the value to be found
     * @param name
     *            whether to search by name
     * @return the point removed
     */
    public Point1 remove(Point1 ps, boolean name) {
        PointNode p3 = point;
        if (p3 == null)
            return null;
        if (p3.getData().equals(ps)) {
            resize();
            return removeHead();
        }
        while (p3.getNext() != null) {
            if (p3.getNext().getData().equals(ps)) {
                if (!name) {
                    PointNode p2 = p3.getNext();
                    p3.setNext(p3.getNext().getNext());
                    p2.setNext(null);
                    resize();
                    return p2.getData();
                }
                else if (p3.getNext().getData().getName().compareTo(
                    ps.getName()) == 0) {
                    PointNode p2 = p3.getNext();
                    p3.setNext(p3.getNext().getNext());
                    p2.setNext(null);
                    resize();
                    return p2.getData();
                }
            }
            p3 = p3.getNext();
        }
        return null;
    }


    /**
     * returns whether or not the list contains only a unique point
     * 
     * @return true if there is only one unique set of coordinates in the list,
     *         false otherwise
     */
    public boolean onlyDuplicates() {
        return dupe;
    }


    /**
     * @return the number of unique elements in the list
     */
    public int getUnique() {
        return unique;
    }

}
