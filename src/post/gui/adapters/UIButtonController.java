/*
	Jonathan Dalrymple
	
	Decemeber 26th, 2008
	
	This class Handles all the button events for the GUI 
*/
package post.gui.adapters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIButtonController implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        if( e.getActionCommand() == "sale" ){
        	System.out.print("Pressed Sale");
        }
        else if( e.getActionCommand() == "log"){
        	System.out.print("Pressed log");
        }
        else if( e.getActionCommand() == "add"){
        	System.out.print("Pressed add");
        }
        
        //e.getActionCommand()
    }

}
