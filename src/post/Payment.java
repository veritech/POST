/**
    Payment.java
    Payment class for supermarket application
*/

package post;

public class Payment
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