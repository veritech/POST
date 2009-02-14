package post.models;

public class ModelManager {
	
	//Models
	private static ProductCatalog productCatalogInstance = new ProductCatalog();
	private static Sales salesInstance = new Sales();
	private static Sale currentSaleInstance = new Sale();
	
	//Constants used to select model
	public static final int SALES = 1;
	public static final int PRODUCT_CATALOG = 2;
	public static final int CURRENT_SALE = 3;
	
	/**
		Hide the constructor from public view
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
				if( !salesInstance.isLoaded() ){
					//Load the model with data from disk
					salesInstance.load();
				}
				
				return salesInstance;
				
			case PRODUCT_CATALOG:
			
				if( !productCatalogInstance.isLoaded() ){
					productCatalogInstance.load();
				}
				
				return productCatalogInstance;
			
			case CURRENT_SALE:
			
				return currentSaleInstance;
				
			default:
				return null;
		}
		
	}
	
	
}
