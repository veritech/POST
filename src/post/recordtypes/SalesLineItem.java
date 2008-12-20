/**
    SalesLineitem.java
    Part of a sale in the supermarket application
*/
package post.recordtypes;

//import post.*;

public class SalesLineItem
{
    private int quantity = 0;
    private ProductSpec productSpec= null;


    public SalesLineItem(ProductSpec specIn, int quantIn)
    {
        productSpec = specIn;
        quantity = quantIn;
    }

    public double subtotal()
    {
        if(productSpec != null)
        {
            return productSpec.getPrice() * quantity;
        }
        else
            return 0.0;
    }
}