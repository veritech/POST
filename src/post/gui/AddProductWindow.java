/*
	Product Window
	
	TODO Make Singleton
*/
package post.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import post.models.*;
import post.recordtypes.*;
import post.gui.SpringUtilities;

public class AddProductWindow extends Window{

	//UPC
	private JSpinner upcSpinner = new JSpinner( new SpinnerNumberModel() );
		
	//Description
	private JTextArea descriptionArea = new JTextArea();
		
	//Price Spinner and spinner model
	private JSpinner priceSpinner = new JSpinner( new SpinnerNumberModel(0.0,0.0,100.0,0.01) );
		
	//Add & cancel button
	private JButton addBtn = new JButton("Add");
	private JButton cancelBtn = new JButton("Cancel");	
	
	protected AddProductWindow(){
		
		//Set the title
		this.setTitle("Add Product");
		
		Container pane = new JPanel();
		SpringLayout layout = new SpringLayout();
		pane.setLayout( layout );
		
		pane.add( new JLabel("UPC") );
		pane.add( upcSpinner );

		pane.add( new JLabel("Price") );
		pane.add( priceSpinner );

		pane.add( new JLabel("Description") );
		pane.add( descriptionArea );

		pane.add( addBtn );
		addBtn.setActionCommand( "add" );
		addBtn.addActionListener( this );
		
		pane.add( cancelBtn );
		cancelBtn.setActionCommand( "cancel" );
		cancelBtn.addActionListener( this );
		
		SpringUtilities.makeCompactGrid( pane, 4, 2, 6, 6, 6, 6 );
		
		this.setContentPane( pane );
		
		//Set the window size
		this.setSize(280, 160);
	}
	
	/**
	*	Clear all the fields in the window
	*
	*/
	private void clearFields(){
		upcSpinner.setValue( 0 );
		priceSpinner.setValue( 0.0);
		descriptionArea.setText("");
	}
	
	/**
	*	
	*/
    public void actionPerformed(ActionEvent e) {
        
        if( e.getActionCommand() == "add" ){
        	//Create  a product
        	ProductSpec product = new ProductSpec(
        		(Integer) upcSpinner.getValue(),
        		descriptionArea.getText(),
        		(Double) priceSpinner.getValue()
        	);
        	
        	//Open the
        	ProductCatalog catalog = (ProductCatalog)ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
        	
        	catalog.add( product );
        	
        	System.out.println("Added " + descriptionArea.getText() );
        	
        	this.clearFields();
        	this.close();        	
        }
        else if( e.getActionCommand() == "cancel" ){
       		//Close the window
       		this.clearFields();
       		this.close();
        }

    }
}
