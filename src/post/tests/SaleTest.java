package post.tests;

import junit.framework.TestCase;
import post.models.*;

public class SaleTest extends TestCase {

    private Sale saleA;
        
    protected void setUp() throws Exception {
        super.setUp();
        
        saleA = new Sale();
        
        saleA.addProduct( 111111, 2 );
        
        saleA.addProduct( 111116, 4 );
        
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSize(){
        
        assertEquals( 2, saleA.size() );
    }

    public void testGetTotal() {
        
        assertEquals( 5.5, saleA.getTotal() );

    }

    public void testMakePayment() {

        saleA.makePayment( 6.0 );
        
        assertEquals( 0.5, saleA.getBalance() );
        
    }

    public void testGetBalance() {
        
        assertEquals( 0.0, saleA.getBalance() );
    }
/*
    public void testWillBegin() {
        fail("Not yet implemented");
    }

    public void testBegin() {
        fail("Not yet implemented");
    }

    public void testRollback() {
        fail("Not yet implemented");
    }

    public void testWillEnd() {
        fail("Not yet implemented");
    }

    public void testEnd() {
        fail("Not yet implemented");
    }

    public void testAddListDataListener() {
        fail("Not yet implemented");
    }
    
    public void testRemoveListDataListener() {
        fail("Not yet implemented");
    }
*/

}
