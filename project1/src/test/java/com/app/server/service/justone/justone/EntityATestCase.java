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
import com.app.server.repository.justone.justone.EntityARepository;
import com.app.shared.justone.justone.EntityA;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class EntityATestCase extends EntityTestCriteria {

    @Autowired
    private EntityARepository<EntityA> entityaRepository;

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

    private EntityA createEntityA(Boolean isSave) throws Exception {
        EntityA entitya = new EntityA();
        entitya.setPkOne("DJqhMWOGMw5WWE0ZRNSf2DoUIxL5a93U27LlL8aQ0JbFpObWKs");
        entitya.setEntityValidator(entityValidator);
        return entitya;
    }

    @Test
    public void test1Save() {
        try {
            EntityA entitya = createEntityA(true);
            entitya.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            entitya.isValid();
            entityaRepository.save(entitya);
            map.put("EntityAPrimaryKey", entitya._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EntityAPrimaryKey"));
            EntityA entitya = entityaRepository.findById((java.lang.String) map.get("EntityAPrimaryKey"));
            entitya.setVersionId(1);
            entitya.setPkOne("CNwJ7Mi1J9dYjfwuLyHPj6xDjBUpV1llQWKYCc4waLqXvcwBX6");
            entitya.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            entityaRepository.update(entitya);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("EntityAPrimaryKey"));
            entityaRepository.findById((java.lang.String) map.get("EntityAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("EntityAPrimaryKey"));
            entityaRepository.delete((java.lang.String) map.get("EntityAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateEntityA(EntityTestCriteria contraints, EntityA entitya) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            entitya.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            entitya.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            entitya.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            entityaRepository.save(entitya);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "pkOne", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "pkOne", "Sdo0sjvzE3lTpjdEy4vGwvVmNS0TM8VxLGfSmy1boScwPTCqPJojER6k5k9u3K4o1oq9zSTvhEWqBTZXZhgzPxJOqvsO80dsFDIPc2Oke6RqKoxxT6BEf6J3D2ajrg8si1ugVnUzMikAhjaZ3dm4Zq5YSMlt2xxd3zsSjuGv6yjrkVYyQgPZkqzLv0nvtaVrzhqkmcOrhm773N7y9BUw63lxZdhX24dq6z5XjXvt5oeOUHLMlk2a0WR5ynKX7AnR2"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                EntityA entitya = createEntityA(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = entitya.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(entitya, null);
                        validateEntityA(contraints, entitya);
                        failureCount++;
                        break;
                    case 2:
                        entitya.setPkOne(contraints.getNegativeValue().toString());
                        validateEntityA(contraints, entitya);
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
