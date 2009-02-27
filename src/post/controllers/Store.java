/**
    Store.java
    This class has creation responsibilities for Post and ProductCatalog
    It also is associated bi-directionally with Post
*/
package post.controllers;

import post.models.*;

public class Store extends Controller
{
    
    //Singleton instance of store
    private static Store instance;
    
    //The Below variables use a manager to load a singleton instance
    //Product catalog Model
    private ProductCatalog productCatalog;
	
	//Delegate for monitoring transaction, delegate requires a copy of the class 
	private Post delegate = new Post(this);
	
	//Current sale object
	private Sale currentSale = (Sale) ModelManager.getInstance( ModelManager.CURRENT_SALE );
	
	/**
	*
	*	Public constructor
	*/
	private Store(){
		 productCatalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );

	}

	/**
	* Sell an item [lineItem] to the current sale
	*
	* @param upc The upc of the item to be added to the sale
	* @param quantity the number of items to be added to the sale
	*/
    public void buyItem( int upc, int quantity ){
    	
    	System.out.println("Added the flowing " + upc + " @ " + quantity );
    	//Calls overloaded add method
    	currentSale.addProduct( upc, quantity );	
    }
    
    /**
    * Remove a item from the current sale
    *
    * @param upc of the item to be removed
    */
    public void removeItem( int upc ){
   		currentSale.remove( upc );
    }
    
    public void applicationWillBegin(){
    	
    	delegate.applicationWillBegin();
    	
    }
    
    /**
    * Start a new sale
    *
    */
    public void startSale(){
    	
    	delegate.willBegin();
    	
    	//If a sale doesn't exist create one
    	this.currentSale.begin();
    	
    	delegate.begin();
    }
    
    /**
    * End a sale
    *
    * @return The sale subtotal
    */
    public double endSale(){
    	
    	double retVal;
    	
    	//Alert delegate will end
    	delegate.willEnd();
    	
    	retVal = this.currentSale.getTotal();
    	
    	this.currentSale.end();
    	//alert delegate has eneded
    	delegate.end();
    	
    	return retVal;
    }
    
    /**
    *	Get instance 
    *
    *
    */
    public static Store getInstance(){
    
    	if( instance == null ){
    		instance = new Store();
    	}
    	
    	return instance;
    }
    
    
    //Serialization methods
    /**
    *	Save method
    */
    public void save(){
    	ModelManager.save( ModelManager.PRODUCT_CATALOG );
    }
    
}