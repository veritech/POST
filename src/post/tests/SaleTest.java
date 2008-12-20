/*
	Jonathan Dalrymple
	
	Test case for Sale class
	
	December 17, 2008

*/
package post.tests;

import junit.framework.TestCase;
import post.*;
import post.recordtypes.ProductSpec;
import post.recordtypes.Sale;

public class SaleTest extends TestCase {
	
	private Sale saleA;
	
	//Sample products
	private ProductSpec productSpecA;
	private ProductSpec productSpecB;
	
    protected void setUp() throws Exception {
        super.setUp();
        
        saleA = new Sale();
        
        productSpecA = new ProductSpec(111111, "Chick Peas 500g", 0.75 );
        productSpecB = new ProductSpec(111112, "Tomatoes 500g", 0.45 );
       	
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testBecomeComplete() {

        
        //fail("Not yet implemented");
    }

    public void testIsComplete() {
        
        assertFalse( saleA.isComplete() );

    }

    public void testMakeLineItem() {

        saleA.makeLineItem( productSpecB, 10 );
        
        assertEquals( 1, saleA.countLineItems() );
    }

    public void testGetTotal() {
		
		saleA.makeLineItem( productSpecA, 10 );
		
		assertEquals( 7.50, saleA.getTotal() );
    }

/*
    public void testMakePayment() {
        fail("Not yet implemented");
    }
*/

    public void testGetBalance() {
		
		//Purchase product
		saleA.makeLineItem( productSpecB, 10 );
		//make a payment
		saleA.makePayment( 10.00 );
		
		//Test
		assertEquals( 5.5, saleA.getBalance() );
    }

}
