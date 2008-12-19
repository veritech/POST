package post.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
	
	private JButton btn;
	
	public MainWindow( String title ){
		//The title
		super( title );
		
		//Close the frame
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		//Set the minimum size
		this.setMinimumSize( new Dimension( 480, 320) );
		
		//Set the size
		this.setSize( new Dimension( 800, 480) );
		
		//Setup the layout
		Container pane = this.getContentPane();
			
		pane.setLayout( new GridBagLayout() );
		
		GridBagConstraints gridSettings = new GridBagConstraints();
		
		gridSettings.anchor = GridBagConstraints.FIRST_LINE_START;
		//ROW 1
		btn = new JButton("Sale");
		
		gridSettings.gridx = 0;
		gridSettings.gridy = 0;
		
		pane.add( btn, gridSettings);
		
		btn = new JButton("Log");
		
		gridSettings.gridx = 1;
		
		pane.add( btn, gridSettings );
		
		
		btn = new JButton("foo");
		
		gridSettings.gridx = 2;
		
		pane.add( btn, gridSettings );
		//ROW 2
		//Sidebar
		Container sidePane = new LineItemList();
		
		
		gridSettings.gridx = 0;
		gridSettings.gridy = 1;

		
		pane.add( sidePane, gridSettings );
		
		//Detail panel
		JPanel detailPanel = new DetailPanel();

		gridSettings.gridx = 1;
		gridSettings.gridy = 1;
		gridSettings.gridwidth = 2;
		gridSettings.weightx = 0.5;
		gridSettings.fill = GridBagConstraints.BOTH;
		
		pane.add( detailPanel, gridSettings );
		
		//ROW 3
		gridSettings.fill = GridBagConstraints.NONE;
		JComboBox comboBox = new JComboBox();

		gridSettings.gridx = 1;
		gridSettings.gridy = 2;

		comboBox.addItem( "One" );
		comboBox.addItem( "Two" );
		
		pane.add( comboBox, gridSettings );
		
		
		btn = new JButton("Add");
	
		gridSettings.gridx = 2;
		gridSettings.gridy = 2;
		
		pane.add( btn, gridSettings );
	}
	
}
