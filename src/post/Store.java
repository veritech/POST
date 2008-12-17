/**
    Store.java
    This class has creation responsibilities for Post and ProductCatalog
    It also is associated bi-directionally with Post
*/
package post;

import java.util.*;
import java.io.*;

public class Store
{
        
    //Product catalog
    private ProductCatalog productCatalog = new ProductCatalog();
    
    //
    private Post post;
    
    //Collection of sales
    private Sale[] sales  = new Sale[50];
    
    //Counter, number of sales
    private int index = 0;
    
    /*
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
        sales[index] = saleIn;
        index++;
    }
}