package post.gui;

import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import post.models.ModelManager;

public class SalesLogWindow extends Window {
    
    private JList log = new JList( ModelManager.getInstance( ModelManager.SALES ) );
    private JButton closeBtn = new JButton("Close");
    
    public SalesLogWindow() {
        this.setTitle("Sales Log");
        
        this.setSize( 160, 200 ); 
        
        this.setLayout( new BoxLayout( this.getContentPane(), BoxLayout.Y_AXIS) );
        
        closeBtn.addActionListener( this );
        closeBtn.setActionCommand("closeBtn");
        
        this.add( new JScrollPane(log) );
        this.add( closeBtn );
        
    }
    
    
    public void actionPerformed( ActionEvent ev ) {     
        
        if( ev.getActionCommand() == "closeBtn" ) {
            this.close();
        }
    }
}
