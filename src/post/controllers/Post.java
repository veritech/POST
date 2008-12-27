/**
    Post.java
    This class acts as controller for the supermarket
    application
*/
package post.controllers;

import post.models.*;
import post.recordtypes.*;

public class Post extends Controller
{
	
	//Sale object, holds current sale
    private Sale sale = null;
    
   //Product catalog
    private ProductCatalog productCatalog = null;
    
    //Store
    private Store store = null;
	
	/*
	* Constructor 
	*
	* @param pcIn Prodcut catalog object
	* @param stIn Store object
	*/
    public Post(ProductCatalog pcIn, Store stIn)
    {
        productCatalog = pcIn;
        store = stIn;

	}

	/*
	* Begin a new sale
	* @return status of the current sale
	*/
    public boolean isNewSale()
    {
        return (sale == null || sale.isComplete());
    }

	/*
	* Insert new data into product catalogue
	*/
    public void enterItem(int upc, int quantIn)
    {
        ProductSpec ps = productCatalog.specification(upc);

        if(isNewSale())
        {
            sale = new Sale();
        }
        sale.makeLineItem(ps, quantIn);
    }

	/*
	* Start a new sale
	* Called at the start of each transaction
	*/
	public void startSale(){
		// TODO Complete function
		sale = new Sale();
	}

	/*
	* End a sale
	* Called to calculate the total of the transaction
	* 
	*/
    public double endSale()
    {
        if (sale!= null)
        {
            sale.becomeComplete();
            return sale.getTotal();
        }
        return 0.0;
    }

	/*
	* Make a transaction
	* 
	*/
    public double makePayment(double cash)
    {
        double total = sale.getTotal();

        sale.makePayment(total);
        store.addSale(sale);
        return cash - total;
    }
    
    /**
    *	Extract the sale from
    *	@return sale the current sale;
    */
    public Sale getSale(){
    	return this.sale;
    }
    
    public void save(){
    	productCatalog.save();
    }
 		
}

