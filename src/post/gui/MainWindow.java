/*
*	Main Window Class
*	
*	Extends JFrame class
*/

package post.gui;

import post.controllers.UIController;
import javax.swing.*;
import java.awt.*;

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
		
		//Setup the menu bar
		this.setJMenuBar( this.createMenuBar() );
		
		//Setup the layout
		this.getContentPane().setLayout( new GridBagLayout() );
		
		//Create the rows
		
		this.createRowYi();
		this.createRowEr();
		this.createRowSan();
	}	
	
	private void createRowYi(){
		btn = new JButton("Sale");
		
		btn.setActionCommand("sale");
		
		btn.addActionListener( controller );
		
		btn.setToolTipText("Complete Sale");
		
		layout.gridx = 0;
		layout.gridy = 0;
		
		layout.ipadx = 10;
		layout.ipady = 10;
		
		this.getContentPane().add( btn, layout);
		
		//Log button
		btn = new JButton("Log");
		
		btn.setActionCommand("log");
		
		btn.addActionListener( controller );
		
		btn.setToolTipText("View Transaction Log");
		
		layout.gridx = 1;
		
		this.getContentPane().add( btn, layout );
		
		//Foo button
		btn = new JButton("foo");
		
		btn.setActionCommand("foo");
		
		btn.addActionListener( controller );
		
		btn.setToolTipText("Foo");
		
		layout.gridx = 2;
		
		this.getContentPane().add( btn, layout );
	}
	
	private void createRowEr(){
		//ROW 2
		//Sidebar
		layout.fill = GridBagConstraints.BOTH;
		
		layout.gridx = 0;
		layout.gridy = 1;

		this.getContentPane().add( sidePane, layout );
		
		//Detail panel
		layout.gridx = 1;
		layout.gridy = 1;
		layout.gridwidth = 3;
		layout.weightx = 0.5;
		
		this.getContentPane().add( detailPanel, layout );
	}
	
	private void createRowSan(){
		//ROW 3
		layout.gridwidth = 1;
		layout.fill = GridBagConstraints.NONE;
		layout.gridy = 2;
		
		//Combobox label
		layout.gridx = 1;
		this.getContentPane().add( new JLabel("Quantity"), layout );
		
		//Generate some quantities
		for( int i=0; i <= 10; i++ ){
			comboBox.addItem( String.valueOf( i ) );
		}
		
		comboBox.setActionCommand( "comboBox" );
		
		comboBox.addActionListener( controller );
		
		comboBox.setToolTipText( "Quantity" );
		
		//Combobox
		layout.gridx = GridBagConstraints.RELATIVE;
		
		this.getContentPane().add( comboBox, layout );
		
		//Add button
		btn = new JButton("Add");
		
		btn.setActionCommand("add");
		
		btn.addActionListener( controller );
		
		layout.gridx = GridBagConstraints.RELATIVE;
		
		this.getContentPane().add( btn, layout );
	}
	
	private JMenuBar createMenuBar(){
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


		//Edit Menu
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener( controller );
		editMenu.add( menuItem );
		
		menuItem = new JMenuItem("Edit");
		menuItem.addActionListener( controller );
		editMenu.add( menuItem );

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener( controller );
		editMenu.add( menuItem );

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
		
		return menuBar;
	}
	
}
