/*
	MODEL class
	
	CRUD based data storage class

*/

package post.models;

import java.util.*;
import java.io.*;

import post.recordtypes.AbstractRecord;

public class Model {
	
	//Name for the class
	protected String name;
	
	//Backing store for the model
	protected HashMap<String,AbstractRecord> backingStore =  new HashMap();
	
	
	//Constructor
	/*public Model();
	{
		//By default we set the backing store to use a hashtable
	}*/
	
	//Destructor
	protected void finalize() throws Throwable
	{
		super.finalize();
	}

	/*
	* Add an object to the internal store
	*/
    public void add( AbstractRecord obj) {
        
        if( obj != null ){
        	
        	//Get the key
        	this.backingStore.put( obj.getKey(), obj );
        	
        }
    }

	/*
	* Remove an object from the internal store
	*/
    public void delete( AbstractRecord obj ) {

		if( obj != null ){
			
			this.backingStore.remove( obj.getKey() );
			
		}
    }	
	
	/*
	* Get an iterator of all the objects in backing store
	*/
    public AbstractRecord read( String key ) {
    	
        return this.backingStore.get( key );
    }
	
	/*
	*
	*/
    public void update( AbstractRecord obj ) {
        // TODO Auto-generated method stub

    }
	
	public int length(){
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
	*	Load the internal store from a file
	*/
	public void load(){
		
 		try{
			
			FileInputStream fileIn = new FileInputStream( this.name + ".bin" );
			
			ObjectInputStream in = new ObjectInputStream( fileIn );
			
			this.backingStore = (HashMap<String, AbstractRecord>) in.readObject();
			
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