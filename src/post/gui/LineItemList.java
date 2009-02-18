package post.gui;


import javax.swing.*;
import java.awt.*;

import post.models.*;
import post.gui.adapters.*;

public class LineItemList extends JList{
	
	private static ListModel listModel = (ListModel) ModelManager.getInstance( ModelManager.CURRENT_SALE );
	//private JList actualList = new JList( listModel );
	
	
	public LineItemList(){
		
		super( listModel );
		
		

		//this.setShowGrid( true );
	}
}
