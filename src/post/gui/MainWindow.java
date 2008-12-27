/*
*	Main Window Class
*	
*	Extends JFrame class
*/

package post.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener, WindowListener{
	
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
	private JPanel detailPanel = new DetailPanel();
	
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
		this.addWindowListener( this );
		
		//Setup the menu
		JMenuBar menuBar = new JMenuBar();
		
		//Open menu item
		menuItem = new JMenuItem("Open");
		menuItem.addActionListener( this );
		fileMenu.add( menuItem );
		
		//Save menu item
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener( this );
		fileMenu.add( menuItem );


		menuItem = new JMenuItem("Add Product");
		menuItem.addActionListener( this );
		productMenu.add( menuItem );
		
		menuItem = new JMenuItem("Remove Product");
		menuItem.addActionListener( this );
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
		
		btn.addActionListener( this );
		
		btn.setToolTipText("Complete Sale");
		
		layout.gridx = 0;
		layout.gridy = 0;
		
		layout.ipadx = 10;
		layout.ipady = 10;
		
		pane.add( btn, layout);
		
		//Log button
		btn = new JButton("Log");
		
		btn.setActionCommand("log");
		
		btn.addActionListener( this );
		
		btn.setToolTipText("View Transaction Log");
		
		layout.gridx = 1;
		
		pane.add( btn, layout );
		
		//Foo button
		btn = new JButton("foo");
		
		btn.setActionCommand("foo");
		
		btn.addActionListener( this );
		
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
		
		comboBox.addActionListener( this );
		
		comboBox.setToolTipText( "Quantity" );
		
		pane.add( comboBox, layout );
		
		//Add button
		btn = new JButton("Add");
		
		btn.setActionCommand("add");
		
		btn.addActionListener( this );
		
		layout.gridx = 3;
		layout.gridy = 2;
		
		pane.add( btn, layout );
	}
	
	/**
	*	Save the models
	*/
	private void save(){
		
	}
	
	/**
	*	Events Action controller method
	*	@param e The ActionEvent
	*/
	public void actionPerformed(ActionEvent e) {

        if( e.getActionCommand().equals("sale") ){
        	System.out.println("Pressed Sale");
        	//TODO Respond to sale button action
        }
        else if( e.getActionCommand().equals("log") ){
        	System.out.println("Pressed log");
        	//TODO Respond to Log button action
        }
        else if( e.getActionCommand().equals("add") ){
			//TODO Respond to Add button action
        }
        else if( e.getActionCommand().equals("comboBox") ){
        	System.out.println("Combobox");
        	//TODO Respond to combo box action
        }
        //Deal with menu actions
        else if( e.getActionCommand().equals("Add Product") ){
        	
        	AddProductWindow.getInstance().setVisible( true );

        }
        else if( e.getActionCommand().equals("Remove Product") ){
        	//TODO Repond to remove Product
        }
        else{
        	System.out.println( e.getActionCommand() );
        }

    }
    
    /**
    *	Window Events
    */
    public void windowActivated( WindowEvent e ){
    	//TODO Implement Window Activated
    }
    
    public void windowClosed( WindowEvent e ){
    	//TODO Implement window closed
    }
    
    //Call save before close
    public void windowClosing( WindowEvent e ){
    	
    	int response = JOptionPane.showConfirmDialog( this, 
    		"Do you want save your changes?" ,
    		"Save Changes?", 
    		JOptionPane.YES_NO_OPTION
    	);
    	
    	switch( response ){
    		case JOptionPane.YES_OPTION:
    			//TODO Handle Save option
    			
    			
    			
    			System.out.print("Saving");
    			break;
    		case JOptionPane.NO_OPTION:
    			//TODO handle Don't save option
    			System.out.print("No Option");
    			break;
    	}
    	
    }
    
    public void windowDeactivated(WindowEvent e){
    	//TODO Implement window Deactivated
    }
	public void windowDeiconified(WindowEvent e){
		//TODO Implement window deiconified
	}
	public void windowIconified(WindowEvent e){
		//TODO Implement windowIconified
	}
	public void windowOpened(WindowEvent e){
		//TODO Implement windowOpenedcon	
	}
}
