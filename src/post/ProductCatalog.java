/**
    The ProductCatalog file acts as a container for
    Product Specs.
    These will be read in from file
*/
package post;

import java.io.*;
import java.util.*;

public class ProductCatalog
{
	
	//filename constant 
	private final static String CATALOG_FILENAME = "catalog.ser";
	
	//Hash table to store unique products
	private Hashtable <Integer, ProductSpec> catalog;

    public ProductCatalog() 
    {
    	
    	//If the catalog is empty load a new one from disk
    	if( catalog == null ){
    		this.load();
    	}
    	
    	
	}
	
	/*
	*	Load the internal store from a file
	*/
	public void load(){
		
		try{
			
			FileInputStream fileIn = new FileInputStream( CATALOG_FILENAME );
			
			ObjectInputStream in = new ObjectInputStream( fileIn );
			
			catalog = (Hashtable<Integer,ProductSpec>) in.readObject();
			
		}
		catch(Exception e ){
			
			System.out.println(e);
			
		}
	}
	
	/*
	*	Save the internal store to a file
	*/
	public void save(){
		
		try{
			
			FileOutputStream fileOut = new FileOutputStream( CATALOG_FILENAME );
			
			ObjectOutputStream out = new ObjectOutputStream( fileOut );
			
			out.writeObject( catalog );
			
			out.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	/*
	* Return the Product specification for a given a UPC code
	* @return ProductSpec the product specification for the given UPC
	*/
    public ProductSpec specification(int upc)
    {
        
        //Box the passed int;
        return catalog.get( (Integer) upc );
        
/*        
        if(upc == 111119)
            return new ProductSpec(111119,"Bread",.75);
        else if (upc == 111120)
            return new ProductSpec(111120, "Biscuits", .45);
        else if (upc == 111121)
            return new ProductSpec(111121, "Anchovies", 1.5);
        else 
            return new ProductSpec(111122, "Dog Food", 1.62);
*/
    }
		
}
