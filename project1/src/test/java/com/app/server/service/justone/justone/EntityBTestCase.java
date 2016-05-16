package com.app.server.service.justone.justone;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.justone.justone.EntityBRepository;
import com.app.shared.justone.justone.EntityB;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.justone.justone.EntityA;
import com.app.server.repository.justone.justone.EntityARepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class EntityBTestCase extends EntityTestCriteria {

    @Autowired
    private EntityBRepository<EntityB> entitybRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private EntityB createEntityB(Boolean isSave) throws Exception {
        EntityA entitya = new EntityA();
        entitya.setPkOne("j99A2OCIETo153Re8phiDsIXqvwT7ivJN2ufnPfd7We6xeCh2K");
        EntityA EntityATest = new EntityA();
        if (isSave) {
            EntityATest = entityaRepository.save(entitya);
            map.put("EntityAPrimaryKey", entitya._getPrimarykey());
        }
        EntityB entityb = new EntityB();
        entityb.setTestTwo("bowwUwzkfHowbdAwIOLGstaEQybirpXJI3C2EdD5MbSfimU7D4");
        entityb.setAaPk((java.lang.String) EntityATest._getPrimarykey());
        entityb.setEntityValidator(entityValidator);
        return entityb;
    }

    @Test
    public void test1Save() {
        try {
            EntityB entityb = createEntityB(true);
            entityb.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            entityb.isValid();
            entitybRepository.save(entityb);
            map.put("EntityBPrimaryKey", entityb._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private EntityARepository<EntityA> entityaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EntityBPrimaryKey"));
            EntityB entityb = entitybRepository.findById((java.lang.String) map.get("EntityBPrimaryKey"));
            entityb.setVersionId(1);
            entityb.setTestTwo("DurCduWhkZ8nsnnoGhiMV6bL8xXxJm2JEdCKYOicUBN7npl4mR");
            entityb.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            entitybRepository.update(entityb);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("EntityBPrimaryKey"));
            entitybRepository.findById((java.lang.String) map.get("EntityBPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaaPk() {
        try {
            java.util.List<EntityB> listofaaPk = entitybRepository.findByAaPk((java.lang.String) map.get("EntityAPrimaryKey"));
            if (listofaaPk.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("EntityBPrimaryKey"));
            entitybRepository.delete((java.lang.String) map.get("EntityBPrimaryKey")); /* Deleting refrenced data */
            entityaRepository.delete((java.lang.String) map.get("EntityAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateEntityB(EntityTestCriteria contraints, EntityB entityb) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            entityb.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            entityb.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            entityb.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            entitybRepository.save(entityb);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "testTwo", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "testTwo", "qRjqKSxPFw5cPxQYW4LBWXphbYDVdlDlUBNwY339WTxJMJEK8vYpUBPsgU4b1wSPjannbLi5DstVFgOdIfqZiSDRvcAfJbRLwCZQXRF8KYS19j7llUw5c5niQnkwcN2ccpFp79DbhvgdXT4zkxyh4dbEcPwTSb1QGOzq0Lc2hePP1nHHGSKgw1BEbhEC80HTfPkgMqLCTeooYBjrxGTOMW4OuVp1a1VoEWIzRGe04O5YmyczR8hPS0rlw68sxQe0R"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                EntityB entityb = createEntityB(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = entityb.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(entityb, null);
                        validateEntityB(contraints, entityb);
                        failureCount++;
                        break;
                    case 2:
                        entityb.setTestTwo(contraints.getNegativeValue().toString());
                        validateEntityB(contraints, entityb);
                        failureCount++;
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
