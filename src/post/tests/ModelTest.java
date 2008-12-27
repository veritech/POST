package post.tests;

import post.models.*;
import junit.framework.TestCase;

public class ModelTest extends TestCase {
	
	protected Model model;
	
    protected void setUp() throws Exception {
        super.setUp();
        
        model = new Model();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
	
	
	public void testAdd(){
		
		
		model.add("Hello Collection");
		
		assertEquals( 1, model.size() );
		
	}
	
	public void testReadWithIndex(){
		
		model.add("Hello Collection");
		
		model.add("Hello Collection 2");
		
		String foo = (String) model.read(0);
		
		assertEquals("Hello Collection", foo);
		
	}
	
	public void testReadWithObject(){
		
		String foo = "Hello Collection";
		String bar;
		
		model.add( foo );
		
		assertEquals( 1, model.size() );
		
		bar = (String) model.read( foo );
		
		assertEquals( bar, foo );
		
	}
	
	public void testRemove(){
		
		//Call add
		testAdd();
		//check there is one
		assertEquals( 1, model.size() );
		
		//remove some
		model.remove("Hello Collection");
		
		//Check
		assertEquals( 0, model.size() );
		
	}
	
	public void testLength(){
		
		assertEquals( 0, model.size() );
	}
}
