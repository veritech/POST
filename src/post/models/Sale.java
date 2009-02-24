/**
    Sale.java

    A sale contains SalesLineItems
    
    consider implementing the enumerable interface, to allow quick reading of items
*/
package post.models;

import java.util.*;

import post.recordtypes.*;

public class Sale extends Model implements iTransaction
{
    //Date of the current transaction
    private Date date;

    //Is the sale complete
    private boolean isComplete = false;

    //Payment object, cash provided, change given
    private Payment payment = null;
	
	
	/**
	* Default constructor
	*
	*/
	public Sale(){
		super();
		//Call super explictly 
		
		date = new Date();
		payment = null;
		isComplete = false;
	}
	
	/**
	* Overloaded model.add method, handles a product catalog lookup
	*
	* @param upc the upc code of the product that you wish to add
	* @param quantity The number of items to add to this line item
	*/
	public void addProduct( int upc, int quantity ){
		
		//load up the models using the manager
		ProductCatalog productCatalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
		
		//Create a new saleslineitem and add it to the collection
		this.add( new SalesLineItem( productCatalog.specification( upc ), quantity ) ); 

	}
	
	/**
	* Get the total value of all items in the sale
	* @return The total of all items with LineItem
	*/
    public double getTotal()
    {
        double total = 0;
   
        for( Enumeration e = this.elements(); e.hasMoreElements(); ){

        	SalesLineItem item = (SalesLineItem) e.nextElement();
        	
        	total += item.subtotal();
        	
        }
        
        return total;
    }
	
	/**
	* Makes a payment to the total of the sale
	*
	* @return The amount of the balance to settle
	*/
    public void makePayment(double amount)
    {
      	//Odd logic 
        //payment = new Payment(amount-5);
        //new logic
        payment = new Payment(amount);
    }

	/**
	* The balance of the transaction
	* @return The balance of the transaction
	*/
    public double getBalance()
    {
        if (payment!=null)
        {
            return payment.getAmount() - getTotal();
        }
        return 0;
    }
   	
   	//Transactional Methods
   	
   	public void willBegin(){
   	
   	}
   	/**
   	* Start the transaction, and clear the backingstore
   	*
   	*/
   	public void begin(){
   		this.isComplete = false;
   		
   		//Clear the backing store
   		this.removeAllElements();
   		
   		this.payment = null;
   	}
   	
   	/**
   	* Revert to the state before the last addition
   	*
   	*/
   	public void rollback(){
   		// TODO Needs to be reimplemented
   		/*
   		if( !this.isComplete && this.backingStore.size() > 0 ){
   			
   			//remove the last element
   			this.backingStore.remove( this.backingStore.size() - 1 );
   			
   		}
		*/
   	}
   	
   	public void willEnd(){
   	
   	}
   	/**
   	* End the current transaction 
   	*/
   	public void end(){
   		
   		this.isComplete = true;
   	}
   	
}
