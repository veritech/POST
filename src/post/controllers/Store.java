/**
    Store.java
    This class has creation responsibilities for Post and ProductCatalog
    It also is associated bi-directionally with Post
*/
package post.controllers;

import java.util.*;
import java.io.*;

import post.models.*;
import post.recordtypes.*;

public class Store extends Controller
{
        
    //reference to the post model
    private Post post;
    
    //Product catalog Model
    private ProductCatalog productCatalog;
    
    //Sales Model
    private Sales sales;
	
	public Store(){
		
		//Get a model instance from the manager model
		productCatalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
		sales = (Sales) ModelManager.getInstance( ModelManager.SALES );
		
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