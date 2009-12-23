package post.tests;

import post.gui.adapters.ProductSearchComboBoxAdapter;
import post.models.ModelManager;
import post.models.ProductCatalog;
import junit.framework.TestCase;

public class ProductSearchComboBoxAdapterTest extends TestCase {
    
    private ProductSearchComboBoxAdapter obj;
    private ProductCatalog productCatalog;

    protected void setUp() throws Exception {
        super.setUp();
        
        obj = new ProductSearchComboBoxAdapter();
        productCatalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /*
    public void testAddListDataListener() {
        fail("Not yet implemented"); // TODO
    }*/

    public void testGetElementAt() {
        
        assertEquals( productCatalog.elementAt(2), obj.getElementAt(2) );
        
    }

    public void testGetSelectedItem() {
        assertNull( obj.getSelectedItem() );
        
        obj.setSelectedItem( productCatalog.elementAt(2) );
        
        assertEquals( productCatalog.elementAt(2), obj.getSelectedItem() );
    }

    public void testGetSize() {
        
        assertEquals(9 ,obj.getSize() );
        
    }
    /*
    public void testRemoveListDataListener() {
        fail("Not yet implemented"); // TODO
    }

    //Doesn't need to be tested as it is covered by the get selected item test
    public void testSetSelectedItem() {
        fail("Not yet implemented"); // TODO
    }
    */
}
