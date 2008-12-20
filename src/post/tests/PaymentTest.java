/*
	Jonathan Dalrymple
	
	Test case for Payment class
	
	December 17, 2008

*/
package post.tests;

import junit.framework.TestCase;
import post.recordtypes.Payment;

public class PaymentTest extends TestCase {
	
	private Payment a = new Payment(0.99);
	private Payment b = new Payment(-0.99);
	private Payment c = new Payment(99.99);
	
    protected void setUp() throws Exception {
        super.setUp();
        
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetAmount() {
        //fail("Not yet implemented");
        assertEquals( a.getAmount(), 0.99 );
        
        assertEquals( b.getAmount(), -0.99 );
        
        assertEquals( c.getAmount(), 99.99 );
    }

}
