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
        // TODO Implement addListDataListener method

    }

    public Object getElementAt(int index) {
        // TODO Implement getElementAt method
        return productCatalog.read( index );
    }

    public int getSize() {
        return productCatalog.size();
    }

    public void removeListDataListener(ListDataListener l) {
        // TODO Implement removeListDataListener

    }

}
