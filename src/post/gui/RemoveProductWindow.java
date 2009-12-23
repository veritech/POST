package post.gui;

import java.awt.event.ActionEvent;
import javax.swing.*;

import post.models.*;
import post.recordtypes.ProductSpec;

public class RemoveProductWindow extends Window{
    
    private ProductCatalog catalog = (ProductCatalog) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
    private JList productList = new JList( catalog );
    private JButton deleteBtn = new JButton("Remove Product");
    private JButton closeBtn = new JButton("Close");
    
    public RemoveProductWindow() {
        super();
        
        this.setSize( 180, 240 );
        
        deleteBtn.setActionCommand("deleteBtn");
        closeBtn.setActionCommand("closeBtn");
        
        deleteBtn.addActionListener( this );
        closeBtn.addActionListener( this );        
        
        this.setLayout( new BoxLayout( this.getContentPane(), BoxLayout.Y_AXIS ) );
        
        this.setTitle("Remove Product");
        
        this.add( new JScrollPane( productList ) );
        this.add( deleteBtn );
        this.add( closeBtn );
        
    }
    
    public void actionPerformed(ActionEvent event) {
        // TODO Auto-generated method stub
        
        if( event.getActionCommand() == "deleteBtn" ) {
            //Remove the selected Element
            try {
                ProductSpec product = (ProductSpec) productList.getSelectedValue();
                
                catalog.removeElement( product );
                
            }
            catch( Exception e ) {
                System.out.println("Failed to get product object");
                e.printStackTrace();
            }

        }
        else if( event.getActionCommand() == "closeBtn" ){
            this.close();
        }
        
    }
}
