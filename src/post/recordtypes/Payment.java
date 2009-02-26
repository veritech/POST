/**
    Payment.java
    Payment class for supermarket application
*/

package post.recordtypes;

public class Payment extends AbstractRecord
{
    private double amount;

    public Payment(double amountIn)
    {
        amount = amountIn;
    }
	
	/*
	* Get payment
	*/
    public double getAmount()
    {
        return amount;
    }
}