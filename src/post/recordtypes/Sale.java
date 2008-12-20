/**
    Sale.java

    A sale contains SalesLineItems
    
    consider implementing the enumerable interface, to allow quick reading of items
*/
package post.recordtypes;

import java.util.*;

public class Sale extends AbstractRecord
{
    //Date of the current transaction
    private Date date = new Date();
    //Is the sale complete
    private boolean isComplete = false;
    //collection of items in the sale
    private ArrayList<SalesLineItem> lineItems = new ArrayList<SalesLineItem>(200);
    //Payment object, cash provided, change given
    private Payment payment = null;

	/*
	* Make the sale complete
    */
    public void becomeComplete()
    {
        isComplete = true;
    }
	
	/*
	* Check the status of the sale
    */
    public boolean isComplete()
    {
        return isComplete;
    }
	
	/*
	* Add an item to the sale
	*/
    public void makeLineItem(ProductSpec specIn, int quantIn)
    {

        lineItems.add( new SalesLineItem(specIn,quantIn) );
        
    }
	
	public int countLineItems(){
		
		return lineItems.size();
	}
	
	/*
	* get the total value of all items in the sale
	* @return The total of all items with LineItem
	*/
    public double getTotal()
    {
        double total = 0;
   
        for(Iterator<SalesLineItem> i = lineItems.iterator(); i.hasNext(); ){

        	total += i.next().subtotal();
        }
        
        return total;
    }
	
	/*
	* Makes a payment to the total of the sale
	*/
    public void makePayment(double amount)
    {
      	//Odd logic 
        //payment = new Payment(amount-5);
        //new logic
        payment = new Payment(amount);
    }

	/*
	* The balance of the transaction
	*/
    public double getBalance()
    {
        if (payment!=null)
        {
            return payment.getAmount() - getTotal();
        }
        return 0;
    }
    
    public String getKey(){
		return this.date.toString();    
   	}
}
