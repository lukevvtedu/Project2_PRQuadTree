import student.TestCase;
public class LeafTest extends TestCase{
    
    private Leaf leaf1;
    private PRNode leaf;
    
    public void setUp() {
        leaf = PRQuadTree.FLYLEAF;
    }
    
    public  void testAdjustTree() {
        Point1 p1 = new Point1("a", 20, 20);
        leaf.insert(1, 1, 0, p1);
        assertEquals(leaf.adjustTree(20, 20, 3), leaf);
    }
    
    public void testDump() {
        
    }
}
