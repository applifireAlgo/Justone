package com.app.server.repository.justone.justone;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.justone.justone.EntityA;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "", versionNumber = "1", comments = "Repository for EntityA Master table Entity", complexity = Complexity.LOW)
public class EntityARepositoryImpl extends SearchInterfaceImpl implements EntityARepository<EntityA> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<EntityA> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.justone.justone.EntityA> query = emanager.createQuery("select u from EntityA u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("JOJU324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EntityARepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public EntityA save(EntityA entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("JOJU322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EntityARepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<EntityA> save(List<EntityA> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.justone.justone.EntityA obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("JOJU322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EntityARepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.justone.justone.EntityA s = emanager.find(com.app.shared.justone.justone.EntityA.class, id);
        emanager.remove(s);
        Log.out.println("JOJU328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EntityARepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(EntityA entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("JOJU321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EntityARepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<EntityA> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.justone.justone.EntityA obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("JOJU321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EntityARepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public EntityA findById(String pk) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("EntityA.findById");
        query.setParameter("pk", pk);
        com.app.shared.justone.justone.EntityA listOfEntityA = (com.app.shared.justone.justone.EntityA) query.getSingleResult();
        Log.out.println("JOJU324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EntityARepositoryImpl", "findById", "Total Records Fetched = " + listOfEntityA);
        return listOfEntityA;
    }
}
