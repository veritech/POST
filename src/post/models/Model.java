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

public class Model{
	
	//Name for the class
	protected String name;
	
	//Backing store for the model
	protected ArrayList<Object> backingStore =  new ArrayList<Object>();
	
	//Has the model data been loaded from disk
	protected boolean isLoaded = false;
	//Constructor
	public Model()
	{
		//Check if the file exist
		File file = new File( name + ".bin" );
		
		//If the file exists
		if( file.exists() ){
			this.load();
		}

	}
	
	//Destructor
	protected void finalize() throws Throwable
	{
		super.finalize();
	}

	/*
	* Add an object to the internal store
	*/
    public boolean add( Object obj) {   
        return this.backingStore.add( obj );
    }
    
    /*
    *
    *
    public void add( int index, Object Element){
    	this.backingStore.add( index, Element );
    }
	*/
	
	/*
	*
	*/
	public boolean isEmpty(){
		return this.backingStore.isEmpty();
	}

	/*
	* Remove an object from the internal store using the
	*/
	public Object remove( int index ){
		return this.backingStore.remove( index );
	}

	/*
	* Remove an object from the internal store, by looking up the same object
	*/
    public boolean remove( Object obj ) {
		return this.backingStore.remove( obj );
    }	
	
	/*
	* Get an iterator of all the objects in backing store
	*/
    public Object read( Object key ) {
    	
        return this.backingStore.get( (Integer)key );
    }
	
	/*
	*
	*/
    public void update( Object obj ) {
        // TODO Implement Update Method
    }
	
	public int size(){
		return this.backingStore.size();
	}
	
	/*
	* Allow control of the backing store
	protected Object getBackingStore(){
		return this.backingStore;
	}
	
	/*
	* Set the backing store to whatever
	
	protected void setBackingStore( Object obj ){
		this.backingStore = obj;
	}
	*/
	
	/*
		Determine if the internal store has been loaded from the disk
	*/
	public boolean isLoaded(){
		return this.isLoaded;
	}
	
	/*
	*	Load the internal store from a file
	*/
	public void load(){
		
 		try{
			
			FileInputStream fileIn = new FileInputStream( this.name + ".bin" );
			
			ObjectInputStream in = new ObjectInputStream( fileIn );
			
			this.backingStore = (ArrayList<Object>) in.readObject();
			
			this.isLoaded = true;
		}
		catch(Exception e ){
			
			System.out.println(e);
			
		} 
	}
	
	/*
	*	Save the internal store to a file
	*/
	public void save(){
		
 		try{
			
			FileOutputStream fileOut = new FileOutputStream( this.name + ".bin" );
			
			ObjectOutputStream out = new ObjectOutputStream( fileOut );
			
			out.writeObject( this.backingStore );
			
			out.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}