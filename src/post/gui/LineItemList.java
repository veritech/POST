package post.gui;

import javax.swing.*;
import java.awt.*;

import post.gui.adapters.*;

public class LineItemList extends JList {
	
	private static ListModel listModel = new ProductsListAdapter();
	
	public LineItemList(){
		
		super( listModel );
		
		this.setMinimumSize( new Dimension( 100, 200) );
		//this.setShowGrid( true );
	}
}
