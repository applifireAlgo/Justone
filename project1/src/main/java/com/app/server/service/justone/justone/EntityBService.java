package com.app.server.service.justone.justone;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.justone.justone.EntityB;
import java.util.List;
import java.util.Map;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Service for EntityB Transaction table", complexity = Complexity.MEDIUM)
public abstract class EntityBService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(EntityB entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<EntityB> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(EntityB entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<EntityB> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> search(Map<String, Object> fieldData) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findByAaPk(FindByBean findByBean) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
