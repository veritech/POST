package post.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CheckoutWindow extends JFrame implements ActionListener {
    
    //JSpinner subtotal = new JSpinner( new SpinnerNumberModel() );
    JSpinner cashTendered = new JSpinner( new SpinnerNumberModel(0.0,0.0,1000.0,0.1) );
    JButton confirmBtn = new JButton("Ok");
    
    public CheckoutWindow() {
        super();
        
        this.setSize( 120 , 140 );
        
        this.setLayout( new BoxLayout( this.getContentPane(), BoxLayout.Y_AXIS ) );

        this.setTitle("Cash Tendered");
        
        this.getContentPane().add( cashTendered );
        this.getContentPane().add( confirmBtn );
    }
    
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    

}
