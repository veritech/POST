package post.gui;

import javax.swing.*;

public class WindowManager {
    
    public static final int ADD_PRODUCT = 0;
    public static final int CASHIER_LOGIN = 1;
    public static final int CHECKOUT = 2;
    
    private static AddProductWindow addProductWindow = new AddProductWindow();
    private static CashierLoginWindow cashierLoginWindow = new CashierLoginWindow();
    private static CheckoutWindow checkoutWindow = new CheckoutWindow();
    
    protected WindowManager() {
        
    }
    
    public static JFrame getInstance( int WindowConstant ) {
        
        switch( WindowConstant ) {
            case ADD_PRODUCT:
                
                return addProductWindow;
                
            case CASHIER_LOGIN:
                
                return cashierLoginWindow;
                
            case CHECKOUT:
                
                return checkoutWindow;
                
            //Ideally should never reach this, but stops warning
            default:
                return null;
        }
    }
    
}
