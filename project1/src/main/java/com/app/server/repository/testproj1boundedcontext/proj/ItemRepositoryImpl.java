package com.app.server.repository.testproj1boundedcontext.proj;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.testproj1boundedcontext.proj.Item;
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
@SourceCodeAuthorClass(createdBy = "john.doe", updatedBy = "john.doe", versionNumber = "43", comments = "Repository for Item Master table Entity", complexity = Complexity.LOW)
public class ItemRepositoryImpl extends SearchInterfaceImpl implements ItemRepository<Item> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Item> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.testproj1boundedcontext.proj.Item> query = emanager.createQuery("select u from Item u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("PRP324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ItemRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Item save(Item entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("PRP322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ItemRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Item> save(List<Item> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.testproj1boundedcontext.proj.Item obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("PRP322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ItemRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.testproj1boundedcontext.proj.Item s = emanager.find(com.app.shared.testproj1boundedcontext.proj.Item.class, id);
        emanager.remove(s);
        Log.out.println("PRP328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ItemRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Item entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("PRP321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ItemRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Item> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.testproj1boundedcontext.proj.Item obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("PRP321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ItemRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Item findById(Integer itemid) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Item.findById");
        query.setParameter("itemid", itemid);
        com.app.shared.testproj1boundedcontext.proj.Item listOfItem = (com.app.shared.testproj1boundedcontext.proj.Item) query.getSingleResult();
        Log.out.println("PRP324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "ItemRepositoryImpl", "findById", "Total Records Fetched = " + listOfItem);
        return listOfItem;
    }
}
