package post.tests;

import post.models.ModelManager;
import post.models.Users;
import post.recordtypes.User;
import junit.framework.TestCase;

public class UsersTest extends TestCase {

    private Users users;
    
    protected void setUp() throws Exception {
        super.setUp();
        
        users = (Users) ModelManager.getInstance( ModelManager.USERS );
        
        //Add an object
        users.add( new User("Jonathan","1987") );
        users.add( new User("Richard","2008") );
        users.add( new User("Wesley","1969") );
        
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFind() {
        
        assertNotNull( users.find("2008") );
        assertNotNull( users.find("1987") );
        assertNotNull( users.find("1969") );
        
    }

    public void testExists() {
        
        assertTrue( users.exists("1969") );
        assertTrue( users.exists("1987") );
        assertTrue( users.exists("2008") );
        
    }

    public void testCurrentUser() {
        
        assertNull( users.getCurrentUser() );
        
        users.setCurrentUser( users.find("2008") );
        
        assertEquals( users.find("2008"), users.getCurrentUser() );
        
        assertNotSame( users.find("1987"), users.getCurrentUser() );
    }

}
