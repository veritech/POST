package post;

import post.controllers.*;
import post.gui.*;
import javax.swing.*;

public class PostApplication implements Runnable {

	
    public void run() {

		JFrame mainWindow = new MainWindow("POST");
		
		mainWindow.setVisible( true );
		
    }
    
	public static void main( String [] args){
    	
    	PostApplication app = new PostApplication();
    	
    	app.run();
    	
    	System.out.println("Running");
    }

}