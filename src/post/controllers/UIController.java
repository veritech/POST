/*
	Jonathan Dalrymple
	
	This class is the main interface between the UI and the rest of the application
*/
package post.controllers;

import java.awt.event.*;
import javax.swing.*;
import post.gui.*;

public class UIController extends Controller implements ActionListener, WindowListener{
	
	private static UIController instance;
	
	/**
	*	Store controller
	*/
	private Store storeController = Store.getInstance();
	
	/**
	* MainWindow Reference
	*/
	private MainWindow mainWindow;
	
	/**
	* Protected constructor
	*/
	protected UIController( MainWindow obj ){
		this.mainWindow = obj;
	}
	
	/**
	*	Add Button action
	*/
	public void addBtnAction(){
		//TODO Respond to Add button action
		//System.out.println("Pressed Add");
		
		storeController.buyItem( mainWindow.getUPC(), mainWindow.getQuantity() );
	}
	
	/**
	*	Sale Button action
	*/
	public void saleBtnAction(){

		WindowManager.getInstance( WindowManager.CHECKOUT ).setVisible( true );
	}
	
	/**
	*	log Button action
	*/
	public void logBtnAction(){
		System.out.println("Pressed log");
		
		WindowManager.getInstance( WindowManager.SALES_LOG ).setVisible( true );
		//TODO Log Button Action
	}
	
	public void saveMenuAction(){
		//TODO Save Product Catalog
		storeController.save();
	}

	
	/**
	*	Events Action controller method
	*	@param e The ActionEvent
	*/
	public void actionPerformed(ActionEvent e) {	
		
        if( e.getActionCommand().equals("sale") ){
        	this.saleBtnAction();
        }
        else if( e.getActionCommand().equals("log") ){
        	this.logBtnAction();
        }
        else if( e.getActionCommand().equals("add") ){
			//TODO Respond to Add button action
			this.addBtnAction();
        }
        //Deal with menu actions
        else if( e.getActionCommand().equals("Save") ){
        	this.saveMenuAction();
        }
        else if( e.getActionCommand().equals("Add Product") ){
        	
        	WindowManager.getInstance( WindowManager.ADD_PRODUCT ).setVisible( true );

        }
        else if( e.getActionCommand().equals("Remove Product") ){
        	
        	WindowManager.getInstance( WindowManager.REMOVE_PRODUCT ).setVisible( true );
        	
        }
        else{
        	System.out.println( "**** Unhandled UI Action ****");
        	System.out.println( e.getActionCommand() );
        }

    }
    
    /**
    *	Window Events
    */
    public void windowActivated( WindowEvent e ){
    	//TODO Implement Window Activated
    }
    
    public void windowClosed( WindowEvent e ){
    	//TODO Implement window closed
    }
    
    //Call save before close
    public void windowClosing( WindowEvent e ){
    	
    	int response = JOptionPane.showConfirmDialog( mainWindow, 
    		"Do you want save your changes?" ,
    		"Save Changes?", 
    		JOptionPane.YES_NO_OPTION
    	);
    	
    	switch( response ){
    		case JOptionPane.YES_OPTION:
    			
    			this.saveMenuAction();
    			
    			System.out.print("Saving");
    			break;
    		case JOptionPane.NO_OPTION:
    			//TODO handle Don't save option
    			System.out.print("No Option");
    			break;
    	}
    	
    }
    
    public void windowDeactivated(WindowEvent e){
    	//TODO Implement window Deactivated
    }
	public void windowDeiconified(WindowEvent e){
		//TODO Implement window deiconified
	}
	public void windowIconified(WindowEvent e){
		//TODO Implement windowIconified
	}
	public void windowOpened(WindowEvent e){
		//TODO Implement windowOpenedcon	
	}
	
	/**
	*	Return an instance of UIController, this instance is lazily loaded
	*	@param obj A reference to the MainWindow of the application
	*	@return a instance of UIController
	*/
	public static UIController getInstance( MainWindow obj){
		
		//Lazily load instance, with a reference to the JFrame
		if( instance == null ){
			instance = new UIController( obj );
		}
		
		return instance;
	}
}
