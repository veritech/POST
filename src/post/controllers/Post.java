/**
    Post.java
    This class acts as controller for the supermarket
    application
*/
package post.controllers;

import post.models.*;

public class Post implements iTransaction
{
	
	private Store storeInstance;
	
    //Sales Model
    private Sales sales = (Sales) ModelManager.getInstance( ModelManager.SALES );

	public Post( Store obj ){
		this.storeInstance = obj;
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

