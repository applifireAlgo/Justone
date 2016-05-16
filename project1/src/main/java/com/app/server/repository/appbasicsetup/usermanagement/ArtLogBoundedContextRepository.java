package com.app.server.repository.appbasicsetup.usermanagement;
import com.app.shared.appbasicsetup.usermanagement.ArtLogBoundedContext;
import java.util.List;


public interface ArtLogBoundedContextRepository {
	
    public void save(ArtLogBoundedContext artLogBoundedContext);
    
    public void update(ArtLogBoundedContext artLogBoundedContext);
    
    public ArtLogBoundedContext findByBoundedContextPrefix(String boundedContextPrefix);
	
	public List<ArtLogBoundedContext> findAll();
 
}
