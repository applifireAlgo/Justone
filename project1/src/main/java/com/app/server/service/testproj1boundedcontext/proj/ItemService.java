package com.app.server.service.testproj1boundedcontext.proj;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.testproj1boundedcontext.proj.Item;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "43", comments = "Service for Item Master table Entity", complexity = Complexity.LOW)
public abstract class ItemService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Item entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Item> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(Integer id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Item entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Item> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
