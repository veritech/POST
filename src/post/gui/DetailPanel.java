package post.gui;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import post.models.*;
import post.recordtypes.*;
import post.gui.adapters.*;


public class DetailPanel extends JPanel implements ActionListener{
	
	private JComboBox searchBox = new JComboBox( new ProductSearchComboBoxAdapter() );
	
	//Detail elements
	private JLabel title = new JLabel("No Product Selected");
	private JLabel price = new JLabel();
	private JLabel upc = new JLabel();
	
	public DetailPanel(){
		//Call the super
		super();
		//Uncomment to allow text to typed into the field
		//searchBox.setEditable( true );
		
		this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
		
		searchBox.setActionCommand("searchComboBox");
		searchBox.addActionListener( this );
		
		//Increase the default font sizes
		title.setFont( new Font(null, Font.BOLD, 20 ));
		price.setFont( new Font(null, Font.BOLD, 24 ));
		
		this.add( searchBox );
		this.add( title );
		this.add( price );
		this.add( upc );
	}
	
	/**
	*	Get the currently selected value of the item within the search box
	*	
	*	@return Int the UPC of the item within the search box
	*/
	public Integer getSearchComboBoxValue(){
		
		ProductSpec retVal = (ProductSpec) searchBox.getSelectedItem();
		
		return retVal.getUpc();
	}
	
	/**
	*	Add a action listener to recieve events from the children of the JPanel
	*	@param e ActionListener to get events from the children of the JPanel
	*/
	public void addChildrenActionListener( ActionListener e ){
		
		searchBox.addActionListener( e );
	}
	
	/**
	*	Set the various elements with the detail 
	*	panel to show the details of the currently selected product
	*	
	*	@param int upc The upc code the current item
	*/
	private void setDetail( int upc ){
		//Get an instance of the product catalogue
		ProductCatalog catalog = (ProductCatalog ) ModelManager.getInstance( ModelManager.PRODUCT_CATALOG );
		ProductSpec spec = catalog.specification( upc );
		
		if( spec != null ){
			
			title.setText( spec.getDescription() );
			price.setText( "£ " + spec.getPrice()  );
			this.upc.setText( "UPC: " + spec.getUpc() );

		}
	}
	
	/**
	*	Action Performed implementation to complete ACtionListener interface
	*
	*	@param e ACtionEvent with details of the event
	*/
	public void actionPerformed( ActionEvent e ){
		
		if( e.getActionCommand() == "searchComboBox" ){
			System.out.println("Changing Detail Panel upc:" + this.getSearchComboBoxValue() );
			
			this.setDetail( this.getSearchComboBoxValue() );
				
		}
		
		
	}
}
