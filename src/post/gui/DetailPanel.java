package post.gui;

import javax.swing.*;
import java.awt.event.*;
import post.recordtypes.*;
import post.gui.adapters.*;


public class DetailPanel extends JPanel {
	
	private JComboBox searchBox = new JComboBox( new ProductSearchComboBoxAdapter() );
	
	public DetailPanel(){
		//Call the super
		super();
		//Uncomment to allow text to typed into the field
		//searchBox.setEditable( true );
		
		this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
		
		this.add( searchBox );
		this.add( new JLabel("Main Panel") );
	}
	
	public DetailPanel( ActionListener listener ){
		//Call the basic constructor
		this();
		
		this.searchBox.setActionCommand("searchComboBox");
		this.searchBox.addActionListener( listener );
	}
	
	public Integer getSearchComboBoxValue(){
		
		ProductSpec retVal = (ProductSpec) searchBox.getSelectedItem();
		
		return retVal.getUpc();
	}
}
