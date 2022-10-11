/**
 * The default class for reading and running the commands from a text file
 * 
 * @author oehlingr19 and lukev
 * @version 3
 *
 */
public class PointNode {

    private PointNode next;
    private Point1 data;

    /**
     * Default constructor for pointnode
     * 
     * @param p
     */
    public PointNode(Point1 p) {
        data = p;
        next = null;
    }

    /**
     * gets the next node
     * 
     * @return next node
     */
    public PointNode getNext() {
        return next;
    }


    /**
     * sets the next data for the node
     * 
     * @param pd
     *            data for node
     */
    public void setData(Point1 pd) {
        data = pd;
    }
    
    /**
     * sets the next node
     * 
     * @param pn
     *            next node
     */
    public void setNext(PointNode pn) {
        next = pn;
    }

    /**
     * gets the data of the node
     * 
     * @return data of node
     */
    public Point1 getData() {
        return data;
    }
}
