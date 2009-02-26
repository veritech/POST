package post.gui;

import javax.swing.*;

public class WindowManager {
    
    public static final int ADD_PRODUCT = 0;
    public static final int CASHIER_LOGIN = 1;
    public static final int CHECKOUT = 2;
    public static final int REMOVE_PRODUCT = 4;
    public static final int SALES_LOG = 5;
    
    private static AddProductWindow addProductWindow = new AddProductWindow();
    private static CashierLoginWindow cashierLoginWindow = new CashierLoginWindow();
    private static CheckoutWindow checkoutWindow = new CheckoutWindow();
    private static RemoveProductWindow removeProductWindow = new RemoveProductWindow();
    private static SalesLogWindow salesLogWindow = new SalesLogWindow();
    
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
                
            case REMOVE_PRODUCT:
                
                return removeProductWindow;
            
            case SALES_LOG:
                
                return salesLogWindow;
            //Ideally should never reach this, but stops warning
            default:
                return null;
        }
    }
    
}
