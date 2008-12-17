/**
    Post.java
    This class acts as controller for the supermarket
    application
*/
package post;

public class Post
{
	
	//Sale object, holds current sale
    private Sale sale = null;
    
   //Product catalog
    private ProductCatalog productCatalog = null;
    
    //Store
    private Store store = null;
	
	/*
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
	* End a sale
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
 		
}

