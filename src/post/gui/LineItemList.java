package post.gui;

import javax.swing.*;
import java.awt.*;

public class LineItemList extends JList {
	
	private static String [] temp = {"Product 1","Product 2","Product 3","Product 4"};
	
	public LineItemList(){
		
		super( temp );
		
		this.setMinimumSize( new Dimension( 100, 200) );
		//this.setShowGrid( true );
	}
}
