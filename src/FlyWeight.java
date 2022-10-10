
/**
 * creates the flyweight for the class so that we can conserve space
 * -any leaf node that does not point to data points instead to the 
 * single flyweight, instantiated inside the quadtree class
 * @author platt, jondef95
 * @version 1
 *
 */
public class FlyWeight implements PRNode
{
    private static FlyWeight instance = new FlyWeight();

    /**
     * creates an empty flyweight
     */
    private FlyWeight()
    {
    }

    /**
     * @return the individual instance of the quadfly
     */
    public static FlyWeight getInstance()
    {
        return instance;
    }

    @Override
    public int dump(int x, int y, int width, int depth)
    {
        String spaces = "";
        for (int i = 0; i < depth; i++)
            spaces += "  ";
        System.out.println(spaces + "Node at " + x + ", " + y + ", "
                + width + ": Empty");
        return 1;
    }

    @Override
    public PRNode insert(int x, int y, int width, Point1 newPoint)
    {
        Leaf newLeaf = new Leaf(newPoint);
        return newLeaf;
    }

    @Override
    public PointList getData()
    {
        return null;
    }

    @Override
    public void duplicates()
    {
    }

    @Override
    public Point1 remove(int x, int y, int width, Point1 searchPoint,
            boolean byName)
    {
        return null;
    }

    @Override
    public PRNode adjustTree(int x, int y, int width)
    {
        return this;
    }
    
    /**
     * @return that this has no unique values
     */
    public int getUnique()
    {
        return 0;
    }

}