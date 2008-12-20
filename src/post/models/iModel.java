/*
	Basic CRUD interface

*/


package post.models;

import java.util.*;

import post.recordtypes.AbstractRecord;

public interface iModel {
    
    public void add( Object obj );
    
    public Object read( Object key );
    
    public void update( Object obj );
    
    public void delete( Object obj );
}
