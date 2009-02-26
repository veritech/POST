package post.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import post.models.*;
import post.controllers.*;


public class CheckoutWindow extends Window{
    
    JSpinner cashTendered = new JSpinner( new SpinnerNumberModel(0.0,0.0,1000.0,0.1) );
    JButton confirmBtn = new JButton("Confirm");
    
    public CheckoutWindow() {
        super();
        
        this.setSize( 200 , 140 );
        
        this.setLayout( new BoxLayout( this.getContentPane(), BoxLayout.Y_AXIS ) );

        this.setTitle("Cash Tendered");
        
        confirmBtn.setActionCommand("confirmBtn");
       	confirmBtn.addActionListener( this );
        
        cashTendered.setForeground( Color.GREEN );
        cashTendered.setBackground( Color.BLACK );
        cashTendered.setFont( new Font(null, Font.BOLD, 24) );
        
        this.getContentPane().add( cashTendered );
        this.getContentPane().add( confirmBtn );
        
    }
    
    public void actionPerformed(ActionEvent e) {
        
		if( e.getActionCommand() == "confirmBtn" ){
			//TODO Handle Confirm Button event
			
			Sale sale = (Sale) ModelManager.getInstance( ModelManager.CURRENT_SALE );
			
			sale.makePayment( (Double) cashTendered.getValue() );
			
			//This code should be moved from the UI into a controller class, ideally store
			if( sale.getBalance() >= 0 ){
				
				Store.getInstance().endSale();
				
				//Not enough to complete tranasction
				JOptionPane.showMessageDialog( this, 
				"Current sale completed",
				"Sale Complete",
				JOptionPane.INFORMATION_MESSAGE
				);
				
				this.close();
			}else{
				
				//Not enough to complete tranasction
				JOptionPane.showMessageDialog( this, 
				"This payment is not large enough to complete the transaction",
				"Insufficient Payment",
				JOptionPane.WARNING_MESSAGE
				);
			}
			
			
		}

    }


}
