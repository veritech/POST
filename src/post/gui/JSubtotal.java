package post.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import post.models.*;

public class JSubtotal extends JTextField implements ListDataListener {
    
    //Set up as a data listener
    Sale currentSale = (Sale) ModelManager.getInstance( ModelManager.CURRENT_SALE );
    
    public JSubtotal() {
        super("00.00");
        
        this.setBackground( Color.BLACK );
        this.setForeground( Color.RED );
        
        currentSale.addListDataListener( this );
        
        //Give it a larger font
        this.setFont( new Font( null, Font.BOLD, 24 ));
    }

    public void contentsChanged(ListDataEvent e) {

        this.setText( String.valueOf(currentSale.getTotal()) );

    }

    public void intervalAdded(ListDataEvent e) {

        this.setText( String.valueOf(currentSale.getTotal()) );
    }

    public void intervalRemoved(ListDataEvent e) {

        this.setText( String.valueOf(currentSale.getTotal()) );
    }
    
    public void setText( String txt ) {
        super.setText( "£ "+ txt );
    }
    
}
