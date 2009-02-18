/*
	MODEL class
	
	CRUD based data storage class
	
	Could conform to the Collection Interface
	
	This class has a collection composited instead of
	inheirited to allow an abstraction of the internal store.
*/

package post.models;

import java.util.*;
import java.io.*;
import javax.swing.*;

public class Model extends DefaultListModel{
	
	//Name for the class
	protected String name;
	
	//Has the model data been loaded from disk
	protected boolean isLoaded = false;

	/**
	* Deprecated Constructor
	*
	*
	public Model()
	{
		//Check if the file exist
		File file = new File( name + ".bin" );
		
		//If the file exists
		if( file.exists() ){
			this.load();
		}

	}
	*/
	
	/**
	*	Wrapper for add method
	*	@Deprecated
	*/
	public void add( Object obj ){
		this.addElement( obj );
	}
	
	/**
	*	Wrapper for add method
	*	@Deprecated
	*/
	public Object read( int obj ){
		return this.get( obj );
	}
}