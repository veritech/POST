/**
	Jonathan Dalrymple
	
	ProductSeachComboBox Adapter
*/
package post.gui.adapters;

import post.models.*;
import post.recordtypes.*;
import javax.swing.*;
import javax.swing.event.ListDataListener;

public class ProductSearchComboBoxAdapter implements ComboBoxModel{
	
    private ProductCatalog productCatalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
	
	private Object currentlySelected;

	/**
     * @see javax.swing.ListModel#addListDataListener(javax.swing.event.ListDataListener)
     */
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.swing.ListModel#getElementAt(int)
     */
    public Object getElementAt(int index) {
    	
    	ProductSpec product = (ProductSpec) productCatalog.read( index );
    	
        return product;
    }

    /**
     * @see javax.swing.ComboBoxModel#getSelectedItem()
     */
    public Object getSelectedItem() {
        // TODO Auto-generated method stub
        return this.currentlySelected;
    }

    /**
     * @see javax.swing.ListModel#getSize()
     */
    public int getSize() {
        return productCatalog.size();
    }

    /**
     * @see javax.swing.ListModel#removeListDataListener(javax.swing.event.ListDataListener)
     */
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
       
    }

    /**
     * @see javax.swing.ComboBoxModel#setSelectedItem(java.lang.Object)
     */
    public void setSelectedItem(Object anItem) {
        // TODO Auto-generated method stub
        this.currentlySelected = anItem;
    }
	
}
