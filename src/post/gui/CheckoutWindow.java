package post.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import post.models.*;


public class CheckoutWindow extends JFrame implements ActionListener {
    
    //JSpinner subtotal = new JSpinner( new SpinnerNumberModel() );
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
			
			this.close();
		}

    }

	public void close(){
		this.processWindowEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
	}
}
