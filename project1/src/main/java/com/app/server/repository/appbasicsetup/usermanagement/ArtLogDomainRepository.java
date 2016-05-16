package com.app.server.repository.appbasicsetup.usermanagement;
import com.app.shared.appbasicsetup.usermanagement.ArtLogBoundedContext;

import com.app.shared.appbasicsetup.usermanagement.ArtLogDomain;

import java.util.List;
public interface ArtLogDomainRepository {

	public List<ArtLogDomain> findByArtLogBoundedContext(ArtLogBoundedContext artLogBoundedContext);

	public ArtLogDomain findById(String getdomainPkId);
	
	public void save(ArtLogDomain awsLogDomain);

	public void update(ArtLogDomain awsLogDomain);

}
