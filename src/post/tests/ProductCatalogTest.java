package post.tests;

import post.models.*;
import junit.framework.TestCase;

public class ProductCatalogTest extends TestCase {

    private ProductCatalog pcObj = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );

    protected void setUp() throws Exception {
        super.setUp();
        
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSpecification() {
        //assertEquals( 1, pcObj.specification(111111));
        
        fail("Needs to be reimplemented");
    }
    
    public void testNumberOfItems() {
        
        assertEquals( 10, pcObj.size() );
    }

}
