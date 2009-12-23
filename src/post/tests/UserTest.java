package post.tests;

import junit.framework.TestCase;

import post.recordtypes.User;

public class UserTest extends TestCase{
    
    User obj;
    

    public void setUp() throws Exception {
        obj = new User("Jonathan", "1987");
    }


    public void tearDown() throws Exception {
    }


    public void testGetName() {
        
        assertEquals("Jonathan", obj.getName() );
        
    }


    public void testSetName() {
        
        obj.setName("Richard");
        
        assertEquals("Richard", obj.getName() );
        
    }


    public void testGetEmployeeID() {
        
        assertEquals( "1987", obj.getEmployeeID() );
    }


    public void testSetEmployeeNumber(){
        
        obj.setEmployeeNumber("2008");
        
        assertEquals("2008", obj.getEmployeeID() );
    }

}
