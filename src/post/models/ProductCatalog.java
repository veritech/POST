/**
    The ProductCatalog file acts as a container for
    Product Specs.
    These will be read in from file
*/
package post.models;

import post.recordtypes.ProductSpec;
import java.util.*;

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

        //loop through the collection and look for the upc
        ProductSpec retVal = null;
        
        for( Enumeration e = this.elements(); e.hasMoreElements(); ){
        	//Get the next object
        	ProductSpec spec = (ProductSpec) e.nextElement();
        	
        	//Does the upc match
        	if( spec.getUpc() == upc ){
        		retVal = spec;
        		break;
        	}
        }
        
        return retVal;
        
    }
		
}
