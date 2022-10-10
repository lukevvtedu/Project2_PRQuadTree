import student.TestCase;
public class LeafTest extends TestCase{
    
    private Leaf leaf1;
    private PRNode leaf;
    
    public void setUp() {
        leaf = PRQuadTree.FLYLEAF;
    }
    
    public  void testAdjustTree() {
        Point1 p1 = new Point1("a",0 ,1);
        leaf1.insert(1, 1, 0, p1);
        assertEquals(leaf1.adjustTree(1, 2, 3), leaf);
    }
}
