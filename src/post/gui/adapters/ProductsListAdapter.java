package post.gui.adapters;

import post.models.*;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ProductsListAdapter implements ListModel {
	
	private ProductCatalog productCatalog;
	
	public ProductsListAdapter(){
		
		productCatalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
		
	}
	
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

    public Object getElementAt(int index) {
        // TODO Auto-generated method stub
        return "String";
    }

    public int getSize() {
        return productCatalog.length();
    }

    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub

    }

}
