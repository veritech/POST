package post.models;

import java.util.Enumeration;

import post.recordtypes.*;


public class Users extends Model {
    
    private User current;
    
    /*
     * Return the User for a given a employeeNumber
     * @return User 
     */
     public User find(String employeeID )
     {

         //loop through the collection and look for the employeeID
         User retVal = null;
         
         for( Enumeration e = this.elements(); e.hasMoreElements(); ){
             //Get the next object
             User user = (User) e.nextElement();
             
//             System.out.println( user.getEmployeeID().equals(employeeID) );
//             
//             System.out.println( "**"+ user.getEmployeeID() +"**"+employeeID  +"**");
             
             //Does the employee ID match
             if( user.getEmployeeID().equals( employeeID ) ){
                 retVal = user;
                 break;
             }
         }
         
         return retVal;
         
     }
     
     public boolean exists( String employeeID ) {
         
         User user = this.find( employeeID );
         
         if( user != null ) {
             return true;
         }
         else {
             return false;
         }
         
     }
     
     /**
      * Set the current user
      * 
      * @param user Set the current user
      */
     public void setCurrentUser( User user) {
         this.current = user;
     }
     
     /**
      * Get the current user
      * 
      * @return User the current user
      */
     public User getCurrentUser() {
         return this.current;
     }
     
}
