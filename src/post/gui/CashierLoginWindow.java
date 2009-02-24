package post.gui;

import javax.swing.*;
import java.awt.event.*;

public class CashierLoginWindow extends JFrame implements ActionListener{
    
    JPasswordField loginBox = new JPasswordField();
    JButton loginBtn = new JButton("Login");
    
    protected CashierLoginWindow() {
		super();
		 
		this.setSize( 120, 140 );
		 
		this.setLayout( new BoxLayout( this.getContentPane(), BoxLayout.Y_AXIS ) );
		 
		this.setTitle("Cashier Login");
		
		//Set this window as the action listener	
		loginBtn.setActionCommand( "loginBtn" );
		loginBtn.addActionListener( this );
		
		this.getContentPane().add( loginBox );
		this.getContentPane().add( loginBtn );
    }
    
    
    public void actionPerformed( ActionEvent e ){
    	
    	//Handle events from the login btn
    	if( e.getActionCommand() == "loginBtn"){
    		
    		this.close();
    	}
    }
    
	public void close(){
		this.processWindowEvent( new WindowEvent( this, WindowEvent.WINDOW_CLOSING ) );
	}
}
