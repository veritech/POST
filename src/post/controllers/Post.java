/**
    Post.java
    This class acts as Observer for the supermarket
    application
*/
package post.controllers;

import javax.swing.*;
import post.models.*;
import post.recordtypes.*;

public class Post implements IApplicationDelegate
{
	
	private Store storeInstance;
	
    //Sales Model
    private Sales sales = (Sales) ModelManager.getInstance( ModelManager.SALES );
	
	private User currentUser;
	private Double cashInDrawer = 0.0;
	
	public Post( Store obj ){
		this.storeInstance = obj;
	}
	
	public void applicationWillBegin(){
		
		Users users = (Users) ModelManager.getInstance( ModelManager.USERS );
		
		String userID = JOptionPane.showInputDialog( 
			null,
			"User ID",
			"Insert User ID",
			 JOptionPane.QUESTION_MESSAGE
		);
		
		System.out.println( users.exists( userID ) );
		System.out.println( "Number of users " + users.size() );
		
		if( users.exists( userID ) ){

			users.setCurrentUser( users.find( userID ) );
			
		}
		else{
			
			JOptionPane.showMessageDialog(
				null,
				"User ID not found",
				"Invalid User ID",
				JOptionPane.WARNING_MESSAGE
			);
			
			//Exit the application
			System.exit(0);
		}

	}
	
	
	/**
	*	Transaction is about to begin
	*
	*/
	public void willBegin(){
		
	}
	
	/**
	*	Transaction has began
	*
	*/
	public void begin(){
		
	}
	
	public void rollback(){
		
	}
	
	/**
	*	Transaction is about to end
	*
	*/
	public void willEnd(){
		
		//get the current sale object
		sales.add( (Sale) ModelManager.getInstance( ModelManager.CURRENT_SALE ) );
		
	}
	
	/**
	*	Transaction has ended
	*
	*/
	public void end(){
		
		ModelManager.save( ModelManager.SALES );
	}
 		
}

