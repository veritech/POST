package post.models;

import java.io.*;

public class ModelManager {
	
	//Models
	private static ProductCatalog productCatalogInstance = null;
	private static Sales salesInstance = null;
	private static Sale currentSaleInstance = null;
	
	//Constants used to select model
	public static final int SALES = 1;
	public static final int PRODUCT_CATALOG = 2;
	public static final int CURRENT_SALE = 3;
	
	/**
	*	Hide the constructor from public view
	*/
	protected ModelManager(){
		
	}

	/**
	*	Get the instance of the passed model
	*	@param modelConstant One of the model constants
	*	@return singleton instance of a model
	*/
	public static Model getInstance( int modelConstant ){
		//TODO check if data has been loaded into model instance, and load if required
		
		switch( modelConstant ){
			case SALES:
				
				//If the data has not been loaded
				if( salesInstance == null ){
					//Load the model with data from disk
					salesInstance = (Sales) load( SALES );
				}
				
				return salesInstance;
				
			case PRODUCT_CATALOG:
			
				if( productCatalogInstance == null ){
					productCatalogInstance = (ProductCatalog) load( PRODUCT_CATALOG );

				}
				
				return productCatalogInstance;
			
			case CURRENT_SALE:
				
				if( productCatalogInstance == null ){
				
					currentSaleInstance = new Sale();
				
				}
				
				
				return currentSaleInstance;
				
			default:
				return null;
		}
		
	}
	
	private static String getFilenameFromConst( int model ){
	
		switch( model ){
			case SALES:
				return "Sales";

			case PRODUCT_CATALOG:
				return "ProductCatalog";

			case CURRENT_SALE:
				return "CurrentSale";

			default:
				return "";
		}
	}
	
	/**
	*	Load the internal store from a file
	*/
	public static Object load( int model ){
		
		FileInputStream fileIn;
		ObjectInputStream in;
		Object retVal = new Object();
		
 		try{
			
			System.out.println( getFilenameFromConst( model ) + ".bin" );
			
			fileIn = new FileInputStream( getFilenameFromConst( model ) + ".bin" );
			
			in = new ObjectInputStream( fileIn );
			
			//TODO Correctly handle failure to load object from file
			switch( model ){
				case SALES:
					
					retVal =  (Sales) in.readObject();
					
					break;
					
				case PRODUCT_CATALOG:
					
					retVal = (ProductCatalog) in.readObject();

					break;
					
				case CURRENT_SALE:
					
					retVal = (Sale) in.readObject();
					
					break;
					
			}
			//this.isLoaded = true;
		}
		catch( FileNotFoundException e ){
			//If the file cannot be found, create a new object
			switch( model ){
				case SALES:
					
					retVal = new Sales();
					
					break;
					
				case PRODUCT_CATALOG:
					
					retVal =  new ProductCatalog();
					
					break;
					
				case CURRENT_SALE:
					
					retVal = new Sale();
					
					break;
			}
			
		}
		catch(Exception e ){
			
			System.out.println(e);
			
		}
		
		
		return retVal;
	}
	
	/**
	*	Save the internal store to a file
	*/
	public static void save( int model ){
		
		FileOutputStream fileOut;
		ObjectOutputStream out;
		
 		try{

			fileOut = new FileOutputStream( getFilenameFromConst( model )  + ".bin" );

			out = new ObjectOutputStream( fileOut );
			
			
			//Switch can be removed as each object is not required to be cast before serialization
			switch( model ){
				case SALES:
					out.writeObject( (Sales) getInstance(model) );
					break;
				case PRODUCT_CATALOG:
					out.writeObject( (ProductCatalog) getInstance(model) );
					break;
				case CURRENT_SALE:
					out.writeObject( (Sale) getInstance(model) );
					break;
				default:
					//Do nada
			}
			
			out.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
}
