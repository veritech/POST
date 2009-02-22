package post.gui;

import java.awt.Color;

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
}
