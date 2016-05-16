package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("UmdUjEOtYzvUQpnJfaOjlS2EArxVZ8NlUHDDiT8R1itjWbuZN8");
        useraccesslevel.setLevelDescription("xcDvhEwfyU3mXnOPI3jN6Rr6UBucVdAZeUECz1iF8Nd4lA1q0K");
        useraccesslevel.setLevelIcon("kshBOhYOfwqfIcriqtkb5UUyr0ne4hIJZ3aKqvfy6O4XckVVDX");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("OzpGEwhZRFu1ImI6p0AEuBVgVNLPrSy7qVKOFBD8xZbfBsnu0d");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelHelp("4YVYGKNF2bC8R1DWOXeW3CTqqdqVX8HTfM6aUzMIkBDPev6eBf");
            useraccesslevel.setLevelDescription("VvQMcLmpIYYhQlsA9gvcZqRqgerS13ZlL9qkNNe0iUeeGH6jmV");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelIcon("3tJIOkxhMK8YtfKpBkNqVRCUyuRycc54ucTSysHfxXBZgLjunx");
            useraccesslevel.setUserAccessLevel(23556);
            useraccesslevel.setLevelName("r5noLHhszpMXOdsQdySrNUuls54QGjmrmXvZJUx3JOdkD1JBXT");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 108923));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "1jeVEIETHxpLBKFWemrQ9oVEokWxs6Z556dSlgcnMTyPivVtOzsi9oVm7atu1GcHfB6uD9ZlVOgN1KRycCeFNnWcZcic6mn4mHWjLgNnPiEOa7z58a1lCn82o15NPmV0RAy6AuURvrxCRsjWt23yc3pK3OPw4WWAPtaumiUTDtH47xs9VmOVCByg6Z9JwiIdMNP0iJE16CoXY0cEvsXw1pbnPC3sDqPj3mcVmaHGezJ8SPEDWcbpQwQkFaYXlZBK1"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "8NcGTURzi4BLfqQket88QQHkOeMkHFQpC3WnmBQx87FxXWvEQD8T93f9WwAgnbzERrshy4EA6cpm4mK55o1GgxD4vLLc1P6o71HYS7WBSHmgFSPuezDHO5hsYYt2pKCYZKVeqtoUL2tSxz60ngfcpRgw9UlowkldeHVbi0n4VP3oOA75oEajtLW2Mf0c3EASQWLd74B0OQv8R5tYKcpDH5tzgtqqsyispkkI3YujqPmjukExyThQMMtsMXsdJm9Oc"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "8Z3QMR9JSeLanENYVPCvd2dGi5KOeDNIT0ssxe7V2zd5UbdJAEDSb8fVKyDwVgmQTgRCBq3Dg5N5J724RcuZaG2EjofNSlGReltdag9gpehIHRnyXu3cOPNGQr3hn4UniIdcGr4XCrJYMXhc4DKfT5sUWoQda7XXAR3KB8jMbEoejvUyMfI9n08qiLOhVLUX5dHRglkDJmI6po670Vqw8gGFrxL3WaJRadHuLJuQu4ZuCpuewaOC9HsYSTkgPXe20"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
