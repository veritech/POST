/**
    Store.java
    This class has creation responsibilities for Post and ProductCatalog
    It also is associated bi-directionally with Post
*/
package post.controllers;

import post.models.*;
import post.recordtypes.*;

public class Store extends Controller
{
        
    //reference to the post model
    private Post post;
    
    //The Below variables use a manager to load a singleton instance
    //Product catalog Model
    private ProductCatalog productCatalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
    
    //Sales Model
    private Sales sales = (Sales) ModelManager.getInstance( ModelManager.SALES );
	
	//Public constructor	
	public Store(){

	}
	
    /*
    *  
    *
    * @return 
    */
    public Post addPost()
    {
        post = new Post(productCatalog,this);
        return post;
    }

	/*
	* Add a sale to the internal store
	*
	* @param saleIn A sale object to be added to the internal collection
	*/
    public void addSale(Sale saleIn)
    {
        sales.add(saleIn);

    }
}