package post;

import post.controllers.*;
import post.gui.*;
import javax.swing.*;
import java.awt.*;

public class Application implements Runnable {

	
    public void run() {
    	
		Store store = new Store();			
		
		JFrame mainWindow = new MainWindow("POST");
		
		mainWindow.setVisible( true );
		
    }
    
	public static void main( String [] args){
    	
    	Application app = new Application();
    	
    	app.run();
    	
    	System.out.print("Running");
    }

}
