package post.tests;

import post.models.*;
import post.recordtypes.ProductSpec;
import junit.framework.TestCase;

public class ProductCatalogTest extends TestCase {

    private ProductCatalog pcObj;

    protected void setUp() throws Exception {
        super.setUp();
        
        pcObj = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
        
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testProduct1() {
        //assertEquals( 1, pcObj.specification(111111));
        
        //Test a product
        ProductSpec product = pcObj.specification( 111111 );
        
        assertEquals( 111111, product.getUpc() );
        
        assertEquals( 0.75, product.getPrice() );
        
        assertEquals( "Chick Peas 500g", product.getDescription() );
    }

    public void testProduct2(){
        //Test another product
        ProductSpec product = pcObj.specification( 111112 );
        
        assertEquals( 111112, product.getUpc() );
        
        assertEquals( 0.45, product.getPrice() );
        
        assertEquals( "Tomatoes 500g", product.getDescription() );
        
    }
    
    public void testProduct3(){
        //Test another product
        ProductSpec product = pcObj.specification( 111113 );
        
        assertEquals( 111113, product.getUpc() );
        
        assertEquals( 1.50, product.getPrice() );
        
        assertEquals( "Mushy Peas  6 X 350g", product.getDescription() );
        
    }
    
    public void testProduct4(){
        //Test another product
        ProductSpec product = pcObj.specification( 111114 );
        
        assertEquals( 111114, product.getUpc() );
        
        assertEquals( 1.62, product.getPrice() );
        
        assertEquals( "Hobgoblin Ale", product.getDescription() );
        
    }
    
    public void testProduct5(){
        //Test another product
        ProductSpec product = pcObj.specification( 111115 );
        
        assertEquals( 111115, product.getUpc() );
        
        assertEquals( 8.50, product.getPrice() );
        
        assertEquals( "Haute Cote de Beaune", product.getDescription() );
        
    }
    
    public void testProduct6(){
        //Test another product
        ProductSpec product = pcObj.specification( 111116 );
        
        assertEquals( 111116, product.getUpc() );
        
        assertEquals( 1.00, product.getPrice() );
        
        assertEquals( "Economy Beans 6 X 500g", product.getDescription() );
        
    }
    
    public void testProduct7(){
        //Test another product
        ProductSpec product = pcObj.specification( 111117 );
        
        assertEquals( 111117, product.getUpc() );
        
        assertEquals( 2.50, product.getPrice() );
        
        assertEquals( "Pork Sausages 500g", product.getDescription() );
        
    }
    
    public void testProduct8(){
        //Test another product
        ProductSpec product = pcObj.specification( 111118 );
        
        assertEquals( 111118, product.getUpc() );
        
        assertEquals( 0.50, product.getPrice() );
        
        assertEquals( "Vegetable Samosa", product.getDescription() );
        
    }
    
    public void testProduct9(){
        //Test another product
        ProductSpec product = pcObj.specification( 111119 );
        
        assertEquals( 111119, product.getUpc() );
        
        assertEquals( 0.87, product.getPrice() );
        
        assertEquals( "Chicken Pot Noodle", product.getDescription() );
        
    }
    
    public void testNumberOfItems() {
        
        assertEquals( 9, pcObj.size() );
    }

}
