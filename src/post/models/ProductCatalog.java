/**
    The ProductCatalog file acts as a container for
    Product Specs.
    These will be read in from file
*/
package post.models;

import java.io.*;
import java.util.*;

import post.recordtypes.ProductSpec;

public class ProductCatalog extends Model
{
	
    public ProductCatalog() 
    {
    	super.name = "ProductCatalog";	
	}
	
	/*
	* Return the Product specification for a given a UPC code
	* @return ProductSpec the product specification for the given UPC
	*/
    public ProductSpec specification(int upc)
    {

        //Box the passed int;
        return (ProductSpec) this.read( String.valueOf(upc) );
        
    }
		
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
