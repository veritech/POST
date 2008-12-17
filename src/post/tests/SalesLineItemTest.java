/*
	Jonathan Dalrymple
	
	Test case for Sales Line Item class
	
	December 17, 2008

*/
package post.tests;


import junit.framework.TestCase;
import post.*;

public class SalesLineItemTest extends TestCase {
	
	private SalesLineItem salesLineItemA;
	private SalesLineItem salesLineItemB;
	
    protected void setUp() throws Exception {
        super.setUp();
        
        ProductSpec productSpecA = new ProductSpec(111111, "Chick Peas 500g", 0.75 );
        
        //Single
        salesLineItemA = new SalesLineItem( productSpecA, 1 );
        //Multiple
        salesLineItemB = new SalesLineItem( productSpecA, 10 );

    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSubtotalWithSingleItem() {
		
		assertEquals( 0.75, salesLineItemA.subtotal() );
		
    }
    
    public void testSubtotalWithMultipleItems(){
    	
    	assertEquals( 7.50, salesLineItemB.subtotal() );
    	
    }

}
