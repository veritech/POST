package post.models;

public class ModelManager {
	
	//Models
	private static ProductCatalog productCatalogInstance = new ProductCatalog();
	private static Sales salesInstance = new Sales();
	
	//Constants used to select model
	public static final int SALES = 1;
	public static final int PRODUCT_CATALOG = 2;
	
	//Hide the constructor from public view
	protected ModelManager(){
		
	}
	
	public static Model getInstance( int modelConstant ){
		
		switch( modelConstant ){
			case SALES:
				return salesInstance;
				
			case PRODUCT_CATALOG:
				return productCatalogInstance;
			
			default:
				return null;
		}
		
	}
	
	
}
