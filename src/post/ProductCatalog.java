/**
    The ProductCatalog file acts as a container for
    Product Specs.
    These will be read in from file
*/
package post;

import java.io.*;
import java.util.*;

public class ProductCatalog implements Serializable
{
	
	//Hash table to store unique products
	private Hashtable <Integer, ProductSpec> catalog = new Hashtable();

    public ProductCatalog() 
    {
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
