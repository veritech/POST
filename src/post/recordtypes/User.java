package post.recordtypes;

public class User extends AbstractRecord {
    private String name;
    private String employeeID;
    
    public User( String pName, String pEmployeeID ) {
        
        this.name = pName;
        this.employeeID = pEmployeeID;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the employeeNumber
     */
    public String getEmployeeID() {
        return employeeID;
    }
    /**
     * @param employeeNumber the employeeNumber to set
     */
    public void setEmployeeNumber( String employeeID) {
        this.employeeID = employeeID;
    }
    
    
}
