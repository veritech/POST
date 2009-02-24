package post.gui;


import javax.swing.*;

import post.models.*;

public class LineItemList extends JList{
	
	private static ListModel listModel = (ListModel) ModelManager.getInstance( ModelManager.CURRENT_SALE );
	//private JList actualList = new JList( listModel );
	
	
	public LineItemList(){
		
		super( listModel );
		
		//this.setShowGrid( true );
	}
}
