package post.models;

public interface ITransaction {
    
    public void willBegin();
    
    public void begin();
    
    public void rollback();
    
    public void willEnd();
    
    public void end();
}
