/**
    ProductSpec.java
    Specification of a product in the context of
    a supermarket application
*/
package post.recordtypes;

import post.recordtypes.AbstractRecord;

public class ProductSpec extends AbstractRecord 
{
    private String description = "";
    private double price = 0;
    private int upc = 0;
    
    public ProductSpec(int upcIn,String descIn, double priceIn)
    {
        
        description = descIn;
        price = priceIn;
        upc = upcIn;
    }
	
	/*
	* Get the products UPC code
	* @return int product UPC code
	*/
    public int getUpc()
    {
        return upc;
    }
	
	/*
	* Get the price of the product
	* @return double price of the object
	*/
    public double getPrice()
    {
        return price;
    }
	
	/*
	* Get the description of the product
	* @return String description
	*/
    public String getDescription()
    {
        return description;
    }
	
	public String toString(){
		return description;
	}
	/*
	* Output the details of the product
	*/
    public void display()
    {
        System.out.println("UPC: " + upc);
        System.out.println("Desc: " + description);
        System.out.println("Price: " + price);
    }
    
    public String getKey(){
    	return String.valueOf( this.upc );
    }
}