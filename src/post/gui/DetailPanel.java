package post.gui;

import javax.swing.*;

public class DetailPanel extends JPanel {
	
	public DetailPanel(){
		this.setLayout( new BoxLayout(this, BoxLayout.Y_AXIS) );
		
		this.add( new JTextField(32) );
		this.add( new JLabel("Main Panel") );
	}
}
