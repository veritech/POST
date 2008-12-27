/*
	This class is the main interface between the UI and the rest of the application
*/
package post.controllers;

public class UIController extends Controller {
	
	private static UIController instance;
	
	/**
	* Protected constructor
	*/
	protected UIController(){
		
	}
	
	/**
	* Add Button action
	*/
	public void addBtnAction(){
		
	}
	
	/**
	*	Return an instance of UIController, this instance is lazily loaded
	*	@return a instance of UIController
	*/
	public static UIController getInstance(){
		
		//Lazily load instance
		if( instance == null ){
			instance = new UIController();
		}
		
		return instance;
	}
}
