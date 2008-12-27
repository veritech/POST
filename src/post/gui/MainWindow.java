/*
*	Main Window Class
*	
*	Extends JFrame class
*/

package post.gui;

import post.controllers.UIController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame{
	
	/**
	* Get an instance of the controller, and pass a reference to this JFrame
	*/
	private UIController controller = UIController.getInstance(this);
	
	//Reused button container
	private JButton btn;
	
	//Reused menu
	private JMenuItem menuItem;
	
	private JMenu fileMenu = new JMenu("File");
	private JMenu editMenu = new JMenu("Edit");
	private JMenu productMenu = new JMenu("Products");
	private JMenu helpMenu = new JMenu("Help");
	
	/**
	* The combo box
	*/
	private JComboBox comboBox = new JComboBox();
	
	//SidePane
	private Container sidePane = new LineItemList();
	
	//Detail panel
	private JPanel detailPanel = new DetailPanel( controller );
	
	//Grid layout
	private	GridBagConstraints layout = new GridBagConstraints();
	
	//Main constructor
	public MainWindow( String title ){
		//The title
		super( title );
		
		//Close the frame
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		//Set the minimum size
		this.setMinimumSize( new Dimension( 480, 320) );
		
		//Set the size
		this.setSize( new Dimension( 480, 360) );
		
		//Set this object as the window listener
		this.addWindowListener( controller );
		
		//Setup the menu
		JMenuBar menuBar = new JMenuBar();
		
		//Open menu item
		menuItem = new JMenuItem("Open");
		menuItem.addActionListener( controller );
		fileMenu.add( menuItem );
		
		//Save menu item
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener( controller );
		fileMenu.add( menuItem );

		menuItem = new JMenuItem("Add Product");
		menuItem.addActionListener( controller );
		productMenu.add( menuItem );
		
		menuItem = new JMenuItem("Remove Product");
		menuItem.addActionListener( controller );
		productMenu.add( menuItem );
		
		menuBar.add( fileMenu );
		menuBar.add( editMenu );
		menuBar.add( productMenu );
		menuBar.add( helpMenu );
		
		this.setJMenuBar( menuBar );
		
		//Setup the layout
		Container pane = this.getContentPane();
			
		pane.setLayout( new GridBagLayout() );
		
		layout.anchor = GridBagConstraints.NORTHWEST;
		
		//ROW 1
		btn = new JButton("Sale");
		
		btn.setActionCommand("sale");
		
		btn.addActionListener( controller );
		
		btn.setToolTipText("Complete Sale");
		
		layout.gridx = 0;
		layout.gridy = 0;
		
		layout.ipadx = 10;
		layout.ipady = 10;
		
		pane.add( btn, layout);
		
		//Log button
		btn = new JButton("Log");
		
		btn.setActionCommand("log");
		
		btn.addActionListener( controller );
		
		btn.setToolTipText("View Transaction Log");
		
		layout.gridx = 1;
		
		pane.add( btn, layout );
		
		//Foo button
		btn = new JButton("foo");
		
		btn.setActionCommand("foo");
		
		btn.addActionListener( controller );
		
		btn.setToolTipText("Foo");
		
		layout.gridx = 2;
		
		pane.add( btn, layout );

		//ROW 2
		//Sidebar
		layout.fill = GridBagConstraints.BOTH;
		
		layout.gridx = 0;
		layout.gridy = 1;

		pane.add( sidePane, layout );
		
		//Detail panel
		layout.gridx = 1;
		layout.gridy = 1;
		layout.gridwidth = 3;
		layout.weightx = 0.5;
		
		pane.add( detailPanel, layout );
		
		//ROW 3
		layout.fill = GridBagConstraints.NONE;

		layout.gridy = 2;
		
		//Combobox label
		layout.gridx = 1;
		pane.add( new JLabel("Quantity"), layout );
		
		//Combobox
		layout.gridx = 2;
		
		//Generate some quantities
		for( int i=0; i <= 10; i++ ){
			comboBox.addItem( String.valueOf( i ) );
		}
		
		comboBox.setActionCommand( "comboBox" );
		
		comboBox.addActionListener( controller );
		
		comboBox.setToolTipText( "Quantity" );
		
		pane.add( comboBox, layout );
		
		//Add button
		btn = new JButton("Add");
		
		btn.setActionCommand("add");
		
		btn.addActionListener( controller );
		
		layout.gridx = 3;
		layout.gridy = 2;
		
		pane.add( btn, layout );
	}	

}
