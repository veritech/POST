package post.tests;

import junit.framework.TestCase;
import post.models.*;
import post.recordtypes.*;

public class SaleTest extends TestCase {

    private Sale saleA;
    
    //Sample products
    private ProductSpec productSpecA;
    private ProductSpec productSpecB;
    
    protected void setUp() throws Exception {
        super.setUp();
        
        saleA = new Sale();
        
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAddIntInt() {
        saleA.addProduct( 111111, 2 );
        
        assertEquals(1, saleA.size() );
    }

    public void testGetTotal() {
        
        saleA.addProduct( 111111, 2 );
        
        assertEquals( 0.9, saleA.getTotal() );
        
        saleA.addProduct( 111112, 4 );
        
        assertEquals( 2.7, saleA.getTotal() );
    }

    public void testMakePayment() {
        
        saleA.addProduct( 111111, 2 );
        
        saleA.makePayment( 2.0 );
        
        assertEquals( 1.1, saleA.getBalance() );
        
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
    public void testGetElementAt() {
        
        saleA.addProduct( 111111, 2 );
        
        //assertEquals( productSpecA, saleA.getElementAt(1) );
    }

    public void testGetSize() {
        
        assertEquals( 0, saleA.getSize() );
    }

}
