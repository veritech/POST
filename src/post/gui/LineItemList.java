package post.gui;


import javax.swing.*;
import java.awt.*;

import post.models.*;
import post.gui.adapters.*;

public class LineItemList extends JList {
	
	private static ListModel listModel = (ListModel) ModelManager.getInstance( ModelManager.CURRENT_SALE );
	
	public LineItemList(){
		
		super( listModel );
		
		this.setMinimumSize( new Dimension( 100, 200) );
		//this.setShowGrid( true );
	}
}
