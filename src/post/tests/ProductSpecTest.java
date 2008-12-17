/*
	Jonathan Dalrymple
	
	Test case for Product Spec[ification] class
	
	December 17, 2008

*/
package post.tests;

import junit.framework.TestCase;
import post.ProductSpec;

public class ProductSpecTest extends TestCase {
	
	private ProductSpec productA = new ProductSpec(111111, "Chick Peas 500g", 0.75 );
	private ProductSpec productB = new ProductSpec(111112, "Tomatoes 500g", 0.45 );
	private ProductSpec productC = new ProductSpec(111113, "Mushy Peas  6 X 350g", 1.50 );
	private ProductSpec productD = new ProductSpec(111114, "Hobgoblin Ale", 1.62);
	
    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetUpc() {
        
        assertEquals( productA.getUpc(), 111111 );
        assertEquals( productB.getUpc(), 111112 );
        assertEquals( productC.getUpc(), 111113 );
        assertEquals( productD.getUpc(), 111114 );
        
    }

    public void testGetPrice() {
        assertEquals( productA.getPrice(), 0.75 );
        assertEquals( productB.getPrice(), 0.45 );
        assertEquals( productC.getPrice(), 1.50 );
        assertEquals( productD.getPrice(), 1.62 );
    }

    public void testGetDescription() {
		assertEquals( productA.getDescription(), "Chick Peas 500g" );
		assertEquals( productB.getDescription(), "Tomatoes 500g" );
		assertEquals( productC.getDescription(), "Mushy Peas  6 X 350g" );
		assertEquals( productD.getDescription(), "Hobgoblin Ale" );
    }

}
